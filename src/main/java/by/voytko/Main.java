package by.voytko;

import by.voytko.model.Animal;
import by.voytko.model.Car;
import by.voytko.model.Flower;
import by.voytko.model.House;
import by.voytko.model.Person;
import by.voytko.model.task16.GenreType;
import by.voytko.model.task16.Performer;
import by.voytko.model.task16.Song;
import by.voytko.util.Util;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static by.voytko.model.task16.GenreType.METAL;
import static by.voytko.model.task16.GenreType.POP;
import static by.voytko.model.task16.GenreType.ROCK;

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
        task16();
    }

    private static void task1() throws IOException {
        final int LOWER_BOUND_YEAR = 10;
        final int UPPER_BOUND_YEAR = 20;
        final int ANIMALS_COUNT_IN_ZOO = 7;

        List<Animal> animals = Util.getAnimals();

        animals.stream()
                .filter(animal -> animal.getAge() >= LOWER_BOUND_YEAR && animal.getAge() < UPPER_BOUND_YEAR)
                .sorted(Comparator.comparing(Animal::getAge))
                .skip(ANIMALS_COUNT_IN_ZOO * 2)
                .limit(ANIMALS_COUNT_IN_ZOO)
                .forEach(System.out::println);
    }

    private static void task2() throws IOException {
        final String ORIGIN = "Japanese";
        final String GENDER_FEMALE = "Female";

        List<Animal> animals = Util.getAnimals();

        animals.stream()
                .filter(animal -> animal.getOrigin().equals(ORIGIN))
                .filter(animal -> animal.getGender().equals(GENDER_FEMALE))
                .map(animal -> animal.getBread().toUpperCase())
                .forEach(System.out::println);
    }

    private static void task3() throws IOException {
        final int MIN_AGE = 30;
        final int FIRST_INDEX = 0;
        final char ORIGIN_FIRST_LETTER = 'A';

        List<Animal> animals = Util.getAnimals();

        animals.stream()
                .filter(animal -> animal.getAge() > MIN_AGE)
                .map(Animal::getOrigin)
                .filter(origin -> origin.charAt(FIRST_INDEX) == ORIGIN_FIRST_LETTER)
                .distinct()
                .forEach(System.out::println);
    }

    private static void task4() throws IOException {
        final String GENDER_MALE = "Male";

        List<Animal> animals = Util.getAnimals();

        long femaleCount = animals.stream()
                .filter(animal -> animal.getGender().equals(GENDER_MALE))
                .count();

        System.out.println(femaleCount);
    }

    private static void task5() throws IOException {
        final int LOWER_BOUND_YEAR = 20;
        final int UPPER_BOUND_YEAR = 30;
        final String ORIGIN = "Hungarian";

        List<Animal> animals = Util.getAnimals();

        boolean isHungarianExists = animals.stream()
                .filter(animal -> animal.getAge() >= LOWER_BOUND_YEAR && animal.getAge() <= UPPER_BOUND_YEAR)
                .anyMatch(animal -> animal.getOrigin().equals(ORIGIN));

        System.out.println(isHungarianExists);
    }

    private static void task6() throws IOException {
        final String GENDER_MALE = "Male";
        final String GENDER_FEMALE = "Female";

        List<Animal> animals = Util.getAnimals();

        boolean isAllMaleOrFemale = animals.stream()
                .allMatch(animal -> animal.getGender().equals(GENDER_MALE) || animal.getGender().equals(GENDER_FEMALE));

        System.out.println(isAllMaleOrFemale);
    }

    private static void task7() throws IOException {
        final String ORIGIN = "Oceania";

        List<Animal> animals = Util.getAnimals();

        boolean isNoOceania = animals.stream()
                .noneMatch(animal -> animal.getOrigin().equals(ORIGIN));

        System.out.println(isNoOceania);
    }

    private static void task8() throws IOException {
        final int MAX_ANIMAL = 100;
        final int DEFAULT_MAX_VALUE = 0;

        List<Animal> animals = Util.getAnimals();

        OptionalInt maxAgeOptional = animals.stream()
                .sorted(Comparator.comparing(Animal::getBread))
                .limit(MAX_ANIMAL)
                .mapToInt(Animal::getAge)
                .max();

        System.out.println(maxAgeOptional.isPresent() ? maxAgeOptional.getAsInt() : DEFAULT_MAX_VALUE);
    }

    private static void task9() throws IOException {
        final int DEFAULT_MAX_VALUE = 0;

        List<Animal> animals = Util.getAnimals();

        OptionalInt minLengthOptional = animals.stream()
                .map(Animal::getBread)
                .map(String::toCharArray)
                .mapToInt(bread -> bread.length)
                .min();

        System.out.println(minLengthOptional.isPresent() ? minLengthOptional.getAsInt() : DEFAULT_MAX_VALUE);
    }

    private static void task10() throws IOException {
        final int START_SUM_VALUE = 0;

        List<Animal> animals = Util.getAnimals();

        int ageSum = animals.stream()
                .mapToInt(Animal::getAge)
                .reduce(START_SUM_VALUE, Integer::sum); // reduce example

        System.out.println(ageSum);
    }

    private static void task11() throws IOException {
        final String ORIGIN = "Indonesian";

        List<Animal> animals = Util.getAnimals();

        Double averageAgeIndonesian = animals.stream()
                .filter(animal -> animal.getOrigin().equals(ORIGIN))
                .collect(Collectors.averagingInt(Animal::getAge)); // averagingInt example

        System.out.println(averageAgeIndonesian);
    }

    private static void task12() throws IOException {
        final int LOWER_BOUND_YEAR = 18;
        final int UPPER_BOUND_YEAR = 27;
        final int MAX_PEOPLE = 200;

        List<Person> people = Util.getPersons();

        people.stream()
                .filter(person -> person.getGender().equals("Male"))
                .filter(person -> LocalDate.now().compareTo(person.getDateOfBirth()) >= LOWER_BOUND_YEAR &&
                        LocalDate.now().compareTo(person.getDateOfBirth()) < UPPER_BOUND_YEAR)
                .sorted(Comparator.comparing(Person::getRecruitmentGroup))
                .limit(MAX_PEOPLE)
                .forEach(System.out::println);
    }

    private static void task13() throws IOException {
        final String BUILDING_TYPE = "Hospital";
        final String GENDER_FEMALE = "Female";
        final String GENDER_MALE = "Male";
        final int ZERO = 0;
        final int YOUNG_YEAR = 18;
        final int OLD_FEMALE_YEAR = 60;
        final int OLD_MALE_YEAR = 65;
        final int MAX_PEOPLE = 500;

        List<House> houses = Util.getHouses();

        houses.stream()
                .flatMap(house -> house.getPersonList().stream()
                        .map(person -> Map.entry(house.getBuildingType().equals(BUILDING_TYPE) ? 1 :
                                LocalDate.now().compareTo(person.getDateOfBirth()) >= ZERO &&
                                        LocalDate.now().compareTo(person.getDateOfBirth()) < YOUNG_YEAR ||
                                        (person.getGender().equals(GENDER_FEMALE) &&
                                                LocalDate.now().compareTo(person.getDateOfBirth()) > OLD_FEMALE_YEAR) ||
                                        (person.getGender().equals(GENDER_MALE) &&
                                                LocalDate.now().compareTo(person.getDateOfBirth()) > OLD_MALE_YEAR) ? 2 : 3, person)))
                .sorted(Map.Entry.comparingByKey())
                .limit(MAX_PEOPLE)
                .map(Map.Entry::getValue)
                .forEach(System.out::println);
    }

    private static void task14() throws IOException {
        final double TON_COST = 7.14;

        Predicate<Car> isTurkmenistanCar = car -> car.getCarMake().equals("Jaguar") || car.getColor().equals("White");
        Predicate<Car> isUzbekistanCar = car -> car.getMass() < 1500 ||
                car.getCarMake().equals("BMW") || car.getCarMake().equals("Lexus") ||
                car.getCarMake().equals("Chrysler") || car.getCarMake().equals("Toyota");
        Predicate<Car> isKazakhstanCar = car -> car.getColor().equals("Black") && car.getMass() > 4000 ||
                car.getCarMake().equals("GMC") || car.getCarMake().equals("Dodge");
        Predicate<Car> isKyrgyzstanCar = car -> car.getReleaseYear() < 1982 ||
                car.getCarMake().equals("Civic") || car.getCarMake().equals("Cherokee");
        Predicate<Car> isCarForRussia = car -> !car.getColor().equals("Yellow") && !car.getColor().equals("Red") &&
                !car.getColor().equals("Green") && !car.getColor().equals("Blue") ||
                car.getPrice() > 40000;
        Predicate<Car> isMongoliaCar = car -> car.getVin().contains("59");

        List<Car> cars = Util.getCars();

        Map<Integer, List<Map.Entry<Integer, Car>>> groupedCars = cars.stream()
                .map(car -> Map.entry(isTurkmenistanCar.test(car) ? 1 :
                        isUzbekistanCar.test(car) ? 2 :
                                isKazakhstanCar.test(car) ? 3 :
                                        isKyrgyzstanCar.test(car) ? 4 :
                                                isCarForRussia.test(car) ? 5 :
                                                        isMongoliaCar.test(car) ? 6 : 7, car))
                .filter(carMap -> carMap.getKey().compareTo(7) != 0)
                .collect(Collectors.groupingBy(Map.Entry::getKey));

        List<Double> costs = groupedCars.values().stream()
                .map(list -> list.stream()
                        .map(Map.Entry::getValue)
                        .mapToDouble(Car::getMass)
                        .sum() * TON_COST)
                .toList();

        double costsSum = costs.stream()
                .mapToDouble(cost -> cost)
                .sum();

        System.out.println(costs);
        System.out.println(costsSum);
    }

    private static void task15() throws IOException {
        final int FIRST_INDEX = 0;
        final char FIRST_LETTER = 'C';
        final char LAST_LETTER = 'S';
        final String VASE_MATERIAL_GLASS = "Glass";
        final String VASE_MATERIAL_ALUMINUM = "Aluminum";
        final String VASE_MATERIAL_STEEL = "Steel";
        final int COUNT_YEAR_DAYS = 365;
        final int COUNT_YEARS = 5;
        final double LITER_TO_CUBIC_METER_COEF = 0.001;
        final double WATER_CUBIC_METER_COST = 1.39;


        List<Flower> flowers = Util.getFlowers();

        double sumPrice = flowers.stream()
                .sorted(Comparator.comparing(Flower::getOrigin).reversed()
                        .thenComparing(Flower::getPrice)
                        .thenComparing(Flower::getWaterConsumptionPerDay).reversed()
                        .thenComparing(Flower::getCommonName).reversed())
                .filter(flower -> (flower.getCommonName().charAt(FIRST_INDEX) >= FIRST_LETTER &&
                        flower.getCommonName().charAt(FIRST_INDEX) <= LAST_LETTER))
                .filter(Flower::isShadePreferred)
                .filter(flower -> flower.getFlowerVaseMaterial().contains(VASE_MATERIAL_GLASS) ||
                        flower.getFlowerVaseMaterial().contains(VASE_MATERIAL_ALUMINUM) ||
                        flower.getFlowerVaseMaterial().contains(VASE_MATERIAL_STEEL))
                .mapToDouble(flower -> flower.getPrice() + flower.getWaterConsumptionPerDay() *
                        COUNT_YEAR_DAYS * COUNT_YEARS * LITER_TO_CUBIC_METER_COEF * WATER_CUBIC_METER_COST)
                .sum();

        System.out.println(sumPrice);
    }

    private static void task16() throws IOException {
        final int MAX_POPULAR_PERFORMERS = 6;
        final LocalDate MIN_SONG_DATE = LocalDate.of(2010, Month.JANUARY, 1);

        List<Performer> performers = Util.getPerformers();

        Map<GenreType, List<Performer>> groupedPerformers = performers.stream()
                .sorted(Comparator.comparing(performer -> performer.getSongs().stream()
                        .mapToInt(Song::getLikesCount)
                        .sum()))
                .limit(MAX_POPULAR_PERFORMERS)
                .filter(performer -> performer.getSongs().stream()
                        .allMatch(song -> song.getReleaseDate().isAfter(MIN_SONG_DATE)))
                .filter(performer -> ROCK.equals(performer.getGenre()) ||
                        POP.equals(performer.getGenre()) ||
                        METAL.equals(performer.getGenre()))
                .sorted(Comparator.comparing(Performer::getName))
                .collect(Collectors.groupingBy(Performer::getGenre));

        System.out.println(groupedPerformers);
    }
}