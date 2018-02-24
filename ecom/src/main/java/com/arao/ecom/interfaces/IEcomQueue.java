package com.arao.ecom.interfaces;

public abstract class IEcomQueue {
	public static String queueName;
	
	public abstract boolean sendToQueue(String message);
	
	public abstract boolean receiveFromQueue();
}
