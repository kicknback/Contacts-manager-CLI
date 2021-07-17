package crud;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

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
}
