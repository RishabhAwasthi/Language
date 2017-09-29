package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;
    private MediaPlayer.OnCompletionListener completionListener = new MediaPlayer.OnCompletionListener(){
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);



                // Create a list of words
                final ArrayList<Word> words = new ArrayList<Word>();
                words.add(new Word("Hello", "O-la",R.raw.hello));
                words.add(new Word("Good morning", "Bway-nos Dee-as",R.raw.goodmorning));
                words.add(new Word("What is your name", "Commo te-ya-mas",R.raw.namewhat));
                words.add(new Word("My name is..", "Me nombre-es..",R.raw.myname));
                words.add(new Word("How are you feeling", "commo te-si-entes?",R.raw.howu));
                words.add(new Word("I'm feeling good", "mey-si-ento-bien",R.raw.good));
                words.add(new Word("Are you coming?", "Vienes?",R.raw.comingaa));
                words.add(new Word("Yes,I'm coming", "Si,voy para-aiya",R.raw.yescoming));
                words.add(new Word("I'm coming", "Ya voi",R.raw.coming));
                words.add(new Word("Lets go", "Vamonos",R.raw.letsgo));
                words.add(new Word("Come here", "ven-aka",R.raw.come));


                // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
                // adapter knows how to create list items for each item in the list.
                WordAdapter adapter = new WordAdapter(this, words);

                // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
                // There should be a {@link ListView} with the view ID called list, which is declared in the
                // word_list.xml layout file.
                ListView listView = (ListView) findViewById(R.id.list);

                // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
                // {@link ListView} will display list items for each {@link Word} in the list.
                listView.setAdapter(adapter);


                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                        // Get the {@link Word} object at the given position the user clicked on
                        Word word = words.get(position);
                        releaseMediaPlayer();

                        // Create and setup the {@link MediaPlayer} for the audio resource associated
                        // with the current word
                        mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, word.getAudioResourceId());

                        // Start the audio file
                        mMediaPlayer.start();
                        mMediaPlayer.setOnCompletionListener(completionListener);
                    }
                });
            }
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }
        }
