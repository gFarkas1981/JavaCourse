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
public class TrafficLightRunner3 implements Runnable {

    public static boolean isStopped3 = false;
    private TrafficLightModel model;
    private JPanel panel;

    public TrafficLightRunner3(TrafficLightModel model, JPanel panel) {
        this.model = model;
        this.panel = panel;
    }

    @Override
    public void run() {

        int i = 0;

        try {

            while (true) {

                i = 0;

                model.setTrafficLight3(true, false, false);
                Thread.sleep(5000);

                while (isStopped3) {

                    Thread.sleep(1000);
                    i++;
                    System.out.println("TrafficLights3 has been stopped for " + i + " seconds.");

                }


                panel.repaint();

                i = 0;

                model.setTrafficLight3(true, true, false);
                Thread.sleep(1000);

                while (isStopped3) {

                    Thread.sleep(1000);
                    i++;
                    System.out.println("TrafficLights3 has been stopped for " + i + " seconds.");

                }

                panel.repaint();

                i = 0;

                model.setTrafficLight3(false, false, true);
                Thread.sleep(5000);

                while (isStopped3) {

                    Thread.sleep(1000);
                    i++;
                    System.out.println("TrafficLights3 has been stopped for " + i + " seconds.");

                }

                panel.repaint();

                i = 0;

                model.setTrafficLight3(false, true, false);
                Thread.sleep(1000);

                while (isStopped3) {

                    Thread.sleep(1000);
                    i++;
                    System.out.println("TrafficLights3 has been stopped for " + i + " seconds.");

                }

                panel.repaint();

            }

        } catch (InterruptedException ex) {

        }

    }

}
