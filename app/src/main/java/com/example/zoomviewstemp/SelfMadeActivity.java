package com.example.zoomviewstemp;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
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
 * https://youtu.be/Pa6JpRp1bCA?si=-1ie7pKt_75gHg0u
 */

public class SelfMadeActivity extends AppCompatActivity {

    private ImageView imageView;
    private Button updateBtn;

    private ScaleGestureDetector scaleGestureDetector;
    private float FACTOR = 1.0f;
    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self_made);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setReferences();

//        scaleGestureDetector = new ScaleGestureDetector(this, new ScaleListener());
        scaleGestureDetector = new ScaleGestureDetector(this, new ScaleGestureDetector.OnScaleGestureListener() {
            @Override
            public boolean onScale(@NonNull ScaleGestureDetector detector) {
                FACTOR *= detector.getScaleFactor();
                FACTOR = Math.max(0.1f, Math.min(FACTOR, 10.f));
                imageView.setScaleX(FACTOR);
                imageView.setScaleY(FACTOR);
//                return false;
                return true;
            }

            @Override
            public boolean onScaleBegin(@NonNull ScaleGestureDetector detector) {
                FACTOR *= detector.getScaleFactor();
                FACTOR = Math.max(0.1f, Math.min(FACTOR, 10.f));

                imageView.setScaleX(FACTOR);
                imageView.setScaleY(FACTOR);
//                return false;
                return true;
            }

            @Override
            public void onScaleEnd(@NonNull ScaleGestureDetector detector) {
                if (FACTOR < 1.0f) {
                    FACTOR = 1.0f;
                }

                imageView.setScaleX(FACTOR);
                imageView.setScaleY(FACTOR);
            }
        });

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setImageView();
                imageView.setScaleX(1.0f);
                imageView.setScaleY(1.0f);
            }
        });
    }

    private void setReferences() {
        imageView = findViewById(R.id.image_view);
        updateBtn = findViewById(R.id.update_btn);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        scaleGestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
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



    class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(@NonNull ScaleGestureDetector detector) {
            FACTOR *= detector.getScaleFactor();
            FACTOR = Math.max(0.1f, Math.min(FACTOR, 10.f));
            imageView.setScaleX(FACTOR);
            imageView.setScaleY(FACTOR);

//            return super.onScale(detector);
            return true;
        }
    }
}