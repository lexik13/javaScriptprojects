// Alexis Krueger, CMSC 215 6381, 07.09.2024

package application;

/**
 * Represents a TIME object with the following characteristics:
 * <ul>
 * <li>Instance variables: hours, minutes, meridian.</li>
 * <li>TIME Constructor: Constructs a TIME object accepting hours, minutes, and meridian.</li>
 * <li>TIME Constructor: Constructs a TIME object accepting a string representation of time in HH:MM AM/PM format.</li>
 * <li>compareTo Method: Compares two TIME objects and returns the comparison result.</li>
 * <li>toString Method: Returns the string representation of the time in HH:MM format.</li>
 * </ul>
 */


/**
 * Represents a time object with hours, minutes, and meridian (AM/PM).
 * Implements Comparable to enable comparison of Time objects based on their time values.
 */
public class Time implements Comparable<Time> {
    private final int hours;
    private final int minutes;
    private final String meridian;

    /**
     * Constructs a Time object with specified hours, minutes, and meridian.
     *
     * @param hours    The hours in 12-hour format (1-12).
     * @param minutes  The minutes (0-59).
     * @param meridian The meridian (AM/PM).
     * @throws InvalidTime If the provided time format is invalid.
     */
    public Time(int hours, int minutes, String meridian) throws InvalidTime {
        validateTime(hours, minutes, meridian);

        this.hours = hours;
        this.minutes = minutes;
        this.meridian = meridian;
    }

    /**
     * Constructs a Time object from a string representation of time in "HH:MM AM/PM" format.
     *
     * @param time The string representation of time.
     * @throws InvalidTime If the provided time format is invalid.
     */
    public Time(String time) throws InvalidTime {
        String[] parts = time.split(" ");
        if (parts.length != 2) {
            throw new InvalidTime("INVALID FORMAT");
        }

        String[] hm = parts[0].split(":");
        if (hm.length != 2) {
            throw new InvalidTime("INVALID FORMAT");
        }

        try {
            int hours = Integer.parseInt(hm[0]);
            int minutes = Integer.parseInt(hm[1]);
            String meridian = parts[1];

            validateTime(hours, minutes, meridian);

            this.hours = hours;
            this.minutes = minutes;
            this.meridian = meridian;
        } catch (NumberFormatException e) {
            throw new InvalidTime("INVALID FORMAT");
        }
    }

    /**
     * Validates the provided hours, minutes, and meridian format.
     *
     * @param hours    The hours to validate.
     * @param minutes  The minutes to validate.
     * @param meridian The meridian to validate (AM/PM).
     * @throws InvalidTime If the provided time format is invalid.
     */
    private void validateTime(int hours, int minutes, String meridian) throws InvalidTime {
        if (hours < 1 || hours > 12 || minutes < 0 || minutes > 59 || (!meridian.equals("AM") && !meridian.equals("PM"))) {
            throw new InvalidTime("INVALID FORMAT");
        }
    }

    /**
     * Compares this Time object with another Time object based on their time values.
     * 
     * @param other The Time object to compare with.
     * @return A negative integer, zero, or a positive integer as this Time object is less than, equal to, or greater than the specified Time object.
     */
    @Override
    public int compareTo(Time other) {
        int thisHour = this.hours == 12 ? 0 : this.hours;
        int otherHour = other.hours == 12 ? 0 : other.hours;

        if (this.meridian.equals("PM")) {
            thisHour += 12;
        }

        if (other.meridian.equals("PM")) {
            otherHour += 12;
        }
        
        if (thisHour != otherHour) {
            return Integer.compare(thisHour, otherHour);
        } else {
            return Integer.compare(this.minutes, other.minutes);
        }
    }

    /**
     * Returns the string representation of the time in "HH:MM AM/PM" format.
     *
     * @return The string representation of the time.
     */
    @Override
    public String toString() {
        return String.format("%02d:%02d %s", hours, minutes, meridian);
    }
}
