package uts.bank.Controller;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import jakarta.servlet.http.HttpSession;



   public class Validator implements Serializable{ 
 
   private String cardNoPattern = "^(?:4[0-9]{12}(?:[0-9]{3})?|5[1-5][0-9]{14}|3[47][0-9]{13}|3(?:0[0-5]|[68][0-9])[0-9]{11}|6(?:011|5[0-9]{2})[0-9]{12}(?:2131|1800|35\\d{3})\\d{11})$";      
   private String namePattern = "([A-Z][a-z]+[\\s])+[A-Z][a-z]*"; 
   private String expPattern = "^(0[1-9]|1[0-2])\\/?([0-9]{2})$";       
   private String CVVPattern = "^[0-9]{3,4}$";       
              
   public Validator(){    }       

   public boolean validate(String pattern, String input){       
      Pattern regEx = Pattern.compile(pattern);       
      Matcher match = regEx.matcher(input);       
      return match.matches(); 
   }       
 
   
   public boolean validateCardNo(String cardNo){                       
      return validate(cardNoPattern,cardNo);   
   }
       
   public boolean validateName(String name){
      return validate(namePattern,name); 
   }    
  
   
   public boolean validateExp(String exp){
      return validate(expPattern,exp); 
   }   
   
   public boolean validateCVV(String cvv){
      return validate(CVVPattern,cvv); 
   }  
   public void clear(HttpSession session){
       session.setAttribute("cardErr", "");
       session.setAttribute("nameErr", "");
       session.setAttribute("expErr", "");
       session.setAttribute("cvvErr", "");
   }
      public static boolean validatePassword(String password) {
         if (password.length() < 8) {
            return false;
         }
         if (!Pattern.compile("[A-Z]").matcher(password).find()) {
            return false;
         }
         if (!Pattern.compile("[a-z]").matcher(password).find()) {
            return false;
         }
         if (!Pattern.compile("[0-9]").matcher(password).find()) {
            return false;
         }
         if (!Pattern.compile("[!@#$%^&*()_+\\-=\\[\\]{};':\",.<>?]").matcher(password).find()) {
            return false;
         }
         // At least one digit
         // At least one uppercase letter
         // At least one lowercase letter



         return true;
      }
}
