package service;

import domain.Cars;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static util.Constants.MIN_FORWARD_NUMBER;

class RacingCarServiceTest {
    private RacingCarService racingCarService;

    @BeforeEach
    void setUp() {
        racingCarService = new RacingCarService();
    }

    @DisplayName("Cars 생성 테스트")
    @Test
    void getCarsTest() {
        assertThat(racingCarService.getCars("가,나,다").getCars()).hasSize(3);
    }

    @DisplayName("반복 횟수 입력 예 처리 테스트")
    @Test
    void getCountNotNumberTest() {
        assertThatThrownBy(() -> racingCarService.getCount("notNumber")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("반복 횟수 입력 예 처리 테스트")
    @ValueSource(strings = {"-1", "0"})
    @ParameterizedTest
    void getCountInvalidNumberTest(String count) {
        assertThatThrownBy(() -> racingCarService.getCount(count)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("우승자 1명 테스트")
    @Test
    void findWinnerTest() {
        Cars cars = new Cars(List.of("가", "나", "다"));

        cars.getCars().get(0).drive(MIN_FORWARD_NUMBER);
        cars.getCars().get(1).drive(MIN_FORWARD_NUMBER);
        cars.getCars().get(1).drive(MIN_FORWARD_NUMBER); // "나"가 우승자

        assertThat(racingCarService.findWinners(cars)).containsAll(List.of("나"));
    }

    @DisplayName("우승자 여러명 테스트")
    @Test
    void findWinnersTest() {
        Cars cars = new Cars(List.of("가", "나", "다"));

        cars.getCars().get(0).drive(MIN_FORWARD_NUMBER);
        cars.getCars().get(0).drive(MIN_FORWARD_NUMBER);
        cars.getCars().get(1).drive(MIN_FORWARD_NUMBER);
        cars.getCars().get(2).drive(MIN_FORWARD_NUMBER);
        cars.getCars().get(2).drive(MIN_FORWARD_NUMBER);

        assertThat(racingCarService.findWinners(cars)).containsAll(List.of("가", "다"));
    }

    @DisplayName("모두가 우승자 테스트")
    @Test
    void findWinnersAllTest() {
        Cars cars = new Cars(List.of("가", "나", "다"));

        cars.getCars().get(0).drive(MIN_FORWARD_NUMBER);
        cars.getCars().get(0).drive(MIN_FORWARD_NUMBER);
        cars.getCars().get(1).drive(MIN_FORWARD_NUMBER);
        cars.getCars().get(1).drive(MIN_FORWARD_NUMBER);
        cars.getCars().get(2).drive(MIN_FORWARD_NUMBER);
        cars.getCars().get(2).drive(MIN_FORWARD_NUMBER);

        assertThat(racingCarService.findWinners(cars)).containsAll(List.of("가", "나", "다"));
    }


}