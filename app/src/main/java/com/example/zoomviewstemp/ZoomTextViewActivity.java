package com.example.zoomviewstemp;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/**
 * https://youtu.be/h1PjJdVYUh4?si=A9vDNB4Dai1XVq8s
 */

public class ZoomTextViewActivity extends AppCompatActivity implements View.OnTouchListener {

    private TextView zoomTextView;
    private Button updateBtn;

    private static final float move = 200;
    private float ratio = 1.0f;
    private int baseDist;
    private float baseRatio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoom_text_view);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setReferences();

        zoomTextView.setTextSize(ratio + 15);


        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zoomTextView.setText("Updated text for zoom");
            }
        });
    }

    private void setReferences() {
        zoomTextView = findViewById(R.id.zoom_text_view);
        updateBtn = findViewById(R.id.update_btn);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
//        return super.onTouchEvent(event);
        if (event.getPointerCount() == 2) {
            int action = event.getAction();
            int mainAction = action&MotionEvent.ACTION_MASK;
            if (mainAction == MotionEvent.ACTION_POINTER_DOWN) {
                baseDist = getDistance(event);
                baseRatio = ratio;
            } else {
                float scale = (getDistance(event) - baseDist) / move;
                float factor = (float) Math.pow(2, scale);
                ratio = Math.min(1024.0f, Math.max(0.1f, baseRatio*factor));
                zoomTextView.setTextSize(ratio + 15);
            }
        }
        return true;
    }

    private int getDistance(MotionEvent event) {
        int dx = (int) (event.getX(0) - event.getX(1));
        int dy = (int) (event.getY(0) - event.getY(1));
        return (int) (Math.sqrt(dx*dx+dy*dy));
    }
}