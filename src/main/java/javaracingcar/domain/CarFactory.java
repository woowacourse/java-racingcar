package javaracingcar.domain;

public class CarFactory {
    private static final int CAR_NAME_LENGTH_MAX_SIZE = 4;
    public static Car generateCar(String name) {
        validateNull(name);
        String trimmedName = name.trim();
        validateEmptyString(trimmedName);
        validateNameLength(trimmedName);
        return new Car(trimmedName);
    }

    private static void validateNull(String name) {
        if (name == null) {
            throw new IllegalArgumentException("null이 입력되었습니다."); //TODO enum으로 변경
        }
    }

    private static void validateEmptyString(String name) {
        if (name.equals("")) {
            throw new IllegalArgumentException("빈 문자열이 입력되었습니다.");
        }
    }

    private static void validateNameLength(String name) {
        if (name.length() > CAR_NAME_LENGTH_MAX_SIZE) {
            throw new IllegalArgumentException("이름이 최대길이를 초과했습니다.");
        }
    }
}
