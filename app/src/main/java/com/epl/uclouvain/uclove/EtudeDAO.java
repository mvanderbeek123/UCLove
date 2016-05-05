package com.epl.uclouvain.uclove;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

/**
 * Created by marie-marie on 5/05/16.
 */
public class EtudeDAO extends DAOBase {

    public static final String ETUDE_TABLE_NAME="Etude";
    public static final String ETUDE_LOGIN="login";
    public static final String ETUDE="faculte";

    public EtudeDAO(Context pContext)
    {
        super(pContext);
    }

    public void ajouter(Etude a)
    {
        ContentValues value = new ContentValues();
        value.put(ETUDE_LOGIN, a.getLogin());
        value.put(ETUDE, a.getFaculte());
        mDb.insert(ETUDE_TABLE_NAME, null, value);
    }

    public void supprimer(Etude a)
    {
        mDb.delete(ETUDE_TABLE_NAME, ETUDE_LOGIN + " = ? AND " + ETUDE + " = ?", new String[]{a.getLogin(), a.getFaculte()});
    }

    public void modifier(Etude a, String nouvelleVal)
    {
        ContentValues value = new ContentValues();
        value.put(ETUDE, nouvelleVal);
        mDb.update(ETUDE_TABLE_NAME, value, ETUDE_LOGIN + " = ? AND " + ETUDE + " = ?", new String[]{a.getLogin(), a.getFaculte()});
    }
    public ArrayList<Etude> selectionner(String login)
    {
        Cursor c = mDb.rawQuery("SELECT * FROM " + ETUDE_TABLE_NAME + "WHERE " + ETUDE_LOGIN + " = ?" , new String[]{login});
        c.moveToFirst();
        ArrayList<Etude> liste = new ArrayList<Etude>();
        while (c.moveToNext())
        {
            String login1 = c.getString(0); ;
            String faculte = c.getString(1);
            Etude a = new Etude(login1 , faculte);
            liste.add(a);
        }
        c.close();
        return liste;
    }
}
