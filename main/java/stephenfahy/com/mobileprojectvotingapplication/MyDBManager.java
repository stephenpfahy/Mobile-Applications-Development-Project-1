package stephenfahy.com.mobileprojectvotingapplication;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

public class MyDBManager {

    //names of rows in the table of the Database
    public static final String KEY_ROWID = "_id";
    public static final String KEY_AGE = "age";
    public static final String KEY_GENDER = "gender";
    public static final String KEY_VOTE = "vote";
    public static final String KEY_POLITICAL_PARTY = "politicalParty";
    public static final String KEY_INCOME_EARNED = "incomeEarned";
    public static final String KEY_AREA = "area";
    public static final String KEY_DOES_USER_HAVE_CHILDREN = "doesUserHaveChildren";
    public static final String KEY_MARRIED = "married";
    public static final String KEY_CANDIDATE = "candidate";
    public static final String KEY_TAOISEACH_CANDIDATE = "taoiseachCandidate";


    private static final String DATABASE_NAME = "Voter_Poll";//database name
    private static final String DATABASE_TABLE = "Voter_Details";//Table Name
    private static final int DATABASE_VERSION = 1;

    //Create database method and make the ID row the PRIMARY KEY and all other records NOT NULL;
    private static final String DATABASE_CREATE = "create table Voter_Details " +
            "(_id integer primary key autoincrement, " +
            "age text not null, " + "gender text not null, " + "vote text not null, " + "politicalParty text not null, " +
            "incomeEarned text not null, " + "area text not null, " + "doesUserHaveChildren text not null, " +
            "married text not null, " + "candidate text not null, " + "taoiseachCandidate text not null);";

    private final Context context;

    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;

    //
    public MyDBManager(Context ctx) {
        //
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {

        //
        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME,
                    null, DATABASE_VERSION);
        }


        @Override
        //
        public void onCreate(SQLiteDatabase db) {

            db.execSQL(DATABASE_CREATE);
        }

        @Override

