package racingcargame.exception;

public enum CarsNameInputExceptionType {
    NO_CAR("※자동차 이름이 입력되지 않았습니다. 다시 입력해 주세요."),
    ONLY_ONE_CAR("※자동차 이름이 한 개만 입력되었습니다. 경주이므로 최소 두 개 이상의 자동차 이름을 입력해 주세요. (ex) pobi, crong"),
    DUPLICATED_NAMES("※중복되는 자동차 이름이 존재합니다. 각각 고유한 자동차 이름을 입력해 주세요.");

    private String errorMessage;

    CarsNameInputExceptionType(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
