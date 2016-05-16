
package newpackage;

import com.sun.xml.internal.fastinfoset.EncodingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Label;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Matias
 */
public class HiloTiket extends Thread{
    ImprimirTiket im;
    private boolean seguir;
    
    public HiloTiket(JLabel lbl){
        im = new ImprimirTiket();
        seguir = true;
    }
    public void parar(){
        seguir = false;
    }
    
  
    public void run(String titulo,String nombre,String fecha,String hora,String tipo, int tl1_1,int tl1_2,int tl1_3, int tl2_1,int tl2_2,int tl2_3, int tl3_1,int tl3_2,int tl3_3, int tl4_1,int tl4_2,int tl4_3, int tl5_1,int tl5_2,int tl5_3){    
        while ( seguir == true){     
            
                im.printTexto(titulo, nombre, fecha, hora, tipo, tl1_1, tl1_2, tl1_3, tl2_1, tl2_2, tl2_3, tl3_1, tl3_2, tl3_3, tl4_1, tl4_2, tl4_3, tl5_1, tl5_2, tl5_3);
                
                this.parar();

        }       
    }
}
