public class LoginSystem {

    
    private String registeredUsername;
    private String registeredPassword;
    private String registeredCellPhoneNumber;
    private String firstName;
    private String lastName;


    public LoginSystem(String firstName, String lastName) { 
        this.firstName = firstName;
        this.lastName = lastName;
    }

    
    public boolean checkUsername(String username) {
        return username.contains("_") && username.length() <= 5;
    }
   
    public boolean checkPasswordComplexity(String password) {
        boolean hasUppercase = false; 
        boolean hasNumber = false;
        boolean hasSpecial = false;

        if (password.length() < 8) {
            return false;
        }

        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);

            if (Character.isUpperCase(ch)) {
                hasUppercase = true;
            }

            if (Character.isDigit(ch)) {
                hasNumber = true;
            }
            if (!Character.isLetterOrDigit(ch)) { 
                hasSpecial = true;
            }

        }
        return hasUppercase && hasNumber && hasSpecial; 
    }
 
    public boolean checkCellPhoneNumber(String cellPhoneNumber) {
        return cellPhoneNumber.matches("^\\+27\\d{9}$");
    }
    
    public String registerUser(String username, String password, String cellPhoneNumber) {
        if (!checkUsername(username)) {
            return "User name not rigt; please have an underscore(_) and is not more than 5 characters in lenght";
        }
        if (!checkPasswordComplexity(password)) {
            return "Wrong password; please Make sure that you have at least 8 characters, 1 capital letter, a number and a special letter(#)";
        }
        if (!checkCellPhoneNumber(cellPhoneNumber)) {
            return "cell number was put in wrong make sure you start wit(+27)";
        }
        this.registeredUsername = username;
        this.registeredPassword = password;
        this.registeredCellPhoneNumber = cellPhoneNumber;

        return "User is registered";
    }
  
    public boolean loginUser(String username, String password) {
        return username.equals(registeredUsername) && password.equals(registeredPassword);
    }
   
    public String returnLoginStaus(boolean loginSuccess) {
        if (loginSuccess) {
            return "Hello " + firstName + ", " + lastName + "good to see you again";
        }else {
            return "Password or Username is Wrong, Please try agin";
        }
    }
}