        //
        public void onUpgrade(SQLiteDatabase db, int oldVersion,
                              int newVersion) {
            // whatever is to be changed on dB structure

        }
    }

    public MyDBManager open() throws SQLException {
        db = DBHelper.getWritableDatabase();
        return this;
    }

    //
    public void close() {
        DBHelper.close();
    }

    //insert the information entered by people in the poll
    public long insertVoter(String age, String gender, String vote, String politicalParty, String incomeEarned,
                            String area, String doesUserHaveChildren, String married, String candidate,
                            String taoiseachCandidate) {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_AGE, age);
        initialValues.put(KEY_GENDER, gender);
        initialValues.put(KEY_VOTE, vote);
        initialValues.put(KEY_POLITICAL_PARTY, politicalParty);
        initialValues.put(KEY_INCOME_EARNED, incomeEarned);
        initialValues.put(KEY_AREA, area);
        initialValues.put(KEY_DOES_USER_HAVE_CHILDREN, doesUserHaveChildren);
        initialValues.put(KEY_MARRIED, married);
        initialValues.put(KEY_CANDIDATE, candidate);
        initialValues.put(KEY_TAOISEACH_CANDIDATE, taoiseachCandidate);

        return db.insert(DATABASE_TABLE, null, initialValues);
    }

    public boolean deleteTask(long rowId) {
        //
        return db.delete(DATABASE_TABLE, KEY_ROWID +
                "=" + rowId, null) > 0;
    }


    public Cursor getAllVotingInformation() {
        return db.query(DATABASE_TABLE, new String[]{
                        KEY_ROWID,
                        KEY_AGE,
                        KEY_GENDER,
                        KEY_VOTE,
                        KEY_POLITICAL_PARTY,
                        KEY_INCOME_EARNED,
                        KEY_AREA,
                        KEY_DOES_USER_HAVE_CHILDREN,
                        KEY_MARRIED,
                        KEY_CANDIDATE,
                        KEY_TAOISEACH_CANDIDATE,

                },
                null,
                null,
                null,
                null,
                null);
    }

    public Cursor getTask(long rowId) throws SQLException {
        Cursor mCursor =
                db.query(true, DATABASE_TABLE, new String[]{
                                KEY_ROWID,
                                KEY_AGE,
                                KEY_GENDER,
                                KEY_VOTE,
                                KEY_POLITICAL_PARTY,
                                KEY_INCOME_EARNED,
                                KEY_AREA,
                                KEY_DOES_USER_HAVE_CHILDREN,
                                KEY_MARRIED,
                                KEY_CANDIDATE,
                                KEY_TAOISEACH_CANDIDATE
                        },
                        KEY_ROWID + "=" + rowId,
                        null,
                        null,
                        null,
                        null,
                        null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }


    public boolean updateTask(long rowId, String age,
                              int gender, String vote, String politicalParty, String incomeEarned, String area,
                              String doesUserHaveChildren, String married, String db_candidate, String db_taoiseachCandidate) {
        ContentValues args = new ContentValues();
        args.put(KEY_AGE, age);
        args.put(KEY_GENDER, gender);
        args.put(KEY_VOTE, vote);
        args.put(KEY_POLITICAL_PARTY, politicalParty);
        args.put(KEY_INCOME_EARNED, incomeEarned);
        args.put(KEY_AREA, area);
        args.put(KEY_DOES_USER_HAVE_CHILDREN, doesUserHaveChildren);
        args.put(KEY_MARRIED, married);
        args.put(KEY_CANDIDATE, db_candidate);
        args.put(KEY_TAOISEACH_CANDIDATE, db_taoiseachCandidate);
        return db.update(DATABASE_TABLE, args,
                KEY_ROWID + "=" + rowId, null) > 0;
    }

    public Cursor getAgeAndPoliticalParty(String age, String politicalParty) throws SQLException {
        Cursor mCursor =
                db.query(true, DATABASE_TABLE, new String[]{
                                KEY_ROWID,
                                KEY_AGE,
                                KEY_GENDER,
                                KEY_VOTE,
                                KEY_POLITICAL_PARTY,
                                KEY_INCOME_EARNED,
                                KEY_AREA,
                                KEY_DOES_USER_HAVE_CHILDREN,
                                KEY_MARRIED,
                                KEY_CANDIDATE,
                                KEY_TAOISEACH_CANDIDATE,

                        },
                        KEY_AGE + "=\"" + age + "\"" + " AND " + KEY_POLITICAL_PARTY + "=\"" + politicalParty + "\"",

                        null,
                        null,
                        null,
                        null,
                        null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }


    public Cursor getGenderAreaIncome(String gender, String area, String incomeEarned) throws SQLException {
        Cursor mCursor =
                db.query(true, DATABASE_TABLE, new String[]{
                                KEY_ROWID,
                                KEY_AGE,
                                KEY_GENDER,
                                KEY_VOTE,
                                KEY_POLITICAL_PARTY,
                                KEY_INCOME_EARNED,
                                KEY_AREA,
                                KEY_DOES_USER_HAVE_CHILDREN,
                                KEY_MARRIED,
                                KEY_CANDIDATE,
                                KEY_TAOISEACH_CANDIDATE,

                        },
                        KEY_GENDER + "=\"" + gender + "\"" + " AND " + KEY_AREA + "=\"" + area + "\"" + " AND " + KEY_INCOME_EARNED + "=\"" + incomeEarned + "\"",

                        null,
                        null,
                        null,
                        null,
                        null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }


    public Cursor getGenderAndIncomeEarned(String gender, String incomeEarned) throws SQLException {
        Cursor mCursor =
                db.query(true, DATABASE_TABLE, new String[]{
                                KEY_ROWID,
                                KEY_AGE,
                                KEY_GENDER,
                                KEY_VOTE,
                                KEY_POLITICAL_PARTY,
                                KEY_INCOME_EARNED,
                                KEY_AREA,
                                KEY_DOES_USER_HAVE_CHILDREN,
                                KEY_MARRIED,
                                KEY_CANDIDATE,
                                KEY_TAOISEACH_CANDIDATE,

                        },
                        KEY_GENDER + "=\"" + gender + "\"" + " AND  " + KEY_INCOME_EARNED + "=\"" + incomeEarned + "\"",

                        null,
                        null,
                        null,
                        null,
                        null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    public Cursor getIncomeEarnedAndArea(String incomeEarned, String area) throws SQLException {
        Cursor mCursor =
                db.query(true, DATABASE_TABLE, new String[]{
                                KEY_ROWID,
                                KEY_AGE,
                                KEY_GENDER,
                                KEY_VOTE,
                                KEY_POLITICAL_PARTY,
                                KEY_INCOME_EARNED,
                                KEY_AREA,
                                KEY_DOES_USER_HAVE_CHILDREN,
                                KEY_MARRIED,
                                KEY_CANDIDATE,
                                KEY_TAOISEACH_CANDIDATE,

                        },
                        KEY_INCOME_EARNED + "=\"" + incomeEarned + "\"" + " AND  " + KEY_AREA + "=\"" + area + "\"",

                        null,
                        null,
                        null,
                        null,
                        null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    public Cursor getGender(String gender) throws SQLException {
        Cursor mCursor =
                db.query(true, DATABASE_TABLE, new String[]{
                                KEY_ROWID,
                                KEY_AGE,
                                KEY_GENDER,
                                KEY_VOTE,
                                KEY_POLITICAL_PARTY,
                                KEY_INCOME_EARNED,
                                KEY_AREA,
                                KEY_DOES_USER_HAVE_CHILDREN,
                                KEY_MARRIED,
                                KEY_CANDIDATE,
                                KEY_TAOISEACH_CANDIDATE,

                        },
                        KEY_GENDER + "=\"" + gender + "\"",

                        null,
                        null,
                        null,
                        null,
                        null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    public Cursor getGenderAndArea(String gender, String area) throws SQLException {
        Cursor mCursor =
                db.query(true, DATABASE_TABLE, new String[]{
                                KEY_ROWID,
                                KEY_AGE,
                                KEY_GENDER,
                                KEY_VOTE,
                                KEY_POLITICAL_PARTY,
                                KEY_INCOME_EARNED,
                                KEY_AREA,
                                KEY_DOES_USER_HAVE_CHILDREN,
                                KEY_MARRIED,
                                KEY_CANDIDATE,
                                KEY_TAOISEACH_CANDIDATE,

                        },
                        KEY_GENDER + "=\"" + gender + "\"" + " AND  " + KEY_AREA + "=\"" + area + "\"",

                        null,
                        null,
                        null,
                        null,
                        null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    public Cursor getIncomeEarned(String incomeEarned) throws SQLException {
        Cursor mCursor =
                db.query(true, DATABASE_TABLE, new String[]{
                                KEY_ROWID,
                                KEY_AGE,
                                KEY_GENDER,
                                KEY_VOTE,
                                KEY_POLITICAL_PARTY,
                                KEY_INCOME_EARNED,
                                KEY_AREA,
                                KEY_DOES_USER_HAVE_CHILDREN,
                                KEY_MARRIED,
                                KEY_CANDIDATE,
                                KEY_TAOISEACH_CANDIDATE,

                        },
                        KEY_INCOME_EARNED + "=\"" + incomeEarned + "\"",

                        null,
                        null,
                        null,
                        null,
                        null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    public Cursor getArea(String area) throws SQLException {
        Cursor mCursor =
                db.query(true, DATABASE_TABLE, new String[]{
                                KEY_ROWID,
                                KEY_AGE,
                                KEY_GENDER,
                                KEY_VOTE,
                                KEY_POLITICAL_PARTY,
                                KEY_INCOME_EARNED,
                                KEY_AREA,
                                KEY_DOES_USER_HAVE_CHILDREN,
                                KEY_MARRIED,
                                KEY_CANDIDATE,
                                KEY_TAOISEACH_CANDIDATE,

                        },
                        KEY_AREA + "=\"" + area + "\"",

                        null,
                        null,
                        null,
                        null,
                        null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }


}


