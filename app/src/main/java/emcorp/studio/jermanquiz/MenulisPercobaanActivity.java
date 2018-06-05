package emcorp.studio.jermanquiz;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import emcorp.studio.jermanquiz.Library.ButtonClick;
import emcorp.studio.jermanquiz.Model.MelihatPercobaan;
import emcorp.studio.jermanquiz.Model.MenuBelajar;

public class MenulisPercobaanActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {
    private List<MenuBelajar> items = new ArrayList<>();
    ImageButton btnSound, img_1;
    private TextToSpeech tts;
    private int posTeks = -1;
    String jawabanUser = "";
    TextView tvNumber;
    EditText edtJawaban;
    Button btnJawaban;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menulis_percobaan);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setTitle("Menulis");

        btnSound = (ImageButton)findViewById(R.id.btnSound);
        img_1 = (ImageButton)findViewById(R.id.img_1);
        btnJawaban = (Button)findViewById(R.id.btnJawab);
        edtJawaban = (EditText)findViewById(R.id.edtJawaban);
        tvNumber = (TextView) findViewById(R.id.tvNumber);

        tts = new TextToSpeech(this, this);

        btnSound.setOnTouchListener(new ButtonClick());
        img_1.setOnTouchListener(new ButtonClick());

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

        posTeks = 0;
        tampilSoal();

        btnSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                speakOut();
            }
        });

        btnJawaban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jawabanUser = edtJawaban.getText().toString().toLowerCase();
                process();
            }
        });

    }

    public void process(){
        if(items.get(posTeks).getDescription().toLowerCase().equals(jawabanUser)){
            edtJawaban.setText("");
            if(posTeks<items.size()-1){
                posTeks = posTeks + 1;
                tampilSoal();
            }else{
                Intent i = new Intent(MenulisPercobaanActivity.this,MelihatPercobaan.class);
                startActivity(i);
                finish();
            }
        }else{
            Toast.makeText(getApplicationContext(),"Salah!",Toast.LENGTH_SHORT).show();
        }
    }

    public void tampilSoal(){
        img_1.setImageDrawable(getResources().getDrawable(items.get(posTeks).getPhoto()));
        tvNumber.setText("Nummer " + String.valueOf(posTeks+1));
        speakOut();
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

    @Override
    public void onBackPressed() {
        Intent i = new Intent(MenulisPercobaanActivity.this,HomePercobaanActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home){
            Intent i = new Intent(MenulisPercobaanActivity.this,HomePercobaanActivity.class);
            startActivity(i);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
