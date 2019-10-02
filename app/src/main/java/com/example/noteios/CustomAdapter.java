package com.example.noteios;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<ListNoteData> {
    private Context context;
    private int resource;
    private ArrayList<ListNoteData> arrContact;

    private final String TAG = getClass().getSimpleName();
    public CustomAdapter(Context context, int resource, ArrayList<ListNoteData> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.arrContact=objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.roll_item,parent,false);

            viewHolder = new ViewHolder();
            viewHolder.tvtitlenotemain = (TextView) convertView.findViewById(R.id.tvtitlenotemain);
            viewHolder.tvtimenotemain = (TextView) convertView.findViewById(R.id.tvtimenotemain);
            viewHolder.tvdesnotemain = (TextView) convertView.findViewById(R.id.tvdesnotemain);
            convertView.setTag(viewHolder);
//            Log.d(TAG, "getView: "+(position));

        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        ListNoteData contact = arrContact.get(position);
        viewHolder.tvtitlenotemain.setText(contact.getText());
        viewHolder.tvtimenotemain.setText(contact.getTime());
        viewHolder.tvdesnotemain.setText(String.valueOf(contact.getId()));

//        viewHolder.btndellistview.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

        return convertView;
    }
    public class ViewHolder{
        TextView tvtitlenotemain;
        TextView tvtimenotemain;
        TextView tvdesnotemain;
        Button btndeletemain;
    }
}