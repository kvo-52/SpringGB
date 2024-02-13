package ru.gb.AppHW03.domain;

/**
 * Сущность пользователя.
 */
public class User {
    /**
     * Идентификатор пользователя.
     */
    private int id;
    /**
     * Имя пользователя.
     */
    private String name;
    /**
     * Возраст пользователя.
     */
    private int age;
    /**
     * Email пользователя.
     */
    private String email;

    public User() {
    }

    // region геттеры и сеттеры


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // endregion
}
