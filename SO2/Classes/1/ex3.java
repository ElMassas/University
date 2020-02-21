import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class ex3 {

    static LinkedList<String> names = new LinkedList<String>();
    static LinkedList<String> sorted = new LinkedList<String>();
    static int position;



    public static void sort(String name) {
        position = 0;  

        for (; position < names.size(); position++) {

            if (sorted.isEmpty())
                sorted.add(name);

            if (names.get(position).compareTo(name) > 0){
                System.out.println(sorted);
                sorted.add(position, name);
                position = 0;
                break;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String name = null;

        while (true) {
            name = scanner.nextLine();
            if(!name.isEmpty()){
                names.add((name));
                sort(name);
                continue;
            }
            else
                break;
        }
        
        scanner.close();
        System.out.println(sorted);
    }
}
