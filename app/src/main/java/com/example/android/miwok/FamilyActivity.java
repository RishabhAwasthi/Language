package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        // Create a list of words
       final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Father", "Padre",R.drawable.family_father,R.raw.father));
        words.add(new Word("mother", "Madre",R.drawable.family_mother,R.raw.mother));
        words.add(new Word("son", "Hijo",R.drawable.family_son,R.raw.son));
        words.add(new Word("daughter", "Hija",R.drawable.family_daughter,R.raw.daughter));
        words.add(new Word("brother", "Hermano",R.drawable.family_older_brother,R.raw.brother));
        words.add(new Word("sister", "Hermana",R.drawable.family_older_sister,R.raw.sister));
        words.add(new Word("grandfather", "Abuelo",R.drawable.family_grandfather,R.raw.grandfather));
        words.add(new Word("grandmother", "Abuela",R.drawable.family_grandmother,R.raw.grandmother));
        words.add(new Word("grandson ", "Nieto",R.drawable.family_younger_brother,R.raw.grandson));
        words.add(new Word("granddaughter", "Nieta",R.drawable.family_younger_sister,R.raw.granddaughter));



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
                mMediaPlayer = MediaPlayer.create(FamilyActivity.this, word.getAudioResourceId());

                // Start the audio file
                mMediaPlayer.start();
            }
        });
    }
}
