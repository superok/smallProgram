package com.demo;

public class DemoThread extends Thread {
	private int threadIndex;

	public DemoThread(int i) {
		threadIndex = i;
	}

	public void run() {
		System.out.println(threadIndex + " thread start" );
		for(int i =1;i<50000;i++) {}
		while(ThreadApplication.threadCount < 100) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(threadIndex+ " thread end" );
	}
}
