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
     * A default constructor for the student object
     */
    public Student(){
        this.profile = null;
        this.creditHours = 0;
    }

    /**
     * A parameterized constructor for the student object
     * @param name Name of the student in string form
     * @param major Major of the student in string form
     * @param creditHours Credit hours the student is taking in integer form
     */

    public Student(String name, String major, int creditHours) throws IllegalArgumentException{
        if(creditHours > 24 || creditHours < 3){
            throw new IllegalArgumentException("Credit hours must be between 3 and 24!");
        }
        this.profile.setName(name);
        this.profile.setMajor(major);
        this.creditHours = creditHours;
        if (creditHours >= 12){
            this.isFullTime = true;
        }
        else{
            this.isFullTime = false;
        }
    }

    /**
     * The do-nothing method of calculating tuition.
     * The other sub-classes will have a method with the same name that will override this one.
     */
    public void tuitionDue(){}

    /**
     * A method lets a student pay their tuition
     * @param amount integer value of how much the student is paying right now
     */
    public void payTuition(int amount, Date datePaid){
        this.tuitionDue = this.tuitionDue - amount;
        this.lastPaid = datePaid;
        this.totalPayment = this.totalPayment + amount;
    }

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
