import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class PhoneNumberValidator {

    /**
     * Validates a phone number string to ensure it matches the format XXX-XXX-XXXX.
     *
     * @param phoneNumber The phone number string to validate.
     * @return True if the phone number is valid, false otherwise.
     */
    public static boolean isValidPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            return false; // Handle null or empty input
        }

        // Regular expression pattern for the phone number format XXX-XXX-XXXX
        //  - ^ asserts the start of the string.
        //  - \\d{3} matches exactly three digits.
        //  - - matches a hyphen.
        //  - $ asserts the end of the string.
        String regex = "^\\d{3}-\\d{3}-\\d{4}$";  // Modified regex for correct length

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);

        return matcher.matches();
    }

    public static void main(String[] args) {
        // Test cases
        String phone1 = "123-456-7890";
        String phone2 = "12-345-67890";
        String phone3 = "1234-567-890";
        String phone4 = "123-4567-890";
        String phone5 = "123-456-789";
        String phone6 = "abc-def-ghij";
        String phone7 = "";
        String phone8 = null;
        String phone9 = "123-456-!!78901";
        String phone10 = "12345678901";

        System.out.println(phone1 + " is valid: " + isValidPhoneNumber(phone1)); // true
        System.out.println(phone2 + " is valid: " + isValidPhoneNumber(phone2)); // false
        System.out.println(phone3 + " is valid: " + isValidPhoneNumber(phone3)); // false
        System.out.println(phone4 + " is valid: " + isValidPhoneNumber(phone4)); // false
        System.out.println(phone5 + " is valid: " + isValidPhoneNumber(phone5)); // false
        System.out.println(phone6 + " is valid: " + isValidPhoneNumber(phone6)); // false
        System.out.println(phone7 + " is valid: " + isValidPhoneNumber(phone7)); // false
        System.out.println(phone8 + " is valid: " + isValidPhoneNumber(phone8)); // false
        System.out.println(phone9 + " is valid: " + isValidPhoneNumber(phone9)); // false
        System.out.println(phone10 + " is valid: " + isValidPhoneNumber(phone10)); // false
    }
}
