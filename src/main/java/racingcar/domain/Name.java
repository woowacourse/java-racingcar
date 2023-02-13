package racingcar.domain;

public class Name {

    private static final int MINIMUM_NAME_LENGTH = 1;
    private static final int MAXIMUM_NAME_LENGTH = 5;

    private String name;

    public Name(String name) {
        if (name.length() < MINIMUM_NAME_LENGTH || name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(
                    "[ERROR] 자동차 이름은 최소 " + MINIMUM_NAME_LENGTH + "글자, 최대 " + MAXIMUM_NAME_LENGTH + "글자까지 가능해요.");
        }
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
