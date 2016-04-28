package com.epl.uclouvain.uclove;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * La base de données. Que chacun ajoute les tables qu'il lui faut.
 */
public class DataBase extends SQLiteOpenHelper
{
    public static final String AMIS_TABLE_NAME = "Amis";
    public static final String AMIS_KEY = "id";
    public static final String AMIS_LOGIN = "login";
    public static final String AMIS_ISAMI = "isAmi";

    public static final String AMIS_TABLE_CREATE =
            "CREATE TABLE " + AMIS_TABLE_NAME + " (" +
                    AMIS_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    AMIS_LOGIN + " TEXT, " +
                    AMIS_ISAMI + " INTEGER " + ");";
    public static final String AMIS_TABLE_DROP =
            "DROP TABLE IF EXISTS " + AMIS_TABLE_NAME + ";";

    public DataBase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(AMIS_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL(AMIS_TABLE_DROP);
        onCreate(db);
    }
}
