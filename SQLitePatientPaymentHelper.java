package com.example.bluecloudmedicalclinic.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by HP on 12/25/2019.
 */


public class SQLitePatientPaymentHelper extends SQLiteOpenHelper {

    private static  final String DATABASE_NAME= "Bluecloud.db";

//    private static  final String DATABASE_NAME= "Bluecloud_medical.db";

    private static  final String TABLE_NAME_PatientPayment= "New_Patient_Table";

    public static final String COLUMN_ID = "id";

    public static  final String COLUMN_FIRST_NAME = "first_name";

    public static  final String COLUMN_LAST_NAME = "last_name";

    public static  final String COLUMN_ZIP = "zip";

    public static  final String COLUMN_LOCATION = "location";

   public static  final String COLUMN_AMOUNT = "amount";

    public static final String COLUMN_CARD_NUMBER = "card_number";

    public static final String COLUMN_CARD_EXP ="card_expiry_date";

    public static final String COLUMN_CARD_HOLDER_NAME ="card_holder_name";

    public static  final String COLUMN_EMAIL = "email";

    private static final String COLUMN_CARD = "card";

    private static final String COLUMN_CHECK = "check";

    private static final String COLUMN_CASH = "cash";


    public SQLitePatientPaymentHelper(Context context) {

        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {

        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME_PatientPayment + "("
                + COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_FIRST_NAME + "TEXT,"
                + COLUMN_LAST_NAME + "TEXT,"
                + COLUMN_ZIP + "VARCHAR,"
                + COLUMN_LOCATION + "VARCHAR,"
                + COLUMN_AMOUNT + "VARCHAR,"
                + COLUMN_CARD_NUMBER + "VARCHAR,"
                + COLUMN_CARD_EXP + "VARCHAR,"
                + COLUMN_CARD_HOLDER_NAME + "VARCHAR,"
                + COLUMN_EMAIL + "VARCHAR" +  ")";
//                + COLUMN_CARD + "VARCHAR,"
//                + COLUMN_CHECK + "VARCHAR,"
//                 + COLUMN_CASH + "VARCHAR" + ")";





//        + COLUMN_CARD + "VARCHAR," +
//                COLUMN_CHECK + "VARCHAR," + COLUMN_CASH + "VARCHAR)";
        db.execSQL(CREATE_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {


        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_PatientPayment);
        onCreate(db);

    }


    public Cursor check_duplicates_in_user_credentials(String user_name, String table) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = null;
        if (table.equals(TABLE_NAME_PatientPayment)) {
            res = db.rawQuery("select * from " + TABLE_NAME_PatientPayment + " where email=? ", new String[]{user_name});
        }
        return res;
    }

    public boolean createPDF(String email )
    {


        String[] columns =
                {
                    COLUMN_EMAIL, COLUMN_FIRST_NAME, COLUMN_LAST_NAME, COLUMN_ZIP, COLUMN_AMOUNT, COLUMN_CARD,
                        COLUMN_CARD_EXP, COLUMN_CARD
                };

        SQLiteDatabase db = this.getReadableDatabase();

        String  selection = COLUMN_EMAIL + "=?";

        String[] selectionArgs = {email};

        Cursor cursor = db.query(TABLE_NAME_PatientPayment,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);

        int cursorCount = cursor.getCount();
        cursor.close();

        return cursorCount > 0;
    }


//    private SQLiteDatabase db = getReadableDatabase();
//    SQLiteDatabase db = this.getReadableDatabase();

//    public Cursor search(String searchString)
//    {
//
//        String[] columns = new String[]{ COLUMN_FIRST_NAME, COLUMN_LAST_NAME, COLUMN_ZIP, COLUMN_LOCATION, COLUMN_AMOUNT,
//        COLUMN_CARD, COLUMN_CARD_EXP, COLUMN_CARD_HOLDER_NAME, COLUMN_EMAIL};
//        String where = COLUMN_EMAIL + " LIKE ?";
//        searchString  = "%" + searchString + "%";
//        String[] whereArgs = new String[]{searchString};
//
//        Cursor cursor = null;
//
//        try {
//            if(db == null)
//            {
//                db = getReadableDatabase();
//
//            }
//
//            cursor = db.query(TABLE_NAME_PatientPayment, columns, where, whereArgs, null, null, null);
//        }
//        catch (Exception ex)
//        {
//
//        }
//        return  cursor;
//    }



    public Cursor getData(String email)
    {


        String[] columns = {"first_name" , "last_name", "zip", "location", "amount", "card_number", "card_expiry_date", "card_holder_name", "email"};

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor getData = db.query("New_Patient_Table", columns, "email=?", new  String[]{ email }, null, null, null);

        return getData;


    }

}
