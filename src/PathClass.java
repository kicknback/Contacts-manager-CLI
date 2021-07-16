import java.nio.file.Path;
import java.nio.file.Paths;

public class PathClass {

    public static Path getPath(String filename) {
        return Paths.get(filename);
    }

    public static Path getPath(String parentDirectory, String filename) {
        return Paths.get(parentDirectory, filename);
    }

}
