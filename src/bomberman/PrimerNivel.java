package bomberman;
import java.awt.event.*;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.ImageIcon;

public class PrimerNivel extends javax.swing.JFrame implements KeyListener
{
    JLabel [][] matrizLabels=new JLabel[13][13];
    JLabel fondo, BomberMan;
    matriz grafo;
    int posx=0, posy=0, retraso=2, contadorPasos=0;
    
    public PrimerNivel()
    {
        setLayout(null);
        grafo= new matriz();
        insertarNodos();
        grafo.ponerImagen(6, 4, 4);
        grafo.ponerImagen(4, 2, 4);
        grafo.ponerImagen(5, 0, 4);
        grafo.ponerImagen(3, 2, 4);
//        grafo.imprimir();
        BomberMan=new JLabel(new ImageIcon(getClass().getResource("/imagenes/frente.png")));
        this.add(BomberMan);
        BomberMan.setBounds(0, 0, 42, 52);
        matrizLabels=grafo.crearMatriz(matrizLabels);
        crearMatrizGrafica();          //pone los objetos que se modifican solo una vez en la pantalla
        crearMatrizGraficaFondo();   //crea los objetos estaticos que nunca cambian
        addKeyListener(this);
    }
    
    public void keyPressed(KeyEvent arg0) 
    {
            //si se mantiene presionada
            //System.out.println(arg0.getKeyChar());
        switch(arg0.getKeyChar())
        {
            case 'w':
            {
                if (posy!=0 && checkear(posx,posy,"arriba", retraso)) 
                {
                    posy=posy-retraso;
                    BomberMan.setBounds(posx, posy, 47, 48);
                    
                    if (contadorPasos%10==0 || contadorPasos%10==1 || contadorPasos%10==2 || contadorPasos%10==3 || contadorPasos%10==4)
                    {
                        BomberMan.setIcon(new ImageIcon(getClass().getResource("/imagenes/espalda.png")));
                        contadorPasos++;
                    }
                    else
                    {
                        BomberMan.setIcon(new ImageIcon(getClass().getResource("/imagenes/espalda2.png")));
                        contadorPasos++;
                    }
                }
                break;
            }
            case 's':
            {
                if (posx!=587 && checkear(posx,posy,"abajo", retraso)) 
                {
                    posy=posy+retraso;
                    BomberMan.setBounds(posx, posy, 47, 48);
                    
                    if (contadorPasos%10==0 || contadorPasos%10==1 || contadorPasos%10==2 || contadorPasos%10==3 || contadorPasos%10==4)
                    {
                        BomberMan.setIcon(new ImageIcon(getClass().getResource("/imagenes/frente.png")));
                        contadorPasos++;
                    }
                    else
                    {
                        BomberMan.setIcon(new ImageIcon(getClass().getResource("/imagenes/frente2.png")));
                        contadorPasos++;
                    }
                }
                break;
            }
            case 'a':
            {
                if (posx!=0 && checkear(posx,posy,"izquierda", retraso)) 
                {
                    posx=posx-retraso;
                    BomberMan.setBounds(posx, posy, 47, 48);
                    
                    if (contadorPasos%10==0 || contadorPasos%10==1 || contadorPasos%10==2 || contadorPasos%10==3 || contadorPasos%10==4)
                    {
                        BomberMan.setIcon(new ImageIcon(getClass().getResource("/imagenes/izq.png")));
                        contadorPasos++;
                    }
                    else
                    {
                        BomberMan.setIcon(new ImageIcon(getClass().getResource("/imagenes/izq2.png")));
                        contadorPasos++;
                    }
                }
                break;
            }
            case 'd':
            {
                if (posx!=570 && checkear(posx,posy,"derecha", retraso)) 
                {
                    posx=posx+retraso;
                    BomberMan.setBounds(posx, posy, 47, 48);
                    
                    if (contadorPasos%10==0 || contadorPasos%10==1 || contadorPasos%10==2 || contadorPasos%10==3 || contadorPasos%10==4)
                    {
                        BomberMan.setIcon(new ImageIcon(getClass().getResource("/imagenes/der.png")));
                        contadorPasos++;
                    }
                    else
                    {
                        BomberMan.setIcon(new ImageIcon(getClass().getResource("/imagenes/der2.png")));
                        contadorPasos++;
                    }
                }
                break;
            }
            case ' ':
            {
                grafo.imprimir();
                break;
            }
        }
        
    }

    public void keyReleased(KeyEvent arg0) 
    {
            //System.out.println("Y");
    }

