/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Estruturas;

/**
 *
 * @author Fabio
 */
public class NoQuad {
  private NoQuad nw;
  private NoQuad ne;
  private NoQuad sw;
  private NoQuad se;
  private Ponto ponto;
  private long posicaoArq;
  
  public NoQuad(long posicaoArq,Double latitude,Double longitude){ // Inicializa as variáveis
    this.ponto = new Ponto(latitude,longitude);
    this.posicaoArq = posicaoArq;
    this.nw=null;
    this.ne=null;
    this.sw=null;
    this.se=null;
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
    
    public Ponto getPonto() {
        return ponto;
    }
    
    public void setPosicaoArq(int posicaoArq) {
        this.posicaoArq = posicaoArq;
    }
    
    public NoQuad getFilho(NoQuad p,int quad){
      
      if(p != null){
        //System.out.println(quad);
        if(quad==1){
          return p.ne;
        }else if(quad==2){
          return p.se;
        }else if(quad==3){
          return p.sw;
        }else{
          return p.nw;
        }
      }else{
        return null;
      }
      
    }
    
    public void setFilho(NoQuad raiz,NoQuad no,int quad){
      if(quad==1){
          raiz.ne=no;
        }else if(quad==2){
          raiz.se=no;
        }else if(quad==3){
          raiz.sw=no;
        }else{
          raiz.nw=no;
        }
    }
   
}
