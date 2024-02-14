package RacingCarGame;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RacingCarGameTest {

    @Test
    void carNameTrimTest(){
        String rawCarNames = "포비, 브라운,테바,안나 ";
        String[] carNames = rawCarNames.split(",");
        List<String> finalCarNames = new ArrayList<>();
        for (String carName : carNames) {
            if (carName.length() <= 0 || carName.length() > 5) {
                throw new IllegalArgumentException("올바르지 않는 자동차 이름입니다. 다시 입력해주세요.");
            }
            finalCarNames.add(carName.trim());
        }
        String[] expect = {"포비", "브라운", "테바", "안나"};
        assertArrayEquals(expect, finalCarNames.toArray());
    }

}