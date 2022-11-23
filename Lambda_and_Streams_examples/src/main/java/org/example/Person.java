package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String firstName;
    private String lastName;
    private List<Pet> pets = new ArrayList<>();

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person addPet(PetType type, String name, int age){
        pets.add(new Pet(type, name, age));
        return this;
    }

    public boolean hasPet(PetType petType){
        return pets.stream().anyMatch(p -> p.getType().equals(petType));
    }

    public boolean isNamed(String name){
        return (firstName + " " + lastName).equals(name);
    }

    public Collection<PetType> getPetTypes(){
        return pets.stream().map(pet -> pet.getType()).collect(Collectors.toSet());
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Pet> getPets() {
        return pets;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", pets=" + pets +
                '}';
    }
}
