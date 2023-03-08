import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    @Nullable
    protected Integer age;
    @Nullable
    protected String city;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public boolean hasAge() { return age != null; }
    public boolean hasAddress() { return city != null; }

    public String getName() { return name; }

    public String getSurname() { return surname; }

    public int getAge() { return age; }
    public String getAddress() { return city; }

    public void setAddress(String address) { city = address; }
    public void happyBirthday() {
        if (hasAge()) {
            age++;
        }
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder childBuilder = new PersonBuilder();
        childBuilder.setSurname(surname);
        childBuilder.setAddress(city);
        return childBuilder;
    }

    @Override
    public String toString() {
        return name + " " + surname +
                ((hasAge()) ? (" " + getAge() + " лет") : "") +
                ((hasAddress()) ? " ардес: " + getAddress() : "");
    }

    @Override
    public int hashCode() { return Objects.hash(name, surname, getAge(), getAddress()); }
}
