/**
 * The Non Resident subclass that extends from the Student superclass.
 * Use this class to calculate the tuition due for a non-resident.
 * @author Tommy Cho, Neha Gudur
 */
import java.text.DecimalFormat;

public class NonResident extends Student{
    protected static double baseTuition = 29737.0;
    protected static double creditHourTuition = 966.0;

    public NonResident(){
        this.setProfile(null);
        this.setCreditHours(0);
    }

    /**
     * Parameterized constructor for a non-resident that calls the super constructor.
     * @param name Name of the student in string form
     * @param major Major of the student in string form
     * @param creditHours Credit hours the student is taking in int form
     */
    public NonResident(String name, String major, int creditHours){
        super(name, major, creditHours);
    }


    /**
     * The calculation method for the tuition of a non-resident student.
     */
    @Override
    public void tuitionDue(){
        double total = 0.0;
        if (this.getTuitionDue() == 0 && this.getTotalPayment() == 0)
        {
            if (this.getIsFullTime()){
                if(this.getCreditHours() <= extraCredits){
                    total = baseTuition + universityFee;
                }
                else{
                    total = baseTuition + universityFee + (this.getCreditHours() - extraCredits) * creditHourTuition;
                }

            }
            else{
                total = this.getCreditHours() * creditHourTuition + partTimeUniversityFee;
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
                ":last payment date:" + this.getLastPaid().dateString() + ":non-resident";
    }

}
