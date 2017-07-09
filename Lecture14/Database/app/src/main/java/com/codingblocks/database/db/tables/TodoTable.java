package com.codingblocks.database.db.tables;

/**
 * Created by championswimmer on 09/07/17.
 */
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import static com.codingblocks.database.db.DbUtils.*;

public class TodoTable {

    public static final String TABLE_NAME = "todos";

    interface Columns {
        String COL_ID = "id";
        String COL_TASK = "task";
    }

    public static final String CMD_CREATE_TABLE =
            CREATE_TABLE +
                    TABLE_NAME +
                    LBR +
                    Columns.COL_ID + TYPE_INTEGER_PK_AI + COMMA +
                    Columns.COL_TASK + TYPE_TEXT +
                    RBR + SEMI;

    public static final String UPGRADE_TABLE_1_2 =
            "ALTER TABLE todos ADD COLUMN done BOOLEAN DEFAULT;" +
                    "UPDATE todos SET done 0 WHERE 1;";


    public static ArrayList<String> getTodos (SQLiteDatabase db) {
        Log.d(TABLE_NAME, "getTodos: ");
        Cursor c = db.query(
                TABLE_NAME,
                new String[]{Columns.COL_TASK},
                null, //"WHERE id = 1 AND done = false",
                null,
                null,
                null,
                null
        );

        ArrayList<String> todos = new ArrayList<>();
        int taskColIndex = c.getColumnIndex(Columns.COL_TASK);
        while (c.moveToNext()) {
            todos.add(c.getString(taskColIndex));
        }

        return todos;
    }

    public static void addTodo (SQLiteDatabase db, String todo) {
        Log.d(TABLE_NAME, "addTodo: ");
        ContentValues todoToInsert = new ContentValues();

        todoToInsert.put(Columns.COL_TASK, todo);

        long id = db.insert(TABLE_NAME, null, todoToInsert);
        Log.d(TABLE_NAME, "addTodo: " + id);
    }

}
