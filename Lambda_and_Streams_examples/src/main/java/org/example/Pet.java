package org.example;

public class Pet {
    private PetType type;
    private String name;
    private int age;

    public Pet(PetType type, String name, int age) {
        this.type = type;
        this.name = name;
        this.age = age;
    }

    public PetType getType() {
        return type;
    }

    public void setType(PetType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "type=" + type +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
