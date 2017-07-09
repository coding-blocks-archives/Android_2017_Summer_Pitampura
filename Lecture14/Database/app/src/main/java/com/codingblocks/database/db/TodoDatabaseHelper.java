package com.codingblocks.database.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.codingblocks.database.db.tables.TodoTable;

/**
 * Created by championswimmer on 09/07/17.
 */

public class TodoDatabaseHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "todo.db";
    public static final int DB_VER = 2;

    public TodoDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TodoTable.CMD_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVer, int newVer) {

        if (oldVer == 1 && newVer == 2) {
            sqLiteDatabase.execSQL(TodoTable.UPGRADE_TABLE_1_2);
        }
        if (oldVer == 2 && newVer == 3) {

        }
    }
}