    public void keyTyped(KeyEvent arg0) 
    {
            //si la apreta y suelta d un solo
//            arg0.getKeyCode();//devuelve la letra
//            System.out.println(arg0.getKeyChar());
    }

    
    public void crearMatrizGraficaFondo()
    {   
        fondo=new JLabel (new ImageIcon(getClass().getResource("/imagenes/fondo de pantalla.png"))); 
        this.add(fondo);
        fondo.setBounds(0, 0, 546, 676);                
    }
    
    public void crearMatrizGrafica()
    {        
        for(int i=0;i<13;i++)
        {
            for(int j=0;j<13;j++)
            {
                if(matrizLabels[i][j]!=null)
                {
                    this.add(matrizLabels[i][j]);
                    matrizLabels[i][j].setBounds(42*j, 52*i, 42, 52);                
                }
            }
        }
    }
    
    private void insertarNodos() 
    {        
        for (int i = 0; i < 13; i++) 
        {
            if(i%2==0)
            {
                for (int j = 0; j < 13; j++) 
                {
                    grafo.ponerImagen(i, j, 17);
                }
            }
            else
            {
                for (int j = 0; j < 13; j++) 
                {
                    if(i%2==0)
                        grafo.ponerImagen(i, j, 17);
                    else
                        grafo.ponerImagen(i, j, 2);               
                }
            }
        }
    }

    private boolean checkear(int posx, int posy, String direccion, int retraso) 
    {
        int x1,x2,y1,y2;
        Casilla aux;
        
        if(direccion.equals("arriba"))
        {
            y1=((posy-retraso)+10)/52;
            x1=(posx+10)/42;
            x2=(posx+31)/42;
            y2=(posy-retraso+41)/52;
            
            if (grafo.checkearParedes(x1, y1) || grafo.checkearParedes(x2, y2) || grafo.checkearParedes(x1, y2) || grafo.checkearParedes(x2, y1))
                return false;
            
            aux=grafo.obtenerNodo(posx/42, posy/52);
            
            if (!(aux.equals(grafo.obtenerNodo((x1+x2)/2, (y1+y2)/2)))) 
            {
                System.out.println("xxx");
                aux.eliminar(0);
            }
            
            grafo.ponerImagen((x1+x2)/2, (y1+y2)/2, 0);
        }
        else if(direccion.equals("abajo"))
        {
            y1=(posy+retraso+10)/52;
            x1=(posx+10)/42;
            x2=(posx+31)/42;
            y2=(posy+retraso+41)/52;
            
            if (grafo.checkearParedes(x1, y1) || grafo.checkearParedes(x2, y2) || grafo.checkearParedes(x1, y2) || grafo.checkearParedes(x2, y1))
            {
                return false;
            }
            
            aux=grafo.obtenerNodo(posx/42, posy/52);
            
            if (!(aux.equals(grafo.obtenerNodo((x1+x2)/2, (y1+y2)/2)))) 
            {
                aux.eliminar(0);
            }
            
            grafo.ponerImagen((x1+x2)/2, (y1+y2)/2, 0);            
        }
        else if(direccion.equals("derecha"))
        {
            y1=(posy+10)/52;
            x1=(posx+retraso+10)/42;
            x2=(posx+31+retraso)/42;
            y2=(posy+41)/52;
            
            if (grafo.checkearParedes(x1, y1) || grafo.checkearParedes(x2, y2) || grafo.checkearParedes(x1, y2) || grafo.checkearParedes(x2, y1))
            {
                return false;
            }
            
            aux=grafo.obtenerNodo(posx/42, posy/52);
            
            if (!(aux.equals(grafo.obtenerNodo((x1+x2)/2, (y1+y2)/2)))) 
            {
                aux.eliminar(0);
            }
            
            grafo.ponerImagen((x1+x2)/2, (y1+y2)/2, 0);            
        }
        else if(direccion.equals("izquierda"))
        {
            y1=(posy+10)/52;
            x1=(posx-retraso+10)/42;
            x2=(posx+31-retraso)/42;
            y2=(posy+41)/52;
            
            if (grafo.checkearParedes(x1, y1) || grafo.checkearParedes(x2, y2) || grafo.checkearParedes(x1, y2) || grafo.checkearParedes(x2, y1))
            {
                return false;
            }
            
            aux=grafo.obtenerNodo(posx/42, posy/52);
            
            if (!(aux.equals(grafo.obtenerNodo((x1+x2)/2, (y1+y2)/2)))) 
            {
                aux.eliminar(0);
            }
            
            grafo.ponerImagen((x1+x2)/2, (y1+y2)/2, 0);            
        }
        
        return true;
    }
}
