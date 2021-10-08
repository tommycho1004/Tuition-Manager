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

        }
        else if(command.equals("AN")){
            if(st.countTokens() != 3){
                System.out.println("Invalid number of parameters!");
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
        Roster roster= new Roster();
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
