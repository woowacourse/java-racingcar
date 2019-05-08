package racing;

public class Car {
    private String name;
    private int status = 0;

    Car(String name){
        this.name=name;
    }

    public void goStatus(){
        if(goOrStop()){
            status++;
        }
    }

    public boolean goOrStop(){
        int randomNum = (int) (Math.random()*10);
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
