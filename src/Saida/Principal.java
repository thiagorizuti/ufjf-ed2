/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Saida;

import Estruturas.ArvoreKD;
import Estruturas.Dados;
import Estruturas.NoKD;
import Estruturas.NoQuad;
import Estruturas.QuadTree;
import Leitura.Entrada;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Marcus
 */
public class Principal {
    public static void main(String Args[]) throws FileNotFoundException, IOException{
      
        Entrada e1 = new Entrada();
        long tempo_ini, tempo_fin, media, mem_ini, mem_fin;
        ArrayList<Long> tempos = new ArrayList<Long>();
        int i;
        DefaultCategoryDataset dsLeitura = new DefaultCategoryDataset();
        DefaultCategoryDataset dsBuscaLinear = new DefaultCategoryDataset();
        DefaultCategoryDataset dsBuscaRandomica = new DefaultCategoryDataset();
        
    	//TESTES LEITURA
        
        
        //Teste Leitura Randomica KDTree
        media = 0;
        tempos.clear();
        for (i=0;i<10;i++){
        	tempo_ini = System.currentTimeMillis();
        	ArrayList<Dados> dados = e1.lerRandomico();
        	ArvoreKD kdTree = new ArvoreKD();
        	kdTree.criaArvoreKD(dados);
        	tempo_fin = System.currentTimeMillis();
        	tempos.add(tempo_fin - tempo_ini);	
                kdTree = null;
        }
        for(i=0;i<tempos.size();i++){
            media = media + tempos.get(i);
        }
        dsLeitura.addValue((media/tempos.size()/1000f),"KDTree e Acesso Randomico","KDTree e Acesso Randomico");
        System.out.println("Teste Leitura Randomica KDTree");
        
        media = 0;
        tempos.clear();
        for (i=0;i<10;i++){
        	tempo_ini = System.currentTimeMillis();
        	ArrayList<Dados> dados = e1.lerRandomico2();
        	ArvoreKD kdTree = new ArvoreKD();
        	kdTree.criaArvoreKD(dados);
        	tempo_fin = System.currentTimeMillis();
        	tempos.add(tempo_fin - tempo_ini);	
                kdTree = null;
        }
        for(i=0;i<tempos.size();i++){
            media = media + tempos.get(i);
        }
        dsLeitura.addValue((media/tempos.size()/1000f),"KDTree e Acesso Sequencial","KDTree e Acesso Sequencial");
        System.out.println("Teste Leitura sequencial KDTree");
        
        media = 0;
        tempos.clear();
        for (i=0;i<10;i++){
        	tempo_ini = System.currentTimeMillis();
        	ArrayList<Dados> dados = e1.lerRandomico();
        	QuadTree quadTree = new QuadTree(dados);
        	tempo_fin = System.currentTimeMillis();
        	tempos.add(tempo_fin - tempo_ini);	
                quadTree = null;
        }
        for(i=0;i<tempos.size();i++){
            media = media + tempos.get(i);
        }
        dsLeitura.addValue((media/tempos.size()/1000f),"QuadTree e Acesso Randomico","QuadTree e Acesso Randomico");
        System.out.println("Teste Leitura Randomica QuadTree");
        
        media = 0;
        tempos.clear();
        for (i=0;i<10;i++){
        	tempo_ini = System.currentTimeMillis();
        	ArrayList<Dados> dados = e1.lerRandomico2();
        	QuadTree quadTree = new QuadTree(dados);
        	tempo_fin = System.currentTimeMillis();
        	tempos.add(tempo_fin - tempo_ini);	
                quadTree= null;
        }
        for(i=0;i<tempos.size();i++){
            media = media + tempos.get(i);
        }
        dsLeitura.addValue((media/tempos.size()/1000f),"QuadTree e Acesso Sequencial","QuadTree e Acesso Sequencial");
        System.out.println("Teste Leitura Sequencial QuadTree");
        
        //Teste Leitura Randomica Lista Encadeada
        media = 0;
        tempos.clear();
        for (i=0;i<10;i++){
        	tempo_ini = System.currentTimeMillis();
        	ArrayList<Dados> dados = e1.lerRandomico();
        	ArvoreKD lista = new ArvoreKD();
        	lista.criaLista(dados);
        	tempo_fin = System.currentTimeMillis();
        	tempos.add(tempo_fin - tempo_ini);	
                lista = null;
        }
        for(i=0;i<tempos.size();i++){
            media = media + tempos.get(i);
        }
        dsLeitura.addValue((media/tempos.size()/1000f),"Lista Encadeada e Acesso Randomico","Lista Encadeada e Acesso Randomico");
        System.out.println("Teste Leitura Randomica Lista");
        
        media = 0;
        tempos.clear();
        for (i=0;i<10;i++){
          tempo_ini = System.currentTimeMillis();
          ArrayList<Dados> dados = e1.lerRandomico2();
          ArvoreKD lista = new ArvoreKD();
          lista.criaLista(dados);
          tempo_fin = System.currentTimeMillis();
          tempos.add(tempo_fin - tempo_ini);	
          lista = null;
        }
        for(i=0;i<tempos.size();i++){
            media = media + tempos.get(i);
        }
        dsLeitura.addValue((media/tempos.size()/1000f),"Lista Encadeada e Acesso Sequencial","Lista Encadeada e Acesso Sequencial");
        System.out.println("Teste Leitura Sequencial Lista");
        
        Grafico.criaGraficoTempoLeitura(dsLeitura);
        
        ArrayList<Dados> dados = e1.lerRandomico();
        ArrayList<Dados> dadosBusca = e1.lerArqTeste();
        
        // Busca randomica KDTree
        ArvoreKD kdTree =new ArvoreKD();
        kdTree.criaArvoreKD(dados);
        media = 0;
        tempos.clear();
        for(i=0;i<10;i++){
        	tempo_ini = System.currentTimeMillis();
        	for (i=0;i<dadosBusca.size();i++){
        		NoKD noKD = kdTree.busca(kdTree.getRaiz(), dadosBusca.get(i).getPonto());
        		String s = Entrada.achaArq(noKD.getPosicaoArq());
        	}
        	tempo_fin = System.currentTimeMillis();
        	tempos.add(tempo_fin - tempo_ini);
        }
        
        for(i=0;i<tempos.size();i++){
            media = media + tempos.get(i);
        }
        
        dsBuscaRandomica.addValue((media/tempos.size()/1000f),"KDTree e Acesso Randomico","KDTree e Acesso Randomico");
        
        kdTree = null;
        System.out.println("Busca kdtree randomica");
        
        QuadTree quadTree = new QuadTree(dados);
        media = 0;
        tempos.clear();
        for(i=0;i<10;i++){
        	tempo_ini = System.currentTimeMillis();
        	for (i=0;i<dadosBusca.size();i++){
        		String s =Entrada.achaArq(quadTree.busca(quadTree.getRaiz(), dadosBusca.get(i).getPonto()));
        	}
        	tempo_fin = System.currentTimeMillis();
        	tempos.add(tempo_fin - tempo_ini);
        }
        for(i=0;i<tempos.size();i++){
            media = media + tempos.get(i);
        }
        dsBuscaRandomica.addValue((media/tempos.size()/1000f),"QuadTree e Acesso Randomico","QuadTree e Acesso Randomico");
        quadTree = null;
        System.out.println("Busca quadtree randomica");
        
        ArvoreKD lista= new ArvoreKD();
        lista.criaLista(dados);        
        media = 0;
        tempos.clear();
        for(i=0;i<10;i++){
        	tempo_ini = System.currentTimeMillis();
        	for (i=0;i<dadosBusca.size();i++){
        		String s = Entrada.achaArq(lista.buscaLista(lista.getRaiz(), dadosBusca.get(i).getPonto()).getPosicaoArq());
        	}
        	tempo_fin = System.currentTimeMillis();
        	tempos.add(tempo_fin - tempo_ini);
        }
        for(i=0;i<tempos.size();i++){
            media = media + tempos.get(i);
        }
        dsBuscaRandomica.addValue((media/tempos.size()/1000f),"Lista Encadeada e Acesso Randomico","Lista Encadeada e Acesso Randomico");
        lista = null;
        System.out.println("Busca lista randomica");
        
        Grafico.criaGraficoTempoBusca(dsBuscaRandomica);
        
        dados = e1.lerRandomico2();
        
        //Teste Busca Sequencial KDTree
        kdTree = new ArvoreKD();
        kdTree.criaArvoreKD(dados);
        media = 0;
        tempos.clear();
        for(i=0;i<10;i++){
        	tempo_ini = System.currentTimeMillis();
        	for (i=0;i<dadosBusca.size();i++){
        		NoKD noKD = kdTree.busca(kdTree.getRaiz(), dadosBusca.get(i).getPonto());
        		String s = Entrada.achaArq2(noKD.getPosicaoArq());
        	}
        	tempo_fin = System.currentTimeMillis();
        	tempos.add(tempo_fin - tempo_ini);
        }
        for(i=0;i<tempos.size();i++){
            media = media + tempos.get(i);
        }
        dsBuscaLinear.addValue((media/tempos.size()/1000f),"KDTree e Acesso Sequencial","KDTree e Acesso Sequencial");
        kdTree=null;
        
        quadTree = new QuadTree(dados);
        media = 0;
        tempos.clear();
        for(i=0;i<10;i++){
        	tempo_ini = System.currentTimeMillis();
        	for (i=0;i<dadosBusca.size();i++){
        		String s = Entrada.achaArq2(quadTree.busca(quadTree.getRaiz(), dadosBusca.get(i).getPonto()));
        	}
        	tempo_fin = System.currentTimeMillis();
        	tempos.add(tempo_fin - tempo_ini);
        }
        for(i=0;i<tempos.size();i++){
            media = media + tempos.get(i);
        }
        dsBuscaLinear.addValue((media/tempos.size()/1000f),"QuadTree e Acesso Sequencial","QuadTree e Acesso Sequencial");
        quadTree=null;
        
        lista = new ArvoreKD();
        lista.criaLista(dados);
        media = 0;
        tempos.clear();
        for(i=0;i<10;i++){
        	tempo_ini = System.currentTimeMillis();
        	for (i=0;i<dadosBusca.size();i++){
        		String s = Entrada.achaArq2(lista.buscaLista(lista.getRaiz(), dadosBusca.get(i).getPonto()).getPosicaoArq());
        	}
        	tempo_fin = System.currentTimeMillis();
        	tempos.add(tempo_fin - tempo_ini);
        }
        for(i=0;i<tempos.size();i++){
            media = media + tempos.get(i);
        }
        dsBuscaLinear.addValue((media/tempos.size()/1000f),"Lista Encadeada e Acesso Sequencial","Lista Encadeada e Acesso Sequencial");
        lista=null;
        
        Grafico.criaGraficoBuscaLinear(dsBuscaLinear);
    }
        

}
