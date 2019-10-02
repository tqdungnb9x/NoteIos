package com.example.noteios;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.ShareActionProvider;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

import static com.example.noteios.MainActivity.ID;
public class NoteActivity<actionBar> extends AppCompatActivity {

    int i=-1;
    int idnote;
    int iscreatenote;
    String time;
    ImageButton btndeletenote;
    ImageButton btnchecknote;
    ImageButton btnaddfilenote;
    ImageButton btnpaintnote;
    ImageButton btnaddnote;
    EditText edtnotenote ;
    LinearLayout linearlayoutnote;
    Bitmap photo = null;
    ListNoteData mangtamthoi;
    TextClock tvtimenotenote;

    ImageView imagenotenote0;
    ImageView imagenotenote1;
    ImageView imagenotenote2;
    ImageView imagenotenote3;
    ImageView imagenotenote4;
    ImageView imagenotenote5;
    ImageView imagenotenote6;
    ImageView imagenotenote7;
    ImageView imagenotenote8;
    ImageView imagenotenote9;
    ImageView imagenotenote10;

    EditText edtnotenote0;
    EditText edtnotenote1;
    EditText edtnotenote2;
    EditText edtnotenote3;
    EditText edtnotenote4;
    EditText edtnotenote5;
    EditText edtnotenote6;
    EditText edtnotenote7;
    EditText edtnotenote8;
    EditText edtnotenote9;
    EditText edtnotenote10;

    LinearLayout.LayoutParams layoutImage;
    LinearLayout.LayoutParams layoutEdit;

    ImageView [] arrayimage = new ImageView[11];
    EditText [] arrayedt = new EditText[11];

    int [] arrayidedit = {R.id.edtnotenote0,R.id.edtnotenote1,R.id.edtnotenote2,R.id.edtnotenote3,R.id.edtnotenote4,R.id.edtnotenote5,R.id.edtnotenote6,R.id.edtnotenote7,R.id.edtnotenote8,R.id.edtnotenote9,R.id.edtnotenote10};
    int [] arrayidimage = {R.id.imagenotenote0,R.id.imagenotenote1,R.id.imagenotenote2,R.id.imagenotenote3,R.id.imagenotenote4,R.id.imagenotenote5,R.id.imagenotenote6,R.id.imagenotenote7,R.id.imagenotenote8,R.id.imagenotenote9,R.id.imagenotenote10};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        AnhXa();

        imagenotenote0 = new ImageView(this);
        imagenotenote1 = new ImageView(this);
        imagenotenote2 = new ImageView(this);
        imagenotenote3 = new ImageView(this);
        imagenotenote4 = new ImageView(this);
        imagenotenote5 = new ImageView(this);
        imagenotenote6 = new ImageView(this);
        imagenotenote7 = new ImageView(this);
        imagenotenote8 = new ImageView(this);
        imagenotenote9 = new ImageView(this);
        imagenotenote10 = new ImageView(this);

        edtnotenote0 = new EditText(this);
        edtnotenote1 = new EditText(this);
        edtnotenote2 = new EditText(this);
        edtnotenote3 = new EditText(this);
        edtnotenote4 = new EditText(this);
        edtnotenote5 = new EditText(this);
        edtnotenote6 = new EditText(this);
        edtnotenote7 = new EditText(this);
        edtnotenote8 = new EditText(this);
        edtnotenote9 = new EditText(this);
        edtnotenote10 = new EditText(this);

        arrayimage[0] = imagenotenote0;
        arrayimage[1] = imagenotenote1;
        arrayimage[2] = imagenotenote2;
        arrayimage[3] = imagenotenote3;
        arrayimage[4] = imagenotenote4;
        arrayimage[5] = imagenotenote5;
        arrayimage[6] = imagenotenote6;
        arrayimage[7] = imagenotenote7;
        arrayimage[8] = imagenotenote8;
        arrayimage[9] = imagenotenote9;
        arrayimage[10] = imagenotenote10;

        arrayedt[0] = edtnotenote0;
        arrayedt[1] = edtnotenote1;
        arrayedt[2] = edtnotenote2;
        arrayedt[3] = edtnotenote3;
        arrayedt[4] = edtnotenote4;
        arrayedt[5] = edtnotenote5;
        arrayedt[6] = edtnotenote6;
        arrayedt[7] = edtnotenote7;
        arrayedt[8] = edtnotenote8;
        arrayedt[9] = edtnotenote9;
        arrayedt[10] = edtnotenote10;

