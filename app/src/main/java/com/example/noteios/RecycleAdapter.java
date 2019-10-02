//package com.example.noteios;
//
//import android.content.Context;
//import android.support.annotation.NonNull;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import java.util.ArrayList;
//
//public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {
//
//    ArrayList<ListNoteData> listNoteData;
//    Context context;
//
//    public RecycleAdapter(ArrayList<ListNoteData> listNoteData, Context context) {
//        this.listNoteData = listNoteData;
//        this.context = context;
//    }
//
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
//        View itemView = layoutInflater.inflate(R.layout.roll_item,viewGroup,false);
//        return new ViewHolder(itemView);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
//        viewHolder.tvtitlenotemain.setText(listNoteData.get(i).getText0());
//        viewHolder.tvtimenotemain.setText(listNoteData.get(i).getTimenote());
//        viewHolder.tvdesnotemain.setText(listNoteData.get(i).getText1());
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return listNoteData.size();
//    }
//
//    public class ViewHolder extends  RecyclerView.ViewHolder{
//
//        TextView tvtitlenotemain;
//        TextView tvtimenotemain;
//        TextView tvdesnotemain;
//
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//            tvtitlenotemain = (TextView)itemView.findViewById(R.id.tvtitlenotemain);
//            tvtimenotemain = (TextView)itemView.findViewById(R.id.tvtimenotemain);
//            tvdesnotemain = (TextView)itemView.findViewById(R.id.tvdesnotemain);
//        }
//    }
//}
