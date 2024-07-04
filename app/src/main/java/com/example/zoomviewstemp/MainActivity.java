package com.example.zoomviewstemp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: add temp from video: https://youtu.be/uZkEhUoAT18?si=hSHSZ3FIhoIMAjjW
 */

public class MainActivity extends AppCompatActivity {

    private Button zoomLayoutBtn, zoomLayoutImageViewBtn, touchImageViewBtn, photoViewBtn,
            zoomageBtn, zoomyBtn, selfMadeBtn, zoomTextViewBtn;
    public static final List<Integer> imageList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setReferences();
        setList();

        getSupportActionBar().hide();

        zoomLayoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), ZoomLayoutActivity.class));
            }
        });

        zoomLayoutImageViewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(getBaseContext(), ZoomLayoutImageViewActivity.class));
            }
        });

        touchImageViewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), TouchImageViewActivity.class));
            }
        });

        photoViewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), PhotoViewActivity.class));
            }
        });

        zoomageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), ZoomageActivity.class));
            }
        });

        zoomyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), ZoomyActivity.class));
            }
        });

        selfMadeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), SelfMadeActivity.class));
            }
        });

        zoomTextViewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), ZoomTextViewActivity.class));
            }
        });
    }

    private void setReferences() {
        zoomLayoutBtn = findViewById(R.id.zoom_layout_btn);
        zoomLayoutImageViewBtn = findViewById(R.id.zoom_layout_image_view_btn);
        touchImageViewBtn = findViewById(R.id.touch_image_view_btn);
        photoViewBtn = findViewById(R.id.photo_view_btn);
        zoomageBtn = findViewById(R.id.zoomage_btn);
        zoomyBtn = findViewById(R.id.zoomy_btn);
        selfMadeBtn = findViewById(R.id.self_made_btn);
        zoomTextViewBtn = findViewById(R.id.zoom_text_view_btn);
    }

    private void setList() {
        imageList.add(R.drawable.aprilia);
        imageList.add(R.drawable.hayabusa);
        imageList.add(R.drawable.honda_cbr_1000rr);
        imageList.add(R.drawable.ninja_h2r);
        imageList.add(R.drawable.suzuki);
        imageList.add(R.drawable.yamaha_r1m);
    }
}