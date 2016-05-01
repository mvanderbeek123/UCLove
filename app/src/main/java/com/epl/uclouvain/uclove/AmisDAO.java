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
    public static final String LOGIN = "login";
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
        value.put(AmisDAO.LOGIN, a.getLogin());
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
        Cursor c = mDb.rawQuery("select " + LOGIN + " from " + TABLE_NAME + " where id = ?", new String[]{String.valueOf(id)});
        String login = c.getString(1);
        int isAmi = c.getInt(2);
        int isFavori = c.getInt(3);
        Amis a = new Amis(id, login, isAmi, isFavori);
        c.close();
        return a;
    }

    public ArrayList<Amis> selectionner_siAmi(int isAmi)
    {
        Cursor c = mDb.rawQuery("select " + LOGIN + " from " + TABLE_NAME + " where isAmi = ?", new String[]{"1"});
        ArrayList<Amis> liste = new ArrayList<Amis>();
        while (c.moveToNext())
        {
            long id2 = c.getLong(0);
            String login = c.getString(1);
            int isFavori = c.getInt(3);
            Amis a = new Amis(id2, login, isAmi, isFavori);
            liste.add(a);
        }
        c.close();
        return liste;
    }
}
