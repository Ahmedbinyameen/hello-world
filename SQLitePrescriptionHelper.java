package com.example.bluecloudmedicalclinic.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by HP on 12/24/2019.
 */

public class SQLitePrescriptionHelper  extends  SQLiteOpenHelper{

    private static  final String DATABASE_NAME= "Bluecloud.db";

//    private static  final String DATABASE_NAME= "Bluecloud_medical.db";

    private static  final String TABLE_NAME= "New_Prescription_Table";

    private static final String COLUMN_ID = "id";

    private static  final String COLUMN_MEDICATION = "medication";

    private static  final String COLUMN_DOSAGE = "dosage";

    private static  final String COLUMN_INSTRUCTION = "instruction";

    private static final String COLUMN_PRESCRIPTION = "prescription";

    public SQLitePrescriptionHelper(Context context) {

        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME +"("
                + COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_MEDICATION + "TEXT,"
                + COLUMN_DOSAGE + "VARCHAR,"
                + COLUMN_INSTRUCTION + "VARCHAR,"
                + COLUMN_PRESCRIPTION + "VARCHAR" +")";

        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
