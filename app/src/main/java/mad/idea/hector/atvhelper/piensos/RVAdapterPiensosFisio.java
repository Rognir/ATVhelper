package mad.idea.hector.atvhelper.piensos;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import mad.idea.hector.atvhelper.Categorias;
import mad.idea.hector.atvhelper.MainActivity;
import mad.idea.hector.atvhelper.R;

public class RVAdapterPiensosFisio extends RecyclerView.Adapter<RVAdapterPiensosFisio.PersonViewHolder>{

    List<Categorias> persons;

    RVAdapterPiensosFisio(List<Categorias> persons) {
        this.persons = persons;
    }

    public class PersonViewHolder extends RecyclerView.ViewHolder {
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
        personViewHolder.categoriasTitulo.setText(persons.get(i).titulo);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
