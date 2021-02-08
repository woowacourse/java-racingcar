package racingCar;

public class Car {
    private static final int THRESHOLD = 4;
    private static final int MINIMUM_LENGTH = 0;
    private static final int MAXIMUM_LENGTH = 5;

    private final String name;
    private int distance = 0;

    public Car(final String name){
        validate(name);
        this.name = name;
    }

    public void validate(String name) {
        if (name.length() <= MINIMUM_LENGTH || name.length() > MAXIMUM_LENGTH) {
            throw new IllegalArgumentException("길이가 1에서 5사이의 이름을 입력해주세요.");
        }
    }

    public void move(int number){
        if(number >= THRESHOLD){
            distance++;
        }
    }

    public boolean isWinner(int max){
        if (distance == max) {
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
