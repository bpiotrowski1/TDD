import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
    @Test
    public void suma_a2b5_7() {
        double expected = 7;
        double actual = Calculator.sum(2, 5);

        Assert.assertEquals(expected, actual, 0.001);
    }

    @Test
    public void suma_a2b2_4() {
        int expected = 4;
        int actual = Calculator.sum(2, 2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void odejmowanie_a5b1_4() {
        double expected = 4;
        double actual = Calculator.substraction(5, 1);

        Assert.assertEquals(expected, actual, 0.001);
    }

    @Test
    public void mnozenie_a5b3_15() {
        double expected = 15;
        double actual = Calculator.multiply(5, 3);

        Assert.assertEquals(expected, actual, 0.001);
    }

    @Test
    public void dzielenie_a15b3_5() {
        double expected = 5;
        double actual = Calculator.divide(15, 3);

        Assert.assertEquals(expected, actual, 0.001);
    }

    @Test
    public void fibonacci_a10_55() {
        double expected = 55;
        double actual = Calculator.getFibonaciNumber(10);

        Assert.assertEquals(expected, actual, 0.001);
    }
}
