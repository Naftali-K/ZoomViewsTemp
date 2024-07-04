package com.example.zoomviewstemp;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.jsibbold.zoomage.ZoomageView;
import com.squareup.picasso.Picasso;

/**
 * https://github.com/jsibbold/zoomage
 */

public class ZoomageActivity extends AppCompatActivity {

    private int index = 0;
    private ZoomageView zoomageView;
    private Button updateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoomage);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setReferences();

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setImageView();
            }
        });
    }

    private void setReferences() {
        zoomageView = findViewById(R.id.zoomage_view);
        updateBtn = findViewById(R.id.update_btn);
    }

    private void setImageView() {
        if (index >= MainActivity.imageList.size()) {
            index = 0;
        }

        Picasso.get().load(MainActivity.imageList.get(index)).into(zoomageView);

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