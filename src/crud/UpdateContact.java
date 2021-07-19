package crud;

import java.util.ArrayList;
import java.util.List;

public class UpdateContact {

    public static List<String> removeContactFromList (List<String> contactList, String updatedInfo, String selectedInfo) {
        List <String> listWithUpdatedUser = new ArrayList<>();
        for (String contact : contactList){
            if(contact.toLowerCase().contains(selectedInfo.toLowerCase())){
                listWithUpdatedUser.add(updatedInfo);
                continue;
            }
            listWithUpdatedUser.add(contact);
        }
        return listWithUpdatedUser;
    }

}
