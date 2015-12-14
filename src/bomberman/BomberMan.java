package bomberman;
import javax.swing.JFrame;

public class BomberMan 
{
    public static void main(String[] args) 
    {
        PrimerNivel pn = new PrimerNivel();
        pn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pn.setSize(800,600);
        pn.setVisible(true);
    }
}