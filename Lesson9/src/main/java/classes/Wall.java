package classes;

public class Wall implements Barrier{
    private int height;

    public Wall(int h){
        this.height = h;
    }

    public void tryAction(Entity ent){
        if(ent.tryJump(this.height)){
            System.out.println(ent.getType() + " " + ent.getName() + " перепрыгнул");
        }else{
            System.out.println(ent.getType() + " " + ent.getName() + " не смог перепрыгнуть");
            ent.setIsPassed(false);
        }
    }
}
