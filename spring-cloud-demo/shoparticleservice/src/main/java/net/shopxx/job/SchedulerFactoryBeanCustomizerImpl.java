package net.shopxx.job;

import java.util.Properties;

import org.springframework.boot.autoconfigure.quartz.SchedulerFactoryBeanCustomizer;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
public class SchedulerFactoryBeanCustomizerImpl implements SchedulerFactoryBeanCustomizer {

	@Override
	public void customize(SchedulerFactoryBean schedulerFactoryBean) {
		Properties ps = new Properties();
		ps.setProperty("org.quartz.jobStore.isClustered", "true");
		schedulerFactoryBean.setQuartzProperties(ps);
	}

}
