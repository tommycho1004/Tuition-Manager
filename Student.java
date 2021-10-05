/**
 *  The Student superclass that stores the attributes of each student and their financial aid information.
 *  Use this class to populate attributes into a new Student object.
 * @author Tommy Cho, Neha Gudur
 */

public class Student {
    private Profile profile;
    private int creditHours;
    private double universityFee = 3268.0;
    private boolean isFullTime;
    private Date lastPaid;
    private double totalPayment;
    private double tuitionDue;

    /**
     * The do-nothing method of calculating tuition.
     * The other sub-classes will have a method with the same name that will override this one.
     */
    public void tuitionDue(){}


    /**
     * Converts the information of the student to a string format
     * @return the student's profile in the form of a string
     */
    @Override
    public String toString(){

    }


    public void populate(int creditHours){
        if (creditHours >= 12)
        {
            isFullTime = true;
        }
        else{
            isFullTime = false;
        }
    }
}