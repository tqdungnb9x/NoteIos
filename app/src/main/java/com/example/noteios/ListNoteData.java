package com.example.noteios;

public class ListNoteData {

    int Id;
    String time;
    String text;
    byte[] image;

//    public ListNoteData(Integer id, String time, String text, byte[] image) {
//        Id = id;
//        this.time = time;
//        this.text = text;
//        this.image = image;
//    }

    public ListNoteData(String time, String text) {
        this.time = time;
        this.text = text;
    }

    public ListNoteData(int id, String text) {
        Id = id;
        this.text = text;
    }

    public ListNoteData(String time, String text, byte[] image) {
        this.time = time;
        this.text = text;
        this.image = image;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
