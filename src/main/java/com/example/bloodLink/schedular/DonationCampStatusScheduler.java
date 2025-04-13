package com.example.bloodLink.schedular;

import com.example.bloodLink.modals.DonationCamp;
import com.example.bloodLink.repository.DonationCampRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class DonationCampStatusScheduler {

    @Autowired
    private DonationCampRepo donationCampRepo;


    @Scheduled(cron = "0 0 0 * * ?") // runs at 12:00 AM every day
    public void updateCampStatus() {
        List<DonationCamp> allCamps = donationCampRepo.findAll();
        for (DonationCamp camp : allCamps) {
            if (camp.getCampDate().isBefore(LocalDate.now()) && camp.isActive() && camp.isApproved()) {
                camp.setActive(false);
                donationCampRepo.save(camp);
            }
        }
    }


}
