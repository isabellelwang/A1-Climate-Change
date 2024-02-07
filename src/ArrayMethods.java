public class ArrayMethods {
    /**
     * computes the sum in the whole array arr
     * @param arr float array of numbers
     * @return the sum, float, of the whole array arr added
     */
    public static float wholeSum(float[] arr) {
        float wholeSum = 0.0f;
        // write your code here
        // change the return statement below to return your answer
        for (int i = 0; i < arr.length; i++) {
            wholeSum += arr[i];
        }
        return wholeSum;
    }
    
    /**
     * finds the sum of the array from specific indexes ranging from lo to hi
     * @param arr array of float numbers
     * @param lo lowest index or starting point of the sum
     * @param hi last exclusive index of the sum
     * @return the sum of the array from including index lo to excluding index hi
     */
    public static float sum(float[] arr, int lo, int hi) {
        // write your code here and return your answer
        float sum = 0.0f;

        for (int i = lo; i < hi; i++) {
            sum += arr[i];
        }
        return sum;
    }

    /**
     * finds the mean of the array float from index lo to index hi
     * @param arr float array of the 
     * @param lo int lowest index or starting index for the sum
     * @param hi int highest index of the sum, but exclusive
     * @return float mean of the array from lo to hi
     */
    public static float mean(float[] arr, int lo, int hi) {
        // write your code here and return your answer
        if (arr.length == 0) {
            return 0.0f;
        }
        return sum(arr, lo, hi) / (hi - lo);
    }

    /**
     * computes mean of the array
     * @param arr array of numbers
     * @return float mean of the array arr
     */
    public static float mean(float[] arr) {
        // write your code here and return your answer
        if (arr.length == 0) {
            return 0.0f;
        }
        return wholeSum(arr) / arr.length;
    }

    /**
     * mean of the float array from lowest index lo to index hi
     * @param arr float arr of numbers to be analyzed
     * @param lo int lo lowest index of the set
     * @param hi int hi highest index considered in the set
     * @return the minimum number in the float array from index lo to index hi
     */
    public static float min(float[] arr, int lo, int hi) {
        // write your code here and return your answer
        if (arr.length == 0) {
            return Float.NaN;
        } else {
            float min = arr[lo];
            int i;
            for (i = lo + 1; i < hi; i++) {
                if (arr[i] < min) {
                    min = arr[i];
                }
            }
            return min;
        }
    }

    /**
     * finds the min in float array 
     * @param arr float array of numbers
     * @return the minimum float of array from index 0 to index arr.length
     */
    public static float min(float[] arr) {
        // write your code here and return your answer
        return min(arr, 0, arr.length);
    }

    /**
     * computes the max from the array arr from int lo to int hi
     * @param arr array of float numbers
     * @param lo int index of the lowest number
     * @param hi int highest index of the array being found
     * @return the maximum number found in the float array from index lo to index hi
     */
    public static float max(float[] arr, int lo, int hi) {
        // write your code here and return your answer
        if (arr.length == 0) {
            return Float.NaN;
        } else {
            float max = arr[lo];
            int i;
            for (i = lo; i < hi; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                }
            }
            return max;
        }
    }

    /**
     * calls on the max(float[], 0, arr.length) method above but sets index to lo= 0 and hi = arr.length
     * @param arr array of flot numbers
     * @return the maximum number found in the array from index 0 to index arr.length
     */
    public static float max(float[] arr) {
        // write your code here and return your answer
        return max(arr, 0, arr.length);
    }

}
