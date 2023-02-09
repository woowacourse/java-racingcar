package domain;

public class Car {

    private final String name;
    private int position;

    public Car(String name) {
        validateLengthOfName(name);
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition(){
        return position;
    }

    public void move(RandomNumberGenerator randomNumberGenerator){
        if (randomNumberGenerator.generate() >= 4) {
            this.position++;
        }
    }

    private void validateLengthOfName(String name) {
        if (name.length() < 1 || name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 자동차이름의 길이는 1-5자까지 가능합니다.");
        }
    }
}
