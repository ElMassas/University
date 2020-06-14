package so2.rest.mapsample1;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * @author jsaias
 */
public class LocationClient {
    private Client client;

    
    /*
    NOTE: este é um pequeno exemplo para um teste rápido. 
    Não deve ter configurações no código fonte.
    */
    String BASE_URL= "http://dev.virtualearth.net/REST/v1/Locations/PT/";
    String URL_SUFFIX= "?o=xml&key=AnhaVcnJ9Vdgv3OsKODZcn_uLSR5Z_SkiYHqvx-dRVuRIb1AVB1dAjzi0TOGkbOy";
    /*
    Num cenário real, pode registar-se no fornecedor de serviço e criar uma chave de serviço,
    para não ficar dependente de um serviço partilhado e limitado.
    No caso, sera em: https://www.bingmapsportal.com/
    */
    

    public LocationClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
    }

    public String getLocation(String address) throws ClientErrorException {
        WebTarget webTarget = client.target(BASE_URL+address+URL_SUFFIX);
        return webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
    }

    public void close() {
        client.close();
    }
    
}
