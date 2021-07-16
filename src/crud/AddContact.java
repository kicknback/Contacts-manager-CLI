package crud;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class AddContact {

    public static void addContactName (List<String> contactName, Path path){
        try {
            Files.write(path, contactName, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Could not Wrtie to File at: " +path.toAbsolutePath());
        }
    }




}
