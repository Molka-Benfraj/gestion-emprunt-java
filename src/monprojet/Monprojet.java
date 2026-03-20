/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monprojet;
import java.util.ArrayList;
/**
 *
 * @author HP
 */
public class Monprojet {

    /**
     * @param args the command line arguments
     */
   
          public static void main(String[] args) {
        GestionEmprunts gestionEmprunts = new GestionEmprunts();

        Utilisateur utilisateur1 = new Utilisateur(1, "ramzi", "benromdhane");
        Utilisateur utilisateur2 = new Utilisateur(2, "molka", "ebnfraj");
        Utilisateur utilisateur3 = new Utilisateur(3, "ali", "ebnahmed");

        Materiel ordinateur = new Materiel("Ordinateur portable");
        Materiel imprimante = new Materiel("Imprimante");

        // Exemple d'emprunts
        gestionEmprunts.nouvelEmprunt(ordinateur, utilisateur1, 7);
        gestionEmprunts.nouvelEmprunt(imprimante, utilisateur2, 5);
        gestionEmprunts.nouvelEmprunt(ordinateur, utilisateur3, 10);
        gestionEmprunts.nouvelEmprunt(ordinateur, utilisateur1, 3); // Nouvel emprunt pour utilisateur1
        gestionEmprunts.nouvelEmprunt(imprimante, utilisateur2, 8); // Nouvel emprunt pour utilisateur2
        gestionEmprunts.nouvelEmprunt(imprimante, utilisateur3, 6); // Nouvel emprunt pour utilisateur3

        // Afficher l'historique des emprunts d'un utilisateur
        gestionEmprunts.afficherHistoriqueEmpruntsUtilisateur(utilisateur1);
        gestionEmprunts.afficherHistoriqueEmpruntsUtilisateur(utilisateur2);
        gestionEmprunts.afficherHistoriqueEmpruntsUtilisateur(utilisateur3);

        // Retourner un emprunt
        gestionEmprunts.retournerEmprunt(1);

        // Afficher les emprunts en retard
        ArrayList<Emprunt> empruntsEnRetard = gestionEmprunts.getEmpruntsEnRetard();
        System.out.println("Emprunts en retard:");
        for (Emprunt emprunt : empruntsEnRetard) {
            System.out.println("Emprunt ID: " + emprunt.getId());
            System.out.println("Matériel: " + emprunt.getMateriel().getNom());
            System.out.println("Date d'emprunt: " + emprunt.getDateEmprunt());
            System.out.println("Durée d'emprunt: " + emprunt.getDureeEmprunt() + " jours");
            System.out.println("--------------");
        }
   
    }
    
}
