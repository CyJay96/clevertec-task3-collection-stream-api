package by.voytko;

import by.voytko.model.Animal;
import by.voytko.model.Car;
import by.voytko.model.Flower;
import by.voytko.model.House;
import by.voytko.model.Person;
import by.voytko.util.Util;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalInt;

public class Main {
    public static void main(String[] args) throws IOException {
        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
        task7();
        task8();
        task9();
        task10();
        task11();
        task12();
        task13();
        task14();
        task15();
    }

    private static void task1() throws IOException {
        List<Animal> animals = Util.getAnimals();
        animals.stream()
                .filter(animal -> animal.getAge() >= 10 && animal.getAge() <= 20)
                .sorted(Comparator.comparing(Animal::getAge))
                .skip(14)
                .limit(7)
                .forEach(System.out::println);
    }

    private static void task2() throws IOException {
        List<Animal> animals = Util.getAnimals();
        animals.stream()
                .filter(animal -> animal.getOrigin().equals("Japanese"))
                .filter(animal -> animal.getGender().equals("Female"))
                .map(animal -> animal.getBread().toUpperCase())
                .forEach(System.out::println);
    }

    private static void task3() throws IOException {
        List<Animal> animals = Util.getAnimals();
        animals.stream()
                .filter(animal -> animal.getAge() > 30)
                .map(Animal::getOrigin)
                .filter(origin -> origin.charAt(0) == 'A')
                .distinct()
                .forEach(System.out::println);
    }

    private static void task4() throws IOException {
        List<Animal> animals = Util.getAnimals();
        long femaleCount = animals.stream()
                .filter(animal -> animal.getGender().equals("Female"))
                .count();
        System.out.println(femaleCount);

    }

    private static void task5() throws IOException {
        List<Animal> animals = Util.getAnimals();
        boolean isHungarianExists = animals.stream()
                .filter(animal -> animal.getAge() >= 20 && animal.getAge() <= 30)
                .anyMatch(animal -> animal.getOrigin().equals("Hungarian"));
        System.out.println(isHungarianExists);
    }

    private static void task6() throws IOException {
        List<Animal> animals = Util.getAnimals();
        boolean isAllMaleOrFemale = animals.stream()
                .allMatch(animal -> animal.getGender().equals("Male") || animal.getGender().equals("Female"));
        System.out.println(isAllMaleOrFemale);
    }

    private static void task7() throws IOException {
        List<Animal> animals = Util.getAnimals();
        boolean isNoOceania = animals.stream()
                .noneMatch(animal -> animal.getOrigin().equals("Oceania"));
        System.out.println(isNoOceania);
    }

    private static void task8() throws IOException {
        List<Animal> animals = Util.getAnimals();
        OptionalInt maxAgeOptional = animals.stream()
                .sorted(Comparator.comparing(Animal::getBread))
                .limit(100)
                .mapToInt(Animal::getAge)
                .max();
        System.out.println(maxAgeOptional.isPresent() ? maxAgeOptional.getAsInt() : 0);
    }

    private static void task9() throws IOException {
        List<Animal> animals = Util.getAnimals();
        OptionalInt minLengthOptional = animals.stream()
                .map(Animal::getBread)
                .map(String::toCharArray)
                .mapToInt(bread -> bread.length)
                .min();
        System.out.println(minLengthOptional.isPresent() ? minLengthOptional.getAsInt() : 0);
    }

    private static void task10() throws IOException {
        List<Animal> animals = Util.getAnimals();
        int ageSum = animals.stream()
                .mapToInt(Animal::getAge)
                .reduce(0, Integer::sum); // reduce example
        System.out.println(ageSum);
    }

    private static void task11() throws IOException {
        List<Animal> animals = Util.getAnimals();
        //        animals.stream() Продолжить ...
    }

    private static void task12() throws IOException {
        List<Person> people = Util.getPersons();
//        Продолжить...
    }

    private static void task13() throws IOException {
        List<House> houses = Util.getHouses();
        //        Продолжить...
    }

    private static void task14() throws IOException {
        List<Car> cars = Util.getCars();
        //        Продолжить...
    }

    private static void task15() throws IOException {
        List<Flower> flowers = Util.getFlowers();
        //        Продолжить...
    }
}