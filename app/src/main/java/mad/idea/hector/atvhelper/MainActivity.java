package mad.idea.hector.atvhelper;

import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import mad.idea.hector.atvhelper.Enfermedades.BaseDeApuntesEnfermedad;
import mad.idea.hector.atvhelper.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Categorias> categorias;
    private RecyclerView rv;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boolean mboolean = false;

        SharedPreferences settings = getSharedPreferences("PREFS_NAME", 0);
        mboolean = settings.getBoolean("FIRST_RUN", false);
        if (!mboolean) {
            // Primera ejecucion

            BaseDeApuntesEnfermedad bbdd = new BaseDeApuntesEnfermedad(this, "DBApuntes", null, 1);

            db = bbdd.getWritableDatabase();
            if(db!=null )
            {
                db.execSQL("INSERT INTO Apuntes (enfermedad, apunte) " +
                        "VALUES ('Parvovirosis', '1')");
                db.execSQL("INSERT INTO Apuntes (enfermedad, apunte) " +
                        "VALUES ('Moquillo canino', '2')");
                db.execSQL("INSERT INTO Apuntes (enfermedad, apunte) " +
                        "VALUES ('Rabia', '3')");
                db.execSQL("INSERT INTO Apuntes (enfermedad, apunte) " +
                        "VALUES ('Adenovirus canino/Hepatitis', '4')");
                db.execSQL("INSERT INTO Apuntes (enfermedad, apunte) " +
                        "VALUES ('Tos de las perreras', '6')");
                db.execSQL("INSERT INTO Apuntes (enfermedad, apunte) " +
                        "VALUES ('Coronavirus canino', '')");
                db.execSQL("INSERT INTO Apuntes (enfermedad, apunte) " +
                        "VALUES ('Leucemia felina(FeLV y FIV)', '')");
                db.execSQL("INSERT INTO Apuntes (enfermedad, apunte) " +
                        "VALUES ('Syndrome respiratorio felino', '')");
                db.execSQL("INSERT INTO Apuntes (enfermedad, apunte) " +
                        "VALUES ('Panleucopenia felina', '')");
                db.execSQL("INSERT INTO Apuntes (enfermedad, apunte) " +
                        "VALUES ('Peritonitis infecciosa felina (PIF)', '')");


                db.execSQL("INSERT INTO Apuntes (enfermedad, apunte) " +
                        "VALUES ('Leptospirosis', '')");
                db.execSQL("INSERT INTO Apuntes (enfermedad, apunte) " +
                        "VALUES ('Ehrlichiosis canina', '')");

                db.execSQL("INSERT INTO Apuntes (enfermedad, apunte) " +
                        "VALUES ('Nematodos', '')");
                db.execSQL("INSERT INTO Apuntes (enfermedad, apunte) " +
                        "VALUES ('Cestodos', '')");
                db.execSQL("INSERT INTO Apuntes (enfermedad, apunte) " +
                        "VALUES ('Trematodos', '')");
                db.execSQL("INSERT INTO Apuntes (enfermedad, apunte) " +
                        "VALUES ('Protozoos', '')");
            }
            db.close();

            settings = getSharedPreferences("PREFS_NAME", 0);
            SharedPreferences.Editor editor = settings.edit();
            editor.putBoolean("FIRST_RUN", true);
            editor.commit();
        } else {
            // El resto de ejecuciones
        }

        rv = (RecyclerView)findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        initializeData();
        iniializeAdapter();

    }

    public void initializeData()
    {
        categorias = new ArrayList<>();
        categorias.add(new Categorias("Fluidoterapia", "Liquido para todos", R.drawable.fluido));
        categorias.add(new Categorias("Enfermedades", "Vaya por dioh", R.drawable.enfermedades));
        categorias.add(new Categorias("Piensos", "Piensaco cojonuo", R.drawable.pienso));
    }

    public void iniializeAdapter() {
        RVAdapter adapter = new RVAdapter(categorias);
        rv.setAdapter(adapter);
    }
}
