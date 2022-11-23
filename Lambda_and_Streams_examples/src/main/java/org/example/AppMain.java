package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class AppMain {
    private List<Person> people;

    public static void main(String[] args) {
        List<Person> persons = createData();
        System.out.println(persons);

        // do any of the persons have a cat?
        boolean result = persons.stream().anyMatch(person -> person.hasPet(PetType.CAT));
        System.out.println(result);

        //how many people have a cat?
        long catCount = persons.stream().filter(person -> person.hasPet(PetType.CAT)).count();
        System.out.println(catCount);

        //who has a cat?
        List<Person> peopleWithCats = persons.stream().filter(person -> person.hasPet(PetType.CAT)).collect(Collectors.toList());
        System.out.println(peopleWithCats);

        //who does not have a cat?
        List<Person> peopleWithoutCats = persons.stream().filter(person -> !person.hasPet(PetType.CAT)).collect(Collectors.toList());
        System.out.println(peopleWithoutCats);

        //partition people with/without cats
        Map<Boolean, List<Person>> catsAndNoCats = persons.stream().collect(Collectors.partitioningBy(
                                            person -> person.hasPet(PetType.CAT)));
        System.out.println(catsAndNoCats);

        //get the name of Tims cats
        Person person = persons.stream().filter(each -> each.isNamed("Tim Taller")).findFirst().get();

        boolean test = ("Dolly & Spot").equals(person.getPets().stream().map(Pet::getName).collect(
                                                    Collectors.joining(" & ")));
        System.out.println("Tim has Dolly & Spot as cats? " + test);

        //nombres de todas las mascotas
        List<String> nombresMascotas = persons.stream().flatMap(p -> p.getPets().stream()).map(Pet::getName).collect(Collectors.toList());
        System.out.println(nombresMascotas);

        //get a List of all the pets type
         List<PetType> allPetType = persons.stream().flatMap(p -> p.getPetTypes().stream()).collect(Collectors.toList());
         System.out.println(allPetType);

         //group people by their last name
        Map<String, List<Person>> byLastName = persons.stream().collect(Collectors.groupingBy(
                            Person::getLastName));
        System.out.println(byLastName);

        //get the age statistics of pets
        List<Integer> agesList = persons.stream().flatMap(p -> p.getPets().stream()).map(Pet::getAge).
                collect(Collectors.toList());
        System.out.println(agesList);
        IntSummaryStatistics stats = agesList.stream().collect(Collectors.summarizingInt(i -> i));
        System.out.println("Min: "+stats.getMin() + " Max: " + stats.getMax() + " Avg: " + stats.getAverage());

        //counts by pet age
        Map<Integer, Long> counts = Collections.unmodifiableMap(persons.stream().flatMap(p -> p.getPets().stream()).
                                        collect(Collectors.groupingBy(Pet::getAge, Collectors.counting())));
        System.out.println(counts);

    }


    private static List<Person> createData() {

        return Arrays.asList(new Person("Mary", "Smith").addPet(PetType.CAT, "Tabby", 2),
                            new Person("Tim", "Taller").addPet(PetType.CAT, "Dolly", 3).addPet(
                                    PetType.CAT, "Spot", 2),
                            new Person("Ted", "Smith").addPet(PetType.DOG, "Spike", 4),
                            new Person("Jake", "Snake").addPet(PetType.DOG, "Serpy", 1),
                            new Person("Lars", "Vogel").addPet(PetType.BIRD, "Twirly", 1),
                            new Person("Harry", "Hamster").addPet(PetType.HAMSTER, "Fuzzy", 1).addPet(
                                    PetType.HAMSTER, "Wuzzy", 1)
                            );
    }
}