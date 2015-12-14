package bomberman;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Lista 
{
    public Nodo nn, ns,ne,no;

    public Lista() 
    {
        nn=ns=ne=no=null;
    }
    
    public void agregarSur(int dato)
    {
        Nodo aux;
        
        if (nn==null)
        {
            nn=ns=no=ne=new Nodo(dato);
        }
        else if(nn==ns)
        {
            ns.sur=new Nodo(dato);
            ns=ns.sur;
            ns.norte=nn;
            ne=no=ns;
        }
        else
        {
            aux=new Nodo(dato);
            ns.sur=aux;
            aux.norte=ns;
            ns=aux;
            ne=no=ns;
        }
    }
    
    public void agregarEste(int dato)
    {
        Nodo aux;
        
        if (nn==null)
        {
            nn=ne=ns=no=new Nodo(dato);
        }
        else if(ne==no)
        {
            no.este=new Nodo(dato);
            no=no.este;
            no.oeste=ne;
        }
        else
        {
            aux=new Nodo(dato);
            no.este=aux;
            aux.oeste=no;
            no=aux;
        }
    }
    
    public void ponerImagen(int X,int Y, int dato)
    {
        Nodo aux=nn;
        
        for(int i=0;i<Y;i++)
        {
            aux=aux.sur;            
        }
        
        for (int i = 0; i < X; i++) 
        {
            aux=aux.este;
        }
        
        aux.insertar(dato);
    }
    
    public boolean checkearParedes(int X,int Y)
    {
        Nodo aux=nn;
        
        for(int i=0;i<Y;i++)
        {
            aux=aux.sur;            
        }
        
        for (int i = 0; i < X; i++) 
        {
            aux=aux.este;
        }
        
        if(aux.buscar(2) || aux.buscar(4))        
            return true;        
        else
            return false;
    }
    
    public Nodo obtenerNodo(int X,int Y)
    {
        Nodo aux=nn;
        
        for(int i=0;i<Y;i++)
        {
            aux=aux.sur;            
        }
        
        for (int i = 0; i < X; i++) 
        {
            aux=aux.este;
        }
        
        return nn;
    }
    
    public void eliminarElementoEnNodo(int X,int Y, int elemento)
    {
        Nodo aux=nn;
        
        for(int i=0;i<Y;i++)
        {
            aux=aux.sur;            
        }
        
        for (int i = 0; i < X; i++) 
        {
            aux=aux.este;
        }
        
        aux.eliminar(0);
    }
    
    public void arreglar()
    {
        Nodo aux=nn, aux2=nn.sur;
        
        for(int i=1;i<13;i++)
        {
            for(int j=1;j<13;j++)
            {
                aux=aux.este;
                aux2=aux2.este;
                aux.sur=aux2;
                aux2.norte=aux;
            }
            
            for (int j = 1; j < 13; j++) 
            {
                aux=aux.oeste;
                aux2=aux2.oeste;
            }
            
            aux2=aux2.sur;
            aux=aux.sur;
        }
    }
    
    public void imprimir()
    {
        System.out.println();
        
        Nodo aux=nn;
        
        for(int i=0;i<13;i++)
        {
            for(int j=0;j<13;j++)
            {
                if(j!=12)
                {
                    if (aux.buscar(0)) 
                    {
                        System.out.print(aux.elementos.get(1) +" ");
                        aux=aux.este;
                    }
                    else
                    {
                        System.out.print(aux.elementos.get(0) +" ");
                        aux=aux.este;
                    }
                }
                else
                {
                    System.out.print(aux.elementos.get(0)+" ");
                }
            }
            
            for (int j = 1; j < 13; j++) 
            {
                aux=aux.oeste;
            }
            
            aux=aux.sur;
            System.out.println("");
        }
    }
    
    public JLabel[][] crearMatriz(JLabel [][] matrizLabels)
    {
        Nodo aux=nn;
        
        for(int i=0;i<13;i++)
        {
            for(int j=0;j<13;j++)
            {
                if(j!=12)
                {
                    if (aux.buscar(0))
                    {
                        matrizLabels[i][j] = new JLabel (new ImageIcon(getClass().getResource("/imagenes/muñeco.png")));         // new ImageIcon(getClass().getResource("/Imagenes/"+imagenes[i][j]))
                    }
                    else if (aux.buscar(4))
                    {
                        matrizLabels[i][j] = new JLabel (new ImageIcon(getClass().getResource("/imagenes/ladrillo.png")));         // new ImageIcon(getClass().getResource("/Imagenes/"+imagenes[i][j]))
                    }
                    else
                    {
                        matrizLabels[i][j] = null;
                    }

                    aux=aux.este;
                }
                else
                {
                    if (aux.buscar(0))
                    {
                        matrizLabels[i][j] = new JLabel (new ImageIcon(getClass().getResource("/imagenes/muñeco.png")));         // new ImageIcon(getClass().getResource("/Imagenes/"+imagenes[i][j]))
                    }
                    else if (aux.buscar(4))
                    {
                        matrizLabels[i][j] = new JLabel (new ImageIcon(getClass().getResource("/imagenes/ladrillo.png")));         // new ImageIcon(getClass().getResource("/Imagenes/"+imagenes[i][j]))
                    }
                    else
                    {
                        matrizLabels[i][j] = null;
                    }
                }
            }
            
            for (int j = 1; j < 13; j++) 
            {
                aux=aux.oeste;
            }
            
            aux=aux.sur;
        }
        
        return matrizLabels;
    }
}