package org.example.seoyeon.lotto;

public class Application {
    public static void main(String[] args) {
        LottoGameController lottoGameController = new LottoGameController(6, 1, 45);
        lottoGameController.play();
    }
}
