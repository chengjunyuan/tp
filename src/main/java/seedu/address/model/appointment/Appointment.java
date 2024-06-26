package seedu.address.model.appointment;

import java.util.UUID;

/**
 * Represents an Appointment in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Appointment implements Comparable<Appointment> {

    // Data fields
    private final UUID id;
    private final UUID personId;
    private final AppointmentTime appointmentTime;

    /**
     * Every field must be present and not null.
     */
    public Appointment(UUID personId, AppointmentTime appointmentTime) {
        this.id = UUID.randomUUID();
        this.appointmentTime = appointmentTime;
        this.personId = personId;
    }

    /**
     * Every field must be present and not null.
     */
    public Appointment(UUID id, UUID personId, AppointmentTime appointmentTime) {
        this.id = id;
        this.appointmentTime = appointmentTime;
        this.personId = personId;
    }


    public UUID getId() {
        return id;
    }

    public String getIdString() {
        return id.toString();
    }

    public UUID getPersonId() {
        return personId;
    }

    public String getPersonIdString() {
        return personId.toString();
    }

    public AppointmentTime getAppointmentTime() {
        return appointmentTime;
    }

    public String getAppointmentTimeString() {
        return appointmentTime.toString();
    }

    public String getAppointmentTimeStringForJson() {
        return appointmentTime.getFormattedDateTime();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Appointment)) {
            return false;
        }

        Appointment otherAppointment = (Appointment) other;
        boolean samePersonId = personId.equals(otherAppointment.getPersonId());
        boolean sameDate = appointmentTime.equals(otherAppointment.getAppointmentTime());
        return (samePersonId && sameDate);
    }

    /**
     * Checks for overlap in timing of 2 appointments
     */
    public boolean overlap(Appointment other) {
        boolean samePersonId = personId.equals((other.getPersonId()));
        if (samePersonId) {
            AppointmentTime otherTime = other.getAppointmentTime();

            if (!otherTime.getAppointmentDate().equals(appointmentTime.getAppointmentDate())) {
                return false;
            }

            return otherTime.getStartTime().isBefore(appointmentTime.getEndTime())
                && appointmentTime.getStartTime().isBefore(otherTime.getEndTime());
        }
        return false;
    }

    @Override
    public int compareTo(Appointment o) {
        if (o == null) {
            return 1;
        }

        return o.appointmentTime.compareTo(this.appointmentTime);
    }

}
