/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Estruturas;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Fabio
 */
public class QuadTree {
  
 private NoQuad raiz;
  
 public QuadTree(ArrayList<Dados> dados) throws FileNotFoundException, IOException {
     for(Iterator it = dados.iterator(); it.hasNext();){
            Dados d1 = (Dados)it.next();
            NoQuad n1 = new NoQuad(d1.getPosicaoArq(), d1.getPonto().getX(), d1.getPonto().getY());
            inserir(raiz, n1);
        }
        
     
 }
  public static int getQuadrante(Ponto p1,Ponto p2){
    if(p1.getX()<p2.getX()){
      if(p1.getY()<p2.getY()){
        return 4;
      }else{
        return 3;
      }
    }else{
      if(p1.getY()<p2.getY()){
        return 1;
      }else{
        return 2;
      }
    }
  }
  
  public void inserir(NoQuad raiz,NoQuad newPoint) throws FileNotFoundException, IOException{
    if(raiz!=null){
      while(raiz!=null){
        NoQuad filho=raiz.getFilho(raiz, QuadTree.getQuadrante(raiz.getPonto(), newPoint.getPonto()));
        if(filho==null){
          raiz.setFilho(raiz, newPoint, QuadTree.getQuadrante(raiz.getPonto(), newPoint.getPonto()));
        }
        raiz=filho;
      }      
    }else{
      this.raiz=newPoint;
    }
    
  }
  
  /**
     * retorna a raiz
     */
    public NoQuad getRaiz() {
        return this.raiz;
    }

    /**
     * Atribui a raiz o NoKD passado
     */
    public void setRaiz(NoQuad raiz) {
        this.raiz = raiz;
    }
    
    public long busca(NoQuad no,Ponto p) throws FileNotFoundException, IOException{
      long pos=-1;
      int i=0;
      do{        
        NoQuad filho=no.getFilho(no, QuadTree.getQuadrante(no.getPonto(),p));
        if(filho!=null){
          pos=filho.getPosicaoArq();
        }
        no=filho;
      }while(no!=null && QuadTree.distanciaPontos(no.getPonto(),p)!=0);
      return pos;
    }
    
    public static double distanciaPontos(Ponto p1,Ponto p2){
      return Math.sqrt( Math.pow( ( p1.getX() - p2.getX() ), 2) + Math.pow( ( p1.getY() - p2.getY() ), 2));
    }
    
}
