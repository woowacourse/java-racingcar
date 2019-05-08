package racing;

public class Car {
    private String name;
    private int status = 0;

    public Car(String name){
        this.name=name;
    }

    public void moveOneTime(){
        int rand = generateRandomNumber();
        if(goOrStop(rand)){
            status++;
        }
    }

    private int generateRandomNumber() {
        return (int) (Math.random() * 10);
    }

    public boolean goOrStop(int randomNum){
        return randomNum >= 4;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < status; i++){
            sb.append('-');
        }
        return sb.toString();
    }


}
