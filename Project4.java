// Alexis Krueger, CMSC 215 6381, 07.09.2024

package application;
	
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

/**
 * Contains functionality for:
 * <ul>
 * <li>Button CompareIntervals: Compares two intervals and outputs a specified message.</li>
 * <li>Button CheckTime: Checks if the time is within intervals and outputs a specified message.</li>
 * </ul>
 */
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * JavaFX application for checking time intervals and comparing them.
 */
public class Project4 extends Application {
    private Button CompareIntervals;
    private Button CheckTime;
    private TextField startTime1;
    private TextField endTime1;
    private TextField startTime2;
    private TextField endTime2;
    private Label outputLabel1;
    private Label outputLabel2;
    private TextField checkTime;
    private Label labelStartTime;
    private Label labelEndTime;
    private TextField intervalMessage;

    /**
     * Method to start the JavaFX application, initializing UI components and handling user interactions.
     *
     * @param primaryStage The primary stage for this JavaFX application.
     */
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Time Interval Checker");

        // GridPane for UI components
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 20, 20, 20));

        // Labels for Start Time and End Time
        Label labelStartTime = new Label("Start Time");
        Label labelEndTime = new Label("End Time");
        grid.add(labelStartTime, 1, 1);
        grid.add(labelEndTime, 2, 1);

        // Interval 1 inputs
        startTime1 = new TextField();
        startTime1.setPromptText("HH:MM AM/PM"); // Prompts to ensure the user enters the correct format
        endTime1 = new TextField();
        endTime1.setPromptText("HH:MM AM/PM");
        grid.addRow(2, new Label("Time Interval 1"), startTime1, endTime1);

        // Interval 2 inputs
        startTime2 = new TextField();
        startTime2.setPromptText("HH:MM AM/PM"); // Prompts to ensure the user enters the correct format
        endTime2 = new TextField();
        endTime2.setPromptText("HH:MM AM/PM");
        grid.addRow(3, new Label("Time Interval 2"), startTime2, endTime2);

        // Compare Intervals Button
        CompareIntervals = new Button("Compare Intervals");
        CompareIntervals.setOnAction(e -> compareIntervals());
        CompareIntervals.setStyle("-fx-pref-width: 200px;"); // Aligning and centering the buttons

        outputLabel1 = new Label();
        grid.add(CompareIntervals, 1, 4, 2, 1);
        GridPane.setHalignment(CompareIntervals, HPos.CENTER);

        // Check Time components
        Label labelCheckTime = new Label("Time to Check");
        checkTime = new TextField();
        checkTime.setPromptText("HH:MM AM/PM");
        outputLabel2 = new Label();

        grid.addRow(5, labelCheckTime, checkTime, outputLabel2);

        CheckTime = new Button("Check Time");
        CheckTime.setOnAction(e -> {
            String result = checkTime();
            intervalMessage.setText(result);
        });

        CheckTime.setStyle("-fx-pref-width: 200px;"); // Aligning and centering the buttons
        grid.add(CheckTime, 1, 6, 2, 1);
        GridPane.setHalignment(CheckTime, HPos.CENTER);

        intervalMessage = new TextField();
        grid.add(intervalMessage, 1, 7, 3, 1);
        intervalMessage.setEditable(false);

        // HBox to contain the GridPane
        HBox hbox = new HBox(10);
        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().add(grid); // Add grid to HBox

        // Set hbox as the root and scene
        Scene scene = new Scene(hbox, 600, 400, Color.LAVENDER);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Method that corresponds to the Compare Intervals button's action.
     * Parses input fields to create Time and Interval objects, then compares the intervals.
     * Updates intervalMessage TextField with comparison result.
     */
    private void compareIntervals() {
        try {
            // Parse and create Time objects for intervals
            Time start1 = new Time(startTime1.getText().trim());
            Time end1 = new Time(endTime1.getText().trim());
            Time start2 = new Time(startTime2.getText().trim());
            Time end2 = new Time(endTime2.getText().trim());

            // Create Interval objects
            Interval<Time> interval1 = new Interval<>(start1, end1);
            Interval<Time> interval2 = new Interval<>(start2, end2);

            // Perform comparisons between Intervals 1 and 2
            String message;
            if (interval2.subinterval(interval1)) {
                message = "Interval 2 is a sub-interval of interval 1";
            } else if (interval1.subinterval(interval2)) {
                message = "Interval 1 is a sub-interval of interval 2";
            } else if (interval1.overlaps(interval2)) {
                message = "The intervals overlap";
            } else {
                message = "The intervals are disjoint";
            }

            intervalMessage.setText(message);

        } catch (InvalidTime e) {
            outputLabel1.setText("Invalid time format entered.");
        }
    }

    /**
     * Method that corresponds to the Check Time button's action.
     * Parses input field to create a Time object, then checks if the time is within each interval.
     *
     * @return A message indicating which intervals (if any) contain the entered time.
     */
    private String checkTime() {
        try {
            Time check = new Time(checkTime.getText().trim());

            Time start1 = new Time(startTime1.getText().trim());
            Time end1 = new Time(endTime1.getText().trim());
            Time start2 = new Time(startTime2.getText().trim());
            Time end2 = new Time(endTime2.getText().trim());

            Interval<Time> interval1 = new Interval<>(start1, end1);
            Interval<Time> interval2 = new Interval<>(start2, end2);

            boolean inInterval1 = interval1.within(check);
            boolean inInterval2 = interval2.within(check);

            if (inInterval1 && inInterval2) {
                return "Both intervals contain the time " + check.toString();
            } else if (inInterval1) {
                return "Only interval 1 contains the time " + check.toString();
            } else if (inInterval2) {
                return "Only interval 2 contains the time " + check.toString();
            } else {
                return "Neither interval contains the time " + check.toString();
            }

        } catch (InvalidTime e) {
            return "Invalid time format entered.";
        }
    }

    /**
     * Main method to launch the JavaFX application.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
