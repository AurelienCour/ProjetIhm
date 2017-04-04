package edu.ihm.tortue;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Programe d'exemple pour la classe Tortue, 
 * avec un bouton permettant de la faire avancer
 * 
 * @author  Patrick Girard
 * @version f�vrier 2017
 */
public class TestCanvasTortue extends JFrame implements ActionListener 
{
    private TortueG myTurtle, myColorTurtle, myGraphicTurtle;
    private JButton bAvance, bTourne, bChangeTortue;
    
    public void actionPerformed (ActionEvent ae) {
        if (ae.getSource() == bAvance)
            myTurtle.avancer();
        else if (ae.getSource() == bTourne) 
            myTurtle.tourner();
        else { // bChangeTortue
            if (myTurtle == myGraphicTurtle) 
                myTurtle = myColorTurtle;
            else
                myTurtle = myGraphicTurtle;
            myTurtle.reset();
            }           
    }
    
    public TestCanvasTortue()
    {
        myGraphicTurtle = new TortueG();
        myColorTurtle = new TortueCouleur("RED");
        JPanel canv = Canvas.getCanvasPanel();
        this.add (canv, BorderLayout.CENTER);
        
        myTurtle = myGraphicTurtle; // Default
        bAvance = new JButton("Avance");
        bTourne = new JButton ("Tourne");
        bChangeTortue = new JButton("Change tortue");
        bAvance.addActionListener(this);
        bTourne.addActionListener(this);
        bChangeTortue.addActionListener(this);
        Container c = this.getContentPane();
        c.add (bAvance, BorderLayout.NORTH);
        c.add (bTourne, BorderLayout.WEST);
        c.add (bChangeTortue, BorderLayout.EAST);
        this.setVisible(true);
        this.pack();
    }
    
}
