package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("경주 객체 테스트")
public class CarRacingTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/racingtestcase/illegalCarNamesTestcase.csv")
    @DisplayName("잘못된 이름이 하나라도 있을 때 테스트")
    void illegalNamesTest (String name1, String name2, String name3){
        String[] names = {name1, name2, name3};
        List<String> nameList = Arrays.asList(names);

        assertThatThrownBy(() -> new CarRacing(nameList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하여야 합니다.");
    }

    @Test
    @DisplayName("경주 진행상황 문자열 변환 테스트")
    void displayTest() {
        List<String> carNames = new ArrayList<>();
        carNames.add("히히");
        carNames.add("유안");
        carNames.add("히유");
        carNames.add("유히");

        CarRacing carRacing = new CarRacing(carNames);

        for (int i = 0; i < 10; i++) {
            carRacing.move();
        }

        System.out.println(carRacing.convertStatusesToString());
        System.out.print("\n * winners *\n");
        System.out.println(carRacing.getWinners().stream()
                .map(Car::convertStatusToString)
                .collect(Collectors.joining("\n")));
    }
}
