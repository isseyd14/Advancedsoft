DROP TABLE account;
DROP TABLE User;
-- info on connecting to sql server
-- String url = "jdbc:mysql://127.0.0.1:3306/bank?allowPublicKeyRetrieval=true&useSSL=false";
--     String username = "root";
--     String password = "root";
--
--
--     protected Connection getConnection(){
--         Connection conn = null;
--         try{
--             Class.forName("com.mysql.cj.jdbc.Driver");
--
--             conn = DriverManager.getConnection(url, username, password);
-- return conn;
-- } catch (SQLException | ClassNotFoundException e){
--             throw new RuntimeException("Error connecting to the database", e);
-- }
--
--
--     }


create table account
(
    Email           varchar(100) not null
        primary key,
    name            varchar(100) null,
    type            varchar(100) null,
    avaliable_funds int          null,
    current_funds   int          null,
    constraint account_User_Email_fk
        foreign key (Email) references User (Email)
);


create table User
(
    Email   varchar(100) not null
        primary key,
    Pass    varchar(100) not null,
    Type    varchar(100) null,
    fname   varchar(100) null,
    lname   varchar(100) null,
    Address varchar(100) null,
    Balance double       null,
    DOB     date         null
);