package com.example.appointment;

import java.util.Date;

public class Appointment {
    private final String appointmentId;
    private final Date appointmentDate;
    private final String description;

    public Appointment(String appointmentId, Date appointmentDate, String description) {
        validateInputs(appointmentId, appointmentDate, description);
        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;
        this.description = description;
    }

    private void validateInputs(String appointmentId, Date appointmentDate, String description) {
        if (appointmentId == null || appointmentId.length() > 10) {
            throw new IllegalArgumentException("Appointment ID cannot be null and must be 10 characters or fewer.");
        }
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Appointment date cannot be null and must not be in the past.");
        }
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description cannot be null and must be 50 characters or fewer.");
        }
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public Date getAppointmentDate() {
        return new Date(appointmentDate.getTime());
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return String.format("Appointment{id='%s', date=%s, description='%s'}", appointmentId, appointmentDate, description);
    }
}
