package racing;

public class Car implements Comparable<Car> {
    private static final String NAME_EXCEPTION_MESSAGE = "양식에 맞는 이름을 입력해주세요 !";

    private String name;
    private Integer status = 1;

    Car(String name){
        if (!name.matches("[0-9a-zA-Z]{1,5}")) {
            throw new IllegalArgumentException(NAME_EXCEPTION_MESSAGE);
        }
        this.name = name;
    }
    Car(String name, Integer status) {
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
