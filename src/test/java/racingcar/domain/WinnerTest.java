package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("최종 우승자")
class WinnerTest {
    @Test
    @DisplayName("생성에 성공한다.")
    public void createTest() {
        //given
        String userInput = "choco, seyan";
        String winner1 = "choco";
        String winner2 = "seyan";

        //when
        Vehicles vehicles = Vehicles.from(userInput);
        vehicles.getBiggestCars();
        Winner winner = Winner.from(vehicles.getBiggestCars());

        //then
        assertEquals(winner.getWinners().get(0), winner1);
        assertEquals(winner.getWinners().get(1), winner2);
    }
}