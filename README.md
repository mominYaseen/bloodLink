|------------------|
| SUPER-ADMIN API's |

manually registering super admin:-
-------------------------------------------------------------------------------------------|
use bloodlink;                                                                             |
INSERT INTO super_admin_table (first_name, last_name, email, password, phone_number, role) |
VALUES ('admin', 'admin', 'admin@email.com', '1234', '+919876543210', 'ROLE_SUPER_ADMIN'); |
-------------------------------------------------------------------------------------------|

|---------------------------------------------------|
1.  POST: localhost:8080/super-admin/register-admin |
----------------------------------------------------| 
    Request:                                                             
        {
            "firstName": "musa",
            "lastName": "yaseen",
            "email": "musa@hospital.com",
            "password": "123",
            "phoneNumber": "123456789",
            "assignedBloodBankCenterName": "City Blood Bank",
            "role": "ROLE_SUB_ADMIN" not in frontend 
        }

    Response:
        {
            "firstName": "musa",
            "lastName": "yaseen",
            "email": "musa@hospital.com",
            "phoneNumber": "123456789",
            "assignedBloodBankCenterName": "123456789",
            "role": "ROLE_SUB_ADMIN",
            "createdAt": "2025-04-18T10:32:43.7650225"
        }


----------------------------------------------------------|
2.  GET: localhost:8080/super-admin/get-registered-admins |
----------------------------------------------------------|
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
3.  PUT: localhost:8080/super-admin/approve-camp/{ID}   |
-------------------------------------------------------|
Request: Path-variable id = (e.g. id = 1)

Response: below json , if camp is already approved then response = "400 Bad Request , msg = "DONATION CAMP ALREADY APPROVED"
        [
            {
                "id": 2,
                "campName": "Downtown Blood Donation Drive",
                "organizerName": "City Blood Bank",
                "address": "lal chowk",
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
                "createdAt": "2025-04-23T14:51:53.196171",
                "contactNumber": "+91-9876543210",
                "email": "musa@hospital.com",
                "bloodBankCenterName": "City Blood Bank",
                "active": true,
                "approved": true
            }
        ]

----------------------------------------------------  
4.  GET: localhost:8080/super-admin/active-camps
-----------------------------------------------------
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

-------------------------------------------------------------|   
5. GET: localhost:8080/super-admin/approved-donation-camps   |
-------------------------------------------------------------|
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


-------------------------------------------------------| 
6. GET: localhost:8080/super-admin/get-requested-camps |
-------------------------------------------------------|
Request: None

Response: List of requested camps or "No requested donation camps found."
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
    }
]

----------------------------------------------------------|
7. GET: localhost:8080/super-admin/get-registered-admins  |
----------------------------------------------------------|
    request: none
    response :
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
               "id": 2,
               "name": "SMHS",
               "address": "123 Main Street, Downtown",
               "contactNumber": "+91123F4567890",
               "email": "contact@smhs.org",
               "city": "Srinagar",
               "state": "Jammu & Kashmir",
               "country": "India",
               "subAdminEmail": "momin@hospital.com"
           }
       ]

|------------------------------------------------------------|
|8. GET: localhost:8080/super-admin/get-logs/{centerId}      | (e.g : localhost:8080/super-admin/get-logs/1) , here 1 represents centerId
-------------------------------------------------------------|
    request:nothing
    response : THIS RESPONSE(inventory log) IS ACCORDING TO BLOOD BANK CENTER WITH ID=1 
        [
            {
                "id": 1,
                "bloodGroup": "A+",
                "quantityChanged": 10,
                "actionType": "donation",
                "remarks": "Issued 3 units for emergency transfusion",
                "performedBy": "musa@hospital.com",
                "availableQuantity": 0,
                "actionTime": "2025-04-25T18:50:04.667186"
            },
            {
                "id": 2,
                "bloodGroup": "A+",
                "quantityChanged": -7,
                "actionType": "request",
                "remarks": "Issued 3 units for emergency transfusion",
                "performedBy": "musa@hospital.com",
                "availableQuantity": 0,
                "actionTime": "2025-04-25T18:53:40.456019"
            },
            {
                "id": 3,
                "bloodGroup": "A+",
                "quantityChanged": 17,
                "actionType": "donation",
                "remarks": "Issued 3 units for emergency transfusion",
                "performedBy": "musa@hospital.com",
                "availableQuantity": 0,
                "actionTime": "2025-04-25T20:32:01.461524"
            },
        ]


----------------------------------------------------------|
7. GET: localhost:8080/super-admin/get-centers            |
----------------------------------------------------------|
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
               "id": 2,
               "name": "SMHS",
               "address": "123 Main Street, Downtown",
               "contactNumber": "+91123F4567890",
               "email": "contact@smhs.org",
               "city": "Srinagar",
               "state": "Jammu & Kashmir",
               "country": "India",
               "subAdminEmail": "momin@hospital.com"
           }
       ]















---------------------------------------------oooooooooooooo----------------------------------------

|-------------|
| SUB-ADMIN   |
|-------------------------------------------------|
|1. POST: localhost:8080/admin/req-donation-camp   |
--------------------------------------------------|
Request:
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


|-------------------------------------------------|
|2. POST: localhost:8080/admin/add-blood-Bank     |
--------------------------------------------------|
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



|-------------------------------------------------|
|3. POST: localhost:8080/admin/add-log            |
--------------------------------------------------|
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



