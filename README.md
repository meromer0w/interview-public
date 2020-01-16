### Welcome to the Interview Livecoding Challenge

## How it's organized
Let's assume we're trying to build a Proof of Concept type of banking system.
We have an `Account` entity in our system, those are presumably stored in some persistence layer.
However, for this task we don't care about that and how these accounts get into our app. Assume it's given.
What we want to achieve is to store these accounts in some data structure in the memory of our application.
We also got a service level interface `com.devexperts.service.AccountService.getAccount`

Going further you'll be presented several programming tasks. It's recommended to stick to suggested order.

**Note:**
Try to avoid changing signature of any method of `AccountService` as well as `Account` class.
However, you're free to introduce new methods and/or override existing ones.

# Task 1
Implement `AccountService.clear`, `AccountService.createAccount` and `AccountService.getAccount` 
methods in most efficient way.
Let's assume one of your colleagues already implemented those methods and submitted the code for your review.

**Goal:**
Perform code review and change implementation accordingly

**Hint:**
Consider performance of `AccountService.getAccount` method.

# Task 2
We want to start expanding our business logic, most important feature is to allow money transfers
between accounts. 

**Goal:**
Implement `AccountService.transfer`

**Hint:**
Assume we're in a single-threaded environment

# Task 3
Given working and tested implementation of single-threaded `AccountService.transfer` provide
multi-threaded version 

**Goal:**
Have money transfer between accounts working in concurrent environment

**Note:**
You can combine it with next task

# Task 4
Create a REST service for `transfer` method. It should still operate with accounts in-memory

**Goal:**
Have money transfer between accounts accessible to the outside world

**Details:**
The operation is available at `POST localhost:8080/api/operations/transfer` with required query parameters:
*source_id*, *target_id*, *amount*.
Response codes are the following:
- 200 (OK) - successful transfer
- 400 (Bad Request) -  one of the parameters in not present or amount is invalid
- 404 (Not Found) - account is not found
- 500 (Internal Server Error) - insufficient account balance

**Hint:**
You can introduce new classes and dependencies

# Task 5
Create 2 tables for accounts and corresponding transfers. Accounts column set should correspond to java code.
Same goes for transfers, however one additional column ('TRANSFER_TIME') representing datetime of transfer
should be added. Insert there given test data.
Provide SQL query that finds all accounts that in total transferred more than 1000$ starting from 2019-01-01 

**Hint:**
You can introduce new classes and dependencies