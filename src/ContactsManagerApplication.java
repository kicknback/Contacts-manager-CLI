import crud.AddContact;
import crud.DeleteContact;
import crud.ReadContacts;
import crud.UpdateContact;

import java.nio.file.Path;
import java.util.List;

public class ContactsManagerApplication {

    public static void main(String[] args) {

        init();

    }

    public static void init() {

        boolean continueProgram = true;

        //Wrap this in a method that is inside a while loop
        while (continueProgram) {
            Path filePath = PathClass.getPath( "src","contacts.txt").toAbsolutePath();
            List<String> readFile = ReadContacts.readFromFile(filePath);

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
                System.out.println();
                ReadContacts.printOnePerLine(readFile);
                break;
            case 2: //Add Contact
                List<String> newContact = FileIO.addNewContactInput();
                Contacts newPerson = new Contacts(newContact.get(0), newContact.get(1), newContact.get(2), newContact.get(3));
                AddContact.addContactToFile(newPerson.getContactInfo(), filePath);
                break;
            case 3:
                String userSearch = FileIO.getString("Enter the user you would like to search");
                System.out.println(ReadContacts.searchContact(userSearch, readFile));
                break;
            case 4:
                String userDelete = FileIO.getString("Enter the user you would like to remove");
                if (FileIO.yesNo(ReadContacts.searchContact(userDelete, readFile) + "\n\nAre you sure you want to remove this record?")) {
                    DeleteContact.removeContactFromList(readFile, userDelete/*ReadContacts.searchContact(userDelete, readFile)*/, filePath);
                }
                break;
            case 5:
                String userUpdate = FileIO.getString("Enter the user you would like to update");
                String selection = ReadContacts.searchContact(userUpdate, readFile);
                if (FileIO.yesNo( selection + "\n\nAre you sure you want to change this record?")) {
                    System.out.println();
                    List<String> updatedContact = FileIO.addNewContactInput();
                    Contacts updatedPerson = new Contacts(updatedContact.get(0), updatedContact.get(1), updatedContact.get(2), updatedContact.get(3));
                    List<String> newReadFile = UpdateContact.removeContactFromList(readFile, updatedPerson.getContactInfo().get(0), selection);
                    DeleteContact.updateListToFile(newReadFile, filePath);
                }
                break;
            case 6:
                break;

        }
    }

}
//        Contacts raul = new Contacts("Raul","Martinez", "915-420-6969", "123 Specific Street, City, 90210");
//        Contacts josh = new Contacts("Josh","Borreli", "915-969-9696", "9000 Specific Street, City, 90000");
//        Contacts per = new Contacts("Per","Son", "915-420-4242", "4444 Specific Ave, City, 90210");

//        AddContact.addContactInfo(raul.getContactInfo(), filePath);
//        AddContact.addContactInfo(josh.getContactInfo(), filePath);
//        AddContact.addContactInfo(per.getContactInfo(), filePath);