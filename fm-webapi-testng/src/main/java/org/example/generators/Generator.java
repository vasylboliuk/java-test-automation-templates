package org.example.generators;

import java.util.Random;

public class Generator {

    private Generator() {
        // default private constructor
    }


    public static int randomNumber() {
        return randomNumber(0, 1000000);
    }

    public static int randomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    public static String randomString() {
        return randomString(10); // default string length
    }

    public static String randomString(int targetStringLength) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        return new Random().ints(leftLimit, rightLimit + 1)
            .limit(targetStringLength)
            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
            .toString();
    }

    public static String randomEmail() {
        return randomString() + "@" + randomString() + ".com";
    }

}
