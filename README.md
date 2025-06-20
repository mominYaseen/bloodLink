> [!NOTE]
> Make sure you have a database  named as "bloodLink"


# when the user/admin/sub_admin login using the api : localhost:8080/login.
    request:
        {
            "email":"email@email.com",
            "password" : "password"
        }

        e.g: login as superAdmin
            {
            "email":"admin@admin.com",
            "password" : "1234"
            }
-------------------------------------------
        e.g: login as subAdmin
        {
        "email":"musa@hospital.com", or "yaseen@hospital.com"
        "password" : "1234"
        }

        or
        {
            "email":"yaseen@hospital.com",
            "password" : "1234"
        }
------------------------------------------------------------

        e.g: login as user
        {
        "email":"momin@email.com",
        "password" : "123"
        }


    response:
        jwt token 
        e.g :
            eyJhbGciOiJIUzI1NiJ9.
            eyJzdWIiOiJtb21pbkBlbWFpbC5jb20iLCJyb2xlIjoiUk9MRV9VU0VSIiwiaWF0IjoxNzQ2NDQ0ODM1LCJleHAiOjE3NDY0NDUxMzV9.
            ca52EZjDnSmNf8KwXWXPGEqUBqeg7jQMnryp1Z22P7Y

## this token contains below details :
    ----------------------------------------
        Decoded Header:
            {
            "alg": "HS256"
            }
        Decoded Payload:
            {
            "sub": "email@email.com",
            "role": "ROLE_USER", (or) "ROLE_SUB_ADMIN" (or) "ROLE_SUPER_ADMIN"
            "iat": 1746444835,
            "exp": 1746445135
            }
        JWT Signature Verification
           { signature}
        
> [!NOTE]
>  the role from the token and render the required dashboard (ui)




> [!NOTE]
>  SET HTTP HEADER TO "Authorizaion" AND SET VALUE TO "BEARER token" TO ALL THE API's EXCEPT ("localhost:8080/user/register).
 token is generated after successfull login.


# SUPER-ADMIN API's

###  POST: localhost:8080/super-admin/register-admin 

    Request:                                                             
        {
            "firstName": "musa",
            "lastName": "yaseen",
            "email": "musa@hospital.com",
            "password": "1234",
            "phoneNumber": "123456789",
            "assignedBloodBankCenterName": "City Blood Bank"
        }

    Response:
        {
            "firstName": "musa",
            "lastName": "yaseen",
            "email": "musa@hospital.com",
            "phoneNumber": "123456789",
            "assignedBloodBankCenterName": "City Blood Bank",
            "role": "ROLE_SUB_ADMIN",
            "createdAt": "2025-04-18T10:32:43.7650225"
        }
    
    e.g 2:
    request:
        {
        "firstName": "yaseen",
        "lastName": "dar",
        "email": "yaseen@hospital.com",
        "password": "1234",
        "phoneNumber": "4563287",
        "assignedBloodBankCenterName": "smhs"
        }
    response:
        {
        "id": 2,
        "firstName": "yaseen",
        "lastName": "dar",
        "email": "yaseen@hospital.com",
        "phoneNumber": "4563287",
        "assignedBloodBankCenterName": "smhs",
        "role": "ROLE_SUB_ADMIN",
        "createdAt": "2025-06-10T22:00:56.0273294"
    }


###  GET: localhost:8080/super-admin/get-registered-admins 
    Request: None

    Response: List of registered-admins or "NO REGISTERED SUB_ADMINS"
    [
       {
           "id": 1,
           "firstName": "musa",
           "lastName": "yaseen",
           "email": "musa@hospital.com",
           "phoneNumber": "123456789",
           "assignedBloodBankCenterName": "123456789",
           "role": "ROLE_SUB_ADMIN",
           "createdAt": "2025-06-10T21:49:51.59436"
       },
       {
           "id": 2,
           "firstName": "yaseen",
           "lastName": "dar",
           "email": "yaseen@hospital.com",
           "phoneNumber": "4563287",
           "assignedBloodBankCenterName": "4563287",
           "role": "ROLE_SUB_ADMIN",
           "createdAt": "2025-06-10T22:00:56.027329"
       }
   ]


