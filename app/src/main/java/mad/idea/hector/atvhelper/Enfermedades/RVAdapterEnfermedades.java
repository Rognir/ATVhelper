package mad.idea.hector.atvhelper.Enfermedades;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import mad.idea.hector.atvhelper.Categorias;
import mad.idea.hector.atvhelper.R;

import java.util.List;

public class RVAdapterEnfermedades extends RecyclerView.Adapter<RVAdapterEnfermedades.PersonViewHolder>{

    List<Categorias> persons;


    RVAdapterEnfermedades(List<Categorias> persons) {
        this.persons = persons;
    }

    public class PersonViewHolder extends RecyclerView.ViewHolder implements OnClickListener {
        View root;
        CardView cv;
        TextView categoriasName;
        TextView categoriasDescripcion;
        TextView categoriasTitulo;



        PersonViewHolder(final View
                                 itemView) {
            super(itemView);
            root = itemView;
            cv = (CardView)itemView.findViewById(R.id.cvPiensos);
            categoriasName = (TextView)itemView.findViewById(R.id.nombre);
            categoriasDescripcion = (TextView)itemView.findViewById(R.id.visitasTexto);
            categoriasTitulo = (TextView) itemView.findViewById(R.id.imagenTxt);
            cv.setOnClickListener(this);
        }
        private Intent intent;

        @Override
        public void onClick(View v) {
            Context context = itemView.getContext();
            intent = new Intent(context, TextoEnfermedad.class);
            intent.putExtra("TAG_ENFERMEDAD", categoriasName.getText());
            context.startActivity(intent);
        }
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cards_piensos, viewGroup, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, int i) {
        personViewHolder.categoriasName.setText(persons.get(i).name);
        personViewHolder.categoriasDescripcion.setText(persons.get(i).descripcion);
        if(persons.get(i).titulo.equals("comun")) personViewHolder.categoriasTitulo.setTextColor(Color.parseColor("#ff0000"));
        if(persons.get(i).titulo.equals("bacterianas")) personViewHolder.categoriasTitulo.setTextColor(Color.parseColor("#0000ff"));
        if(persons.get(i).titulo.equals("parasitarias")) personViewHolder.categoriasTitulo.setTextColor(Color.parseColor("#228b22"));
        personViewHolder.categoriasTitulo.setText(persons.get(i).titulo);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
