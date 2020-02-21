import java.io.IOException;

public class Hello {
    // receives arguments at execution
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < args.length; i++) {
            System.out.println("Hello " + args[i]);
        }
        /*Second method
        byte[] b = new byte[128];
        int lidos = System.in.read(b);
        String s = new String(b, 0, lidos - 1); // ou -2 no windows
        System.out.println("lido: " + lidos);
        System.out.println("s: " + s + "\n\n");
        int valor = Integer.parseInt(s.substring(0, lidos - 1));
        System.out.println("valor: " + valor);*/
    }
}