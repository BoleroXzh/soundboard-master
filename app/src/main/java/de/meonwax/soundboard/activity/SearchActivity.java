package de.meonwax.soundboard.activity;

import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import de.meonwax.soundboard.R;
import de.meonwax.soundboard.sound.Sound;
import de.meonwax.soundboard.sound.SoundAdapter;
import de.meonwax.soundboard.activity.MainActivity;

public class SearchActivity extends AppCompatActivity {

    private List<Sound> sounds2;
    private SoundPool soundPool2;
    private SoundAdapter soundAdapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        // Show action bar to allow user to navigate back
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        init();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }

    public void searchmusic(View view) {
        init();
        EditText editText = (EditText) findViewById(R.id.searchtext);
        String message = editText.getText().toString();
        for (int i = 0; i < MainActivity.sounds.size(); i++) {
            String name = MainActivity.sounds.get(i).getName();
            if (name.contains(message)) {
                sounds2.add(MainActivity.sounds.get(i));
            }
        }
    }

    private void init() {
        soundPool2 = MainActivity.soundPool;
        sounds2 = new ArrayList<>();
        soundAdapter2 = new SoundAdapter(this, sounds2);
        ListView soundList = (ListView) findViewById(R.id.sound_list2);
        soundList.setAdapter(soundAdapter2);
    }
}
