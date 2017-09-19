package com.oakley8sam.samotinyapp2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.TimePicker;


import java.sql.Time;

public class SecondScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TimePicker estClock = (TimePicker) findViewById(R.id.EstClock);
        TimePicker pstClock = (TimePicker) findViewById(R.id.PstClock);

        pstClock.setHour(estClock.getHour() - 3);
        if (pstClock.getHour() < 24)
            pstClock.setHour(pstClock.getHour() + 24);
        final TextView barFeedback = (TextView) findViewById(R.id.barFeedback);

        final SeekBar sb1 = (SeekBar) findViewById(R.id.seekbar1);

        sb1.setOnSeekBarChangeListener((new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                barFeedback.setText("Current Progress: " + sb1.getProgress());
                if(sb1.getProgress() == 100){
                    startActivity(new Intent(SecondScreen.this, MainActivity.class));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //unused, override required to suppress warnings
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //unused, override required to suppress warnings
            }
        }));
    }
}
