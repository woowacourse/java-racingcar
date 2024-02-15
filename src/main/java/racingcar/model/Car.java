package racingcar.model;

public class Car {
    private final String name;
    private int position;
    private NumberGenerator numberGenerator;

    public Car(String name, NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
        this.name = name;
    }

    private boolean canMove(){
        int random = numberGenerator.generateNumber(10);
        return random >= 4;
    }

    public void move() {
        if (canMove()) {
            position++;
        }
    }

    public int comparePosition(int currentMaxPosition){
        return Math.max(currentMaxPosition, position);
    }

    public boolean checkIsWinner(int finalMaxPosition){
        return position == finalMaxPosition;
    }

    public String getName(){
        return name;
    }

    public int getPosition() {
        return position;
    }



}
