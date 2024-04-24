package stringCalculator;

public class Calculator {


    public static void main(String[] args) {
        try {
            StringCalculator calculator = new StringCalculator("//:\n1:2");

            System.out.println("값은 " + calculator.sum() + " 입니다.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