###  PUT: localhost:8080/super-admin/approve-camp/{ID}
    Request: Path-variable id = (e.g. id = 1)

    Response: below json , if camp is already approved then response = "400 Bad Request , msg = "DONATION CAMP ALREADY APPROVED"
        {
         "id": 1,
         "campName": "Downtown Blood Donation Drive",
         "organizerName": "City Blood Bank",
         "address": "45 Red Cross Avenue",
         "city": "Baramulla",
         "state": "Jammu & Kashmir",
         "country": "India",
         "latitude": 34.209,
         "longitude": 74.3481,
         "campDate": "2026-04-25",
         "startTime": "10:00:00",
         "endTime": "16:00:00",
         "totalSlots": 80,
         "slotsBooked": 0,
         "slotsLeft": 80,
         "createdAt": "2025-06-10T21:52:33.271302",
         "contactNumber": "+91-9876543210",
         "email": "musa@hospital.com",
         "bloodBankCenterName": "City Blood Bank",
         "active": true,
         "approved": true
     }

### GET: localhost:8080/super-admin/active-camps
    Request: None
    
    Response: List of active-camps or "NO ACTIVE LIST OF DONATION CAMPS"
        [
            {
                "id": 1,
                "campName": "Downtown Blood Donation Drive",
                "organizerName": "City Blood Bank",
                "address": "citymall",
                "city": "srinagar",
                "state": "Jammu & Kashmir",
                "country": "India",
                "latitude": 34.209,
                "longitude": 74.3481,
                "campDate": "2025-04-25",
                "startTime": "10:00:00",
                "endTime": "16:00:00",
                "totalSlots": 80,
                "slotsBooked": 1,
                "slotsLeft": 79,
                "createdAt": "2025-04-23T16:46:44.681233",
                "contactNumber": "+91-9876543210",
                "email": "musa@hospital.com",
                "bloodBankCenterName": "City Blood Bank",
                "active": true,
                "approved": true
            },
            {
                "id": 3,
                "campName": "Downtown Blood Donation Drive",
                "organizerName": "City Blood Bank",
                "address": "lalchowk",
                "city": "srinagar",
                "state": "Jammu & Kashmir",
                "country": "India",
                "latitude": 34.209,
                "longitude": 74.3481,
                "campDate": "2025-04-25",
                "startTime": "10:00:00",
                "endTime": "16:00:00",
                "totalSlots": 80,
                "slotsBooked": 0,
                "slotsLeft": 80,
                "createdAt": "2025-04-23T16:47:09.934748",
                "contactNumber": "+91-9876543210",
                "email": "musa@hospital.com",
                "bloodBankCenterName": "City Blood Bank",
                "active": true,
                "approved": true
            }
        ]

### GET: localhost:8080/super-admin/approved-donation-camps

    Request: None

    Response: List of approved donation camps or "NO DONATION CAMP REQUEST ACCEPTED YET"
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
    }
    ]


### GET: localhost:8080/super-admin/get-requested-camps
    Request: None

    Response: List of requested camps or "No requested donation camps found."
    [
       {
           "id": 1,
           "campName": "Downtown Blood Donation Drive",
           "organizerName": "City Blood Bank",
           "address": "45 Red Cross Avenue",
           "city": "Baramulla",
           "state": "Jammu & Kashmir",
           "country": "India",
           "latitude": 34.209,
           "longitude": 74.3481,
           "campDate": "2026-04-25",
           "startTime": "10:00:00",
           "endTime": "16:00:00",
           "totalSlots": 80,
           "slotsBooked": 0,
           "slotsLeft": 80,
           "createdAt": "2025-06-10T21:52:33.271302",
           "contactNumber": "+91-9876543210",
           "email": "musa@hospital.com",
           "bloodBankCenterName": "City Blood Bank",
           "active": false,
           "approved": false
       },
       {
           "id": 4,
           "campName": "Downtown Blood Donation Drive",
           "organizerName": "City Blood Bank",
           "address": "xyz add",
           "city": "lalchow",
           "state": "Jammu & Kashmir",
           "country": "India",
           "latitude": 34.209,
           "longitude": 74.3481,
           "campDate": "2026-04-25",
           "startTime": "10:00:00",
           "endTime": "16:00:00",
           "totalSlots": 80,
           "slotsBooked": 0,
           "slotsLeft": 80,
           "createdAt": "2025-06-10T22:15:43.962976",
           "contactNumber": "+91-9876543210",
           "email": "musa@hospital.com",
           "bloodBankCenterName": "City Blood Bank",
           "active": false,
           "approved": false
       }
   ]

