package com.example.bloodLink.schedular;

import com.example.bloodLink.modals.BloodInventory;
import com.example.bloodLink.modals.UserEntity;
import com.example.bloodLink.service.BloodInventoryService;
import com.example.bloodLink.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class BloodRequestToDonor {

    @Autowired
    private BloodInventoryService bloodInventoryService;

    @Autowired
    private UserService userService;
    

    @Scheduled(fixedRate = 2000) // Runs every day at 12:00 AM
    public void sendNotificationToDonors()
    {
        List<BloodInventory> lowInventoryByBloodBankCenter = bloodInventoryService.findLowInventoryByBloodBankCenter();
        if (!(lowInventoryByBloodBankCenter.isEmpty())){
            for (BloodInventory bloodInventory : lowInventoryByBloodBankCenter){
                if (bloodInventory.getAvailableUnits() <= bloodInventory.getMinimumUnits()){
                    if (bloodInventory.getLastNotifiedAt() == null ||
                        bloodInventory.getLastUpdated().isAfter(bloodInventory.getLastNotifiedAt()))
                    {
                        List<UserEntity> donorList = userService.findByBloodGroupAndEligibleToDonateTrue(bloodInventory.getBloodGroup());
                        for (UserEntity user : donorList){
                            System.out.println("First name : " + user.getFirstName() + " and Blood Group : " + user.getBloodGroup() );

                        }
                        bloodInventory.setLastNotifiedAt(LocalDateTime.now());
                        bloodInventoryService.saveBloodInventory(bloodInventory);
                    }
                }
            }
        }

    }


}
