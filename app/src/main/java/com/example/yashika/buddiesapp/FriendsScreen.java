package com.example.yashika.buddiesapp;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class FriendsScreen extends AppCompatActivity {

    Toast toast;
    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;

    AudioManager.OnAudioFocusChangeListener changeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mMediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();
            }
        }
    };

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };

    @Override
    public void onStop() {
        super.onStop();
        // When the activity is stopped, release the media player resources because we won't
        // be playing any more sounds.
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
            mAudioManager.abandonAudioFocus(changeListener);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        if (toast != null) {
            toast.cancel();
        }
        toast = Toast.makeText(FriendsScreen.this, "Please increase volume!", Toast.LENGTH_SHORT);
        toast.show();

        //Creating an ArrayList for Songs
        final ArrayList<Profile> profiles = new ArrayList<Profile>();
        profiles.add(new Profile(getString(R.string.name1), getString(R.string.desc1), R.drawable.akshit));
        profiles.add(new Profile(getString(R.string.name2), getString(R.string.desc2), R.drawable.geetanjali));
        profiles.add(new Profile(getString(R.string.name3), getString(R.string.desc3), R.drawable.karthikeyan));
        profiles.add(new Profile(getString(R.string.name4), getString(R.string.desc4), R.drawable.lakshit));


        // Create an {@link ProfileAdapter}, whose data source is a list of {@link Profile}s. The
        // adapter knows how to create list items for each item in the list.
        ProfileAdapter adapter = new ProfileAdapter(FriendsScreen.this, profiles);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list_view, which is declared in the
        // activity_list.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list_view);

        // Make the {@link ListView} use the {@link ProfileAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Profile} in the list.
        listView.setAdapter(adapter);

        int result = mAudioManager.requestAudioFocus(changeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN);

        if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
            mMediaPlayer = MediaPlayer.create(FriendsScreen.this, R.raw.yaara);
            mMediaPlayer.start();
            mMediaPlayer.setOnCompletionListener(mCompletionListener);
        }

        Button dedic = (Button) findViewById(R.id.dedn);
        dedic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Create a new intent to open the {@link ListActivity} layout file
                Intent dednIntent = new Intent(FriendsScreen.this, DedActivity.class);
                //Start the new activity
                startActivity(dednIntent);
            }

        });

    }
}
