/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generals;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;

/**
 *
 * @author Programador 1
 */
public class ProgressComponent implements Runnable {
    int maxValue;
    JProgressBar progress;
    static int numBar = 1;
    
    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;  
        progress.setMaximum(this.maxValue);
    }
    
    @Override
    public void run() {
 
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(ProgressComponent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
