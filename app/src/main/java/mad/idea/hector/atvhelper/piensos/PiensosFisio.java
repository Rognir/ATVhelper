package mad.idea.hector.atvhelper.piensos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import mad.idea.hector.atvhelper.Categorias;
import mad.idea.hector.atvhelper.R;

public class PiensosFisio extends AppCompatActivity {

    RecyclerView rv;
    ArrayList<Categorias> categorias;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piensos_fisio);
        rv = (RecyclerView) findViewById(R.id.rvPiensosNormales);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        initializeData();
        iniializeAdapterPiensos();

    }

    public void initializeData() {
        categorias = new ArrayList<>();
        categorias.add(new Categorias("Leche en polvo", "", "gato/perro"));
        categorias.add(new Categorias("Cachorro (y hembras gestantes)", "", "gato/perro"));
        categorias.add(new Categorias("Adulto", "", "gato/perro"));
        categorias.add(new Categorias("Senior", "", "gato/perro"));
    }

    public void iniializeAdapterPiensos() {
        RVAdapterPiensosFisio adapter = new RVAdapterPiensosFisio(categorias);
        rv.setAdapter(adapter);
    }
}
