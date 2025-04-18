|------------------|
|SUPER-ADMIN API's |
|---------------------------------------------------|
1.  POST: localhost:8080/super-admin/register-admin |
----------------------------------------------------|
  request :-                                                             
         {
            "firstName": "musa",
            "lastName": "yaseen",
            "email": "musa@hospital.com",
            "password": "123",
            "phoneNumber": "123456789",
            "assignedBloodBankCenterName": "City Blood Bank",
            "role": "ROLE_SUB_ADMIN"
          }
  response:-
          {
            "firstName": "musa",
            "lastName": "yaseen",
            "email": "musa@hospital.com",
            "phoneNumber": "123456789",
            "assignedBloodBankCenterName": "123456789",
            "role": "ROLE_SUB_ADMIN",
            "createdAt": "2025-04-18T10:32:43.7650225"
          }
    
|----------------------------------------------------------|
|2.  GET: localhost:8080/super-admin/get-registered-admins |
|----------------------------------------------------------|
  request:- none
  response :- list of registered-admin OR "NO REGISTERED SUB_ADMINS"
    [
        {
            "id": 1,
            "firstName": "musa",
            "lastName": "yaseen",
            "email": "musa@hospital.com",
            "phoneNumber": "123456789",
            "assignedBloodBankCenterName": "123456789",
            "role": "ROLE_SUB_ADMIN",
            "createdAt": "2025-04-18T10:43:18.437716"
        }, 
        {
            "id": 2,
            "firstName": "momin",
            "lastName": "yaseen",
            "email": "momin@hospital.com",
            "phoneNumber": "9897886381",
            "assignedBloodBankCenterName": "smhs",
            "role": "ROLE_SUB_ADMIN",
            "createdAt": "2025-04-18T10:46:47.270021"
        }
    ]    

-------------------------------------------------------| 
3.  PUT :localhost:8080/super-admin/aprove-camp/{ID}   |
-------------------------------------------------------|
  request :- path-variable id = (provide camp id no. (e.g id = 1))
  response : - 
    {
        "id": 1,
        "campName": "Downtown Blood Donation Drive",
        "organizerName": null,
        "address": "45 Red Cross Avenue",
        "city": "Baramulla",
        "state": "Jammu & Kashmir",
        "country": "India",
        "latitude": 34.209,
        "longitude": 74.3481,
        "campDate": "2025-04-25",
        "startTime": "10:00:00",
        "endTime": "16:00:00",
        "totalSlots": 80,
        "slotsBooked": 0,
        "slotsLeft": 0,
        "createdAt": "2025-04-18T10:43:22.72774",
        "contactNumber": "+91-9876543210",
        "email": "musa@hospital.com",
        "subAdmin": {
            "id": 1,
            "firstName": "musa",
            "lastName": "yaseen",
            "email": "musa@hospital.com",
            "phoneNumber": "123456789",
            "assignedBloodBankCenterName": "123456789",
            "role": "ROLE_SUB_ADMIN",
            "createdAt": "2025-04-18T10:43:18.437716"
        },
        "active": true,
        "approved": true
    }
    
----------------------------------------------------  
4.  GET : localhost:8080/super-admin/active-camps
-----------------------------------------------------
  request:-none
  response:- list of active-camps or "NO ACTIVE LIST OF DONATION CAMPS"
    [
      {
          "id": 1,
          "campName": "Downtown Blood Donation Drive",
          "organizerName": null,
          "address": "45 Red Cross Avenue",
          "city": "Baramulla",
          "state": "Jammu & Kashmir",
          "country": "India",
          "latitude": 34.209,
          "longitude": 74.3481,
          "campDate": "2025-04-25",
          "startTime": "10:00:00",
          "endTime": "16:00:00",
          "totalSlots": 80,
          "slotsBooked": 0,
          "slotsLeft": 0,
          "createdAt": "2025-04-18T10:43:22.72774",
          "contactNumber": "+91-9876543210",
          "email": "musa@hospital.com",
          "subAdmin": {
              "id": 1,
              "firstName": "musa",
              "lastName": "yaseen",
              "email": "musa@hospital.com",
              "phoneNumber": "123456789",
              "assignedBloodBankCenterName": "123456789",
              "role": "ROLE_SUB_ADMIN",
              "createdAt": "2025-04-18T10:43:18.437716"
          },
          "active": true,
          "approved": true
      },
      {},{},{}
  ]



