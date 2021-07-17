package crud;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class AddContact {

    public static void addContactToFile (List<String> contactInfo, Path path){
        try {
            Files.write(path, contactInfo, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Could not Write to File at: " +path);
        }
    }






}
