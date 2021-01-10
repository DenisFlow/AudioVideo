package com.example.audiovidio;

import androidx.appcompat.app.AppCompatActivity;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnPlay, btnStop, btnPause;
    MediaPlayer player;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStop = findViewById(R.id.buttonStopMusic);
        btnPlay = findViewById(R.id.buttonPlayMusic);
        btnPause = findViewById(R.id.buttonPauseMusic);

        btnPlay.setOnClickListener(MainActivity.this);
        btnStop.setOnClickListener(MainActivity.this);
        btnPause.setOnClickListener(MainActivity.this);

        player = MediaPlayer.create(this, R.raw.music);

    }

    @Override
    public void onClick(View buttView) {

        switch (buttView.getId()){
            case R.id.buttonPlayMusic:
                player.start();
                break;
            case R.id.buttonStopMusic:
                if (player != null) {
                    player.pause();
                }
                break;
            case R.id.buttonPauseMusic:
                player.stop();
                player.release();
                player = null;
                break;
        }

    }
}