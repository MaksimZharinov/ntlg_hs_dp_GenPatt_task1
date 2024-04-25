import java.util.OptionalInt;

public class Person {
    protected final String NAME;
    protected final String SURNAME;
    protected OptionalInt age;
    protected String address;

    private boolean addressKnows;

    public Person(String name, String surname) {
        NAME = name;
        SURNAME = surname;
        age = OptionalInt.empty();
        addressKnows = false;
    }

    public Person(String name, String surname, int age) {
        NAME = name;
        SURNAME = surname;
        this.age = OptionalInt.of(age);
        addressKnows = false;
    }

    public boolean hasAge() {
        return age.isPresent() ? true : false;
    }
    public boolean hasAddress() {
        return addressKnows ? true : false;
    }

    public String getName() {
        return NAME;
    }
    public String getSurname() {
        return SURNAME;
    }
    public OptionalInt getAge() {
        return age.isPresent() ? OptionalInt.of(age.getAsInt()) : OptionalInt.empty();
    }
    public String getAddress() {
        return addressKnows ? address : "Address unknown";
    }

    public void setAddress(String address) {
        this.address = address;
        addressKnows = true;
    }
    public void happyBirthday() {
        if (age.isPresent()) age = OptionalInt.of(age.getAsInt() + 1);
    }

    @Override
    public String toString() {

        return (getName() + " " + getSurname() + "\n" +
                "Age: " + getAge() + " " + "\n" +
                "Address: " + getAddress());
    }

    @Override
    public int hashCode() {
        int total = 31;

        total = total * 31 + NAME.hashCode();
        total = total * 31 + SURNAME.hashCode();
        total = total * 31 + (addressKnows ? address.hashCode() : 0);
        total = total * 31 + (age.isPresent() ? age.hashCode() : 0);

        return total;
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder().setSurname(SURNAME);
    }
}