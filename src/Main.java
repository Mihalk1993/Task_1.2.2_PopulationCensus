import java.util.*;

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
        List<Integer> personAges = new ArrayList<>();
        for (Person person : persons) {
            personAges.add(person.getAge());
        }

        long teensAmount = personAges.stream()
                .filter(x -> x < 18)
                .count();
        System.out.println("Количество несовершеннолетних - " + teensAmount + " человек");

//        Map<String, Integer> conscripts = new HashMap<>();
//        for (Person person : persons) {
//            conscripts.put(person.getSurname(), person.getAge());
//        }
//
//        conscripts.entrySet().stream()
//                .map()
//
//        persons.stream()
//                .filter(person -> person.getAge() < 18)
//                .map(person -> person.getSurname())
    }
}
