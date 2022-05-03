package classes;

public class Robot implements Entity{
    private int power;
    private String name;
    private String type = "Робот";
    private boolean isPassed = true;

    public Robot(String name, int power){
        this.name = name;
        this.power = power;
    }
    @Override
    public boolean tryRun(int l){
        return l <= this.power;
    }
    @Override
    public boolean tryJump(int l){
        return l <= this.power;
    }
    @Override
    public String getName(){
        return this.name;
    }
    @Override
    public String getType(){
        return this.type;
    }
    @Override
    public boolean getIsPassed(){
        return this.isPassed;
    }
    @Override
    public void setIsPassed(boolean isPassed){
        this.isPassed = isPassed;
    }
}
