package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("One","Uno",R.drawable.number_one,R.raw.one));
        words.add(new Word("Two","Dos",R.drawable.number_two,R.raw.two));
        words.add(new Word("Three","Tres",R.drawable.number_three,R.raw.three));
        words.add(new Word("Four","Cautro",R.drawable.number_four,R.raw.four));
        words.add(new Word("Five","Cinco",R.drawable.number_five,R.raw.five));
        words.add(new Word("Six","seis",R.drawable.number_six,R.raw.six));
        words.add(new Word("Seven","Siete",R.drawable.number_seven,R.raw.seven));
        words.add(new Word("Eight","Ocho",R.drawable.number_eight,R.raw.eight));
        words.add(new Word("Nine","Nueve",R.drawable.number_nine,R.raw.nine));
        words.add(new Word("Ten","Diez", R.drawable.number_ten,R.raw.ten));


        WordAdapter itemsAdapter = new WordAdapter(this,words);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the {@link Word} object at the given position the user clicked on
                Word word = words.get(position);

                // Create and setup the {@link MediaPlayer} for the audio resource associated
                // with the current word
                mMediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getAudioResourceId());

                // Start the audio file
                mMediaPlayer.start();
            }
        });




    }
}
