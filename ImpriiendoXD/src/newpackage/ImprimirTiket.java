package newpackage;

import java.awt.*;
import java.awt.print.*;
import javax.print.PrintService;
import javax.print.attribute.*;
import javax.print.attribute.standard.*;
import static java.awt.print.Printable.PAGE_EXISTS;

public class ImprimirTiket implements Printable{
    private PrintService[] printService;
    private String tl, nb, fc, hr, tp;
    private int Tl1_1,Tl1_2,Tl1_3,Tl2_1,Tl2_2,Tl2_3,Tl3_1,Tl3_2,Tl3_3,Tl4_1,Tl4_2,Tl4_3,Tl5_1,Tl5_2,Tl5_3;
    private PrinterJob pj;
    private PrintRequestAttributeSet pras;

    public ImprimirTiket() {
        this.printService = PrinterJob.lookupPrintServices();
        pras = new HashPrintRequestAttributeSet();
        pras.add(MediaSizeName.ISO_A4);
        pras.add(new PageRanges(1,1));
        pras.add(new Copies(1));
        pj = PrinterJob.getPrinterJob();
        pj.setPrintable(this);
    }
    
    public void printTexto(String titulo,String nombre,String fecha,String hora,String tipo, int tl1_1,int tl1_2,int tl1_3, int tl2_1,int tl2_2,int tl2_3, int tl3_1,int tl3_2,int tl3_3, int tl4_1,int tl4_2,int tl4_3, int tl5_1,int tl5_2,int tl5_3) {
 
        tl = titulo;
        Tl1_1 = tl1_1;
        Tl1_2 = tl1_2;
        Tl1_3 = tl1_3;
            
        tp = tipo;
        Tl2_1 = tl2_1;
        Tl2_2 = tl2_2;
        Tl2_3 = tl2_3;
        
        nb = nombre;
        Tl3_1 = tl3_1;
        Tl3_2 = tl3_2;
        Tl3_3 = tl3_3;
        
        fc = fecha;
        Tl4_1 = tl4_1;
        Tl4_2 = tl4_2;
        Tl4_3 = tl4_3;
        
        hr = hora;
        Tl5_1 = tl5_1;
        Tl5_2 = tl5_2;
        Tl5_3 = tl5_3;
         

         
        try {
            pj.setPrintService(printService[1]);
            pj.print(pras);      
        } catch (PrinterException err) {
            System.err.println(err);
        }
    }
 
    public int print(Graphics g, PageFormat pf, int pageIndex) throws PrinterException {
        Graphics2D g2 = (Graphics2D) g; 
        g2.translate(pf.getImageableX(), pf.getImageableY());

        g.setFont(new Font("Arial Narrow", Font.PLAIN, Tl1_1));
        g.drawString(String.valueOf(tl), Tl1_2, Tl1_3);
        
        g.setFont(new Font("Arial Narrow", Font.PLAIN, Tl2_1));
        g.drawString(String.valueOf(tp), Tl2_2, Tl2_3);
        
        g.setFont(new Font("Arial Narrow", Font.PLAIN, Tl3_1));
        g.drawString(String.valueOf("Nombre: "+nb), Tl3_2, Tl3_3);
        
        g.setFont(new Font("Arial Narrow", Font.PLAIN, Tl4_1)); 
        g.drawString(String.valueOf("Fecha:  "+fc), Tl4_2, Tl4_3);
        
        g.setFont(new Font("Arial Narrow", Font.PLAIN, Tl5_1));
        g.drawString(String.valueOf("Hora:   "+hr), Tl5_2, Tl5_3);
        g.setColor(Color.white);
        g.setFont(new Font("Arial Narrow", Font.PLAIN, 13));
        g.drawString("no se vera ", 89, 110);
        g.dispose();
        return PAGE_EXISTS; 
    }
}

