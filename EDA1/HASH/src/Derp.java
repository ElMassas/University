/*
import java.io.*;
import java.util.StringTokenizer;

public class Derp {

    public LinearHashTable<String> table = new LinearHashTable<String>(50),
            notable = new LinearHashTable<String>(50),
            sugestao = new LinearHashTable<String>(50);
    private String t, limite = " .!,?;:_()[]$-@~/*#&\"";
    private String dictFile, errorFile, docFile;


    public Derp(String dictFile, String errorFile, String docFile) {
        this.dictFile = dictFile;
        this.errorFile = errorFile;
        this.docFile  = docFile;
    }

    public void spellCheck(String DocFile) {
        try {
            BufferedReader buffer = new BufferedReader(new FileReader(DocFile));
            StringTokenizer tokens;

            for (String line; (line = buffer.readLine()) != null; ) {
                tokens = new StringTokenizer(line, limite);
                while (tokens.hasMoreTokens()) {
                    t = tokens.nextToken();
                    System.out.println("token: " + t);

                    if(table.search(t) == null){
                        System.out.println("fuck me in the ass");
                    }else{
                        System.out.println(t + "is a correct word");
                    }
                    System.out.println("que se passa?");
                    */
/*int a = table.searchIndex(t);
                    if (a == -1) {
                        boolean Q = true;
                        for (int u = 0; u < notable.size(); u++) {
                            if (notable.hashTable[u].compareTo(t) == 0) {
                                Q = false;
                                break;
                            }
                        }
                        if(Q) {
                            System.out.println("here");
                            insertA(notable, t); // Erro na tabela.
                            insertA(notable, "-1"); // Separador de erros.
                            addCharacter(t);
                            removeCharacter(t);
                            switchCharacter(t);
                            insertA(sugestao,"-1"); // Diz o fim das sugestoes.
                        }
                    }*//*

                }
            }
        } catch(Exception e) {
            System.out.println("ERROR!");
        }
    }

    public void insertA(LinearHashTable<String> a, String x) {
        for (int j = 0; true; j++) {
            if (a.hashTable[j] != null) {
                a.hashTable[j].value = x;
                break;
            }
        }
    }

    public void addCharacter(String a) {
        for (int i = 0; i < a.length() + 1; i++) {
            String b = a.substring(0, i);
            String c = a.substring(i, a.length());
            for (char lower = 'a'; lower <= 'z'; lower++) {
                String g = b + lower + c;
                System.out.println(g);
                int z = table.searchIndex(g);
                if (z != -1) {
                    insertA(sugestao, g);
                }
            }
            for (char upper = 'A'; upper <= 'Z'; upper++) {
                String g = b + upper + c;
                int z = table.searchIndex(g);
                if (z != -1) {
                    insertA(sugestao, g);
                }
            }
        }
    }

    public void removeCharacter(String a) {
        for (int i = 0; i < a.length(); i++) {
            String b = a.substring(0, i);
            String c = a.substring(i + 1, a.length());
            int z = table.searchIndex(b + c);
            if (z != -1) {
                insertA(sugestao,b + c);
            }
        }
    }

    public void switchCharacter(String a) {
        for (int i = 0; i < a.length() - 1; i++) {
            char b = a.charAt(i);
            char c = a.charAt(i + 1);
            String b1 = "";
            if (i != 0) {
                b1 = a.substring(0, i);
            }
            String c1 = a.substring(i + 2, a.length());
            int z = table.searchIndex(b1 + c + b + c1);
            if (z != -1) {
                insertA(sugestao,b1 + c + b + c1);
            }
        }
    }

    public void read(String dictFile) {
        try {
            BufferedReader buffer = new BufferedReader(new FileReader(dictFile));
            //System.out.println("aqui");
            for (String line; (line = buffer.readLine()) != null; ) {
                //System.out.println("aqui");
                table.insert(line);
            }
        } catch(Exception e) {
            System.out.println("NOT FOUND!");
        }
    }

    public void generateFile(LinearHashTable<String> sugestion, String errorFile) {
        try {
            BufferedWriter buffer = new BufferedWriter(new FileWriter(errorFile));
            int i = 0;
            while (notable.hashTable[i] != null) {
                buffer.write(notable.hashTable[i] + ": ");

                while (sugestao.hashTable[i] != null) {
                    buffer.write(sugestao.hashTable[i] + "; ");
                }
                i += 2;
                buffer.newLine();
            }
            buffer.flush();
            buffer.close();

        } catch (Exception e) {
            System.out.println("ERROR!");
        }
    }

    public static void main(String[] args){
        System.out.println(new File(".").getAbsoluteFile());
        Derp corretor = new Derp("dicTeste.txt", "errorFile.txt", "docFile.txt");
        corretor.read("dicTeste.txt");
        System.out.println("spellChecK");
        corretor.spellCheck("docFile.txt");
        System.out.println("generateFile");
        corretor.table.print();
        System.out.println("****************");
        corretor.sugestao.print();
        corretor.generateFile(corretor.sugestao, "errorFile.txt");
    }
}

*/
