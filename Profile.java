/**
 * The profile class that is used to identify students.
 * @author Tommy Cho, Neha Gudur
 */
public class Profile {
    private String name;
    private Major major; //5 majors and 2-character each: CS, IT, BA, EE, ME

    public void setName(String name){
        this.name = name;
    }

    public void setMajor(String major){
        if (major.equals("CS") || major.equals("Cs") || major.equals("cS") || major.equals("cs")){
            this.major = Major.CS;
        }
        else if (major.equals("IT") || major.equals("It") || major.equals("iT") || major.equals("it")){
            this.major = Major.IT;
        }
        else if (major.equals("BA") || major.equals("Ba") || major.equals("bA") || major.equals("ba")){
            this.major = Major.BA;
        }
        else if (major.equals("EE") || major.equals("Ee") || major.equals("eE") || major.equals("ee")){
            this.major = Major.EE;
        }
        else if (major.equals("ME") || major.equals("Me") || major.equals("mE") || major.equals("me")){
            this.major = Major.ME;
        }
        else {
            this.major = Major.Unknown;
        }
    }
    /**
     * Converts the information of the student to a string format
     * @return the student's profile in the form of a string
     */
    @Override
    public String toString(){

    }

    /**
     * Compares two students and determines if they are the same
     * @param obj student that is being compared
     * @return true if the two students are equal
     */
    @Override
    public boolean equals(Object obj){

    }
}
