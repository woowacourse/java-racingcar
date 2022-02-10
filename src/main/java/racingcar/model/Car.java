package racingcar.model;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
    }

    public void forward(boolean canForward) {
        if (canForward) {
            this.position += 1;
        }
    }

    @Override
    public String toString() {
        String result = "";
        result += name + " : ";
        for (int count = 0; count < this.position; count++) {
            result += "-";
        }
        result += "\n";
        return result;
    }
}
