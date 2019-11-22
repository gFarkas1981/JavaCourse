/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingworker;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingWorker;

/**
 *
 * @author Gabor Farkas <info@gfarkas.com>
 */
public class MyWorker extends SwingWorker<String, String> {
    
    @Override
    protected String doInBackground() throws Exception {
        
        for (int i = 0; i <= 100; i++) {

                    try {
                        
                        setProgress(i);
                        publish(i + "%");
                        Thread.sleep(50);
                    
                    } catch (InterruptedException ex) {
                        Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
                
                return "Background process has finished";
        
    }
    
}
