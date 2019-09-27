package settheory;

/**
 *
 * @author Gabor Farkas <info@gfarkas.com>
 */
public class Union {
    
    //  The UNION of {1, 2, 3} and {2, 3, 4} is the set {1, 2, 3, 4}.

    public static int[] sumArrays(int[] array1, int[] array2) {
        
        int[] outputArray = new int[array1.length + array2.length];
        
        for (int i = 0; i < array1.length + array2.length; i++) {

            if (i < array1.length) {

                outputArray[i] = array1[i];

            } else {

                outputArray[i] = array2[i - array1.length];

            }

        }

        return outputArray;

    }
    
    public static int[] countRepetitionsInArray(int[] inputArray) {
        
        int[] nrOfRepetition = new int[inputArray.length];

        for (int i = 0; i < inputArray.length - 1; i++) {

            // comparing actual elements to the following elements
            for (int j = i + 1; j < inputArray.length; j++) {

                // if actual element equals to one of the following elements
                if (inputArray[i] == inputArray[j]) {

                    nrOfRepetition[i] += 1;
// but if we had one or more repetition before this element in allElements...
                    for (int k = 0; k < i; k++) {

                        if (inputArray[k] == inputArray[i]) {

                            nrOfRepetition[i] = 0;

                        }

                    }

                }

            }

        }        
        
        return nrOfRepetition;
        
    }
    
    public static int[] createUnionArray(int[] sumOfTwoArrays, int[] nrOfRepetitions) {
        
        // initializing the length of the union array
        int unionLength = sumOfTwoArrays.length;

        // the union array's length will be:
        for (int i : nrOfRepetitions) {

            unionLength -= nrOfRepetitions[i];
            
        }

        int[] union = new int[unionLength];
        int unionArrayElementCounter = 0;
        
        // iterating through the sum of the two arrays
        for (int i = 0; i < sumOfTwoArrays.length - 1; i++) {
            
            // assuming that the element is unique
            boolean uniqueElement = true;

            // comparing to the others
            for (int j = i + 1; j < sumOfTwoArrays.length; j++) {

                // if there's a match
                if (sumOfTwoArrays[i] == sumOfTwoArrays[j]) {

                    // this element is not unique
                    uniqueElement = false;

                }

            }
            
            // this element is unique
            if (uniqueElement || nrOfRepetitions[i] == 0) {

                // adding this element to the next position of the union
                union[unionArrayElementCounter] = sumOfTwoArrays[i];
                unionArrayElementCounter++;
                //System.out.println(unionElementCounter);
            }

        }
        
        return union;
        
    }

    public void unionMethod(int[] array1, int[] array2) {

        System.out.print("All elements:\t");

        // putting all elements of the two array to a new one (allElements)
        int[] allElements = sumArrays(array1, array2);
        
        for (int element : allElements) {
            
            System.out.print(element + " ");
            
        }
        
        System.out.println("");
        
        // counting repetition in allElements
        int[] nrOfRepetitions = countRepetitionsInArray(allElements);

        System.out.print("Repetitions:\t");
        
        for (int element : nrOfRepetitions) {
            
            System.out.print(element + " ");
            
        }
        
        System.out.println("");

        int[] union = createUnionArray(allElements, nrOfRepetitions);
        
        System.out.println("Length of union[]: " + union.length);

        boolean uniqueElement = true;
        int unionElementCounter = 0;

        // Creating union set from the sum of the two arrays and 
        // the array of the number of repetitions

        System.out.print("Union: ");

        for (int element : union) {

            System.out.print(element + " ");

        }
    }
}
