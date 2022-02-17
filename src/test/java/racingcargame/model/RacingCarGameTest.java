package racingcargame.model;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import racingcargame.view.NameInputValidator;

public class RacingCarGameTest {
    private RacingCarGame racingCarGame;

    @BeforeEach
    void setUp() {
        racingCarGame = new RacingCarGame("liver,lawn", "2");
    }

    @Test
    @DisplayName("생성한 자동차 객체 갯수 확인")
    void storeCarName() {
        assertThat(racingCarGame.startRace().size()).isEqualTo(2);
    }

    @Test
    @DisplayName("우승자 확인")
    void findCarName() {
        assertThat(racingCarGame.findRacingGameWinner().get(0).contains("liver")
                || racingCarGame.findRacingGameWinner().get(0).contains("lawn")).isTrue();
    }

    @Test
    @DisplayName("입력한 경주 횟수가 0일 시 객체 생성 예외")
    void InputZeroRaceCount() {
        assertThatThrownBy(() -> {
             new RacingCarGame("green", "0");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[error] 경주횟수는 1이상의 값을 입력해주세요.");
    }

    @Test
    @DisplayName("자동차 이름이 5글자를 초과한 경우 객체 생성 예외")
    void exceedCarNameLimitSize() {
        assertThatThrownBy(() -> {
            new RacingCarGame("lawn,green lawn,gl", "1");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[error] 자동차 이름을 1자이상, 5자 이하로 입력해주세요.");
    }

    @Test
    @DisplayName("중복된 자동차 이름 입력 시 객체 생성 예외")
    void inputSameCarNameException() {
        assertThatThrownBy(() -> {
            NameInputValidator.validateCarNamesInput("lawn,lawn");
            new RacingCarGame("lawn,lawn", "1");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[error] 중복된 자동차 이름이 있습니다.");
    }
}