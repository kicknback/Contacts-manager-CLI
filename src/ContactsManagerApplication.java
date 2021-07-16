import crud.AddContact;

import java.nio.file.Path;

public class ContactsManagerApplication {

    public static void main(String[] args) {

        init();


    }

    public static void init() {
        Path filePath = PathClass.getPath( "src","contacts.txt").toAbsolutePath();

        Contacts contact1 = new Contacts("Raul","Martinez", "915-420-6969", "123 Specific Street, City, 90210");
        Contacts contacts2 = new Contacts("Josh","Borreli", "915-969-9696", "9000 Specific Street, City, 90000");
        Contacts contacts3 = new Contacts("Per","Son", "915-420-4242", "4444 Specific Ave, City, 90210");

        AddContact.addContactName(contact1.getFirstName(), filePath);
    }

}
