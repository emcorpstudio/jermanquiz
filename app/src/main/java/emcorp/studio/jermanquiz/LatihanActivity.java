package emcorp.studio.jermanquiz;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import emcorp.studio.jermanquiz.Model.Latihan;

public class LatihanActivity extends AppCompatActivity {
    int pilihan;
    String hasil, opsi;
    int pos = -1;
    private List<Latihan> items = new ArrayList<>();
    Button btnJawab;
    ImageButton img;
    int soalke = 0;
    String opsidipilih = "";
    int jawabposisi = -1;
    String updatejawaban = "";
    String updatesoal = "";
    int[] listkosong;
    TextView tvSoal;
    int score = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latihan);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setTitle("Menu Latihan");
        img = (ImageButton)findViewById(R.id.img);
        btnJawab = (Button)findViewById(R.id.btnJawab);
        tvSoal = (TextView)findViewById(R.id.tvSoal);

        items.clear();
        items.add(new Latihan(R.drawable.keyboard,"T,A,_,T,_,T,_,R","S,A,U","TASTATUR"));
        items.add(new Latihan(R.drawable.computer,"_,_,M,P,U,_,_,R","C,O,T,E","COMPUTER"));
        items.add(new Latihan(R.drawable.mouse,"_,_,U,S","M,A","MAUS"));
        items.add(new Latihan(R.drawable.server,"S,_,_,V,_,R","E,R,E","SERVER"));
        items.add(new Latihan(R.drawable.printer,"D,_,_,C,K,_,R","R,U,E","DRUCKER"));
        items.add(new Latihan(R.drawable.scanner,"_,C,A,_,N,_,R","S,N,E","SCANNER"));
        items.add(new Latihan(R.drawable.laptop,"L,_,_,T,O,_","A,P,P","LAPTOP"));
        items.add(new Latihan(R.drawable.floppydisc,"_,I,_,K,E,_,T,E","D,S,T","DISKETTE"));
        items.add(new Latihan(R.drawable.cloud,"_,_,_,K,E","W,O,L","WOLKE"));
        items.add(new Latihan(R.drawable.festplatte,"_,E,_,T,_,_,_,T,T,E","F,S,P,L,A","FESTPLATTE"));

        soalke = 0;
        tampilSoal(soalke);

        btnJawab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                tampilSoal(soalke);
                if(answerall(updatejawaban)){
                    updatejawaban = updatejawaban.replaceAll(",","");
                    if(updatejawaban.equals(items.get(soalke).getjawaban())){
                        score = score + 10;
                    }
                    int maxsoal = items.size();
                    if(soalke<maxsoal-1){
                        soalke = soalke + 1;
                        listkosong = null;
                        tampilSoal(soalke);
                    }else{
//                        Toast.makeText(getApplicationContext(),"Selesai skor anda "+String.valueOf(score),Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(LatihanActivity.this,ScoreActivity.class);
                        i.putExtra("score",String.valueOf(score));
                        startActivity(i);
                        finish();
                    }
                }else{
                    Toast.makeText(getApplicationContext(),"Belum semua",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }



    public boolean answerall(String jawaban){
        boolean result = true;
        if(jawaban.indexOf("_")>=0){
            result = false;
        }
        return result;
    }

    public void showOpsi(String opsi){
        String teks = opsi;
        String[] teksArray = teks.split(",");
        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.loOpsi);
        linearLayout.removeAllViews();
        for(int i=0;i<teksArray.length;i++){
            final TextView valueTV = new TextView(this);
            valueTV.setText(teksArray[i]);
            valueTV.setTag(String.valueOf(i));
            valueTV.setGravity(Gravity.CENTER);
            valueTV.setTextSize(40);
            valueTV.setClickable(true);
            valueTV.setTypeface(valueTV.getTypeface(), Typeface.BOLD);
            valueTV.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f));

            valueTV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    Toast.makeText(getApplicationContext(),valueTV.getText(),Toast.LENGTH_SHORT).show();
                    opsidipilih = valueTV.getText().toString();
                }
            });

            linearLayout.addView(valueTV);
        }
    }

    public void showSoal(String soal){
        String teks = soal;
        final String[] teksArray = teks.split(",");
        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.loHasil);
        linearLayout.removeAllViews();
        for(int i=0;i<teksArray.length;i++){
            final TextView valueTV = new TextView(this);
            valueTV.setText(teksArray[i]);
            valueTV.setTag(String.valueOf(i));
            valueTV.setGravity(Gravity.CENTER);
            valueTV.setTextSize(40);
            valueTV.setClickable(true);
            String listkos = "";
            for(int j=0;j<listkosong.length;j++){
                listkos = listkos+String.valueOf(listkosong[j]);
            }
            if(findKosong(i)){
                valueTV.setTextColor(getResources().getColor(R.color.colorAccent));
            }
//            valueTV.setBackgroundResource(android.R.attr.selectableItemBackground);
            Log.d("CECEK",String.valueOf(i)+" - " + findKosong(i)+" in "+listkos+" from "+soal);
            valueTV.setTypeface(valueTV.getTypeface(), Typeface.BOLD);
            valueTV.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f));

            valueTV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    Toast.makeText(getApplicationContext(),valueTV.getText(),Toast.LENGTH_SHORT).show();
                    if(findKosong(Integer.valueOf(valueTV.getTag().toString()))){
                        if(opsidipilih.equals("")){
                            Toast.makeText(getApplicationContext(),"Pilih salah satu opsi terlebih dahulu!",Toast.LENGTH_SHORT).show();
                        }else{
                            jawabposisi = Integer.valueOf(valueTV.getTag().toString());
                            teksArray[jawabposisi] = opsidipilih;
//                            updatejawaban= String.join(",",teksArray);
                            updatejawaban = join(teksArray,0,",");
                            showSoal(updatejawaban);
                            opsidipilih = "";
                        }
                    }else{
                        Toast.makeText(getApplicationContext(),"Pilih pada bagian dengan warna merah!",Toast.LENGTH_SHORT).show();
                    }

                }
            });

            linearLayout.addView(valueTV);
        }
    }

    public static String join(String[] strings, int startIndex, String separator) {
        StringBuffer sb = new StringBuffer();
        for (int i=startIndex; i < strings.length; i++) {
            if (i != startIndex) sb.append(separator);
            sb.append(strings[i]);
        }
        return sb.toString();
    }

    public void tampilSoal(int nomor){
        tvSoal.setText(String.valueOf(nomor+1)+" / "+String.valueOf(items.size()));
        updatesoal= items.get(nomor).getopsi();
        updatejawaban = items.get(nomor).getsoal();
        String soaltanpakoma = updatesoal.replaceAll(",","");
        String jawabantanpakoma = updatejawaban.replaceAll(",","");
        listkosong = new int[soaltanpakoma.length()];
        int ke = 0;
        String listkos = "";
        for(int i=0;i<jawabantanpakoma.length();i++){
            String cek = Character.toString(jawabantanpakoma.charAt(i));
            if(cek.equals("_")){
                listkos = listkos+String.valueOf(i);
                listkosong[ke] = i ;
                ke = ke + 1;
            }
        }
        img.setBackgroundResource(items.get(nomor).getphoto());
        showOpsi(items.get(nomor).getopsi());
        showSoal(items.get(nomor).getsoal());
        Log.d("CEK",soaltanpakoma+" "+jawabantanpakoma+" - "+String.valueOf(soaltanpakoma.length())+" - "+listkos);

    }

    public boolean findKosong(int ke){
        boolean result = false;
        for(int i=0;i<listkosong.length;i++){
            if(listkosong[i]==ke){
                result = true;
                break;
            }
        }
        return result;
    }


    @Override
    public void onBackPressed() {
        Intent i = new Intent(LatihanActivity.this,MainActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home){
            Intent i = new Intent(LatihanActivity.this,MainActivity.class);
            startActivity(i);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
