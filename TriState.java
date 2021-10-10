/**
 * The TriState subclass that extends from the NonResident superclass.
 * Use this class to get discounts for tristate students.
 * @author Tommy Cho, Neha Gudur
 */
import java.text.DecimalFormat;

public class TriState extends NonResident{
    private boolean isNY; //true then they're from NY and if false then they're from CT

    private static double nyDiscount = 4000.0;
    private static double ctDiscount = 5000.0;

    /**
     * Parameterized constructor for a tri-state that calls the super constructor.
     * @param name Name of the student in string form
     * @param major Major of the student in string form
     * @param creditHours Credit hours the student is taking in int form
     */
    public TriState(String name, String major, int creditHours, String state){
        super(name, major, creditHours);
        if(state.equals("NY") || state.equals("nY") || state.equals("Ny") || state.equals("ny")){
            this.isNY = true;
        }
        else{
            this.isNY = false;
        }
    }

    /**
     * A helper method that returns the string of the state that a tri-state student is in.
     * @return NY or CT depending on the student's location in string form
     */
    public String stateString(){
        if (this.isNY){
            return "NY";
        }
        else{
            return "CT";
        }
    }
    /**
     * The calculation method for the tuition of a non-resident, tri-state student.
     */
    @Override
    public void tuitionDue(){
        double total = 0.0;
        if (this.getTuitionDue() == 0 && this.getTotalPayment() == 0)
        {
            if (this.getIsFullTime()){
                if(this.getCreditHours() <= extraCredits){
                    //full time less than 16 credits calculation
                    total = baseTuition + universityFee;
                }
                else{
                    //full time more than 16 credits calculation
                    total = baseTuition + universityFee + (this.getCreditHours() - extraCredits) * creditHourTuition;
                }
                if (isNY){
                    //setting the discount for full time NY people
                    this.setTuitionDue(total - nyDiscount);
                }
                else{
                    //setting the discount for full time CT people
                    this.setTuitionDue(total - ctDiscount);
                }
            }
            else{
                //part time calculation (tri-state part time do not get discount)
                total = this.getCreditHours() * creditHourTuition + partTimeUniversityFee;
                this.setTuitionDue(total);
            }
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
                ":last payment date:" + this.getLastPaid().dateString() + ":non-resident(tri-state):" + stateString();
    }
}
