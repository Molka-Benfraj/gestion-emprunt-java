/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monprojet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
/**
 *
 * @author HP
 */
public class Emprunt {
    private static int count = 1;
    private int id;
    private Materiel materiel;
    private Utilisateur utilisateur;
    private Date dateEmprunt;
    private int dureeEmprunt; // en jours
    private boolean estRendu;

    public Emprunt(Materiel materiel, Utilisateur utilisateur, int dureeEmprunt) {
        this.id = count++;
        this.materiel = materiel;
        this.utilisateur = utilisateur;
        this.dateEmprunt = new Date();
        this.dureeEmprunt = dureeEmprunt;
        this.estRendu = false;
    }

    public void retourner() {
        this.estRendu = true;
    }

    public boolean estEnRetard() {
        if (!estRendu) {
            Calendar dateRetourPrevue = Calendar.getInstance();
            dateRetourPrevue.setTime(dateEmprunt);
            dateRetourPrevue.add(Calendar.DAY_OF_MONTH, dureeEmprunt);

            Calendar dateActuelle = Calendar.getInstance();

            return dateActuelle.after(dateRetourPrevue);
        }
        return false;
    }

    public int getId() {
        return id;
    }

    public Materiel getMateriel() {
        return materiel;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public Date getDateEmprunt() {
        return dateEmprunt;
    }

    public int getDureeEmprunt() {
        return dureeEmprunt;
    }

    public boolean isEstRendu() {
        return estRendu;
    }
    
}
