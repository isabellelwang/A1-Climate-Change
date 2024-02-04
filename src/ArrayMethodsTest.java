import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayMethodsTest {
    /*
     * The class ArrayMethodsTest includes instructor-provided tests
     * to evaluate the array methods that you will write in the class
     * ArrayMethods. You should also write some of your own tests.
     */

    /* Arrays used to test ArrayMethods */
    float[] arr1 = { 1.0f, 2.0f, 3.0f, 4.0f };
    float[] arr2 = { -7.5f, 3.2f };
    float[] arr3 = {};
    float[] arr4 = { 1.0f, 3.0f, 2.0f };
    // adding two additional tests arrays
    float[] arr5 = { 3.2f, -8.4f };
    float[] arr6 = { -3.4f, -4.5f, -7.5f };

    @Test
    public void testWholeSum() {
        /* Tests for the wholeSum method */

        // Format of assertEquals: expected value, actual value, delta
        // delta is your tolerance for minor differences in computation
        // For example, is 32.000001 the same as 32.0000009?
        // Here we tell it yes, for temperatures, those two are the same
        assertEquals(10.0f, ArrayMethods.wholeSum(arr1), 0.000001);
        assertEquals(-4.3f, ArrayMethods.wholeSum(arr2), 0.000001);
        assertEquals(0.0f, ArrayMethods.wholeSum(arr3), 0.000001);
        // Write TWO additional tests
        assertEquals(-5.2f, ArrayMethods.wholeSum(arr5), 0.000001);
        assertEquals(-15.4, ArrayMethods.wholeSum(arr6), 0.000001);
    }

    @Test
    public void testSum() {
        assertEquals(5.0f, ArrayMethods.sum(arr1, 1, 3), 0.000001);
        assertEquals(10.0f, ArrayMethods.sum(arr1, 0, 4), 0.000001);
        assertEquals(0.0f, ArrayMethods.sum(arr1, 2, 2), 0.000001);
        // Write THREE additional tests
        assertEquals(-5.2f, ArrayMethods.sum(arr5, 0, 1), 0.000001);
        assertEquals(-10.9f, ArrayMethods.sum(arr6, 1, 2), 0.000001);
        assertEquals(5.0f, ArrayMethods.sum(arr4, 1, 2), 0.000001);

    }

    @Test
    public void testMean() {
        assertEquals(3.5f, ArrayMethods.mean(arr1, 2, 4), 0.000001);
        assertEquals(2.5f, ArrayMethods.mean(arr1), 0.000001);
        assertEquals(0.0f, ArrayMethods.mean(arr3), 0.000001);
        // Write THREE additional tests
        assertEquals(-2.6f, ArrayMethods.mean(arr5), 0.000001);
        assertEquals(-5.133333333f, ArrayMethods.mean(arr6), 0.000001);
        assertEquals(-4.5, ArrayMethods.mean(arr6, 1, 2), 0.000001);
    }

    @Test
    public void testMin() {
        assertEquals(2.0f, ArrayMethods.min(arr1, 1, 4), 0.000001);
        assertEquals(1.0f, ArrayMethods.min(arr1), 0.000001);
        assertEquals(Float.NaN, ArrayMethods.min(arr3), 0.000001);
        // Write TWO OR THREE additional tests
        assertEquals(3.2f, ArrayMethods.min(arr5, 0, 1), 0.000001);
        assertEquals(-4.5f, ArrayMethods.min(arr6, 0, 2), 0.000001);
    }

    @Test
    public void testMax() {
        assertEquals(4.0f, ArrayMethods.max(arr1, 1, 4), 0.000001);
        assertEquals(3.0f, ArrayMethods.max(arr4), 0.000001);
        assertEquals(1.0f, ArrayMethods.max(arr4, 0, 0), 0.000001);
        // Write TWO OR THREE additional tests
        assertEquals(3.2f, ArrayMethods.max(arr5, 0, 2), 0.000001);
        assertEquals(3.2f, ArrayMethods.max(arr5, 0, 2), 0.000001);
    }
}