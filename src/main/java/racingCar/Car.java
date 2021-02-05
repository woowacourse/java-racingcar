package racingCar;

public class Car {

    String name;
    int distance;

    public Car(String name){
        validate(name);
        this.name = name;
    }

    void move(int number){
        if(number >= 4){
            distance++;
        }
    }

    public void validate(String name) {
        if (name.length() <= MINIMUM_LENGTH || name.length() > MAXIMUM_LENGTH) {
            throw new IllegalArgumentException("길이가 1에서 5사이의 이름을 입력해주세요.");
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
