package com.arao;

import org.hibernate.classic.Session;

import com.arao.common.user.User;
import com.arao.persistence.HibernateUtil;



import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args )
    {
		
		
        System.out.println("Maven + Hibernate + MySQL");
        Session session = HibernateUtil.getSessionFactory().openSession();

//		AWSCredentials credentials = null;
//		try {
//			credentials = new ProfileCredentialsProvider("svc-ecom").getCredentials();
//		} catch (Exception e) {
//			throw new AmazonClientException("Cannot load the credentials from the credential profiles file. "
//					+ "Please make sure that your credentials file is at the correct "
//					+ "location (~/.aws/credentials), and is in valid format.", e);
//		}

		AmazonSQS sqs = AmazonSQSClientBuilder.standard().withCredentials(new ProfileCredentialsProvider("svc-ecom")).withRegion(Regions.US_EAST_2).build();
		
		System.out.println("Listing all queues in your account.\n");
		for (String queueUrl : sqs.listQueues().getQueueUrls()) {
		    System.out.println("  QueueUrl: " + queueUrl);
		}
		System.out.println();
		
        System.out.println("===========================================");
        System.out.println("Getting Started with Amazon SQS");
        System.out.println("===========================================\n");
        
        session.beginTransaction();
        User user =  (User) session.get(User.class, 4);
        user.setPassword("passwork");
        session.getTransaction().commit();
    }
}
