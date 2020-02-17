public class Main {

    public static void main(String[] args){
        ArrayStack stack = new ArrayStack(15);
        stack.push(25);
        stack.push(12);
        stack.push(50);
        while(stack.size() != 0){
            System.out.println(stack.pop());
        }
    }
}
