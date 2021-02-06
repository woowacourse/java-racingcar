package javaracingcar.controller;

import javaracingcar.domain.Game;
import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;
import java.util.List;

class GameControllerTest {
    Game game;

    @BeforeEach
    void setup() {
        List<String> carNames = Arrays.asList("a", "b", "c", "a");
        int trial = 5;
        game = Game.init(carNames, trial);
    }
    // TODO: GameController 테스트를 구현해야 함.


}