package tuitions;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * The UI class of this program.
 * The user may input several commands to modify their roster of students.
 * Handles all exceptions and invalid data.
 *
 * @author Tommy Cho
 */
public class TuitionManager {
    /**
     * A helper method to determine if a major is valid or not
     *
     * @param major Major of a student in string form
     * @return true if the major is valid, false otherwise
     */
    public boolean majorChecker(String major) {
        if (major.equals("CS") || major.equals("Cs") || major.equals("cS") || major.equals("cs") ||
                major.equals("IT") || major.equals("It") || major.equals("iT") || major.equals("it") ||
                major.equals("BA") || major.equals("Ba") || major.equals("bA") || major.equals("ba") ||
                major.equals("EE") || major.equals("Ee") || major.equals("eE") || major.equals("ee") ||
                major.equals("ME") || major.equals("Me") || major.equals("mE") || major.equals("me")) {
            return true;
        } else {
            System.out.println("'" + major + "' is not a valid major.");
            return false;
        }
    }

    /**
     * A helper method to check whether the state is part of the tri-state area or not
     *
     * @param state state the user inputted where they're living in
     * @return true if the state is NY or CT, false otherwise
     */
    public boolean stateChecker(String state) {
        if (state.equals("NY") || state.equals("nY") || state.equals("Ny") || state.equals("ny") ||
                state.equals("CT") || state.equals("cT") || state.equals("Ct") || state.equals("ct")) {
            return true;
        } else {
            System.out.println("Not part of the tri-state area.");
            return false;
        }
    }

    /**
     * A helper method to check if the credit hours are numeric or not
     *
     * @param creditHourString credit hours of a student in string form
     * @return true if it is a number, false otherwise
     */
    public boolean isNumeric(String creditHourString) {
        if (creditHourString != null && creditHourString.matches("[-+]?\\d*\\.?\\d+")) {
            return true;
        } else {
            System.out.println("Invalid credit hours.");
            return false;
        }
    }

    /**
     * A helper method for the addHelper to check if the number of parameters (3) entered is valid
     *
     * @param st String tokenizer from the user
     * @return true if parameters are valid, false otherwise
     */
    public boolean parameterCheckerThree(StringTokenizer st) {
        if (st.countTokens() < 2) {
            System.out.println("Missing data in command line.");
            return false;
        } else if (st.countTokens() == 2) {
            System.out.println("Credit hours missing.");
            return false;
        } else if (st.countTokens() != 3) {
            System.out.println("Invalid number of parameters!");
            return false;
        } else {
            return true;
        }
    }

    /**
     * A helper method for the addHelper to check if the number of parameters (4) entered is valid
     *
     * @param st String tokenizer from the user
     * @return true if parameters are valid, false otherwise
     */
    public boolean parameterCheckerFour(StringTokenizer st) {
        if (st.countTokens() < 2) {
            System.out.println("Missing data in command line.");
            return false;
        } else if (st.countTokens() == 2) {
            System.out.println("Credit hours missing.");
            return false;
        } else if (st.countTokens() < 4) {
            System.out.println("Missing data in command line.");
            return false;
        } else if (st.countTokens() != 4) {
            System.out.println("Invalid number of parameters!");
            return false;
        } else {
            return true;
        }
    }

    /**
     * A helper method to determine whether the number of credit hours is valid or not
     *
     * @param creditHours credit hours a student is taking
     * @return true if amount is valid, false otherwise
     */
    public boolean creditChecker(int creditHours) {
        int ZERO = 0;
        int minCredits = 3;
        int maxCredits = 24;
        if (creditHours < ZERO) {
            System.out.println("Credit hours cannot be negative.");
            return false;
        } else if (creditHours < minCredits) {
            System.out.println("Minimum credit hours is 3.");
            return false;
        } else if (creditHours > maxCredits) {
            System.out.println("Credit hours exceed the maximum 24.");
            return false;
        } else {
            return true;
        }
    }

    /**
     * Helper method to determine if an international student has enough credits or not
     *
     * @param creditHours credits the international student is taking
     * @return true if hours are valid, false otherwise
     */
    public boolean creditCheckerInternational(int creditHours) {
        if (creditHours < 12) {
            System.out.println("International students must enroll at least 12 credits.");
            return false;
        } else {
            return true;
        }
    }

