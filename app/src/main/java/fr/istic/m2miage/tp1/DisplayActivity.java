package fr.istic.m2miage.tp1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    private TextView nom, prenom, ville, naissance, departement, telephone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        this.nom = (TextView) findViewById(R.id.nom);
        this.prenom = (TextView) findViewById(R.id.prenom);
        this.naissance = (TextView) findViewById(R.id.naissance);
        this.ville = (TextView) findViewById(R.id.ville);
        this.departement = (TextView) findViewById(R.id.departement);
        this.telephone = (TextView) findViewById(R.id.telephone);

        Intent intent = getIntent();
        if(intent.hasExtra("personne")){
            Personne p = intent.getParcelableExtra("personne");
            this.nom.setText(p.getNom());
            this.prenom.setText(p.getPrenom());
            this.naissance.setText(p.getNaissance());
            this.ville.setText(p.getVille());
            this.departement.setText(p.getDepartement());
            this.telephone.setText(p.getTelephone());
        }


    }
}
