package org.example.hongjun.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Lotto {
    List<Integer> winNumber = new ArrayList<>(); // 번호
    Random random = new Random();

    // 로또 번호 생성
    public void makeLotto() {
        // 중복되지 않는 6개 번호 생성
        while (winNumber.size() != 6) {
            int number = random.nextInt(45) + 1;
            if (!winNumber.contains(number)) {
                winNumber.add(number);
            }
        }
        // 정렬
        Collections.sort(winNumber);
    }
}
