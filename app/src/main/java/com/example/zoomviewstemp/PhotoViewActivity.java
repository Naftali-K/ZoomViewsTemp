package com.example.zoomviewstemp;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.squareup.picasso.Picasso;

/**
 * https://github.com/Baseflow/PhotoView
 */

public class PhotoViewActivity extends AppCompatActivity {

    private Button updateBtn;
    private ImageView imageView;
    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_view);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setReferences();

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Picasso.get().load(R.drawable.aprilia).into(imageView);
                setImageView();
            }
        });
    }

    private void setReferences() {
        updateBtn = findViewById(R.id.update_btn);
        imageView = findViewById(R.id.image_view);
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