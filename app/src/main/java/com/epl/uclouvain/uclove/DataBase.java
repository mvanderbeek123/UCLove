package com.epl.uclouvain.uclove;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Date;
import java.sql.Time;

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

    public static final String  CLIENT_TABLE_EX1 = " INSERT INTO " + CLIENT_TABLE_NAME +
            " (" +
            CLIENT_LOGIN + " , " + CLIENT_MDP + " , " + CLIENT_NAME + " , " + CLIENT_LASTNAME + " , " +
            CLIENT_DATE + " , " + CLIENT_GENRE + " , " + CLIENT_ETUDE + " , " + CLIENT_PLACE + " , " +
            CLIENT_NUM + " , " + CLIENT_HAIR + " , " + CLIENT_SKIN + " , " + CLIENT_EYES +
            ") VALUES ( \"Del\", \"dt\", \"Delphine\", \"DT\", \"1995-06-09\", \"Féminin\", \"EPL\" ,\"LLN\", 0485523246, \"Noir\", \"Blanc\", \"Brun\" );";

    public static final String  CLIENT_TABLE_EX2 = " INSERT INTO " + CLIENT_TABLE_NAME +
            " (" +
            CLIENT_LOGIN + " , " + CLIENT_MDP + " , " + CLIENT_NAME + " , " + CLIENT_LASTNAME + " , " +
            CLIENT_DATE + " , " + CLIENT_GENRE + " , " + CLIENT_ETUDE + " , " + CLIENT_PLACE +
            ") VALUES ( \"MM\", \"vdb\", \"Marie-Marie\", \"VDB\", \"1995-12-20\", \"Féminin\", \"EPL\" ,\"LLN\" );";

    public static final String  CLIENT_TABLE_EX3 = " INSERT INTO " + CLIENT_TABLE_NAME +
            " (" +
            CLIENT_LOGIN + " , " + CLIENT_MDP + " , " + CLIENT_NAME + " , " + CLIENT_LASTNAME + " , " +
            CLIENT_DATE + " , " + CLIENT_GENRE + " , " + CLIENT_ETUDE + " , " + CLIENT_PLACE +
            ") VALUES ( \"Step\", \"marn\", \"Stephan\", \"MARN\", \"1994-08-13\", \"Masculin\", \"EPL\" ,\"LLN\");";

    public static final String  CLIENT_TABLE_EX4 = " INSERT INTO " + CLIENT_TABLE_NAME +
            " (" +
            CLIENT_LOGIN + " , " + CLIENT_MDP + " , " + CLIENT_NAME + " , " + CLIENT_LASTNAME + " , " +
            CLIENT_DATE + " , " + CLIENT_GENRE + " , " + CLIENT_ETUDE + " , " + CLIENT_PLACE +" , " +
            CLIENT_NUM + " , " + CLIENT_HAIR + " , " + CLIENT_SKIN + " , " + CLIENT_EYES +
            ") VALUES ( \"Jul\", \"mer\", \"Julien\", \"MER\", \"1996-01-09\", \"Masculin\", \"EPL\" ,\"LLN\", 0494694892, \"Noir\", \"Blanc\", \"Vert\" );";




    // Table Genre
    public static final String GENRE_TABLE_NAME="Genre";
    public static final String GENRE_LOGIN="login";
    public static final String GENRE_GENRE="genre";
    public static final String GENRE_CREATE_TABLE= "CREATE TABLE " + GENRE_TABLE_NAME + " (" +
            GENRE_LOGIN + " TEXT NOT NULL REFERENCES CLIENT, " +
            GENRE_GENRE + " TEXT NOT NULL);";
    public static final String GENRE_DROP = "DROP TABLE IF EXISTS " + GENRE_TABLE_NAME+";";

    public static final String  GENRE_TABLE_EX1 = " INSERT INTO " + GENRE_TABLE_NAME +
            " (" +
            GENRE_LOGIN + " , " + GENRE_GENRE  +
            ") VALUES ( \"Del\", \"Masculin\");";
    public static final String  GENRE_TABLE_EX2 = " INSERT INTO " + GENRE_TABLE_NAME +
            " (" +
            GENRE_LOGIN + " , " + GENRE_GENRE  +
            ") VALUES ( \"Jul\", \"Féminin\");";

    // Table Cheveux
    public static final String CHEVEUX_TABLE_NAME="Cheveux";
    public static final String CHEVEUX_LOGIN="login";
    public static final String CHEVEUX_COLOR="couleur";
    public static final String CHEVEUX_CREATE_TABLE= "CREATE TABLE " + CHEVEUX_TABLE_NAME + " (" +
            CHEVEUX_LOGIN + " TEXT NOT NULL REFERENCES CLIENT, " +
            CHEVEUX_COLOR + " TEXT NOT NULL);";
    public static final String CHEVEUX_DROP = "DROP TABLE IF EXISTS " + CHEVEUX_TABLE_NAME+";";

    public static final String  CHEVEUX_TABLE_EX1 = " INSERT INTO " + CHEVEUX_TABLE_NAME +
            " (" +
            CHEVEUX_LOGIN + " , " + CHEVEUX_COLOR  +
            ") VALUES ( \"Del\", \"Noirs\");";
    public static final String  CHEVEUX_TABLE_EX2 = " INSERT INTO " + CHEVEUX_TABLE_NAME +
            " (" +
            CHEVEUX_LOGIN + " , " + CHEVEUX_COLOR  +
            ") VALUES ( \"Jul\", \"Bruns\");";

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
    public static final String AMIS_LOGIN1 = "login1";
    public static final String AMIS_LOGIN2 = "login2";
    public static final String AMIS_FAVORI = "isFavori";
    public static final String AMIS_ISAMI = "isAmi";
    public static final String AMIS_TABLE_CREATE = "CREATE TABLE " + AMIS_TABLE_NAME + " (" +
            AMIS_LOGIN1 + " TEXT, " +
            AMIS_LOGIN2 + " TEXT, " +
            AMIS_ISAMI + " INTEGER, " +
            AMIS_FAVORI + " INTEGER " + ");";
    public static final String AMIS_TABLE_DROP = "DROP TABLE IF EXISTS " + AMIS_TABLE_NAME + ";";

    // INSERT INTO table_name (column1,column2,column3,...)     VALUES (value1,value2,value3,...);

    public static final String  AMIS_TABLE_EX1 = " INSERT INTO " + AMIS_TABLE_NAME +
            " (" +
            AMIS_LOGIN1 + " , " + AMIS_LOGIN2 + " , " + AMIS_ISAMI + " , " + AMIS_FAVORI +
            ") VALUES ( \"Del\", \"Jul\", 1, 0);";
    public static final String  AMIS_TABLE_EX2 = " INSERT INTO " + AMIS_TABLE_NAME +
            " (" +
            AMIS_LOGIN1 + " , " + AMIS_LOGIN2 + " , " + AMIS_ISAMI + " , " + AMIS_FAVORI +
            ") VALUES ( \"Del\", \"MM\", 1 ,0);";
    public static final String  AMIS_TABLE_EX3 = " INSERT INTO " + AMIS_TABLE_NAME +
            " (" +
            AMIS_LOGIN1 + " , " + AMIS_LOGIN2 + " , " + AMIS_ISAMI + " , " + AMIS_FAVORI +
            ") VALUES ( \"Step\", \"Jul\", 1, 1);";
    public static final String  AMIS_TABLE_EX4 = " INSERT INTO " + AMIS_TABLE_NAME +
            " (" +
            AMIS_LOGIN1 + " , " + AMIS_LOGIN2 + " , " + AMIS_ISAMI + " , " + AMIS_FAVORI +
            ") VALUES ( \"MM\", \"Jul\", 0 ,0);";
    public static final String  AMIS_TABLE_EX5 = " INSERT INTO " + AMIS_TABLE_NAME +
            " (" +
            AMIS_LOGIN1 + " , " + AMIS_LOGIN2 + " , " + AMIS_ISAMI + " , " + AMIS_FAVORI +
            ") VALUES ( \"MM\", \"Step\", 1, 1);";


    // Table chatmessages
    public static final String CHAT_TABLE_NAME = "chatmsg";
    public static final String LOGIN1 = "login1";
    public static final String LOGIN2 = "login2";
    public static final String MSG = "msg";
    public static final String MSGDATE = "msgdate";

    public static final String CHAT_TABLE_CREATE = "CREATE TABLE " + CHAT_TABLE_NAME + " (" +
            LOGIN1 + " TEXT, " +
            LOGIN2 + " TEXT, " +
            MSG + " TEXT, " +
            MSGDATE + " TEXT " +");";

    public static final String CHAT_TABLE_DROP = "DROP TABLE IF EXISTS " + CHAT_TABLE_NAME + ";";

    // Table meet
    public static final String MEET_TABLE_NAME = "Meet";
    public static final String LOG1 = "login1";
    public static final String LOG2 = "login2";
    public static final String DATE = "date";
    public static final String LIEU = "lieu";
    public static final String RDV = "rdv";
    public static final String MEET_TABLE_CREATE = "CREATE TABLE " + MEET_TABLE_NAME + " (" +
            LOG1 + " TEXT, " +
            LOG2 + " TEXT, " +
            DATE + " TEXT, " +
            LIEU + " TEXT, " +
            RDV  + " INT " +");";

    public static final String MEET_TABLE_DROP = "DROP TABLE IF EXISTS " + MEET_TABLE_NAME + ";";

    public static final String  MEET_TABLE_EX1 = " INSERT INTO " + MEET_TABLE_NAME +
            " (" +
            AMIS_LOGIN1 + " , " + AMIS_LOGIN2 + " , " + DATE + " , " + LIEU + " , " + RDV +
            ") VALUES ( \"Del\", \"Jul\", \"2016-05-06\" , \"Cinescope\" , 0);";
    public static final String  MEET_TABLE_EX2 = " INSERT INTO " + MEET_TABLE_NAME +
            " (" +
            AMIS_LOGIN1 + " , " + AMIS_LOGIN2 + " , " + DATE + " , " + LIEU + " , " + RDV +
            ") VALUES ( \"Del\", \"MM\", \"2016-06-09\" , \"Genieskot\" , 0);";
    public static final String  MEET_TABLE_EX3 = " INSERT INTO " +  MEET_TABLE_NAME +
            " (" +
            AMIS_LOGIN1 + " , " + AMIS_LOGIN2 + " , " + DATE + " , " + LIEU + " , " + RDV +
            ") VALUES ( \"Step\", \"Jul\",\"2016-10-12\" , \"CI\" , 1);";
    public static final String  MEET_TABLE_EX4 = " INSERT INTO " +  MEET_TABLE_NAME +
            " (" +
            AMIS_LOGIN1 + " , " + AMIS_LOGIN2 + " , " + DATE + " , " + LIEU + " , " + RDV +
            ") VALUES ( \"MM\", \"Step\",\"2016-12-25\" , \"Bxl\" , 2);";

    //Table Photos
    public static final String PHOTO_TABLE_NAME = "Photo";
    public static final String LOGIN="login";
    public static final String PHOTO_NOM="nom";
    public static final String PHOTO_PROFIL="profil";
    public static final String PHOTO_TABLE_CREATE="CREATE TABLE " + PHOTO_TABLE_NAME + " ( " + LOGIN + " TEXT, " + PHOTO_NOM + " TEXT, " + PHOTO_PROFIL + " INTEGER);";
    public static final String PHOTO_TABLE_DROP="DROP TABLE IF EXISTS " + PHOTO_TABLE_NAME + ";";
    public DataBase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {

        db.execSQL(CLIENT_CREATE_TABLE);
        db.execSQL(CLIENT_TABLE_EX1);
        db.execSQL(CLIENT_TABLE_EX2);
        db.execSQL(CLIENT_TABLE_EX3);
        db.execSQL(CLIENT_TABLE_EX4);

        db.execSQL(AMIS_TABLE_CREATE);
        db.execSQL(AMIS_TABLE_EX1);
        db.execSQL(AMIS_TABLE_EX2);
        db.execSQL(AMIS_TABLE_EX3);
        db.execSQL(AMIS_TABLE_EX4);
        db.execSQL(AMIS_TABLE_EX5);

        db.execSQL(CHAT_TABLE_CREATE);

        db.execSQL(GENRE_CREATE_TABLE);
        db.execSQL(GENRE_TABLE_EX1);
        db.execSQL(GENRE_TABLE_EX2);

        db.execSQL(CHEVEUX_CREATE_TABLE);
        db.execSQL(CHEVEUX_TABLE_EX1);
        db.execSQL(CHEVEUX_TABLE_EX2);

        db.execSQL(YEUX_CREATE_TABLE);
        db.execSQL(PEAU_CREATE_TABLE);
        db.execSQL(ETUDE_CREATE_TABLE);
        db.execSQL(PHOTO_TABLE_CREATE);

        db.execSQL(MEET_TABLE_CREATE);
        db.execSQL(MEET_TABLE_EX1);
        db.execSQL(MEET_TABLE_EX2);
        db.execSQL(MEET_TABLE_EX3);
        db.execSQL(MEET_TABLE_EX4);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL(AMIS_TABLE_DROP);
        db.execSQL(MEET_TABLE_DROP);
        db.execSQL(CLIENT_DROP);
        db.execSQL(CHAT_TABLE_DROP);
        db.execSQL(GENRE_DROP);
        db.execSQL(CHEVEUX_DROP);
        db.execSQL(YEUX_DROP);
        db.execSQL(PEAU_DROP);
        db.execSQL(ETUDE_DROP);
        db.execSQL(PHOTO_TABLE_DROP);
        onCreate(db);
    }
}