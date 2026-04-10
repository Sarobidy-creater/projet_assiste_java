public class Employe extends Personne {
    private String numeroEmploye;
    private String dateEmbauche;

    public Employe(int identifiant, String nom, String adresse, String contact, String numeroEmploye, String dateEmbauche) {
        super(identifiant, nom, adresse, contact);
        this.numeroEmploye = numeroEmploye;
        this.dateEmbauche = dateEmbauche;
    }

    public String getNumeroEmploye() { return numeroEmploye; }
    public String getDateEmbauche() { return dateEmbauche; }

    public String obtenirRole() {
        return "Employe";
    }

    @Override
    public String obtenirInfos() {
        return super.obtenirInfos() +
               "\nNumero Employe : " + numeroEmploye +
               "\nDate Embauche : " + dateEmbauche;
    }
}
