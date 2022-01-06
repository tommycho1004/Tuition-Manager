import tuitions.Date;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {

    @Test
    void isValid() {
        //cases that should return false
        Date wrongDay = new Date("10/00/2021");
        Date wrongDay2 = new Date("10/32/2021");
        Date wrongMonth = new Date("00/11/2021");
        Date wrongMonth2 = new Date("13/11/2021");
        Date wrongYear = new Date("10/11/2023");
        Date notLeapYear = new Date("2/29/2021");
        //cases that should return true
        Date rightDay = new Date("10/10/2021");
        Date todaysDate = new Date();
        Date todaysDate2 = new Date();
        //tests
        assertFalse(wrongDay.isValid());
        assertFalse(wrongDay2.isValid());
        assertFalse(wrongMonth.isValid());
        assertFalse(wrongMonth2.isValid());
        assertFalse(wrongYear.isValid());
        assertFalse(notLeapYear.isValid());
        assertTrue(rightDay.isValid());
        assertTrue(todaysDate.isValid());
        assertTrue(todaysDate2.isValid());
    }
}