/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Estruturas;

/**
 *
 * @author Marcus
 */
public class NoKD {
    
    private NoKD esq,dir,pai;
    private int nivel;
    private long posicaoArq;
    private Ponto ponto;
    private String featureClass;
    private String featureCode;
    private String geonameid;
    
    public NoKD(long posicaoArq,Double latitude,Double longitude){ // Inicializa as variáveis
        this.ponto = null;
        ponto = new Ponto(latitude, longitude);
        this.posicaoArq = posicaoArq;
        
        
    }

    /**
     * Retorna a posicaoArq
     */
    public long getPosicaoArq() {
        return posicaoArq;
    }

    /**
     * Retorna a latitude
     */
    public double getLatitude() {
        return getPonto().getX();
    }

    /**
     * Retorna a longitude
     */
    public double getLongitude() {
        return getPonto().getY();
    }

    /**
     * Retorna a featureClass
     */
    public String getFeatureClass() {
        return featureClass;
    }

    /**
     * Retorna a featureCode
     */
    public String getFeatureCode() {
        return featureCode;
    }

    /**
     * Retorna a geonameid
     */
    public String getGeonameid() {
        return geonameid;
    }

    /**
     * Retorna o no a esquerda
     */
    public NoKD getEsq() {
        return esq;
    }

    /**
     * Dado um parâmentro, atribui ao no a esquerda
     */
    public void setEsq(NoKD esq) {
        this.esq = esq;
    }

    /**
     * Retorna o no a direita
     */
    public NoKD getDir() {
        return dir;
    }

    /**
     * Dado um parâmetro, atribui ao no a direita
     */
    public void setDir(NoKD dir) {
        this.dir = dir;
    }

    /**
     * Retorna o no pai
     */
    public NoKD getPai() {
        return pai;
    }

    /**
     * Dado um parâmetro, atribui ao no pai
     */
    public void setPai(NoKD pai) {
        this.pai = pai;
    }

    /**
     * Dado um parâmetro, atribui a posicaoArq
     */
    public void setPosicaoArq(int posicaoArq) {
        this.posicaoArq = posicaoArq;
    }

    /**
     * @param latitude the latitude to set
     */
    

    /**
     * Dado um parâmetro, atribui a featureClass
     */
    public void setFeatureClass(String featureClass) {
        this.featureClass = featureClass;
    }

    /**
     * Dado um parâmetro, atribui a featureCode
     */
    public void setFeatureCode(String featureCode) {
        this.featureCode = featureCode;
    }

    /**
     * Dado um parâmetro, atribui a geonameid
     */
    public void setGeonameid(String geonameid) {
        this.geonameid = geonameid;
    }

    /**
     * Retorna o nivel
     */
    public int getNivel() {
        return nivel;
    }

    /**
     * Dado um parâmetro, atribui ao nível
     */
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
    /**
     * Verifica o nível 
     */
    
    public boolean nivelEhPar() {
        return (this.getNivel() % 2) == 0;
    }

    /**
     * Retorna o ponto
     */
    public Ponto getPonto() {
        return ponto;
    }
    
    
}
