package lab6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NewIntCalculatorTest {

    @Test
    public void testAddPositive() {
        NewIntCalculator calc = new NewIntCalculator();
        calc.init();
        calc.add(5);
        calc.add(10);
        Assertions.assertEquals(15, calc.result());
    }

    @Test
    public void testAddNegatives() {
        NewIntCalculator calc = new NewIntCalculator();
        calc.init();
        calc.add(-5);
        calc.add(-10);
        Assertions.assertEquals(-15, calc.result());
    }

    @Test
    public void testSubtractPositives() {
        NewIntCalculator calc = new NewIntCalculator();
        calc.init();
        calc.add(20);
        calc.subtract(5);
        Assertions.assertEquals(15, calc.result());
    }

    @Test
    public void testSubtractNegatives() {
        NewIntCalculator calc = new NewIntCalculator();
        calc.init();
        calc.add(5);
        calc.subtract(-3);
        Assertions.assertEquals(8, calc.result());
    }

    @Test
    public void testMultiplyPositives() {
        NewIntCalculator calc = new NewIntCalculator();
        calc.init();
        calc.add(4);
        calc.multiply(3);
        Assertions.assertEquals(12, calc.result());
    }

    @Test
    public void testMultiplyNegatives() {
        NewIntCalculator calc = new NewIntCalculator();
        calc.init();
        calc.add(-4);
        calc.multiply(-2);
        Assertions.assertEquals(8, calc.result());
    }

    @Test
    public void testMultiplyBy0() {
        NewIntCalculator calc = new NewIntCalculator();
        calc.init();
        calc.add(15);
        calc.multiply(0);
        Assertions.assertEquals(0, calc.result());
    }

    @Test
    public void testDividePositives() {
        NewIntCalculator calc = new NewIntCalculator();
        calc.init();
        calc.add(20);
        calc.divide(4);
        Assertions.assertEquals(5, calc.result());
    }

    @Test
    public void testDivideNegatives() {
        NewIntCalculator calc = new NewIntCalculator();
        calc.init();
        calc.add(-20);
        calc.divide(-5);
        Assertions.assertEquals(4, calc.result());
    }

    @Test
    public void testDivideBy0() {
        NewIntCalculator calc = new NewIntCalculator();
        calc.init();
        calc.add(10);
        Assertions.assertThrows(ArithmeticException.class, () -> {
            calc.divide(0);
        });
    }
}