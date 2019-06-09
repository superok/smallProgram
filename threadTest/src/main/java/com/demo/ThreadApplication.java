package com.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreadApplication {
	public static int threadCount = 0;
	
	public static void main(String[] args) {
		System.out.println("Main application start");
		Set<Integer> pendingSet = new HashSet<>(Arrays.asList(20,40,60,80,100))  ;		
		
		List<ThreadFactory> joinList = new ArrayList<>();
		for(int i=1;i<=10;i++) {
			ThreadFactory threadFactory = new ThreadFactory(i);
			threadFactory.start();

			joinList.add(threadFactory);
			
			if(pendingSet.contains(i*10)) {							
				try {
					Thread.sleep(100);
					if(pendingSet.contains(threadCount)) {
						System.out.println(threadCount +" threads were created, waiting");
						Thread.sleep(1000);
					}					
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}

		for(ThreadFactory threadFactory:joinList) {
			try {
				threadFactory.join();
			} catch (InterruptedException e) {
				System.out.println("Thread was interrupted.");
			}
		}
		
		System.out.println("Main application end");
	}

}
