package so2.rest.mapsample1;

/**
 *
 * @author jsaias
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LocationClient client= new LocationClient();
        String resp= client.getLocation("azaruja");
        System.err.println("RESPOSTA: "+resp);
        
    }
    
}
