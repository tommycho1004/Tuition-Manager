/**
 * The International subclass that extends from the NonResident superclass.
 * Use this class to do get calculation information for international students.
 * @author Tommy Cho, Neha Gudur
 */
import java.text.DecimalFormat;

public class International extends NonResident{
    private boolean studyAbroad; //true if they are studying abroad, false otherwise

    private static double additionalFee = 2650.0;

    /**
     * Setter method for study abroad status
     * This only sets it to true because the project description doesn't say a student can go from study-abroad to
     * non study-abroad.
     */
    public void setStudyAbroad(){
        if(this.getCreditHours() > 12){
            this.setCreditHours(12);
        }
        this.studyAbroad = true;
    }

    /**
     * A getter method for study abroad status
     * @return true if student is study abroad, false otherwise
     */
    public boolean getStudyAbroad(){
        return studyAbroad;
    }

    /**
     * /**
     * Parameterized constructor for an international student that calls the super constructor.
     * @param name Name of the student in string form
     * @param major Major of the student in string form
     * @param creditHours Credit hours the student is taking in int form
     * @param studyAbroad True if they are study abroad, false otherwise
     */
    public International(String name, String major, int creditHours, boolean studyAbroad){
        super(name, major, creditHours);
        this.studyAbroad = studyAbroad;
    }

    /**
     * A helper method that returns whether a student is study abroad status or not in string form
     * @return "study abroad" if they are study abroad, nothing otherwise
     */
    private String studyAbroadString(){
        if (studyAbroad){
            return ":study abroad";
        }
        else{
            return "";
        }
    }

    /**
     * The calculation method for the tuition of a non-resident student.
     */
    @Override
    public void tuitionDue(){
        double total = 0.0;
        if (this.getTuitionDue() == 0 && this.getTotalPayment() == 0)
        {
            if(!studyAbroad){
                if (this.getCreditHours() <= extraCredits){
                    total = baseTuition + universityFee + additionalFee;
                }
                else{
                    total = baseTuition + universityFee + additionalFee + (this.getCreditHours() - extraCredits) *
                            creditHourTuition;
                }
            }
            else{
                total = universityFee + additionalFee;
            }
            this.setTuitionDue(total);
        }
        else{
            return;
        }
    }

    /**
     * Converts the information of the student to a string format
     * @return the student's profile in the form of a string
     */
    @Override
    public String toString(){
        DecimalFormat dec = new DecimalFormat("#.00");
        return this.getProfile().toString() + ":" + this.getCreditHours() + " credit hours:tuition due:" +
                dec.format(this.getTuitionDue()) + ":total payment:" + dec.format(this.getTotalPayment()) +
                ":last payment date:" + this.getLastPaid().dateString() + ":non-resident:international" +
                this.studyAbroadString();
    }
}
