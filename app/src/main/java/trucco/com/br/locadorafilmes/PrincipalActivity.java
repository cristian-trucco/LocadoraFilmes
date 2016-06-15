package trucco.com.br.locadorafilmes;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;


import java.util.ArrayList;
import java.util.List;

public class PrincipalActivity extends ListActivity {

    private List<Filme> filmes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        filmes = new ArrayList<Filme>();

        Filme filme = null;

        filme = new Filme();
        filme.setNome("Matrix");
        filme.setCategoria("Ficção Cientifica");
        filme.setDiretor("Irmão lo");
        filme.setAnoLancamento(1999);
        filme.setNacionalidade("Estados Unidos");
        filme.setAtorPrincipal("keaunu Reves");
        filmes.add(filme);

        filme = new Filme();
        filme.setNome("American Pie");
        filme.setCategoria("Comédia");
        filme.setDiretor("Sei lá");
        filme.setAnoLancamento(2002);
        filme.setNacionalidade("Estados Unidos");
        filme.setAtorPrincipal("Nerde");
        filmes.add(filme);

        filme = new Filme();
        filme.setNome("Star Wars 7");
        filme.setCategoria("Ficção Cientifica");
        filme.setDiretor("Jorge Lucas");
        filme.setAnoLancamento(2016);
        filme.setNacionalidade("Estados Unidos");
        filme.setAtorPrincipal("Darth Vader");
        filmes.add(filme);

        filme = new Filme();
        filme.setNome("Sniper Americano");
        filme.setCategoria("Ação");
        filme.setDiretor("Depois eu vejo");
        filme.setAnoLancamento(2015);
        filme.setNacionalidade("Estados Unidos");
        filme.setAtorPrincipal("Atirador de Elite");
        filmes.add(filme);

        filme = new Filme();
        filme.setNome("Exorcista");
        filme.setCategoria("Terror");
        filme.setDiretor("Morreu");
        filme.setAnoLancamento(1975);
        filme.setNacionalidade("Estados Unidos");
        filme.setAtorPrincipal("Coisa Ruim");
        filmes.add(filme);

        setListAdapter(new ArrayAdapter<Filme>(
                this, // Contexto da lista
                android.R.layout.simple_list_item_1, // Layout do item
                android.R.id.text1, filmes));

        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Filme filme = filmes.get(position);
                Intent intent = new Intent(PrincipalActivity.this, DetalheFilmeActivity.class);
                intent.putExtra("filme", filme);
                startActivity(intent);
            }
        });
    }

}



