import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;
import org.junit.Before; 
public class TestPOJO {
    private static final int aNum = 3;
    private static final String aDesc = "A description";
    private POJO inTest;
    @Before public void setUp() {
        inTest = new POJO(aNum, aDesc);
    }
    @Test public void testConstruction() {
        assertEquals(aNum, inTest.getNumber());
        assertEquals(aDesc, inTest.getDescription());
    }
    @Test public void testSetter() {
        inTest.setNumber(15);
        assertEquals(15, inTest.getNumber());
    }
    @Test public void testEquals() {
        assertEquals(inTest, new POJO(aNum, aDesc));
        assertNotEquals(inTest, null);
        assertEquals(inTest, new POJO(aNum, new String(aDesc)));
    }
    @Test public void testHashCode() {
        final POJO other = new POJO(aNum, aDesc);
        assertEquals(inTest, other);
        assertEquals(inTest.hashCode(), other.hashCode());
    }
}
