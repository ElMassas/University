import java.util.Scanner;
import java.util.Arrays;

public class Sort<T extends Comparable<? super T>> {

    public static Comparable[] input_values = (Comparable[]) new Comparable[0];
    public static Comparable[] tempo =  (Comparable[]) new Comparable[6];



    //bubble sort
    public static void method1(Comparable[] A){
        while (true){
            boolean alteração = false;
            for (int i = 0; i < A.length - 1; i++){
                Comparable tempValue = 0;
                if( A[i].compareTo(A[i+1]) == 1){
                    tempValue = A[i];
                    A[i] = A[i+1];
                    A[i+1] = tempValue;
                    alteração = true;
                }
            }
            if(alteração == false){break;}
        }
        printArray(A);
    }



    /*
    ****************SELECTION*****************
    *Accepts equal values
    */
    public static void method2(Comparable[] A){
        for(int i = 0; i < A.length; i++){
            int tempIndex = getMinValue(A, i);
            Comparable tempValue = A[i];
            A[i] = A[tempIndex];
            A[tempIndex] = tempValue;
        }
    }

    public static int getMinValue(Comparable[] A, int startingIndex) {
        Comparable minValue = A[startingIndex];
        int minIndex = startingIndex;
        for (int i = 0 + startingIndex; i < A.length; i++){
            if (minValue.compareTo(A[i]) >= 0) {
                System.out.println("value: " + minValue);
                minValue = A[i];
                System.out.println("Index: " + minIndex);
                minIndex = i;
            }
        }
        return minIndex;
    }



    public static Comparable[] le_array(){
        Scanner reader = new Scanner(System.in);
        int index = 0;
        try{
            while(true){
                String temp = reader.nextLine();
                if(temp.equals("")){ break; }
                increaseArraySize();
                input_values[index] = Integer.parseInt(temp);
                index++;
            }
        }catch (NumberFormatException exc){
            if (reader != null);
            reader.close();
        }
        return input_values;
    }

    public static void printArray(Object[] x){
        String convertToString = "";
        for(int i = 0; i <= x.length-1; i++){
            convertToString += " " + x[i];
        }
        System.out.println(convertToString);
    }

    public static void increaseArraySize(){
        Comparable[] temp = (Comparable[]) new Comparable[input_values.length + 1];
        for( int i = 0; i < input_values.length; i++ ){
            temp[i] = input_values[i];
        }
        temp[temp.length -1] = null;
        input_values = (Comparable[]) new Comparable[temp.length];
        for( int i = 0; i < temp.length; i++){
            input_values[i] = temp[i];
        }
    }

    public static void main(String[] args){

        /*tempo[0] = 3;
        tempo[1] = 2;
        tempo[2] = 5;
        tempo[3] = 10;
        tempo[4] = 7;
        tempo[5] = 7;




        */
        method1(le_array());
        //printArray(tempo);
    }
}

