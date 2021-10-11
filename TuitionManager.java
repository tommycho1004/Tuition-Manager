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


    //variables to use for the next method
    private static int ZERO = 0;
    private static int minCredits = 3;
    private static int maxCredits = 24;

    /**
     * A helper method to determine whether the number of credit hours is valid or not
     * @param creditHours credit hours a student is taking
     * @return true if amount is valid, false otherwise
     */
    public boolean creditChecker(int creditHours){
        if (creditHours < ZERO){
            System.out.println("Credit hours cannot be negative.");
            return false;
        }
        else if(creditHours < minCredits){
            System.out.println("Minimum credit hours is 3.");
            return false;
        }
        else if(creditHours > maxCredits){
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
                        if (!roster.add(resident)){
                            System.out.println("Student is already in the roster.");
                        }
                        else{
                            //roster.add(resident); //(try)
                            System.out.println("Student added.");
                        }
                    }
                }
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
                        if (!roster.add(nonResident)){
                            System.out.println("Student is already in the roster.");
                        }
                        else{
                            //roster.add(nonResident); //(try)
                            System.out.println("Student added.");
                        }
                    }
                }
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
                        if (!roster.add(triState)){
                            System.out.println("Student is already in the roster.");
                        }
                        else{
                            //roster.add(triState); //(try)
                            System.out.println("Student added.");
                        }
                    }
                }
            }
        }
        else if(command.equals("AI")){
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
                        if (!roster.add(international)){
                            System.out.println("Student is already in the roster.");
                        }
                        else{
                            //roster.add(international); //(try)
                            System.out.println("Student added.");
                        }
                    }
                }
            }
        }
        else{ //removes student
            if(st.countTokens() != 2){
                System.out.println("Invalid number of parameters!");
            }
            else{
                String name = st.nextToken();
                String major = st.nextToken();
                if (majorChecker(major)){
                    Student temp = new Student(name, major);
                    if(roster.remove(temp) == false){
                        System.out.println("Student is not in the roster.");
                    }
                    else{
                        System.out.println("Student removed from the roster.");
                    }
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

    public boolean financialAidChecker(double financialAid){
        if (financialAid < 0 || financialAid > 10000){
            System.out.println("Invalid amount.");
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
                if(!date.isValid()){
                    System.out.println("Payment date invalid");
                }
                else{
                    if(paymentChecker(paymentAmount) && majorChecker(major)){
                        Student student = new Student(name, major);
                        if(!roster.payTuition(student, paymentAmount, date)){
                            System.out.println("Amount is greater than amount due.");
                        }
                        else{
                            System.out.println("Payment applied");
                        }
                    }
                }
            }
        } else if (command.equals("S")) {
            if (st.countTokens() != 3) {
                System.out.println("Invalid number of parameters!");
            }
            else{
                String name = st.nextToken();
                String major = st.nextToken();
                boolean studyAbroadStatus = Boolean.parseBoolean(st.nextToken());
                if (majorChecker(major)) {
                    International temp = new International(name, major);
                    if (!roster.setStudyAbroad(temp)){
                        System.out.println("Couldn't find the international student.");
                    }
                    else{
                        System.out.println("Tuition updated.");
                    }
                }
            }
        }
        else if(command.equals("C")){
            if(st.countTokens() != 0){
                System.out.println("Invalid number of parameters!");
            }
            else{
                roster.calculate();
                System.out.println("Calculation completed");
            }
        }
        else{ //set financial aid amount
            if(st.countTokens() < 3){
                System.out.println("Missing the amount.");
            }
            else if(st.countTokens() != 3){
                System.out.println("Invalid number of parameters!");
            }
            else{
                String name = st.nextToken();
                String major = st.nextToken();
                double finAidAmount = Double.parseDouble(st.nextToken());
                if (financialAidChecker(finAidAmount)) {
                    Student temp = new Student(name, major);
                    int aidScenario = roster.setFinancialAid(temp, finAidAmount);
                    if (aidScenario == 4) {
                        System.out.println("Tuition Updated.");
                    } else if (aidScenario == 0) {
                        System.out.println("Student not in the roster.");
                    } else if (aidScenario == 1) {
                        System.out.println("Not a resident student.");
                    } else if (aidScenario == 2) {
                        System.out.println("Awarded once already.");
                    } else if (aidScenario == 3) {
                        System.out.println("Parttime student doesn't qualify for the award.");
                    }
                }
            }
        }
    }

    /**
     * A helper method that reads the input command and executes its respective print function
     * @param st the string tokenizer with inputs from the user
     * @param roster the roster being modified
     * @param command the input command from the user
     */
    public void printHelper(StringTokenizer st, Roster roster, String command){
        if(st.countTokens() != 0){
            System.out.println("Invalid number of parameters!");
            return;
        }
        if(roster.getSize() == 0){
            System.out.println("Student roster is empty!");
            return;
        }
        if(command.equals("P")){
            roster.print();
        }
        else if(command.equals("PN")){
            roster.printByName();
        }
        else{ //print only the students who have made payments, ordered by the payment date.
            roster.printByPaymentDate();
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

            input = reader.nextLine();
            st = new StringTokenizer(input, ",");
            command = st.nextToken();
        }
        System.out.println("Tuition Manager terminated.");
    }
}
