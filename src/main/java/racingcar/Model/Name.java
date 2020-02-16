package racingcar.Model;

public class Name {
    private String name;

    public Name(final String name) {
        checkEmptyCarName(name);
        checkSmallerThanSix(name);
        this.name = name;
    }

    public static void checkEmptyCarName(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException("차 이름은 빈 문자열일 수 없습니다.");
        }
    }

    public static void checkSmallerThanSix(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("차 이름의 길이가 6 이상입니다.");
        }
    }

    public String getName() {
        return name;
    }
}
