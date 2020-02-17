public class Agenda<E extends Comparable<? super E>> {

    AVL<E> listaContactos = new AVL<E>();

    /*public void adicionar(E contacto){
       listaContactos.insere(contacto);
    }

    public void editar(E contacto){
        listaContactos.remove(contacto);
        listaContactos.insere(contacto);

    }
*/
    public void remover(E contacto){
        listaContactos.remove(contacto);
    }

    public void listar(){
        listaContactos.printEmOrdem();
    }

    public E chamador(E contacto){
         if( listaContactos.contains(contacto) ){
             return contacto;
         }
         return contacto;
    }



    public static void main(String[] args){

        AVL temp = new AVL<>();

        /*temp.insere(10);
        temp.printPreOrdem();
        System.out.println("*************");
        temp.insere(20);
        temp.printPreOrdem();
        System.out.println("*************");
        temp.insere(30);
        temp.printPreOrdem();
        System.out.println("*************");
        temp.insere(40);
        temp.printPreOrdem();
        System.out.println("*************");
        temp.insere(50);
        temp.printPreOrdem();
        System.out.println("*************");
        temp.insere(25);
        temp.printPreOrdem();
        System.out.println("*************");
        temp.insere(45);
        temp.printPreOrdem();
        System.out.println("*************");*//*
        temp.remove(25);
        temp.printPreOrdem();
        System.out.println("*************");
        System.out.println("*************");
        temp.remove(50);
        temp.printPreOrdem();
        System.out.println("finished");*/

        //temp.printPreOrdem();
    }

}
