package com.example.bloodLink.schedular;

import com.example.bloodLink.modals.BloodInventory;
import com.example.bloodLink.service.BloodInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BloodRequestToDonor {

    @Autowired
    private BloodInventoryService bloodInventoryService;

    

    @Scheduled(cron = "0 0 0 * * ?") // Runs every day at 12:00 AM
    public void sendNotificationToDonors()
    {

    }


}
