package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.NumberGenerator;

class RacingGameTest {
    private final AlwaysMoveNumberGenerator alwaysMoveNumberGenerator = new AlwaysMoveNumberGenerator();
    private final NeverMoveNumberGenerator neverMoveNumberGenerator = new NeverMoveNumberGenerator();

    private final Car boxster = new Car("박스터");
    private final Car sonata = new Car("소나타");
    private final Car benz = new Car("벤츠");

    private final Cars dummy = new Cars(List.of(
            boxster,
            sonata,
            benz
    ));

    @Test
    @DisplayName("레이싱 게임을 한 라운드 진행할 때 4이상의 숫자가 주어지면 우승자의 위치가 1이다.")
    void moveTest() {
        RacingGame game = new RacingGame(alwaysMoveNumberGenerator, 3, dummy);
        game.playOneRound();

        List<Car> carList = dummy.getCars();
        List<String> names = carsToNames(carList);
        List<Integer> positions = carsToPositions(carList);

        assertAll(() -> {
            assertThat(names).contains("박스터", "소나타", "벤츠");
            assertThat(positions).containsOnly(1);
        });
    }

    @Test
    @DisplayName("레이싱 게임을 한 라운드 진행할 때 3이하의 숫자가 주어지면 우승자의 위치가 0이다.")
    void notMoveTest() {
        RacingGame game = new RacingGame(neverMoveNumberGenerator, 3, dummy);
        game.playOneRound();

        List<Car> carList = dummy.getCars();
        List<String> names = carsToNames(carList);
        List<Integer> positions = carsToPositions(carList);

        assertAll(() -> {
            assertThat(names).contains("박스터", "소나타", "벤츠");
            assertThat(positions).containsOnly(0);
        });
    }

    @DisplayName("isEnd 메소드는 게임 종료 여부를 반환한다")
    @ParameterizedTest(name = "시도 횟수가 {0}일 때 {1}번 시도하면 {2}")
    @CsvSource(value = {"3:1:false", "3:2:false", "3:3:true"}, delimiter = ':')
    void isEndTest(int count, int tryCount, boolean result) {
        RacingGame game = new RacingGame(alwaysMoveNumberGenerator, count, dummy);

        for (int i = 0; i < tryCount; i++) {
            game.playOneRound();
        }

        assertThat(game.isEnd()).isEqualTo(result);
    }

    @Test
    @DisplayName("시도 횟수가 100회 초과하면 예외가 발생한다")
    void tryCountEx() {
        int tryCount = 101;

        assertThatThrownBy(() -> new RacingGame(tryCount, dummy))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 100회 이하만 가능합니다 현재 : " + tryCount + "회");
    }

    static class AlwaysMoveNumberGenerator implements NumberGenerator {

        public static final int MOVE_NUMBER = 4;

        @Override
        public int generate() {
            return MOVE_NUMBER;
        }

    }

    static class NeverMoveNumberGenerator implements NumberGenerator {

        public static final int NOT_MOVE_NUMBER = 3;

        @Override
        public int generate() {
            return NOT_MOVE_NUMBER;
        }

    }

    private List<String> carsToNames(List<Car> carList) {
        return carList.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private List<Integer> carsToPositions(List<Car> carList) {
        return carList.stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());
    }
}
