package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_numbers);

            // Create a list of words
           final ArrayList<Word> words = new ArrayList<Word>();
            words.add(new Word("red", "Rojo",R.drawable.color_red,R.raw.red));
            words.add(new Word("yellow", "Amarillo",R.drawable.color_mustard_yellow,R.raw.yellow));
            words.add(new Word("Dusty yellow", "Amarillo polvoriento",R.drawable.color_dusty_yellow,R.raw.dustyyellow));
            words.add(new Word("green", "Verde",R.drawable.color_green,R.raw.green));
            words.add(new Word("brown", "Marron",R.drawable.color_brown,R.raw.brown));
            words.add(new Word("gray", "Gris",R.drawable.color_gray,R.raw.gray));
            words.add(new Word("black", "Negro",R.drawable.color_black,R.raw.black));
            words.add(new Word("white", "Blanco",R.drawable.color_white,R.raw.white));


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

                    // Create and setup the {@link MediaPlayer} for the audio resource associated
                    // with the current word
                    mMediaPlayer = MediaPlayer.create(ColorsActivity.this, word.getAudioResourceId());

                    // Start the audio file
                    mMediaPlayer.start();
                }
            });
        }
    }
