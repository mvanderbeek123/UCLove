package com.epl.uclouvain.uclove;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

/**
 * Created by marie-marie on 5/05/16.
 */
public class GenreDAO extends DAOBase {
    public static final String GENRE_TABLE_NAME="Genre";
    public static final String GENRE_LOGIN="login";
    public static final String GENRE_GENRE="genre";

    public GenreDAO(Context pContext)
    {
        super(pContext);
    }

    public void ajouter(Genre a)
    {
        ContentValues value = new ContentValues();
        value.put(GenreDAO.GENRE_LOGIN, a.getLogin());
        value.put(GenreDAO.GENRE_GENRE, a.getGenre());
        mDb.insert(GenreDAO.GENRE_TABLE_NAME, null, value);
    }

    public void supprimer(Genre a)
    {
        mDb.delete(GENRE_TABLE_NAME, GENRE_LOGIN + " = ? AND " + GENRE_GENRE + " = ?", new String[]{a.getLogin(), a.getGenre()});
    }

    public void modifier(Genre a, String nouvelleVal)
    {
        ContentValues value = new ContentValues();
        value.put(GENRE_GENRE, nouvelleVal);
        mDb.update(GENRE_TABLE_NAME, value, GENRE_LOGIN + " = ? AND " + GENRE_GENRE + " = ?", new String[]{a.getLogin(), a.getGenre()});
    }
    public ArrayList<Genre> selectionner(String login) {
        Cursor c = mDb.rawQuery("SELECT * FROM " + GENRE_TABLE_NAME + "WHERE " + GENRE_LOGIN + " = ?", new String[]{login});
        c.moveToFirst();
        ArrayList<Genre> liste = new ArrayList<Genre>();
        while (c.moveToNext()) {
            String login1 = c.getString(0);
            ;
            String genre = c.getString(1);
            Genre a = new Genre(login1, genre);
            liste.add(a);
        }
        c.close();
        return liste;
    }
}
