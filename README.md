# -repository
springboot RestAPI and JWT integration
Above design is for event registration page.

We need to create  Rest API for user Registration and Event registration with two different types of users with JWT token and PostgreSQL
⦁	Existing registered users
⦁	New user
You will need to create four tables with following names
⦁	Registered_users
⦁	Temp
⦁	OTP
⦁	Events_registration ( only two columns – user_id and Create date)

Following are the 2 use cases.
Case 1: Registered user will come on the registration page and fill the form
Flow : The user will enter the email address first and then we will check in the database if the email id exists or not using a REST API. If the user exists in database we will send OTP on his email id.
User has to enter the OTP received on his email ID on the form shown above and if the OTP is verified we will fetch the USER_ID column from the registered users table and insert the same in Events table

Case 2: Non Registered user will come on the registration page and will fill the form
Flow : The user will enter the email address first and then we will check in the database if the email id exists or not using a REST API. If the user doesn’t exist then we make an entry in the temp table and send OTP on the email id.
User has to enter the OTP received on his email ID on the form shown above and if the OTP is verified we will insert his data into Registered_users from temp table and  fetch the USER_ID column from the registered users table and insert the same in Events table

