package domain;

public class Car {
    private String name;
    private int position;

    public Car(String name){
        this.name = name;
        this.position = 0;
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public void move(int randomNumber) {
        if (isMove(randomNumber)) {
            position++;
        }
    }

    public static boolean isMove(int randomNumber){
        return randomNumber >= Constant.MOVE_CONDITION;
    }

    public void printCurrentPosition(){
        System.out.print(String.format("%s : ", name));
        for (int i = 1; i <= position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public int compareToPosition(int pos) {
        return Math.max(pos, position);
    }
}
