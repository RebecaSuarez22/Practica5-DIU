package practica5_diu;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Lienzo extends JPanel{
    private BufferedImage imagen, res, logo;
    public int posicion = 2;
    public int altura, ancho;
    
    
    public Lienzo(){
        try {
            imagen = ImageIO.read(new URL("https://www.purina-latam.com/sites/g/files/auxxlc391/files/styles/social_share_large/public/purina-reconocer-a-un-perro-feliz.jpg?itok=8xw_Cyof"));
            this.setPreferredSize(new Dimension(imagen.getWidth(),imagen.getHeight()));
            ancho = imagen.getWidth();
            altura = imagen.getHeight();
            logo = ImageIO.read(new URL("https://hotelcaninofelinorioseco.es/wp-content/uploads/2019/06/zona-perro.png"));
            res = Utils.clonarImagen(imagen);
        }catch(MalformedURLException ex){
            Logger.getLogger(Lienzo.class.getName()).log(Level.SEVERE, null, ex);
        }catch(IOException ex){
            Logger.getLogger(Lienzo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void setColores(boolean c_red, boolean c_green, boolean c_blue){
        Graphics g=getGraphics();
        res = Utils.seleccionarComponentes(imagen, c_red, c_green, c_blue);
        paintComponent(g);
    }
    
         
    public void setPosicion(int posicion){
        Graphics g=getGraphics();
        this.posicion = posicion;
        paintComponent(g);
    }
        
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(res, 0, 0, ancho, altura,  null);  
       
        
        
        switch(posicion){
            case 0:
                g.drawImage(logo, 0, 0, 50, 50 ,null);
                break;
                
            case 1:
                g.drawImage(logo, 0, altura - 50, 50, 50 ,null);
                break;
                
            case 2:
                g.drawImage(logo, ancho - 50, 0, 50, 50 ,null);
                break;
            
            case 3:
                g.drawImage(logo, ancho - 50, altura - 50, 50, 50 ,null);
                break;
                
                
        } 
        
            
        
    }
}