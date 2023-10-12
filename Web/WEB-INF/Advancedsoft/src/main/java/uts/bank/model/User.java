package uts.bank.model;

import java.util.Date;

public class User {
        private String email;
        private String pass;
        private String type;
        private String firstName;
        private String lastName;
        private String address;
        private String DOB;

        private String phone;
        public User(String email, String pass, String type, String firstName, String lastName, String address, String DOB, String phone) {
            this.email = email;
            this.pass = pass;
            this.type = type;
            this.firstName = firstName;
            this.lastName = lastName;
            this.address = address;
            this.DOB = DOB;
            this.phone = phone;
        }

        public String getEmail() {

            return this.email;
        }

        public void setEmail(String email) {

            this.email = email;
        }

        public String getPass() {

            return this.pass;
        }

        public void setPass(String pass) {

            this.pass = pass;
        }

        public String getType() {

            return this.type;
        }

        public void setType(String type) {

            this.type = type;
        }

        public String getFirstName() {

            return this.firstName;
        }

        public void setFirstName(String firstName) {

            this.firstName = firstName;
        }

        public String getLastName() {

            return lastName;
        }

        public void setLName(String lastName) {

            this.lastName = lastName;
        }

        public String getAddress() {

            return this.address;
        }

        public void setAddress(String address) {

            this.address = address;
        }

        public String getDOB() {

            return this.DOB;
        }

        public void setDOB(String DOB) {

            this.DOB = DOB;
        }

        public String getPhone() {
            return this.phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
    }

