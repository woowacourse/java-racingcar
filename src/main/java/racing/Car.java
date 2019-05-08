package racing;

public class Car implements Comparable<Car> {
    private String name;
    private Integer status = 0;

    public Car(String name){
        this.name=name;
    }
    public Car(String name,Integer status){
        this.name = name;
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public void moveOneTime(){
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

    public boolean goOrStop(int randomNum){
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
