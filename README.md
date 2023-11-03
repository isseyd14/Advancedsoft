# Advancedsoft
# Team Member
Issey Dowling  (Access Management and user management)  
Joshua Burke  (Pay and transfer management and payment contacts)  
Thomas McMahon  (Admin Account, Delete Account and Front-end)  
Xiaobing Zhu    (Card management and transaction history)    
# Prerequisites
- Java Development Kit (JDK) installed (version 17)  
- Apache Maven installed (version 3.0 or higher)    

# Building the Project
1. Open a terminal or command prompt.  
2. Navigate to the project directory.  
3. Run the following Maven command to build the project:  
   % mvn clean install  

# Team Member Contributions
Joshua Burke
- Creation of Database
- Controller
    - AddAccountServlet
    - AddContactServlet
    - deleteContactservlet
    - editContactServlet
    - moveMoneySerlvet
    - paytransferservlet
    - savecontactservlet
    - updateContactServlet
    - viewbalanceservlet
    - viewHistoryServlet
- DAO
    - AccountDAO
    - ContactDAO
    - TransactionDAO
- Model
    - Account
    - Contact
- JSP Files
    - add-contact.jsp
    - edit-contact.jsp
    - Pay-transfer.jsp
    - Save-contact.jsp
    - View-balance.jsp
- Test Files
    - AccountTest
    - ContactTest 

Issey Dowling 
- Controller
  - ChangePasswordservlet
  - deleteaccservlet
  - forgotpassword
  - loginservlet
  - registerservlet
  - sendemailservlet
  - updateuserservlet
  - validator
- DAO
  - User
- Model
  - User
- JSP Files
  - index
  - account
  - changepass2
  - changepassword
  - editacc
  - forgotpass
  - register
  - login
- Test Files
  - UserTest
  - userUpdTest

Thomas McMahon
- Controller
    - AdminServlet
    - AdminAccountDeleteServlet
    - AdminAccountEditServlet
    - AdminUpdateUserServlet
    - AdminUserTransactionServlet
    - DepositServlet
    - WithdrawServlet
- DAO
    - AdminDAO
- Model
    - Transaction
- JSP Files
    - admin.jsp
    - admin-EditAccount.jsp
    - admin-UserTransactions.jsp
    - admin-ViewAccount.jsp
    - UserDetails.jsp
    - Withdraw.jsp
    - Deposit.jsp
- Test Files
  - AdminTest
  - TestDB
  
Xiaobing Zhu 
- Controller
    - BaseServlet
    - CardServlet
    - TransServlet
- DAO
    - CardDAO
    - TransDAO
- Model
    - Card
- JSP Files
    - addCard.jsp
    - changepin.jsp
    - transaction.jsp
    - card.jsp
    - View-balance.jsp
