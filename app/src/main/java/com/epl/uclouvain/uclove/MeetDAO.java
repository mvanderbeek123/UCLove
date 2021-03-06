package com.epl.uclouvain.uclove;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

/**
 * Classe DAO pour la table MEET de la database
 * Created by noe on 04/05/16.
 */
  public class MeetDAO extends DAOBase {

    public static final String TABLE_NAME = "Meet";
    public static final String LOGIN1 = "login1";
    public static final String LOGIN2 = "login2";
    public static final String DATE = "date";
    public static final String LIEU = "lieu";
    public static final String RDV = "rdv";

    public MeetDAO(Context pContext)
    {
        super(pContext);
    }

    public void ajouter(Meet m)
    {
        ContentValues value = new ContentValues();
        value.put(MeetDAO.LOGIN1, m.getLogin1());
        value.put(MeetDAO.LOGIN2, m.getLogin2());
        value.put(MeetDAO.DATE, m.getDate());
        value.put(MeetDAO.LIEU, m.getLieu());
        value.put(MeetDAO.RDV, m.getConfirmed());
        mDb.insert(MeetDAO.TABLE_NAME, null, value);
    }

    public ArrayList<Meet> historique(String l1, String l2)
    {
        String requete = "select login1, login2, date, lieu" +
                " from " + DataBase.MEET_TABLE_NAME +
                " where (login1 = \"" + l1 + "\" or login1 = \"" + l2 + "\")"+
                " and   (login2 = \"" + l1 + "\" or login2 = \"" + l2 + "\");"+
                " and rdv=1";

        Cursor c = mDb.rawQuery(requete, new String[]{});

        ArrayList<Meet> liste = new ArrayList<Meet>();
        while (c.moveToNext())
        {
            Meet m=new Meet("","","","",1);

            m.setLogin1(c.getString(0));
            m.setLogin2(c.getString(1));
            m.setDate(c.getString(2));
            m.setLieu(c.getString(3));
            liste.add(m);
        }
        c.close();
        return liste;
    }

    public ArrayList<Meet> selectionner_listProp(String login_user)
    {
        String requete = "select login1, login2, date, lieu " +
                " from " + DataBase.MEET_TABLE_NAME +
                " where (login2 = \"" + login_user + "\")" +
                " and   (rdv = 0);" ;
        Cursor c = mDb.rawQuery(requete, new String[]{});

        ArrayList<Meet> liste = new ArrayList<Meet>();
        while (c.moveToNext())
        {
            String log1 = c.getString(0); ;
            String log2 = c.getString(1);
            String date=c.getString(2);
            String lieu=c.getString(3);
            Meet m = new Meet(log1,log2,date,lieu,0);
            liste.add(m);
        }
        c.close();
        return liste;

    }



    public void modif_prop_oui(String login1, String login2)
    {
        ContentValues value = new ContentValues();
        value.put(RDV, 1);
        mDb.update(TABLE_NAME, value, " login1 = ?" + " AND login2 = ?", new String[] {login1, login2});
    }

    public void modif_prop_non(String login1, String login2)
    {
        ContentValues value = new ContentValues();
        value.put(RDV, 2);
        mDb.update(TABLE_NAME, value, " login1 = ?" + " AND login2 = ?", new String[] {login1, login2});
    }




}
