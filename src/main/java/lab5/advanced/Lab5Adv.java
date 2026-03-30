package lab5.advanced;

public class Lab5Adv {
    public static void main(String[] args) {
        NewIntCalculator calculator = new NewIntCalculator(10);
        int result=(Integer) calculator.add(5).subtract(3).multiply(2).result();
        System.out.println(result);
        DoubleCalculator calculator2 = new DoubleCalculator(10);
        double result2=(Double) calculator2.add(5).subtract(3).multiply(2).result();
        System.out.println(result2);
    }
}