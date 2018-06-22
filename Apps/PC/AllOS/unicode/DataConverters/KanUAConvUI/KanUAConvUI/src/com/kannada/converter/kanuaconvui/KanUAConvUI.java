/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kannada.converter.kanuaconvui;

import javax.swing.LookAndFeel;
import javax.swing.UIManager;
/**
 *
 * @author Administrator
 */
public class KanUAConvUI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try { 
            //LookAndFeel lookAndFeel = new UIManager().getSystemLookAndFeelClassName();
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()) ;
        } catch (Exception ex) { 
            ex.printStackTrace(); 
        }
                java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KanUAConvForm().setVisible(true);
            }
        });
    }
}
