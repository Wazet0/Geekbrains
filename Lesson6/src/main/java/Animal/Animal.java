package Animal;

public class Animal {
    protected String name;

    public Animal(){}

    protected void run(int distance){
        System.out.println(this.name + " пробежал " + distance + " м.");
    }

    protected void swim(int distance){
        System.out.println(this.name + " проплыл " + distance + " м.");
    }
}
