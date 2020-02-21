import java.util.Scanner;

public class ex4 {
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
        scanner.close();
    }
}