### GET: localhost:8080/super-admin/get-registered-admins
    request: none
    response :
       [
          {
              "id": 1,
              "firstName": "musa",
              "lastName": "yaseen",
              "email": "musa@hospital.com",
              "phoneNumber": "123456789",
              "assignedBloodBankCenterName": "123456789",
              "role": "ROLE_SUB_ADMIN",
              "createdAt": "2025-06-10T21:49:51.59436"
          },
          {
              "id": 2,
              "firstName": "yaseen",
              "lastName": "dar",
              "email": "yaseen@hospital.com",
              "phoneNumber": "4563287",
              "assignedBloodBankCenterName": "4563287",
              "role": "ROLE_SUB_ADMIN",
              "createdAt": "2025-06-10T22:00:56.027329"
          }
      ]

### GET: localhost:8080/super-admin/get-logs/{centerId}      | (e.g : localhost:8080/super-admin/get-logs/1) , here 1 represents centerId
    request:nothing
    response : THIS RESPONSE(inventory log) IS ACCORDING TO BLOOD BANK CENTER WITH ID=1 
        [
           {
               "id": 1,
               "bloodGroup": "O+",
               "quantityChanged": -3,
               "actionType": "REQUEST",
               "remarks": "Issued 3 units for emergency transfusion",
               "performedBy": "musa@hospital.com",
               "availableQuantity": 5,
               "actionTime": "2025-06-10T21:55:43.593605"
           },
           {
               "id": 2,
               "bloodGroup": "O+",
               "quantityChanged": 3,
               "actionType": "DONATION",
               "remarks": "Donation at xxx camp",
               "performedBy": "musa@hospital.com",
               "availableQuantity": 8,
               "actionTime": "2025-06-10T21:56:24.328764"
           }
       ]


### GET: localhost:8080/super-admin/get-centers
    request : none
    response : list of blood bank centers . each center will be clickable and 
                 then will have the option to check the logs of it using above(8th ⬆️) api call internally.
       [
          {
              "id": 1,
              "name": "City Blood Bank",
              "address": "123 Main Street, Downtown",
              "contactNumber": "+911234567890",
              "email": "contact@citybloodbank.org",
              "city": "Srinagar",
              "state": "Jammu & Kashmir",
              "country": "India",
              "subAdminEmail": "musa@hospital.com"
          },
          {
              "id": 4,
              "name": "smhs",
              "address": "123 Main Street, Downtown",
              "contactNumber": "+9156316813168",
              "email": "contact@smhs.org",
              "city": "Srinagar",
              "state": "Jammu & Kashmir",
              "country": "India",
              "subAdminEmail": "yaseen@hospital.com"
          }
      ]















---------------------------------------------oooooooooooooo----------------------------------------

# SUB-ADMIN   


### POST: localhost:8080/admin/req-donation-camp
    Request:
    {
    "campName": "Downtown Blood Donation Drive",
    "address": "45 Red Cross Avenue",
    "city": "Baramulla",
    "state": "Jammu & Kashmir",
    "country": "India",
    "latitude": 34.2090,
    "longitude": 74.3481,
    "campDate": "2026-04-25",
    "startTime": "10:00:00",
    "endTime": "16:00:00",
    "totalSlots": 80,
    "contactNumber": "+91-9876543210",
    "email": "lifeline@bloodservices.org"
    }

    Response:
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


