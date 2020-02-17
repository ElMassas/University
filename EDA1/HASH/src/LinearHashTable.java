
public class LinearHashTable<T extends Comparable<? super T>> extends HashTable<T> {

    public LinearHashTable(){
        super();
    }

    public LinearHashTable(int n){
        super(n);
    }

    //linear acess to the hashTable
    @Override
    public int procPos(T x) {
        int temp = 0;
        int position = Math.abs(hashStrings(x)) % hashTable.length;
        while ( hashTable[position] != null && !hashTable[position].value.equals(x)){
            position++;
            temp++;
            if(temp > getMaxDiff()){ setMaxDiff(temp); }
            if(position >= hashTable.length) position %= hashTable.length;
        }
        return position;
    }
}
