import org.jetbrains.annotations.Nullable;

public class PersonBuilder implements IPersonBuilder {
    private String name;
    private String surname;
    @Nullable
    private Integer age;
    @Nullable
    private String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (name == null) {
            throw new IllegalArgumentException("Поле name должно быть заполнено.");
        }
        if (surname == null) {
            throw new IllegalArgumentException("Поле surname должно быть заполнено.");
        }
        Person result;
        if (age != null) {
            if (age < 0) {
                throw new IllegalArgumentException("Возраст не может быть отрицательным.");
            }
            result = new Person(name, surname, age);
        } else {
            result = new Person(name, surname);
        }
        if (address != null) {
            result.setAddress(address);
        }
        return result;
    }
}
