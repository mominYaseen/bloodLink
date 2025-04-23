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
    "role": "ROLE_SUB_ADMIN"
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


|----------------------------------------------------------|
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
                "active": false,
                "approved": false
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


-------------------------------------------------------------|   
5. GET: localhost:8080/super-admin/approved-donation-camps  |
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
    request :- at the time of registering the bloodBankCenter , the subAdmin can send the below response , where the
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
|4. POST: localhost:8080/admin/get-blood-inventory|
--------------------------------------------------|
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
|5. POST: localhost:8080/admin/get-requested-camps|
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
|6. POST: localhost:8080/admin/get-requested-camps|
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




















------------------------------------------------oooooooooooooooo------------------------------------------
|-------------|
| UserEntity  |
|-------------------------------------------------|
|1. POST: localhost:8080/user/register            |
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





