package com.example.noteios;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextClock;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

import static com.example.noteios.MainActivity.ID;
public class NoteActivity<actionBar> extends AppCompatActivity {

    int countview=0;
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

//    ImageView imagenotenote0;
//    ImageView imagenotenote1;
//    ImageView imagenotenote2;
//    ImageView imagenotenote3;
//    ImageView imagenotenote4;
//    ImageView imagenotenote5;
//    ImageView imagenotenote6;
//    ImageView imagenotenote7;
//    ImageView imagenotenote8;
//    ImageView imagenotenote9;
//    ImageView imagenotenote10;
//
//    EditText edtnotenote0;
//    EditText edtnotenote1;
//    EditText edtnotenote2;
//    EditText edtnotenote3;
//    EditText edtnotenote4;
//    EditText edtnotenote5;
//    EditText edtnotenote6;
//    EditText edtnotenote7;
//    EditText edtnotenote8;
//    EditText edtnotenote9;
//    EditText edtnotenote10;

//    RelativeLayout.LayoutParams layoutRelative;
//    RelativeLayout.LayoutParams layoutImage;
//    RelativeLayout.LayoutParams layoutEdit;
//    RelativeLayout.LayoutParams layoutButton;
//    LinearLayout.LayoutParams layoutLinear;
    LinearLayout.LayoutParams layoutRelative;
    RelativeLayout.LayoutParams layoutImage;
    LinearLayout.LayoutParams layoutEdit;
    RelativeLayout.LayoutParams layoutButton;

    ImageView [] arrayimage = new ImageView[11];
    EditText [] arrayedt = new EditText[11];
//    LinearLayout[] arraylinear = new LinearLayout[11];
    RelativeLayout [] arrayrelative = new RelativeLayout[11];
    ImageButton [] arraybtn = new ImageButton[11];

    int [] arrayidedit = {R.id.edtnotenote0,R.id.edtnotenote1,R.id.edtnotenote2,R.id.edtnotenote3,R.id.edtnotenote4,R.id.edtnotenote5,R.id.edtnotenote6,R.id.edtnotenote7,R.id.edtnotenote8,R.id.edtnotenote9,R.id.edtnotenote10};
    int [] arrayidimage = {R.id.imagenotenote0,R.id.imagenotenote1,R.id.imagenotenote2,R.id.imagenotenote3,R.id.imagenotenote4,R.id.imagenotenote5,R.id.imagenotenote6,R.id.imagenotenote7,R.id.imagenotenote8,R.id.imagenotenote9,R.id.imagenotenote10};
    int [] arrayidbtn = {R.id.btndelnotenote0,R.id.btndelnotenote1,R.id.btndelnotenote2,R.id.btndelnotenote3,R.id.btndelnotenote4,R.id.btndelnotenote5,R.id.btndelnotenote6,R.id.btndelnotenote7,R.id.btndelnotenote8,R.id.btndelnotenote9,R.id.btndelnotenote10};
    int [] arrayidrelative = {R.id.relativelayoutsub0,R.id.relativelayoutsub1,R.id.relativelayoutsub2,R.id.relativelayoutsub3,R.id.relativelayoutsub4,R.id.relativelayoutsub5,R.id.relativelayoutsub6,R.id.relativelayoutsub7,R.id.relativelayoutsub8,R.id.relativelayoutsub9,R.id.relativelayoutsub10};
//    int [] arrayidlinear = {R.id.linearlayoutsub0,R.id.linearlayoutsub1,R.id.linearlayoutsub2,R.id.linearlayoutsub3,R.id.linearlayoutsub4,R.id.linearlayoutsub5,R.id.linearlayoutsub6,R.id.linearlayoutsub7,R.id.linearlayoutsub8,R.id.linearlayoutsub9,R.id.linearlayoutsub10};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        getActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFFFF")));

        AnhXa();

        arrayimage[0] = new ImageView(this);
        arrayimage[1] = new ImageView(this);
        arrayimage[2] = new ImageView(this);
        arrayimage[3] = new ImageView(this);
        arrayimage[4] = new ImageView(this);
        arrayimage[5] = new ImageView(this);
        arrayimage[6] = new ImageView(this);
        arrayimage[7] = new ImageView(this);
        arrayimage[8] = new ImageView(this);
        arrayimage[9] = new ImageView(this);
        arrayimage[10] = new ImageView(this);

        arrayedt[0] = new EditText(this);
        arrayedt[1] = new EditText(this);
        arrayedt[2] = new EditText(this);
        arrayedt[3] = new EditText(this);
        arrayedt[4] = new EditText(this);
        arrayedt[5] = new EditText(this);
        arrayedt[6] = new EditText(this);
        arrayedt[7] = new EditText(this);
        arrayedt[8] = new EditText(this);
        arrayedt[9] = new EditText(this);
        arrayedt[10] = new EditText(this);

