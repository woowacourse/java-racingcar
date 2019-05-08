package racing;

public class Car implements Comparable<Car> {
    private String name;
    private Integer status = 1;

    Car(String name){
        this.name=name;
    }
    Car(String name, Integer status){
        if (name.matches("[0-9a-zA-Z]{1,5}")) {
            throw new IllegalArgumentException("이름이 글자수를 초과합니다.");
        }
        this.name = name;
        this.status = status;
    }

    Integer getStatus() {
        return status;
    }

    String getName() {
        return name;
    }

    void moveOneTime(){
        int rand = generateRandomNumber();
        if(goOrStop(rand)){
            status++;
        }
    }

    @Override
    public int compareTo(Car o) {
        return this.status.compareTo(o.status);
    }

    private int generateRandomNumber() {
        return (int) (Math.random() * 10);
    }

    boolean goOrStop(int randomNum){
        return randomNum >= 4;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        sb.append(" : ");
        for(int i = 0; i < this.status; i++){
            sb.append('-');
        }
        return sb.toString();
    }


}
