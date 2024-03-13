package seedu.address.model.appointment;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.TypicalPersons.ALICE;

import java.util.UUID;

import org.junit.jupiter.api.Test;

public class AppointmentTest {

    @Test
    public void getters() {
        AppointmentTime appointmentTime = new AppointmentTime("10/02/2024 11am-2pm");
        Appointment appointment = new Appointment(ALICE, appointmentTime);

        // same UUID
        assertTrue(appointment.getID() instanceof UUID);

        // same person
        assertTrue(appointment.getPerson().isSamePerson(ALICE));

        // same time
        assertTrue(appointment.getAppointmentTime().equals(appointmentTime));

        // same time, different object
        assertTrue(appointment.getAppointmentTime().equals(new AppointmentTime("10/02/2024 11am - 2pm")));
    }

    @Test
    public void isSameAppointment() {
        AppointmentTime appointmentTime = new AppointmentTime("10/02/2024 11am-2pm");
        Appointment appointment = new Appointment(ALICE, appointmentTime);
        // same object -> returns true
        assertTrue(appointment.equals(appointment));

        // null -> returns false
        assertFalse(ALICE.isSamePerson(null));
    }
}
