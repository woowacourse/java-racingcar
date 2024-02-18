package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("최종 우승자")
class WinnersTest {
    @Test
    @DisplayName("생성에 성공한다.")
    public void createTest() {
        //given
        String userInput = "choco, seyan";
        String winner1 = "choco";
        String winner2 = "seyan";

        //when
        Cars cars = Cars.from(userInput);
        Winners winners = Winners.from(cars.findFarthestCars());

        //then
        assertEquals(winners.getWinners().get(0), winner1);
        assertEquals(winners.getWinners().get(1), winner2);
    }
}