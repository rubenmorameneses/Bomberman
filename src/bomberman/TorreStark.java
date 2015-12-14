package bomberman;
import java.awt.event.*;
import java.awt.Component;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.ImageIcon;

public class TorreStark extends javax.swing.JFrame implements KeyListener
{
    Casilla [][] matriz;
    JLabel [][] matrizLabels=new JLabel[13][13];
    JLabel fondo, BomberMan;
    Lista grafo;
    
    public TorreStark()
    {
        initComponents();
        grafo= new Lista();
        insertarNodos();
        grafo.arreglar();
        grafo.ponerImagen(3, 0, 4);
        grafo.ponerImagen(4, 2, 4);
        grafo.ponerImagen(5, 0, 4);
        grafo.ponerImagen(3, 2, 4);
        grafo.imprimir();
        matrizLabels=grafo.crearMatriz(matrizLabels);
        crearMatrizGrafica();          //pone los objetos que se modifican solo una vez en la pantalla
        crearMatrizGraficaFondo();   //crea los objetos estaticos que nunca cambian
        addKeyListener(this);
    }
    
//    import java.awt.event.*;

//public class LectorTeclado implements KeyListener {
//
//public LectorTeclado (Personaje personaje){
//		
//	}
    public void keyPressed(KeyEvent arg0) 
    {
            //si se mantiene presionada
        System.out.println(arg0.getKeyChar());
    }

    public void keyReleased(KeyEvent arg0) 
    {
            System.out.println("Y");
    }

    public void keyTyped(KeyEvent arg0) 
    {
            //si la apreta y suelta d un solo
            arg0.getKeyCode();//devuelve la letra
            System.out.println("x");
    }

    
    public void crearMatrizGraficaFondo()
    {   
        fondo=new JLabel (new ImageIcon(getClass().getResource("/imagenes/fondo de pantalla.png"))); 
        this.add(fondo);
        fondo.setBounds(0, 0, 520, 520);                
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
                    matrizLabels[i][j].setBounds(40*j, 40*i, 40, 40);                
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 0, 0);

        jButton1.setText("A");
        getContentPane().add(jButton1);
        jButton1.setBounds(620, 110, 39, 23);

        jButton2.setText("<");
        getContentPane().add(jButton2);
        jButton2.setBounds(580, 130, 40, 23);

        jButton3.setText(">");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(660, 130, 41, 23);

        jButton4.setText("V");
        getContentPane().add(jButton4);
        jButton4.setBounds(620, 150, 39, 23);

        jButton5.setText("Especial del caballo");
        getContentPane().add(jButton5);
        jButton5.setBounds(580, 230, 140, 23);

        jButton6.setText("Poner Bomba");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(580, 210, 140, 23);

        jButton7.setText("jButton7");
        getContentPane().add(jButton7);
        jButton7.setBounds(340, 170, 73, 23);

        jButton8.setText("jButton8");
        getContentPane().add(jButton8);
        jButton8.setBounds(380, 160, 73, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jButton3ActionPerformed

private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jButton6ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    private void insertarNodos() 
    {        
        for (int j = 0; j < 13; j++) 
        {
            for (int i = 0; i < 13; i++) 
            {
                grafo.agregarEste(17);
            }

            grafo.agregarSur(17);
            
            for (int i = 1; i < 14; i++) 
            {
                if(i%2==0)
                    grafo.agregarEste(17);
                else
                    grafo.agregarEste(2);                
            }
            
            grafo.agregarSur(17);
        }
        
        for (int i = 0; i < 13; i++) 
        {
            grafo.agregarEste(0);
        }
    }
}