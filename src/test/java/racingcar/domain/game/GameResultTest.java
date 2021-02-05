package racingcar.domain.game;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarName;
import racingcar.domain.car.CarsTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameResultTest {


    @ParameterizedTest
    @DisplayName("우승자가 여러명일 경우 쉼표로 구분하여 출력한다")
    @MethodSource("provideInputsFor_우승자가_여러명일_경우_쉼표로_구분하여_출력한다")
    public void 우승자가_여러명일_경우_쉼표로_구분하여_출력한다(List<CarName> input, String expected) {
        GameResult gameResult = GameResult.valueOf(input, null);
        assertEquals(expected, gameResult.getWinnersString());
    }


    @ParameterizedTest
    @DisplayName("우승자가_여러명일_경우_오른차순으로_정렬_후_출력한다")
    @MethodSource("provideInputsFor_우승자가_여러명일_경우_오른차순으로_정렬_후_출력한다")
    public void 우승자가_여러명일_경우_오른차순으로_정렬_후_출력한다(List<CarName> input, String expected) {
        GameResult gameResult = GameResult.valueOf(input, null);
        assertEquals(expected, gameResult.getWinnersString());
    }


    private static Stream<Arguments> provideInputsFor_우승자가_여러명일_경우_쉼표로_구분하여_출력한다() {
        return Stream.of(
                Arguments.of(Arrays.asList(new CarName("로이드"), new CarName("워니"), new CarName("포비")), "로이드, 워니, 포비가 최종 우승했습니다."),
                Arguments.of(Arrays.asList(new CarName("111"), new CarName("222")), "111, 222가 최종 우승했습니다."),
                Arguments.of(Arrays.asList(new CarName("a")), "a가 최종 우승했습니다.")
        );
    }

    private static Stream<Arguments> provideInputsFor_우승자가_여러명일_경우_오른차순으로_정렬_후_출력한다() {
        return Stream.of(
                Arguments.of(Arrays.asList(new CarName("포비"), new CarName("로이드"), new CarName("워니")), "로이드, 워니, 포비가 최종 우승했습니다."),
                Arguments.of(Arrays.asList(new CarName("222"), new CarName("111")), "111, 222가 최종 우승했습니다."),
                Arguments.of(Arrays.asList(new CarName("a"), new CarName("v"), new CarName("c")), "a, c, v가 최종 우승했습니다.")
        );
    }

}
