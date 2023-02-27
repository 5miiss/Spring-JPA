package spring.hibernate;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.TransactionManager;

import spring.hibernate.models.Customer;
import spring.hibernate.persistence.dao.CustomerDao;
import spring.hibernate.persistence.dao.impl.CustomerDaoTransactional;


public class App 
{
    public static void main( String[] args )
    {
        // AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // context.register(ConfigClass.class);
        // context.refresh();
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
  
        CustomerDao dao = context.getBean("customerDaoTransactional" ,CustomerDao.class);
            
       Customer cust = context.getBean("customer",Customer.class);
       dao.addCustomer(cust);
       List<Customer>customers = dao.getAllCustomers();
        customers.forEach(c->c.display());

        JpaTransactionManager tx =context.getBean(JpaTransactionManager.class);
        System.out.println(tx.getEntityManagerFactory());

        context.close();
    }

    public static void dispCustomer(Object obj){
        try {
            System.out.println(obj);
        } catch (NullPointerException e) {
            System.out.println("no such customer available");
        }

    }
}
