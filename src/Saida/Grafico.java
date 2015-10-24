/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Saida;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Marcus
 */
public class Grafico {
    
    
    public static void criaGraficoTempoLeitura(DefaultCategoryDataset ds) throws FileNotFoundException, IOException{
        JFreeChart grafico = ChartFactory.createBarChart("Tempo de Construção do Índice", "Metodo", "Tempo(s)", ds, PlotOrientation.VERTICAL, true, true, false);
        OutputStream arquivo = new FileOutputStream("output/graficoTempoLeitura.png");
        ChartUtilities.writeChartAsPNG(arquivo, grafico, 1024, 768);
        arquivo.close();
    }
    
    public static void criaGraficoTempoBusca(DefaultCategoryDataset ds) throws FileNotFoundException, IOException{
        JFreeChart grafico = ChartFactory.createBarChart("Tempo de Busca", "Método", "Tempo(s)", ds, PlotOrientation.VERTICAL, true, true, false);
        OutputStream arquivo = new FileOutputStream("output/graficoTempoBuscaRandomica.png");
        ChartUtilities.writeChartAsPNG(arquivo, grafico, 1024, 768);
        arquivo.close();
        
        
    }
    
    public static void criaGraficoMemoria(DefaultCategoryDataset ds) throws FileNotFoundException, IOException{
        JFreeChart grafico = ChartFactory.createBarChart("Memória", "Estrutura ", "Memória Utilizada(Mb)", ds, PlotOrientation.VERTICAL, true, true, false);
        OutputStream arquivo = new FileOutputStream("output/graficoMemoria.png");
        ChartUtilities.writeChartAsPNG(arquivo, grafico, 1024, 768);
        arquivo.close();
    }
    
    public static void criaGraficoBuscaLinear(DefaultCategoryDataset ds) throws FileNotFoundException, IOException{
        JFreeChart grafico = ChartFactory.createBarChart("Tempo de Busca", "Método", "Tempo(s)", ds, PlotOrientation.VERTICAL, true, true, false);
        OutputStream arquivo = new FileOutputStream("output/graficoTempoBuscaSequencial.png");
        ChartUtilities.writeChartAsPNG(arquivo, grafico, 1024, 768);
        arquivo.close();
    }
}
