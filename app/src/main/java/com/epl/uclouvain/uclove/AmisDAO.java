package com.epl.uclouvain.uclove;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

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
        mDb.insert(AmisDAO.TABLE_NAME, null, value);


    }

    public void supprimer(long id)
    {
        mDb.delete(TABLE_NAME, KEY + " = ?", new String[] {String.valueOf(id)});
    }

    public void modifier(Amis a)
    {
        // Méthode qui sert à rien on l'utilisera jamais en pratique.
    }

    public Amis selectionner(long id)
    {
        Cursor c = mDb.rawQuery("select " + LOGIN + " from " + TABLE_NAME + " id = ? ", new String[] {String.valueOf(id)});
        long id2 = c.getLong(0);
        String login = c.getString(1);
        int isAmi = c.getInt(2);
        int isFavori = c.getInt(3);
        Amis a = new Amis(id2, login, isAmi, isFavori);
        return a;
    }
}
