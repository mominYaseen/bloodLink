package com.example.bloodLink.service.impl;

import com.example.bloodLink.modals.DonationCamp;
import com.example.bloodLink.modals.UserEntity;
import com.example.bloodLink.service.MailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender mailSender;




    public void sendDonationCampThankYouEmail(UserEntity user, DonationCamp camp) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(user.getEmail());
            helper.setSubject("🩸 Thank You for Donating Blood at Our Camp!");
            helper.setFrom("moominyaseen786@gmail.com"); // TODO --  use bloodlink email here , so that this email message wont get into spam folder

            String body = String.format(
                    "Dear %s %s,\n\n" +
                            "Thank you for being a lifesaver!\n\n" +
                            "We sincerely appreciate your generous blood donation during the donation camp held at %s on %s. Your contribution is vital in helping those in urgent need of blood and saving lives.\n\n" +
                            "Donation Details:\n" +
                            "- Donor Name: %s %s\n" +
                            "- Blood Group: %s\n" +
                            "- Camp Name: %s\n" +
                            "- Camp Location: %s\n" +
                            "- Date of Donation: %s\n\n" +
                            "Please remember, you will be eligible to donate again after %s.\n\n" +
                            "If you have any questions or feedback, feel free to contact us.\n\n" +
                            "Warm regards,\n" +
                            "BloodLink Team\n" +
                            "noreply@bloodlink.org\n" +
                            "www.bloodlink.org",
                    user.getFirstName(), user.getLastName(),
                    camp.getCampName(), camp.getCampDate().toString(),
                    user.getFirstName(), user.getLastName(),
                    user.getBloodGroup(),
                    camp.getCampName(),
                    camp.getAddress(),
                    camp.getCampDate().toString(),
                    user.getNextDonationDate().toString()
            );

            helper.setText(body, false); // false = plain text

            mailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException("Failed to send email: " + e.getMessage());
        }
    }

}
