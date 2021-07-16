package crud;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReadContacts {

    public static List<String> readFromFile(Path path) throws IOException {
        return Files.readAllLines(path);
    }
}
