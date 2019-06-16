import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.assertj.core.data.Offset;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(JUnitParamsRunner.class)
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

    /*--- try catch ---*/
    @Test
    public void divide_a10b0_IllegalArgumentExceptionTryCatch() {
        try {
            Calculator.divide(10, 0);
        } catch (IllegalArgumentException e) {
            Assert.assertTrue(true);
            return;
        }

        Assert.fail();
    }

    /*--- expected ---*/
    @Test(expected = IllegalArgumentException.class)
    public void divide_a10b0_IllegalArgumentExceptionExpected() {
        Calculator.divide(10, 0);
    }

    /*--- rule ---*/
    @Rule
    public ExpectedException rule = ExpectedException.none();

    @Test
    public void divide_a10b_0_IllegalArgumentExceptionRule() {
        rule.expect(IllegalArgumentException.class);
        Calculator.divide(10, 0);
    }

    /*--- LOGARYTM ---*/
    @Test
    public void log_a4x2_2() {
        double expected = 2;
        double acutal = Calculator.log(2, 4);

        Assert.assertEquals(expected, acutal, 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void log_a_1_x5_IllegalArgumentExceptionExpected() {
        Calculator.log(-1, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void log_a5_x_1_IllegalArgumentExceptionExpected() {
        Calculator.log(5, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void log_a1_x100_IllegalArgumentExceptionExpected() {
        Calculator.log(1, 100);
    }

    /*--- LAMBDA ---*/
    @Test
    public void log_a_3b10_IllegalArgumentExceptionMassageBaseOFLogarithmShouldBeGraterThan0() {
        assertThatThrownBy(() -> {
            Calculator.log(-3, 10);
        }).hasMessage("a mniejsze od zero lub rowne 1");
    }

    @Test
    public void log_a_1b10_IllegalArgumentExceptionMassageBaseOFLogarithmShouldNotBe1() {
        assertThatThrownBy(() -> {
            Calculator.log(1, 10);
        }).hasMessage("a mniejsze od zero lub rowne 1");
    }

    @Test
    public void log_a_3b10_IllegalArgumentExceptionMassageNumberShouldBeGraterThan0() {
        assertThatThrownBy(() -> {
            Calculator.log(2, -5);
        }).hasMessage("a mniejsze od zero lub rowne 1");
    }

    /*--- Assertj suma ---*/
    @Test
    public void log_a2b4_2() {
        double expected = 2;
        double actual = Calculator.log(2, 4);

        assertThat(expected).isEqualTo(actual, Offset.strictOffset(0.01));
    }

    /*--- OFFSET ---*/
    @Test
    public void suma_a5b10_15() {
        double expected = 15;
        double actual = Calculator.sum(5, 10.0);

        assertThat(expected).isEqualTo(actual, Offset.strictOffset(0.01));
    }

    @Test
    public void odejmowanie_a15b5_10() {
        double expected = 10;
        double actual = Calculator.substraction(15, 5);

        assertThat(expected).isEqualTo(actual, Offset.strictOffset(0.01));
    }

    /*--- TESTY PARAMETRYCZNE ---*/
    @Test
    @Parameters({"5, 10, 15", "100, 500, 600"})
    public void sum_parametrized(int a, int b, int expected) {
        assertThat(expected).isEqualTo(Calculator.sum(a, b));
    }

    @Test
    @Parameters({"5,15,-10", "100, 50, 50"})
    public void substraction_parametrized(double a, double b, double expected) {
        assertThat(expected).isEqualTo(Calculator.substraction(a, b), Offset.strictOffset(0.001));
    }

    /*--- FIBONACCI ---*/
    @Test
    @Parameters({"1,1", "2,1", "3,2", "4,3", "5,5", "6,8", "7,13", "8,21", "9,34", "10,55"})
    public void fibonacci_parametrized(int n, int expected) {
        assertThat(expected).isEqualTo(Calculator.getFibonaciNumber(n));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getFibonacciNumber_100_IllegalArgumentException() {
        Calculator.getFibonaciNumber(-100);
    }

    /*===*/
    @Test
    @Parameters(method = "getFibonacciData")
    public void fibonacci_parametrizedByMethod(int n, int expected) {
        assertThat(expected).isEqualTo(Calculator.getFibonaciNumber(n));
    }

    private Object[] getFibonacciData() {
        return new Object[]{
                new Object[]{0, 0},
                new Object[]{1, 1},
                new Object[]{2, 1},
                new Object[]{3, 2},
                new Object[]{4, 3},
                new Object[]{5, 5},
                new Object[]{6, 8},
                new Object[]{7, 13},
                new Object[]{8, 21},
                new Object[]{9, 34},
                new Object[]{10, 55},
        };
    }

    @Test
    @Parameters(method = "getSumData")
    public void sum_parametrizedByMethod(int a, int b, int expected) {
        assertThat(expected).isEqualTo(Calculator.sum(a, b));
    }

    private Object[] getSumData() {
        return new Object[]{
                new Object[]{5, 10, 15},
                new Object[]{500, 5, 505},
                new Object[]{1000, 1000, 2000}
        };
    }

    @Test
    @Parameters(source = DifferenceDataProvide.class)
    public void substraction_parametrizedByClass(double a, double b, double expected) {
        assertThat(expected).isEqualTo(Calculator.substraction(a, b));
    }

    @Test
    @Parameters(source = DivideDataProvide.class)
    public void divide_paramizedByClass(double a, double b, double expected) {
        assertThat(expected).isEqualTo(Calculator.divide(a,b));
    }

    /*--- TDD ---*/
    @Test
    public void pow_a2_4() {
        double expected = 8;
        double actual = Calculator.pow2(2);

        assertThat(expected).isEqualTo(actual);
    }
}
