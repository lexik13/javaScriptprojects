//Alexis Krueger CMSC 215 6389, June 25 2024 

package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Project3 extends Application {
	/** Contains: 
	 *  GUI Illustration
	 * 	Trip cost object
	 */
    private TextField distanceField;
    private ComboBox<String> distanceUnitComboBox;
    private TextField gasolineCostField;
    private ComboBox<String> gasolineUnitComboBox;
    private TextField gasMileageField;
    private ComboBox<String> gasMileageUnitComboBox;
    private TextField hotelCostField;
    private TextField foodCostField;
    private TextField daysField;
    private TextField attractionsField;
    private Button calculateButton;
    private Label outputLabel;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Trip Cost Calculator");

        
        GridPane grid = new GridPane(); //  UI components
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 20, 20, 20));

        
        distanceField = new TextField(); // Distance input
        distanceField.setPromptText("Distance");

        distanceUnitComboBox = new ComboBox<>();
        distanceUnitComboBox.getItems().addAll("miles", "kilometers");
        distanceUnitComboBox.setValue("miles");

        grid.addRow(0, new Label("Distance:"), distanceField, distanceUnitComboBox);

        
        gasolineCostField = new TextField(); // Gasoline cost input
        gasolineCostField.setPromptText("Gasoline Cost");

        gasolineUnitComboBox = new ComboBox<>();
        gasolineUnitComboBox.getItems().addAll("dollars per gallon", "dollars per liter");
        gasolineUnitComboBox.setValue("dollars per gallon");

        grid.addRow(1, new Label("Gasoline Cost:"), gasolineCostField, gasolineUnitComboBox);

       
        gasMileageField = new TextField();  // Gas mileage input
        gasMileageField.setPromptText("Gas Mileage");

        gasMileageUnitComboBox = new ComboBox<>();
        gasMileageUnitComboBox.getItems().addAll("miles per gallon", "kilometers per liter");
        gasMileageUnitComboBox.setValue("miles per gallon");

        grid.addRow(2, new Label("Gas Mileage:"), gasMileageField, gasMileageUnitComboBox);

        
        hotelCostField = new TextField(); // Hotel cost per day input
        hotelCostField.setPromptText("Hotel Cost per Day");

        grid.addRow(3, new Label("Hotel Cost per Day:"), hotelCostField);

        
        foodCostField = new TextField(); // Food cost per day input
        foodCostField.setPromptText("Food Cost per Day");

        grid.addRow(4, new Label("Food Cost per Day:"), foodCostField);

        
        daysField = new TextField(); // Number of days input
        daysField.setPromptText("Number of Days");

        grid.addRow(5, new Label("Number of Days:"), daysField);

        
        attractionsField = new TextField(); // Attractions cost input
        attractionsField.setPromptText("Attractions Cost");

        grid.addRow(6, new Label("Attractions Cost:"), attractionsField);

        
        calculateButton = new Button("Calculate"); // Calculate button
        calculateButton.setOnAction(e -> calculateTripCost());

        
        outputLabel = new Label(); // Output label

        
        VBox vbox = new VBox(10); // Add components to VBox
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(grid, calculateButton, outputLabel);

        // Set scene and customizing
        Scene scene = new Scene(vbox, 400, 400, Color.BLANCHEDALMOND);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void calculateTripCost() {
        try {
           
            double distance = Double.parseDouble(distanceField.getText());  // Read input values
            double gasolineCost = Double.parseDouble(gasolineCostField.getText());
            double gasMileage = Double.parseDouble(gasMileageField.getText());
            double hotelCost = Double.parseDouble(hotelCostField.getText());
            double foodCost = Double.parseDouble(foodCostField.getText());
            int numberOfDays = Integer.parseInt(daysField.getText());
            double attractionsCost = Double.parseDouble(attractionsField.getText());

            // Determine selected units from combo boxes
            String distanceUnit = distanceUnitComboBox.getValue();
            String gasolineUnit = gasolineUnitComboBox.getValue();
            String gasMileageUnit = gasMileageUnitComboBox.getValue();

            // Convert units based on selections
            if (distanceUnit.equals("kilometers")) {
                distance *= TripCost.KILOMETERS_PER_MILE; // Convert kilometers to miles
            }
            if (gasolineUnit.equals("dollars per liter")) {
                gasolineCost /= TripCost.LITERS_PER_GALLON; // Convert dollars per liter to dollars per gallon
            }
            if (gasMileageUnit.equals("kilometers per liter")) {
                gasMileage = TripCost.convertGasMileage(gasMileage); // Convert kilometers per liter to miles per gallon
            }

            TripCost trip = new TripCost(distance, gasolineCost, gasMileage, // Trip cost object
                                         hotelCost, foodCost, numberOfDays, attractionsCost);
            double totalCost = trip.computeTotalTripCost();

           
            outputLabel.setText(String.format("Total Trip Cost: $%.2f", totalCost)); // Display calculated cost

        } catch (NumberFormatException e) {   // Exception handler
            outputLabel.setText("Please enter valid numbers for all fields.");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
