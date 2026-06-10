package com.prioritybroadcast.view;

import com.prioritybroadcast.model.Customer;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class BroadcastView implements Serializable {

    List<Customer> customers;

    @PostConstruct
    public void init(){
        customers = new ArrayList<>();

        customers.add(new Customer("Bagas Andrian", "08123456781", "Pending"));
        customers.add(new Customer("Bagas Andrian 2", "08123456782", "Pending"));
        customers.add(new Customer("Bagas Andrian 3", "08123456783", "Pending"));
        customers.add(new Customer("Bagas Andrian 4", "08123456784", "Pending"));
        customers.add(new Customer("Bagas Andrian 5", "08123456785", "Pending"));
        customers.add(new Customer("Bagas Andrian 6", "08123456786", "Pending"));
        customers.add(new Customer("Bagas Andrian 7", "08123456787", "Pending"));
        customers.add(new Customer("Bagas Andrian 8", "08123456788", "Pending"));
        customers.add(new Customer("Bagas Andrian 9", "08123456789", "Pending"));
        customers.add(new Customer("Bagas Andrian 10", "081234567810", "Pending"));
    }

    public List<Customer> getCustomers() {
        return customers;
    }

}
