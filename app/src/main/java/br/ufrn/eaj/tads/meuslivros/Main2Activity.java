package br.ufrn.eaj.tads.meuslivros;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import banco.BancoHelper;
import modelo.Livro;

public class Main2Activity extends AppCompatActivity {

    BancoHelper bancoHelper = new BancoHelper(this);
    Livro livro = new Livro();
    EditText titulo;
    EditText autor;
    EditText ano;
    RatingBar nota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        titulo = (EditText) findViewById(R.id.editText);
        autor = (EditText) findViewById(R.id.editText2);
        ano = (EditText) findViewById(R.id.editText3);
        nota = (RatingBar) findViewById(R.id.ratingBar);

    }

    public void salvar(View v){

        livro.setTitulo(titulo.getText().toString());
        livro.setAutor(autor.getText().toString());
        livro.setAno(autor.getText().toString());
        livro.setNota(nota.getRating());

        bancoHelper.save(livro);


        Toast.makeText(this, "Livro Salvo com sucesso", Toast.LENGTH_SHORT).show();
        finish();
    }


    public void cancelar(View v){
        Snackbar snackbar = Snackbar.make((View) v.getParent(), "Clique em cancelar", Snackbar.LENGTH_SHORT).setAction("Cancelar", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Main2Activity.this, "Cancelou", Toast.LENGTH_SHORT).show();

                finish();
            }

        });

        snackbar.show();

    }


}
