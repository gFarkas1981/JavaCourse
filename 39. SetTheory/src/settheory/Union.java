package settheory;

/**
 *
 * @author Gabor Farkas <info@gfarkas.com>
 */
public class Union {

    public void unionMethod(int[] array1, int[] array2) {

        //  The UNION of {1, 2, 3} and {2, 3, 4} is the set {1, 2, 3, 4}.
        int[] allElements = new int[array1.length + array2.length];
        System.out.print("All elements:\t");

        // putting all elements of the two array to a new one (allElements)
        for (int i = 0; i < array1.length + array2.length; i++) {

            if (i < array1.length) {

                allElements[i] = array1[i];

            } else {

                allElements[i] = array2[i - array1.length];

            }

            System.out.print(allElements[i]+ " ");

        }

        // counting repetition in allElements
        int[] nrOfRepetition = new int[allElements.length];

        for (int i = 0; i < allElements.length - 1; i++) {
            
            // comparing actual elements to the following elements
            for (int j = i + 1; j < allElements.length; j++) {

                // if actual element equals to one of the following elements
                if (allElements[i] == allElements[j]) {

                    nrOfRepetition[i] += 1;
// but if we had one or more repetition before this element in allElements...
                    for (int k = 0; k < i; k++) {

                        if (allElements[k] == allElements[i]) {

                            nrOfRepetition[i] = 0;

                        }

                    }

                }

            }

        }
           
        // initializing the length of the union array
        int unionLength = allElements.length;

        System.out.println("");
        System.out.print("Repetations:\t");

        for (int i : nrOfRepetition) {
            
            unionLength -= nrOfRepetition[i];
            System.out.print(i + " ");
            
            
        }

        System.out.println("");

        System.out.println("Length of union[]: " + unionLength);
        // the union array's length will be:
        int[] union = new int[unionLength];

        boolean uniqueElement = true;
        int unionElementCounter = 0;

        // iterating through allElements again
        for (int i = 0; i < allElements.length - 1; i++) {

            // assuming that the element is unique
            uniqueElement = true;

            // comparing to the others
            for (int j = i + 1; j < allElements.length; j++) {

                // if there's a match
                if (allElements[i] == allElements[j]) {

                    // this element is not unique
                    uniqueElement = false;

                }

            }

            // this element is unique
            if (uniqueElement || nrOfRepetition[i] == 0) {

                // adding this element to the next position of the union
                union[unionElementCounter] = allElements[i];
                unionElementCounter++;
                //System.out.println(unionElementCounter);
            }

        }

        System.out.print("Union: ");

        for (int element : union) {

            System.out.print(element + " ");

        }
    }
}
