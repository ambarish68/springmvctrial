package com.arao.ecom.queues;

import com.arao.ecom.interfaces.IEcomQueue;

public class PendingOrdersQueue extends IEcomQueue {

	@Override
	public boolean sendToQueue(String message) {
		// TODO Auto-generated method stub
		return false;
		
	}
	//should be scheduled
	@Override
	public boolean receiveFromQueue() {
		// TODO Auto-generated method stub
		return false;
	}

}
