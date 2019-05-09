package racing.domain;

public class Car {
    private static final int MAX_CAR_NAME = 5;
    private final String name;
    private int distance;


    public Car(String name) {
        this.name = checkName(name);
        distance = 0;
    }

    private String checkName(String name){
        if (name.length() > MAX_CAR_NAME){
            throw new IllegalArgumentException("레이서의 이름은 5자 이하여야 합니다.");
        }
        return name;
    }
}
