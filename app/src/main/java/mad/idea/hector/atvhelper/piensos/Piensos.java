package mad.idea.hector.atvhelper.piensos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import mad.idea.hector.atvhelper.Categorias;
import mad.idea.hector.atvhelper.R;

import java.util.ArrayList;
import java.util.List;

public class Piensos extends AppCompatActivity {
    private List<Categorias> categorias;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piensos);

        rv = (RecyclerView)findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        initializeData();
        iniializeAdapterPiensos();

    }

    public void initializeData()
    {
        categorias = new ArrayList<>();
        categorias.add(new Categorias("Fisiológicos", "", R.drawable.piensofisio));
        categorias.add(new Categorias("Medicamentosos", "", R.drawable.piensomed));
    }

    public void iniializeAdapterPiensos() {
        RVAdapterPiensos adapter = new RVAdapterPiensos(categorias);
        rv.setAdapter(adapter);
    }
}
