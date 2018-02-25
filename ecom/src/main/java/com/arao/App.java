package com.arao;

import java.util.ArrayList;
import org.hibernate.classic.Session;
import com.arao.common.user.User;
import com.arao.ecom.exception.BusinessLogicException;
import com.arao.ecom.repositories.UserRepository;
import com.arao.persistence.HibernateUtil;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
public class App 
{
	public static void main( String[] args )
    {
		
		
        System.out.println("Maven + Hibernate + MySQL");
        Session session = HibernateUtil.getSessionFactory().openSession();
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
        
        
        UserRepository urep=new UserRepository();
        User usr=new User();
        usr.setEmailId("aaaba@gmail.com");
        usr.setName("araoaraob");
        usr.setPassword("araoabrao");
        
        ArrayList<User> uList=new ArrayList<User>();
        uList.add(usr);
        try {
			urep.add(uList);
		} catch (BusinessLogicException e) {
			e.printStackTrace();
		}
    }
}
