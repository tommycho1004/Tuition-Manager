import tuitions.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InternationalTest {

    @Test
    void tuitionDue() {
        Double expected1 = 35655.0;
        Double expected2 = 35655.0;
        Double expected3 = 37587.0;
        Double expected4 = 5918.0;
        International international1 = new International("Santo", "iT", 13, false);
        International international2 = new International("Maria", "be", 16, false);
        International international3 = new International("Jeremy", "me", 18, false);
        International international4 = new International("Sam", "cs", 12, true); // study abroad
        international1.tuitionDue();
        international2.tuitionDue();
        international3.tuitionDue();
        international4.tuitionDue();
        Double actual1 = international1.getTuitionDue();
        Double actual2 = international2.getTuitionDue();
        Double actual3 = international3.getTuitionDue();
        Double actual4 = international4.getTuitionDue();
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
    }
}