package ru.gb.AppHW03.services;

import ru.gb.AppHW03.domain.User;
import org.springframework.stereotype.Service;

/**
 * Сервис консольных уведомлений (логирование).
 */
@Service
public class NotificationService {

    /**
     * Уведомление о создании нового пользователя.
     * @param user объект пользователя.
     */
    public void notifyUser(User user) {
        System.out.println("A new user has been created: " + user.getName());
    }

    /**
     * Вывод заданного уведомления в консоль.
     * @param s сообщение для вывода.
     */
    public void sendNotification(String s) {
        System.out.println(s);
    }
}
