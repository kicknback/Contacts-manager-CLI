import crud.AddContact;

import java.nio.file.Path;

public class ContactsManagerApplication {

    public static void main(String[] args) {

        init();


    }

    public static void init() {
        Path filePath = PathClass.getPath( "src","contacts.txt").toAbsolutePath();

        Contacts raul = new Contacts("Raul","Martinez", "915-420-6969", "123 Specific Street, City, 90210");
        Contacts josh = new Contacts("Josh","Borreli", "915-969-9696", "9000 Specific Street, City, 90000");
        Contacts per = new Contacts("Per","Son", "915-420-4242", "4444 Specific Ave, City, 90210");

//        AddContact.addContactInfo(raul.getContactInfo(), filePath);
//        AddContact.addContactInfo(josh.getContactInfo(), filePath);
//        AddContact.addContactInfo(per.getContactInfo(), filePath);

    }

}
