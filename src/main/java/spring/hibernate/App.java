package spring.hibernate;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.hibernate.config.ConfigClass;
import spring.hibernate.models.Customer;
import spring.hibernate.persistence.dao.CustomerDao;
import spring.hibernate.persistence.dao.impl.CustomerDaoSession;


public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ConfigClass.class);
        context.refresh();
        // ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
  
        System.out.println(context.getBean("customerDao" ,CustomerDao.class).getCustomerById(1));
        
        context.close();
    }
}
