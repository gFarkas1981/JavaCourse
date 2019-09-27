package settheory;

/**
 *
 * @author Gabor Farkas <info@gfarkas.com>
 */
public class Intersection {
    
    public static int commonElementsOfTwoArrays(int[] array1, int[] array2) {
        
        int commonElements = 0;
        
        // counting common elements
        for (int array1Element = 0; array1Element < array1.length; array1Element++) {

            for (int array2Element = 0; array2Element < array2.length; array2Element++) {

                if (array1[array1Element] == array2[array2Element]) {

                    boolean checkedAlready = false;

                    for (int i = 0; i < array1Element; i++) {

                        if (array1[i] == array1[array1Element]) {

                            checkedAlready = true;

                        }

                    }
                    
                    for (int i = 0; i < array2Element; i++) {

                        if (array2[i] == array2[array2Element]) {

                            checkedAlready = true;

                        }

                    }

                    if (!checkedAlready) {

                        commonElements++;
                            
                    }

                }

            }

        }
        
        return commonElements;
        
    }
    
    public static boolean arrayContains(int[] array, int number) {
        
        for (int element : array) {
            
            if (element == number) {
                
                return true;
                
            }
            
        }
        
        return false;
        
    }
    
    public static int[] createIntersectionOfTwoArrays(int[] array1, int[] array2, int commonElements) {
        
        int[] intersection = new int[commonElements];
        int intersectionIndex = 0;
        
        //fillin up 
        for (int array1Element = 0; array1Element < array1.length; array1Element++) {

            for (int array2Element = 0; array2Element < array2.length; array2Element++) {

                if (array1[array1Element] == array2[array2Element]) {

                    boolean checkedAlready = false;

                    for (int i = 0; i < array1Element; i++) {

                        if (array1[i] == array1[array1Element]) {

                            checkedAlready = true;

                        }

                    }
                    
                    for (int i = 0; i < array2Element; i++) {

                        if (array2[i] == array2[array2Element]) {

                            checkedAlready = true;

                        }

                    }

                    if (!checkedAlready) {

                        intersection[intersectionIndex] =array1[array1Element];
                        intersectionIndex++;
                            
                    }

                }

            }

        }
        
        return intersection;
        
    }

    public void intersectionMethod(int[] array1, int[] array2) {

        
        int commonElements = commonElementsOfTwoArrays(array1, array2);
        
        System.out.println("Number of common elements: " + commonElements);
                
        System.out.print("Intersection:\t");
        
        int[] intersection = createIntersectionOfTwoArrays(array1, array2, commonElements);
        
        for (int element : intersection) {
            
            System.out.print(element + " ");
            
        }
        
        System.out.println("");
        
    }

}
