/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Leitura;

import Estruturas.Dados;
import Estruturas.Ponto;
import static Leitura.Entrada.convertUTF8toISO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;


    
    
   
/**
 *
 * @author Marcus
 */
public class Entrada {
    
    private static File arq= new File(System.getProperty("user.dir"), "US.txt");
    
    public ArrayList<Dados> lerRandomico() throws FileNotFoundException, IOException{//guarda o byte que inicia a linha
        FileReader leitor = new FileReader(arq);
        BufferedReader buffer = new BufferedReader(leitor);
        String linha= "";
        long posArq = 0;
        ArrayList<Dados> dados = new ArrayList<Dados>();
        
        while(((linha = buffer.readLine()) != null)){
            byte b[] = linha.getBytes();
            long tam = b.length;
            String s[] = linha.split("\t");// quebra a string dado o caractere tabulation
            Double latitude = Double.parseDouble(s[4]);
            Double longitude = Double.parseDouble(s[5]);
            Dados d1 = new Dados(posArq, new Ponto(latitude, longitude));
            dados.add(d1);
            posArq+=tam+1;//soma o caractere /n
        }
        return dados;
    }
     public ArrayList<Dados> lerRandomico2() throws FileNotFoundException, IOException{//guarda o numero da linha
        FileReader leitor = new FileReader(arq);
        BufferedReader buffer = new BufferedReader(leitor);
        String linha= "";
        long posArq = 0;
        ArrayList<Dados> dados = new ArrayList<Dados>();
        
        while(((linha = buffer.readLine()) != null)){
            
            String s[] = linha.split("\t");// quebra a string dado o caractere tabulation
            Double latitude = Double.parseDouble(s[4]);
            Double longitude = Double.parseDouble(s[5]);
            Dados d1 = new Dados(posArq, new Ponto(latitude, longitude));
            dados.add(d1);
            posArq++;//incrementa a linha
        }
        return dados;
    }
     public ArrayList<Dados> lerArqTeste() throws FileNotFoundException, IOException{
        File f1 = new File(System.getProperty("user.dir"),"input/BR.txt");
        FileReader leitor = new FileReader(f1);
        BufferedReader buffer = new BufferedReader(leitor);
        String linha= "";
        ArrayList<Dados> dados = new ArrayList<Dados>();
        
        while(((linha = buffer.readLine()) != null)){
            
            String s[] = linha.split("\t");// quebra a string dado o caractere tabulation
            Double latitude = Double.parseDouble(s[4]);
            Double longitude = Double.parseDouble(s[5]);
            Dados d1 = new Dados(0, new Ponto(latitude, longitude));
            dados.add(d1);
            
        }
        return dados; 
     }
    
    
    public static String achaArq(long index) throws FileNotFoundException, IOException{//procura pelo byte que inicia a linha
        RandomAccessFile random = new RandomAccessFile(arq, "r");
        random.seek(index);//posiciona na linha a ser lida
        String linha = random.readLine();
        String s[] = linha.split("\t");
        random.close();
        return convertUTF8toISO(s[1]);
    }
    public static String achaArq2(long index) throws FileNotFoundException, IOException{//procura pelo numero da linha
        FileReader leitor = new FileReader(arq);
        BufferedReader buffer = new BufferedReader(leitor);
        long i=0;
        String linha= "";
        while((i!= index)){
            linha = buffer.readLine();
            i++;
        }
        String s[]= linha.split("\t");
        return s[1];
    }
    
    public static String convertUTF8toISO(String str) {
      String ret = null;
      try {
        ret = new String(str.getBytes("ISO-8859-1"), "UTF-8");
      }
      catch (java.io.UnsupportedEncodingException e) {
        return null;
      }
      return ret;
    }
  
}
