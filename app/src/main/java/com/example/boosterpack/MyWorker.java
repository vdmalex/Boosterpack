package com.example.boosterpack;

import io.magicthegathering.javasdk.api.CardAPI;
import io.magicthegathering.javasdk.resource.Card;

public class MyWorker {
    public static int minus(int value){
        return value-1;
    }
    public static int plus(int value){
        return value+1;
    }
    public static String test() {
        int multiverseId = 1;
        Card card = new Card();
        card.setName("test");
        String name = card.getName();
        return name;
    }
}
