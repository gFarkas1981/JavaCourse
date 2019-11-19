/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingtrafficlights;

import javax.swing.*;

/**
 *
 * @author Gabor Farkas <info@gfarkas.com>
 */
public class TrafficLightRunner4 implements Runnable {

    public static boolean isStopped4 = false;
    private TrafficLightModel model;
    private JPanel panel;

    public TrafficLightRunner4(TrafficLightModel model, JPanel panel) {
        this.model = model;
        this.panel = panel;
    }

    @Override
    public void run() {

        int i = 0;

        try {

            while (true) {

                i = 0;

                model.setTrafficLight4(true, false, false);
                Thread.sleep(5000);

                while (isStopped4) {

                    Thread.sleep(1000);
                    i++;
                    System.out.println("TrafficLights4 has been stopped for " + i + " seconds.");

                }


                panel.repaint();

                i = 0;

                model.setTrafficLight4(true, true, false);
                Thread.sleep(1000);

                while (isStopped4) {

                    Thread.sleep(1000);
                    i++;
                    System.out.println("TrafficLights4 has been stopped for " + i + " seconds.");

                }

                panel.repaint();

                i = 0;

                model.setTrafficLight4(false, false, true);
                Thread.sleep(5000);

                while (isStopped4) {

                    Thread.sleep(1000);
                    i++;
                    System.out.println("TrafficLights4 has been stopped for " + i + " seconds.");

                }

                panel.repaint();

                i = 0;

                model.setTrafficLight4(false, true, false);
                Thread.sleep(1000);

                while (isStopped4) {

                    Thread.sleep(1000);
                    i++;
                    System.out.println("TrafficLights4 has been stopped for " + i + " seconds.");

                }

                panel.repaint();

            }

        } catch (InterruptedException ex) {

        }

    }

}
