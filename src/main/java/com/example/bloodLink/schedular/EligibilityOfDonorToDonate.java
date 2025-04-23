package com.example.bloodLink.schedular;

import com.example.bloodLink.modals.UserEntity;
import com.example.bloodLink.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class EligibilityOfDonorToDonate {

    @Autowired
    private UserService userService;

    @Scheduled(cron = "0 0 0 * * ?") // Runs every day at 12:00 AM
    public void updateUserDonateStatus() {
        List<UserEntity> allUsers = userService.getAllUser();

        for (UserEntity user : allUsers) {
            LocalDate nextDonationDate = user.getNextDonationDate();

            if (nextDonationDate != null &&
                    nextDonationDate.isBefore(LocalDate.now()) &&
                    !user.isEligibleToDonate()) {

                user.setEligibleToDonate(true);
                user.setLastDonatedDate(nextDonationDate);
                user.setNextDonationDate(null);
                userService.save(user);
            }
        }
    }
}
