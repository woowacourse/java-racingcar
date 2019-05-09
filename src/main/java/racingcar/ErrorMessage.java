package racingcar;

import java.util.HashMap;

public class ErrorMessage {
    public static HashMap<String, String> inputErrorMessage = new HashMap<String, String>() {
        {
            put("ERROR_CAR_NAME_LENGTH", "자동자 이름을 정확하게 입력하세요.");
            put("ERROR_GAME_COUNT", "시도할 횟수를 정확하게 입력하세요");
        }
    };

}
