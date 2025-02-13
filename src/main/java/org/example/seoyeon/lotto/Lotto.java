package org.example.seoyeon.lotto;

import java.util.*;

public class Lotto {
    List<Integer> lottoes = new ArrayList<>();
    Random random = new Random();

    public Lotto() {
        makeLottery();
    }

    public Lotto(List<Integer> lottoes) {
        this.lottoes = lottoes;
    }

    public void makeLottery() {
        for (int i = 0; i < LottoValue.NUMBER.value; i++) {
            int n = random.nextInt(LottoValue.MAX.value) + 1;
            if (lottoes.contains(n)) {
                i--;
            } else {
                lottoes.add(n);
            }
        }
        Collections.sort(lottoes);
    }


}
