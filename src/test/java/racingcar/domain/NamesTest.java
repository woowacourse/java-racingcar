package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class NamesTest {
    @DisplayName("이름 중복을 가진 Names 검증 테스트")
    @ParameterizedTest
    @CsvSource({"is2js,코니,is2js", "코니,is2js,코니"})
    void invalid_duplicated_names(String name1, String name2, String name3) {
        List<Name> nameList = Arrays.asList(Name.from(name1), Name.from(name2), Name.from(name3));

        assertThatThrownBy(() -> Names.from(nameList)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이름 중복이 없는 Names 검증 테스트")
    @ParameterizedTest
    @CsvSource({"is2js,코니,is3js", "코니,is2js,코나"})
    void valid_distinct_names(String name1, String name2, String name3) {
        System.out.println(name1);
        System.out.println(name3);
        List<Name> nameList = Arrays.asList(Name.from(name1), Name.from(name2), Name.from(name3));

        assertDoesNotThrow(() -> Names.from(nameList));
    }
}
