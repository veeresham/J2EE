package com.test;

import java.util.HashMap;
import java.util.Map;

import org.jboss.system.ServiceMBeanSupport;

public class MyService extends ServiceMBeanSupport implements MyServiceMBean {

	private Map<String, String> hashMap = new HashMap<String, String>();
	private boolean running = false;

	public void start() {
		System.out.println("Started...");
		running = true;
		while (running) {
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Adding an entry");
			hashMap.put(System.currentTimeMillis() + "",
					System.currentTimeMillis() + "");
		}
		System.out.println("Stopped");
	}

	public void stop() {
		System.out.println("Stopped");
		running = false;
	}

}
