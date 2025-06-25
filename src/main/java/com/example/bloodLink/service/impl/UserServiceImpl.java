package com.example.bloodLink.service.impl;

import com.example.bloodLink.dto.EligibilityFormDTO;
import com.example.bloodLink.dto.UserDto;
import com.example.bloodLink.modals.DonationCamp;
import com.example.bloodLink.modals.UserEntity;
import com.example.bloodLink.repository.UserRepo;
import com.example.bloodLink.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepo userRepo;

  @Override
  public UserEntity getUserByEmail(String email) {
    return userRepo.findUserByEmail(email);
  }

  @Override
  public boolean checkIfEligible(EligibilityFormDTO form) {

    if (!form.isFeelingWell() || form.isRecentDonation() ||
        form.isTakingMedication() || form.isHasChronicIllness() ||
        form.isHasInfection() || form.isCovidRecently() || form.isMalariaTravel() ||
        form.isHasTattoo() || form.isTestedPositiveHIV() || form.isPregnant() ||
        form.getWeight() <= 40) {
      return false;
    } else {
      return true;
    }

  }

  // used for saving the userEntity at the time of registering
  @Override
  public UserEntity saveUserToDb(UserDto user) {

    UserEntity userEntity = new UserEntity();
    userEntity.setFirstName(user.getFirstName());
    userEntity.setLastName(user.getLastName());
    userEntity.setEmail(user.getEmail());
    userEntity.setPhoneNumber(user.getPhoneNumber());
    userEntity.setGender(user.getGender());
    userEntity.setAge(user.getAge());
    userEntity.setBloodGroup(user.getBloodGroup());
    userEntity.setAddress(user.getAddress());
    userEntity.setCity(user.getCity());
    userEntity.setState(user.getState());
    userEntity.setCountry(user.getCountry());
    userEntity.setLatitude(user.getLatitude());
    userEntity.setLongitude(user.getLongitude());
    userEntity.setLastDonatedDate(user.getLastDonationDate());
    if (user.getLastDonationDate() != null) {
      //LocalDate.now().plusMonths(3)
      userEntity.setNextDonationDate(user.getLastDonationDate().plusMonths(3));

    }
    return userRepo.save(userEntity);
  }

  // used in schedular class
  @Override
  public UserEntity save(UserEntity user) {
    return userRepo.save(user);
  }

  @Override
  public List<UserEntity> getAllUser() {
    return userRepo.findAll();
  }

  @Override
  public List<DonationCamp> donationCampHistory(String email) {
    return userRepo.findUserByEmail(email).getRegisteredCamps();

  }

  @Override
  public List<UserEntity> findByBloodGroupAndEligibleToDonateTrue(String bloodGroup) {
    return userRepo.findByBloodGroupAndEligibleToDonateTrue(bloodGroup);
  }

}
