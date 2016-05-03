package com.epl.uclouvain.uclove;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * La base de données.
 */
public class DataBase extends SQLiteOpenHelper
{
    // Table Client
    public static final String CLIENT_TABLE_NAME="Client";
    public static final String CLIENT_LOGIN="login";
    public static final String CLIENT_MDP="mot_de_passe";
    public static final String CLIENT_NAME="prenom";
    public static final String CLIENT_LASTNAME="nom";
    public static final String CLIENT_DATE="date_de_naissance";
    public static final String CLIENT_GENRE="genre";
    public static final String CLIENT_ETUDE="etude";
    public static final String CLIENT_PLACE="localisation";
    public static final String CLIENT_NUM="numero_de_telephone";
    public static final String CLIENT_HAIR="cheveux";
    public static final String CLIENT_EYES="yeux";
    public static final String CLIENT_SKIN="peau";
    public static final String CLIENT_CREATE_TABLE = "CREATE TABLE " + CLIENT_TABLE_NAME + " (" +
            CLIENT_LOGIN + " TEXT NOT NULL PRIMARY KEY, " +
            CLIENT_MDP  + " TEXT NOT NULL, " +
            CLIENT_NAME + " TEXT NOT NULL, " +
            CLIENT_LASTNAME + " TEXT NOT NULL, " +
            CLIENT_DATE + " TEXT NOT NULL, " +
            CLIENT_GENRE + " TEXT NOT NULL, " +
            CLIENT_ETUDE + " TEXT NOT NULL, "+
            CLIENT_PLACE + " TEXT NOT NULL, " +
            CLIENT_NUM + " INTEGER ," +
            CLIENT_HAIR + " TEXT, " +
            CLIENT_SKIN + " TEXT, " +
            CLIENT_EYES + " TEXT " + ");";
    public static final String CLIENT_DROP =
            "DROP TABLE IF EXISTS " + CLIENT_TABLE_NAME + ";";

    // Table Genre
    public static final String GENRE_TABLE_NAME="Genre";
    public static final String GENRE_LOGIN="login";
    public static final String GENRE_GENRE="genre";
    public static final String GENRE_CREATE_TABLE= "CREATE TABLE " + GENRE_TABLE_NAME + " (" +
            GENRE_LOGIN + " TEXT NOT NULL REFERENCES CLIENT, " +
            GENRE_GENRE + " TEXT NOT NULL);";
    public static final String GENRE_DROP = "DROP TABLE IF EXISTS " + GENRE_TABLE_NAME+";";

    // Table Cheveux
    public static final String CHEVEUX_TABLE_NAME="Cheveux";
    public static final String CHEVEUX_LOGIN="login";
    public static final String CHEVEUX_COLOR="couleur";
    public static final String CHEVEUX_CREATE_TABLE= "CREATE TABLE " + CHEVEUX_TABLE_NAME + " (" +
            CHEVEUX_LOGIN + " TEXT NOT NULL REFERENCES CLIENT, " +
            CHEVEUX_COLOR + " TEXT NOT NULL);";
    public static final String CHEVEUX_DROP = "DROP TABLE IF EXISTS " + CHEVEUX_TABLE_NAME+";";

    // Table yeux
    public static final String YEUX_TABLE_NAME="Yeux";
    public static final String YEUX_LOGIN="login";
    public static final String YEUX_COLOR="couleur";
    public static final String YEUX_CREATE_TABLE= "CREATE TABLE " + YEUX_TABLE_NAME + "(" +
            YEUX_LOGIN + " TEXT NOT NULL REFERENCES CLIENT, " +
            YEUX_COLOR + " TEXT NOT NULL);";
    public static final String YEUX_DROP = "DROP TABLE IF EXISTS " + YEUX_TABLE_NAME+";";

    // Table Peau
    public static final String PEAU_TABLE_NAME="Peau";
    public static final String PEAU_LOGIN="login";
    public static final String PEAU_COLOR="couleur";
    public static final String PEAU_CREATE_TABLE= "CREATE TABLE " + PEAU_TABLE_NAME + "(" +
            PEAU_LOGIN + " TEXT NOT NULL REFERENCES CLIENT, " +
            PEAU_COLOR + " TEXT NOT NULL);";
    public static final String PEAU_DROP = "DROP TABLE IF EXISTS " + PEAU_TABLE_NAME+";";

    // Table Etude
    public static final String ETUDE_TABLE_NAME="Etude";
    public static final String ETUDE_LOGIN="login";
    public static final String ETUDE="faculte";
    public static final String ETUDE_CREATE_TABLE= "CREATE TABLE " + ETUDE_TABLE_NAME + " (" +
            ETUDE_LOGIN + " TEXT NOT NULL REFERENCES CLIENT, " +
            ETUDE + " TEXT NOT NULL);";
    public static final String ETUDE_DROP = "DROP TABLE IF EXISTS " + ETUDE_TABLE_NAME+";";

    // Table amis.
    public static final String AMIS_TABLE_NAME = "Amis";
    public static final String AMIS_KEY = "id";
    public static final String AMIS_LOGIN = "login";
    public static final String AMIS_ISAMI = "isAmi";
    public static final String AMIS_TABLE_CREATE = "CREATE TABLE " + AMIS_TABLE_NAME + " (" +
            AMIS_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            AMIS_LOGIN + " TEXT, " +
            AMIS_ISAMI + " INTEGER " + ");";
    public static final String AMIS_TABLE_DROP = "DROP TABLE IF EXISTS " + AMIS_TABLE_NAME + ";";

    // Table chatmessages
    public static final String CHAT_TABLE_NAME = "messages";
    public static final String LOGIN1 = "login1";
    public static final String LOGIN2 = "login2";
    public static final String MSG = "msg";
    public static final String MSGDATE = "msg_date";
    public static final String CHAT_CREATE_TABLE = "CREATE TABLE " + CHAT_TABLE_NAME + " (" +
            LOGIN1 + " TEXT, " +
            LOGIN2 + " TEXT, " +
            MSG + " TEXT " +
            MSGDATE + " TEXT " +");";
    public static final String CHAT_TABLE_DROP = "DROP TABLE IF EXISTS " + CHAT_TABLE_NAME + ";";


    public DataBase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(AMIS_TABLE_CREATE);
        db.execSQL(CLIENT_CREATE_TABLE);
        db.execSQL(CHAT_CREATE_TABLE);
        db.execSQL(GENRE_CREATE_TABLE);
        db.execSQL(CHEVEUX_CREATE_TABLE);
        db.execSQL(YEUX_CREATE_TABLE);
        db.execSQL(PEAU_CREATE_TABLE);
        db.execSQL(ETUDE_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL(AMIS_TABLE_DROP);
        db.execSQL(CLIENT_DROP);
        db.execSQL(CHAT_TABLE_DROP);
        db.execSQL(GENRE_DROP);
        db.execSQL(CHEVEUX_DROP);
        db.execSQL(YEUX_DROP);
        db.execSQL(PEAU_DROP);
        db.execSQL(ETUDE_DROP);
        onCreate(db);
    }

    // Autres tables. A ajouter en suivant le même schéma que j'ai fait pour la table Amis.
}
