package service;

import domain.repository.CarRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameServiceTest {

    @DisplayName("입력받은 자동차들의 이름이 쉼표(,)를 기준으로 잘 나누어 지는가")
    @ParameterizedTest
    @ValueSource(strings = {"pobi,crong,honux", "dino,bebe"})
    @Test
    void 자동차_이름_자르기(String names) {
        GameService gameService = new GameService(new CarRepository());
        gameService.splitNames(names)
    }
}