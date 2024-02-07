import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

public class ClimateStudy {
    public static void main(String[] args) {

        float[] avgTemps = new float[8]; // average temperature of each year
        int[] firstAverage = new int[8]; // first index of average over first average
        float[] overThirty = new float[8]; // array for values over 30 degrees C
        float[] sumTemps = new float[8]; // sum of temperatures for each year
        float[] countTemps = new float[8]; // number of temperatures in each year
        float sum = 0.0f; // sum count
        float countTemp = 0.0f; // count of temperatures

        // loop through each file of DeadHorse
        for (int i = 0; i < 8; i++) {
            // System.out.println((2016 + i) + ": ");
            String filename = (args.length > 0) ? args[0]
                    : "data/Deadhorse/Deadhorse" + String.valueOf(2016 + i) + ".txt";
            Scanner file = null;
            try {
                file = new Scanner(new File(filename));
            } catch (FileNotFoundException e) {
                System.err.println("Cannot locate file.");
                System.exit(-1);
            }
            int count = 0;
            while (file.hasNextLine()) {
                count++;
                file.nextLine();
            }

            float[] tempsArr = new float[count];

            int index = 0;
            file.close(); // closing file
            // setting cursor up to top of file.
            try {
                file = new Scanner(new File(filename));
            } catch (FileNotFoundException e) {
                System.err.println("Cannot locate file.");
                System.exit(-1);
            }

            // stores the date and temperature into array
            while (file.hasNextLine()) {
                String line = file.nextLine();
                String[] fields = line.split("\\s+");
                String date = fields[1];
                float temperature = Float.valueOf(fields[8]);
                tempsArr[index] = temperature;
                // counts the temperature that are not "empty" and adds it to the sum
                if (tempsArr[index] != -9999.0f) {
                    countTemp++;
                    sum += tempsArr[index];
                }
                index++;
            }
            countTemps[i] = countTemp; // add the count of each year to the count array
            sumTemps[i] = sum; // add the sum of each year to the sum array

            file.close();

            // finding average
            boolean[] negative = ClimateQueries.isEqualTo(tempsArr, -9999.0f);
            boolean[] val = ClimateQueries.logicalNot(negative);

            avgTemps[i] = ClimateQueries.mean(tempsArr, val);

            // finding first index of temperature greater than first average
            boolean[] greaterThanAvg = ClimateQueries.isGreaterThan(tempsArr, avgTemps[0]);
            firstAverage[i] = ClimateQueries.findFirst(greaterThanAvg);

            // find temperature over 30 degrees Celsius
            boolean[] greaterThanThirty = ClimateQueries.isGreaterThan(tempsArr, 30.0f);
            overThirty[i] = ClimateQueries.count(greaterThanThirty);
        }

        // loops through average temp to print out the average temp
        for (int k = 0; k < avgTemps.length; k++) {
            System.out.println("The average temperature in " + String.valueOf(2016 + k) + " in Deadhorse is "
                    + avgTemps[k] + " degrees Celsius. ");
        }

        // loops through first average to print out the first average temperature of
        // each year
        for (int k = 0; k < firstAverage.length; k++) {
            System.out.println("The first day in " + String.valueOf(2016 + k)
                    + " in Deadhorse with a temperature greater than the first annual temperature is Day "
                    + firstAverage[k] + ". ");
        }

        // loops through the overThirty to print out number of temperatures over 30
        // degrees C.
        for (int k = 0; k < overThirty.length; k++) {
            System.out.println("The number of temperatures over 30.0 degrees Celsius in " + String.valueOf(2016 + k)
                    + " in Deadhorse is " + overThirty[k] + ". ");
        }

        float sumPeriod;
        float countPeriod;
        // splits the date into two periods (2016-2019 and 2020-2023) and prints out the
        // average of each period
        for (int i = 0; i < sumTemps.length; i += 4) {
            sumPeriod = ArrayMethods.sum(sumTemps, i, i + 4);
            countPeriod = ArrayMethods.sum(countTemps, i, i + 4);
            System.out.println("Average temperature of " + String.valueOf(2016 + i) + " to "
                    + String.valueOf(2016 + i + 3) + " is " + sumPeriod / countPeriod + " degrees Celsius.");
        }
    }
}
