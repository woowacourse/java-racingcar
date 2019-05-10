package racing.model;



public class Car {
    private static final int BOUNDARY = 4;
    private static final int NAME_LENGTH_LIMIT = 5;
    private String name;
    private int position = 0;

    public Car(String name) throws Exception {
        if (name.length() > NAME_LENGTH_LIMIT || name.length() < 1)
            throw new Exception();
        this.name = name;
    }

    public void move(int randomNumber) {
        if (randomNumber >= BOUNDARY)
            position++;
    }

    public String showPosition() {
        String carPositionString = name + " : ";
        for (int i = 0; i < position; i++) {
            carPositionString += '-';
        }

        return carPositionString;
    }

    public String getName() {
        return name;
    }


    public int compareTo(Car o2) {
        if (this.position == o2.position) {
            return 0;
        }
        if (this.position > o2.position) {
            return 1;
        }
        return -1;
    }




}
