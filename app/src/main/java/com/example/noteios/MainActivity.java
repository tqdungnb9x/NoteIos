package com.example.noteios;

import android.content.ClipData;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity<actionBar> extends AppCompatActivity {

    public static final String ID ="id";
    public static final String CREATE ="iscreate";
    public static final String BUNDLE ="bundle";
    public static final String KEYEDT ="edittext";
    public static final String KEYIMG ="image";
    public int idnote;

    boolean itemboolean=false;
    ImageButton btnaddmain;
    ImageButton btnappmain;
    TextView tvlistnote;
    ImageView imvlistnote;

    ListView lvwnotemain;
    TextView tvwcountmain;
    ImageView imvdeleteitem;
//    ArrayList<ListNoteData> mang;
    TextView tvtitlenotemain;
    TextView tvtimenotemain;
    TextView tvdesnotemain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Ghi chú");

        AnhXa();

//        set Back Icon
//
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        Drawable drawable = getResources().getDrawable(R.drawable.ic_back);
//        getSupportActionBar().setHomeAsUpIndicator(drawable);
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(), MainActivity.class));
//            }
//        });
//        Toobar đã như ActionBar
//        ActionBar actionBar = getSupportActionBar();

//        Tạo DB
        final SQLite db = new SQLite(getApplicationContext(), "Note.sqlite", null, 1);

//        Tạo table
        db.QueryData("CREATE TABLE IF NOT EXISTS NOTE ( Id INTEGER,Time VARCHAR, Text VARCHAR, Image BLOB )");

        //        //dòng này để text sql, làm xong nhớ xóa
//        db.QueryData("INSERT INTO NOTE VALUES (null,'10:10','abc' ,null)");

        //        Button Create Note
        btnaddmain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                idnote =db.count();
                IntentToNote( idnote,1);
            }
        });

        //Button này Tạm thời dùng để xóa data của 1 bảng, vân giữ nguyên bảng
        btnappmain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.QueryData("DELETE FROM NOTE");
                LoadDataList(db);
            }
        });

        LoadDataList(db);
//        ADAPTER
//        ArrayList<ListNoteData > mang = new ArrayList<ListNoteData>();
//        Cursor note = db.GetData("SELECT * FROM NOTE");
//        note.moveToLast();
//        do{
//            mang.add(new ListNoteData(note.getString(1),note.getString(2)));
//            note.moveToPrevious();
//            // thằng Blob của DB đang rơi vào cột 2,( đáng ra là cột 3)
//            //mang.add(new ListNoteData(note.getInt(0),note.getString(1),note.getString(2), note.getBlob(3)));
//        }while (!note.isBeforeFirst());
//
//        CustomAdapter adapter = new CustomAdapter(getApplicationContext(), R.layout.roll_item, mang);
//        lvwnotemain.setAdapter(adapter);

//        Bắt sự kiện nhấn vào 1 note trong list note
        lvwnotemain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"position = "+position, Toast.LENGTH_SHORT).show();
                IntentToNote(db.count()-1-position,0);
                Log.v("nhan1lan","nhan1lan");
            }
        });


//        Bắt sự kiện nhấn giữ sẽ xóa 1 note
        lvwnotemain.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                int count = db.count()- position-1; // tránh db.count() thay đổi trong SQLite.java
                Log.v("abcabc",""+count);
                db.Delete(count,getApplicationContext());
                LoadDataList(db);
                return true;
            }
        });



//        Button Delete trong màn hình note

//        imvdelitem.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View v){
//                db.QueryData("DELETE FROM NOTE WHERE Id =" + idnote );//idnote là biến Id cho mỗi 1 ghi chú , ++ khi thêm 1 ghi chú
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem item = menu.findItem(R.id.itemEdit);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId()){
            case R.id.itemEdit:
//                if (itemboolean == true) {
//                    imvdeleteitem.setVisibility(View.VISIBLE);
//                }
//                else imvdeleteitem.setVisibility(View.GONE);
                return true;
//            case R.id.help:
//                showHelp();
//                return true;
//            default:
//            return super.onOptionsItemSelected(item);

        }
        return super.onOptionsItemSelected(item);
    }

    public void AnhXa(){
        btnaddmain = (ImageButton) findViewById(R.id.btnaddmain);
        btnappmain = (ImageButton) findViewById(R.id.btnappmain);
        lvwnotemain = (ListView) findViewById(R.id.lvwnotemain);
        tvwcountmain = (TextView) findViewById(R.id.tvwcountmain);
//        imvdeleteitem = (ImageView) findViewById(R.id.imvdeleteitem);
//        tvlistnote = (TextView) findViewById(R.id.tvlistnote);
//        imvlistnote = (ImageView) findViewById(R.id.imvlistnote);
        tvtitlenotemain = (TextView) findViewById(R.id.tvtitlenotemain);
        tvtimenotemain = (TextView) findViewById(R.id.tvtimenotemain);
        tvdesnotemain = (TextView) findViewById(R.id.tvdesnotemain);

    }

    public void IntentToNote(int id, int iscreate){
        Intent intent = new Intent(MainActivity.this,NoteActivity.class);
        Bundle bundle = new Bundle();
//        bundle.putString(KEYEDT,mang.get(posision).text);
//        bundle.putByteArray(KEYIMG,mang.get(posision).image);
        bundle.putInt(ID,id);
        bundle.putInt(CREATE,iscreate);//iscreate = 1 thì là tạo note mới, = 0 là chỉnh sửa
        Toast.makeText(MainActivity.this,"id = "+id + " ,iscreate=" +iscreate,Toast.LENGTH_SHORT).show();
        intent.putExtra(BUNDLE,bundle);
        startActivity(intent);
        Log.v("chuyenAc","chuyenAc");
    }
//    public void RecycleAdapter(){
//        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.rcvmain);
//        recyclerView.setHasFixedSize(true);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
//        recyclerView.setLayoutManager(linearLayoutManager);
//        ArrayList<ListNoteMain> arrayList =new ArrayList<>();
//        RecycleAdapter recycleAdapter = new RecycleAdapter(mang,getApplicationContext());
//    }

    public void LoadDataList (SQLite db){
        ArrayList<ListNoteData> mang = new ArrayList<ListNoteData>();
        Cursor note = db.GetData("SELECT * FROM NOTE");
        if(note.getCount() != 0){
            note.moveToLast();
            do{
                mang.add(new ListNoteData(note.getInt(0),note.getString(2)));
                note.moveToPrevious();
                // thằng Blob của DB đang rơi vào cột 2,( đáng ra là cột 3)
                //mang.add(new ListNoteData(note.getInt(0),note.getString(1),note.getString(2), note.getBlob(3)));
            }while (!note.isBeforeFirst());
        }

        CustomAdapter adapter = new CustomAdapter(MainActivity.this, R.layout.roll_item, mang);
        lvwnotemain.setAdapter(adapter);
        //HIện số lượng ghi chú
        tvwcountmain.setText("CÓ " + db.count() + " GHI CHÚ ");
    }
}