### POST: localhost:8080/admin/add-blood-Bank     
    request :- at the time of registering the bloodBankCenter , the subAdmin can send the below req , where the
                details like BloodInventory is also send at the same time .
        {
            "name": "City Blood Bank",
            "address": "123 Main Street, Downtown",
            "contactNumber": "+911234567890",
            "email": "contact@citybloodbank.org",
            "city": "Srinagar",
            "state": "Jammu & Kashmir",
            "country": "India",
            "latitude": 34.0836,
            "longitude": 74.7973,
            "centerEstablishedTime": "2020-04-01T09:00:00",
            "bloodInventories": [
                {
                "bloodGroup": "A+",
                "availableUnits": 12,
                
                "bloodBankCenter":1
                },
                {
                "bloodGroup": "B+",
                "availableUnits": 10,
                
                "bloodBankCenter":1
                },
                {
                "bloodGroup": "O+",
                "availableUnits": 8,
               
                "bloodBankCenter":1
                },
                {
                "bloodGroup": "AB+",
                "availableUnits": 6,
                
                "bloodBankCenter":1
                }
            ]
        }
    response:-
        {
            "id": 1,
            "name": "City Blood Bank",
            "address": "123 Main Street, Downtown",
            "contactNumber": "+911234567890",
            "email": "contact@citybloodbank.org",
            "city": "Srinagar",
            "state": "Jammu & Kashmir",
            "country": "India",
            "latitude": 34.0836,
            "longitude": 74.7973,
            "centerEstablishedTime": "2020-04-01T09:00:00",
            "accountCreatedAt": "2025-04-18T20:44:06.756302",
            "subAdmin": {
                    "id": 1,
                    "firstName": "musa",
                    "lastName": "yaseen",
                    "email": "musa@hospital.com",
                    "phoneNumber": "123456789",
                    "assignedBloodBankCenterName": "123456789",
                    "role": "ROLE_SUB_ADMIN",
                    "createdAt": "2025-04-18T20:44:03.156548"
                },
            "bloodInventories": [
                    {
                    "id": 1,
                    "bloodGroup": "A+",
                    "availableUnits": 12,
                    "minimumUnits": 5,
                    "bloodBankCenter": 1
                    },
                    {
                    "id": 2,
                    "bloodGroup": "B+",
                    "availableUnits": 10,
                    "minimumUnits": 4,
                    "bloodBankCenter": 1
                    },
                    {
                    "id": 3,
                    "bloodGroup": "O+",
                    "availableUnits": 8,
                    "minimumUnits": 3,
                    "bloodBankCenter": 1
                    },
                    {
                    "id": 4,
                    "bloodGroup": "AB+",
                    "availableUnits": 6,
                    "minimumUnits": 2,
                    "bloodBankCenter": 1
                    }
            ]
        }
    e.g 2.
     request:
       {
       "name": "smhs",
       "address": "123 Main Street, Downtown",
       "contactNumber": "+9156316813168",
       "email": "contact@smhs.org",
       "city": "Srinagar",
       "state": "Jammu & Kashmir",
       "country": "India",
       "latitude": 34.0836,
       "longitude": 74.7973,
       "centerEstablishedTime": "2020-04-01T09:00:00",
       "bloodInventories": [
       {
       "bloodGroup": "A+",
       "availableUnits": 12,
       "bloodBankCenter": 1
       },
       {
       "bloodGroup": "B+",
       "availableUnits": 10,
       "bloodBankCenter": 1
       },
       {
       "bloodGroup": "O+",
       "availableUnits": 8,
       "bloodBankCenter": 1
       },
       {
       "bloodGroup": "AB+",
       "availableUnits": 6,
       "bloodBankCenter": 1
       }
       ]
       }
    response:
      {
      "id": 2,
      "name": "smhs",
      "address": "123 Main Street, Downtown",
      "contactNumber": "+9156316813168",
      "email": "contact@smhs.org",
      "city": "Srinagar",
      "state": "Jammu & Kashmir",
      "country": "India",
      "subAdminEmail": "yaseen@hospital.com"
      }


