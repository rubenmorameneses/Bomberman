package bomberman;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class matriz 
{
    Casilla [][] tablero;

    public matriz() 
    {
        tablero= new Casilla[13][13];
        
        for (int i = 0; i < 10; i++) 
        {
            for (int j = 0; j < 10; j++) 
            {
                tablero[i][j]=new Casilla(17);
            }
        }
    }    
    
    public void ponerImagen(int X,int Y, int dato)
    {
        System.out.println(X+" "+Y);
        tablero[X][Y].insertar(dato);
    }
    
    public boolean checkearParedes(int X,int Y)
    {        
        if(tablero[X][Y].buscar(2) || tablero[X][Y].buscar(4))        
            return true; 
        
        return false;
    }
    
    public Casilla obtenerNodo(int X,int Y)
    {
        return tablero[X][Y];
    }
    
    public void eliminarBombermanEnNodo(int X,int Y, int elemento)
    {
        tablero[X][Y].eliminar(0);
    }
    
    public void imprimir()
    {
        System.out.println();
        
        for(int i=0;i<13;i++)
        {
            for(int j=0;j<13;j++)
            {
                if (tablero[i][j].buscar(0)) 
                {
                    System.out.print("0 ");
                }
                else
                {
                    System.out.print(tablero[i][j].elementos.get(0) +" ");
                }               
            }
            
            System.out.println();
        }
    }

    public JLabel[][] crearMatriz(JLabel [][] matrizLabels)
    {
        for(int i=0;i<13;i++)
        {
            for(int j=0;j<13;j++)
            {
                if (tablero[i][j].buscar(0))
                {
                    matrizLabels[i][j] = new JLabel (new ImageIcon(getClass().getResource("/imagenes/muñeco.png")));         // new ImageIcon(getClass().getResource("/Imagenes/"+imagenes[i][j]))
                }
                else if (tablero[i][j].buscar(4))
                {
                    matrizLabels[i][j] = new JLabel (new ImageIcon(getClass().getResource("/imagenes/ladrillo.png")));         // new ImageIcon(getClass().getResource("/Imagenes/"+imagenes[i][j]))
                }
                else
                {
                    matrizLabels[i][j] = null;
                }
            }
        }
        
        return matrizLabels;
    }
}