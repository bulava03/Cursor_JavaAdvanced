package model;

public class Pilot {
    private String name;
    private int age;
    private String models;

    public Pilot(String name, int age, String models) {
        this.name = name;
        this.age = age;
        this.models = models;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getModels() {
        return models;
    }

    @Override
    public String toString() {
        return "Pilot{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", models=" + models +
                '}';
    }
}
