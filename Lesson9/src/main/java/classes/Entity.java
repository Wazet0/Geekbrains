package classes;

public interface Entity {
    public boolean tryRun(int l);
    public boolean tryJump(int l);
    public String getName();
    public String getType();
    public boolean getIsPassed();
    public void setIsPassed(boolean isPassed);
}
