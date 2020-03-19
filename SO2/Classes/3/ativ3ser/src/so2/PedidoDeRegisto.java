/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so2;

/**
 *
 * @author massas
 */
public class PedidoDeRegisto extends Pedido {
 
    public Registo reg;
 
    public PedidoDeRegisto(Registo r) {
        this.reg= r;
    }
 
    public Registo getRegisto() {
        return reg;
    }
}