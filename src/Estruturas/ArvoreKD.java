/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Estruturas;

import static Estruturas.ArvoreKD.desenha;
import Leitura.Entrada;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Marcus
 */
public class ArvoreKD {
    
    private NoKD raiz=null;
    
    public void criaArvoreKD(ArrayList<Dados> dados) throws IOException{
        Iterator it = dados.iterator();
        raiz=null;       
        while(it.hasNext()){
            Dados d1 = (Dados)it.next();
            NoKD n1 = new NoKD(d1.getPosicaoArq(), d1.getPonto().getX(), d1.getPonto().getY());
            inserir(n1, raiz);
        }
        
    }
    public NoKD inserir(NoKD no, NoKD raiz) throws IOException {
        
        if (raiz != null) { // Testa se a raiz não é nula
                if (raiz.nivelEhPar()) { // Se o nível é par, compara pela latitude (x)
                       
                        if (no.getLatitude() <= raiz.getLatitude()) {  // Se a latitude(x) é menor

                                if (raiz.getEsq() == null) { // Se é nulo, insere
                                        no.setNivel(raiz.getNivel() + 1);
                                        no.setPai(raiz);
                                        raiz.setEsq(no);
                                        
                                } 
                                else { // Se não é nulo, chama resursão para o filho esquerdo
                                        inserir(no, raiz.getEsq());
                                }
                                
                        } 
                        else { // Se a latitude (x) é maior

                                if (raiz.getDir() == null) { // Se é nulo, insere
                                        no.setNivel(raiz.getNivel() + 1);
                                        no.setPai(raiz);
                                        raiz.setDir(no);
                                        
                                } 
                                else { // Se não é nulo, chama resursão para o filho direito
                                        inserir(no, raiz.getDir());
                                }
                        }
                        
                } 
                else { // Se o nível é ímpar, compara pela longitude (y)
                        
                        if (no.getLongitude() <= raiz.getLongitude()) { // Se a longitude(y) é menor

                                if (raiz.getEsq() == null) { // Se é nulo, insere
                                        no.setNivel(raiz.getNivel() + 1);
                                        no.setPai(raiz);
                                        raiz.setEsq(no);
                                        
                                } 
                                else { // Se não é nulo, chama resursão para o filho esquerdo
                                        inserir(no, raiz.getEsq());
                                }
                                
                        } 
                        else { // // Se a longitude (y) é maior

                                if (raiz.getDir() == null) {// Se é nulo, insere
                                        no.setNivel(raiz.getNivel() + 1);
                                        no.setPai(raiz);
                                        raiz.setDir(no);
                                       
                                } 
                                else { // Se não é nulo, chama resursão para o filho direito
                                        inserir(no, raiz.getDir());
                                }
                        }
                }
        } 
        else { // Se é nula, insere o no como raiz
                
                this.setRaiz(no);
        }

        return no;
    }
    
    
    /**
     * retorna a raiz
     */
    public NoKD getRaiz() {
        return this.raiz;
    }

    /**
     * Atribui a raiz o NoKD passado
     */
    public void setRaiz(NoKD raiz) {
        this.raiz = raiz;
    }
    // Desenha a arvore na tela
    public static void desenha(NoKD raiz, Graphics2D g,Color color){
        if(raiz != null){
            
            desenha(raiz.getEsq(),g,color);
            
            Rectangle2D rect = new Rectangle2D.Double();
            g.setColor(color);
            //multiplica por -1 a latitude pois o sistema de coordenadas da tela é diferente do cartesiano
            rect = new Rectangle2D.Double(raiz.getPonto().getY(), raiz.getPonto().getX()*(-1), 0.1, 0.1);
            g.fill(rect);
            desenha(raiz.getDir(),g,color);
            
        }
    }
    
    // Calcula a distancia entre dois pontos
    public static double distanciaPontos(Ponto p1,Ponto p2){
        return Math.sqrt( Math.pow( ( p1.getX() - p2.getX() ), 2) + Math.pow( ( p1.getY() - p2.getY() ), 2));
    }
    
     public NoKD busca(NoKD raiz,Ponto p){
       
      
      if(p.getX().equals(raiz.getPonto().getX()) && p.getY().equals(raiz.getPonto().getY())){
        
        return raiz; 
        
      }else{
        
        if(raiz.getDir()==null && raiz.getEsq()==null){
           
        }else{
          // Se for um nivel par verifica o ponto x
          if ((raiz.nivelEhPar() && p.getX()<raiz.getLatitude()) || (!raiz.nivelEhPar() && p.getY()<raiz.getLongitude())) {

            if (raiz.nivelEhPar()) {      

              // Verifica se o ponto pode ter um filho dentro da menor menorDistancia calculada
              if (p.getX() <= raiz.getLatitude() && raiz.getEsq()!=null) {
                return busca(raiz.getEsq(),p);
              }
              if(p.getX() > raiz.getLatitude() && raiz.getDir()!=null) {
                return busca(raiz.getDir(),p);
              }

            }else{

              if (p.getY() <= raiz.getLongitude() && raiz.getEsq()!=null) {
                return busca(raiz.getEsq(),p);
              }

              if(p.getY() > raiz.getLongitude() && raiz.getDir()!=null) {
                return busca(raiz.getDir(),p);
              }

            }

          }else{

            if(raiz.nivelEhPar()){

              if(p.getX()>raiz.getLatitude() && raiz.getDir()!=null){
                return busca(raiz.getDir(),p);
              }
              if(p.getX()<=raiz.getLatitude() && raiz.getEsq()!=null){
                return busca(raiz.getEsq(),p);
              }

            }else{
              if(p.getY()>raiz.getLongitude() && raiz.getDir()!=null){
                return busca(raiz.getDir(),p);
              }
              if(p.getY()<=raiz.getLongitude() && raiz.getEsq()!=null){
                return busca(raiz.getEsq(),p);
              }        
              
            }

          }       
          
        }
  
      }     
      return null;
    }
    
    public void criaLista(ArrayList<Dados> dados){
    	for(Iterator it = dados.iterator(); it.hasNext();){
            Dados d1 = (Dados)it.next();
            NoKD n1 = new NoKD(d1.getPosicaoArq(), d1.getPonto().getX(), d1.getPonto().getY());
            insereListaEncadeada(raiz, n1);
        }
    	
    }
 // Matodo que insere na lista encadeada, dados a raiz e o no a ser inserido;
    public NoKD insereListaEncadeada(NoKD raiz, NoKD no) {
        if(raiz == null){ // Testa se a raiz � nula;
            this.setRaiz(no); // Se �, insere;
        }
        else { 
            no.setDir(raiz); // Se n�o �, insere no come�o, fazendo o proximo do no inserido receber a raiz;        
            this.setRaiz(no);
        }
        return no;    
    }
    
    // Metodo que busca se o ponto passado existe na lista encadeada;
    public NoKD buscaLista(NoKD raiz, Ponto p)
    {
        if(raiz == null) return null;
        else{
            NoKD aux = raiz;

            while(!(aux.getPonto().getX().equals(p.getX()) && aux.getPonto().getY().equals(p.getY()) && aux!=null)){
                aux = aux.getDir();

            }
            return aux;
        }
    }
   
}