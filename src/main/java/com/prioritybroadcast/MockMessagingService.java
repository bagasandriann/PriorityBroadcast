package com.prioritybroadcast;

import com.prioritybroadcast.model.Customer;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class MockMessagingService {

    private void simmulateNetworkDelay(){
        int delay = ThreadLocalRandom.current().nextInt(1000, 2001);

        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private boolean isSuccessful(){
        int ranNumber = ThreadLocalRandom.current().nextInt(100);
        return  ranNumber >= 10;
    }

    public boolean sendMessage(Customer customer) {
        if (customer.getPhoneNumber() == null || customer.getPhoneNumber().isBlank()) {
            return false;
        }
        simmulateNetworkDelay();
        return isSuccessful();
    }
}
