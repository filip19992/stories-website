package pl.filipwlodarczyk.stronaZeZdejciami.registration;


public class PasswordValidator {
    public static validatePasswordResponse validatePassword(String password) {

        char firstChar = password.charAt(0);
        String regexForSymbols = "[^-_=+\\\\|\\[{\\]};:'\",<>/]*";


        if (password.length() < 8) {
            return new validatePasswordResponse(false, "Password is too short");
        } else if (password.length() > 12) {
            return new validatePasswordResponse(false, "password is too long");
        } else if (firstChar < 64 || firstChar > 90) {
            return new validatePasswordResponse(false, "First lettter is not an upper case");
        } else if (!password.matches(regexForSymbols)) {
            return new validatePasswordResponse(false, "Passsword doesnt contain a symbol");
        } else {
            return new validatePasswordResponse(true, "Password valided");
        }
    }


    public static class validatePasswordResponse {
        boolean isValidated;
        String message;

        public validatePasswordResponse(boolean isValidated, String message) {
            this.isValidated = isValidated;
            this.message = message;
        }

        public boolean isValidated() {
            return isValidated;
        }

        public String getMessage() {
            return message;
        }
    }


}
