package singletonPattern;

public enum SingletonEnumClass implements SingletonEnumInterface {
    INSTANCE;

    @Override
    public void doSomething() {
        System.out.println("already initialized");
    }


    public static SingletonEnumClass getInstance() {
        return INSTANCE;
    }
}
