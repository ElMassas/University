import java.util.InputMismatchException;
import java.util.Scanner;

public class temp {
    // receives arguments at execution
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numb = 0;

        while (true) {
            if (scanner.hasNext()) {
                try {
                    numb = scanner.nextInt();
                } catch (NumberFormatException nfe) {
                } finally {
                    System.out.println(numb + 1);
                    break;
                }
            } else
                break;
        }

    }
}