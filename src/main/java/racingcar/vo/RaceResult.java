package racingcar.vo;

public class RaceResult {

    private static final String DEFAULT_RACE_ALL_RESULT = "자동차 경주 진행 전입니다.";

    private final String result;

    public RaceResult() {
        this.result = DEFAULT_RACE_ALL_RESULT;
    }

    public RaceResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}
