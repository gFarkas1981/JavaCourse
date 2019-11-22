
package swingtrafficlight;

/**
 *
 * @author Gabor Farkas <info@gfarkas.com>
 */
public class TrafficLightModel {
    
    private boolean red1;
    private boolean yellow1;
    private boolean green1;
    private boolean red2;
    private boolean yellow2;
    private boolean green2;
    private boolean red3;
    private boolean yellow3;
    private boolean green3;
    private boolean red4;
    private boolean yellow4;
    private boolean green4;

    public TrafficLightModel() {
    }

    public TrafficLightModel(boolean red1, boolean yellow1, boolean green1, boolean red2, boolean yellow2, boolean green2, boolean red3, boolean yellow3, boolean green3, boolean red4, boolean yellow4, boolean green4) {
        this.red1 = red1;
        this.yellow1 = yellow1;
        this.green1 = green1;
        this.red2 = red2;
        this.yellow2 = yellow2;
        this.green2 = green2;
        this.red3 = red3;
        this.yellow3 = yellow3;
        this.green3 = green3;
        this.red4 = red4;
        this.yellow4 = yellow4;
        this.green4 = green4;
    }
    
    public void setTrafficLight1(boolean red1, boolean yellow1, boolean green1) {
        
        this.red1 = red1;
        this.yellow1 = yellow1;
        this.green1 = green1;
        
    }
    
    public void setTrafficLight2(boolean red2, boolean yellow2, boolean green2) {
        
        this.red2 = red2;
        this.yellow2 = yellow2;
        this.green2 = green2;
                
    }

    public void setTrafficLight3(boolean red3, boolean yellow3, boolean green3) {
        
        this.red3 = red3;
        this.yellow3 = yellow3;
        this.green3 = green3;
        
    }
    
    public void setTrafficLight4(boolean red4, boolean yellow4, boolean green4) {
      
        this.red4 = red4;
        this.yellow4 = yellow4;
        this.green4 = green4;
        
    }
          
    
    
    
    public void switchRed1() {
        
       red1 = !red1;
        
    }
    
    
    public void switchYellow1() {
        
       yellow1 = !yellow1;
        
    }
    
    
    public void switchGreen1() {
        
       green1 = !green1;
        
    }
    
    public void switchRed2() {
        
       red2 = !red2;
        
    }
    
    
    public void switchYellow2() {
        
       yellow2 = !yellow2;
        
    }
    
    
    public void switchGreen2() {
        
       green2 = !green2;
        
    }

    public void switchRed3() {
        
       red3 = !red3;
        
    }
    
    
    public void switchYellow3() {
        
       yellow3 = !yellow3;
        
    }
    
    
    public void switchGreen3() {
        
       green3 = !green3;
        
    }

    public void switchRed4() {
        
       red4 = !red4;
        
    }
    
    
    public void switchYellow4() {
        
       yellow4 = !yellow4;
        
    }
    
    
    public void switchGreen4() {
        
       green4 = !green4;
        
    }


    public boolean isGreen1() {
        return green1;
    }

    public void setGreen1(boolean green1) {
        this.green1 = green1;
    }

    public boolean isRed1() {
        return red1;
    }

    public void setRed1(boolean red1) {
        this.red1 = red1;
    }

    public boolean isYellow1() {
        return yellow1;
    }

    public void setYellow1(boolean yellow1) {
        this.yellow1 = yellow1;
    }
    
    public boolean isGreen2() {
        return green2;
    }

    public void setGreen2(boolean green2) {
        this.green2 = green2;
    }

    public boolean isRed2() {
        return red2;
    }

    public void setRed2(boolean red2) {
        this.red2 = red2;
    }

    public boolean isYellow2() {
        return yellow2;
    }

    public void setYellow2(boolean yellow2) {
        this.yellow2 = yellow2;
    }
    
    public boolean isGreen3() {
        return green3;
    }

    public void setGreen3(boolean green3) {
        this.green3 = green3;
    }

    public boolean isRed3() {
        return red3;
    }

    public void setRed3(boolean red3) {
        this.red3 = red3;
    }

    public boolean isYellow3() {
        return yellow3;
    }

    public void setYellow3(boolean yellow3) {
        this.yellow3 = yellow3;
    }
    
    public boolean isGreen4() {
        return green4;
    }

    public void setGreen4(boolean green4) {
        this.green4 = green4;
    }

    public boolean isRed4() {
        return red4;
    }

    public void setRed4(boolean red4) {
        this.red4 = red4;
    }

    public boolean isYellow4() {
        return yellow4;
    }

    public void setYellow4(boolean yellow4) {
        this.yellow4 = yellow4;
    }
    
    
}
