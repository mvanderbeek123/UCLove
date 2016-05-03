package com.epl.uclouvain.uclove;

import android.content.Context;

/**
 * Classe DAO pour la table MEET de la database
 * Created by noe on 04/05/16.
 */
public class MeetDAO extends DAOBase {

    public static final String LOGIN = "login"; //voir si on travaille par login ou par id
    public static final String DATE = "Date";
    public static final String HOUR = "Heure";

    public MeetDAO(Context pContext)
    {
        super(pContext);
    }


}