    /**
     * A helper method that reads the input command and executes its respective function in the roster
     *
     * @param st      the string tokenizer with inputs from the user
     * @param roster  the roster being modified
     * @param command the input command from the user
     */
    public void addHelper(StringTokenizer st, Roster roster, String command) {
        switch (command) {
            case "AR":
                if (parameterCheckerThree(st)) {
                    String name = st.nextToken();
                    String major = st.nextToken();
                    String creditHourString = st.nextToken();
                    if (isNumeric(creditHourString)) { //check if credit hours are valid
                        int creditHours = Integer.parseInt(creditHourString);
                        if (majorChecker(major) && creditChecker(creditHours)) { //check for valid credit hours and major
                            Resident resident = new Resident(name, major, creditHours);
                            if (!roster.add(resident)) {
                                System.out.println("Student is already in the roster.");
                            } else {
                                //roster.add(resident); //(try)
                                System.out.println("Student added.");
                            }
                        }
                    }
                }
                break;
            case "AN":
                if (parameterCheckerThree(st)) {
                    String name = st.nextToken();
                    String major = st.nextToken();
                    String creditHourString = st.nextToken();
                    if (isNumeric(creditHourString)) { //check if credit hours are valid
                        int creditHours = Integer.parseInt(creditHourString);
                        if (majorChecker(major) && creditChecker(creditHours)) { //check for valid credit hours and major
                            NonResident nonResident = new NonResident(name, major, creditHours);
                            if (!roster.add(nonResident)) {
                                System.out.println("Student is already in the roster.");
                            } else {
                                //roster.add(nonResident); //(try)
                                System.out.println("Student added.");
                            }
                        }
                    }
                }
                break;
            case "AT":
                if (parameterCheckerFour(st)) {
                    String name = st.nextToken();
                    String major = st.nextToken();
                    String creditHourString = st.nextToken();
                    String state = st.nextToken();
                    if (isNumeric(creditHourString) && stateChecker(state)) { //check if credit hours and state are valid
                        int creditHours = Integer.parseInt(creditHourString);
                        if (majorChecker(major) && creditChecker(creditHours)) { //check for valid credit hours and major
                            TriState triState = new TriState(name, major, creditHours, state);
                            if (!roster.add(triState)) {
                                System.out.println("Student is already in the roster.");
                            } else {
                                //roster.add(triState); //(try)
                                System.out.println("Student added.");
                            }
                        }
                    }
                }
                break;
            case "AI":
                if (parameterCheckerFour(st)) {
                    String name = st.nextToken();
                    String major = st.nextToken();
                    String creditHourString = st.nextToken();
                    boolean studyAbroadStatus = Boolean.parseBoolean(st.nextToken());
                    if (isNumeric(creditHourString)) { //check if credit hours and state are valid
                        int creditHours = Integer.parseInt(creditHourString);
                        //check for valid credit hours and major
                        if (majorChecker(major) && creditChecker(creditHours) && creditCheckerInternational(creditHours)) {
                            International international = new International(name, major, creditHours, studyAbroadStatus);
                            if (!roster.add(international)) {
                                System.out.println("Student is already in the roster.");
                            } else {
                                //roster.add(international); //(try)
                                System.out.println("Student added.");
                            }
                        }
                    }
                }
                break;
            default:  //removes student
                if (st.countTokens() != 2) {
                    System.out.println("Invalid number of parameters!");
                } else {
                    String name = st.nextToken();
                    String major = st.nextToken();
                    if (majorChecker(major)) {
                        Student temp = new Student(name, major);
                        if (!roster.remove(temp)) {
                            System.out.println("Student is not in the roster.");
                        } else {
                            System.out.println("Student removed from the roster.");
                        }
                    }
                }
                break;
        }
    }

    /**
     * A helper method for the tuitionHelper to check if the parameters for tuition payment is valid or not
     *
     * @param st String tokenizer from the user
     * @return true if the parameters are valid, false otherwise
     */
    public boolean parameterCheckerPayment(StringTokenizer st) {
        if (st.countTokens() < 2) {
            System.out.println("Missing data in command line.");
            return false;
        } else if (st.countTokens() < 3) {
            System.out.println("Payment amount missing.");
            return false;
        } else if (st.countTokens() < 4) {
            System.out.println("Missing date of payment.");
            return false;
        } else if (st.countTokens() != 4) {
            System.out.println("Invalid number of parameters!");
            return false;
        } else {
            return true;
        }
    }

    /**
     * A helper method that checks if a payment amount is negative or not
     *
     * @param paymentAmount double payment attempting to be made
     * @return true if payment amount is valid, false otherwise
     */
    public boolean paymentChecker(double paymentAmount) {
        if (paymentAmount <= 0) {
            System.out.println("Invalid amount.");
            return false;
        } else {
            return true;
        }
    }

