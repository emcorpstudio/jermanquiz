package emcorp.studio.jermanquiz;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import emcorp.studio.jermanquiz.Library.ButtonClick;
import emcorp.studio.jermanquiz.Model.MendengarkanPercobaan;

public class MendengarkanPercobaanActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {
    private List<MendengarkanPercobaan> items = new ArrayList<>();
    ImageButton btnSound, img_1, img_2;
    private TextToSpeech tts;
    private int posTeks = -1;
    String jawabanUser = "";
    TextView tvNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mendengarkan_percobaan);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setTitle("Mendengarkan");

        btnSound = (ImageButton)findViewById(R.id.btnSound);
        img_1 = (ImageButton)findViewById(R.id.img_1);
        img_2 = (ImageButton)findViewById(R.id.img_2);
        tvNumber = (TextView) findViewById(R.id.tvNumber);

        tts = new TextToSpeech(this, this);

        btnSound.setOnTouchListener(new ButtonClick());
        img_1.setOnTouchListener(new ButtonClick());
        img_2.setOnTouchListener(new ButtonClick());

        items.clear();
        items.add(new MendengarkanPercobaan("Tastatur", R.drawable.floppydisc, R.drawable.keyboard, "B"));
        items.add(new MendengarkanPercobaan("Computer", R.drawable.computer, R.drawable.server,"A"));
        items.add(new MendengarkanPercobaan("Maus", R.drawable.mouse, R.drawable.floppydisc,"A"));
        items.add(new MendengarkanPercobaan("Server", R.drawable.bluetooth, R.drawable.server,"B"));
        items.add(new MendengarkanPercobaan("Computernetzwerk", R.drawable.network, R.drawable.scanner,"A"));
        items.add(new MendengarkanPercobaan("Drucker", R.drawable.printer, R.drawable.computer,"A"));
        items.add(new MendengarkanPercobaan("Scanner", R.drawable.network, R.drawable.scanner, "B"));
        items.add(new MendengarkanPercobaan("Laptop", R.drawable.computer, R.drawable.laptop, "B"));
        items.add(new MendengarkanPercobaan("Diskette", R.drawable.floppydisc, R.drawable.server, "A"));
        items.add(new MendengarkanPercobaan("Bluetooth", R.drawable.bluetooth, R.drawable.network, "A"));

        posTeks = 0;
        tampilSoal();

        btnSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                speakOut();
            }
        });

        img_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jawabanUser = "A";
                process();
            }
        });

        img_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jawabanUser = "B";
                process();
            }
        });

    }

    public void process(){
        if(items.get(posTeks).getJawaban().equals(jawabanUser)){
            if(posTeks<items.size()-1){
                posTeks = posTeks + 1;
                tampilSoal();
            }else{
                Intent i = new Intent(MendengarkanPercobaanActivity.this,HomePercobaanActivity.class);
                startActivity(i);
                finish();
            }
        }else{
            Toast.makeText(getApplicationContext(),"Salah!",Toast.LENGTH_SHORT).show();
        }
    }

    public void tampilSoal(){
        img_1.setImageDrawable(getResources().getDrawable(items.get(posTeks).getPhoto_1()));
        img_2.setImageDrawable(getResources().getDrawable(items.get(posTeks).getPhoto_2()));
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
        Intent i = new Intent(MendengarkanPercobaanActivity.this,HomePercobaanActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home){
            Intent i = new Intent(MendengarkanPercobaanActivity.this,HomePercobaanActivity.class);
            startActivity(i);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
