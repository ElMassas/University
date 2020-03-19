package so2.rmi;

import java.util.Vector;

public interface Palavras extends java.rmi.Remote {

    public String primeiraPalavra(String s) throws java.rmi.RemoteException;

    public Vector<String> divide(String s) throws java.rmi.RemoteException;

}
