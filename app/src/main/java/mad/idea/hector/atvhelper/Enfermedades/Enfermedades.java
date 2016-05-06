package mad.idea.hector.atvhelper.Enfermedades;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import mad.idea.hector.atvhelper.Categorias;
import mad.idea.hector.atvhelper.R;

import java.util.ArrayList;
import java.util.List;

public class Enfermedades extends AppCompatActivity {

    private List<Categorias> categorias;

    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enfermedades);

        rv = (RecyclerView) findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        initializeData();
        iniializeAdapterEnfermedades();
    }
    public void initializeData()
    {
        categorias = new ArrayList<>();
        //Enfermedades comunes
        categorias.add(new Categorias("Parvovirosis","", "comun"));
        categorias.add(new Categorias("Moquillo canino", "", "comun"));
        categorias.add(new Categorias("Rabia", "", "comun"));
        categorias.add(new Categorias("Adenovirus canino/Hepatitis", "", "comun"));
        categorias.add(new Categorias("Tos de las perreras", "", "comun"));
        categorias.add(new Categorias("Coronavirus canino", "", "comun"));
        categorias.add(new Categorias("Leucemia felina(FeLV y FIV)", "", "comun"));
        categorias.add(new Categorias("Syndrome respiratorio felino", "", "comun"));
        categorias.add(new Categorias("Panleucopenia felina", "", "comun"));
        categorias.add(new Categorias("Peritonitis infecciosa felina (PIF)", "", "comun"));


        //Enfermedades bacterianas
        categorias.add(new Categorias("Leptospirosis", "", "bacterianas"));
        categorias.add(new Categorias("Ehrlichiosis canina", "", "bacterianas"));

        //Enfermedades parasitarias
        categorias.add(new Categorias("Nematodos", "", "parasitarias"));
        categorias.add(new Categorias("Cestodos", "", "parasitarias"));
        categorias.add(new Categorias("Trematodos", "", "parasitarias"));
        categorias.add(new Categorias("Protozoos", "", "parasitarias"));

    }

    public void iniializeAdapterEnfermedades() {
        RVAdapterEnfermedades adapter = new RVAdapterEnfermedades(categorias);
        rv.setAdapter(adapter);
    }
}
