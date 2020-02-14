package racinggame.controller;

import racinggame.controller.Input;
import racinggame.controller.Output;
import racinggame.domain.RacingGame;

/**
 * Main 클래스는 메인 로직의 최상위 운영을 담당하는 클래스이다.
 * Input,Output 객체의 인스턴스를 보유하고,
 * 이를 RacingGame 클래스에 전달하여 게임을 진행한다.
 * 프로그램이 시작하는 main 메서드를 가지고 있다.
 */
public class Main {
    public static void main(String... args) {
        Input input = new Input();
        Output output = new Output();
        RacingGame.play(input, output);
    }
}

