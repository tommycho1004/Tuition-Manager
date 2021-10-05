/**
 * The Non Resident subclass that extends from the Student superclass.
 * Use this class to calculate the tuition due for a non-resident.
 * @author Tommy Cho, Neha Gudur
 */

public class NonResident extends Student{
    private double baseTuition = 29737.0;
    private double creditHour = 966.0;
    private double nonResidentTuition;

    /**
     * The calculation method for the tuition of a non-resident student.
     */
    @Override
    public void tuitionDue(){
        double total = 0.0;
        //calculations
        nonResidentTuition = total;
    }

    /**
     * Getter for tuition after calculation.
     * @return tuition of a non-resident in double form.
     */
    public double getTuition(){
        return nonResidentTuition;
    }

    /**
     * Converts the information of the student to a string format
     * @return the student's profile in the form of a string
     */
    @Override
    public String toString(){

    }

}