### POST: localhost:8080/admin/add-log           
    request:
        {
            "bloodGroup": "O+",
            "quantityChanged": -3,
            "actionType": "REQUEST", given in any case , it is internally converted to uppercase
            "remarks": "Issued 3 units for emergency transfusion"
        }
    response:
        {
        "id": 1,
        "bloodGroup": "O+",
        "quantityChanged": -3,
        "actionType": "REQUEST",
        "remarks": "Issued 3 units for emergency transfusion",
        "performedBy": "musa@hospital.com",
        "actionTime": "2025-04-22T11:18:20.3144499"
        }



### GET: localhost:8080/admin/get-blood-inventory
    request:- nothing
    response:-
        [
          {
              "bloodGroup": "A+",
              "availableUnits": 12,
              "lastUpdated": "2025-06-10T21:51:43.059894"
          },
          {
              "bloodGroup": "B+",
              "availableUnits": 10,
              "lastUpdated": "2025-06-10T21:51:43.059894"
          },
          {
              "bloodGroup": "O+",
              "availableUnits": 8,
              "lastUpdated": "2025-06-10T21:56:24.310901"
          },
          {
              "bloodGroup": "AB+",
              "availableUnits": 6,
              "lastUpdated": "2025-06-10T21:51:43.059894"
          }
      ]

### GET: localhost:8080/admin/get-requested-camps

    request : none
    response:
        [
             {
                 "id": 1,
                 "campName": "Downtown Blood Donation Drive",
                 "organizerName": "City Blood Bank",
                 "address": "45 Red Cross Avenue",
                 "city": "Baramulla",
                 "state": "Jammu & Kashmir",
                 "country": "India",
                 "latitude": 34.209,
                 "longitude": 74.3481,
                 "campDate": "2026-04-25",
                 "startTime": "10:00:00",
                 "endTime": "16:00:00",
                 "totalSlots": 80,
                 "createdAt": "2025-06-10T21:52:33.271302",
                 "contactNumber": "+91-9876543210",
                 "email": "musa@hospital.com",
                 "active": false,
                 "approved": false
             },
             {
                 "id": 4,
                 "campName": "Downtown Blood Donation Drive",
                 "organizerName": "City Blood Bank",
                 "address": "xyz add",
                 "city": "lalchow",
                 "state": "Jammu & Kashmir",
                 "country": "India",
                 "latitude": 34.209,
                 "longitude": 74.3481,
                 "campDate": "2026-04-25",
                 "startTime": "10:00:00",
                 "endTime": "16:00:00",
                 "totalSlots": 80,
                 "createdAt": "2025-06-10T22:15:43.962976",
                 "contactNumber": "+91-9876543210",
                 "email": "musa@hospital.com",
                 "active": false,
                 "approved": false
             }
         ]


### GET: localhost:8080/admin/get-active-camps    
    request: nothing
    response: the camps that are activated by the super-admin according to the subAdmin's bloodBank center will appear here , if it returns empty array then there are no active camps for this subadmins blood center
        [
            {
                "id": 1,
                "campName": "Downtown Blood Donation Drive",
                "organizerName": "City Blood Bank",
                "address": "citymall",
                "city": "srinagar",
                "state": "Jammu & Kashmir",
                "country": "India",
                "latitude": 34.209,
                "longitude": 74.3481,
                "campDate": "2025-04-25",
                "startTime": "10:00:00",
                "endTime": "16:00:00",
                "totalSlots": 80,
                "createdAt": "2025-04-23T16:46:44.681233",
                "contactNumber": "+91-9876543210",
                "email": "musa@hospital.com",
                "active": true,
                "approved": true
            },
            {
                "id": 3,
                "campName": "Downtown Blood Donation Drive",
                "organizerName": "City Blood Bank",
                "address": "lalchowk",
                "city": "srinagar",
                "state": "Jammu & Kashmir",
                "country": "India",
                "latitude": 34.209,
                "longitude": 74.3481,
                "campDate": "2025-04-25",
                "startTime": "10:00:00",
                "endTime": "16:00:00",
                "totalSlots": 80,
                "createdAt": "2025-04-23T16:47:09.934748",
                "contactNumber": "+91-9876543210",
                "email": "musa@hospital.com",
                "active": true,
                "approved": true
            }
        ]

