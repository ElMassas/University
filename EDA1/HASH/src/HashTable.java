import Interfaces.HashTableInterface;
import java.util.Arrays;

public class HashTable<T extends Comparable<? super T>> implements HashTableInterface<T> {

    @SuppressWarnings("unchecked")
    //global variables
    private int occupied = 0;
    public int maxDiff  = 0;
    public Element<T> [] hashTable;
    public Element<T> [] newHashTable;


    public int getMaxDiff(){
        return maxDiff;
    }

    public void setMaxDiff(int n){
        this.maxDiff = n;
    }

    @SuppressWarnings("unchecked")
    public HashTable() {
        hashTable = (Element<T> []) new Element[691173];
        Arrays.fill(hashTable, null);
    }

    @SuppressWarnings("unchecked")
    public HashTable(int n) {
        hashTable = (Element<T> [])new Element[n];
        Arrays.fill(hashTable, null);
    }

    public boolean isActive( int currentIndex){
        return hashTable[currentIndex] != null && hashTable[currentIndex].active;
    }

    public int hashStrings( T string){
        int hashVal = 0;
        for( int i = 0; i < ((String) string).length();i++)
            hashVal += 31*hashVal + ((String) string).charAt( i );
        hashVal %= hashTable.length;
        if( hashVal < 0 )
            hashVal += hashTable.length;
        return hashVal % hashTable.length;
    }


    public boolean isEmpty(){
        return size() == 0;
    }

    public boolean isFull(){
        return size() == hashTable.length;
    }

    private static int nextPrime( int n )
    {
        if( n <= 0 )
            n = 3;

        if( n % 2 == 0 )
            n++;

        for( ; !isPrime( n ); n += 2 )
            ;

        return n;
    }

    private static boolean isPrime( int n )
    {
        if( n == 2 || n == 3 )
            return true;

        if( n == 1 || n % 2 == 0 )
            return false;

        for( int i = 3; i * i <= n; i += 2 )
            if( n % i == 0 )
                return false;

        return true;
    }

    @Override
    public int size() {
        return occupied;
    }

    @Override
    public float loadCapacity() {
        return occupied/hashTable.length;
    }

    @Override
    public int procPos(T x) {
        return Math.abs(x.hashCode()) % hashTable.length;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void allocateTable(int dim) {
        hashTable = (Element<T> []) new Element[dim];
        Arrays.fill(hashTable, null);
    }

    @Override
    public void makeEmpty() {
        Arrays.fill(hashTable, null);
    }

    @Override
    public T search(T x) {
        if(isEmpty()) { return null; }
        int posição = Math.abs(hashStrings(x) % hashTable.length);
        int stop = posição;
        while (posição < maxDiff){
            if (hashTable[posição].value != x){ posição++; }
            else {
                System.out.println("encotrou");
                return hashTable[posição].value; }
            }
        return null;
    }

    @Override
    public void remove(T x) {

        if( ++occupied == hashTable.length / 2){ rehash(); }
        hashTable[procPos(x)] = null;
        occupied--;
    }

    @Override
    public void insert(T x) {
        if (isActive(procPos(x))){return;}//already in the hashTable then does nothing
        hashTable[procPos(x)] = new Element<T>(x, true);
        occupied++;

        if( occupied > hashTable.length / 2){ rehash(); }
    }

    @Override
    public void rehash() {
        Element<T> [] oldArray = hashTable;
        allocateTable(nextPrime(hashTable.length * 2));
        for( int i = 0; i < oldArray.length; i++){
            if ( oldArray[i] != null){
                insert(oldArray[i].value);
            }
        }
    }

    @Override
    public void print() {
        System.out.println("\n HASHTABLE: ");
        System.out.println(toString());

    }

    public String toString() {
        String table = "";
        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[i] == null) {
                table += i + " | \n";
            } else {
                table += i + " | " + hashTable[i].value + "\n";
            }
        }
        return table;
    }

    /*public String toString(){
        StringBuffer buffer = new StringBuffer();

        buffer.append(System.getProperty("line.separator"));
        buffer.append("{");
        buffer.append(System.getProperty("line.separator"));

        for (int i = 0; i < this.hashTable.length; i++) {
            if (this.hashTable[i] != null) {
                buffer.append("\t" + "Element"this.hashTable[i].toString());
                buffer.append(System.getProperty("line.separator"));
            }
        }

        buffer.append("}");

        return buffer.toString();
    }*/
}
