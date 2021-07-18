package crud;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class DeleteContact {
    public static void removeContactFromList (List<String> contactList, String firstName, Path path) {
        List <String> listWithoutDeletedUser = new ArrayList<>();
        for (String contact : contactList){
            if(contact.contains(firstName)){
               continue;
            }
            listWithoutDeletedUser.add(contact);
        }
        updateListToFile(listWithoutDeletedUser, path);
    }

    private static void updateListToFile (List<String> listWithoutSelectedUser, Path path){
        try {
            Files.write(path, listWithoutSelectedUser);
        } catch (IOException e) {
            System.out.println("Could not Overwrite to File at: " +path);
        }
    }
}
