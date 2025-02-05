package com.test.trabajou5listamultimedia;

public class Item {
    private String title;
    private int type; // 1: Video, 2: Audio, 3: Web
    private int id;   // Para distinguir entre los videos y audios
    private int imageResId; // ID de la imagen para cada item

    public Item(String title, int type, int id, int imageResId) {
        this.title = title;
        this.type = type;
        this.id = id;
        this.imageResId = imageResId;
    }

    public String getTitle() { return title; }
    public int getType() { return type; }
    public int getId() { return id; }
    public int getImageResId() { return imageResId; }
}


