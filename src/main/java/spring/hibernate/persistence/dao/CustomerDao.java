package spring.hibernate.persistence.dao;

import java.util.List;



import spring.hibernate.models.Customer;

public interface  CustomerDao {
    

    public Customer getCustomerById(int id);
    public List<Customer> getAllCustomers();
    public void addCustomer(Customer c);
    public void updateCustomer(int id ,Customer c);
    public void deleteCustomer(Customer c);

}
