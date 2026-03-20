/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monprojet;

import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author HP
 */
public class GestionEmprunts {
    
     private ArrayList<Emprunt> emprunts;

    public GestionEmprunts() {
        this.emprunts = new ArrayList<>();
    }

    public void nouvelEmprunt(Materiel materiel, Utilisateur utilisateur, int dureeEmprunt) {
        Emprunt emprunt = new Emprunt(materiel, utilisateur, dureeEmprunt);
        emprunts.add(emprunt);
    }

    public void retournerEmprunt(int empruntId) {
        for (Emprunt emprunt : emprunts) {
            if (emprunt.getId() == empruntId) {
                emprunt.retourner();
                break;
            }
        }
    }

    public ArrayList<Emprunt> getEmpruntsUtilisateur(Utilisateur utilisateur) {
        ArrayList<Emprunt> empruntsUtilisateur = new ArrayList<>();
        for (Emprunt emprunt : emprunts) {
            if (emprunt.getUtilisateur().equals(utilisateur)) {
                empruntsUtilisateur.add(emprunt);
            }
        }
        return empruntsUtilisateur;
    }

    public ArrayList<Emprunt> getEmpruntsEnRetard() {
        ArrayList<Emprunt> empruntsEnRetard = new ArrayList<>();
        for (Emprunt emprunt : emprunts) {
            if (!emprunt.isEstRendu() && emprunt.estEnRetard()) {
                empruntsEnRetard.add(emprunt);
            }
        }
        return empruntsEnRetard;
    }

    // Méthode pour afficher l'historique des emprunts d'un utilisateur
    public void afficherHistoriqueEmpruntsUtilisateur(Utilisateur utilisateur) {
        ArrayList<Emprunt> empruntsUtilisateur = getEmpruntsUtilisateur(utilisateur);

        if (empruntsUtilisateur.isEmpty()) {
            System.out.println("L'utilisateur n'a pas emprunté de matériel.");
        } else {
            System.out.println("Historique des emprunts de " + utilisateur.getNom() + " " + utilisateur.getPrenom() + ":");
            for (Emprunt emprunt : empruntsUtilisateur) {
                System.out.println("Emprunt ID: " + emprunt.getId());
                System.out.println("Matériel: " + emprunt.getMateriel().getNom());
                System.out.println("Date d'emprunt: " + emprunt.getDateEmprunt());
                System.out.println("Durée d'emprunt: " + emprunt.getDureeEmprunt() + " jours");
                System.out.println("Retourné: " + (emprunt.isEstRendu() ? "Oui" : "Non"));
                System.out.println("--------------");
            }
        }
    }
    
    
}
