import tuitions.*;
import static org.junit.jupiter.api.Assertions.*;

class RosterTest {

    private Roster roster = new Roster();
    private Resident resident = new Resident("George", "EE", 13);
    private NonResident nonResident = new NonResident("Jianna", "cs", 15);
    private International international = new International("Ceaser", "iT", 14, false);
    private TriState triState = new TriState("Ceaser", "BE", 14, "NY");
    private TriState triState2 = new TriState("Sydney", "ME", 14, "CT");
    private Resident resident2 = new Resident("Jasper", "EE", 15);

    @org.junit.jupiter.api.Test
    void add() {
        Roster roster = new Roster();
        assertTrue(roster.add(resident));
        assertTrue(roster.add(nonResident));
        assertTrue(roster.add(international));
        assertTrue(roster.add(triState));
        assertTrue(roster.add(triState2));
        assertFalse(roster.add(international));
    }

    @org.junit.jupiter.api.Test
    void remove() {
        assertFalse(roster.remove(nonResident));
        roster.add(resident);
        roster.add(nonResident);
        roster.add(international);
        roster.add(triState);
        roster.add(triState2);
        assertFalse(roster.remove(resident2));
        assertTrue(roster.remove(nonResident));
        assertTrue(roster.remove(international));
        assertFalse(roster.remove(international));
        assertTrue(roster.remove(triState));
        assertTrue(roster.remove(triState2));
        assertTrue(roster.remove(resident));
    }
}