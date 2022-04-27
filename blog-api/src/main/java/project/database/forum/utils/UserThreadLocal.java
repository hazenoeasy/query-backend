package project.database.forum.utils;

import project.database.forum.dao.pojo.User;

/**
 * @author Yuh Z
 * @date 12/10/21
 */
public class UserThreadLocal {
    public UserThreadLocal() {
    }

    private static final ThreadLocal<User> THREAD_LOCAL = new ThreadLocal<>();

    public static void put(User user){
        THREAD_LOCAL.set(user);
    }

    public static User get(){
        return THREAD_LOCAL.get();
    }
    public static void delete(){
        THREAD_LOCAL.remove();
    }
}
