package emcorp.studio.jermanquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomePercobaanActivity extends AppCompatActivity {
    Button btnMendengarkan, btnMenulis, btnMelihat, btnMencocokkan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_percobaan);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setTitle("Menu Percobaan");

        btnMendengarkan = (Button)findViewById(R.id.btnMendengarkan);
        btnMenulis = (Button)findViewById(R.id.btnMenulis);
        btnMelihat = (Button)findViewById(R.id.btnMelihat);
        btnMencocokkan = (Button)findViewById(R.id.btnMencocokkan);

        btnMendengarkan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomePercobaanActivity.this,MendengarkanPercobaanActivity.class);
                startActivity(i);
                finish();
            }
        });

        btnMenulis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomePercobaanActivity.this,MenulisPercobaanActivity.class);
                startActivity(i);
                finish();
            }
        });

        btnMelihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomePercobaanActivity.this,MelihatPercobaanActivity.class);
                startActivity(i);
                finish();
            }
        });

        btnMencocokkan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Coming soon",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(HomePercobaanActivity.this,MainActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home){
            Intent i = new Intent(HomePercobaanActivity.this,MainActivity.class);
            startActivity(i);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
