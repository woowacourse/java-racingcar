package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    private static final int CARS_LENGTH = 3;
    private static final int GAME_NOT_OVER_ROUND = 3;
    private static final int TOTAL_ROUNDS = 10;

    private final CarRepository carRepository = new CarRepository();
    private Game game;

    @BeforeEach
    void beforeEach() {
        clearDatabase();
        game = new Game(new String[]{"pobi", "jeong", "roma"}, TOTAL_ROUNDS);

        for (int i = 0; i < GAME_NOT_OVER_ROUND; i++) {
            game.playRound();
        }
    }

    @DisplayName("cars에는 생성자에 인자로 입력된 car 인스턴스의 현재 상태와 동일한 속성값을 지닌 car 인스턴스들이 담긴다.")
    @Test
    void constructor_deepCopiedInstancesHasTheSameProperties() {
        List<Car> originalCars = game.getCars();
        List<Car> deepCopiedCars = new Cars(originalCars).getCars();

        for (int idx = 0; idx < CARS_LENGTH; idx++) {
            Car origin = originalCars.get(idx);
            Car copy = deepCopiedCars.get(idx);

            assertThat(origin.getName()).isEqualTo(copy.getName());
            assertThat(origin.getPosition()).isEqualTo(copy.getPosition());
        }
    }

    @DisplayName("cars에 저장된 car 인스턴스들은 원본 객체가 변화하더라도 변화하지 않는다.")
    @Test
    void constructor_originalObjectHasNoEffectOnDeepCopiedObjects() {
        List<Car> originalCars = game.getCars();
        List<Car> deepCopiedCars = new Cars(originalCars).getCars();

        List<Integer> prevPositions = deepCopiedCars.stream()
                .mapToInt(Car::getPosition)
                .boxed()
                .collect(Collectors.toList());

        playAllRounds();

        for (int idx = 0; idx < CARS_LENGTH; idx++) {
            Car origin = originalCars.get(idx);
            Car copy = deepCopiedCars.get(idx);

            assertThat(copy.getPosition()).isEqualTo(prevPositions.get(idx));
            assertThat(copy.getPosition()).isLessThanOrEqualTo(origin.getPosition());
        }
    }

    private void playAllRounds() {
        while (!game.isOver()) {
            game.playRound();
        }
    }

    private void clearDatabase() {
        carRepository.clear();
    }
}
