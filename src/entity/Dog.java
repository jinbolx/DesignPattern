package entity;

public class Dog extends Animal {
    int age=22;
    @Override
    public void display() {
        super.display();
        System.out.println("dog"+age);
    }
}
