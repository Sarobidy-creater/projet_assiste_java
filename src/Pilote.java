public class Pilote extends Employe {
    private String licence;
    private int heuresDeVol;

    public Pilote(int identifiant, String nom, String adresse, String contact, String numeroEmploye, String dateEmbauche, String licence, int heuresDeVol) {
        super(identifiant, nom, adresse, contact, numeroEmploye, dateEmbauche);
        this.licence = licence;
        this.heuresDeVol = heuresDeVol;
    }

    public String getLicence() { return licence; }
    public int getHeuresDeVol() { return heuresDeVol; }

    public void affecterVol() {
        System.out.println("Pilote " + getNom() + " affecté au vol.");
    }

    public void obtenirVol() {
        System.out.println("Vol du pilote " + getNom());
    }

    @Override
    public String obtenirRole() {
        return "Pilote";
    }

    @Override
    public String obtenirInfos() {
        return super.obtenirInfos() +
               "\nLicence : " + licence +
               "\nHeures de vol : " + heuresDeVol;
    }
}

