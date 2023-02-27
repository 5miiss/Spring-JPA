package spring.hibernate.persistence.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import spring.hibernate.models.Customer;
import spring.hibernate.persistence.dao.CustomerDao;

public class CustomerDaoImpl implements CustomerDao {


    private EntityManager em ;



    public void setEmf(EntityManagerFactory emf) {
         em = emf.createEntityManager();
    }
    
    @Override
    public Customer getCustomerById(int id){


       Customer c = em.find(Customer.class, id);
       c.display();
       return c;
    // return null;
    }

    @Override
    public List<Customer> getAllCustomers(){

        // return hibernateTemplate.loadAll(Customer.class);
        return null;
    }

    @Override
    public void addCustomer(Customer c){

        // transactionTemplate.execute(new TransactionCallback<Object>() {

        //     @Override
        //     @Nullable
        //     public Object doInTransaction(TransactionStatus arg0) {

        //         hibernateTemplate.saveOrUpdate(c);
        //         return arg0;
        //     }
            

        // });
    }

    @Override
    public void updateCustomer(int id ,Customer c){

        // transactionTemplate.execute(new TransactionCallback<Object>() {

        //     @Override
        //     @Nullable
        //     public Object doInTransaction(TransactionStatus arg0) {

        //         hibernateTemplate.update(c);
        //         return arg0;
        //     }
            

        // });
    }

    @Override
    public void deleteCustomer(Customer c){
        // transactionTemplate.execute(new TransactionCallback<Object>() {

        //     @Override
        //     @Nullable
        //     public Object doInTransaction(TransactionStatus arg0) {

        //         hibernateTemplate.delete(c);
        //         return arg0;
        //     }
            

        // });
    }



}
