import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileIO {

    private static Scanner sc = new Scanner(System.in);

    public static int getMenuChoice() {
        System.out.println("\n*** MENU OPTIONS ***\n\n" +
                "1 - View contacts\n" +
                "2 - Add a new contact\n" +
                "3 - Search for contact by name\n" +
                "4 - Delete existing contact\n" +
                "5 - Update existing contact\n" +
                "6 - Exit\n");
        return getInt(1, 6);

    }

    public static boolean yesNo(String prompt) {
        boolean exit = false;
        while (true) {
            System.out.printf("\n%s ", prompt);
            String input = "";
            input = sc.nextLine();
            if (input.matches("(?i)y|yes|yea|yeah|ya|yep")) {
                exit = true;
                break;
            } else if (input.matches("(?i)n|no|nah|na|nope|notta")) {
                "".isEmpty();
                break;
            } else {
                System.out.println("\nNot a valid response...\n");
            }
        }
        return exit;
    }

    public static int getInt(int min, int max) {
        System.out.printf("Enter a value between the range of %s and %s\n", min, max);
        while (true) {
            if (sc.hasNextInt()) {
                int intValue = sc.nextInt();
                if (intValue < min || intValue > max) {
                    System.out.printf("\nThat number isn't between %s and %s..\n", min, max);
                    sc.nextLine();
                } else {
                    sc.nextLine();
                    return intValue;
                }
            } else {
                System.out.println("Please enter a valid number.. \n");
                sc.nextLine();
            }
        }
    }

    public static List<String> addNewContactInput() {
        List<String> list = new ArrayList<>();

        list.add(getString("Enter first name"));
        list.add(getString("Enter last name"));
        while(true) {
            String phone = getString("Enter phone number (area code optional) ex. 123-456-7899: ");
            if (isValidPhoneNumber(phone)) {
                list.add(phone);
                break;
            }
        }
        list.add(getString("Enter address: "));

        return list;
    }

    public static String getString(String prompt) {
        System.out.printf("\n%s: ", prompt);
        return sc.nextLine();
    }

    public static boolean isValidPhoneNumber(String input) {
        return input.matches("(?:\\d{3}-)?\\d{3}-\\d{4}");
    }

}
