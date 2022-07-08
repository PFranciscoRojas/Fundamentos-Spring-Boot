package com.fundamentos.springboot.Fundamentos;

import com.fundamentos.springboot.Fundamentos.bean.MyBean;
import com.fundamentos.springboot.Fundamentos.bean.MyBeanWithDependency;
import com.fundamentos.springboot.Fundamentos.bean.MyBeanWithProperties;
import com.fundamentos.springboot.Fundamentos.component.ComponentDependency;
import com.fundamentos.springboot.Fundamentos.entity.User;
import com.fundamentos.springboot.Fundamentos.pojo.UserPojo;
import com.fundamentos.springboot.Fundamentos.repository.UserRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

    private final Log LOGGER = LogFactory.getLog(FundamentosApplication.class);
    private ComponentDependency componentDependency;
    private MyBean myBean;
    private MyBeanWithDependency myBeanWithDependency;

    private MyBeanWithProperties myBeanWithProperties;
    private UserPojo userPojo;

    private UserRepository userRepository;

    public FundamentosApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency,
                                  MyBean myBean, MyBeanWithDependency myBeanWithDependency,
                                  MyBeanWithProperties myBeanWithProperties, UserPojo userPojo,UserRepository userRepository) {
        this.componentDependency = componentDependency;
        this.myBean = myBean;
        this.myBeanWithDependency = myBeanWithDependency;
        this.myBeanWithProperties = myBeanWithProperties;
        this.userPojo = userPojo;
        this.userRepository = userRepository;

    }

    public static void main(String[] args) {
        SpringApplication.run(FundamentosApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
      // ejemplosAnteriores();
        saveUsersInDatabase();
        getInformationJpqlFromEmail();
    }

    private void getInformationJpqlFromEmail(){
        LOGGER.info("User with method findByUserEmail: "+
                userRepository.findByUserEmail("francisco@mail.com").
                orElseThrow(()->new RuntimeException("Email doesn't exist")));
        userRepository.findAndSort("user", Sort.by("id").descending())
        .forEach(user->LOGGER.info("User with method sort: "+user));
    }

    private void saveUsersInDatabase(){
        User user1 = new User("Francisco","francisco@mail.com", LocalDate.of(1992,4,23));
        User user2 = new User("Marcela","march@mail.com", LocalDate.of(1994,10,22));
        User user3 = new User("Daniela","Daniela@mail.com", LocalDate.of(1903,3,23));
        User user4 = new User("user4","user4@mail.com", LocalDate.of(1904,4,24));
        User user5 = new User("user5","user5@mail.com", LocalDate.of(1905,5,25));
        User user6 = new User("user6","user6@mail.com", LocalDate.of(1906,6,26));
        User user7 = new User("user7","user7@mail.com", LocalDate.of(1907,7,27));
        User user8 = new User("user8","user8@mail.com", LocalDate.of(1908,8,28));
        User user9 = new User("user9","user9@mail.com", LocalDate.of(1909,9,29));
        User user10 = new User("user10","user10@mail.com", LocalDate.of(1910,10,30));

        List<User> list = Arrays.asList(user1,user2,user3,user4,user5,user6,user7,user8,user9,user10);
        list.forEach(userRepository::save);

    }

    private void ejemplosAnteriores(){
        componentDependency.saludar();
        myBean.print();
        myBeanWithDependency.printWithDependency();
        System.out.println(myBeanWithProperties.function());
        System.out.println(userPojo.getEmail() + " - " + userPojo.getAge());
        try {
            int value = 10/0;
            LOGGER.debug("value is "+value);

        } catch (Exception e) {
            LOGGER.error("This is a Error by 0: "+ e.getStackTrace());
        }
    }

}
