package mad.idea.hector.atvhelper.Enfermedades;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hector1 on 24/04/2016.
 */
public class BaseDeApuntesEnfermedad extends SQLiteOpenHelper {
    String sqlCreate = "CREATE TABLE Apuntes (enfermedad TEXT, apunte TEXT)";

    public BaseDeApuntesEnfermedad(Context contexto, String nombre,
                                   SQLiteDatabase.CursorFactory factory, int version) {
        super(contexto, nombre, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Se ejecuta la sentencia SQL de creación de la tabla
        db.execSQL(sqlCreate);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva) {
        //NOTA: Por simplicidad del ejemplo aquí utilizamos directamente la opción de
        //      eliminar la tabla anterior y crearla de nuevo vacía con el nuevo formato.
        //      Sin embargo lo normal será que haya que migrar datos de la tabla antigua
        //      a la nueva, por lo que este método debería ser más elaborado.

        //Se elimina la versión anterior de la tabla
        db.execSQL("DROP TABLE IF EXISTS Apuntes");

        //Se crea la nueva versión de la tabla
        db.execSQL(sqlCreate);
    }
}
