package com.example.firebase;

public class Notes {

    private String title;
    private String text;
    private String tag;
    private boolean favorite;

    public Notes(String title, String text, String tag, boolean favorite) {
        this.title = title;
        this.text = text;
        this.tag = tag;
        this.favorite = favorite;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String getTag() {
        return tag;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }
}

