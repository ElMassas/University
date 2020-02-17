public class Element<T> implements Comparable<String> {

    public T value;//valor a inserir
    public String toStringValue = (String) value;
    public boolean active;//false quando o elemento está apagado


    public Element(T value){
        this( value, true);
    }

    public Element(T value, boolean active) {
        this.value = value;
        this.active = active;
    }

    public String toString(){
        return (String) value;
    }


    public int compareTo(String t) {
        return this.toStringValue.compareTo(t);

    }
}
