package service;

import domain.Cars;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static util.Constants.MIN_FORWARD_NUMBER;

class RacingCarServiceTest {
    private RacingCarService racingCarService;

    @BeforeEach
    void setUp() {
        racingCarService = new RacingCarService();
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
}