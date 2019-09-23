package changingVariables;

public class ChangingVariables {

    
    public static void main(String[] args) {
        
        int a = 3;
        int b = 7;
        
        b += a;
        a = b - a;
        b -= a;
        
        System.out.println("a=" + a);
        System.out.println("b=" + b);
        
    }
    
}
