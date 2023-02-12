package domain;

import racing.domain.RacingGame;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.Cars;
import racing.util.Converter;

import java.util.List;

class RacingGameTest {

    @DisplayName("입력받은 문자열이 잘 쪼개지는지")
    @Test
    void 문자열_분리_확인() {
        String inputNames = "pobi,crong,honux";
        List<String> names = Converter.splitInput(inputNames);
        Assertions.assertThat(names.get(0)).isEqualTo("pobi");
        Assertions.assertThat(names.get(1)).isEqualTo("crong");
        Assertions.assertThat(names.get(2)).isEqualTo("honux");
    }


    @DisplayName("자동차 이름을 받으면 자동차 객체가 생성 되어야 한다.")
    @Test
    void 자동차_생성_확인() {
        RacingGame racingGame = new RacingGame(List.of("pobi","crong","honux"), 3);
        Assertions.assertThat(racingGame.getCars().getCar(0).getName()).isEqualTo("pobi");
        Assertions.assertThat(racingGame.getCars().getCar(1).getName()).isEqualTo("crong");
        Assertions.assertThat(racingGame.getCars().getCar(2).getName()).isEqualTo("honux");
    }

}
