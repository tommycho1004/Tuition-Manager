/**
 * The International subclass that extends from the NonResident superclass.
 * Use this class to do get calculation information for international students.
 * @author Tommy Cho, Neha Gudur
 */

public class International extends NonResident{
    private static double additionalFee = 2650.0;
    private boolean studyAbroad = false; //true if they are studying abroad, false otherwise
    private double internationalTuition;

    /**
     * The calculation method for the tuition of a non-resident student.
     */
    @Override
    public void tuitionDue(){
        double total = 0.0;
        //calculations
        internationalTuition = total;
    }

    /**
     * Converts the information of the student to a string format
     * @return the student's profile in the form of a string
     */
    @Override
    public String toString(){

    }
}
