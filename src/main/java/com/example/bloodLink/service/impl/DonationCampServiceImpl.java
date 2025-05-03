package com.example.bloodLink.service.impl;

import com.example.bloodLink.modals.BloodBankCenter;
import com.example.bloodLink.modals.DonationCamp;
import com.example.bloodLink.modals.UserEntity;
import com.example.bloodLink.repository.DonationCampRepo;
import com.example.bloodLink.service.DonationCampService;
import com.example.bloodLink.service.MailService;
import com.example.bloodLink.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DonationCampServiceImpl implements DonationCampService {

    @Autowired
    private DonationCampRepo donationCampRepo;

    @Autowired
    private UserService userService;


    @Autowired
    private MailService mailService;

    // method for requesting donation camp
    @Override
    public DonationCamp reqDonationCamp(DonationCamp camp) {

        return donationCampRepo.save(camp);
    }

    // returns the donation camps that the blood bank center has requested
    @Override
    public List<DonationCamp> findByIsApprovedFalseAndBloodBankCenter(BloodBankCenter bloodBankCenter) {
        return donationCampRepo.findByIsApprovedFalseAndBloodBankCenter(bloodBankCenter)
                .orElseThrow(()->new RuntimeException("NO DONATION-CAMP REQUESTED"));
    }

    @Override
    public List<DonationCamp> findByIsActiveTrueAndBloodBankCenter(BloodBankCenter bloodBankCenter) {
        return donationCampRepo.findByIsActiveTrueAndBloodBankCenter(bloodBankCenter)
                .orElseThrow(()->new RuntimeException("NO ACTIVE DONATION CAMPS"));
    }

    // register donor to a donation_camp
    @Override
    public String registerForDonationCamp(String donorEmail, Long campId) {

        // Fetch the DonationCamp from the database
        DonationCamp donationCamp = donationCampRepo.findById(campId)
                .orElseThrow(() -> new EntityNotFoundException("DONATION CAMP NOT FOUND"));

        // Fetch the UserEntity (Donor) by email
        UserEntity donor = userService.getUserByEmail(donorEmail);

        // Check if the donor is eligible to donate
        if (!(donor.isEligibleToDonate())) {
            throw new RuntimeException("DONOR IS NOT ELIGIBLE TO DONATE ." );
        }

        // Check if there are available slots in the donation camp
        if (donationCamp.getSlotsLeft() <= 0) {
            throw new RuntimeException("NO SLOTS LEFT IN THIS DONATION CAMP");
        }

        // Register the donor by adding them to the camp's list of registered donors
        donationCamp.getRegisteredDonors().add(donor);

        // Update the donor's registered camps
        donor.getRegisteredCamps().add(donationCamp);



        // Update the available slots and booked slots for the camp
        donationCamp.setSlotsLeft(donationCamp.getSlotsLeft() - 1);
        donationCamp.setSlotsBooked(donationCamp.getSlotsBooked() + 1);


        // Update donor status and dates
        donor.setEligibleToDonate(false);
        donor.setLastDonatedDate(LocalDate.now());
        donor.setNextDonationDate(LocalDate.now().plusMonths(3));



        // Save the updated camp and donor details to the database
        donationCampRepo.save(donationCamp);
        userService.save(donor);

        // send email notification to user(donor) for donating blood .
        mailService.sendDonationCampThankYouEmail(donor,donationCamp);

        // Return a success message
        return "Donor successfully registered for the donation camp!";
    }



    // getting list of donation camp that are not yet approved by the super admin
    @Override
    public List<DonationCamp> findByIsApprovedFalse() {
        return donationCampRepo.findByIsApprovedFalse();
    }


    // approving the donation camp (done by super admin)
    @Override
    public DonationCamp approveDonationCamp(Long campId) {
        DonationCamp donationCamp = donationCampRepo.findById(campId)
                .orElseThrow(()->new RuntimeException("DONATION CAMP NOT FOUND"));
        // approving the donation camp
        if (donationCamp.isApproved()){
            throw  new RuntimeException("DONATION CAMP ALREADY APPROVED");
        }
        donationCamp.setApproved(true);
        donationCamp.setActive(true);
        //persisting the changes in the DB
       return donationCampRepo.save(donationCamp);
    }

    // getting list of donation camps that are approved by the admin
    @Override
    public List<DonationCamp> findByIsApprovedTrue() {

        return donationCampRepo.findByIsApprovedTrue();

    }

    // getting list of donation camps that are currently active (by the admin)
    @Override
    public List<DonationCamp> findByIsActiveTrue() {
        return donationCampRepo.findByIsActiveTrue();
    }

}
