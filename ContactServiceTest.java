import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactServiceTest {

    private ContactService contactService;
    private Contact contact;

    @BeforeEach
    void setUp() {
        // Set up the contact service and add a default contact
        contactService = new ContactService();
        contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
    }

    // Test adding a new contact successfully
    @Test
    void testAddContactSuccess() {
        Contact newContact = new Contact("0987654321", "Jane", "Smith", "0987654321", "456 New Ave");
        contactService.addContact(newContact);
        assertEquals("Jane", contactService.getContactById("0987654321").getFirstName());
    }

    // Test adding a contact with a duplicate ID
    @Test
    void testAddContactDuplicateId() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            contactService.addContact(new Contact("1234567890", "Jane", "Smith", "0987654321", "456 New Ave"));
        });
        assertEquals("Contact ID must be unique.", exception.getMessage());
    }

    // Test deleting an existing contact successfully
    @Test
    void testDeleteContactSuccess() {
        contactService.deleteContact("1234567890");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            contactService.getContactById("1234567890");
        });
        assertEquals("Contact ID does not exist.", exception.getMessage());
    }

    // Test deleting a non-existing contact
    @Test
    void testDeleteContactNotFound() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            contactService.deleteContact("nonexistentID");
        });
        assertEquals("Contact ID does not exist.", exception.getMessage());
    }

    // Test updating the first name of an existing contact successfully
    @Test
    void testUpdateFirstNameSuccess() {
        contactService.updateFirstName("1234567890", "Johnny");
        assertEquals("Johnny", contactService.getContactById("1234567890").getFirstName());
    }

    // Test updating the last name of an existing contact successfully
    @Test
    void testUpdateLastNameSuccess() {
        contactService.updateLastName("1234567890", "Smith");
        assertEquals("Smith", contactService.getContactById("1234567890").getLastName());
    }

    // Test updating the phone number of an existing contact successfully
    @Test
    void testUpdatePhoneSuccess() {
        contactService.updatePhone("1234567890", "0987654321");
        assertEquals("0987654321", contactService.getContactById("1234567890").getPhone());
    }

    // Test updating the address of an existing contact successfully
    @Test
    void testUpdateAddressSuccess() {
        contactService.updateAddress("1234567890", "789 New St");
        assertEquals("789 New St", contactService.getContactById("1234567890").getAddress());
    }

    // Test updating a contact with a non-existing ID
    @Test
    void testUpdateContactNotFound() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateFirstName("nonexistentID", "Johnny");
        });
        assertEquals("Contact ID does not exist.", exception.getMessage());
    }
}
