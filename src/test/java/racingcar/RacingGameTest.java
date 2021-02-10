package racingcar;

import racingcar.controller.RacingGame;
import racingcar.model.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RacingGameTest {

    @Test
    @DisplayName("입력값을 쉼표 단위로 나눠서 리스트 객체로 반환한다.")
    public void splitInputTest() throws Exception {
        List<String> splittedInput = RacingGame.splitInput("Ryan,Pika");
        List<String> expected = Arrays.asList("Ryan", "Pika");
        assertThat(splittedInput).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("게임 시행 횟수는 1 이상의 숫자여야 한다.")
    @ValueSource(strings = {"  ", " as", "b3"})
    void isValidNumberTest(String number) {
        assertThrows(IllegalArgumentException.class, () -> RacingGame.isValidNumber(number));
    }

    @Test
    @DisplayName("가장 멀리 이동한 자동차가 우승한다.")
    void findWinnersTest() {
        List<Car> cars = Arrays.asList(
                new Car("Babo", 5),
                new Car("Ryan", 3),
                new Car("Pika", 5)
        );
        RacingGame.assignCars(cars);

        /*
         * 여기서 getCars() 메소드는 테스트케이스를 위한 메소드라고 생각이 됩니다. (나중에 확장하다보면 쓰일 수 있겠지만 현재로는)
         * RacingGame 내부에있는 변수에 직접 접근하는 것보다 메소드를 사용하는 것이 낫다고 판단되어 사용했는데 테스트 케이스를 위한 메소드를 만들어도 될까요?
         */
        RacingGame.getCars().updateMaxDistance();
        assertThat(RacingGame.findWinners()).isEqualTo(Arrays.asList(
                new Car("Babo", 5),
                new Car("Pika", 5)));
    }
}
