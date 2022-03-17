/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package euromillions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

/**
 * @author ico0
 */
public class DipTest {

    private Dip instance;

    final static int STARS_RANGE = 12;

    public DipTest() {
    }

    @BeforeEach
    public void setUp() {
        instance = new Dip(new int[]{10, 20, 30, 40, 50}, new int[]{1, 2});
    }

    @AfterEach
    public void tearDown() {
        instance = null;
    }


    @Test
    public void testConstructorFromBadArrays() {
        // todo: instantiate a dip passing valid or invalid arrays
        // fail("constructor from bad arrays: test not implemented yet");
        assertThrows(IllegalArgumentException.class, () -> {
            new Dip(new int[]{10, 20, 30, 40, 50, 60}, new int[]{1,2});
        }, "ERROR! #numbers is incorrect!");

        assertThrows(IllegalArgumentException.class, () -> {
            new Dip(new int[]{10, 20, 30, 40, 50}, new int[]{1,2,3});
        }, "ERROR! #stars is incorrect!");
    }

    @Test
    public void testFormat() {
        // note: correct the implementation of the format(), not the test...
        String result = instance.format();
        assertEquals("N[ 10 20 30 40 50] S[  1  2]", result, "format as string: formatted string not as expected. ");
    }

    @Test
    public void testNewStarRange() {
        assertDoesNotThrow(() -> new Dip(new int[]{1, 2, 3, 4, 5}, new int[]{1, 5}));
        assertDoesNotThrow(() -> new Dip(new int[]{1, 2, 3, 4, 5}, new int[]{11, 12}));
        assertThrows(IllegalArgumentException.class, () -> new Dip(new int[]{1, 2, 3, 4, 5}, new int[]{14, 19}));
    }

}
