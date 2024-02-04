public class ClimateQueries{

    // Below are stubs for each of the methods for the 
    // climate analysis. You should include both ranged
    // and unranged methods for each, but only the unranged
    // are listed below

    public static boolean[] isEqualTo(float[] arr, float val){
        // add your code here 
        // replace code below with your own return statement
        
        boolean[] indicator = new boolean[arr.length];

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == val){
                indicator[i] = true; 
            }
        }
        return indicator;
    }

    public static boolean[] logicalNot(boolean[] arr){
        // add your code here
        // replace code below with your own return statement
        boolean[] indicator = new boolean[arr.length]; 

        for(int i = 0; i < arr.length; i++) {
            indicator[i] = !arr[i]; 
        }
        return indicator;
    }

    public static boolean[] logicalAnd(boolean[] arr1, boolean[] arr2){
        // add your code here
        // replace code below with your own return statement
        if(arr1.length != arr2.length) {
            throw new RuntimeException("Lengths do not equal each other.");
        }
        boolean[] indicator = new boolean [arr1.length];
        for(int i = 0; i < arr1.length; i++) {
            if(arr1[i] && arr2[i]) {
                indicator[i] = true; 
            }
            else {
                indicator[i] = false; 
            }
        }
        return indicator;
    }

    public static boolean[] isGreaterThan(float[] arr, float val){
        // add your code here
        // replace code below with your own return statement
        boolean[] indicator = new boolean[arr.length];

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > val){
                indicator[i] = true; 
            }
        }
        return indicator;
    }

    public static boolean[] datesBetween(String[] arr, String date1, String date2){
        // add your code here
        // replace code below with your own return statement
        boolean[] indicator = new boolean[arr.length];

        for(int i = 0; i < arr.length; i++) {
            if(Integer.parseInt(arr[i]) > Integer.parseInt(date1) && Integer.parseInt(arr[i]) < Integer.parseInt(date2)) {
                indicator[i] = true; 
            }
            else {
                indicator[i] = false; 
            }
        }
        return indicator;
    }

    public static float mean(float[] arr, boolean[] indicator, int lo, int hi){
        // add your code here
        // replace code below with your own return statement
        float count = 0.0f;
        float sum = 0.0f; 
        for(int i = lo; i < hi; i++) {
            if (indicator[i]) {
                sum += arr[i]; 
                count++; 
            }
        } 
        return sum/count; 
    
    }

    public static float mean(float[] arr, boolean[] indicator){
        // add your code here
        // replace code below with your own return statement
        return mean(arr, indicator, 0, arr.length);
    }

    public static int count(boolean[] arr){
        // add your code here
        // replace code below with your own return statement
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i]) {
                count++; 
            }
            
        }
        return count; 
    }

    public static int findFirst(boolean[] arr){
        // add your code here
        // replace code below with your own return statement
        for(int i = 0; i < arr.length; i++) {
            if(arr[i]) {
                return i; 
            }
        }
        return -1;
    }

    public static int[] find(boolean[] arr){
        // add your code here
        // replace code below with your own return statement
        int count = 0; 
        for(int i = 0; i < arr.length; i++) {
            if(arr[i]) {
                count++; 
            }
        }
        int[] indices = new int[count];
        int indicesCount = 0; 
        for(int i = 0; i < count; i++) { 
            if(arr[i]) {
                indices[indicesCount] = i;
                indicesCount++; 
            }
        }
        return indices; 
    }
}