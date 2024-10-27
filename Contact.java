public class Contact {
    // Fields
    private final String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    // Constructor
    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        // Contact ID validation
        if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException("Contact ID cannot be null and must be 10 characters or fewer.");
        }
        this.contactId = contactId;

        // First name validation
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("First name cannot be null and must be 10 characters or fewer.");
        }
        this.firstName = firstName;

        // Last name validation
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last name cannot be null and must be 10 characters or fewer.");
        }
        this.lastName = lastName;

        // Phone number validation
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone number cannot be null and must be exactly 10 digits.");
        }
        this.phone = phone;

        // Address validation
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address cannot be null and must be 30 characters or fewer.");
        }
        this.address = address;
    }

    // Getters
    public String getContactId() {
        return contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    // Setters (except for contactId since it's not updatable)
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("First name cannot be null and must be 10 characters or fewer.");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last name cannot be null and must be 10 characters or fewer.");
        }
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone number cannot be null and must be exactly 10 digits.");
        }
        this.phone = phone;
    }

    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address cannot be null and must be 30 characters or fewer.");
        }
        this.address = address;
    }
}
