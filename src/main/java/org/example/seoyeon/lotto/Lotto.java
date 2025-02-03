package org.example.seoyeon.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lotto {
    List<Integer> lottoes = new ArrayList<>();
    int numberCount;
    int range;
    Random random = new Random();

    public Lotto(int num, int range) {
        numberCount = num;
        this.range = range;
        makeLottery();
    }

    public void makeLottery() {
        for (int i = 0; i < numberCount; i++) {
            int n = random.nextInt(range) + 1;
            if(lottoes.size()==0){
                lottoes.add(n);
            }
            else if (lottoes.contains(n)) {
                i--;
                continue;
            }
            for (int j = 0; j < lottoes.size(); j++) {
                if (n > lottoes.get(j) && j == lottoes.size() - 1) {
                    lottoes.add(n);
                } else if (n < lottoes.get(j)) {
                    lottoes.add(j, n);
                    break;
                }
            }
        }
    }


}
