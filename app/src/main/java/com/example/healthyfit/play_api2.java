package com.example.healthyfit;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class play_api2 extends YouTubeBaseActivity {
    private Intent intent;
    private int number;
    private String name;

    YouTubePlayerView playerView;
    YouTubePlayer player;

    private  static String API_KEY = "A본인의 API";
    private  static String videoId = "";

    private  static final String TAG = "player";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player2);

        intent = getIntent();
        number = intent.getIntExtra("number", -1);

        initPlayer();

        Button btnPlay = findViewById(R.id.youtubeBtn2);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playVideo();
            }
        });
    }

    private  void playVideo() {
        if(player != null) {
            if(player.isPlaying()) {
                player.pause();
            }
            switch(number) {
                case 0:
                    videoId = "CYcLODSeC-c";
                    break;
                case 1 :
                    videoId = "2pLT-olgUJs";
                    break;
                case 2:
                    videoId = "0L5gAT1fJaM";
                    break;
                case 3 :
                    videoId = "Kymv9On2";
                    break;
                case 4:
                    videoId = "T-bVqdhqW2U";
                    break;
            }
            player.cueVideo(videoId);
        }
    }



    private void initPlayer() {
        playerView = findViewById(R.id.youTubePlayerView2);
        playerView.initialize(API_KEY, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                player = youTubePlayer;

                player.setPlayerStateChangeListener(new YouTubePlayer.PlayerStateChangeListener() {
                    @Override
                    public void onLoading() {

                    }

                    @Override
                    public void onLoaded(String id) {
                        Log.d(TAG, "onLoaded: " + id);
                        player.play();
                    }

                    @Override
                    public void onAdStarted() {

                    }

                    @Override
                    public void onVideoStarted() {

                    }

                    @Override
                    public void onVideoEnded() {

                    }

                    @Override
                    public void onError(YouTubePlayer.ErrorReason errorReason) {
                        Log.d(TAG, "onError: " + errorReason);
                    }
                });
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }


        });
    }
}
