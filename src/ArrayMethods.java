public class ArrayMethods {
    public static float wholeSum(float[] arr) {
        float wholeSum = 0.0f;
        // write your code here
        // change the return statement below to return your answer
        for (int i = 0; i < arr.length; i++) {
            wholeSum += arr[i];
        }
        return wholeSum;
    }

    public static float sum(float[] arr, int lo, int hi) {
        // write your code here and return your answer
        float sum = 0.0f;

        for (int i = lo; i < hi; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static float mean(float[] arr, int lo, int hi) {
        // write your code here and return your answer
        if(arr.length == 0) {
            return 0.0f; 
        }
        return sum(arr, lo, hi) / (hi - lo);
    }

    public static float mean(float[] arr) {
        // write your code here and return your answer
        if(arr.length == 0) {
            return 0.0f; 
        }
        return wholeSum(arr) / arr.length;
    }

    public static float min(float[] arr, int lo, int hi) {
        // write your code here and return your answer
        if(arr.length == 0) {
            return Float.NaN; 
        }
        else {
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

    public static float min(float[] arr) {
        // write your code here and return your answer
        return min(arr, 0, arr.length); 
    }

    public static float max(float[] arr, int lo, int hi) {
        // write your code here and return your answer
        if(arr.length == 0) {
            return Float.NaN; 
        }
        else {
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

    public static float max(float[] arr) {
        // write your code here and return your answer
        return max(arr, 0, arr.length); 
    }

}
