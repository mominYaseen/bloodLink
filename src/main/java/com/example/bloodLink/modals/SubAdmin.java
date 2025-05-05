package com.example.bloodLink.modals;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity(name = "adminTable")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property ="id"
)
public class SubAdmin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "email",nullable = false,unique = true)
    private String email;
//    @Column(name = "password")
//    private String password;
    @Column(name = "phoneNumber",nullable = false,unique = true)
    private String phoneNumber;



    @Column(name = "role")
    private String role = "ROLE_ADMIN";

    @Column(updatable = false)
    private LocalDateTime createdAt;


    @ManyToOne
    @JoinColumn(name = "super_admin_id", referencedColumnName = "id",nullable = false)
    @JsonIgnore
    private SuperAdmin superAdmin;
//
//    @OneToMany(cascade = CascadeType.ALL , orphanRemoval = true , mappedBy = "subAdmin")
//    private List<DonationCamp> listOfDonationCampRequested = new ArrayList<>();


    @Column(name = "assignedBloodBankCenterName")
    private String assignedBloodBankCenter;


    @JsonIgnore
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE},optional = true) // because if the sub-admin is deleted , we don't want to delete
    @JoinColumn(name = "bloodBankId" , referencedColumnName ="id",nullable = true)  //bloodBankCenter associated to it
    private BloodBankCenter bloodBankCenter = null;


    public SubAdmin() {
    }



    // the super admin sends it during the account creation
//    @PrePersist
//    protected void onCreate() {
//        this.bloodBankCenter=null;
//    }


    public String getAssignedBloodBankCenter() {
        return assignedBloodBankCenter;
    }

    public void setAssignedBloodBankCenter(String assignedBloodBankCenter) {
        this.assignedBloodBankCenter = assignedBloodBankCenter;
    }

    public BloodBankCenter getBloodBankCenter() {
        return bloodBankCenter;
    }

    public void setBloodBankCenter(BloodBankCenter bloodBankCenter) {
        this.bloodBankCenter = bloodBankCenter;
    }

//    public List<DonationCamp> getListOfDonationCampRequested() {
//        return listOfDonationCampRequested;
//    }
//
//    public void setListOfDonationCampRequested(List<DonationCamp> listOfDonationCampRequested) {
//        this.listOfDonationCampRequested = listOfDonationCampRequested;
//    }

    public SuperAdmin getSuperAdmin() {
        return superAdmin;
    }

    public void setSuperAdmin(SuperAdmin superAdmin) {
        this.superAdmin = superAdmin;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


//    public String getPassword() {
//        return password;
//    }
//public void setPassword(String password) {
//    this.password = password;
//}




    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }



    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "SubAdmin{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
//                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
//                ", role='" + role + '\'' +
                '}';
    }
}
