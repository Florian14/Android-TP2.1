package fr.istic.m2miage.tp1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private EditText nom, prenom, ville, naissance, telephone;
    private Spinner departement;
    private Button validateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.nom = (EditText) findViewById(R.id.nom);
        this.prenom = (EditText) findViewById(R.id.prenom);
        this.ville = (EditText) findViewById(R.id.ville);
        this.naissance = (EditText) findViewById(R.id.date);
        this.departement = (Spinner) findViewById(R.id.departement);
        this.validateBtn = (Button) findViewById(R.id.validateBtn);

        validateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String message = prenom.getText() + " " + nom.getText() + " est né le " + naissance.getText() + " à " + ville.getText();
//                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent();

                Personne p = new Personne();
                p.setNom(nom.getText().toString());
                p.setPrenom(prenom.getText().toString());
                p.setNaissance(naissance.getText().toString());
                p.setVille(ville.getText().toString());
                p.setDepartement(departement.getSelectedItem().toString());
                if(telephone != null) {
                    p.setTelephone(telephone.getText().toString());
                }

                intent.putExtra("personne", p);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        LinearLayout layout = (LinearLayout) findViewById(R.id.verticalLayout);

        switch(item.getItemId()){
            case R.id.resetMenu:
                for(int i=0; i<layout.getChildCount(); i++){
                    if(layout.getChildAt(i) instanceof EditText) {
                        EditText et = (EditText) layout.getChildAt(i);
                        et.setText("");
                    }
                }
                this.nom.setText("");
                this.prenom.setText("");
                this.ville.setText("");
                this.naissance.setText("");
                return true;
            case R.id.addComponentMenu:
                if(telephone == null) {
                    telephone = new EditText(this);
                    telephone.setInputType(InputType.TYPE_CLASS_PHONE);
                    telephone.setHint("Numéro de téléphone");
                    layout.addView(telephone);
                }
                return true;
            case R.id.afficherVille:
                if(!ville.getText().toString().isEmpty()) {
                    String villeStr = ville.getText().toString();
                    villeStr = villeStr.replace(' ', '_');
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://fr.wikipedia.org/wiki/" + villeStr));
                    startActivity(intent);
                }
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
