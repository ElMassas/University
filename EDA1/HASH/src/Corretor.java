import java.io.BufferedReader;
import java.io.FileReader;

public class Corretor{



    /*public void read(String dictFile) {
        try {
            BufferedReader buffer = new BufferedReader(new FileReader(dictFile));
            for (String line; (line = buffer.readLine()) != null; ) {
                table.insert(line);
            }
        } catch(Exception e) {
            System.out.println("NOT FOUND!");
        }
    }*/

    public static void mainO(String[] args){
        QuadHashTable<String> doesItWork = new QuadHashTable<String>(20);

        doesItWork.insert("oir");
        doesItWork.insert("ok");
        doesItWork.insert("vagina");
        doesItWork.insert(":O");
        doesItWork.insert("UwU");
        doesItWork.print();
    }
}