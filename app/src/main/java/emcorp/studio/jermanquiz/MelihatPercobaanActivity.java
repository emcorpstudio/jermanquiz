package emcorp.studio.jermanquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import emcorp.studio.jermanquiz.Library.ButtonClick;
import emcorp.studio.jermanquiz.Model.MelihatPercobaan;

public class MelihatPercobaanActivity extends AppCompatActivity {
    private List<MelihatPercobaan> items = new ArrayList<>();
    ImageButton img_1;
    private int posTeks = -1;
    String jawabanUser = "";
    TextView tvNumber;
    Button btnJawabA,btnJawabB,btnJawabC,btnJawabD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_melihat_percobaan);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setTitle("Menulis");

        img_1 = (ImageButton)findViewById(R.id.img_1);
        btnJawabA = (Button)findViewById(R.id.btnJawabA);
        btnJawabB = (Button)findViewById(R.id.btnJawabB);
        btnJawabC = (Button)findViewById(R.id.btnJawabC);
        btnJawabD = (Button)findViewById(R.id.btnJawabD);
        tvNumber = (TextView) findViewById(R.id.tvNumber);

        img_1.setOnTouchListener(new ButtonClick());

        items.clear();
        items.add(new MelihatPercobaan(R.drawable.keyboard,"Tastatur","Computernetzwerk","Server","Maus","A"));
        items.add(new MelihatPercobaan(R.drawable.computer,"Server","Computer","Maus","Diskette","B"));
        items.add(new MelihatPercobaan(R.drawable.mouse,"Computernetzwerk","Diskette","Server","Maus","D"));
        items.add(new MelihatPercobaan(R.drawable.server,"Maus","Diskette","Server","Festplatte","C"));
        items.add(new MelihatPercobaan(R.drawable.network,"Computernetzwerk","Festplatte","Maus","Diskette","A"));
        items.add(new MelihatPercobaan(R.drawable.printer,"Maus","Drucker","Computernetzwerk","Festplatte","B"));
        items.add(new MelihatPercobaan(R.drawable.scanner,"Computernetzwerk","Server","Maus","Scanner","D"));
        items.add(new MelihatPercobaan(R.drawable.laptop,"Festplatte","Maus","Laptop","Diskette","C"));
        items.add(new MelihatPercobaan(R.drawable.floppydisc,"Diskette","Server","Maus","Computernetzwerk","A"));
        items.add(new MelihatPercobaan(R.drawable.bluetooth,"Bluetooth","Computernetzwerk","Diskette","Festplatte","A"));
//        items.add(new MelihatPercobaan(R.drawable.cloud,"Computernetzwerk","Maus","Wolke","Diskette","C"));
//        items.add(new MelihatPercobaan(R.drawable.festplatte,"Server","Festplatte","Maus","Computernetzwerk","B"));

        posTeks = 0;
        tampilSoal();

        btnJawabA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jawabanUser = "A";
                process();
            }
        });

        btnJawabB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jawabanUser = "B";
                process();
            }
        });

        btnJawabC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jawabanUser = "C";
                process();
            }
        });

        btnJawabD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jawabanUser = "D";
                process();
            }
        });

    }

    public void process(){
        if(items.get(posTeks).getjawaban().toUpperCase().equals(jawabanUser)){
            if(posTeks<items.size()-1){
                posTeks = posTeks + 1;
                tampilSoal();
            }else{
                Intent i = new Intent(MelihatPercobaanActivity.this,HomePercobaanActivity.class);
                startActivity(i);
                finish();
            }
        }else{
            Toast.makeText(getApplicationContext(),"Salah!",Toast.LENGTH_SHORT).show();
        }
    }

    public void tampilSoal(){
        img_1.setImageDrawable(getResources().getDrawable(items.get(posTeks).getphoto()));
        btnJawabA.setText("A. "+items.get(posTeks).getopsi_a());
        btnJawabB.setText("B. "+items.get(posTeks).getopsi_b());
        btnJawabC.setText("C. "+items.get(posTeks).getopsi_c());
        btnJawabD.setText("D. "+items.get(posTeks).getopsi_d());
        tvNumber.setText("Nummer " + String.valueOf(posTeks+1));
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(MelihatPercobaanActivity.this,HomePercobaanActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home){
            Intent i = new Intent(MelihatPercobaanActivity.this,HomePercobaanActivity.class);
            startActivity(i);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
