package spring.hibernate.models;


import java.sql.Timestamp;

import jakarta.persistence.*;

@Entity
@Table(name ="info")
public class Customer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String FirstName;
    private String LastName;
    private String Mobile;
    private Timestamp lastOrdered;


    public Customer() {
    }

    public Customer( String FirstName, String LastName, String Mobile) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Mobile = Mobile;
    }

    public Customer(int id, String FirstName, String LastName, String Mobile) {
        this.id = id;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Mobile = Mobile;
    }

    public Customer( String FirstName, String LastName, String Mobile ,Timestamp lastOrdered) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Mobile = Mobile;
        this.lastOrdered = lastOrdered;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return this.LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getMobile() {
        return this.Mobile;
    }

    public void setMobile(String Mobile) {
        this.Mobile = Mobile;
    }


    public Timestamp getLastOrdered() {
        return this.lastOrdered;
    }

    public void setLastOrdered(Timestamp lastOrdered) {
        this.lastOrdered = lastOrdered;
    }

    public void display(){
        System.out.println("==============================================");
        System.out.println("the id for the customer is : " + id
                           +"\nthe first name for the customer is : " + FirstName
                           +"\nthe lastname for the customer is : " + LastName
                           +"\nthe mobile for the customer is : " + Mobile
                           +"\nthe Last Ordered date is : " + lastOrdered
                           );
                           System.out.println("==============================================\n\n");

    }

}
