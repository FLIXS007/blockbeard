/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BlockbeardVue;

import blockbeard.mouvementPersonnage.controleurPersonnage;
import java.awt.HeadlessException;
import javax.swing.JFrame;

/**
 *
 * @author yanis
 */
public class FenetrePartie extends JFrame{
    private controleurPersonnage c;

    public FenetrePartie(controleurPersonnage c, String title) throws HeadlessException {
        super(title);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
        this.c = c;
        
        this.initComposants();
    }
    
    private void initComposants(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
        this.addKeyListener(c);
        
    }
    
    
}