    /**
     * A helper method that checks if a financial aid amount is valid or not
     *
     * @param financialAid double financial aid attempting to be applied
     * @return true if amount is valid, false otherwise
     */
    public boolean financialAidChecker(double financialAid) {
        if (financialAid < 0 || financialAid > 10000) {
            System.out.println("Invalid amount.");
            return false;
        } else {
            return true;
        }
    }

    /**
     * A helper method that reads the input command and executes its respective function having to do with tuition
     *
     * @param st      the string tokenizer with inputs from the user
     * @param roster  the roster being modified
     * @param command the input command from the user
     */
    public void tuitionHelper(StringTokenizer st, Roster roster, String command) {
        switch (command) {
            case "T":
                if (parameterCheckerPayment(st)) {
                    String name = st.nextToken();
                    String major = st.nextToken();
                    double paymentAmount = Double.parseDouble(st.nextToken());
                    Date date = new Date(st.nextToken());
                    if (!date.isValid()) {
                        System.out.println("Payment date invalid.");
                    } else {
                        if (paymentChecker(paymentAmount) && majorChecker(major)) {
                            Student student = new Student(name, major);
                            if (!roster.payTuition(student, paymentAmount, date)) {
                                System.out.println("Amount is greater than amount due.");
                            } else {
                                System.out.println("Payment applied.");
                            }
                        }
                    }
                }
                break;
            case "S":
                if (st.countTokens() != 3) {
                    System.out.println("Invalid number of parameters!");
                } else {
                    String name = st.nextToken();
                    String major = st.nextToken();
                    if (majorChecker(major)) {
                        International temp = new International(name, major);
                        if (!roster.setStudyAbroad(temp)) {
                            System.out.println("Couldn't find the international student.");
                        } else {
                            System.out.println("Tuition updated.");
                        }
                    }
                }
                break;
            case "C":
                if (st.countTokens() != 0) {
                    System.out.println("Invalid number of parameters!");
                } else {
                    roster.calculate();
                    System.out.println("Calculation completed.");
                }
                break;
            default:  //set financial aid amount
                if (st.countTokens() < 3) {
                    System.out.println("Missing the amount.");
                } else if (st.countTokens() != 3) {
                    System.out.println("Invalid number of parameters!");
                } else {
                    String name = st.nextToken();
                    String major = st.nextToken();
                    double finAidAmount = Double.parseDouble(st.nextToken());
                    if (financialAidChecker(finAidAmount)) {
                        Student temp = new Student(name, major);
                        int aidScenario = roster.setFinancialAid(temp, finAidAmount);
                        if (aidScenario == 4) {
                            System.out.println("Tuition updated.");
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
                break;
        }
    }

    /**
     * A helper method that reads the input command and executes its respective print function
     *
     * @param st      the string tokenizer with inputs from the user
     * @param roster  the roster being modified
     * @param command the input command from the user
     */
    public void printHelper(StringTokenizer st, Roster roster, String command) {
        if (st.countTokens() != 0) {
            System.out.println("Invalid number of parameters!");
            return;
        }
        if (roster.getSize() == 0) {
            System.out.println("Student roster is empty!");
            return;
        }
        if (command.equals("P")) {
            roster.print();
        } else if (command.equals("PN")) {
            roster.printByName();
        } else { //print only the students who have made payments, ordered by the payment date.
            roster.printByPaymentDate();
        }
    }

    /**
     * A helper method to check if the input is valid (has words) or not
     *
     * @param input string from the user
     * @return true if the input is valid, false otherwise
     */
    public boolean inputChecker(String input) {
        return !input.equals("");
    }

    /**
     * Runs a while loop to continuously read inputs from the user until the quit command is entered.
     */
    public void run() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Tuition Manager starts running.");
        String input = reader.nextLine();
        StringTokenizer st;
        String command;
        Roster roster = new Roster();
        while (!input.equals("Q")) {
            if (inputChecker(input)) {
                st = new StringTokenizer(input, ",");
                command = st.nextToken();
                switch (command) {
                    case "AR", "AN", "AT", "AI", "R" -> addHelper(st, roster, command);
                    case "T", "S", "F", "C" -> tuitionHelper(st, roster, command);
                    case "P", "PN", "PT" -> printHelper(st, roster, command);
                    default -> System.out.println("Command '" + command + "' not supported!");
                }
            } else {
                System.out.println();
            }
            input = reader.nextLine();
        }
        System.out.println("Tuition Manager terminated.");
    }
}
