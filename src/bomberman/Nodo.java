package bomberman;

import java.util.ArrayList;

public class Nodo
{
    public ArrayList<Integer> elementos;
    public Nodo norte, sur, oeste, este;
    boolean check=false,peligro=false;
    //Lista elementos; 
    
    public Nodo(int tipo)
    {
        elementos=new ArrayList<Integer>();
        elementos.add(tipo);
    }
    
    public void insertar(int tipo)
    {
        elementos.add(tipo);
    }
    
    public boolean buscar(int tipo)
    {
        for (int i = 0; i < elementos.size(); i++) 
        {
            if (elementos.get(i)==tipo) 
            {
                return true;
            }
        }
        
        return false;
    }
    
    public int eliminar(int tipo)
    {
        for (int i = 0; i < elementos.size(); i++) 
        {
            if (String.valueOf(elementos.get(i)).equals(String.valueOf(tipo))) 
            {
                elementos.remove(i);
                return tipo;
            }
        }
        
        return 100;
    }
}