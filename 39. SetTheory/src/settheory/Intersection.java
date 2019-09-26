package settheory;

/**
 *
 * @author Gabor Farkas <info@gfarkas.com>
 */
public class Intersection {

    public void intersectionMethod(int[] array1, int[] array2) {

        //  The INTERSECTION of {1, 2, 3} and {2, 3, 4} is the set {2, 3}.
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
        
         System.out.println("Number of common elements: " + commonElements);
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
        
        System.out.print("Intersection:\t");
        
        for (int element : intersection) {
            
            System.out.print(element + " ");
            
        }
        
        System.out.println("");
        
    }

}
