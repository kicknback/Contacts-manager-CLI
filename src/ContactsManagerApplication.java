import crud.AddContact;
import crud.ReadContacts;

import java.nio.file.Path;
import java.util.List;

public class ContactsManagerApplication {

    public static void main(String[] args) {

        init();

    }

    public static void init() {
        Path filePath = PathClass.getPath( "src","contacts.txt").toAbsolutePath();
        List<String> readFile = ReadContacts.readFromFile(filePath);
        boolean continueProgram = true;

//        Contacts raul = new Contacts("Raul","Martinez", "915-420-6969", "123 Specific Street, City, 90210");
//        Contacts josh = new Contacts("Josh","Borreli", "915-969-9696", "9000 Specific Street, City, 90000");
//        Contacts per = new Contacts("Per","Son", "915-420-4242", "4444 Specific Ave, City, 90210");

//        AddContact.addContactInfo(raul.getContactInfo(), filePath);
//        AddContact.addContactInfo(josh.getContactInfo(), filePath);
//        AddContact.addContactInfo(per.getContactInfo(), filePath);

        //Wrap this in a method that is inside a while loop
        while (continueProgram) {
            switchOptions(filePath, readFile);
            boolean moreSelections = FileIO.yesNo("Would you like to make another selection?");
            if (!moreSelections) {
                System.out.println("\nExiting program...");
                continueProgram = false;
            }
        }


    }

    public static void switchOptions(Path filePath, List<String> readFile) {
        switch (FileIO.getMenuChoice()) {
            case 1:
                ReadContacts.printOnePerLine(readFile);
                break;
            case 2: //Add Contact
                List<String> newContact = FileIO.addNewContactInput();
                Contacts newPerson = new Contacts(newContact.get(0), newContact.get(1), newContact.get(2), newContact.get(3));
                AddContact.addContactToFile(newPerson.getContactInfo(), filePath);
                break;
            case 3:
                String userSearch = FileIO.getString("Enter the name you would like to search");
                System.out.println(ReadContacts.searchContact(userSearch, readFile));
                break;
        }
    }



}
