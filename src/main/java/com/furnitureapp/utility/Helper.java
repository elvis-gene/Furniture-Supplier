package com.furnitureapp.utility;

import java.util.concurrent.ThreadLocalRandom;

public class Helper {
    public static Integer generateCode(){

        //This generates a fully numeric unique code
        int min = 1;
        int max = 999_999;
        return ThreadLocalRandom.current().nextLong(min, max + 1);

        //This is a different way of returning unique numbers only
        //return UUID.randomUUID().toString().replaceAll("[^0-9]", "");
    }
}
