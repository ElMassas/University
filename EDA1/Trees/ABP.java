import Interfaces.BinaryTree;

public class ABP<E extends Comparable<? super E>> implements BinaryTree<E> {


    //global varibles
    TreeNode<E> root;

    public ABP() {
        root = null;
    }

    public ABP(E object) {
        root = new TreeNode<E>(object);
    }

    @Override
    public boolean isEmpty() { return root == null; }

    @Override
    public boolean contains(E object) {
        TreeNode current = root;
        while(current != null){
            if(current.element == object){
                return true;
            }
            else if(current.element.compareTo(object) > 0){
                current = current.left;
            }else{
                current = current.right;
            }
        }
        return false;
    }

    @Override
    public E findMin(){
        return findMin(root);
    }

    private E findMin( TreeNode<E> node){
        while(node.left != null){
            node = node.left;
        }
        return node.element;
    }

    @Override
    public E findMax() {
        return findMax(root);
    }

    private E findMax( TreeNode<E> node){
        while(node.right != null){
            node = node.right;
        }
        return node.element;
    }

    @Override
    public void insere(E contactId) {
        root = insert(contactId, root);
    }

    @SuppressWarnings("Duplicates")
    private TreeNode insert(E object, TreeNode<E> node) {
        if (node == null) {
            node = new TreeNode<E>(object, null, null);
        }
        else if ((node.element).compareTo(object)>0) {
            node.left = insert(object, node.left);

        }
        else if((node.element).compareTo(object)<0) {
            node.right = insert(object, node.left);
        }
        return node;
    }

    @Override
    public void remove(E object) {
        root = remove(object, root);
    }

    //finds the node to delete and checks for deletion cases, dealing with them
    @SuppressWarnings("Duplicates")
    private TreeNode<E> remove( E object, TreeNode<E> node) {
        //search for the node
        if (node == null) {
            return node;
        }
        if (node.element.compareTo(object) < 0) {
            node.right = remove(object, node.right);
        }
        else if (node.element.compareTo(object) > 0) {
            node.left = remove(object, node.left);
        }
        //node found
        else if (node.left != null && node.right != null) {//if the parent node to delete has two child nodes
            E min = findMin(node.right);
            node.element = min;
            node.right = remove(min, node.right);
        }
        else if (node.left == null) {//case it has 1 child node
            node = node.right;
        } else {
            node = node.left; //case it has 1 child node
        }
        return node;
    }

    @Override
    public void printEmOrdem() {
        printInOrder(root);
    }

    private void printInOrder(TreeNode node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.println(node);
            printInOrder(node.right);
        }
    }

    @Override
    public void printPosOrdem() {
        printPostOrder(root);
    }

    private void printPostOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.println(node);
    }

    @Override
    public void printPreOrdem() {
        printPreOrder(root);

    }

    public void printPreOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node);
        printPreOrder(node.left);
        printPreOrder(node.right);
    }
}
