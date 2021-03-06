package me.xdd.self.criminalintent.sqlite;

import android.database.Cursor;
import android.database.CursorWrapper;

import java.util.Date;
import java.util.UUID;

import me.xdd.self.criminalintent.model.Crime;

/**
 * @author xuandong on 2019/4/24.
 */
public class CrimeCursorWrapper extends CursorWrapper {
    /**
     * Creates a cursor wrapper.
     *
     * @param cursor The underlying cursor to wrap.
     */
    public CrimeCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Crime getCrime(){
        String uuidString  = getString(getColumnIndex(CrimeDbSchema.CrimeTable.Cols.UUID));
        String title = getString(getColumnIndex(CrimeDbSchema.CrimeTable.Cols.TITLE));
        long date = getLong(getColumnIndex(CrimeDbSchema.CrimeTable.Cols.DATE));
        int isSolved = getInt(getColumnIndex(CrimeDbSchema.CrimeTable.Cols.SOLVED));
        String suspect = getString(getColumnIndex(CrimeDbSchema.CrimeTable.Cols.SUSPECT));
        String mobile = getString(getColumnIndex(CrimeDbSchema.CrimeTable.Cols.MOBILE));
        Crime crime = new Crime(UUID.fromString(uuidString));
        crime.setTitle(title);
        crime.setDate(new Date(date));
        crime.setSolved(isSolved != 0);
        crime.setSuspect(suspect);
        crime.setMobile(mobile);
        return crime;
    }
}