-------------------------------------------------------------|   
5. GET : localhost:8080/super-admin/approved-donation-camps  |
-------------------------------------------------------------|
  request:- none
  response :- list of all approved donation camps. or "NO DONATION CAMP REQUEST ACCEPTED YET"
      [
        {
            "id": 1,
            "campName": "Downtown Blood Donation Drive",
            "organizerName": null,
            "address": "45 Red Cross Avenue",
            "city": "Baramulla",
            "state": "Jammu & Kashmir",
            "country": "India",
            "latitude": 34.209,
            "longitude": 74.3481,
            "campDate": "2025-04-25",
            "startTime": "10:00:00",
            "endTime": "16:00:00",
            "totalSlots": 80,
            "slotsBooked": 0,
            "slotsLeft": 0,
            "createdAt": "2025-04-18T10:43:22.72774",
            "contactNumber": "+91-9876543210",
            "email": "musa@hospital.com",
            "subAdmin": {
                "id": 1,
                "firstName": "musa",
                "lastName": "yaseen",
                "email": "musa@hospital.com",
                "phoneNumber": "123456789",
                "assignedBloodBankCenterName": "123456789",
                "role": "ROLE_SUB_ADMIN",
                "createdAt": "2025-04-18T10:43:18.437716"
            },
            "active": true,
            "approved": true
        },
        {},
        {}
    ]
  

-------------------------------------------------------| 
6.GET :localhost:8080/super-admin/get-requested-camps  |
-------------------------------------------------------|
  request : none
  response : list of requested camps or "No requested donation camps found."
    [
    {
        "id": 1,
        "campName": "Downtown Blood Donation Drive",
        "organizerName": null,
        "address": "45 Red Cross Avenue",
        "city": "Baramulla",
        "state": "Jammu & Kashmir",
        "country": "India",
        "latitude": 34.209,
        "longitude": 74.3481,
        "campDate": "2025-04-25",
        "startTime": "10:00:00",
        "endTime": "16:00:00",
        "totalSlots": 80,
        "slotsBooked": 0,
        "slotsLeft": 0,
        "createdAt": "2025-04-18T11:02:37.376168",
        "contactNumber": "+91-9876543210",
        "email": "musa@hospital.com",
        "subAdmin": {
            "id": 1,
            "firstName": "musa",
            "lastName": "yaseen",
            "email": "musa@hospital.com",
            "phoneNumber": "123456789",
            "assignedBloodBankCenterName": "123456789",
            "role": "ROLE_SUB_ADMIN",
            "createdAt": "2025-04-18T10:43:18.437716"
        },
        "active": false,
        "approved": false
    },
    {},
    {}
]

---------------------------------------------oooooooooooooo----------------------------------------

|-------------|
|SUB-ADMIN:-  |
|-------------------------------------------------|
|  POST: localhost:8080/admin/req-donation-camp   |
|-------------------------------------------------|
  request:-
      {
        "campName": "Downtown Blood Donation Drive",
        "address": "45 Red Cross Avenue",
        "city": "Baramulla",
        "state": "Jammu & Kashmir",
        "country": "India",
        "latitude": 34.2090,
        "longitude": 74.3481,
        "campDate": "2025-04-25",
        "startTime": "10:00:00",
        "endTime": "16:00:00",
        "totalSlots": 80,
        "contactNumber": "+91-9876543210",
        "email": "lifeline@bloodservices.org"
      }

  response:-
    {
    "id": 1,
    "campName": "Downtown Blood Donation Drive",
    "organizerName": null,
    "address": "45 Red Cross Avenue",
    "city": "Baramulla",
    "state": "Jammu & Kashmir",
    "country": "India",
    "latitude": 34.209,
    "longitude": 74.3481,
    "campDate": "2025-04-25",
    "startTime": "10:00:00",
    "endTime": "16:00:00",
    "totalSlots": 80,
    "createdAt": "2025-04-18T10:43:22.7277396",
    "contactNumber": "+91-9876543210",
    "email": "musa@hospital.com"
}
 




















