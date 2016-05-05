package com.epl.uclouvain.uclove;

/**
 * Created by marie-marie on 5/05/16.
 */
public class Genre {
    private String login;
    private String genre;

    public Genre (String login, String genre)
    {
        this.login=login;
        this.genre=genre;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public String getLogin() {
        return login;
    }
}
