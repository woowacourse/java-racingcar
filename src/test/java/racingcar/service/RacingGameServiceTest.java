package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.RandomNumberGenerator;
import racingcar.repository.CarRepository;

public class RacingGameServiceTest {

    public static class MockRandomNumberGenerator implements RandomNumberGenerator {

        static final int FORWARDING_NUMBER = 4;
        static final int STOPPING_NUMBER = 0;
        static final int[] RANDOM_NUMBERS = {
            FORWARDING_NUMBER, STOPPING_NUMBER,
            FORWARDING_NUMBER, STOPPING_NUMBER,
            STOPPING_NUMBER, FORWARDING_NUMBER,
            STOPPING_NUMBER, FORWARDING_NUMBER
        };
        int index = 0;

        @Override
        public int getRandomNumber() {
            return RANDOM_NUMBERS[index++];
        }
    }

    private static final String CAR_1_Name = "pobi";
    private static final String CAR_2_Name = "jason";

    CarRepository carRepository;
    RacingGameService racingGameService;
    Car car1;
    Car car2;

    @BeforeEach
    public void setUp() {
        carRepository = new CarRepository();
        car1 = Car.from(CAR_1_Name);
        car2 = Car.from(CAR_2_Name);
        carRepository.save(car1);
        carRepository.save(car2);
        racingGameService = new RacingGameService(carRepository, new MockRandomNumberGenerator());
    }

    @Test
    public void 한_턴의_게임진행() {
        racingGameService.proceedTurn();
        assertThat(carRepository.findByName(CAR_1_Name).getPosition()).isEqualTo(1);
        assertThat(carRepository.findByName(CAR_2_Name).getPosition()).isEqualTo(0);
    }

    @Test
    public void 여러_턴의_게임진행() {
        racingGameService.proceedTurn();
        assertThat(carRepository.findByName(CAR_1_Name).getPosition()).isEqualTo(1);
        assertThat(carRepository.findByName(CAR_2_Name).getPosition()).isEqualTo(0);
        racingGameService.proceedTurn();
        assertThat(carRepository.findByName(CAR_1_Name).getPosition()).isEqualTo(2);
        assertThat(carRepository.findByName(CAR_2_Name).getPosition()).isEqualTo(0);
        racingGameService.proceedTurn();
        assertThat(carRepository.findByName(CAR_1_Name).getPosition()).isEqualTo(2);
        assertThat(carRepository.findByName(CAR_2_Name).getPosition()).isEqualTo(1);
    }

    @Test
    public void 단독우승자_조회() {
        racingGameService.proceedTurn();
        racingGameService.proceedTurn();
        racingGameService.proceedTurn();
        assertThat(racingGameService.getWinners()).contains(car1);
    }

    @Test
    public void 우승자_조회() {
        racingGameService.proceedTurn();
        racingGameService.proceedTurn();
        racingGameService.proceedTurn();
        racingGameService.proceedTurn();
        assertThat(racingGameService.getWinners()).contains(car1, car2);
    }
}
