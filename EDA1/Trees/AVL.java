import Interfaces.BinaryTree;

public class AVL<E extends Comparable<? super E>> implements BinaryTree<E>{

    //global variables
    TreeNode<E> root;


    public AVL() {
        root = null;
    }

    public AVL(E object) {
        root = new TreeNode<E>(object);
    }

    public int height() {
        if (this.isEmpty()) {
            return 0;
        } else {
            return height(root);
        }
    }

    public int height(TreeNode<E> node) {
        if (node == null) {
            return -1;
        }

        int hLeft = height(node.left);
        int hRight = height(node.right);

        return Math.max(hLeft, hRight) + 1;
    }

    public int getBalance(TreeNode<E> node){
            if( node == null){ return 0; }
            return height(node.left) - height(node.right);
    }

    private TreeNode RightRotation(TreeNode<E> node) {
       // System.out.println("Right rotation");

        /*TreeNode<E> newNode = node.left;
        node.left = newNode.right;
        newNode.right = node;*/

        TreeNode<E> newNode = node.left;
        TreeNode<E>  tempNode = newNode.right;

        newNode.right = node;
        node.left = tempNode;

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        newNode.height = Math.max(height(newNode.left), height(newNode.right)) + 1;

        return newNode;
    }

    private TreeNode LeftRotation(TreeNode<E> node) {
        //System.out.println("Left rotation");

        /*TreeNode<E> newNode = node.right;
        node.right = newNode.left;
        newNode.left = node;*/

        TreeNode<E> newNode = node.right;
        TreeNode<E> tempNode = newNode.left;

        newNode.left = node;
        node.right = tempNode;

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        newNode.height = Math.max(height(newNode.left), height(newNode.right)) + 1;

        return newNode;
    }
    
    @Override
    public boolean isEmpty() { return root == null;  }

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

    public E containsE(E object) {
        return object;
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

    //just to make it easier to read the code further ahead


    @Override
    public void insere(E contactId) {
        root = insert(contactId, root);
    }

    @SuppressWarnings("Duplicates")
    private TreeNode insert(E object, TreeNode<E> node) {
        //System.out.println("insert");
        if (node == null) {
            //System.out.println("new node creation");
            node = new TreeNode<E>(object, null, null);
        }
        else if (object.compareTo(node.element) < 0) {
            //System.out.println("node change 1");
            node.left = insert(object, node.left);
            node.height = 1 + Math.max(height(node.left),height(node.right));

        }
        else if(object.compareTo(node.element) > 0) {
            //System.out.println("node change 2");
            node.right = insert(object, node.left);
            node.height = 1 + Math.max(height(node.left),height(node.right));
        }


        int balance = getBalance(node);

        if ( balance > 1 && object.compareTo(node.left.element) < 0) {
            //System.out.println("call 1");
            return RightRotation(node);
        }
        else if ( balance > 1 && object.compareTo(node.left.element) > 0) {
            //System.out.println("call 2");
            node.left = LeftRotation(node.left);
            return RightRotation(node);
        }
        else if ( balance < -1 && object.compareTo(node.right.element) > 0) {
            //System.out.println("call 3");
            return LeftRotation(node);
        }
        else if ( balance < -1 && object.compareTo(node.right.element) < 0) {
            //System.out.println("call 4");
            node.right = RightRotation(node.right);
            return LeftRotation(node);
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

        //node search
        if (node == null) { return node; }
        if (object.compareTo(node.element) < 0) {
            System.out.println("left\n");
            System.out.println(node.left);
            System.out.println(node.right);
            node.left = remove(object, node.left);
        }
        else if (object.compareTo(node.element) > 0) {
            System.out.println("right\n");
            System.out.println(node.left);
            System.out.println(node.right);
            node.right = remove(object, node.right);
        }

        //node found
        else {
            System.out.println("elemento a remover encontrado");
            //node with one child or none
            System.out.println(node.left);
            System.out.println(node.right);
            if (node.left == null || node.right == null) {

                TreeNode<E> current = new TreeNode<E>(null, null, null);
                if (current == node.left) {
                    System.out.println("node.left");
                    current = node.right;
                } else {
                    System.out.println("node.right");
                    current = node.left;
                }

                //in case the node doesn't have any children
                if (current == null) {
                    System.out.println("no child");
                    //current = node;
                    node = null;
                }
                else {
                    node = current;
                }
            } else/*if(node.left != null && node.right != null)*/ {
                System.out.println("2 childs");
                E current = findMin(node.right);
                root.element = current;
                node.right = remove(current, node.right);
            }
        }


        int balance = getBalance(node);

        if ( balance > 1 && object.compareTo(node.left.element) < 0) {
            System.out.println("call 1");
            return RightRotation(node);
        }
        else if ( balance > 1 && object.compareTo(node.left.element) > 0) {
            System.out.println("call 2");
            node.left = LeftRotation(node.left);
            return RightRotation(node);
        }
        else if ( balance < -1 && object.compareTo(node.right.element) > 0) {
            System.out.println("call 3");
            return LeftRotation(node);
        }
        else if ( balance < -1 && object.compareTo(node.right.element) < 0) {
            System.out.println("call 4");
            node.right = RightRotation(node.right);
            return LeftRotation(node);
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
