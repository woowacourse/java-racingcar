package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.RandomNumberGenerator;
import racingcar.repository.CarRepository;

public class RacingGameServiceTest {

    static class MockRandomNumberGenerator implements RandomNumberGenerator {

        static final int FORWARDING_NUMBER = 4;
        static final int STOPPING_NUMBER = 0;
        static final int[] RANDOM_NUMBERS = {
            FORWARDING_NUMBER, STOPPING_NUMBER,
            FORWARDING_NUMBER, STOPPING_NUMBER,
            STOPPING_NUMBER, FORWARDING_NUMBER
        };
        int index = 0;

        @Override
        public int getRandomNumber() {
            return RANDOM_NUMBERS[index++];
        }
    }

    CarRepository carRepository;
    RacingGameService racingGameService;

    @BeforeEach
    public void setUp() {
        carRepository = new CarRepository();
        carRepository.save(Car.from("pobi"));
        carRepository.save(Car.from("jason"));
        racingGameService = new RacingGameService(carRepository, new MockRandomNumberGenerator());
    }

    @Test
    public void 한_턴의_게임진행() {
        racingGameService.proceedTurn();
        assertThat(carRepository.findByName("pobi").getPosition()).isEqualTo(1);
        assertThat(carRepository.findByName("jason").getPosition()).isEqualTo(0);
    }

    @Test
    public void 여러_턴의_게임진행() {
        racingGameService.proceedTurn();
        assertThat(carRepository.findByName("pobi").getPosition()).isEqualTo(1);
        assertThat(carRepository.findByName("jason").getPosition()).isEqualTo(0);
        racingGameService.proceedTurn();
        assertThat(carRepository.findByName("pobi").getPosition()).isEqualTo(2);
        assertThat(carRepository.findByName("jason").getPosition()).isEqualTo(0);
        racingGameService.proceedTurn();
        assertThat(carRepository.findByName("pobi").getPosition()).isEqualTo(2);
        assertThat(carRepository.findByName("jason").getPosition()).isEqualTo(1);
    }
}
