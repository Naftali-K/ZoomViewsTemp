package com.example.zoomviewstemp;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zoomviewstemp.adapters.ZoomLayoutRecyclerViewAdapter;
import com.otaliastudios.zoom.ZoomLayout;
import com.squareup.picasso.Picasso;

/**
 * https://github.com/natario1/ZoomLayout
 */

public class ZoomLayoutActivity extends AppCompatActivity {

//    private RecyclerView recyclerView;
//    private ZoomLayoutRecyclerViewAdapter adapter;
    private int index = 0;
    private ZoomLayout zoomLayout;
    private ImageView imageView;
    private Button updateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoom_layout);
        setReferences();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        adapter = new ZoomLayoutRecyclerViewAdapter(MainActivity.imageList);
//        recyclerView.setAdapter(adapter);

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setImageView();
//                zoomLayout.realZoomTo(1.0f, true);
                zoomLayout.zoomTo(1.0f, false);
            }
        });

    }

    private void setReferences() {
//        recyclerView = findViewById(R.id.recyclerView);
        zoomLayout = findViewById(R.id.zoom_layout);
        imageView = findViewById(R.id.image_view);
        updateBtn = findViewById(R.id.update_btn);
    }

    private void setImageView() {
        if (index >= MainActivity.imageList.size()) {
            index = 0;
        }

        Picasso.get().load(MainActivity.imageList.get(index)).into(imageView);

        index ++;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}