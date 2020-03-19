package paral01;


public class Paralelo extends Thread {
    
    
    public Paralelo() {
        super();
    }
    public Paralelo(String n) {
        super(n);
    }
    
    
    
    
    public void run() {
        //  em paralelo
    	String name= Thread.currentThread().getName();
        try {

	    for (int i=0; i<10; i++) {
        	System.out.println("# "+ name +" ponto 0");        	
		Thread.sleep(100);
	    }
	    // ...
	    
	    
	    System.out.println("\t# "+ name +" ponto 1");        	
        }
        catch (Exception e) {
	    e.printStackTrace();
        }
    }
    

    
    public static void main(String[] args) throws Exception {
	System.out.println("inicio ---------------------------");
	
	// 3 objectos do tipo Thread (subclasse Paralelo)
	Paralelo p1= new Paralelo();
	Paralelo p2= new Paralelo("thread-do-meio");
	Paralelo p3= new Paralelo();
	
	
	// lancar as 3, cada uma executara por si
        p1.start();
	p2.start();
	p3.start();
        
        p2.join();
         
                        
	
	
	System.out.println("fim ---------------------------");
	
    }
    
}