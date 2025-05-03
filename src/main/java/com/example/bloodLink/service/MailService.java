package com.example.bloodLink.service;

import com.example.bloodLink.modals.DonationCamp;
import com.example.bloodLink.modals.UserEntity;

public interface MailService {

    void sendDonationCampThankYouEmail(UserEntity user, DonationCamp camp);
}
