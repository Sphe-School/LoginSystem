public class LoginSystem {

    // now we going to store the users registered details (Variables)//
    private String registeredUsername;
    private String registeredPassword;
    private String registeredCellPhoneNumber;
    private String firstName;
    private String lastName;

    // Constructor This runs when I make the object//
    public LoginSystem(String firstName, String lastName) { //Make a login object and store first name and last name inside it//
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Now i check username//
    public boolean checkUsername(String username) {
        return username.contains("_") && username.length() <= 5;
    }
    // Now we check the password//
    public boolean checkPasswordComplexity(String password) {
        boolean hasUppercase = false; // these start as false then the loop will check each character 1 by 1//
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
            if (!Character.isLetterOrDigit(ch)) { //if it is NOT a letter and NOT a digit, then it is special//
                hasSpecial = true;
            }

        }
        return hasUppercase && hasNumber && hasSpecial; // This is for password passes only if all are true.//
    }
    // here we gonna check the cell number it must start wit +27//
    public boolean checkCellPhoneNumber(String cellPhoneNumber) {
        return cellPhoneNumber.matches("^\\+27\\d{9}$");
    }
    //register user and return the correct message//
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
    // checking login details//
    public boolean loginUser(String username, String password) {
        return username.equals(registeredUsername) && password.equals(registeredPassword);
    }
    // final login message//
    public String returnLoginStaus(boolean loginSuccess) {
        if (loginSuccess) {
            return "Hello " + firstName + ", " + lastName + "good to see you again";
        }else {
            return "Password or Username is Wrong, Please try agin";
        }
    }
}
