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
            throw new IllegalArgumentException();
        }
    }

    public void move(int moveNumber){
        if (moveNumber > 3) {
            position++;
        }
    }

    public int getPosition(){
        return position;
    }
}