### POST: localhost:8080/admin/register-donor-to-camp/{campId}/{donorEmail}
    e.g : localhost:8080/admin/register-donor-to-camp/3/momin@email.com
    request : none
    response:
         1.   DONATION CAMP NOT FOUND (IF campId given is wrong or the camp is not active)
         2.   DONOR IS NOT ELIGIBLE TO DONATE(when donor  is not eligible to donate)
         3.   NO SLOTS LEFT IN THIS DONATION CAMP (when slots are not left)
         4.   Donor successfully registered for the donation camp! (when donor registers successfully)


### GET: localhost:8080/admin/get-logs            
    REQUEST : NONE
    RESPONSE :
        [
    {
        "id": 1,
        "bloodGroup": "O+",
        "quantityChanged": -3,
        "actionType": "REQUEST",
        "remarks": "Issued 3 units for emergency transfusion",
        "performedBy": "musa@hospital.com",
        "availableQuantity": 5,
        "actionTime": "2025-06-10T21:55:43.593605"
    },
    {
        "id": 2,
        "bloodGroup": "O+",
        "quantityChanged": 3,
        "actionType": "DONATION",
        "remarks": "Donation at xxx camp",
        "performedBy": "musa@hospital.com",
        "availableQuantity": 8,
        "actionTime": "2025-06-10T21:56:24.328764"
    },{},{}
]
            

------------------------------------------------oooooooooooooooo------------------------------------------


# UserEntity 




### POST: localhost:8080/user/register
    request:
        {
            "firstName": "momin",
            "lastName": "momin",
            "email": "momin@email.com",
            "password": "123",
            "phoneNumber": "+1234567890",
            "gender": "male",
            "age": 30,
            "bloodGroup": "O+",
            "address": "123 Street Name",
            "city": "Srinagar",
            "state": "Jammu and Kashmir",
            "country": "India",
            "latitude": 34.0858,
            "longitude": 74.7984,
            "lastDonationDate": "2025-03-15T10:00:00"
        }
    response:
        {
            "id": 1,
            "firstName": "momin",
            "lastName": "momin",
            "email": "momin@email.com",
            "phoneNumber": "+1234567890",
            "gender": "male",
            "age": 30,
            "bloodGroup": "O+",
            "address": "123 Street Name",
            "city": "Srinagar",
            "state": "Jammu and Kashmir",
            "country": "India",
            "latitude": 34.0858,
            "longitude": 74.7984,
            "createdAt": "2025-05-05T15:10:50.422131",
            "eligibleToDonate": false,
            "nextDonationDate": null,
            "eligibilityCheckDone": true,
            "lastDonatedDate": null
        }

### GET: localhost:8080/user/donation-history
    request:- nothing
    response:-
        [
            {
                "campName": "Downtown Blood Donation Drive",
                "organizerName": "City Blood Bank",
                "address": "citymall",
                "city": "citymall",
                "state": "Jammu & Kashmir",
                "country": "India",
                "campDate": "2025-04-25",
                "contactNumber": "+91-9876543210",
                "email": "musa@hospital.com"
            },{},{}
        ]



### GET: localhost:8080/user/get-low-blood        
    request : none
    response :
        [
            {
                "centerName": "City Blood Bank",
                "city": "Srinagar",
                "bloodGroup": "O+",
                "availableUnits": 8
            },
            {
                "centerName": "SMHS",
                "city": "Srinagar",
                "bloodGroup": "O+",
                "availableUnits": 8
            },{},{}
        ]
> [!NOTE]
>  this method at the end because it needs websockets to have latest and realtime data from  the db.







### POST: localhost:8080/user/check-eligibility
    request:
        {
            "feelingWell": ,
            "recentDonation": ,
            "takingMedication": ,
            "hasChronicIllness": ,
            "hasInfection": ,
            "covidRecently": ,
            "malariaTravel": ,
            "hasTattoo": ,
            "testedPositiveHIV": ,
            "pregnant": ,
            "weight":
        }
    response :
        1. user eligible to donate(200)
             {
                "isEligibleToDonate": true
            }

                or
        2. user not-eligible to donate(200)

             {
                "isEligibleToDonate": false
            }

