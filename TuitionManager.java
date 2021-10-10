/**
 * The UI class of this program.
 * The user may input several commands to modify their roster of students.
 * Handles all exceptions and invalid data.
 * @author Tommy Cho, Neha Gudur
 */

import java.util.Scanner;
import java.util.StringTokenizer;

public class TuitionManager {

    /**
     * A helper method to check whether the state is part of the tri-state area or not
     * @param state state the user inputted where they're living in
     * @return true if the state is NY or CT, false otherwise
     */
    public boolean stateChecker(String state){
        if (state.equals("NY") || state.equals("nY") || state.equals("Ny") || state.equals("ny") ||
                state.equals("CT") || state.equals("cT") || state.equals("Ct") || state.equals("ct")){
            return true;
        }
        else{
            System.out.println("Not part of the tri-state area.");
            return false;
        }
    }

    /**
     * A helper method to check if the credit hours are numeric or not
     * @param creditHourString credit hours of a student in string form
     * @return true if it is a number, false otherwise
     */
    public boolean isNumeric(String creditHourString) {
        if(creditHourString != null && creditHourString.matches("[-+]?\\d*\\.?\\d+"))
        {
            return true;
        }
        else{
            System.out.println("Invalid credit hours.");
            return false;
        }
    }

    /**
     * A helper method for the addHelper to check if the number of parameters (3) entered is valid
     * @param st String tokenizer from the user
     * @return true if parameters are valid, false otherwise
     */
    public boolean parameterCheckerThree(StringTokenizer st){
        if(st.countTokens() < 2){
            System.out.println("Missing data in the command line.");
            return false;
        }
        else if(st.countTokens() == 2){
            System.out.println("Credit hours missing.");
            return false;
        }
        else if(st.countTokens() != 3){
            System.out.println("Invalid number of parameters!");
            return false;
        }
        else{
            return true;
        }
    }

    /**
     * A helper method for the addHelper to check if the number of parameters (4) entered is valid
     * @param st String tokenizer from the user
     * @return true if parameters are valid, false otherwise
     */
    public boolean parameterCheckerFour(StringTokenizer st){
        if(st.countTokens() < 2){
            System.out.println("Missing data in the command line.");
            return false;
        }
        else if(st.countTokens() == 2){
            System.out.println("Credit hours missing.");
            return false;
        }
        else if(st.countTokens() < 4){
            System.out.println("Missing data in the command line.");
            return false;
        }
        else if(st.countTokens() != 4){
            System.out.println("Invalid number of parameters!");
            return false;
        }
        else{
            return true;
        }
    }


    /**
     * A helper method to determine if a major is valid or not
     * @param major Major of a student in string form
     * @return true if the major is valid, false otherwise
     */
    public boolean majorChecker(String major){
        if (major.equals("CS") || major.equals("Cs") || major.equals("cS") || major.equals("cs") ||
                major.equals("IT") || major.equals("It") || major.equals("iT") || major.equals("it") ||
                major.equals("BA") || major.equals("Ba") || major.equals("bA") || major.equals("ba") ||
                major.equals("EE") || major.equals("Ee") || major.equals("eE") || major.equals("ee") ||
                major.equals("ME") || major.equals("Me") || major.equals("mE") || major.equals("me")){
            return true;
        }
        else{
            System.out.println(major + "' is not a valid major.");
            return false;
        }
    }

    /**
     * A helper method to determine whether the number of credit hours is valid or not
     * @param creditHours credit hours a student is taking
     * @return true if amount is valid, false otherwise
     */
    public boolean creditChecker(int creditHours){
        if (creditHours < 0){
            System.out.println("Credit hours cannot be negative.");
            return false;
        }
        else if(creditHours < 3){
            System.out.println("Minimum credit hours is 3.");
            return false;
        }
        else if(creditHours > 24){
            System.out.println("Credit hours exceed the maximum 24.");
            return false;
        }
        else{
            return true;
        }
    }

    /**
     * Helper method to determine if an international student has enough credits or not
     * @param creditHours credits the international student is taking
     * @return true if hours are valid, false otherwise
     */
    public boolean creditCheckerInternational(int creditHours){
        if (creditHours < 12){
            System.out.println("International students must enroll at least 12 credits.");
            return false;
        }
        else{
            return true;
        }
    }

