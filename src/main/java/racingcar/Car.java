package racingcar;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void moveForward() {
        this.position++;
    }

    @Override
    public String toString() {
        String pos = new String(new char[position]).replace("\0", "-");
        return this.name + " : " + pos;
    }

//    public static void main(String[] args) {
//        Car a = new Car("asdf");
//        System.out.println(a.getName());
//        System.out.println(a.getPosition());
//        a.moveForward();
//        System.out.println(a.getPosition());
//        System.out.println(a);
//        a.moveForward();
//        a.moveForward();
//        System.out.println(a);
//    }
}
