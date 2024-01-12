package gb.hw01;

import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Екатерина", "Краснова", 13);
        Person person2 = new Person("Василий", "Петров", 35);
        Person person3 = new Person("Сергей", "Ефремов", 55);

        System.out.println("Результат сравнения объектов person1 и person2: " + person1.equals(person2));
        System.out.println("Результат сравнения объектов person2 и person3: " + person2.equals(person3));

        System.out.println("\nHashCode объекта person1: " + person1.hashCode());
        System.out.println("HashCode объекта person2: " + person2.hashCode());
        System.out.println("HashCode объекта person3: " + person3.hashCode());
        System.out.println("Одинаковые объекты имеют общий HashCode.");

        try {
            Gson gson = new Gson();
            String json1 = gson.toJson(person1);
            System.out.println("\nОбъект person1 сериализован.");
            String json2 = gson.toJson(person2);
            System.out.println("Объект person2 сериализован.");

            Person pers1 = gson.fromJson(json1, Person.class);
            System.out.println("\nОбъект person1 десериализован.");
            Person pers2 = gson.fromJson(json2, Person.class);
            System.out.println("Объект person2 десериализован.");

            System.out.println("\nОбъект person1:");
            System.out.println("Имя:     " + pers1.getFirstName());
            System.out.println("Фамилия: " + pers1.getLastName());
            System.out.println("Возраст: " + pers1.getAge());

            System.out.println("\nОбъект person2:");
            System.out.println("Имя:     " + pers2.getFirstName());
            System.out.println("Фамилия: " + pers2.getLastName());
            System.out.println("Возраст: " + pers2.getAge());

        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}