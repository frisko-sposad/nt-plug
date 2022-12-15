package ntplug.ntplug.controller;

public class UserPost {
    private String login;
    private String date;

    public UserPost(String login, String date) {
        this.login = login;
        this.date = date;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
