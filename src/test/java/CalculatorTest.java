import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.assertj.core.api.Assertions;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
}
