package com.anila.telu.proyek4_jmp_a_anila.helper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

import com.anila.telu.proyek4_jmp_a_anila.model.Person;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "digitaltalent.db";

    public DBHelper(@Nullable Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String SQL_CREATE_TABLE = "CREATE TABLE data_person (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nama TEXT NOT NULL, " +
                "alamat TEXT NOT NULL)";
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1){
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS data_person");
        onCreate(sqLiteDatabase);
    }

    public void insert (String nama, String alamat) {
        SQLiteDatabase database = this.getWritableDatabase();
        String queryValues = "INSERT INTO data_person(nama, alamat)" +
                "VALUES ('" + nama + "', '" + alamat + "')";

        database.execSQL(queryValues);
        database.close();
    }

    public ArrayList<Person> getAllData() {
        ArrayList<Person> persons = new ArrayList<>();

        SQLiteDatabase database = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM data_person";
        Cursor cursor = database.rawQuery(selectQuery, null);
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String nama = cursor.getString(1);
            String alamat = cursor.getString(2);
            persons.add(new Person(id, nama, alamat));
        }
        database.close();
        return persons;
    }

    public void delete(int id){
        SQLiteDatabase database = this.getReadableDatabase();
        String deleteQuery = "DELETE FROM data_person WHERE id = "+id;
        database.execSQL(deleteQuery);
        database.close();
    }
}
