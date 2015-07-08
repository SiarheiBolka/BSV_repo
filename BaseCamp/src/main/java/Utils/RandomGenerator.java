package Utils;

import java.util.Random;

/**
 * Created by Siarhei Bolka on 7/8/2015.
 */
public class RandomGenerator {

    public static int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }
}
