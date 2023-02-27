// package spring.hibernate.config;

// import java.sql.Timestamp;
// import java.time.LocalDateTime;
// import java.util.Properties;

// import javax.sql.DataSource;

// import org.hibernate.jpa.HibernatePersistenceProvider;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.ComponentScan;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.context.annotation.PropertySource;
// import org.springframework.core.env.Environment;
// import org.springframework.jdbc.datasource.DriverManagerDataSource;

// import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;


// import jakarta.persistence.EntityManagerFactory;
// import jakarta.persistence.spi.PersistenceProvider;
// import spring.hibernate.persistence.dao.CustomerDao;
// import spring.hibernate.persistence.dao.impl.CustomerDaoImpl;
// import spring.hibernate.models.*;


// @Configuration
// @PropertySource("datasource.properties")
// @ComponentScan("spring.hibernate")
// public class ConfigClass {
    
//     @Bean
//     public DataSource  dataSource(@Value("${jdbc.driverClassName}") String drivverclassName , @Value("${jdbc.url}")String url ,
//                                     @Value("${jdbc.username}") String username ,@Value("${jdbc.password}") String Password){
//         DriverManagerDataSource datasource = new DriverManagerDataSource(url, username, Password);
//         datasource.setDriverClassName(drivverclassName);
//         return datasource;
//     }

//     @Bean PersistenceProvider getp(){
//         return new HibernatePersistenceProvider();
//     }


//     @Bean
//     public LocalContainerEntityManagerFactoryBean emFactory(DataSource  dataSource ,PersistenceProvider pp , Environment env){

//         LocalContainerEntityManagerFactoryBean emf=new LocalContainerEntityManagerFactoryBean();
//         emf.setDataSource(dataSource);
//         emf.setPackagesToScan("spring.hibernate.models");
//         emf.setPersistenceProvider(pp);
//         Properties props =new Properties() ;
//         props.put("hibernate.dialect",env.getRequiredProperty("hibernate.dialect")); 
//         props.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
//         props.put("hibernate.format_sql", env.getRequiredProperty("hibernate.format_sql"));
//         props.put("hibernate.hbm2ddl.auto", env.getRequiredProperty("hibernate.hbm2ddl.auto"));
//         emf.setJpaProperties(props);
//         return emf;
//     }

//     @Bean
//     public CustomerDao customerDao(EntityManagerFactory emf){
//         CustomerDaoImpl c = new CustomerDaoImpl();
//         c.setEmf(emf);
//         return c;
//     }



//     @Bean
//     public Customer customer( @Value("by session ") String FirstName,@Value("customer ") String LastName
//                                 ,@Value("01351654654 ") String Mobile ){

//         Timestamp ts =Timestamp.valueOf(LocalDateTime.now());
//         return new Customer( FirstName, LastName, Mobile,ts);
//     }

// }
