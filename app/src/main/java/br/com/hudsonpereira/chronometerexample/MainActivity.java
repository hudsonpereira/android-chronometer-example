package br.com.hudsonpereira.chronometerexample;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;

// https://developer.android.com/reference/android/widget/Chronometer

// Counts only when started
// https://stackoverflow.com/questions/42006181/chronometer-is-still-running-after-calling-stop

public class MainActivity extends AppCompatActivity {

    Chronometer chronometer;

    long timeWhenStopped;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chronometer = findViewById(R.id.chronometer);
        chronometer.setBase(SystemClock.elapsedRealtime());
    }

    public void onClickStartHandler(View view) {
        chronometer.setBase(SystemClock.elapsedRealtime() + timeWhenStopped);
        chronometer.start();
    }

    public void OnClickStopHandler(View view) {
        chronometer.stop();
        timeWhenStopped = chronometer.getBase() - SystemClock.elapsedRealtime();
    }
}
