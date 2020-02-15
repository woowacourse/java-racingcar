package racing.model;

public class Car {

    public static final int MAX_NAME_SIZE = 5;
    private String name;

    public Car(String name) {
        checkNameLengthUnderSix(name);
        this.name = name;
    }

    private void checkNameLengthUnderSix(String name) {
        if (name.length() > MAX_NAME_SIZE){
            throw new IllegalArgumentException("이름은 5글자를 초과할 수 없습니다.");
        }
    }
}
