package bomberman;

public class ListaEnlazada 
{
    NodoEnlazado pn, un;

    public ListaEnlazada() 
    {
        pn=un=null;
    }
    
    public void agregar(int dato)
    {
        NodoEnlazado aux;
        
        if (pn==null)
        {
            pn=un=new NodoEnlazado(dato);
        }
        else if(pn==un)
        {
            pn.siguiente=new NodoEnlazado(dato);
            un=pn.siguiente;
            un.anterior=pn;
        }
        else
        {
            aux=new NodoEnlazado(dato);
            un.siguiente=aux;
            aux.anterior=un;
            un=aux;
        }
    }
    
    public void eliminar(int dato)
    {
        NodoEnlazado aux2;
        
        if (pn!=null)
        {
            aux2=pn;
            
            while(aux2!=null)
            {
                if(pn==un && pn.dato==dato)
                {
                    pn=un=null;
                    return;
                }
                else if(pn.dato== dato)
                {
                    pn=pn.siguiente;
                    pn.anterior=null;
                    return;
                }
                else if (un.dato==dato)
                {
                    un=un.anterior;
                    un.siguiente=null;
                    return;
                }
                else if (aux2.dato==dato)
                {
                    aux2.anterior.siguiente=aux2.siguiente;
                    aux2.siguiente.anterior=aux2.anterior;
                    return;
                }
                
                aux2=aux2.siguiente;
            }
        }        
    }
    
    public int mayor()
    {
        NodoEnlazado aux;
        int mayor;
        
        if (pn==null)
        {
            return 0;
        }
        else if(pn==un)
        {
            return pn.dato;
        }
        else
        {
            aux=pn.siguiente;
            mayor=pn.dato;
            
            while(aux!=null)
            {
                if (mayor<aux.dato)
                {
                    mayor=aux.dato;
                    aux=aux.siguiente;
                }
                else
                {
                    aux=aux.siguiente;
                }
            }
            
            return mayor;
        }
    }
    
    public void imprimir()
    {
        NodoEnlazado aux;
        
        if (pn==null)
        {
            System.out.println("--- vacia");
        }
        else if(pn==un)
        {
            System.out.println(pn.dato);
        }
        else
        {
            aux=pn;
            
            while(aux!=null)
            {
                System.out.println(aux.dato+(aux!=un?"-":""));
                aux=aux.siguiente;
            }            
        }
    }
}