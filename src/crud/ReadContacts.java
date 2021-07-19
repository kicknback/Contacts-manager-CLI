package crud;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadContacts {

    public static List<String> readFromFile(Path path) {
        List<String> tlist = new ArrayList<>();
        try {
            tlist = Files.readAllLines(path);
        } catch (IOException e) {
            System.out.printf("Could not read file @%s", path);
        }
        return tlist;
    }

    public static void printOnePerLine (List<String> contactList){
        for(String contact : contactList){
            System.out.println(contact);
        }
    }

    public static String searchContact(String name, List<String> readFile) {
        Scanner userValue = new Scanner(name);
        String newStr = "";
        while (userValue.hasNext()) {
            newStr = newStr + "\\s*\\|?\\s*" + userValue.next();
        }
        String outputString = "";  // Can change to list of strings if needed
        for (String line : readFile) {
            if (line.matches(String.format("(?i).*(%s).*\\|.*\\|.*", newStr))) {
                outputString += line + "\n";
            }
        }
        if (outputString.isEmpty()) {
            return "That user was not found.";
        }
        return outputString;
    }

}
