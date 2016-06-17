package trucco.com.br.locadorafilmes;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.view.View;

/**
 * Created by iori_ on 14/06/2016.
 */
public class DetalheFilmeActivity extends Activity{

    private Filme filme;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalhe_filme);

        filme = (Filme) getIntent().getExtras().getSerializable("filme");


        ((TextView)findViewById(R.id.categoriaTextView)).setText("Categoria: " + filme.getCategoria());
        ((TextView)findViewById(R.id.nomeTextView)).setText("Nome do Filme: " + filme.getNome());
        ((TextView)findViewById(R.id.diretorTextView)).setText("Nome Diretor: " + filme.getDiretor());
        ((TextView)findViewById(R.id.anoLacamentoTextView)).setText("Lançado em: " + filme.getAnoLancamento());
        ((TextView)findViewById(R.id.nacionalidadeTextView)).setText("Pais de Origem: " + filme.getNacionalidade());
        ((TextView)findViewById(R.id.atorPrincipalTextView)).setText("Ator Principal:" + filme.getAtorPrincipal());

       ((TextView)findViewById(R.id.contatoTextView)).setOnClickListener(new OnClickListener() {

           @Override
           public void onClick(View v) {
               TextView t = (TextView) v;
               Intent i = new Intent(Intent.ACTION_SENDTO);
               i.setData(Uri.fromParts("mailto:", t.getText().toString(), null));
               i.putExtra(Intent.EXTRA_SUBJECT, "Informações sobre " + filme.getNome());
               i.putExtra(Intent.EXTRA_TEXT, "Gostaria de receber mais informações sobre " + filme.getNome());
               startActivity(i);
           }
       });


        ((TextView)findViewById(R.id.telefoneTextView)).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                TextView t = (TextView) v;
                Intent i = new Intent(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:" +  t.getText().toString()));
                startActivity(i);
            }
        });


        ((TextView)findViewById(R.id.maisInfoButton)).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                TextView t = (TextView) v;
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("http://www.imdb.com/"));
                startActivity(i);
            }
        });

    }
}