        mangtamthoi = new ListNoteData(null,null,null);


//        layoutImage = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutImage = new LinearLayout.LayoutParams(200,200);
        layoutEdit = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);

        //DB

        final SQLite db = new SQLite(getApplicationContext(), "Note.sqlite", null, 1);
        //           db.QueryData();

        //Lay Data cua note tu ben MainAc
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra(MainActivity.BUNDLE);
        idnote = bundle.getInt(MainActivity.ID);

        //đây là text posision của listview
        iscreatenote = bundle.getInt(MainActivity.CREATE);
        mangtamthoi.setId(idnote);

        //set textclock
        String formatdate = "E, d-M-yy";
        tvtimenotenote.setFormat24Hour(formatdate);
        //Truyen vao cac view cua NoteAc

        mangtamthoi.setTime(tvtimenotenote.getText().toString());
            if (iscreatenote == 0) { // iscreatenote = 1 là tạo mới note, = 0 là chỉnh sửa
                Cursor notetamthoi = db.GetData("SELECT * FROM NOTE " );

                //đang hơi khó hiểu dòng này, từ đoạn InternNote bên MainAc
                notetamthoi.moveToPosition(idnote);//idnote = Id trong SQL -1

//                mangtamthoi.setText(notetamthoi.getString(2));
//                mangtamthoi.setImage(notetamthoi.getBlob(3));
                edtnotenote.setText(notetamthoi.getString(2));

                //sẽ sửa thêm nhiều vòng if khi chỉnh lên nhiều text và image trong sql
                if(notetamthoi.getBlob(3)!=null){
                    creatImageView(0,ByteArray_To_Bitmap(notetamthoi.getBlob(3)));
                }
            }

        // set add file photo button
        btnaddfilenote.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent Camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(Camera, 111);
            }
        });

        // set Back Icon
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Drawable drawable = getResources().getDrawable(R.drawable.ic_back);
        getSupportActionBar().setHomeAsUpIndicator(drawable);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), NoteActivity.class));
            }
        });

        ActionBar actionBar = getSupportActionBar();
        //Toobar đã như ActionBar\

        //Button Save
        btnaddnote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                if(arrayimage[0]==null){
//                    Toast.makeText(NoteActivity.this,"image0 == null",Toast.LENGTH_LONG).show();
//                }
//                else {
//                    Toast.makeText(NoteActivity.this,"image0 ## null",Toast.LENGTH_LONG).show();
//                }
                if(arrayimage[0].getDrawable()==null) {
                    if (iscreatenote == 1) {
                        db.InsertNull(idnote,
                                tvtimenotenote.getText().toString(),
                                edtnotenote.getText().toString(),
                                null
                        );
                    } else {
                        Log.v("update","null");
                        db.UpdateNull(idnote,
                                tvtimenotenote.getText().toString(),
                                edtnotenote.getText().toString()
                        );
                    }
                }
                else {
                    if (iscreatenote == 1) {
                        db.Insert(idnote,
                                tvtimenotenote.getText().toString(),
                                edtnotenote.getText().toString(),
                                ImageView_To_Byte(arrayimage[0])
                        );
                    } else {
                        db.Update(idnote,
                                tvtimenotenote.getText().toString(),
                                edtnotenote.getText().toString(),
                                ImageView_To_Byte(arrayimage[0])

                        );
                    }
                }
                Toast.makeText(NoteActivity.this, "Đã lưu", Toast.LENGTH_SHORT).show();
                BackToMain();
            }
        });

        //Button Delete
        btndeletenote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (iscreatenote==1){
                    BackToMain();
                }
                else {
                    db.DeleteAndUpdate((int) (idnote+1));
                    BackToMain();
                }
            }
        });

        //Button Table

        btnchecknote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_note, menu);
        MenuItem item = menu.findItem(R.id.actionShare);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
//            Button share
            case R.id.actionShare:
                //xem lại dòng 238 và 252 có thể trùng nhau
                MenuItem actionShare = findViewById(R.id.actionShare);
                ShareActionProvider myShareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(actionShare);
                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
