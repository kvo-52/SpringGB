package gb.hw01;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class Person implements Serializable {
    private final String firstName;
    private final String lastName;
    private final int age;

    /**
     * Конструктор класса Person, в котором:
     *
     * @param firstName - имя;
     * @param lastName  - фамилия;
     * @param age       - возраст.
     */
    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    /**
     * toString - переопределенный метод вывода на печать объектов класса Person.
     *
     * @return - данные об объекте.
     */
    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("firstName", this.firstName)
                .append("lastName", this.lastName)
                .append("age", this.age)
                .toString();
    }

    /**
     * Метод equals сравнивает два объекта класса Person, проверяя их возраст, имя и фамилию.
     * Если все данные совпадают, метод возвращает true, иначе - false.
     *
     * @param obj - объект класса Person.
     * @return - true или false
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if (other.age != this.age) {
            return false;
        }
        return new EqualsBuilder().append(firstName, other.firstName).append(lastName, other.lastName).isEquals();
    }

    /**
     * Метод hashCode() используется для определения уникальности объекта в хэш-таблице.
     * Он возвращает целое число, которое служит “ключом” для объекта в хэш-таблице.
     * Чем меньше это число, тем больше вероятность, что объект будет найден быстрее.
     * В данном случае, метод строит хэш-код на основе имени и фамилии объекта Person, используя алгоритм MurmurHash.
     *
     * @return - целое число, которое служит “ключом” для объекта в хэш-таблице.
     */
    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(firstName)
                .append(lastName)
                .toHashCode();
    }

    /**
     * Методы для получения значений полей класса Person.
     *
     * @return - возвращают firstName, lastName или age соответственно.
     */
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }
}
