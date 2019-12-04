package com.example.noteios;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

public class SQLite extends SQLiteOpenHelper {

//    long numberOfRows = DatabaseUtils.queryNumEntries(db, "NOTE");
    private int count=0;



    SQLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }


    //2 dạng truy vấn :
    // không trả kết quả : CREATE, ...
    void QueryData(String sql){
            SQLiteDatabase db = getWritableDatabase();
            db.execSQL(sql);
        }

    //TRẢ KẾT QUẢ : SELECT
    Cursor GetData(String sql){ // chuyển con trỏ tới vị trí SQL
        SQLiteDatabase db = getWritableDatabase(); // có thể dùng getWrite vừa đọc vừa ghi
        return db.rawQuery(sql, null);
    }

    //Thêm Ghi chú ...
//    public void Insert(long id, String time, String text , byte[] image) {
//        SQLiteDatabase db = getWritableDatabase();
//
//        if(image!=null){
//            String sql = "INSERT INTO NOTE VALUES (?, ?, ?, ?)";
//            SQLiteStatement statement = db.compileStatement(sql);
//            statement.clearBindings();
//            //        statement.bindLong(0,id);
//            statement.bindLong(1, id);
//            statement.bindString(2, time);
//            statement.bindString(3, text);
//            statement.bindBlob(4, image);
//            statement.executeInsert();
//        }
//        else{
//            String sql = "INSERT INTO NOTE VALUES (?, ?, ?, ?)";
//            SQLiteStatement statement = db.compileStatement(sql);
//            statement.clearBindings();
//            //        statement.bindLong(0,id);
//            statement.bindLong(1, id);
//            statement.bindString(2, time);
//            statement.bindString(3, text);
//            statement.bindNull(4);
//            statement.executeInsert();
//        }
//
//    }

    private void Insert(long id, String time, String text , byte[] image0, String text0, byte[] image1, String text1, byte[] image2, String text2, byte[] image3, String text3, byte[] image4, String text4, byte[] image5, String text5, byte[] image6, String text6, byte[] image7, String text7, byte[] image8, String text8, byte[] image9, String text9, byte[] image10, String text10) {
        SQLiteDatabase db = getWritableDatabase();
        String sql = "INSERT INTO NOTE VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        SQLiteStatement statement = db.compileStatement(sql);
        statement.clearBindings();
        statement.bindLong(1, id);
        statement.bindString(2, time);
        statement.bindString(3, text);
        if(image0!=null){
            statement.bindBlob(4, image0);
            statement.bindString(5, text0);
        }
        else {
            statement.bindNull(4);
            statement.bindNull(5);
        }

        if(image1!=null){
            statement.bindBlob(6, image1);
            statement.bindString(7, text1);
        }
        else {
            statement.bindNull(6);
            statement.bindNull(7);
        }

        if(image2!=null){
            statement.bindBlob(8, image2);
            statement.bindString(9, text2);
        }
        else {
            statement.bindNull(8);
            statement.bindNull(9);
        }

        if(image3!=null){
            statement.bindBlob(10, image3);
            statement.bindString(11, text3);
        }
        else {
            statement.bindNull(10);
            statement.bindNull(11);
        }

        if(image4!=null){
            statement.bindBlob(12, image4);
            statement.bindString(13, text4);
        }
        else {
            statement.bindNull(12);
            statement.bindNull(13);
        }

        if(image5!=null){
            statement.bindBlob(14, image5);
            statement.bindString(15, text5);
        }
        else {
            statement.bindNull(14);
            statement.bindNull(15);
        }

        if(image6!=null){
            statement.bindBlob(16, image6);
            statement.bindString(17, text6);
        }
        else {
            statement.bindNull(16);
            statement.bindNull(17);
        }

        if(image7!=null){
            statement.bindBlob(18, image7);
            statement.bindString(19, text7);
        }
        else {
            statement.bindNull(18);
            statement.bindNull(19);
        }

        if(image8!=null){
            statement.bindBlob(20, image8);
            statement.bindString(21, text8);
        }
        else {
            statement.bindNull(20);
            statement.bindNull(21);
        }

        if(image9!=null){
            statement.bindBlob(22, image9);
            statement.bindString(23, text9);
        }
        else {
            statement.bindNull(22);
            statement.bindNull(23);
        }

        if(image10!=null){
            statement.bindBlob(24, image10);
            statement.bindString(25, text10);
        }
        else {
            statement.bindNull(24);
            statement.bindNull(25);
        }

        statement.executeInsert();

    }

