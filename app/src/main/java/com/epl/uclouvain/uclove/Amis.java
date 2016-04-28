package com.epl.uclouvain.uclove;

/**
 * Une classe qui représente la table "Amis" de la DataBase.
 */
public class Amis
{
    private long id;
    private String login;
    private int isAmi ;

    public Amis(long id, String login, int isAmi)
    {
        super();
        this.id = id;
        this.login = login;
        this.isAmi = isAmi;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getLogin()
    {
        return login;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    public float getIsAmi()
    {
        return isAmi;
    }

    public void setIsAmi(int isAmi)
    {
        this.isAmi = isAmi;
    }

}
