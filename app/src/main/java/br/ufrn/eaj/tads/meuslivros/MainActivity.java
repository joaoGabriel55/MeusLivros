package br.ufrn.eaj.tads.meuslivros;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void cadastrar(View v){
        startActivity(new Intent(this, Main2Activity.class));
    }

    public void listar(View v){
        startActivity(new Intent(this, Main3Activity.class));
    }


}
