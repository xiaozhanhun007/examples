package demo.zzp.app.aop.aspect;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.com.rlid.utils.json.JsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import demo.zzp.app.redis.JedisUtils;

/**
 * 防止重复提交操作AOP类
 * @author karyzeng 2018.03.10
 * @version 1.0
 */
@Aspect
@Component
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class PreventRepetitionAspect {
	
	@Autowired
	private JedisUtils jedisUtils;

	private static final String PARAM_TOKEN = "token";
    private static final String PARAM_TOKEN_FLAG = "tokenFlag";
    
    /**
	 * around
	 * @throws Throwable 
	 */
	@Around(value = "@annotation(demo.zzp.app.aop.annotation.PreventRepetitionAnnotation)")
	public Object excute(ProceedingJoinPoint joinPoint) throws Throwable{
		try {
			Object result = null;
			Object[] args = joinPoint.getArgs();
			for(int i = 0;i < args.length;i++){
				if(args[i] != null && args[i] instanceof HttpServletRequest){
					HttpServletRequest request = (HttpServletRequest) args[i];
					HttpSession session = request.getSession();
					if(request.getMethod().equalsIgnoreCase("get")){
						//方法为get
						result = generate(joinPoint, request, session, PARAM_TOKEN_FLAG);
					}else{
						//方法为post
						result = validation(joinPoint, request, session, PARAM_TOKEN_FLAG);
					}
				}
			}
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("执行防止重复提交功能AOP失败，原因：" + e.getMessage());
			return "操作失败！"+ "执行防止重复提交功能AOP失败，原因：" + e.getMessage();
		//	return JsonBuilder.toJson(false, "操作失败！", "执行防止重复提交功能AOP失败，原因：" + e.getMessage());
		}
	}
	
	public Object generate(ProceedingJoinPoint joinPoint, HttpServletRequest request, HttpSession session,String tokenFlag) throws Throwable {
        String uuid = UUID.randomUUID().toString();
        request.setAttribute(PARAM_TOKEN, uuid);
        return joinPoint.proceed();
    } 
	
	public Object validation(ProceedingJoinPoint joinPoint, HttpServletRequest request, HttpSession session,String tokenFlag) throws Throwable {
		String requestFlag = request.getParameter(PARAM_TOKEN);
		//redis加锁
		boolean lock = jedisUtils.tryGetDistributedLock(tokenFlag + requestFlag, requestFlag, 60000);
		System.out.println("lock:" + lock + "," + Thread.currentThread().getName());
		if(lock){
			//加锁成功
			//执行方法
			Object funcResult = joinPoint.proceed();
			//方法执行完之后进行解锁
			jedisUtils.releaseDistributedLock(tokenFlag + requestFlag, requestFlag);
			return funcResult;
		}else{
			//锁已存在
			return JsonBuilder.toJson(false, "不能重复提交！", null);
		}
    }
	
}
