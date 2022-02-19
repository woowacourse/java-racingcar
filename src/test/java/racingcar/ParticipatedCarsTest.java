package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.assertj.core.internal.bytebuddy.asm.Advice.Argument;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.Car;
import racingcar.domain.ParticipatedCars;
import racingcar.domain.WinnerNames;
import racingcar.util.BoundedRandomNumberGenerator;
import racingcar.util.MovableNumberGenerator;
import racingcar.util.NonMovableNumberGenerator;
import racingcar.util.RandomNumberGenerator;

@SuppressWarnings("NonAsciiCharacters")
public class ParticipatedCarsTest {

    private ParticipatedCars participatedCars;

    @BeforeEach
    void setCars() {
        participatedCars = new ParticipatedCars(Arrays.asList("이브", "클레이", "포비"));
    }

    @Test
    public void 자동차_생성_테스트() {
        assertThat(participatedCars.getCars().size()).isEqualTo(3);
    }

    @Test
    public void 자동차_이름_중복_테스트() {
        List<String> carNames = Arrays.asList("이브", "이브", "포비");
        assertThatThrownBy(() -> new ParticipatedCars(carNames))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("자동차 이름은 중복될 수 없습니다.");
    }


    @ParameterizedTest
    @MethodSource("provideGeneratorAndResultPosition")
    public void 자동차_작동_테스트(RandomNumberGenerator generator, int resultPosition) {
        participatedCars.tryToDriveBy(generator);
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
        participatedCars.tryToDriveBy(new BoundedRandomNumberGenerator(9, 0));
        List<String> winners = WinnerNames.of(participatedCars).getWinnerNames();

        List<String> sortedNames = getSortedNamesByPositionDesc(participatedCars);

        for (int i = 0 ; i < winners.size(); i++) {
            assertThat(winners.get(i)).isEqualTo(sortedNames.get(i));
        }
    }

    private List<String> getSortedNamesByPositionDesc(ParticipatedCars participatedCars) {
        return participatedCars.getCars().stream()
                .sorted((faster, slower) -> slower.getPosition() - faster.getPosition())
                .map(car -> car.getName())
                .collect(Collectors.toList());
    }
}
