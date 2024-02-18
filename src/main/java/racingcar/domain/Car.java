package racingcar.domain;

public class Car {
    private static final int BOUND = 10;

    private final String name;
    private int position;
    private final NumberGenerator numberGenerator;

    public Car(String name, NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
        this.name = name;
    }

    private boolean canMove(){
        int random = numberGenerator.generateNumber(BOUND);
        return random >= 4;
    }

    public void move() {
        if (canMove()) {
            position++;
        }
    }

    public int comparePosition(int otherPosition){
        return Math.max(otherPosition, position);
    }

    public boolean matchesPosition(int otherPosition){
        return position == otherPosition;
    }

    public String getName(){
        return name;
    }

    public int getPosition() {
        return position;
    }



}
