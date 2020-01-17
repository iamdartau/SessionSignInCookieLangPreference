package dao;

import models.News;
import models.User;

import java.util.ArrayList;

public class Dbmanager {

    private static ArrayList<User> users = new ArrayList<>();

    static {

        users.add(new User(1, "abc", "123"));
        users.add(new User(2, "cbc", "123"));
        users.add(new User(3, "nbc", "123"));
    }

    public static ArrayList<User> getAllUsers() {
        return users;
    }

    public static User getByLoginPassword(String login, String password) {
        for (User user : users
        ) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public static User getUserById(int id) {
        for (User user : users
        ) {
            if (id == user.getId()) {
                return user;
            }
        }
        return null;
    }

//----------------------------------------------------------------------------------------------------------------------

    private static ArrayList<News> news = new ArrayList<>();

    static {

        news.add(new News(1, "бұл мәтін қазақ тілінде"));
        news.add(new News(2, "Этот текст на русском"));
        news.add(new News(3, "This text is in english"));
    }

    public static ArrayList<News> getAllNews() {
        return news;
    }

    public static News getById(String id) {
        for (News n : news
        ) {
            if (id.equals(String.valueOf(n.getId()))) {
                return n;
            }
        }
        return null;
    }

}
