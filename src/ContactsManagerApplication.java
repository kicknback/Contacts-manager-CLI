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

        System.out.println("\nYou have entered the contacts manager program...");

        while (continueProgram) {
            Path filePath = PathClass.getPath( "src","contacts.txt").toAbsolutePath();
            List<String> readFile = ReadContacts.readFromFile(filePath);

            switchOptions(filePath, readFile);
            boolean moreSelections = FileIO.yesNo("Would you like to make another menu selection?");
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
                System.out.println("First name          |   Last Name           |   Phone #             |   Address\n");
                System.out.println("--------------------------------------------------------------------------------------------------------------------");
                ReadContacts.printOnePerLine(readFile);
                break;
            case 2: //Add Contact
                List<String> newContact = FileIO.addNewContactInput();
                Contacts newPerson = new Contacts(newContact.get(0), newContact.get(1), newContact.get(2), newContact.get(3));
                AddContact.addContactToFile(newPerson.getContactInfo(), filePath);
                System.out.println("\n--- User Added ---");
                break;
            case 3:
                String userSearch = FileIO.getString("Enter the user you would like to search");
                System.out.println("\n" + ReadContacts.searchContact(userSearch, readFile));
                break;
            case 4:
                String userDelete = FileIO.getString("Enter the user you would like to remove");
                if (FileIO.yesNo(ReadContacts.searchContact(userDelete, readFile) + "\n\nAre you sure you want to remove this record?")) {
                    DeleteContact.removeContactFromList(readFile, userDelete/*ReadContacts.searchContact(userDelete, readFile)*/, filePath);
                    System.out.println("\n---User removed---");
                }
                break;
            case 5:
                String userUpdate = FileIO.getString("Enter the user you would like to update");
                String selection = ReadContacts.searchContact(userUpdate, readFile);
                int selectionAmount = selection.split("\n").length;
                if(selectionAmount > 1){
                    System.out.println("Cannot update multiple records");
                    break;
                }
                if (selection.equalsIgnoreCase("That user was not found.")) {
                    System.out.println("\nThat user was not found.");
                    break;
                }
                if (FileIO.yesNo( selection + "\n\nAre you sure you want to change this record?")) {
                    List<String> updatedContact = FileIO.addNewContactInput();
                    Contacts updatedPerson = new Contacts(updatedContact.get(0), updatedContact.get(1), updatedContact.get(2), updatedContact.get(3));
                    List<String> newReadFile = UpdateContact.removeContactFromList(readFile, updatedPerson.getContactInfo().get(0), userUpdate);
                    DeleteContact.updateListToFile(newReadFile, filePath);
                    System.out.println("\n--- User changed ---");
                }
                break;
            case 6:
                break;

        }
    }

}
