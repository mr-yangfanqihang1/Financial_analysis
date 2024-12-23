package buptworker.entity;

public class User_pairs {
    String user_left;
    String user_right;

    public User_pairs(String user_left, String user_right) {
        this.user_left = user_left;
        this.user_right = user_right;
    }

    public String getUser_left() {
        return user_left;
    }

    public void setUser_left(String user_left) {
        this.user_left = user_left;
    }

    public String getUser_right() {
        return user_right;
    }

    public void setUser_right(String user_right) {
        this.user_right = user_right;
    }

    @Override
    public String toString() {
        return "user_pairs{" +
                "user_left=" + user_left +
                ", user_right=" + user_right +
                '}';
    }
}
