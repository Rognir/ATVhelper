package mad.idea.hector.atvhelper.Enfermedades;

import android.app.Activity;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import mad.idea.hector.atvhelper.R;

public class TextoEnfermedad extends AppCompatActivity {
    EditText texto;
    Button guardar;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_texto_enfermedad);
        texto = (EditText)findViewById(R.id.editText);
        guardar = (Button)findViewById(R.id.btnGuardar);

        BaseDeApuntesEnfermedad bbdd = new BaseDeApuntesEnfermedad(this, "DBApuntes", null, 1);

        db = bbdd.getWritableDatabase();
        final String newString;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                newString= null;
            } else {
                newString= extras.getString("TAG_ENFERMEDAD");
            }
        } else {
            newString= (String) savedInstanceState.getSerializable("TAG_ENFERMEDAD");
        }
        Cursor c = db.rawQuery("SELECT enfermedad, apunte FROM Apuntes WHERE enfermedad LIKE '"+newString+"'", null);

    //Nos aseguramos de que existe al menos un registro
        if (c.moveToFirst()) {
            //Recorremos el cursor hasta que no haya más registros
            do {
                String apunte= c.getString(1);

                texto.setText(apunte);
            } while(c.moveToNext());
        }
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.execSQL("UPDATE Apuntes SET apunte='"+texto.getText()+"' WHERE enfermedad LIKE '"+newString+"' ");
                Toast toast = Toast.makeText(getApplication().getBaseContext(),"Apuntes guardados",Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}