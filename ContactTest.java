import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContactTest {

    private Contact contact;

    @BeforeEach
    void setUp() {
        contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
    }

    // Test constructor
    @Test
    void testContactCreationSuccess() {
        assertNotNull(contact);
        assertEquals("1234567890", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test
    void testContactCreationInvalidContactId() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St");
        });
        assertEquals("Contact ID cannot be null and must be 10 characters or fewer.", exception.getMessage());
    }

    @Test
    void testContactCreationNullContactId() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Doe", "1234567890", "123 Main St");
        });
        assertEquals("Contact ID cannot be null and must be 10 characters or fewer.", exception.getMessage());
    }

    @Test
    void testFirstNameTooLong() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "ThisNameIsTooLong", "Doe", "1234567890", "123 Main St");
        });
        assertEquals("First name cannot be null and must be 10 characters or fewer.", exception.getMessage());
    }

    @Test
    void testLastNameTooLong() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", "ThisLastNameIsTooLong", "1234567890", "123 Main St");
        });
        assertEquals("Last name cannot be null and must be 10 characters or fewer.", exception.getMessage());
    }

    @Test
    void testPhoneNotTenDigits() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", "Doe", "12345678", "123 Main St");
        });
        assertEquals("Phone number cannot be null and must be exactly 10 digits.", exception.getMessage());
    }

    @Test
    void testNullPhone() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", "Doe", null, "123 Main St");
        });
        assertEquals("Phone number cannot be null and must be exactly 10 digits.", exception.getMessage());
    }

    @Test
    void testAddressTooLong() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", "Doe", "1234567890", "This address is way too long and exceeds 30 characters.");
        });
        assertEquals("Address cannot be null and must be 30 characters or fewer.", exception.getMessage());
    }

    // Test setters
    @Test
    void testSetFirstNameSuccess() {
        contact.setFirstName("Jane");
        assertEquals("Jane", contact.getFirstName());
    }

    @Test
    void testSetFirstNameTooLong() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName("ThisNameIsTooLong");
        });
        assertEquals("First name cannot be null and must be 10 characters or fewer.", exception.getMessage());
    }

    @Test
    void testSetLastNameSuccess() {
        contact.setLastName("Smith");
        assertEquals("Smith", contact.getLastName());
    }

    @Test
    void testSetLastNameTooLong() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName("ThisLastNameIsTooLong");
        });
        assertEquals("Last name cannot be null and must be 10 characters or fewer.", exception.getMessage());
    }

    @Test
    void testSetPhoneSuccess() {
        contact.setPhone("0987654321");
        assertEquals("0987654321", contact.getPhone());
    }

    @Test
    void testSetPhoneInvalid() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone("98765");
        });
        assertEquals("Phone number cannot be null and must be exactly 10 digits.", exception.getMessage());
    }

    @Test
    void testSetAddressSuccess() {
        contact.setAddress("456 New Ave");
        assertEquals("456 New Ave", contact.getAddress());
    }

    @Test
    void testSetAddressTooLong() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress("This address is way too long and exceeds 30 characters.");
        });
        assertEquals("Address cannot be null and must be 30 characters or fewer.", exception.getMessage());
    }
}