package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    TextField monthField = new TextField();
    @FXML
    TextField yearField = new TextField();
    @FXML
    Label result = new Label();
    @FXML
    public void printCalender(){
        int month = Integer.parseInt(monthField.getText());
        int year = Integer.parseInt(yearField.getText());
        printMonth(month,year);
    }

    private void printMonth(int month,int year) {
        printMonthTitle( month,year);
        printMonthBody(month,year);
    }

    private void printMonthBody(int month,int year) {
        int startDay = getStartDay(month,year);
        int numOfDaysInMonth = getNumOfDaysInMonth(month,year);
    }

    private int getNumOfDaysInMonth(int month,int year) {
        boolean leapYear = isLeapYear(year);
        return 0;
    }

    private int getStartDay(int month,int year) {
        int totalNumOfDays = getTotalNumOfDays(month,year);
        return 0;
    }

    private int getTotalNumOfDays(int month,int year) {
        int numOfDaysInMonth = getNumOfDaysInMonth(month,year);
        boolean leapYear = isLeapYear(year);
        return 0;
    }

    private boolean isLeapYear(int year) {
        return false;
    }

    private void printMonthTitle(int month,int year) {
        String monthName = getMonthName(month);
    }

    private String getMonthName(int month) {
        return null;
    }
}
