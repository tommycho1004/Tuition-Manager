/**
 * The Roster class used as the container for students.
 * This class contains methods to perform several functions to the roster of students.
 *
 * @author Tommy Cho, Neha Gudur
 */

public class Roster {
    private Student[] roster;
    private int size; //keep track of the number of students in the roster

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
        Student newList[] = new Student[size + 4];
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
            size++; // add to numAlbums
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
        if (size == 0) {
            System.out.println("Student roster is empty!");
        } else {
            System.out.println("* list of students in the roster **");
            for (int i = 0; i < size; i++) {
                System.out.println(roster[i].toString());
            }
            System.out.println("* end of roster **");
        }
    }

    public void printByName() {
        if (size == 0) {
            System.out.println("Student roster is empty!");
        } else {
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
    }

    public void printByPaymentDate() {
        if (size == 0) {
            System.out.println("Student roster is empty!");
        } else {
            int paymentSize = 0;
            for (int i = 0; i < size; i++) {
                if (roster[i].hasMadePayment()) {
                    paymentSize++;
                }
            }
            Student[] newArray = new Student[paymentSize];
            int k = 0;
            for (int i = 0; i < size; i++) {
                if (roster[i].hasMadePayment()) {
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


    public boolean calculate() {
        for (int i = 0; i < size; i++) {
            if (roster[i] instanceof International) {
                ((International) roster[i]).tuitionDue();
            } else if (roster[i] instanceof TriState) {
                ((TriState) roster[i]).tuitionDue();
            } else if (roster[i] instanceof NonResident) {
                ((NonResident) roster[i]).tuitionDue();
            } else if (roster[i] instanceof Resident) {
                ((Resident) roster[i]).tuitionDue();
            }
            // i think instead of all of this, just roster[i]).tuitionDue(); would work
        }
        return true;
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
                Date temp = new Date("0/0/0");
                student.setLastPaid(temp);
                student.tuitionDue();
                return true;
            } else return false;
        } else return false;
    }

    public int setFinancialAid(Student student, double financialaid) { // 0 if not in roster,
        // 1 if not resident, 2 if got aid before, 3 if is part time, 4 if tuition updated
        if (find(student) != -1) {
            if (student instanceof Resident) {
                if (((Resident) student).getIsFinAid() == false) {
                    if (student.getIsFullTime()) {
                        ((Resident) student).receiveFinAid(financialaid);
                        return 4;
                    } else return 3;
                } else return 2;
            } else return 1;
        } else return 0;
    }
}

