package com.example.appointment;

import java.util.HashMap;
import java.util.Map;

public class AppointmentService {
    private final Map<String, Appointment> appointments = new HashMap<>();

    public void addAppointment(Appointment appointment) {
        if (appointments.putIfAbsent(appointment.getAppointmentId(), appointment) != null) {
            throw new IllegalArgumentException("Appointment with this ID already exists.");
        }
    }

    public void deleteAppointment(String appointmentId) {
        if (appointments.remove(appointmentId) == null) {
            throw new IllegalArgumentException("No appointment found with this ID.");
        }
    }

    public Appointment getAppointment(String appointmentId) {
        return appointments.get(appointmentId);
    }
}
