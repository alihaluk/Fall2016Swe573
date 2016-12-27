package tr.edu.boun.healthtracker.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import tr.edu.boun.healthtracker.model.inner.ExerciseObject;
import tr.edu.boun.healthtracker.model.inner.UserObject;

/**
 * Created by haluks on 15/12/2016.
 */

public class DB
{
    public static final int DATABASE_VERSION = 1;
    public static String DATABASE_NAME = "HTdb";
    public static Context ctx;
    public SQLiteDatabase database;

    public DB(Context context) {
        ctx = context;
    }

    public void beginTransaction() {
        database.beginTransaction();
    }

    public void Commit() {
        database.setTransactionSuccessful();
    }

    public void endTransaction() {
        database.endTransaction();
    }

    public Boolean isOpen() {
        return (database != null && database.isOpen());
    }

    public void openDB() {
        try {
            if (database != null) {
                if (database.isOpen()) {
                    return;
                }
            }

            database = (new DBOpenHelper(ctx)).getWritableDatabase();
        } catch (Exception Ex) {
            Log.d("", Ex.getMessage());
        }
    }

    public void closeDB() {
        if (database != null && database.isOpen())
            database.close();
    }

    //

    public static final String TABLE_USER = "tblUser";
    public static final String USER_ID = "ID";
    public static final String USER_EMAIL = "Email";
    public static final String USER_USERNAME = "Username";
    public static final String USER_PASSWORD = "Password";
    public static final String USER_GENDER = "Gender";
    public static final String USER_AGE = "Age";
    public static final String USER_HEIGHT = "Height";
    public static final String USER_WEIGHT = "Weight";
    public static final String USER_BMI = "Bmi";
    public static final String USER_CAL_GOAL = "CalorieGoal";
    public static final String USER_ACTIVE = "Active";

    public static final String TABLE_CREATE_USER = "CREATE TABLE " + TABLE_USER
            + " ("
            + USER_ID + " INTEGER PRIMARY KEY,"
            + USER_EMAIL + " STRING,"
            + USER_USERNAME + " TEXT,"
            + USER_PASSWORD + " TEXT,"
            + USER_GENDER + " STRING,"
            + USER_AGE + " INTEGER,"
            + USER_HEIGHT + " DOUBLE,"
            + USER_WEIGHT + " DOUBLE,"
            + USER_BMI + " DOUBLE,"
            + USER_CAL_GOAL + " INTEGER,"
            + USER_ACTIVE + " INTEGER"
            + ");";

    public boolean doesExistsUser(String user_email) {
        Cursor c = database.rawQuery("SELECT " + USER_ID + " FROM "
                + TABLE_USER + " WHERE Email = '" + user_email + "';", null);
        if (c.getCount() > 0) {
            c.close();
            return true;
        } else {
            c.close();
            return false;
        }
    }

    public boolean isUserValid(String user_email, String user_pass) {
        Cursor c = database.rawQuery("SELECT " + USER_ID + " FROM "
                + TABLE_USER + " WHERE Email = '" + user_email + "' AND Password = '" + user_pass + "';", null);
        if (c.getCount() > 0) {
            c.close();
            return true;
        } else {
            c.close();
            return false;
        }
    }

    public void insertUser(UserObject tUser) {
        ContentValues values = new ContentValues();
        values.put(USER_EMAIL, tUser.getEmail());
        values.put(USER_USERNAME, tUser.getUsername());
        values.put(USER_PASSWORD, tUser.getPassword());
        values.put(USER_GENDER, tUser.getGender());
        values.put(USER_AGE, tUser.getAge());
        values.put(USER_HEIGHT, tUser.getHeight());
        values.put(USER_WEIGHT, tUser.getWeight());
        values.put(USER_BMI, tUser.getBmi());
        values.put(USER_CAL_GOAL, tUser.getCalGoal());
        values.put(USER_ACTIVE, tUser.getActive());

        database.insert(TABLE_USER, null, values);
    }

    public void updateUser(UserObject tUser) {
        ContentValues values = new ContentValues();
        values.put(USER_EMAIL, tUser.getEmail());
        values.put(USER_USERNAME, tUser.getUsername());
        values.put(USER_PASSWORD, tUser.getPassword());
        values.put(USER_GENDER, tUser.getGender());
        values.put(USER_AGE, tUser.getAge());
        values.put(USER_HEIGHT, tUser.getHeight());
        values.put(USER_WEIGHT, tUser.getWeight());
        values.put(USER_BMI, tUser.getBmi());
        values.put(USER_CAL_GOAL, tUser.getCalGoal());
        values.put(USER_ACTIVE, tUser.getActive());

        database.update(TABLE_USER, values, "Id = " + tUser.getId().toString(), null);
    }

    public UserObject getActiveUser() {

        UserObject user = null;

        String sql = "SELECT "
                + USER_ID
                + "," + USER_EMAIL
                + "," + USER_USERNAME
                + "," + USER_PASSWORD
                + "," + USER_GENDER
                + "," + USER_AGE
                + "," + USER_HEIGHT
                + "," + USER_WEIGHT
                + "," + USER_BMI
                + "," + USER_CAL_GOAL
                + "," + USER_ACTIVE
                + " FROM " + TABLE_USER + " WHERE " + USER_ACTIVE + " = 1";
        Cursor cursor = database.rawQuery(sql, null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0)
        {
            user = new UserObject();
            user.setId(cursor.getInt(0));
            user.setEmail(cursor.getString(1));
            user.setUsername(cursor.getString(2));
            user.setPassword(cursor.getString(3));
            user.setGender(cursor.getString(4));
            user.setAge(cursor.getInt(5));
            user.setHeight(cursor.getDouble(6));
            user.setWeight(cursor.getDouble(7));
            user.setBmi(cursor.getDouble(8));
            user.setCalGoal(cursor.getInt(9));
            user.setActive(cursor.getInt(10) == 1);
        }

        cursor.close();
        return user;
    }

    public void setActiveUserWithMail(String email)
    {
        database.execSQL("UPDATE " + TABLE_USER + " SET " + USER_ACTIVE + " = 0");
        database.execSQL("UPDATE " + TABLE_USER + " SET " + USER_ACTIVE + " = 1 WHERE " + USER_EMAIL + " = '" + email + "'");
    }


    /*
        This values are for 60 mins.
     */
    public static final String TABLE_EXERCISE_CAL_BURNED = "tblExerciseCalBurned";
    public static final String ECB_EXERCISE_NAME = "Name";
    public static final String ECB_CAL_VALUE_PER_KG = "CalValuePerKG";
    public static final String TABLE_CREATE_EXERCISE_CAL_BURNED = "CREATE TABLE " + TABLE_EXERCISE_CAL_BURNED
            + " ("
            + ECB_EXERCISE_NAME + " TEXT,"
            + ECB_CAL_VALUE_PER_KG + " DOUBLE"
            + ");";

    public List<ExerciseObject> getCalculatedExerciseListWithMass (Double mass_value){
        Cursor c = database.rawQuery("SELECT " + ECB_EXERCISE_NAME
                + ", " + mass_value + " * " + ECB_CAL_VALUE_PER_KG + " FROM "
                + TABLE_EXERCISE_CAL_BURNED + ";", null);

        List<ExerciseObject> retList = new ArrayList<>();
        if (c.getCount() > 0) {
            c.moveToFirst();
            while (!c.isAfterLast()) {
                ExerciseObject ex = new ExerciseObject();
                ex.setName(c.getString(0));
                ex.setCalorie(c.getDouble(1));
                retList.add(ex);

                c.moveToNext();
            }
        }
        c.close();
        return retList;
    }
}
