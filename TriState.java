/**
 * The TriState subclass that extends from the NonResident superclass.
 * Use this class to get discounts for tristate students.
 * @author Tommy Cho, Neha Gudur
 */

public class TriState extends NonResident{
    private static double NY = 4000.0;
    private static double CT = 5000.0;
    private double triStateTuition;

    /**
     * The calculation method for the tuition of a non-resident, tri-state student.
     */
    @Override
    public void tuitionDue(){
        double total = 0.0;
        //calculations
        triStateTuition = total;
    }

    /**
     * Converts the information of the student to a string format
     * @return the student's profile in the form of a string
     */
    @Override
    public String toString(){

    }
}
