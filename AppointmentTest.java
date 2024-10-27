package com.example.appointment;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class HairAppointmentTest {

    private static final String VALID_APPOINTMENT_ID = "H123456";
    private static final Date VALID_APPOINTMENT_DATE = new Date(System.currentTimeMillis() + 86400000);
    private static final String VALID_DESCRIPTION = "Haircut and styling";
    private static final String VALID_STYLIST = "Jessica Eddy";

    @Test
    public void testCreateValidHairAppointment() {
        HairAppointment hairAppointment = new HairAppointment(VALID_APPOINTMENT_ID, VALID_APPOINTMENT_DATE, VALID_DESCRIPTION, VALID_STYLIST);

        assertNotNull(hairAppointment);
        assertEquals(VALID_APPOINTMENT_ID, hairAppointment.getAppointmentId());
        assertEquals(VALID_APPOINTMENT_DATE, hairAppointment.getAppointmentDate());
        assertEquals(VALID_DESCRIPTION, hairAppointment.getDescription());
        assertEquals(VALID_STYLIST, hairAppointment.getStylist());
    }

     //Add more tests for invalid cases if needed
}
