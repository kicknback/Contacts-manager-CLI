import java.nio.file.Path;

public class ContactsManagerApplication {

    public static void main(String[] args) {

        init();


    }

    public static void init() {
        Path filePath = PathClass.getPath( "src","contacts.txt").toAbsolutePath();


    }

}
