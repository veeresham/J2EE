package com.test;

import org.jboss.system.ServiceMBean;

public interface MyServiceMBean extends ServiceMBean {
	public void start();
	public void stop();
}
