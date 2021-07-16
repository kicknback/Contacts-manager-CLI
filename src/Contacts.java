import java.util.ArrayList;
import java.util.List;

public class Contacts {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private List<String> contactInfo = new ArrayList<>();
    private String stringifyContactInfo = "";

    public Contacts(String firstName, String lastName, String phoneNumber, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;

        stringifyContactInfo = this.firstName + " | " + this.lastName + " | " + this.phoneNumber + " | " + this.address;
        setContactInfo();
    }

    public Contacts() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getContactInfo() {
        return this.contactInfo;
    }

    public void setContactInfo() {
        this.contactInfo.add(stringifyContactInfo);
    }
}
