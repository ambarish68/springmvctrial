package com.arao.ecom.sqsclient;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;

public class AWSQueueClient {
	
	public AWSQueueClient(){
		ProfileCredentialsProvider credentialsProvider = null;
		try {
			credentialsProvider = new ProfileCredentialsProvider("svc-ecom");
		} catch (Exception e) {
			throw new AmazonClientException("Cannot load the credentials from the credential profiles file. "
					+ "Please make sure that your credentials file is at the correct "
					+ "location (~/.aws/credentials), and is in valid format.", e);
		}

		AmazonSQS sqs = AmazonSQSClientBuilder
				.standard()
				.withCredentials(credentialsProvider)
				.withRegion(Regions.US_EAST_2)
				.build();
	}
	
	

}
