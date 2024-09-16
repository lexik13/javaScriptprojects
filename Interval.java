// Alexis Krueger, CMSC 215 6381, 07.09.2024
package application;

import java.util.Comparator;

/**
 * Represents an INTERVAL object with the following functionalities:
 * <ul>
 * <li>Constructor: Initializes an INTERVAL object with start and end points.</li>
 * <li>WITHIN method: Checks if an object of the generic type parameter is inside the INTERVAL object.</li>
 * <li>SUBINTERVAL method: Determines if a given interval is a subinterval or within the INTERVAL.</li>
 * <li>OVERLAPS method: Checks if a given interval overlaps with the INTERVAL.</li>
 * </ul>
 */
/**
 * Represents an interval with start and end points of generic type T, which must be Comparable.
 * Provides methods to check if a value is within the interval, if another interval is a subinterval,
 * and if two intervals overlap.
 *
 * @param <T> The type of the interval endpoints, which must be Comparable.
 */
public class Interval<T extends Comparable<T>> implements Comparator<Interval<T>> {
    private T start;
    private T end;

    /**
     * Constructs an Interval object with specified start and end points.
     *
     * @param start The start point of the interval.
     * @param end   The end point of the interval.
     */
    public Interval(T start, T end) {
        this.start = start;
        this.end = end;
    }

    /**
     * Checks if a value is within the interval, including endpoints.
     *
     * @param value The value to check.
     * @return true if the value is within the interval (inclusive of endpoints), false otherwise.
     */
    public boolean within(T value) {
        return (value.compareTo(start) >= 0) && (value.compareTo(end) <= 0);
    }

    /**
     * Checks if another interval is a subinterval of this interval.
     *
     * @param other The interval to check.
     * @return true if the other interval is entirely within this interval, false otherwise.
     */
    public boolean subinterval(Interval<T> other) {
        return this.start.compareTo(other.getStart()) <= 0 && this.end.compareTo(other.getEnd()) >= 0;
    }

    /**
     * Checks if two intervals overlap.
     *
     * @param other The interval to check for overlap with this interval.
     * @return true if the two intervals overlap, false otherwise.
     */
    public boolean overlaps(Interval<T> other) {
        return (this.start.compareTo(other.getEnd()) < 0 && this.end.compareTo(other.getStart()) > 0) ||
               (other.getStart().compareTo(this.end) < 0 && other.getEnd().compareTo(this.start) > 0);
    }

    /**
     * Gets the start point of the interval.
     *
     * @return The start point.
     */
    public T getStart() {
        return start;
    }

    /**
     * Gets the end point of the interval.
     *
     * @return The end point.
     */
    public T getEnd() {
        return end;
    }

    /**
     * Compares two Interval objects for order.
     *
     * @param interval1 The first Interval object to be compared.
     * @param interval2 The second Interval object to be compared.
     * @return a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.
     */
    @Override
    public int compare(Interval<T> interval1, Interval<T> interval2) {
        int startComparison = interval1.getStart().compareTo(interval2.getStart());
        if (startComparison != 0) {
            return startComparison;
        }
        return interval1.getEnd().compareTo(interval2.getEnd());
    }
}
