package com.example.zoomviewstemp;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.ortiz.touchview.TouchImageView;
import com.squareup.picasso.Picasso;

/**
 * https://github.com/MikeOrtiz/TouchImageView
 *
 * https://youtu.be/8SCXPnECFNQ?si=Hv4IHzPEf0aCxk4Q
 * https://youtu.be/M-30yZ3AGp0?si=h4s-R3cfvooZKRhY
 */

public class TouchImageViewActivity extends AppCompatActivity {
    private static final String TAG = "Test_code";

    private TouchImageView touchImageView;
    private Button updateBtn;
    private float initialZoom = 1.0f;
    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_image_view);
        setReferences();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        touchImageView.setOnTouchImageViewListener(new TouchImageView.OnTouchImageViewListener() {
            @Override
            public void onMove() {
//                Log.d(TAG, "onMove: Moving zoom icon");
            }
        });

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setImageView();
                touchImageView.setZoom(1.0f);
            }
        });
    }

    private void setReferences() {
        touchImageView = findViewById(R.id.touch_image_view);
        updateBtn = findViewById(R.id.update_btn);
    }

    private void setImageView() {
        if (index >= MainActivity.imageList.size()) {
            index = 0;
        }

        Picasso.get().load(MainActivity.imageList.get(index)).into(touchImageView);

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