        arrayrelative[0] = new RelativeLayout(this);
        arrayrelative[1] = new RelativeLayout(this);
        arrayrelative[2] = new RelativeLayout(this);
        arrayrelative[3] = new RelativeLayout(this);
        arrayrelative[4] = new RelativeLayout(this);
        arrayrelative[5] = new RelativeLayout(this);
        arrayrelative[6] = new RelativeLayout(this);
        arrayrelative[7] = new RelativeLayout(this);
        arrayrelative[8] = new RelativeLayout(this);
        arrayrelative[9] = new RelativeLayout(this);
        arrayrelative[10] = new RelativeLayout(this);

//        arraylinear[0] = new LinearLayout(this);
//        arraylinear[1] = new LinearLayout(this);
//        arraylinear[2] = new LinearLayout(this);
//        arraylinear[3] = new LinearLayout(this);
//        arraylinear[4] = new LinearLayout(this);
//        arraylinear[5] = new LinearLayout(this);
//        arraylinear[6] = new LinearLayout(this);
//        arraylinear[7] = new LinearLayout(this);
//        arraylinear[8] = new LinearLayout(this);
//        arraylinear[9] = new LinearLayout(this);
//        arraylinear[10] = new LinearLayout(this);

        arraybtn[0] = new ImageButton(this);
        arraybtn[1] = new ImageButton(this);
        arraybtn[2] = new ImageButton(this);
        arraybtn[3] = new ImageButton(this);
        arraybtn[4] = new ImageButton(this);
        arraybtn[5] = new ImageButton(this);
        arraybtn[6] = new ImageButton(this);
        arraybtn[7] = new ImageButton(this);
        arraybtn[8] = new ImageButton(this);
        arraybtn[9] = new ImageButton(this);
        arraybtn[10] = new ImageButton(this);



        mangtamthoi = new ListNoteData(null,null,null);


