package com.example.bloodLink.service.impl;

import com.example.bloodLink.dto.BloodBankCenterRegistrationRequestDTO;
import com.example.bloodLink.modals.BloodBankCenter;
import com.example.bloodLink.modals.BloodInventory;
import com.example.bloodLink.modals.SubAdmin;
import com.example.bloodLink.repository.BloodBankCenterRepo;
import com.example.bloodLink.repository.SubAdminRepo;
import com.example.bloodLink.service.BloodBankCenterService;
import com.example.bloodLink.service.CommonDataService;
import com.example.bloodLink.service.SubAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BloodBankCenterServiceImpl implements BloodBankCenterService {


    @Autowired
    private BloodBankCenterRepo bloodBankCenterRepo;

    @Autowired
    private SubAdminService subAdminService;

    @Autowired
    private SubAdminRepo subAdminRepo;

    @Override
    public BloodBankCenter addBloodBankCenterToDb(BloodBankCenterRegistrationRequestDTO dto , String email) {


        SubAdmin subAdmin = subAdminService.findByEmail(email);


        if (subAdmin.getBloodBankCenter() != null) {
            throw new IllegalStateException("SubAdmin already has a center");
        }

        BloodBankCenter center = new BloodBankCenter();
        center.setName(dto.getName());
        center.setAddress(dto.getAddress());
        center.setCity(dto.getCity());
        center.setEmail(dto.getEmail());
        center.setContactNumber(dto.getContactNumber());
        center.setLatitude(dto.getLatitude());
        center.setLongitude(dto.getLongitude());
        center.setState(dto.getState());
        center.setCountry(dto.getCountry());
        center.setCenterEstablishedTime(dto.getCenterEstablishedTime());
        center.setSubAdmin(subAdmin);
        subAdmin.setBloodBankCenter(center);

        List<BloodInventory> inventories = dto.getBloodInventories().stream().map(inv -> {
            BloodInventory b = new BloodInventory();
            b.setBloodGroup(inv.getBloodGroup());
            b.setAvailableUnits(inv.getAvailableUnits());
            b.setMinimumUnits(inv.getMinimumUnits());
            b.setLastUpdated(LocalDateTime.now());
            b.setBloodBankCenter(center);
            return b;
        }).toList();
        center.setBloodInventories(inventories);
        bloodBankCenterRepo.save(center);
//        subAdminRepo.save(subAdmin);
        return center;
    }

    @Override
    public List<BloodBankCenter> getAllBloodCenters() {
    
    List<BloodBankCenter> result = bloodBankCenterRepo.findAll();
        return result;
    }

    @Override
    public BloodBankCenter getCenter(Long id) {
        return bloodBankCenterRepo.findById(id)
                .orElseThrow(()->new RuntimeException("NO BLOOD BANK FOUND"));
    }


}