|-------------------------------------------------|
|4. GET: localhost:8080/admin/get-blood-inventory|
--------------------------------------------------
    request:- nothing
    response:-
        [
            {
                "bloodGroup": "A+",
                "availableUnits": 61,
                "lastUpdated": "2025-04-22T17:38:17.47556"
            },
            {
                "bloodGroup": "B+",
                "availableUnits": 10,
                "lastUpdated": "2025-04-22T17:15:24.702722"
            },
            {
                "bloodGroup": "O+",
                "availableUnits": 8,
                "lastUpdated": "2025-04-22T17:15:24.702722"
            },
            {
                "bloodGroup": "AB+",
                "availableUnits": 6,
                "lastUpdated": "2025-04-22T17:15:24.702722"
            }
        ]

|-------------------------------------------------|
|5. GET: localhost:8080/admin/get-requested-camps|
--------------------------------------------------|
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
                "campDate": "2025-04-25",
                "startTime": "10:00:00",
                "endTime": "16:00:00",
                "totalSlots": 80,
                "createdAt": "2025-04-23T14:51:37.31501",
                "contactNumber": "+91-9876543210",
                "email": "musa@hospital.com"
            },
            {
                "id": 2,
                "campName": "Downtown Blood Donation Drive",
                "organizerName": "City Blood Bank",
                "address": "lal chowk",
                "city": "Baramulla",
                "state": "Jammu & Kashmir",
                "country": "India",
                "latitude": 34.209,
                "longitude": 74.3481,
                "campDate": "2025-04-25",
                "startTime": "10:00:00",
                "endTime": "16:00:00",
                "totalSlots": 80,
                "createdAt": "2025-04-23T14:51:53.196171",
                "contactNumber": "+91-9876543210",
                "email": "musa@hospital.com"
            }
        ]

|-------------------------------------------------|
|6. GET: localhost:8080/admin/get-active-camps    |
--------------------------------------------------|
    request: nothing
    response: the camps that are activated by the super-admin according to the subAdmin's bloodBank center will appear here
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

|--------------------------------------------------------------------------|
|6. POST: localhost:8080/admin/register-donor-to-camp/{campId}/{donorEmail}|
---------------------------------------------------------------------------|
    e.g : localhost:8080/admin/register-donor-to-camp/3/momin@email.com
    request : none
    response:
         1.   DONATION CAMP NOT FOUND (IF campId given is wrong or the camp is not active)
         2.   DONOR IS NOT ELIGIBLE TO DONATE(when donor  is not eligible to donate)
         3.   NO SLOTS LEFT IN THIS DONATION CAMP (when slots are not left)
         4.   Donor successfully registered for the donation camp! (when donor registers successfully)


|-------------------------------------------------|
|7. GET: localhost:8080/admin/get-logs            |
--------------------------------------------------|
    REQUEST : NONE
    RESPONSE :
        [
            {
            "id": 1,
            "bloodGroup": "A+",
            "quantityChanged": 10,
            "actionType": "donation",
            "remarks": "Issued 3 units for emergency transfusion",
            "performedBy": "musa@hospital.com",
            "availableQuantity": 0,
            "actionTime": "2025-04-25T18:50:04.667186"
            },
            {
            "id": 2,
            "bloodGroup": "A+",
            "quantityChanged": -7,
            "actionType": "request",
            "remarks": "Issued 3 units for emergency transfusion",
            "performedBy": "musa@hospital.com",
            "availableQuantity": 0,
            "actionTime": "2025-04-25T18:53:40.456019"
            },
            {
            "id": 3,
            "bloodGroup": "A+",
            "quantityChanged": 17,
            "actionType": "donation",
            "remarks": "Issued 3 units for emergency transfusion",
            "performedBy": "musa@hospital.com",
            "availableQuantity": 0,
            "actionTime": "2025-04-25T20:32:01.461524"
            },{},{}
        ]
            

















------------------------------------------------oooooooooooooooo------------------------------------------
|-------------|
| UserEntity  |
|-------------------------------------------------|
|1. POST: localhost:8080/user/register             | 
--------------------------------------------------|
    request:
            {
                "firstName": "momin",
                "lastName": "momin",
                "email": "momin@email.com",
                "password": "1234",
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
                "eligibleToDonate": true,
                "lastDonationDate": "2025-03-15T10:00:00"
            }

    response:
            {
            "id": 1,
            "firstName": "momin",
            "lastName": "momin",
            "email": "momin@email.com",
            "password": "1234",
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
            "createdAt": "2025-04-23T16:47:46.745896",
            "eligibleToDonate": true,
            "nextDonationDate": null,
            "eligibilityCheckDone": true,
            "lastDonatedDate": null
            }

note



|-------------------------------------------------|
|2. GET: localhost:8080/user/donation-history     |
--------------------------------------------------|
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



|-------------------------------------------------|
|3. GET: localhost:8080/user/get-low-blood        |
--------------------------------------------------|
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
**note**: complete this method at the end because it needs websockets to have latest and realtime data from  the db.







|-------------------------------------------------|
|4. POST: localhost:8080/user/check-eligibility   |
--------------------------------------------------|
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
                or
        2. user not-eligible to donate(200)


|-----------------------------------------------------|
|5. Get: localhost:8080/user/check-if-eligibility    |
------------------------------------------------------|
    request : nothing
    response : true ( if eligibility-check is done)
                else
                false (if eligibility-check is not done)





|-----------------------------------------------------|
|6. Get: localhost:8080/user/active-camps             |
------------------------------------------------------|

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
    
















USER ENTITY SQL QUERIES FOR TESTING PURPOSES

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

