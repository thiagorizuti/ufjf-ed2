/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Estruturas;

/**
 *
 * @author Marcus
 */
public class Ponto {
    private Double x;
    private Double y;

    public Ponto(Double x, Double y){ // Inicializa as variáveis
        this.x= x;
        this.y= y;
        
    }
           
    /**
     * Retorna o x
     */
    public Double getX() {
        return x;
    }

    /**
     * Dado um parâmentro, atribui a x
     */
    public void setX(Double x) {
        this.x = x;
    }

    /**
     * Retorna o y
     */
    public Double getY() {
        return y;
    }

    /**
     * Dado um parâmentro, atribui a y
     */
    public void setY(Double y) {
        this.y = y;
    }
    
}
