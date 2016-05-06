package mad.idea.hector.atvhelper.piensos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import mad.idea.hector.atvhelper.Categorias;
import mad.idea.hector.atvhelper.R;

import java.util.ArrayList;
import java.util.List;

public class PiensosMedicamentososGato extends AppCompatActivity {
    private List<Categorias> categorias;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piensos_medicamentosos);

        rv = (RecyclerView)findViewById(R.id.rvPiensosNormales);



        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        initializeData();
        iniializeAdapterPiensosNormales();

    }

    public void initializeData()
    {
        categorias = new ArrayList<>();
        categorias.add(new Categorias("Ry = Convalescence y recovery" +
                "\nHills = A/D ", "", "Cuidados intensivos"));
        categorias.add(new Categorias("Ry = Dental" +
                "\nHills = T/D", "", "Dentales"));
        categorias.add(new Categorias("Ry = Diabetic" +
                "\nHills = W/D o R/D" +
                "\nAD = Obesity", "", "Diabetes"));
        categorias.add(new Categorias("Hills = I/D" +
                "\nAD = Gastroenteric Sensitive", "", "Gastro"));
        categorias.add(new Categorias("Ry = hepatic" +
                "\nHills = I/D o L/D", "", "Pr. hep."));
        categorias.add(new Categorias("Ry = Sensitivity" +
                "\nHills = D/D o B/D", "", "Dermatologicos \n(sensibilidad alimentaria)"));
        categorias.add(new Categorias("Ry = Obesity 'mantener' y Saciety" +
                "\nHills = Metabolic R/D o W/D o M/D" +
                "\nAD = Obesity", "", "Obesidad"));
        categorias.add(new Categorias("Ry = Renal" +
                "\nHills = K/D" +
                "\nAD = Renal", "", "Problemas renales"));
        categorias.add(new Categorias("Ry = Urinary" +
                "\nHills = C/D S/D o U/D" +
                "\nAD = Urinary", "", "Urinaria\n(cristales)"));
    }

    public void iniializeAdapterPiensosNormales() {
        RVAdapterPiensosMedicamentosos adapter = new RVAdapterPiensosMedicamentosos(categorias);
        rv.setAdapter(adapter);
    }
}
