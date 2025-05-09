package com.training.login_app.database_helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class database_helper extends SQLiteOpenHelper {

    private static final String DATABASE_MAIN = "studentProfile.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "students";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_COURSE = "course";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PHONE = "phone";

    private static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NAME + " TEXT, " +
                    COLUMN_COURSE + " TEXT, " +
                    COLUMN_EMAIL + " TEXT, " +
                    COLUMN_PHONE + " TEXT" +
                    ");";

    public database_helper(Context context) {
        super(context, DATABASE_MAIN, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertStudent(String name, String course, String email, String phone) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_COURSE, course);
        values.put(COLUMN_EMAIL, email);
        values.put(COLUMN_PHONE, phone);

        long result = db.insert(TABLE_NAME, null, values);
        return result != -1; //Return true if insertion is successful
    }

    public boolean updateStudent(int id, String name, String course, String email, String phone) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_COURSE, course);
        values.put(COLUMN_EMAIL, email);
        values.put(COLUMN_PHONE, phone);

        int rowUpdated = db.update(TABLE_NAME, values, COLUMN_ID + "=?", new String[]{String.valueOf(id)});
        return rowUpdated > 0; //Return true if update is successful
    }

    public boolean deleteStudent(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        int rowDeleted = db.delete(TABLE_NAME, COLUMN_ID + "=?", new String[]{String.valueOf(id)});
        return rowDeleted > 0; //Return true if deletion is successful
    }

    public Cursor getStudent(String studentID)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM students WHERE id=?", new String[]{studentID});
        return cursor;
    }
    public Cursor getStudent()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM "+TABLE_NAME+" LIMIT 1", null);

    }
}