package me.xdd.self.criminalintent.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import me.xdd.self.criminalintent.sqlite.CrimeDbSchema.CrimeTable;

/**
 * 1、确认目标数据库是否存在
 * 2、如果不存在，首先创建数据库，然后创建数据表并初始化数据
 * 3、如果存在，打开并确认表是否为最新
 * 4、如果是旧版本，就要先升级到最新版本
 *
 * @author xuandong on 2019/4/19.
 */
public class CrimeBaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "crimeBase.db";
    private static final String TABLE1 = "create table " +
            CrimeTable.NAME +
            "(" + " _id integer primary key autoincrement, " +
            CrimeTable.Cols.UUID + ", " +
            CrimeTable.Cols.TITLE + ", " +
            CrimeTable.Cols.DATE + ", " +
            CrimeTable.Cols.SOLVED + "," +
            CrimeTable.Cols.SUSPECT + "," +
            CrimeTable.Cols.MOBILE +
            ")";

    public CrimeBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    public CrimeBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE1);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
