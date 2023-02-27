package spring.hibernate.persistence.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import spring.hibernate.models.Customer;
import spring.hibernate.persistence.dao.CustomerDao;

// @Repository
public class CustomerDaoTransactional implements CustomerDao{
    

    @PersistenceContext
    private EntityManager em;


    @Override
    // @Transactional
    public Customer getCustomerById(int id) {

        // Session session = sessionFactory.openSession();
        try {
            return em.find(Customer.class, id);

        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

    @Override
    // @Transactional
    public List<Customer> getAllCustomers() {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
        Root<Customer> rootEntry = cq.from(Customer.class);
        CriteriaQuery<Customer> all = cq.select(rootEntry);
        TypedQuery<Customer> allQuery = em.createQuery(all);
        return allQuery.getResultList();
    }

    @Override
    @Transactional
    public void addCustomer(Customer c) {
        System.out.println("zzzzzzzzzzzzzzzzzzzzzz");
        // em.getTransaction().begin();
        em.persist(c);
        // em.getTransaction().commit();

        System.out.println(em.contains(c));

    }

    @Override
    @Transactional

    public void updateCustomer(int id ,Customer c) {

        // Customer editedCustomer = session.get(Customer.class, id);
        // if(editedCustomer != null){
        //     editedCustomer.setFirstName(c.getFirstName());
        //     editedCustomer.setLastName(c.getLastName());
        //     editedCustomer.setMobile(c.getMobile());
        //     session.update(editedCustomer);
        // }
    }

    @Override
    @Transactional
    public void deleteCustomer(Customer c) {

    //     if(session.load(Customer.class, c.getId()) != null)
    //         session.delete(c);
    // 

    }
}