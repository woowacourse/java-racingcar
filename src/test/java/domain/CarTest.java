package domain;


import static org.mockito.Mockito.mockStatic;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import utils.RandomNumberGenerator;
import static org.mockito.BDDMockito.given;


class CarTest {
    private static MockedStatic<RandomNumberGenerator> generator;

    @BeforeAll
    public static void setUp() {
        generator = mockStatic(RandomNumberGenerator.class);
    }

    @AfterAll
    public static void tearDown() {
        generator.close();
    }

    @Test
    void carMoveTest() {
        given(RandomNumberGenerator.generate()).willReturn(5);
        Car car = new Car(new CarName("toby"));
        car.move();
        Assertions.assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void carDoesNotMoveTest() {
        given(RandomNumberGenerator.generate()).willReturn(2);
        Car car = new Car(new CarName("toby"));
        car.move();
        Assertions.assertThat(car.getPosition()).isEqualTo(0);
    }
}
