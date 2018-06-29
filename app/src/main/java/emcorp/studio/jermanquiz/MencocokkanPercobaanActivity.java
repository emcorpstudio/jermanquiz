package emcorp.studio.jermanquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import emcorp.studio.jermanquiz.Library.ButtonClick;
import emcorp.studio.jermanquiz.Model.MencocokkanPercobaan;

public class MencocokkanPercobaanActivity extends AppCompatActivity {
    TextView tv1, tv2, tv3, tv4, tv5;
    ImageButton btnImage1,btnImage2,btnImage3,btnImage4,btnImage5;
    int opsiText = 0;
    int opsiImg = 0;
    private List<MencocokkanPercobaan> items = new ArrayList<>();
    int jmlSoal = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mencocokkan_percobaan);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setTitle("Mencocokkan");
        tv1 = (TextView)findViewById(R.id.tv1);
        tv2 = (TextView)findViewById(R.id.tv2);
        tv3 = (TextView)findViewById(R.id.tv3);
        tv4 = (TextView)findViewById(R.id.tv4);
        tv5 = (TextView)findViewById(R.id.tv5);
        btnImage1 = (ImageButton)findViewById(R.id.btnImage1);
        btnImage2 = (ImageButton)findViewById(R.id.btnImage2);
        btnImage3 = (ImageButton)findViewById(R.id.btnImage3);
        btnImage4 = (ImageButton)findViewById(R.id.btnImage4);
        btnImage5 = (ImageButton)findViewById(R.id.btnImage5);

        items.clear();
        items.add(new MencocokkanPercobaan(R.drawable.keyboard,"Computer","Tastatur"));
        items.add(new MencocokkanPercobaan(R.drawable.network,"Diskette","Computernetzwerk"));
        items.add(new MencocokkanPercobaan(R.drawable.floppydisc,"Bluetooth","Diskette"));
        items.add(new MencocokkanPercobaan(R.drawable.bluetooth,"Computernetzwerk","Bluetooth"));
        items.add(new MencocokkanPercobaan(R.drawable.computer,"Tastatur","Computer"));

        jmlSoal = items.size();

        btnImage1.setImageResource(items.get(0).getphoto());
        btnImage2.setImageResource(items.get(1).getphoto());
        btnImage3.setImageResource(items.get(2).getphoto());
        btnImage4.setImageResource(items.get(3).getphoto());
        btnImage5.setImageResource(items.get(4).getphoto());

        tv1.setText(items.get(0).getopsi());
        tv2.setText(items.get(1).getopsi());
        tv3.setText(items.get(2).getopsi());
        tv4.setText(items.get(3).getopsi());
        tv5.setText(items.get(4).getopsi());

        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBackgroundOfTextview(1);
            }
        });
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBackgroundOfTextview(2);
            }
        });
        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBackgroundOfTextview(3);
            }
        });
        tv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBackgroundOfTextview(4);
            }
        });
        tv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBackgroundOfTextview(5);
            }
        });

        btnImage1.setOnTouchListener(new ButtonClick());
        btnImage2.setOnTouchListener(new ButtonClick());
        btnImage3.setOnTouchListener(new ButtonClick());
        btnImage4.setOnTouchListener(new ButtonClick());
        btnImage5.setOnTouchListener(new ButtonClick());

        btnImage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBackgroundOfImageButton(1);
            }
        });
        btnImage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBackgroundOfImageButton(2);
            }
        });
        btnImage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBackgroundOfImageButton(3);
            }
        });
        btnImage4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBackgroundOfImageButton(4);
            }
        });
        btnImage5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBackgroundOfImageButton(5);
            }
        });
    }

    public void setBackgroundOfTextview(int i){
        switch (i){
            case 1 :
                tv1.setBackgroundResource(R.drawable.box_line);
                tv2.setBackgroundResource(R.drawable.box_noline);
                tv3.setBackgroundResource(R.drawable.box_noline);
                tv4.setBackgroundResource(R.drawable.box_noline);
                tv5.setBackgroundResource(R.drawable.box_noline);
                break;
            case 2 :
                tv1.setBackgroundResource(R.drawable.box_noline);
                tv2.setBackgroundResource(R.drawable.box_line);
                tv3.setBackgroundResource(R.drawable.box_noline);
                tv4.setBackgroundResource(R.drawable.box_noline);
                tv5.setBackgroundResource(R.drawable.box_noline);
                break;
            case 3 :
                tv1.setBackgroundResource(R.drawable.box_noline);
                tv2.setBackgroundResource(R.drawable.box_noline);
                tv3.setBackgroundResource(R.drawable.box_line);
                tv4.setBackgroundResource(R.drawable.box_noline);
                tv5.setBackgroundResource(R.drawable.box_noline);
                break;
            case 4 :
                tv1.setBackgroundResource(R.drawable.box_noline);
                tv2.setBackgroundResource(R.drawable.box_noline);
                tv3.setBackgroundResource(R.drawable.box_noline);
                tv4.setBackgroundResource(R.drawable.box_line);
                tv5.setBackgroundResource(R.drawable.box_noline);
                break;
            case 5 :
                tv1.setBackgroundResource(R.drawable.box_noline);
                tv2.setBackgroundResource(R.drawable.box_noline);
                tv3.setBackgroundResource(R.drawable.box_noline);
                tv4.setBackgroundResource(R.drawable.box_noline);
                tv5.setBackgroundResource(R.drawable.box_line);
                break;
            case 0 :
                tv1.setBackgroundResource(R.drawable.box_noline);
                tv2.setBackgroundResource(R.drawable.box_noline);
                tv3.setBackgroundResource(R.drawable.box_noline);
                tv4.setBackgroundResource(R.drawable.box_noline);
                tv5.setBackgroundResource(R.drawable.box_noline);
                break;
        }
        opsiText = i;
        checkJawaban(opsiImg,opsiText);
    }

    public void setBackgroundOfImageButton(int i){
        switch (i){
            case 1 :
                btnImage1.setBackgroundResource(R.drawable.box_line);
                btnImage2.setBackgroundResource(R.drawable.box_noline);
                btnImage3.setBackgroundResource(R.drawable.box_noline);
                btnImage4.setBackgroundResource(R.drawable.box_noline);
                btnImage5.setBackgroundResource(R.drawable.box_noline);
                break;
            case 2 :
                btnImage1.setBackgroundResource(R.drawable.box_noline);
                btnImage2.setBackgroundResource(R.drawable.box_line);
                btnImage3.setBackgroundResource(R.drawable.box_noline);
                btnImage4.setBackgroundResource(R.drawable.box_noline);
                btnImage5.setBackgroundResource(R.drawable.box_noline);
                break;
            case 3 :
                btnImage1.setBackgroundResource(R.drawable.box_noline);
                btnImage2.setBackgroundResource(R.drawable.box_noline);
                btnImage3.setBackgroundResource(R.drawable.box_line);
                btnImage4.setBackgroundResource(R.drawable.box_noline);
                btnImage5.setBackgroundResource(R.drawable.box_noline);
                break;
            case 4 :
                btnImage1.setBackgroundResource(R.drawable.box_noline);
                btnImage2.setBackgroundResource(R.drawable.box_noline);
                btnImage3.setBackgroundResource(R.drawable.box_noline);
                btnImage4.setBackgroundResource(R.drawable.box_line);
                btnImage5.setBackgroundResource(R.drawable.box_noline);
                break;
            case 5 :
                btnImage1.setBackgroundResource(R.drawable.box_noline);
                btnImage2.setBackgroundResource(R.drawable.box_noline);
                btnImage3.setBackgroundResource(R.drawable.box_noline);
                btnImage4.setBackgroundResource(R.drawable.box_noline);
                btnImage5.setBackgroundResource(R.drawable.box_line);
                break;
            case 0 :
                btnImage1.setBackgroundResource(R.drawable.box_noline);
                btnImage2.setBackgroundResource(R.drawable.box_noline);
                btnImage3.setBackgroundResource(R.drawable.box_noline);
                btnImage4.setBackgroundResource(R.drawable.box_noline);
                btnImage5.setBackgroundResource(R.drawable.box_noline);
        }
        opsiImg = i;
        checkJawaban(opsiImg,opsiText);
    }

    public void checkJawaban(int opsiImg, int opsiText){
        if(opsiImg>0&&opsiText>0){
            TextView tv = null;
            ImageButton img = null;
            switch (opsiText){
                case 1:
                    tv = tv1;
                    break;
                case 2:
                    tv = tv2;
                    break;
                case 3:
                    tv = tv3;
                    break;
                case 4:
                    tv = tv4;
                    break;
                case 5:
                    tv = tv5;
                    break;
            }
            switch (opsiImg){
                case 1:
                    img = btnImage1;
                    break;
                case 2:
                    img = btnImage2;
                    break;
                case 3:
                    img = btnImage3;
                    break;
                case 4:
                    img = btnImage4;
                    break;
                case 5:
                    img = btnImage5;
                    break;
            }
            String kunci_jawaban = items.get(opsiImg-1).getjawaban();
            String jawaban_user = items.get(opsiText-1).getopsi();
            if(kunci_jawaban.toLowerCase().equals(jawaban_user.toLowerCase())){
                tv.setVisibility(View.INVISIBLE);
                img.setVisibility(View.INVISIBLE);
                opsiImg = 0;
                opsiText = 0;
                setBackgroundOfImageButton(0);
                setBackgroundOfTextview(0);
                jmlSoal = jmlSoal - 1;
                Toast.makeText(getApplicationContext(),"Benar",Toast.LENGTH_SHORT).show();
                if(jmlSoal <= 0){
                    Intent i = new Intent(MencocokkanPercobaanActivity.this,HomePercobaanActivity.class);
                    startActivity(i);
                    finish();
                }
            }else{
                opsiImg = 0;
                opsiText = 0;
                setBackgroundOfImageButton(0);
                setBackgroundOfTextview(0);
                Toast.makeText(getApplicationContext(),"Salah",Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(MencocokkanPercobaanActivity.this,HomePercobaanActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home){
            Intent i = new Intent(MencocokkanPercobaanActivity.this,HomePercobaanActivity.class);
            startActivity(i);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
