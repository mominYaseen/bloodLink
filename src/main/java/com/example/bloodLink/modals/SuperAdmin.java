package com.example.bloodLink.modals;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "superAdminTable")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property ="id"
)
public class SuperAdmin {
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
    @Column(name = "phoneNumber",unique = true,nullable = false)
    private String phoneNumber;

    @Column(name = "role")
    private String role = "ROLE_SUPER_ADMIN";

    @OneToMany(mappedBy = "superAdmin", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<SubAdmin> listOfRegisteredAdmins = new ArrayList<>();



    public SuperAdmin() {
    }

    public SuperAdmin(String firstName, String lastName, String email, String phoneNumber, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
//        this.password = password;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }

    public List<SubAdmin> getListOfRegisteredAdmins() {
        return listOfRegisteredAdmins;
    }

    public void setListOfRegisteredAdmins(List<SubAdmin> listOfRegisteredAdmins) {
        this.listOfRegisteredAdmins = listOfRegisteredAdmins;
    }

    public Long getId() {
        return id;
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
        return "SuperAdmin{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
//                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
