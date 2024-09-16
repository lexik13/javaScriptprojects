// Alexis Krueger, June 25 2024, CMSC 215 6389

package application;
public class TripCost { 
/** Contains:
 * Trip cost object
 * Method computes and returns the total trip cost
 */
	public static final double KILOMETERS_PER_MILE = 1.609347;
	public static final double LITERS_PER_GALLON = 3.78541178;

	
	private double distance;
	private double gasolineCost;
	private double gasMileage;
	private double hotelCost;
	private double foodCost;
	private int numberOfDays;
	private double attractionsCost;
	
	// Constructor containing trip cost object: represents the currency/cost of the trip
	public TripCost(double distance, double gasolineCost, double gasMileage, double hotelCost, double foodCost, int numberOfDays, double attractionsCost) {
		this.distance = distance;
		this.gasolineCost = gasolineCost;
		this.gasMileage = gasMileage;
		this.hotelCost = hotelCost;
		this.foodCost = foodCost;
		this.numberOfDays = numberOfDays;
		this.attractionsCost = attractionsCost;				
	} 
	
	public double computeTotalTripCost() {
		double fuelCost = (distance / gasMileage) * gasolineCost;
		double HotelAndFoodCost = + (hotelCost + foodCost) * numberOfDays;
		return fuelCost + HotelAndFoodCost + attractionsCost;
	}
	
	public double convertDistanceToMiles(double distance) {
		return distance / KILOMETERS_PER_MILE;
	}

	public double convertGasolineCost(double cost) {
		return cost * LITERS_PER_GALLON;
	}
	
	public static double convertGasMileage(double mileage) {
		double mpgEquiv = (mileage / KILOMETERS_PER_MILE) * LITERS_PER_GALLON;
		return mpgEquiv;
	}
}
