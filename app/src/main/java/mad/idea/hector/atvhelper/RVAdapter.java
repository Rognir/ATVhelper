package mad.idea.hector.atvhelper;

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
import android.widget.Toast;

import mad.idea.hector.atvhelper.Enfermedades.Enfermedades;

import mad.idea.hector.atvhelper.R;

import mad.idea.hector.atvhelper.piensos.Piensos;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonViewHolder>{

    List<Categorias> persons;

    RVAdapter(List<Categorias> persons) {
        this.persons = persons;
    }

    public class PersonViewHolder extends RecyclerView.ViewHolder implements OnClickListener {
        View root;
        CardView cv;
        TextView categoriasName;
        TextView categoriasDescripcion;
        ImageView categoriasPhoto;


        PersonViewHolder(final View
                                 itemView) {
            super(itemView);
            root = itemView;
            cv = (CardView)itemView.findViewById(R.id.cv);
            categoriasName = (TextView)itemView.findViewById(R.id.nombre);
            categoriasDescripcion = (TextView)itemView.findViewById(R.id.visitas);
            categoriasPhoto = (ImageView)itemView.findViewById(R.id.imagen);
            cv.setOnClickListener(this);
        }
        private Intent intent;

        @Override
        public void onClick(View v) {
            Context context = itemView.getContext();
            int posicion = getAdapterPosition();
            switch (posicion)
            {
                case 0:
                    intent = new Intent(context, FluidoTerapia.class);
                    break;
                case 1:
                    intent = new Intent(context, Enfermedades.class);
                    break;
                case 2:
                    intent = new Intent(context, Piensos.class);
                    break;
                default:
                    intent = new Intent(context, MainActivity.class);
                    break;
            }
            context.startActivity(intent);
        }
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cards, viewGroup, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, int i) {
        personViewHolder.categoriasName.setText(persons.get(i).name);
        personViewHolder.categoriasDescripcion.setText(persons.get(i).descripcion);
        personViewHolder.categoriasPhoto.setImageResource(persons.get(i).photoId);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
