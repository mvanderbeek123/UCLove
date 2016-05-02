package com.epl.uclouvain.uclove;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

/**
 * La classe DAO pour la table Amis de la DataBase.
 */
public class ChatDAO extends DAOBase
{
    public ChatDAO(Context pContext)
    {
       super(pContext);
    }

    public void ajouter(ChatMessage c)
    {
        ContentValues value = new ContentValues();
        value.put(DataBase.LOGIN1, c.login1);
        value.put(DataBase.LOGIN2, c.login2);
        value.put(DataBase.MSG, c.msg);
        value.put(DataBase.MSGDATE, c.msg_date);
        mDb.insert(DataBase.CHAT_TABLE_NAME, null, value);
    }


    public ArrayList<ChatMessage> historique(String l1, String l2)
    {
        Cursor c = mDb.rawQuery("select login1, login2, msg, msg_date" +
                " from " + DataBase.CHAT_TABLE_NAME +
                " where (login1 = " + l1 + " or login1 = " + l2 + ")"+
                " and   (login2 = " + l1 + " or login2 = " + l2 + ");" , new String[]{});

        ArrayList<ChatMessage> liste = new ArrayList<ChatMessage>();
        while (c.moveToNext())
        {
            ChatMessage cm = new ChatMessage();

            cm.login1 = c.getString(0);
            cm.login2 = c.getString(1);
            cm.msg = c.getString(2);
            cm.msg_date = c.getString(3);
            liste.add(cm);
        }
        c.close();
        return liste;
    }
}
