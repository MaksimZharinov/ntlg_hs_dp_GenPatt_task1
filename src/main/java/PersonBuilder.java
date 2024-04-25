import java.util.HashMap;
import java.util.Map;
import java.util.OptionalInt;

public class PersonBuilder {
    private Map<String, Boolean> check = new HashMap<>();
    private String name;
    private String surname;
    private OptionalInt age;
    private String address;

    public PersonBuilder() {}

    public PersonBuilder setName(String name) {
        this.name = name;
        check.put("name", true);
        return this;
    }
    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        check.put("surname", true);
        return this;
    }
    public PersonBuilder setAge(int age) throws IllegalArgumentException {
        if (age < 0) throw new IllegalArgumentException();
        this.age = OptionalInt.of(age);
        return this;
    }
    public PersonBuilder setAddress(String address) {
        this.address = address;
        check.put("address", true);
        return this;
    }

    public Person build() throws IllegalStateException {
        if (check.get("name") == null || check.get("surname") == null) {
            throw new IllegalStateException();
        }
        Person person;
        if (age != null) {
            person = new Person(name, surname, age.getAsInt());
        } else {
            person = new Person(name, surname);
        }
        if (check.get("address") != null) person.setAddress(address);
        return person;
    }
}