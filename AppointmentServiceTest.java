package com.example.appointment;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class HairAppointmentServiceTest {

    @Test
    public void testAddHairAppointment() {
        AppointmentService service = new AppointmentService();
        HairAppointment hairAppointment = new HairAppointment("H123456", new Date(System.currentTimeMillis() + 86400000), "Haircut and styling", "Jessica Eddy");

        service.addAppointment(hairAppointment);

        // Verify that the appointment was added
        assertEquals(hairAppointment, service.getAppointment("H123456"));
    }

    @Test
    public void testAddDuplicateHairAppointment() {
        AppointmentService service = new AppointmentService();
        HairAppointment hairAppointment = new HairAppointment("H123456", new Date(System.currentTimeMillis() + 86400000), "Haircut and styling", "Jessica Eddy");

        service.addAppointment(hairAppointment);

        // Try adding the same appointment again
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            service.addAppointment(hairAppointment);
        });
        assertEquals("Appointment with this ID already exists.", exception.getMessage());
    }

    @Test
    public void testDeleteHairAppointment() {
        AppointmentService service = new AppointmentService();
        HairAppointment hairAppointment = new HairAppointment("H123456", new Date(System.currentTimeMillis() + 86400000), "Haircut and styling", "Jessica Eddy");

        service.addAppointment(hairAppointment);
        service.deleteAppointment("H123456");

        // Verify that the appointment was deleted
        assertNull(service.getAppointment("H123456"));
    }

    @Test
    public void testDeleteNonExistentHairAppointment() {
        AppointmentService service = new AppointmentService();

        // Try deleting a non-existent appointment
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            service.deleteAppointment("H123456");
        });
        assertEquals("No appointment found with this ID.", exception.getMessage());
    }

    @Test
    public void testGetHairAppointment() {
        AppointmentService service = new AppointmentService();
        HairAppointment hairAppointment = new HairAppointment("H123456", new Date(System.currentTimeMillis() + 86400000), "Haircut and styling", "Jessica Eddy");

        service.addAppointment(hairAppointment);

        // Verify that we can retrieve the appointment
        HairAppointment retrieved = (HairAppointment) service.getAppointment("H123456");
        assertNotNull(retrieved);
        assertEquals("H123456", retrieved.getAppointmentId());
        assertEquals("Haircut and styling", retrieved.getDescription());
        assertEquals("Jessica Eddy", retrieved.getStylist());
    }

    @Test
    public void testGetNonExistentHairAppointment() {
        AppointmentService service = new AppointmentService();

        // Verify that retrieving a non-existent appointment returns null
        assertNull(service.getAppointment("H123456"));
    }
}
