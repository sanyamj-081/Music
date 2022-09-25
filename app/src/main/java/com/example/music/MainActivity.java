package com.example.music;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    AudioManager audioManager;
    public void play(View view) {
        mediaPlayer.start();
    }public void pause(View view) {
        mediaPlayer.pause();
    }public void stop(View view) {
        mediaPlayer.stop();
    }
        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            mediaPlayer=MediaPlayer.create(this, R.raw.music);

            audioManager =(AudioManager) getSystemService(Context.AUDIO_SERVICE);
            int maxVol= audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
            int curVol= audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
            SeekBar seekVol= findViewById(R.id.seekVol);
            seekVol.setMax(maxVol);
            seekVol.setProgress(curVol);

            seekVol.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                    audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });

            SeekBar progress= findViewById(R.id.progress);
            progress.setMax(mediaPlayer.getDuration());

            progress.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int i, boolean fromUser) {
                    mediaPlayer.seekTo(i);
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });


        }
    }
