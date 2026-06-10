package com.prioritybroadcast.view;

import com.prioritybroadcast.MockMessagingService;
import com.prioritybroadcast.model.Customer;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Named
@ViewScoped
public class BroadcastView implements Serializable {

    List<Customer> customers;
    private String broadcastStatus = "Ready";
    private final MockMessagingService mockMessagingService;
    private boolean broadcastRunning;
    private int progress;
    private transient ExecutorService executorService;

    @PostConstruct
    public void init(){
        executorService = Executors.newSingleThreadExecutor();

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

    public String getBroadcastStatus() {
        return broadcastStatus;
    }

    public BroadcastView(MockMessagingService mockMessagingService) {
        this.mockMessagingService = mockMessagingService;
    }

    public boolean isBroadcastRunning() {
        return broadcastRunning;
    }

    public int getProgress() {
        return progress;
    }

    public void startBroadcast() {
        broadcastStatus = "Broadcast running";

        broadcastRunning = true;
        progress = 0;

        executorService.submit(() -> {
            for (Customer customer : customers) {
                customer.setStatus("Sending");

                boolean success = mockMessagingService.sendMessage(customer);

                if (success) {
                    customer.setStatus("Sent");
                } else {
                    customer.setStatus("Failed");
                }
            }

            broadcastStatus = "Broadcast finished";
            broadcastRunning = false;
        });
    }

    public void refresh() {
        long completedCount = customers.stream()
                .filter(customer -> "Sent".equals(customer.getStatus()) || "Failed".equals(customer.getStatus()))
                .count();

        progress = (int) ((completedCount * 100) / customers.size());

        if (broadcastRunning) {
            broadcastStatus = "Broadcast running: " + completedCount + " of " + customers.size() + " completed";
        }
    }

}
