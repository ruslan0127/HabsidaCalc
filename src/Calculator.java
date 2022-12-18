import java.sql.SQLOutput;
import java.util.Scanner;

public class Calculator {

    private String[] tokens;
    private int pos;

    public static void main(String[] args) {

        System.out.println("Input:");
        Scanner in = new Scanner(System.in);
        String task = in.nextLine();
        Calculator calculator = new Calculator((task));
        System.out.println("Output: \n" + calculator.calculate());
    }

    public Calculator(String task) {
            this.tokens = task.split(" ");
            this.pos = 0;
    }

    public double calculate() {
        double first = multiply();

        while (pos < tokens.length) {
            String operator = tokens[pos];
            if (!operator.equals("+") && !operator.equals("-")) {
                break;
            } else {
                pos++;
            }

            double second = multiply();
            if (operator.equals("+")) {
                first += second;
            } else {
                first -= second;
            }
        }
        return first;
    }

    public double multiply() {
        double first = Double.parseDouble(tokens[pos++]);

        while (pos < tokens.length) {
            String operator = tokens[pos];
            if (!operator.equals("*") && !operator.equals("/")) {
                break;
            } else {
                pos++;
            }

            double second = Double.parseDouble(tokens[pos++]);
            if (operator.equals("*")) {
                first *= second;
            } else {
                first /= second;
            }
        }
        return first;
    }
}