//    public  void InsertNull(int id, String time, String text, byte[] image ){
//        Log.v("insert","null");
//        SQLiteDatabase db = getWritableDatabase();
//        db.execSQL("INSERT INTO NOTE (Id, Time, Text, Image ) VALUES (?, ?, ?, ?)",
//                new String[]{String.valueOf(id), time, text, image.toString()});
//    }

//    public void UpdateNull (long id, String time, String text ){
//        Log.v("update123","null");
//        SQLiteDatabase db = getWritableDatabase();
//        String sql = "UPDATE NOTE SET Id = ?, Time = ?, Text = ? , Image = null WHERE Id = ?";
//        SQLiteStatement statement = db.compileStatement(sql);
//        statement.clearBindings();
//        statement.bindLong(1, -1);
//        statement.bindString(2, time);
//        statement.bindString(3, text);
//        statement.bindLong(4, id);
//        statement.executeUpdateDelete();
//        Cursor cursor = db.rawQuery("SELECT MAX (Id) FROM NOTE", null);
//        cursor.moveToFirst();
//        int max = cursor.getInt(0);
//        if (id < max) {
//            for (long i = id + 1; i <= max; i++) { // vì xóa nên max giảm 1, nên để <=
//                db.execSQL("UPDATE NOTE SET Id = ? WHERE Id = ?",
//                        new String[]{i - 1 + "", i + ""});
//            }
//            db.execSQL("UPDATE NOTE SET Id = ? WHERE Id = ?",
//                    new String[]{max + "", -1 + ""});
//        }
//        else {
//            db.execSQL("UPDATE NOTE SET Id = ? WHERE Id = ?",
//                    new String[]{max + 1 + "", -1 + ""});
//        }
//    }

