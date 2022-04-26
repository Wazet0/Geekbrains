package classes;

public class RunWay implements Barrier{
    private int length;

    public RunWay(int l){
        this.length = l;
    }

    @Override
    public void tryAction(Entity ent){
        if(ent.tryRun(this.length)){
            System.out.println(ent.getType() + " " + ent.getName() + " пробежал");
        }else{
            System.out.println(ent.getType() + " " + ent.getName() + " не смог пробежать");
            ent.setIsPassed(false);
        }
    }
}
