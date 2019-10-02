package com.example.noteios;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;
import android.widget.Toast;

import static android.provider.ContactsContract.CommonDataKinds.Note.NOTE;

public class SQLite extends SQLiteOpenHelper {

//    long numberOfRows = DatabaseUtils.queryNumEntries(db, "NOTE");
    public int count=0;



    public SQLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }


    //2 dạng truy vấn :
    // không trả kết quả : CREATE, ...
        public void QueryData(String sql){
            SQLiteDatabase db = getWritableDatabase();
            db.execSQL(sql);
        }

    //TRẢ KẾT QUẢ : SELECT
    public Cursor GetData(String sql){ // chuyển con trỏ tới vị trí SQL
        SQLiteDatabase db = getWritableDatabase(); // có thể dùng getWrite vừa đọc vừa ghi
        return db.rawQuery(sql, null);
    }

    //Thêm Ghi chú ...
    public void Insert(long id, String time, String text , byte[] image) {
        Log.v("insert","notnull");
        SQLiteDatabase db = getWritableDatabase();
        String sql = "INSERT INTO NOTE VALUES (?, ?, ?, ?)";
        SQLiteStatement statement = db.compileStatement(sql);
        statement.clearBindings();
//        statement.bindLong(0,id);
        statement.bindLong(1, id);
        statement.bindString(2, time);
        statement.bindString(3, text);
        statement.bindBlob(4, image);
        statement.executeInsert();
    }

    public  void InsertNull(int id, String time, String text, byte[] image ){
        Log.v("insert","null");
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO NOTE (Id, Time, Text, Image ) VALUES (?, ?, ?, ?)",
                new String[]{String.valueOf(id), time, text, image+ ""});
    }

    public void UpdateNull (int id, String time, String text ){
        Log.v("update","null");
        SQLiteDatabase db = getWritableDatabase(); // có thể dùng getWrite vừa đọc vừa ghi
        db.execSQL("UPDATE NOTE SET Id = ?, Time = ?, Image = null WHERE Id = ?", new String[]{-1 + "", time, id + ""});
        Cursor cursor = db.rawQuery("SELECT MAX (Id) FROM NOTE", null);
        cursor.moveToFirst();
        int max = cursor.getInt(0);
        if (id < max) {
            for (long i = id + 1; i <= max; i++) { // vì xóa nên max giảm 1, nên để <=
                db.execSQL("UPDATE NOTE SET Id = ? WHERE Id = ?",
                        new String[]{i - 1 + "", i + ""});
            }
            db.execSQL("UPDATE NOTE SET Id = ? WHERE Id = ?",
                    new String[]{max + "", -1 + ""});
        }
        else {
            db.execSQL("UPDATE NOTE SET Id = ? WHERE Id = ?",
                    new String[]{max + 1 + "", -1 + ""});
        }
    }

    public void Update (long id, String time ,String text , byte[] image) {
        Log.v("update","notnull");
        SQLiteDatabase db = getWritableDatabase();
        String sql = "UPDATE NOTE SET Id = ?, Time = ?, Text = ? , Image = ? WHERE Id = ?";
        SQLiteStatement statement = db.compileStatement(sql);
        statement.clearBindings();
        statement.bindLong(1, -1);
        statement.bindString(2, time);
        statement.bindString(3, text);
        statement.bindBlob(4, image);
        statement.bindLong(5, id);
        statement.executeUpdateDelete();
        Cursor cursor = db.rawQuery("SELECT MAX (Id) FROM NOTE", null);
        cursor.moveToFirst();
        int max = cursor.getInt(0);
        if (id < max) {
            for (long i = id + 1; i <= max; i++) { // vì xóa nên max giảm 1, nên để <=
                db.execSQL("UPDATE NOTE SET Id = ? WHERE Id = ?",
                        new String[]{i - 1 + "", i + ""});
            }
            db.execSQL("UPDATE NOTE SET Id = ? WHERE Id = ?",
                    new String[]{max + "", -1 + ""});
        }
        else {
            db.execSQL("UPDATE NOTE SET Id = ? WHERE Id = ?",
                    new String[]{max + 1 + "", -1 + ""});
        }
    }

    public void Delete (long id, Context context){
        SQLiteDatabase db = getWritableDatabase();
        String sql = "DELETE FROM NOTE WHERE Id = ?";
        SQLiteStatement statement = db.compileStatement(sql);
        statement.clearBindings();
        statement.bindLong(1,id);
        statement.executeUpdateDelete();
        Cursor cursor = db.rawQuery("SELECT MAX (Id) FROM NOTE", null);
        cursor.moveToFirst();
        int max = cursor.getInt(0);
        if(id < max){
            for (long i =id +1; i <= max; i ++){ // vì xóa nên max giảm 1, nên để <=
                db.execSQL("UPDATE NOTE SET Id = ? WHERE Id = ?",
                        new String[]{i-1 + "", i + ""});
            }
        }
    }

//    public void UpdateId(int Idafter, int Idbefore ) {
//        SQLiteDatabase db = getWritableDatabase();
//        db.execSQL("UPDATE NOTE SET Id = ? WHERE Id = ?",
//                new String[]{Idafter + "", Idbefore + ""});
//    }

    //ĐẾM TỔNG SỐ GHI CHÚ
    public int count () {
        String countQuery = "SELECT * FROM NOTE " ;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(countQuery, null);

        if (cursor != null) {
            count = cursor.getCount();
            cursor.close();
        }
        return count;
    }

//    public int count(){
//        SQLiteDatabase db = getWritableDatabase();
//        Cursor cursor = db.rawQuery("SELECT MAX (Id) FROM NOTE", null);
//        if (cursor !=null){
//            cursor.moveToFirst();
//            int max = cursor.getInt(0);
//            return max;
//        }
//        else return 0;
//    }

    public void DeleteAndUpdate(int id){
        SQLiteDatabase db = getWritableDatabase(); // có thể dùng getWrite vừa đọc vừa ghi
        String sql = "DELETE FROM NOTE WHERE Id = ?";
        SQLiteStatement statement = db.compileStatement(sql);
        statement.clearBindings();
        statement.bindLong(1,id);
        statement.executeUpdateDelete();

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

}
