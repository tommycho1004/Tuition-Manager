/**
 * The Resident subclass that extends from the Student superclass.
 * Use this class to calculate the tuition due for a resident.
 * @author Tommy Cho, Neha Gudur
 */
public class Resident extends Student{
    private boolean financialAid = false; //true if they received it, false if they didn't
    private double baseTuition = 12536.0;
    private double creditHour = 404.0;
    private double residentTuition;

    /**
     * The calculation method for the tuition of a resident student.
     */
    @Override
    public void tuitionDue(){
        double total = 0.0;
        //calculations
        residentTuition = total;
    }

    /**
     * Converts the information of the student to a string format
     * @return the student's profile in the form of a string
     */
    @Override
    public String toString(){

    }

    /**
     * Getter for tuition after calculation.
     * @return the tuition of the resident in double form.
     */
    public double getTuition(){
        return residentTuition;
    }
}