### Get: localhost:8080/user/check-if-eligibility    
    request : nothing
    1. if user has already consumed api(localhost:8080/user/check-eligibility) and is eligible to donate, then
        response : 
            {
                "checkDone": true,
                "eligibleToDonate": false
             }

    2. if user has already consumed api(localhost:8080/user/check-eligibility) and is not  eligible to donate, then
        response : 
            {
                "checkDone": true,
                "eligibleToDonate":false 
             }

    3. if user has not consumed api  (localhost:8080/user/check-eligibility) yet , then
        response : 
            {
                "checkDone": false,
                "eligibleToDonate": false
             }

### Get: localhost:8080/user/active-camps             

    request : none
    response : list of active camps
        [
            {
                "campName": "Downtown Blood Donation Drive",
                "organizerName": "City Blood Bank",
                "address": "citymall",
                "city": "srinagar",
                "state": "Jammu & Kashmir",
                "country": "India",
                "campDate": "2025-04-25",
                "contactNumber": "+91-9876543210",
                "email": "musa@hospital.com"
            },
            {
                "campName": "Downtown Blood Donation Drive",
                "organizerName": "City Blood Bank",
                "address": "barzullah",
                "city": "srinagar",
                "state": "Jammu & Kashmir",
                "country": "India",
                "campDate": "2025-05-15",
                "contactNumber": "+91-9876543210",
                "email": "musa@hospital.com"
            },
            {
            "campName": "Downtown Blood Donation Drive",
            "organizerName": "City Blood Bank",
            "address": "hkjhklhl",
            "city": "srinagar",
            "state": "Jammu & Kashmir",
            "country": "India",
            "campDate": "2025-05-15",
            "contactNumber": "+91-9876543210",
            "email": "musa@hospital.com"
            }
        ]


#### USER ENTITY SQL QUERIES FOR TESTING PURPOSES

    INSERT INTO user_table (first_name, last_name, email, password, phone_number, gender, age, blood_group,
    address, city, state, country, latitude, longitude, account_created_date,
    eligible_to_donate, last_donation_date, next_donation_date, eligibility_check_done)
    VALUES ('momin', 'yaseen', 'mominyaseeneducation@gmail.com', 'I+3LEgli!2', '5872631379', 'male', 44, 'A+',
    '6983 Anita Trace', 'Foxtown', 'Hawaii', 'Tunisia', -14.602331, 29.509902, '2025-04-25 15:09:31',
    FALSE, '2024-06-16', NULL, TRUE);
    
    INSERT INTO user_table (first_name, last_name, email, password, phone_number, gender, age, blood_group,
    address, city, state, country, latitude, longitude, account_created_date,
    eligible_to_donate, last_donation_date, next_donation_date, eligibility_check_done)
    VALUES ('Elizabeth', 'Taylor', 'johnsonjessica@yahoo.com', 'D6cAsoS)%2', '8916198263', 'FEMALE', 25, 'O+',
    '978 Cortez Parkway', 'South Joshuaside', 'Georgia', 'Ethiopia', -45.631229, 139.591871, '2025-04-25 15:09:31',
    FALSE, '2024-08-18', NULL, TRUE);
    
    INSERT INTO user_table (first_name, last_name, email, password, phone_number, gender, age, blood_group,
    address, city, state, country, latitude, longitude, account_created_date,
    eligible_to_donate, last_donation_date, next_donation_date, eligibility_check_done)
    VALUES ('Karen', 'Price', 'iduncan@reed-coleman.com', '3GWj5OXp!4', '7699984341', 'MALE', 34, 'A+',
    '24044 Carlos River Apt. 630', 'Lake Rebecca', 'Kentucky', 'Costa Rica', -0.0517605, 72.297130, '2025-04-25 15:09:31',
    FALSE, '2024-06-30', NULL, TRUE);

