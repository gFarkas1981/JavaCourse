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
public class TrafficLightRunner1 implements Runnable {

    private TrafficLightModel model;
    private JPanel panel;

    public TrafficLightRunner1(TrafficLightModel model, JPanel panel) {
        this.model = model;
        this.panel = panel;
    }

    @Override
    public void run() {

        try {

            while (true) {

                model.setTrafficLight1(true, false, false);
                Thread.sleep(5000);
                panel.repaint();

                model.setTrafficLight1(true, true, false);
                Thread.sleep(1000);
                panel.repaint();

                model.setTrafficLight1(false, false, true);
                Thread.sleep(5000);
                panel.repaint();

                model.setTrafficLight1(false, true, false);
                Thread.sleep(1000);
                panel.repaint();

            }

        } catch (InterruptedException ex) {

        }

    }

}
