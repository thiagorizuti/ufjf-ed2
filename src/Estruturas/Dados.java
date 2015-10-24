/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Estruturas;

/**
 *
 * @author Marcus
 */
public class Dados {
    private long posicaoArq;
    private Ponto ponto;
    

    public Dados(long posicaoArq,Ponto ponto){
      
        this.posicaoArq = posicaoArq;
        this.ponto = ponto;
    }
    /**
     * @return the posicaoArq
     */
    public long getPosicaoArq() {
        return posicaoArq;
    }

    /**
     * @return the ponto
     */
    public Ponto getPonto() {
        return ponto;
    }

    /**
     * @return the featureClass
     */
   
    
}
