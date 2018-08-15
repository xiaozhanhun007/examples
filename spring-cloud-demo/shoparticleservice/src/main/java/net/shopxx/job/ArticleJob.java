package net.shopxx.job;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.QuartzJobBean;

@Configuration
public class ArticleJob extends QuartzJobBean {

	private String name;

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		System.out.println(String.format("Hello from A %s!", this.name));
	}

	@Bean
	public JobDetail articleJobDetail() {
		return JobBuilder.newJob(ArticleJob.class).withIdentity("articleJob")
				.usingJobData("name", "World").storeDurably().build();
	}

	@Bean
	public Trigger articleTrigger() {
		SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
				.withIntervalInSeconds(3).repeatForever();

		return TriggerBuilder.newTrigger().forJob(articleJobDetail())
				.withIdentity("articleTrigger").withSchedule(scheduleBuilder).build();
	}
}
