public class InputException {
    private static final String CAR_NAME_EXCEPTION_MESSAGE = "[ERROR] 자동차 이름의 길이가 1이상 4자 이하여야 합니다.";
    private static final String COUNT_EXCEPTION_MESSAGE = "[ERROR] 0보다 큰 숫자를 입력해야 합니다.";
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final int MIN_CAR_NAME_LENGTH = 1;
    private static final int MIN_COUNT_SIZE = 1;


    public void checkCarNameLength(String carName) throws IllegalArgumentException {
        if (carName.length() > MAX_CAR_NAME_LENGTH || carName.length() < MIN_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_EXCEPTION_MESSAGE);
        }
    }

    public void checkInputCountLength(int count) {
        if (count < MIN_COUNT_SIZE) {
            throw new IllegalArgumentException(COUNT_EXCEPTION_MESSAGE);
        }
    }
}
