package com.example.supermarket;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
public class SupermarketDataSource {
    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;

    public SupermarketDataSource(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public boolean insertRatings(float liquor, float produce, float meat, float cheese, float checkout) {
        boolean didSucceed = false;
        try {
            ContentValues initialValues = new ContentValues();

            initialValues.put("liquor", liquor);
            initialValues.put("produce", produce);
            initialValues.put("meat", meat);
            initialValues.put("cheese", cheese);
            initialValues.put("checkout", checkout);

            didSucceed = database.insert("ratings", null, initialValues) > 0;
        } catch (Exception e) {
            // Handle the exception (e.g., log it)
        }
        return didSucceed;
    }
}