//        shareIntent.putExtra(Intent.EXTRA_STREAM,getImageUri(getApplicationContext(),photo));
                shareIntent.putExtra(Intent.EXTRA_TEXT,edtnotenote.getText().toString());
                shareIntent.setType("*/*");
                startActivity(Intent.createChooser(shareIntent,"Chia sẻ với "));
                myShareActionProvider.setShareIntent(shareIntent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //save photo
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==111 && resultCode==RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            i++;
            creatImageView(0,photo);
        }
    }

    public void AnhXa(){
        linearlayoutnote = findViewById(R.id.linearlayoutnote);
        btndeletenote = findViewById(R.id.btndeletenote);
        btnchecknote = findViewById(R.id.btnchecknote);
        btnaddfilenote = findViewById(R.id.btnaddfilenote);
        btnpaintnote = findViewById(R.id.btnpaintnote);
        btnaddnote = findViewById(R.id.btnaddnote);
        edtnotenote = findViewById(R.id.edtnotenote);
        tvtimenotenote = findViewById(R.id.tvtimenotenote);
    }

    public void creatImageView(int i,Bitmap photo){
        if(arrayimage[i].getParent() != null) {
            ((ViewGroup)arrayimage[i].getParent()).removeView(arrayimage[i]); // <- fix
        }

        arrayimage[i].setId(arrayidimage[i]);
        arrayedt[i].setId(arrayidedit[i]);
//        arrayimage[i].setAdjustViewBounds(true);
//        arrayimage[i].setMaxHeight(100);
//        arrayimage[i].setMaxWidth(100);
        arrayimage[i].setLayoutParams(layoutImage);
        arrayedt[i].setLayoutParams(layoutEdit);
        arrayimage[i].setImageBitmap(photo);
        arrayedt[i].getBackground().mutate().setColorFilter(getResources().getColor(R.color.colorWhite), PorterDuff.Mode.SRC_ATOP);

        if(arrayimage[i].getParent() != null) {
            ((ViewGroup)arrayimage[i].getParent()).removeView(arrayimage[i]); // <- fix
        }
        linearlayoutnote.addView(arrayimage[i]);
        linearlayoutnote.addView(arrayedt[i]);
    }

    public byte[] Bitmap_To_Byte(Bitmap photo){
//        Bitmap bmp = BitmapFactory.decodeResource(getResources(),R.drawable.chomuc);
//        BitmapDrawable drawable = (BitmapDrawable) h.;
//        Bitmap bmp = drawable.getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        photo.compress(Bitmap.CompressFormat.PNG,100,stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }

    public Bitmap Byte_To_Bitmap(byte[] image){
        Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0, image.length);
        ByteArrayOutputStream blob = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0 /* Ignored for PNGs */, blob);
        byte[] bitmapdata = blob.toByteArray();
        return bitmap;
    }

//    public void TakeNoteFromMain (){
//        Intent intent = getIntent();
//        Bundle bundle = intent.getBundleExtra(MainActivity.BUNDLE);
//
////        creatImageView(Byte_To_Bitmap(image));
//        idnote = bundle.getInt(MainActivity.ID);
//        iscreatenote = bundle.getInt(MainActivity.CREATE);
//
//        final SQLite db = new SQLite(getApplicationContext(), "Note.sqlite", null, 1);
//
//        mangtamthoi.setId(idnote);
//        if(iscreatenote==0){// =0 là chỉnh sửa, = 1 là tạo mới
//            Cursor notetamthoi = db.GetData("SELECT * FROM NOTE WHERE Id = " + idnote);
//            mangtamthoi.setText(notetamthoi.getString(1));
//            mangtamthoi.setImage(notetamthoi.getBlob(2));
//        }
//
//    }

    public byte[] ImageView_To_Byte(ImageView imageView){
        BitmapDrawable bitmapDrawable = (BitmapDrawable)imageView.getDrawable();
        Bitmap bitmap = Bitmap.createBitmap(bitmapDrawable.getBitmap());
//        Bitmap bitmap =bitmapDrawable.getBitmap();
        ByteArrayOutputStream stream =new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100,stream);
        byte [] bytearray = stream.toByteArray();
        return bytearray;

//        Bitmap bmp = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
//        byte[] imageInByte = baos.toByteArray();
//        return imageInByte;
    }

    public void BackToMain(){
        Intent intent = new Intent(NoteActivity.this,MainActivity.class);
        startActivity(intent);
    }

    public Bitmap ByteArray_To_Bitmap(byte[] byteArray){
        Bitmap bm = BitmapFactory.decodeByteArray(byteArray, 0 ,byteArray.length);
        return bm;
    }
}