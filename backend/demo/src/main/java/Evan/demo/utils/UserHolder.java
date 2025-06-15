package Evan.demo.utils;

public class UserHolder {

    private static final ThreadLocal<Integer> userIdTL = new ThreadLocal<>();
    private static final ThreadLocal<String> usernameTL = new ThreadLocal<>();

    public static void setUserId(Integer id) {
        userIdTL.set(id);
    }

    public static Integer getUserId() {
        return userIdTL.get();
    }

    public static void setUsername(String username) {
        usernameTL.set(username);
    }

    public static String getUsername() {
        return usernameTL.get();
    }

    public static void clear() {
        usernameTL.remove();
    }
}
