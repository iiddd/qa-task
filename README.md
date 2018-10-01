# qa-task
This repository is created to share automated test project for qa task.

System requirements:
MS Windows 10 or Mac OS X (Project was tested on described platforms only)
Latest Google Chrome browser or latest Mozilla Firefox
JDK 1.8
Intellij Idea 2018 (Eclipse may need additional config)

Launch:
Clone git repo as a maven project

Approach:
I used pure Selenium as a framework (as the most popular framework for web applications test automation), Maven as builder (provide to use profile options), TestNG as test runner (easier to configurate out of the box)
Page object pattern to make code more clear (fluence). Fragments used to keep common methods for spesified flows.
Additional info: 
Maven-surefire-plugin was used to set up system property variable in pom xml to build profile-based browser dependency.
Test case description is added as a comment to every test class.

Test results:

LOGIN:
1) Login. Initial state - Passed
2) Login. Basic flow - Passed
3) Login. Incorrect login - Passed
4) Login. Incorrect Password - Passed

EMPLOYEE DETAILS:
1) Employee List. Initial State - Passed
2) Employee List. Delete employee from the list - Failed
3) Employee. Open existing employee details. Double click - Passed
4) Employee. Open existing employee details. Edit Button - Passed
5) Employee. Create New Employee. Basic flow - Passed
6) Employee. Create New Employee. Incomplete profile - Passed
7) Employee. Create New Employee. Format Restrictions. Names - Passed
8) Employee. Create New Employee. Format Restrictions. Emails - Failed
9) Employee. Create New Employee. Format Restrictions. Date - Failed
10) Employee. Create New Employee. Cancel - Passed
11) Employee. Change Employee details - Passed
12) Employee. Change Employee details. Back - Passed
13) Employee. Delete Employee - Passed

LOGOUT:
1) Logout. Employee list page - Failed
2) Logout. Employee page. Edit - Failed
3) Logout. Employee page. Create - Failed
4) Logout. Navigate to app direct url unauthorized Passed
