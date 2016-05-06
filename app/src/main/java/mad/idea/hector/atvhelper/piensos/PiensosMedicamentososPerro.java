package mad.idea.hector.atvhelper.piensos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import mad.idea.hector.atvhelper.Categorias;
import mad.idea.hector.atvhelper.R;

import java.util.ArrayList;
import java.util.List;

public class PiensosMedicamentososPerro extends AppCompatActivity {
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
        categorias.add(new Categorias("Ry = Metabolic" +
                "\nHills = R/D W/D o J/D" +
                "\nAD = Obesity y Saciety ", "", "Obesidad"));
        categorias.add(new Categorias("Ry = Sensitivity Control, Hypoallergenic y Skin Support" +
                "\nHills = Z/D y D/D" +
                "\nAD = Atopic care, Hypoallergenic y Intolerance care ", "", "Enfermedades Cutaneas"));
        categorias.add(new Categorias("Ry = Diabetic (special low)" +
                "\nHills = R/D y W/D" +
                "\nAD =  Diabetes colitis", "", "Diabetes"));
        categorias.add(new Categorias("Ry = Renal" +
                "\nHills = K/D o U/D" +
                "\nAD =  Renal", "", "Patologias renales"));
        categorias.add(new Categorias("Ry = Low fat" +
                "\nHills = I/D o I/D low fat" +
                "\nAD =  Gastroforte y Gastroenteric low fat", "", "Gastrointestinal"));
        categorias.add(new Categorias("Ry = Urinary" +
                "\nHills = C/D (calculos de estruvita ph básico oxalato forma ph ácido) S/D y U/D (basificar ph)" +
                "\nAD =  Urinary", "", "Urinaria"));
        categorias.add(new Categorias("Ry = " +
                "\nHills = K/D o U/D" +
                "\nAD =  Renal", "", "atologias renales"));
        categorias.add(new Categorias("Ry = Cardiac" +
                "\nHills = H/D o K/D", "", "Problemas de corazón"));
        categorias.add(new Categorias("Ry = Convalescence support" +
                "\nHills = N/D, I/D y A/D", "", "Cuidados intensivos"));
        categorias.add(new Categorias("Hills = T/D"+
                "\nAD = Dental", "", "Dental"));
        categorias.add(new Categorias("Ry = Mobility" +
                "\nHills = J/D"+
                "\nAD = Articular reduced calories", "", "Problemas articulares"));
        categorias.add(new Categorias("Ry = Hepatic" +
                "\nHills = L/D"+
                "\nAD = no tiene usaria Gastroenteric", "", "Problemas hepaticos"));
    }

    public void iniializeAdapterPiensosNormales() {
        RVAdapterPiensosMedicamentosos adapter = new RVAdapterPiensosMedicamentosos(categorias);
        rv.setAdapter(adapter);
    }
}
