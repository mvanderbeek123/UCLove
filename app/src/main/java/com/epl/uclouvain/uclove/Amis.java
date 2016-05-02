package com.epl.uclouvain.uclove;

/**
 * Une classe qui représente la table "Amis" de la DataBase.
 */
public class Amis
{
    private long id;
    private String login1;
    private String login2;
    private int isAmi;
    private int isFavori; // 1 si favori, 0 sinon.

    public Amis(long id, String login1, String login2, int isAmi, int isFavori)
    {
        super();
        this.id = id;
        this.login1 = login1;
        this.login2 = login2;
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

    public String getLogin1()
    {
        return login1;
    }

    public void setLogin1(String login1)
    {
        this.login1 = login1;
    }

    public String getLogin2()
    {
        return login2;
    }

    public void setLogin2(String login2)
    {
        this.login2 = login2;
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