        layoutRelative = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        layoutLinear = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutImage = new RelativeLayout.LayoutParams(500, 500);
        layoutImage.setMargins(20,20,20,20);
        layoutImage.addRule(RelativeLayout.CENTER_HORIZONTAL);
        layoutButton = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutEdit = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);


        //DB

        final SQLite db = new SQLite(getApplicationContext(), "Note.sqlite", null, 1);
        //           db.QueryData();

        //Lay Data cua note tu ben MainAc
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra(MainActivity.BUNDLE);
        idnote = bundle.getInt(ID);

        //đây là text posision của listview
        iscreatenote = bundle.getInt(MainActivity.CREATE);
        mangtamthoi.setId(idnote);

        //set textclock
        String formatdate = "E, d-M-yy";
        tvtimenotenote.setFormat24Hour(formatdate);
        //Truyen vao cac view cua NoteAc

        mangtamthoi.setTime(tvtimenotenote.getText().toString());
            if (iscreatenote == 0) { // iscreatenote = 1 là tạo mới note, = 0 là chỉnh sửa
                Cursor notetamthoi = db.GetData("SELECT * FROM NOTE ORDER BY Id ASC " );

                //đang hơi khó hiểu dòng này, từ đoạn InternNote bên MainAc
                notetamthoi.moveToPosition(idnote);//idnote = Id trong SQL -1

//                mangtamthoi.setText(notetamthoi.getString(2));
//                mangtamthoi.setImage(notetamthoi.getBlob(3));
                edtnotenote.setText(notetamthoi.getString(2));

                //sẽ sửa thêm nhiều vòng if khi chỉnh lên nhiều text và image trong sql
                if(notetamthoi.getBlob(3)!=null){
                    creatImageView(0,ByteArray_To_Bitmap(notetamthoi.getBlob(3)));
                    arrayedt[0].setText(notetamthoi.getString(4));
                    //countview++;
                    Log.v("create1111", String.valueOf(countview));

                    if(notetamthoi.getBlob(5)!=null){
                        creatImageView(1,ByteArray_To_Bitmap(notetamthoi.getBlob(5)));
                        arrayedt[1].setText(notetamthoi.getString(6));
                        //countview++;

                        if(notetamthoi.getBlob(7)!=null){
                            creatImageView(2,ByteArray_To_Bitmap(notetamthoi.getBlob(7)));
                            arrayedt[2].setText(notetamthoi.getString(8));
                            //countview++;

                            if(notetamthoi.getBlob(9)!=null){
                                creatImageView(3,ByteArray_To_Bitmap(notetamthoi.getBlob(9)));
                                arrayedt[3].setText(notetamthoi.getString(10));
                                //countview++;

                                if(notetamthoi.getBlob(11)!=null){
                                    creatImageView(4,ByteArray_To_Bitmap(notetamthoi.getBlob(11)));
                                    arrayedt[4].setText(notetamthoi.getString(12));
                                    //countview++;

                                    if(notetamthoi.getBlob(13)!=null){
                                        creatImageView(5,ByteArray_To_Bitmap(notetamthoi.getBlob(13)));
                                        arrayedt[5].setText(notetamthoi.getString(14));
                                        //countview++;

                                        if(notetamthoi.getBlob(15)!=null){
                                            creatImageView(6,ByteArray_To_Bitmap(notetamthoi.getBlob(15)));
                                            arrayedt[6].setText(notetamthoi.getString(16));
                                            //countview++;

                                            if(notetamthoi.getBlob(17)!=null){
                                                creatImageView(7,ByteArray_To_Bitmap(notetamthoi.getBlob(17)));
                                                arrayedt[7].setText(notetamthoi.getString(18));
                                                //countview++;

                                                if(notetamthoi.getBlob(19)!=null){
                                                    creatImageView(8,ByteArray_To_Bitmap(notetamthoi.getBlob(19)));
                                                    arrayedt[8].setText(notetamthoi.getString(20));
                                                    //countview++;

                                                    if(notetamthoi.getBlob(21)!=null){
                                                        creatImageView(9,ByteArray_To_Bitmap(notetamthoi.getBlob(21)));
                                                        arrayedt[9].setText(notetamthoi.getString(22));
                                                        //countview++;

                                                        if(notetamthoi.getBlob(23)!=null){
                                                            creatImageView(10,ByteArray_To_Bitmap(notetamthoi.getBlob(23)));
                                                            arrayedt[10].setText(notetamthoi.getString(24));
                                                            //countview++;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
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
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(), NoteActivity.class));
//            }
//        });

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
//                if(!hasImage(arrayimage[0])){
//                    if (iscreatenote == 1) {
//                        Log.v("insert111","null");
//
//                        db.Insert(idnote,
//                                tvtimenotenote.getText().toString(),
//                                edtnotenote.getText().toString(),
//                                null
//                        );
//                    } else {
//                        Log.v("update111","null");
//                        db.Update(idnote,
//                                tvtimenotenote.getText().toString(),
//                                edtnotenote.getText().toString(),
//                                null
//                        );
//                    }
//                }
//                else {
                    if (iscreatenote == 1) {
                        Log.v("insert111","notnull");

                        db.Insert(idnote,
                                tvtimenotenote.getText().toString(),
                                edtnotenote.getText().toString(),
                                ImageView_To_Byte(arrayimage[0]),
                                arrayedt[0].getText().toString(),
                                ImageView_To_Byte(arrayimage[1]),
                                arrayedt[1].getText().toString(),
                                ImageView_To_Byte(arrayimage[2]),
                                arrayedt[2].getText().toString(),
                                ImageView_To_Byte(arrayimage[3]),
                                arrayedt[3].getText().toString(),
                                ImageView_To_Byte(arrayimage[4]),
                                arrayedt[4].getText().toString(),
                                ImageView_To_Byte(arrayimage[5]),
                                arrayedt[5].getText().toString(),
                                ImageView_To_Byte(arrayimage[6]),
                                arrayedt[6].getText().toString(),
                                ImageView_To_Byte(arrayimage[7]),
                                arrayedt[7].getText().toString(),
                                ImageView_To_Byte(arrayimage[8]),
                                arrayedt[8].getText().toString(),
                                ImageView_To_Byte(arrayimage[9]),
                                arrayedt[9].getText().toString(),
                                ImageView_To_Byte(arrayimage[10]),
                                arrayedt[10].getText().toString()
                        );
                    } else {
                        Log.v("update111","notnull");

                        db.Update(idnote,
                                tvtimenotenote.getText().toString(),
                                edtnotenote.getText().toString(),
                                ImageView_To_Byte(arrayimage[0]),
                                arrayedt[0].getText().toString(),
                                ImageView_To_Byte(arrayimage[1]),
                                arrayedt[1].getText().toString(),
                                ImageView_To_Byte(arrayimage[2]),
                                arrayedt[2].getText().toString(),
                                ImageView_To_Byte(arrayimage[3]),
                                arrayedt[3].getText().toString(),
                                ImageView_To_Byte(arrayimage[4]),
                                arrayedt[4].getText().toString(),
                                ImageView_To_Byte(arrayimage[5]),
                                arrayedt[5].getText().toString(),
                                ImageView_To_Byte(arrayimage[6]),
                                arrayedt[6].getText().toString(),
                                ImageView_To_Byte(arrayimage[7]),
                                arrayedt[7].getText().toString(),
                                ImageView_To_Byte(arrayimage[8]),
                                arrayedt[8].getText().toString(),
                                ImageView_To_Byte(arrayimage[9]),
                                arrayedt[9].getText().toString(),
                                ImageView_To_Byte(arrayimage[10]),
                                arrayedt[10].getText().toString()
                        );
//                    }
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
                    db.Delete( idnote+1, getApplicationContext());
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
            creatImageView(countview,photo);
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

    public void creatImageView(final int i, Bitmap photo){
        Log.v("create1112", String.valueOf(countview));
        if(i>10){
            Toast.makeText(NoteActivity.this,"Doesn't work",Toast.LENGTH_SHORT).show();
        }
        else {
            if(arrayrelative[i] != null) {
                arrayrelative[i].removeAllViews();
                ((ViewGroup)linearlayoutnote).removeView(arrayrelative[i]); // <- fix
                ((ViewGroup)linearlayoutnote).removeView(arrayedt[i]); // <- fix
            }
//            arraylinear[i].setId(arrayidlinear[i]);
            arrayrelative[i].setId(arrayidrelative[i]);
            arrayimage[i].setId(arrayidimage[i]);
            arrayedt[i].setId(arrayidedit[i]);
            arraybtn[i].setId(arrayidbtn[i]);

//            arraylinear[i].setLayoutParams(layoutLinear);
            arrayrelative[i].setLayoutParams(layoutRelative);
            arrayimage[i].setLayoutParams(layoutImage);
            arrayedt[i].setLayoutParams(layoutEdit);
            arraybtn[i].setLayoutParams(layoutButton);

            arraybtn[i].setImageResource(R.drawable.ic_close);
            layoutButton.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,arrayidimage[i]);
            layoutButton.addRule(RelativeLayout.ALIGN_PARENT_TOP,arrayidimage[i]);
//            layoutEdit.addRule(RelativeLayout.BELOW,arrayidimage[i]);

            arrayimage[i].setImageBitmap(photo);
            arrayedt[i].getBackground().mutate().setColorFilter(getResources().getColor(R.color.colorWhite), PorterDuff.Mode.SRC_ATOP);
//            arrayedt[i].setMinLines(2);
            arrayedt[i].setHint("Edit1");


//            linearlayoutnote.addView(arraylinear[i]);
            linearlayoutnote.addView(arrayrelative[i]);
            arrayrelative[i].addView(arrayimage[i]);
            arrayrelative[i].addView(arraybtn[i]);
            linearlayoutnote.addView(arrayedt[i]);

            countview++;
            arraybtn[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    countview--;
                    Log.v("create1113", String.valueOf(countview));
                    if (i==0){
                        edtnotenote.setText(edtnotenote.getText().toString().concat("\r\n"));
                        edtnotenote.setText(edtnotenote.getText().toString().concat(arrayedt[i].getText().toString()));

                        arrayimage[i].setImageDrawable(null); // the best clear imageview way in this time, not the best at all way
//                arrayimage[i].setImageResource(android.R.color.transparent);
                        arrayedt[i].setText(null);
                        arrayrelative[i].removeAllViews();
                        ((ViewGroup) arrayrelative[i].getParent()).removeView(arrayrelative[i]);
                        boolean b = ImageView_To_Byte(arrayimage[i])!=null; // =0 if null, =1 if not null
                        Log.v("delete", String.valueOf(b));

                    }else {
                        arrayedt[i-1].setText(arrayedt[i-1].getText().toString().concat(arrayedt[i].getText().toString()));
                        arrayimage[i].setImageResource(android.R.color.transparent);
                        arrayedt[i].setText(null);
                        ((ViewGroup) arrayrelative[i].getParent()).removeView(arrayrelative[i]);
                    }

                }
            });
        }

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
        if(!hasImage(imageView)){
            return null;
        }
        else {
            BitmapDrawable bitmapDrawable = (BitmapDrawable)imageView.getDrawable();
            Bitmap bitmap = Bitmap.createBitmap(bitmapDrawable.getBitmap());
//        Bitmap bitmap =bitmapDrawable.getBitmap();
            ByteArrayOutputStream stream =new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG,100,stream);
            byte [] bytearray = stream.toByteArray();
            return bytearray;
        }


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

    private boolean hasImage( ImageView view) {
        Drawable drawable = view.getDrawable();
        boolean hasImage = (drawable != null);

        if (hasImage && (drawable instanceof BitmapDrawable)) {
            hasImage = ((BitmapDrawable)drawable).getBitmap() != null;
        }

        return hasImage;
    }

}