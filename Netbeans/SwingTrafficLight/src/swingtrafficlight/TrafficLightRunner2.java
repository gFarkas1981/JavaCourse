/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingtrafficlight;

import javax.swing.JPanel;

/**
 *
 * @author Gabor Farkas <info@gfarkas.com>
 */
public class TrafficLightRunner2 implements Runnable {

    private TrafficLightModel model;
    private JPanel panel;

    public TrafficLightRunner2(TrafficLightModel model, JPanel panel) {
        this.model = model;
        this.panel = panel;
    }

    @Override
    public void run() {

        try {

            while (true) {

                model.setTrafficLight2(true, false, false);
                Thread.sleep(5000);
                panel.repaint();

                model.setTrafficLight2(true, true, false);
                Thread.sleep(1000);
                panel.repaint();

                model.setTrafficLight2(false, false, true);
                Thread.sleep(5000);
                panel.repaint();

                model.setTrafficLight2(false, true, false);
                Thread.sleep(1000);
                panel.repaint();

            }

        } catch (InterruptedException ex) {

        }

    }

}
