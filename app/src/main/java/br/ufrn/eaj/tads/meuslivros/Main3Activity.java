package br.ufrn.eaj.tads.meuslivros;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import banco.BancoHelper;
import modelo.Livro;

public class Main3Activity extends AppCompatActivity {

    private TextView titulo;
    private TextView autor;
    private TextView ano;
    private TextView nota;

    private List<Livro> lista;
    private int livroAtual = -1;
    //ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        //layout = (ConstraintLayout) findViewById(R.id.);

        BancoHelper bancoHelper = new BancoHelper(this);

        titulo = (TextView) findViewById(R.id.titulo);
        autor = (TextView) findViewById(R.id.autor);
        ano = (TextView) findViewById(R.id.ano);
        nota = (TextView) findViewById(R.id.nota);

        lista = bancoHelper.findAll();

        for (int i = 0; i < lista.size(); i++){
            if(i == 0){
                atualizarParametros(i);
                livroAtual = 0;
            }
        }
    }

    private void atualizarParametros(int i){
        titulo.setText(lista.get(i).getTitulo());
        autor.setText(lista.get(i).getAutor());
        ano.setText(lista.get(i).getAno());
        nota.setText(String.valueOf(lista.get(i).getNota()));
    }

    public void proximo(View v){
        if(livroAtual == lista.size() -1 ){
            Snackbar snackbar = Snackbar.make((View) v.getParent(), "Ultimo registro", Snackbar.LENGTH_SHORT);
            snackbar.show();
        } else {
            atualizarParametros(livroAtual + 1);
            livroAtual ++;
        }
    }

    public void anterior(View v){
        if(livroAtual == 0 ){
            Snackbar snackbar = Snackbar.make((View) v.getParent(), "Primeiro registro", Snackbar.LENGTH_SHORT);
            snackbar.show();
        } else {
            atualizarParametros(livroAtual - 1);
            livroAtual --;
        }
    }
}