//    public void Update (long id, String time ,String text , byte[] image) {
//        SQLiteDatabase db = getWritableDatabase();
//        if(image!=null){
//            String sql = "UPDATE NOTE SET Id = ?, Time = ?, Text = ? , Image = ? WHERE Id = ?";
//            SQLiteStatement statement = db.compileStatement(sql);
//            statement.clearBindings();
//            statement.bindLong(1, -1);
//            statement.bindString(2, time);
//            statement.bindString(3, text);
//            statement.bindBlob(4, image);
//            statement.bindLong(5, id);
//            statement.executeUpdateDelete();
//
//        }
//        else {
//            db.execSQL("UPDATE NOTE SET Id = ?, Time = ?, Text = ? , Image = ? WHERE Id = ?",
//                    new String[]{String.valueOf(-1), time, text, null, String.valueOf(id)});
//        }
//
//        Cursor cursor = db.rawQuery("SELECT MAX (Id) FROM NOTE", null);
//        cursor.moveToFirst();
//        int max = cursor.getInt(0);
//        if (id < max) {
//            for (long i = id + 1; i <= max; i++) { // vì xóa nên max giảm 1, nên để <=
//                db.execSQL("UPDATE NOTE SET Id = ? WHERE Id = ?",
//                        new String[]{i - 1 + "", i + ""});
//            }
//            db.execSQL("UPDATE NOTE SET Id = ? WHERE Id = ?",
//                    new String[]{max + "", -1 + ""});
//        }
//        else {
//            db.execSQL("UPDATE NOTE SET Id = ? WHERE Id = ?",
//                    new String[]{max + 1 + "", -1 + ""});
//        }
//    }


    private void Update (long id, String time, String text , byte[] image0, String text0, byte[] image1, String text1, byte[] image2, String text2, byte[] image3, String text3, byte[] image4, String text4, byte[] image5, String text5, byte[] image6, String text6, byte[] image7, String text7, byte[] image8, String text8, byte[] image9, String text9, byte[] image10, String text10) {
        SQLiteDatabase db = getWritableDatabase();
        String sql = "UPDATE NOTE SET Id = ?, Time = ?, Text = ?, Image0 = ?, Text0 =?, Image1 = ?, Text1 =?, Image2 = ?, Text2 =?, Image3 = ?, Text3 =?, Image4 = ?, Text4 =?, Image5 = ?, Text5 =?, Image6 = ?, Text6 =?, Image7 = ?, Text7 =?, Image8 = ?, Text8 =?, Image9 = ?, Text9 =?, Image10 = ?, Text10 =? WHERE Id = ?";
        SQLiteStatement statement = db.compileStatement(sql);
        statement.clearBindings();
        statement.bindLong(1, id);
        statement.bindString(2, time);
        statement.bindString(3, text);

        // tối ưu hóa code bằng đồng quy được
        if(image0!=null){
            statement.bindBlob(4, image0);
            statement.bindString(5, text0);
        }
        else {
            statement.bindNull(4);
            statement.bindNull(5);
        }

        if(image1!=null){
            statement.bindBlob(6, image1);
            statement.bindString(7, text1);
        }
        else {
            statement.bindNull(6);
            statement.bindNull(7);
        }

        if(image2!=null){
            statement.bindBlob(8, image2);
            statement.bindString(9, text2);
        }
        else {
            statement.bindNull(8);
            statement.bindNull(9);
        }

        if(image3!=null){
            statement.bindBlob(10, image3);
            statement.bindString(11, text3);
        }
        else {
            statement.bindNull(10);
            statement.bindNull(11);
        }

        if(image4!=null){
            statement.bindBlob(12, image4);
            statement.bindString(13, text4);
        }
        else {
            statement.bindNull(12);
            statement.bindNull(13);
        }

        if(image5!=null){
            statement.bindBlob(14, image5);
            statement.bindString(15, text5);
        }
        else {
            statement.bindNull(14);
            statement.bindNull(15);
        }

        if(image6!=null){
            statement.bindBlob(16, image6);
            statement.bindString(17, text6);
        }
        else {
            statement.bindNull(16);
            statement.bindNull(17);
        }

        if(image7!=null){
            statement.bindBlob(18, image7);
            statement.bindString(19, text7);
        }
        else {
            statement.bindNull(18);
            statement.bindNull(19);
        }

        if(image8!=null){
            statement.bindBlob(20, image8);
            statement.bindString(21, text8);
        }
        else {
            statement.bindNull(20);
            statement.bindNull(21);
        }

        if(image9!=null){
            statement.bindBlob(22, image9);
            statement.bindString(23, text9);
        }
        else {
            statement.bindNull(22);
            statement.bindNull(23);
        }

        if(image10!=null){
            statement.bindBlob(24, image10);
            statement.bindString(25, text10);
        }
        else {
            statement.bindNull(24);
            statement.bindNull(25);
        }

        statement.bindLong(26, id);
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

    void Delete(long id, Context context){
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

    public void DeleteAndUpdate(int id) {
        SQLiteDatabase db = getWritableDatabase(); // có thể dùng getWrite vừa đọc vừa ghi
        String sql = "DELETE FROM NOTE WHERE Id = ?";
        SQLiteStatement statement = db.compileStatement(sql);
        statement.clearBindings();
        statement.bindLong(1, id);
        statement.executeUpdateDelete();
    }

    //ĐẾM TỔNG SỐ GHI CHÚ
    int count(){
        String countQuery = "SELECT * FROM NOTE " ;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(countQuery, null);

        if (cursor != null) {
            count = cursor.getCount();
            cursor.close();
        }
        return count;
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

}
