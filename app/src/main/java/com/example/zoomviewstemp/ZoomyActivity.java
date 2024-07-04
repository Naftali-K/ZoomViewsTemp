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

import com.ablanco.zoomy.Zoomy;
import com.squareup.picasso.Picasso;

/**
 * https://github.com/imablanco/Zoomy
 *
 * https://www.youtube.com/watch?v=uVrea0MGmGE&ab_channel=TechProjects
 */

public class ZoomyActivity extends AppCompatActivity {

    private int index = 0;
    private ImageView imageView;
    private Button updateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoomy);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setReferences();

        Zoomy.Builder builder = new Zoomy.Builder(this).target(imageView);
        builder.register();

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setImageView();
            }
        });
    }

    private void setReferences() {
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