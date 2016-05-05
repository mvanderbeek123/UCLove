package com.epl.uclouvain.uclove;

/**
 * Created by marie-marie on 5/05/16.
 */
public class Etude {
    private String login;
    private String faculte;

    public Etude (String login,String faculte)
    {
        this.login=login;
        this.faculte=faculte;
    }
    public String getLogin() {
        return login;
    }

    public String getFaculte() {
        return faculte;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setFaculte(String faculte) {
        this.faculte = faculte;
    }
}
