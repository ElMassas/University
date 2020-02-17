public class TreeNode<E extends Comparable<? super E>>{
    E element;
    E phoneNumber1;
    E phoneNumber2;
    TreeNode<E> left;
    TreeNode<E> right;
    int height;

    //constructors
    public TreeNode(E object) {
        this.element = object;
        this.left = null;
        this.right = null;
        this.height = 0;
    }

    public TreeNode(E object, TreeNode<E> left, TreeNode<E> right) {
        this.element = object;
        this.left = left;
        this.right = right;
    }

    public String toString() {
        return element.toString();
    }
}
