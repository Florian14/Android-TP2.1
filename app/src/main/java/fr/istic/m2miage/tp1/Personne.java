package fr.istic.m2miage.tp1;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Florian on 08/10/2016.
 */

public class Personne  implements Parcelable {

    private String nom, prenom, naissance, ville, departement, telephone;

    public Personne(){}

    public Personne(String nom, String prenom, String naissance, String ville, String departement, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.naissance = naissance;
        this.ville = ville;
        this.departement = departement;
        this.telephone = telephone;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNaissance() {
        return naissance;
    }

    public void setNaissance(String naissance) {
        this.naissance = naissance;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Personne(Parcel in) {
        this.nom = in.readString();
        this.prenom = in.readString();
        this.naissance = in.readString();
        this.ville = in.readString();
        this.departement = in.readString();
        this.telephone = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nom);
        dest.writeString(prenom);
        dest.writeString(naissance);
        dest.writeString(ville);
        dest.writeString(departement);
        dest.writeString(telephone);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Personne> CREATOR = new Creator<Personne>() {
        @Override
        public Personne createFromParcel(Parcel in) {
            return new Personne(in);
        }

        @Override
        public Personne[] newArray(int size) {
            return new Personne[size];
        }
    };
}