    /**
     * A helper method that reads the input command and executes its respective function in the roster
     * @param st the string tokenizer with inputs from the user
     * @param roster the roster being modified
     * @param command the input command from the user
     */
    public void addHelper(StringTokenizer st, Roster roster, String command){
        if (command.equals("AR")){
            if(parameterCheckerThree(st)){
                String name = st.nextToken();
                String major = st.nextToken();
                String creditHourString = st.nextToken();
                if(isNumeric(creditHourString)){ //check if credit hours are valid
                    int creditHours = Integer.parseInt(creditHourString);
                    if(creditChecker(creditHours) && majorChecker(major)){ //check for valid credit hours and major
                        Resident resident = new Resident(name, major, creditHours);
                        roster.add(resident);
                    }
                }
            }
            else{
                return;
            }
        }
        else if(command.equals("AN")){
            if(parameterCheckerThree(st)){
                String name = st.nextToken();
                String major = st.nextToken();
                String creditHourString = st.nextToken();
                if(isNumeric(creditHourString)){ //check if credit hours are valid
                    int creditHours = Integer.parseInt(creditHourString);
                    if(creditChecker(creditHours) && majorChecker(major)){ //check for valid credit hours and major
                        NonResident nonResident = new NonResident(name, major, creditHours);
                        roster.add(nonResident);
                    }
                }
            }
            else{
                return;
            }
        }
        else if(command.equals("AT")){
            if(parameterCheckerFour(st)){
                String name = st.nextToken();
                String major = st.nextToken();
                String creditHourString = st.nextToken();
                String state = st.nextToken();
                if(isNumeric(creditHourString) && stateChecker(state)){ //check if credit hours and state are valid
                    int creditHours = Integer.parseInt(creditHourString);
                    if(creditChecker(creditHours) && majorChecker(major)){ //check for valid credit hours and major
                        TriState triState = new TriState(name, major, creditHours, state);
                        roster.add(triState);
                    }
                }
                else{
                    return;
                }
            }
        }
        else{ //add international student
            if(parameterCheckerFour(st)){
                String name = st.nextToken();
                String major = st.nextToken();
                String creditHourString = st.nextToken();
                Boolean studyAbroadStatus = Boolean.parseBoolean(st.nextToken());
                if(isNumeric(creditHourString)){ //check if credit hours and state are valid
                    int creditHours = Integer.parseInt(creditHourString);
                    //check for valid credit hours and major
                    if(creditChecker(creditHours) && majorChecker(major) && creditCheckerInternational(creditHours)){
                        International international = new International(name, major, creditHours, studyAbroadStatus);
                        roster.add(international);
                    }
                }
                else{
                    return;
                }
            }
        }
    }

    /**
     * A helper method for the tuitionHelper to check if the parameters for tuition payment is valid or not
     * @param st String tokenizer from the user
     * @return true if the parameters are valid, false otherwise
     */
    public boolean parameterCheckerPayment(StringTokenizer st){
        if(st.countTokens() < 2){
            System.out.println("Missing data in the command line.");
            return false;
        }
        else if(st.countTokens() < 3){
            System.out.println("Payment amount missing.");
            return false;
        }
        else if(st.countTokens() < 4){
            System.out.println("Missing date of payment.");
            return false;
        }
        else if(st.countTokens() != 4){
            System.out.println("Invalid number of parameters!");
            return false;
        }
        else{
            return true;
        }
    }

    public boolean paymentChecker(int paymentAmount){
        if(paymentAmount <= 0){
            System.out.println("Invalid amount");
            return false;
        }
        else{
            return true;
        }
    }

    /**
     * A helper method that reads the input command and executes its respective function having to do with tuition
     * @param st the string tokenizer with inputs from the user
     * @param roster the roster being modified
     * @param command the input command from the user
     */
    public void tuitionHelper(StringTokenizer st, Roster roster, String command){
        if(command.equals("T")){
            if(parameterCheckerPayment(st)){
                String name = st.nextToken();
                String major = st.nextToken();
                int paymentAmount = Integer.parseInt(st.nextToken());
                Date date = new Date(st.nextToken());
                if(paymentChecker(paymentAmount) && majorChecker(major)){
                    Student student = new Student(name, major);
                    student.payTuition(paymentAmount, date);
                    //add error if payment amount is greater than payment due
                }
            }
        }
        else if(command.equals("S")){
            //find student first
            if(st.countTokens() != 3){
                System.out.println("Invalid number of parameters!");
                String name = st.nextToken();
                String major = st.nextToken();
                boolean studyAbroadStatus = Boolean.parseBoolean(st.nextToken());
                if(majorChecker(major)){
                    Student student = new Student(name, major);
                    if(student instanceof International){//find student first to edit roster
                        International iStudent = (International) student;
                        iStudent.setStudyAbroad();
                    }
                }
            }
        }
        else if(command.equals("C")){

        }
        else{ //set financial aid amount

        }
    }

    /**
     * A helper method that reads the input command and executes its respective print function
     * @param st the string tokenizer with inputs from the user
     * @param roster the roster being modified
     * @param command the input command from the user
     */
    public void printHelper(StringTokenizer st, Roster roster, String command){
        if(command.equals("P")){

        }
        else if(command.equals("PN")){

        }
        else{ //print only the students who have made payments, ordered by the payment date.

        }
    }

    /**
     * Runs a while loop to continuously read inputs from the user until the quit command is entered.
     */
    public void run(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Tuition Manager starts running.");
        String input = reader.nextLine();
        StringTokenizer st = new StringTokenizer(input, ",");
        Roster roster = new Roster();
        String command = st.nextToken();
        while(!command.equals("Q")) {
            if(command.equals("AR") || command.equals("AN") || command.equals("AT") || command.equals("AI") ||
                    command.equals("R")) {
                addHelper(st, roster, command);
            }
            else if(command.equals("T") || command.equals("S") || command.equals("F") || command.equals("C")){
                tuitionHelper(st, roster, command);
            }
            else if (command.equals("P") || command.equals("PN") || command.equals("PT")){
                printHelper(st, roster, command);
            }
            else{
                System.out.println("Command '" + command + "' not supported!");
            }
        }
        System.out.println("Tuition Manager terminated.");
    }
}
