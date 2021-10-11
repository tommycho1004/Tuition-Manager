/**
 * The Roster class used as the container for students.
 * This class contains methods to perform several functions to the roster of students.
 *
 * @author Tommy Cho, Neha Gudur
 */

public class Roster {
    private Student[] roster = new Student[4];
    private int size = 0; //keep track of the number of students in the roster

    public int getSize() {
        return size;
    }

    private int find(Student student) {
        for (var i = 0; i < size; i++) {
            if (roster[i].equals(student)) {
                return i;
            }
        }
        return -1;
    }

    public int finds(Student student) {
        return find(student);
    }

    /**
     * A method to grow the list of students.
     * The roster grows by 4 everytime a cap is reached.
     */
    private void grow() {
        Student[] newList = new Student[size + 4];
        for (int i = 0; i < size; i++) {
            newList[i] = roster[i];
        }
        roster = newList;
    }

    /**
     * A method to add the student to the roster.
     *
     * @param student the student being added
     * @return true if the student is added, false otherwise
     */
    public boolean add(Student student) {
        if (find(student) == -1) {
            size++;
            if (size % 4 == 0) {
                grow();
            }
            roster[size - 1] = student;
            return true;
        }
        return false;
    }

    /**
     * A method to remove a student from the roster.
     *
     * @param student the student being removed
     * @return true if the student is removed, false otherwise
     */
    public boolean remove(Student student) {
        if (size == 0) {
            return false;
        }
        if (find(student) != -1) {
            for (var j = find(student); j < size; j++) {
                roster[j] = roster[j + 1];
                if (roster[j] == null) {
                    size--;
                    return true;
                }
            }
        }
        return false;
    }

    public void print() {
        System.out.println("* list of students in the roster **");
        for (int i = 0; i < size; i++) {
            System.out.println(roster[i].toString());
        }
        System.out.println("* end of roster **");
    }

    public void printByName() {
        Student[] newArray = roster;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (newArray[j].getProfile().compareTo(newArray[j + 1].getProfile()) > 0) {//j happened before i
                    Student temp = newArray[j];
                    newArray[j] = newArray[j + 1];
                    newArray[j + 1] = temp;
                }
            }
        }

        System.out.println("* list of students ordered by name **");
        for (int i = 0; i < size; i++) {
            System.out.println(newArray[i].toString());
        }
        System.out.println("** end of roster **");
    }

    public void printByPaymentDate() {
        int paymentSize = 0;
        for (int i = 0; i < size; i++) {
            if (roster[i].getMadePayment()) {
                paymentSize++;
            }
        }
        if (paymentSize == 0) {
            System.out.println("There are no students who have paid yet.");
        } else {
            Student[] newArray = new Student[paymentSize];
            int k = 0;
            for (int i = 0; i < size; i++) {
                if (roster[i].getMadePayment()) {
                    newArray[k] = roster[i];
                    k++;
                }
            }
            for (int i = 0; i < paymentSize - 1; i++) {
                for (int j = 0; j < paymentSize - i - 1; j++) {
                    if (newArray[j].getLastPaid().compareTo(newArray[j + 1].getLastPaid()) > 0) {//j happened before i
                        Student temp = newArray[j];
                        newArray[j] = newArray[j + 1];
                        newArray[j + 1] = temp;
                    }
                }
            }

            System.out.println("* list of students made payments ordered by payment date **");
            for (int i = 0; i < paymentSize; i++) {
                System.out.println(newArray[i].toString());
            }
            System.out.println("* end of roster **");
        }

    }


    public void calculate() {
        for (int i = 0; i < size; i++) {
            if (roster[i] instanceof International) {
                roster[i].tuitionDue();
            } else if (roster[i] instanceof TriState) {
                roster[i].tuitionDue();
            } else if (roster[i] instanceof NonResident) {
                roster[i].tuitionDue();
            } else if (roster[i] instanceof Resident) {
                roster[i].tuitionDue();
            }
        }
    }

    public boolean payTuition(Student student, double paymentAmount, Date date) { // false if amount greater than amount due
        if (paymentAmount <= student.getTuitionDue()) {
            student.payTuition(paymentAmount, date);
            return true;
        } else return false;
    }

    public boolean setStudyAbroad(Student student) { // returns false if couldn't find international student
        if (find(student) != -1) {
            if (student instanceof International) {
                ((International) student).setStudyAbroad();
                if (student.getCreditHours() > 12) {
                    student.setCreditHours(12);
                }
                student.setTotalPayment(0);
                student.setTuitionDue(0);
                Date temp = new Date("0/0/0");
                student.setLastPaid(temp);
                student.tuitionDue();
                return true;
            } else return false;
        } else return false;
    }

    /**
     * A method for the command to set financial aid of a resident student.
     * @param student Student that is being granted financial aid.
     * @param financialAid amount they are awarded
     * @return 4 if successful, 3 if the student is part time (unsuccessful),
     * 2 if the student already received it (unsuccessful), 1 if the student isn't a resident (unsuccessful)
     * and 0 if the student is not found (unsuccessful)
     */
    public int setFinancialAid(Student student, double financialAid) {
        if (find(student) != -1) {
            if (student instanceof Resident) {
                if (!((Resident) student).getFinancialAid()) {
                    //((Resident) student).getFinancialAid() == false)
                    if (student.getIsFullTime()) {
                        ((Resident) student).receiveFinAid(financialAid);
                        return 4;
                    } else return 3;
                } else return 2;
            } else return 1;
        } else return 0;
    }
}
