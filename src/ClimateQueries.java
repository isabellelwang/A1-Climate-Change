import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays; 

//import javax.xml.transform.Source;

public class ClimateQueries {

    // Below are stubs for each of the methods for the
    // climate analysis. You should include both ranged
    // and unranged methods for each, but only the unranged
    // are listed below

    /**
     * sets true or false into an array if each element in the arr equals the target value, val
     * @param arr array with elements being compared to
     * @param val float val target number being compared to
     * @return boolean array of true and false of whether val equals to arr elements
     */
    public static boolean[] isEqualTo(float[] arr, float val) {
        boolean[] indicator = new boolean[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val) {
                indicator[i] = true;
            }
        }
        return indicator;
    }

    /**
     * Negates the boolean and stores it into a boolean array
     * @param arr array with boolean values being negated
     * @return a boolean array of negated values of arr
     */
    public static boolean[] logicalNot(boolean[] arr) {
        boolean[] indicator = new boolean[arr.length];

        for (int i = 0; i < arr.length; i++) {
            indicator[i] = !arr[i];
        }
        return indicator;
    }

    /**
     * performs And operator with two boolean arrays and stores the and value into a new boolean array
     * @param arr1 boolean array of true or false
     * @param arr2 another boolean array of true or false
     * @return boolean array of And values of arr1 and arr2 or throws runtime if length of arr1 and arr2 are unequal.
     */
    public static boolean[] logicalAnd(boolean[] arr1, boolean[] arr2) {
        // add your code here
        // replace code below with your own return statement
        if (arr1.length != arr2.length) {
            throw new RuntimeException("Lengths do not equal each other.");
        }
        boolean[] indicator = new boolean[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] && arr2[i]) {
                indicator[i] = true;
            } else {
                indicator[i] = false;
            }
        }
        return indicator;
    }

    /**
     * compares whether element in float arr is greater than val
     * @param arr array of float elements
     * @param val float val being compared to
     * @return boolean of true or false whether each values in array are greater than val
     */
    public static boolean[] isGreaterThan(float[] arr, float val) {
        // add your code here
        // replace code below with your own return statement
        boolean[] indicator = new boolean[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= val) {
                indicator[i] = true;
            } else {
                indicator[i] = false;
            }
        }
        return indicator;
    }

    /**
     * For a list of String of dates, compares whether date elements are in between date1 and date2 and stores in a new boolean array
     * @param arr array of String dates 
     * @param date1 String earliest date
     * @param date2 String latest date being compared to
     * @return boolean array of elements that are in between date1 and date2
     */
    public static boolean[] datesBetween(String[] arr, String date1, String date2) {
        // add your code here
        // replace code below with your own return statement
        boolean[] indicator = new boolean[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (Integer.parseInt(arr[i]) > Integer.parseInt(date1)
                    && Integer.parseInt(arr[i]) < Integer.parseInt(date2)) {
                indicator[i] = true;
            } else {
                indicator[i] = false;
            }
        }
        return indicator;
    }

    /**
     * if the indicator is true, adds arr element into a sum from the range lo and hi
     * @param arr arr of float values
     * @param indicator arr of boolean values that correspond to arr
     * @param lo int lo lowest index of the number the array including
     * @param hi int hi highest index the array reaches
     * @return the float mean of the array from index lo to index hi
     */
    public static float mean(float[] arr, boolean[] indicator, int lo, int hi) {
        // add your code here
        // replace code below with your own return statement
        float count = 0.0f;
        float sum = 0.0f;
        for (int i = lo; i < hi; i++) {
            if (indicator[i]) {
                sum += arr[i];
                count++;
            }
        }
        return sum / count;
    }

    /**
     * Overloaded method from above that sets 0 to lo and arr.length to hi
     * @param arr array of float numbers
     * @param indicator boolean indicator of true and false that corresponds to the arr
     * @return the float mean from index 0 to index arr.length
     */
    public static float mean(float[] arr, boolean[] indicator) {
        return mean(arr, indicator, 0, arr.length);
    }

    /**
     * counts the number of true values in boolean arr
     * @param arr bool arr containing true and false
     * @return int number of trues in boolean arr
     */
    public static int count(boolean[] arr) {
        // add your code here
        // replace code below with your own return statement
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]) {
                count++;
            }

        }
        return count;
    }

    /**
     * Finds the first index that has value true
     * @param arr boolean array of true and false
     * @return int index of first appearance of true in boolean arr, otherwise prints -1
     */
    public static int findFirst(boolean[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]) {
                return i;
            }
        }
        return -1;
    }

    /**
     * stores the index in boolean arr that are ture
     * @param arr boolean arr of true and false
     * @return int array of indexes of value true
     */
    public static int[] find(boolean[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]) {
                count++;
            }
        }
        int[] indices = new int[count];
        int indicesCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]) {
                indices[indicesCount] = i;
                indicesCount++;
            }
        }
        return indices;
    }

    //testing the number 
    public static void main(String[] args) {
        String filename = (args.length > 0) ? args[0] : "data/YUMA_2023.txt";
        Scanner file = null;

        //tries to access the file, otherwise prints "Cannot locate file"
        try {
            file = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            System.err.println("Cannot locate file.");
            System.exit(-1);
        }

        // counts the number in file to create an array later on
        int count = 0;
        while (file.hasNextLine()) {
            count++;
            file.nextLine();
        }

        float[] tempsArr = new float[count]; //create a float array 
        int index = 0;
        file.close(); // closing file

        // setting cursor up to top of file.
        try {
            file = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            System.err.println("Cannot locate file.");
            System.exit(-1);
        }

        float[] minArr = new float[count]; //creates array to store minimum value in each year
        float[] maxArr = new float[count]; //create array to store maximum value in each year
        String[] dates = new String[count]; //stores the dates in array

        //loops through the file
        while (file.hasNextLine()) {
            String line = file.nextLine();
            String[] fields = line.split("\\s+");
            String date = fields[1];
            float temperature = Float.valueOf(fields[8]);
            float minTemps = Float.valueOf(fields[6]);
            float maxTemps = Float.valueOf(fields[5]);
            dates[index] = date; //stores the date into date array
            tempsArr[index] = temperature; //stores the temperature in array
            minArr[index] = minTemps;  //stores minimum value from field 6 into minTemps
            maxArr[index] = maxTemps;  //stores maximum value into field 5 maxTemps
            index++;
        }
        file.close();

        System.out.println(Arrays.toString(tempsArr)); //prints out the array of temperatures

        boolean[] negative = isEqualTo(tempsArr, -9999.0f); //flips value into false if temp= -9999
        boolean[] val = logicalNot(negative); 
        
        System.out.println("Source file: " + filename);
        System.out.println("mean: " + mean(tempsArr, val)); //prints mean

        boolean[] negativeMin = isEqualTo(minArr, -9999.0f); 
        boolean[] minVal = logicalNot(negativeMin); 
        System.out.println("Minimum average daily temperature: " + mean(minArr, minVal)); //prints minimum average daily

        boolean[] negativeMax = isEqualTo(maxArr, -9999.0f); 
        boolean[] maxVal = logicalNot(negativeMax);  
        System.out.println("Maximum average daily temperature: " + mean(maxArr, maxVal)); //prints maximum 
 
        boolean[] janNegative = ClimateQueries.datesBetween(dates, "20230101", "20230131");
        boolean[] janIndicator = ClimateQueries.logicalAnd(janNegative, val);
        System.out.println("Mean temperature in January: " + mean(tempsArr, janIndicator)); //prints january mean

        boolean[] julyNegative = ClimateQueries.datesBetween(dates, "20230701", "20230731");
        boolean[] julyIndicator = ClimateQueries.logicalAnd(julyNegative, val);
        System.out.println("Mean temperature in July: " + mean(tempsArr, julyIndicator)); //prints july mean

        
        
    }
}