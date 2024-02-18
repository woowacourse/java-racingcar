import static org.assertj.core.api.Assertions.assertThat;

import domain.RandomMovementGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RandomMovementGeneratorTest {
    @ParameterizedTest()
    @CsvSource(value = {"0,false", "3,false", "4,true", "9,true"})
    @DisplayName("전진 혹은 정지가 잘 생성 되는지 확인한다.")
    void create(int power, boolean expected) {
        //given
        RandomMovementGenerator randomMovementGenerator = new RandomMovementGenerator((minNumber, maxNumber) -> power);
        //when
        boolean isMove = randomMovementGenerator.generate();
        //then
        assertThat(isMove).isEqualTo(expected);
    }
}
