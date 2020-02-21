import java.io.IOException;
import java.util.Scanner;

public class ex2 {
    // receives arguments at execution
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String numb = scanner.nextLine();
        System.out.println(Integer.parseInt(numb) + 1 );
    }
}