package domain;

public class Car {

    private final String name;
    private int position;

    public Car(String name) {
        validateLengthOfName(name);
        this.name = name;
        position = 0;
    }

    private void validateLengthOfName(String name) {
        if (name.length() < 1 || name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 자동차이름의 길이는 1-5자까지 가능합니다.");
        }
    }

    public void move(RandomNumberGenerator randomNumberGenerator){
        if (randomNumberGenerator.generate() > 3) {
            position++;
        }
    }

    public int getPosition(){
        return position;
    }

    public String getName() {
        return name;
    }
}
