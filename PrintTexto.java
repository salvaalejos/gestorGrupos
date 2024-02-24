package Proyecto_POO_New;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.print.*;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;

public class PrintTexto implements java.awt.print.Printable{
    private String texto;
    PrintTexto(String texto){
        this.texto = texto;
    }
    @Override
        public int print(Graphics g, java.awt.print.PageFormat pf, int pageIndex){
            if (pageIndex > 0){
                return NO_SUCH_PAGE;
            }
            Font font = new Font("Arial", Font.PLAIN, 12);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setFont(font);
            
            int x = (int) pf.getImageableX();
            int y = (int) pf.getImageableY()+15;
            g2d.drawString(this.texto, x, y);
            return PAGE_EXISTS;
        }
}
