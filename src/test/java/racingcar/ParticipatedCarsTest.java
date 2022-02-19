package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.Car;
import racingcar.domain.ParticipatedCars;
import racingcar.util.BoundedRandomNumberGenerator;
import racingcar.util.MovableNumberGenerator;
import racingcar.util.NonMovableNumberGenerator;
import racingcar.util.RandomNumberGenerator;
import racingcar.exception.carname.CarNameException;

@SuppressWarnings("NonAsciiCharacters")
public class ParticipatedCarsTest {

    private ParticipatedCars participatedCars;

    @BeforeEach
    void setCars() {
        participatedCars = ParticipatedCars.from("이브,클레이,포비");
    }

    @Test
    public void 자동차_생성_테스트() {
        assertThat(participatedCars.getCars().size()).isEqualTo(3);
    }

    @ParameterizedTest
    @MethodSource("provideCarNamesLineAndExceptionMessage")
    public void 자동차_생성_예외_테스트(String carNamesLine, String message) {
        assertThatThrownBy(() -> ParticipatedCars.from(carNamesLine))
                .isInstanceOf(CarNameException.class)
                .hasMessageContaining(message);
    }

    private static Stream<Arguments> provideCarNamesLineAndExceptionMessage() {
        return Stream.of(
                Arguments.of(null, "자동차 이름을 찾을 수 없습니다!"),
                Arguments.of("", "빈 문자열을 자동차 이름으로 입력할 수 없습니다."),
                Arguments.of("이브,이브,포비", "자동차 이름은 중복될 수 없습니다.")
        );
    }

    @ParameterizedTest
    @MethodSource("provideGeneratorAndResultPosition")
    public void 자동차_작동_테스트(RandomNumberGenerator generator, int resultPosition) {
        participatedCars.tryToMoveBy(generator);
        List<Car> cars = participatedCars.getCars();
        for (int i = 0; i < cars.size(); i++) {
            assertThat(cars.get(i).getPosition()).isEqualTo(resultPosition);
        }
    }

    private static Stream<Arguments> provideGeneratorAndResultPosition() {
        return Stream.of(
                Arguments.of(new MovableNumberGenerator(), 1),
                Arguments.of(new NonMovableNumberGenerator(), 0)
        );
    }

    @Test
    public void 최종_우승자_찾기_테스트() {
        participatedCars.tryToMoveBy(new BoundedRandomNumberGenerator(9, 0));
        List<String> winnerNames = participatedCars.getWinnerNames();

        List<String> sortedNames = getSortedNamesByPositionDesc(participatedCars);

        for (int i = 0 ; i < winnerNames.size(); i++) {
            assertThat(winnerNames.get(i)).isEqualTo(sortedNames.get(i));
        }
    }

    private List<String> getSortedNamesByPositionDesc(ParticipatedCars participatedCars) {
        return participatedCars.getCars().stream()
                .sorted((faster, slower) -> slower.getPosition() - faster.getPosition())
                .map(car -> car.getName())
                .collect(Collectors.toList());
    }
}
