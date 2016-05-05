package com.epl.uclouvain.uclove;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import java.util.ArrayList;

/**
 * La classe DAO pour la table Amis de la DataBase.
 */
public class AmisDAO extends DAOBase
{
    public static final String TABLE_NAME = "Amis";
    public static final String LOGIN1 = "login1";
    public static final String LOGIN2 = "login2";
    public static final String ISAMI = "isAmi";
    public static final String ISFAVORI = "isFavori";

    public AmisDAO(Context pContext)
    {
       super(pContext);
    }

    public void ajouter(Amis a)
    {
        ContentValues value = new ContentValues();
        value.put(AmisDAO.LOGIN1, a.getLogin1());
        value.put(AmisDAO.LOGIN2, a.getLogin2());
        value.put(AmisDAO.ISAMI, a.getIsAmi());
        value.put(AmisDAO.ISFAVORI, a.getIsFavori());
        mDb.insert(AmisDAO.TABLE_NAME, null, value);
    }

    public void supprimer(String login1, String login2)
    {
        mDb.delete(TABLE_NAME, " login1 = ?" + " AND login2 = ?", new String[] {login1, login2});
    }

    public void ajouter_favori(String login1, String login2)
    {
        ContentValues value = new ContentValues();
        value.put(ISFAVORI, 1);
        mDb.update(TABLE_NAME, value, " login1 = ?" + " AND login2 = ?", new String[] {login1, login2});
    }

    public void supprimer_favori(String login1, String login2)
    {
        ContentValues value = new ContentValues();
        value.put(ISFAVORI, 0);
        mDb.update(TABLE_NAME, value, " login1 = ?" + " AND login2 = ?", new String[] {login1, login2});
    }

    public Amis selectionner_ami(String login1, String login2)
    {
        String requete = "select login1, login2, isFavori " +
                " from " + TABLE_NAME +
                " where (login1 = \"" + login1 + "\" and login2 = \"" + login2 + "\")"+
                " or (login1 = \"" + login2 + "\" and login2 = \"" + login1 + "\")"+
                " and (isAmi = 1);" ;
        Cursor c = mDb.rawQuery(requete, new String[]{});
        int isFavori = c.getInt(2);
        Amis a = new Amis(login1, login2, 1, isFavori);
        c.close();
        return a;
    }

    public ArrayList<Amis> selectionner_listAmis(String login_user)
    {
        String requete = "select login1, login2, isFavori " +
                " from " + DataBase.AMIS_TABLE_NAME +
                " where (login1 = \"" + login_user + "\" or login2 = \"" + login_user + "\")"+
                " and   (isAmi = 1);" ;
        Cursor c = mDb.rawQuery(requete, new String[]{});

        ArrayList<Amis> liste = new ArrayList<Amis>();
        while (c.moveToNext())
        {
            String login1 = c.getString(0); ;
            String login2 = c.getString(1);
            int isFavori = c.getInt(2);
            Amis a = new Amis(login1 , login2, 1, isFavori);
            liste.add(a);
        }
        c.close();
        return liste;
    }

}
