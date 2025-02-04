package org.example.haneul.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lotto {

    Random rand = new Random();
    public List create() {
        List<Integer> lottoes=new ArrayList<>(6);
        while (lottoes.size()<6) {
            int n=rand.nextInt(1,46);
            if (!lottoes.contains(n)) {
                lottoes.add(n);
            }
        }
        return lottoes;
    }
}
