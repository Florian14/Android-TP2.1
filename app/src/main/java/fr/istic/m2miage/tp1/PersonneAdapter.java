package fr.istic.m2miage.tp1;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by Florian on 18/10/2016.
 */

public class PersonneAdapter extends ArrayAdapter<Personne> {

    private LayoutInflater mInflater;

    public PersonneAdapter(Context context, int resourceId, List<Personne> items) {
        super(context, resourceId, items);

        mInflater = LayoutInflater.from(context);
        Log.d(TAG, "onCreate");
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder;
        Personne personne = getItem(position);

        if (convertView == null || convertView.getTag() == null) {
            convertView = mInflater.inflate(R.layout.item, null);

            holder = new Holder();
            holder.nom = (TextView) convertView.findViewById(R.id.listNom);
            holder.prenom = (TextView) convertView.findViewById(R.id.listPrenom);
            holder.naissance = (TextView) convertView.findViewById(R.id.listNaissance);
            holder.ville = (TextView) convertView.findViewById(R.id.listVille);

            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        holder.nom.setText(personne.getNom());
        holder.prenom.setText(personne.getPrenom());
        holder.naissance.setText(personne.getNaissance());
        holder.ville.setText(personne.getVille());

        return convertView;
    }

    public class Holder {
        TextView nom;
        TextView prenom;
        TextView naissance;
        TextView ville;
    }
}
