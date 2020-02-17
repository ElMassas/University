
public class QuadHashTable<T extends Comparable<? super T>> extends HashTable<T> {

   public QuadHashTable(){
       super();
   }

   public QuadHashTable(int n){
       super(n);
   }

    //quadratic acess to the hashtable
    @Override
    public int procPos(T x) {
       int colisões = 1;
        int position = Math.abs(hashStrings(x)) % hashTable.length;
        while ( hashTable[position] != null && !hashTable[position].value.equals(x)){
            position += colisões * colisões;
            colisões++;
            if( colisões > getMaxDiff()) { setMaxDiff(colisões); }
            if(position >= hashTable.length) position %= hashTable.length;
        }
        return position;
    }
}
