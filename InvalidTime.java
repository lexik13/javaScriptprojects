// Alexis Krueger, CMSC 215 6381, 07.09.2024

package application;

/**
 * Represents an InvalidTime object with the following components:
 * <ul>
 * <li>Instance variable: String type.</li>
 * <li>InvalidTime Constructor: Constructs an InvalidTime object accepting a string.</li>
 * <li>getMessage Method: Retrieves the message associated with the InvalidTime object.</li>
 * </ul>
 */

/**
 * Exception thrown when an invalid time format is encountered.
 */

public class InvalidTime extends Exception {
    private final String errorMessage;

    /**
     * Constructs an InvalidTime exception with the specified error message.
     *
     * @param errorMessage The error message describing the reason for the exception.
     */
    public InvalidTime(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    /**
     * Returns the error message associated with this InvalidTime exception.
     *
     * @return The error message.
     */
    @Override
    public String getMessage() {
        return this.errorMessage;
    }
}

