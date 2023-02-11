package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.NumberGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    @DisplayName("Cars 객체 생성 성공 테스트")
    void createCarsTest() {
        List<String> carsName = new ArrayList<>(Arrays.asList("pobi","crong","honux"));
        Cars cars = new Cars(carsName);

        assertThat(cars.getCars().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("단일 우승자인 경우 결과 테스트")
    void getWinnerTest() {
        List<String> carsName = new ArrayList<>(Arrays.asList("ocean","jamie"));
        Cars cars = new Cars(carsName);
        List<Integer> randomNumbers = new ArrayList<>(Arrays.asList(9, 0, 6, 7));

        TestNumberGenerator testNumberGenerator = new TestNumberGenerator(randomNumbers);

        for (int i = 0; i < 2; i++)
            cars.moveResult(testNumberGenerator);

        List<String> answer = new ArrayList<>(Arrays.asList("ocean"));
        assertThat(cars.getWinners()).isEqualTo(answer);
    }

    @Test
    @DisplayName("다중 우승자인 경우 결과 테스트")
    void getWinnersTest() {

        List<String> carsName = new ArrayList<>(Arrays.asList("ocean","jamie"));
        Cars cars = new Cars(carsName);
        List<Integer> randomNumbers = new ArrayList<>(Arrays.asList(9, 9, 6, 6));

        TestNumberGenerator testNumberGenerator = new TestNumberGenerator(randomNumbers);

        for (int i = 0; i < 2; i++)
            cars.moveResult(testNumberGenerator);

        List<String> answer = new ArrayList<>(Arrays.asList("ocean","jamie"));
        assertThat(cars.getWinners()).isEqualTo(answer);
    }

    static class TestNumberGenerator implements NumberGenerator {
        private final List<Integer> numbers;

        public TestNumberGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generateNumber() {
            return numbers.remove(0);
        }
    }
}
