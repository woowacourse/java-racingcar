package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("경주 객체 테스트")
public class CarRacingTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/racingtestcase/illegalCarNamesTestcase.csv")
    @DisplayName("잘못된 이름이 하나라도 있을 때 테스트")
    public void illegalNamesTest (String name1, String name2, String name3){
        String[] names = {name1, name2, name3};
        List<String> nameList = Arrays.asList(names);

        assertThatThrownBy(() -> new CarRacing(nameList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하여야 합니다.");
    }
}
