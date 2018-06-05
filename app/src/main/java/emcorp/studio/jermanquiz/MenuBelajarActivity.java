package emcorp.studio.jermanquiz;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import emcorp.studio.jermanquiz.Adapter.MenuBelajarAdapter;
import emcorp.studio.jermanquiz.Model.MenuBelajar;

public class MenuBelajarActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {
    private View view;
    private RecyclerView recyclerView;
    private List<MenuBelajar> items = new ArrayList<>();
    private MenuBelajarAdapter mAdapter;
    private Menu menu;
    private TextToSpeech tts;
    private int posTeks = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_belajar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setTitle("Menu Belajar");

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        tts = new TextToSpeech(this, this);

        items.clear();
        items.add(new MenuBelajar("Tastatur", R.drawable.keyboard));
        items.add(new MenuBelajar("Computer", R.drawable.computer));
        items.add(new MenuBelajar("Maus", R.drawable.mouse));
        items.add(new MenuBelajar("Server", R.drawable.server));
        items.add(new MenuBelajar("Computernetzwerk", R.drawable.network));
        items.add(new MenuBelajar("Drucker", R.drawable.printer));
        items.add(new MenuBelajar("Scanner", R.drawable.scanner));
        items.add(new MenuBelajar("Laptop", R.drawable.laptop));
        items.add(new MenuBelajar("Diskette", R.drawable.floppydisc));
        items.add(new MenuBelajar("Bluetooth", R.drawable.bluetooth));
        items.add(new MenuBelajar("Wolke", R.drawable.cloud));
        items.add(new MenuBelajar("Festplatte", R.drawable.festplatte));

        mAdapter = new MenuBelajarAdapter(MenuBelajarActivity.this, items);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(MenuBelajarActivity.this,3));
        mAdapter.setOnItemClickListener(new MenuBelajarAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, MenuBelajar obj, int position) {
                posTeks = position;
                speakOut();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(MenuBelajarActivity.this,MainActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home){
            Intent i = new Intent(MenuBelajarActivity.this,MainActivity.class);
            startActivity(i);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDestroy() {
        // Don't forget to shutdown tts!
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {

            int result = tts.setLanguage(Locale.GERMANY);

            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "This Language is not supported");
            } else {
                speakOut();
            }

        } else {
            Log.e("TTS", "Initilization Failed!");
        }
    }

    private void speakOut() {
        if(posTeks>=0){
            String text = items.get(posTeks).getDescription();
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
        }
    }
}
