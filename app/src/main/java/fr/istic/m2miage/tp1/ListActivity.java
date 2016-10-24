package fr.istic.m2miage.tp1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private ListView listView;
    private Button button;

    private List<Personne> listClients;
    private ArrayAdapter arrayAdapter;

    private ArrayList<HashMap<String, String>> listMapClients;
    private SimpleAdapter simpleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listView = (ListView) findViewById(R.id.listClients);
        button = (Button) findViewById(R.id.ajouterClientBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListActivity.this, MainActivity.class);
                startActivityForResult(intent, 1000);
            }
        });

        // 2 methodes sont utilisees
        // Methode 1 : stockage d'objets "Personne" dans une liste
        listClients = new ArrayList<>();
        // Méthode 2 : utilisation d'une liste de hashmaps, une hashmap contient les informations
        // d'une personne
        listMapClients = new ArrayList<>();

        HashMap<String, String> hm = new HashMap<>();
        // Méthode 1
        Personne personne = new Personne("Dupont", "Robert", "25/10/1968", "Rennes", "Ille-et-Vilaine", "0612345678");
        listClients.add(personne);
        // Méthode 2
        hm.put("nom", personne.getNom());
        hm.put("prenom", personne.getPrenom());
        hm.put("naissance", personne.getNaissance());
        hm.put("ville", personne.getVille());
        listMapClients.add(hm);

        hm = new HashMap<>();
        personne = new Personne("Tuning", "Jacky", "12/05/1978", "Caen", "Calvados", "0687654321");
        hm.put("nom", personne.getNom());
        hm.put("prenom", personne.getPrenom());
        hm.put("naissance", personne.getNaissance());
        hm.put("ville", personne.getVille());
        listClients.add(personne);
        listMapClients.add(hm);

        hm = new HashMap<>();
        personne = new Personne("Polo", "Marco", "12/12/20128", "Nantes", "Loire-Atlantique", "0622334455");
        hm.put("nom", personne.getNom());
        hm.put("prenom", personne.getPrenom());
        hm.put("naissance", personne.getNaissance());
        hm.put("ville", personne.getVille());
        listClients.add(personne);
        listMapClients.add(hm);

        // Méthode 1
        arrayAdapter = new PersonneAdapter(this, R.layout.item, listClients);

        // Méthode 2
        // Création d'un SimpleAdapter qui se chargera de mettre les items présent dans notre list
        // (listItem) dans la vue affichageItem
        simpleAdapter = new SimpleAdapter(this.getBaseContext(), listMapClients, R.layout.item,
                new String[] {"nom", "prenom", "naissance", "ville"}, new int[] {R.id.listNom,
                R.id.listPrenom, R.id.listNaissance, R.id.listVille});


        //On attribue à notre listView l'adapter que l'on vient de créer
        // Méthode 1
        listView.setAdapter(arrayAdapter);
        // Méthode 2
        //listView.setAdapter(simpleAdapter);
    }

    /**
     * Cette méthode permet de récupérer l'objet Personne créé dans MainActivity
     * @param requestCode Code qui correspond a l'activité qui nous envoie ses informations
     * @param resultCode Permet de vérifier si aucune erreur ne s'est produite
     * @param data Données transmises par l'autre activité
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case 1000:
                if(data.hasExtra("personne")) {
                    Personne personne = data.getParcelableExtra("personne");
                    HashMap<String, String> hm = new HashMap<>();
                    hm.put("nom", personne.getNom());
                    hm.put("prenom", personne.getPrenom());
                    hm.put("naissance", personne.getNaissance());
                    hm.put("ville", personne.getVille());
                    listClients.add(personne);
                    listMapClients.add(hm);

                    listView.setAdapter(arrayAdapter);
                    //listView.setAdapter(simpleAdapter);
                }
                break;
        }
    }
}
