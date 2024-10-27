import java.util.HashMap;
import java.util.Map;

public class ContactService {
    // Store contacts in a HashMap where the key is the contact ID.
    private Map<String, Contact> contacts;

    // Constructor
    public ContactService() {
        contacts = new HashMap<>();
    }

    // Add a new contact
    public void addContact(Contact contact) {
        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact ID must be unique.");
        }
        contacts.put(contact.getContactId(), contact);
    }

    // Delete a contact by ID
    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID does not exist.");
        }
        contacts.remove(contactId);
    }

    // Update the firstName of a contact
    public void updateFirstName(String contactId, String firstName) {
        Contact contact = getContactById(contactId);
        contact.setFirstName(firstName);
    }

    // Update the lastName of a contact
    public void updateLastName(String contactId, String lastName) {
        Contact contact = getContactById(contactId);
        contact.setLastName(lastName);
    }

    // Update the phone number of a contact
    public void updatePhone(String contactId, String phone) {
        Contact contact = getContactById(contactId);
        contact.setPhone(phone);
    }

    // Update the address of a contact
    public void updateAddress(String contactId, String address) {
        Contact contact = getContactById(contactId);
        contact.setAddress(address);
    }

    // Helper method to get a contact by ID and handle non-existing IDs
    private Contact getContactById(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID does not exist.");
        }
        return contacts.get(contactId);
    }
}