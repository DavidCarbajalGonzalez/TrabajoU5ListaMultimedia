package com.test.trabajou5listamultimedia;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ItemAdapter adapter;
    private List<Item> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        itemList = new ArrayList<>();
        itemList.add(new Item("Noria", 1, 1, R.drawable.ic_video));
        itemList.add(new Item("Bajada de montaña", 1, 2, R.drawable.ic_video));
        itemList.add(new Item("Música", 2, 1, R.drawable.ic_audio));
        itemList.add(new Item("Música", 2, 2, R.drawable.ic_audio));
        itemList.add(new Item("Voz de Galicia", 3, 1, R.drawable.ic_web_voz));
        itemList.add(new Item("Twitch", 3, 2, R.drawable.ic_web_twitch));

        adapter = new ItemAdapter(itemList, item -> {
            MediaDialog dialog = MediaDialog.newInstance(item.getType(), item.getId());
            dialog.show(getSupportFragmentManager(), "mediaDialog");
        });

        recyclerView.setAdapter(adapter);
    }
}

