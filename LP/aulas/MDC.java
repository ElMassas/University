package LP.aulas;

import java.io.IOException;

public class MDC {

    public static int mdc(int a , int b){
        if (a == b)
            return a;
        else if( b > a)
            return mdc(a, b - a);
        else 
            return mdc(a -b, a);
    }
    public static void main(String[] args) throws IOException {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        System.out.println(mdc(a, b));
    }
}