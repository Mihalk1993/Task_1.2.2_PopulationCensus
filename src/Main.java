import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> surNames = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();

        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    surNames.get(new Random().nextInt(surNames.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

//        Подсчёт количества несовершеннолетних:
        long teensAmount = persons.stream()
                .filter(person -> person.getAge() < 18)
                .count();
        System.out.println("Количество несовершеннолетних - " + teensAmount + " человек");

//        Выявление и вывод в консоль фамилий призывников:
        List<String> conscripts = persons.stream()
                .filter(person -> person.getSex() == Sex.MAN)
                .filter(person -> person.getAge() >= 18)
                .filter(person -> person.getAge() < 27)
                .map(person -> person.getSurname())
                .collect(Collectors.toList());
//        Вывод в консоль при необходимости:
        System.out.println("\nВоеннообязанные товарищи: \n" + conscripts);

        //        Выявление и вывод в консоль фамилий потенциально работоспособных людей с высшим образованием:
        List<Person> workableEducatedPersons = persons.stream()
                .filter(person -> person.getAge() >= 18)
                .filter(person -> person.getEducation() == Education.HIGHER)
                .sorted(Comparator.comparing(person -> person.getSurname()))
                .collect(Collectors.toList());
//        Вывод в консоль при необходимости:
        System.out.println("\nРаботоспособные товарищи с высшим образованием: \n" + workableEducatedPersons);
    }
}
