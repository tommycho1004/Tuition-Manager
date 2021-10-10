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
     * A helper method that reads the input command and executes its respective function in the roster
     * @param st the string tokenizer with inputs from the user
     * @param roster the roster being modified
     * @param command the input command from the user
     */
    public void addHelper(StringTokenizer st, Roster roster, String command){
        if (command.equals("AR")){
            if(st.countTokens() != 3){
                System.out.println("Invalid number of parameters!");
            }
            else{
                String name = st.nextToken();
                String major = st.nextToken();
                int creditHours = Integer.parseInt(st.nextToken());
                if(creditChecker(creditHours) && majorChecker(major)){
                    Resident resident = new Resident(name, major, creditHours);
                    roster.add(resident);
                }
            }

        }
        else if(command.equals("AN")){
            if(st.countTokens() != 3){
                System.out.println("Invalid number of parameters!");
            }
            else{
                String name = st.nextToken();
                String major = st.nextToken();
                int creditHours = Integer.parseInt(st.nextToken());
                if(creditChecker(creditHours) && majorChecker(major)){
                    NonResident nonResident = new NonResident(name, major, creditHours);
                    roster.add(nonResident);
                }
            }
        }
        else if(command.equals("AT")){
            if(st.countTokens() != 4){
                System.out.println("Invalid number of parameters!");
            }

        }
        else{ //add international student
            if(st.countTokens() != 4){
                System.out.println("Invalid number of parameters!");
            }

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

        }
        else if(command.equals("S")){

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
