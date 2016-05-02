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
    public static final String KEY = "id";
    public static final String LOGIN1 = "login1";
    public static final String LOGIN2 = "login2";
    public static final String ISAMI = "isAmi";
    public static final String ISFAVORI = "isFavori";

    /* public static final String AMIS_TABLE_CREATE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    LOGIN + " TEXT, " +
                    ISAMI + " INTEGER " +
                    ISFAVORI + " INT " + ");";
    public static final String AMIS_TABLE_DROP =
            "DROP TABLE IF EXISTS " + TABLE_NAME + ";"; */

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

    public void supprimer(long id)
    {
        mDb.delete(TABLE_NAME, KEY + " = ?", new String[] {String.valueOf(id)});
    }

    public void ajouter_favori(long id)
    {
        ContentValues value = new ContentValues();
        value.put(ISFAVORI, 1);
        mDb.update(TABLE_NAME, value, KEY  + " = ?", new String[] {String.valueOf(id)});
    }

    public void supprimer_favori(long id)
    {
        ContentValues value = new ContentValues();
        value.put(ISFAVORI, 0);
        mDb.update(TABLE_NAME, value, KEY  + " = ?", new String[] {String.valueOf(id)});
    }

    public Amis selectionner_parID(long id)
    {
        /* Cursor c = mDb.rawQuery("select " + LOGIN2 + " from " + TABLE_NAME + " where login1 = ? AND id = ? ", new String[]{login_global, String.valueOf(id)});
        String login1 = c.getString(1);
        String login2 = c.getString(2);
        int isAmi = c.getInt(3);
        int isFavori = c.getInt(4);
        Amis a = new Amis(id, login1, login2, isAmi, isFavori);
        c.close();
        return a; */
        return null;
    }

    public ArrayList<Amis> selectionner_siAmi(int isAmi)
    {
        /* Cursor c = mDb.rawQuery("select " + LOGIN2 + " from " + TABLE_NAME + " where login1 = ? AND isAmi = ?", new String[]{login_global,"1"});
        ArrayList<Amis> liste = new ArrayList<Amis>();
        while (c.moveToNext())
        {
            long id2 = c.getLong(0);
            String login1 = c.getString(1);
            String login2 = c.getString(2);
            int isFavori = c.getInt(4);
            Amis a = new Amis(id2, login1, login2, isAmi, isFavori);
            liste.add(a);
        }
        c.close();
        return liste; */
        return null;
    }
}
