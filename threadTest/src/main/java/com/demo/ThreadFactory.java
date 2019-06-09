package com.demo;

import java.util.ArrayList;
import java.util.List;

public class ThreadFactory extends Thread{
	private int threadIndex;
	
	public ThreadFactory(int i) {
		this.threadIndex = i;
	}

	public void run() {
		System.out.println("Producer Thread " + threadIndex + " start.");
		List<DemoThread> joinList = new ArrayList<>();
		for(int i=1;i<=10;i++) {			
			DemoThread demoThread = new DemoThread(i+(threadIndex-1)*10);
			demoThread.start();	
			ThreadApplication.threadCount ++;
			if(ThreadApplication.threadCount >= 100) {
				System.out.println("Completing create 100 Threads ===========");		
			}
			joinList.add(demoThread);					
		}	
		for(DemoThread demoThread:joinList) {
			try {
				demoThread.join();
			} catch (InterruptedException e) {
				System.out.println("Thread was interrupted.");
			}
		}
		
		System.out.println("Producer Thread " + threadIndex + " end.");
	}

}
