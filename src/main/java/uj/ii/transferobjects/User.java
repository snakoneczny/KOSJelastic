package uj.ii.transferobjects;

public class User {

    private String login;
    private String passMD5;

    public User() {
    }

    public User(String login, String passMD5) {
        this.login = login;
        this.passMD5 = passMD5;
    }
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassMD5() {
        return passMD5;
    }

    public void setPassMD5(String passMD5) {
        this.passMD5 = passMD5;
    }
}
