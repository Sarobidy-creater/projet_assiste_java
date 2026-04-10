public class PersonnelCabine extends Employe {
    private String qualification;

    public PersonnelCabine(int identifiant, String nom, String adresse, String contact, String numeroEmploye, String dateEmbauche, String qualification) {
        super(identifiant, nom, adresse, contact, numeroEmploye, dateEmbauche);
        this.qualification = qualification;
    }

    public String getQualification() { return qualification; }

    public void affecterVol() {
        System.out.println("Personnel cabine " + getNom() + " affecté au vol.");
    }

    public void obtenirVol() {
        System.out.println("Vol du personnel cabine " + getNom());
    }

    @Override
    public String obtenirRole() {
        return "Personnel Cabine";
    }

    @Override
    public String obtenirInfos() {
        return super.obtenirInfos() +
               "\nQualification : " + qualification;
    }
}

