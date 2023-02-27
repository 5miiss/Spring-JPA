package spring.hibernate.persistence.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import spring.hibernate.models.Customer;
import spring.hibernate.persistence.dao.CustomerDao;


public class CustomerDaoSession implements CustomerDao{
    
    private Session session ;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.session = sessionFactory.openSession();
    }


    @Override
    @Transactional
    public Customer getCustomerById(int id) {

        // Session session = sessionFactory.openSession();
        return session.get(Customer.class, id);
    }

    @Override
    @Transactional
    public List<Customer> getAllCustomers() {

        return session.createQuery("from Customer").list();

    }

    @Override
    @Transactional
    public void addCustomer(Customer c) {

        session.save(c);
    }

    @Override
    @Transactional

    public void updateCustomer(int id ,Customer c) {

        Customer editedCustomer = session.get(Customer.class, id);
        if(editedCustomer != null){
            editedCustomer.setFirstName(c.getFirstName());
            editedCustomer.setLastName(c.getLastName());
            editedCustomer.setMobile(c.getMobile());
            session.update(editedCustomer);
        }
    }

    @Override
    @Transactional
    public void deleteCustomer(Customer c) {

        if(session.load(Customer.class, c.getId()) != null)
            session.delete(c);
    }

}