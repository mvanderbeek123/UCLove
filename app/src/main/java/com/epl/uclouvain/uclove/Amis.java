package com.epl.uclouvain.uclove;

/**
 * Une classe qui représente la table "Amis" de la DataBase.
 */
public class Amis
{
    private long id;
    private String login;
    private int isAmi;
    private int isFavori; // 1 si favori, 0 sinon.

    public Amis(long id, String login, int isAmi, int isFavori)
    {
        super();
        this.id = id;
        this.login = login;
        this.isAmi = isAmi;
        this.isFavori = isFavori;
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

    public int getIsFavori()
    {
        return isFavori;
    }

    public void setIsFavori(int isFavori)
    {
        this.isFavori = isFavori;
    }
}
