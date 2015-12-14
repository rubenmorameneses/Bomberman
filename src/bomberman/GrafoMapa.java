//import java.lang.*;
//public class GrafoMapa{
//	public NodoMapa PrimerNodo;
//	public NodoMapa PrimerNodoSur;
//	public NodoMapa UltimoNodo;
//	public NodoMapa UltimoNodoSur;
//	String Nombre;
//	//Constructor: Construye una lista vacia con un nombre s
//	public GrafoMapa(String s){
//		Nombre=s;
//		PrimerNodo=UltimoNodo=null;
//		PrimerNodoSur=UltimoNodoSur;
//
//	}
//	//Constructor2
//	public GrafoMapa(){this("Mapa");}
//
//
//	//Metodos de Grafos
//	//VacioGrafo
//	public boolean VacioGrafo(){
//		return PrimerNodo==null;
//	}
//	//InsertaEste
//	public void InsertaEste(Object Elem){
//		if (VacioGrafo()){
//			PrimerNodo=UltimoNodo=new NodoMapa(Elem, null, UltimoNodoSur, null, null);
//		}
//		else{
//			UltimoNodo=UltimoNodo.Este= new NodoMapa(Elem, null, UltimoNodoSur, null, UltimoNodo);
//		}
//	}
//	//InsertaOeste
//	public void InsertaOeste(Object Elem){
//		if (VacioGrafo()){
//			PrimerNodo=UltimoNodo=new NodoMapa(Elem, null, PrimerNodoSur, PrimerNodo, null);
//		}
//		else{
//			PrimerNodo=PrimerNodo.Oeste= new NodoMapa(Elem, null, PrimerNodoSur, PrimerNodo, null);
//		}
//	}
//	//InsertaSur
//	public void InsertaSur(Object Elem){
//		if (VacioGrafo()){
//			PrimerNodoSur=UltimoNodoSur=new NodoMapa(Elem, PrimerNodo, null, UltimoNodoSur, null);
//		}
//		else{
//			PrimerNodoSur=PrimerNodoSur.Sur= new NodoMapa(Elem, PrimerNodoSur, null, UltimoNodoSur, null);
//		}
//	}
//
//
//	public static void main(String[]args){
//		GrafoMapa Mundo1=new GrafoMapa();
//		Mundo1.InsertaEste(1);
//		System.out.println(Mundo1.VacioGrafo());
//		System.out.println(Mundo1.PrimerNodo.Elem);
//		System.out.println(Mundo1.PrimerNodo.Sur);
//		Mundo1.InsertaEste(4);
//		System.out.println(Mundo1.UltimoNodo.Elem);
//		System.out.println(Mundo1.PrimerNodo.Este.Elem);
//		Mundo1.InsertaOeste(8);
//		System.out.println(Mundo1.PrimerNodo.Elem);
//		System.out.println(Mundo1.PrimerNodo.Este.Elem);
//		Mundo1.InsertaSur(16);
//		System.out.println(Mundo1.PrimerNodo.Este.Elem);
//
//	}
//
//}