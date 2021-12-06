package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
    Button button = new Button();
    @FXML
    public void onMouseEnter(){
        button.setOpacity(1);
    }
    @FXML
    public void onMouseExit(){
        button.setOpacity(0.8);
    }

    @FXML
    public void printCalender(){
        try {
            int month = Integer.parseInt(monthField.getText());
            int year = Integer.parseInt(yearField.getText());
            printMonth(month,year);

        }catch (Exception e){
            result.setText("Please, Enter A Valid Values");
        }

    }

    private void printMonth(int month,int year) {
        printMonthTitle( month,year);
        printMonthBody(month,year);
    }

    private void printMonthBody(int month,int year) {
        int numOfDaysInMonth = getNumOfDaysInMonth(month,year);
        int startDay = getStartDay(month,year);
        String r = "\n";
        for (int i = 0; i < startDay; i++) {
            r += "       ";
        }
        for (int i = 1; i <= numOfDaysInMonth; i++) {
            if(i<10)
                r+= String.format("%6d",i);
            else r+= String.format("%5d",i);
            if((startDay + i) % 7 == 0)
                r+="\n";
        }
        result.setText(result.getText() + r);
    }

    private int getNumOfDaysInMonth(int month,int year) {
        if(month == 2){
            if(isLeapYear(year)) return 29;
            else return 28;
        }
        int[] _30 = {4,6,9,11};
        for (int i : _30){
            if(month == i)
                return 30;
        }
       return 31;
    }

    private int getStartDay(int month,int year) {
        // January 1, 1500 was the 1st day of the year 1500 in the Gregorian calendar.
        // There were 364 days remaining until the end of the year.
        // The day of the week was Monday == 3

        return (getTotalNumOfDays(month,year) + 3)%7;
    }

    private int getTotalNumOfDays(int month,int year) {
        int numOfDaysInMonth = getNumOfDaysInMonth(month,year);
        boolean leapYear = isLeapYear(year);
        int total = 0;
        // add the num of days from the previous years from 1500
        for (int i = 1500; i < year; i++) {
            if(isLeapYear(i))
                total += 366;
            else total += 365;
        }
        // add the num of days of the current year till the current month
        for (int i = 1; i < month; i++)
            total += getNumOfDaysInMonth(i,year);

        return total;
    }

    private boolean isLeapYear(int year) {
        /*
        * pseudocode
        * if (year is not divisible by 4) then (it is a common year)
            else if (year is not divisible by 100) then (it is a leap year)
            else if (year is not divisible by 400) then (it is a common year)
            else (it is a leap year)
        * */
        if(year % 4 != 0) return false;
        if (year % 100 != 0) return true;
        if(year % 400 != 0) return false;
        return true;
    }

    private void printMonthTitle(int month,int year) {
        String monthName = getMonthName(month);
        String r = monthName + "   "+ year;
        r+= "\n********************";
        r+= "\n Fri  Sat  Sun  Mon  Tue  Wed  Thu";
        result.setText(r);
    }

    private String getMonthName(int month) {

        return switch (month){
            case 1 -> "January";
            case 2 -> "February";
            case 3 -> "March";
            case 4 -> "April";
            case 5 -> "May";
            case 6 -> "June";
            case 7 -> "July";
            case 8 -> "August";
            case 9 -> "September";
            case 10 -> "October";
            case 11 -> "November";
            case 12 -> "December";
            default -> null;
        };
    }
}
