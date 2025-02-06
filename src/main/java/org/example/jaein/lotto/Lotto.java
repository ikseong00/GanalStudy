package org.example.jaein.lotto;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Lotto {
    List<Integer> lotto=new ArrayList<>();
    Random rand=new Random();

    public void makeLotto() {    //로또 자동 번호 돌리기
        while(lotto.size()<6) {
            int num=rand.nextInt(45)+1;
            if (!lotto.contains(num)) {
                lotto.add(num);
            }
        Collections.sort(lotto); //오른차순으로 자동 번호 정렬
        }
    }
}
