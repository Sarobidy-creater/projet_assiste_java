public class Personne {
    public int Identifiant;
    public String Nom;
    public String Adresse;
    public String Contact;


    public Personne(int Identifiant, String Nom, String Adresse, String Contact){
        this.Identifiant = Identifiant;
        this.Nom = Nom;
        this.Adresse = Adresse;
        this.Contact = Contact;
    }
    public String obtenirInfos(){
        return "Informations : "+ "\nIdentifiant : " + getIdentifiant() +
                "\n Nom : " + getNom() +
                "\n Adresse : " + getAdresse() +
                "\nContact : " + getContact();
    };

    public String getNom(){
        return Nom;
    };

    public String getAdresse(){
        return Adresse;
    };

    public int getIdentifiant(){
        return Identifiant;
    };

    public String getContact() {
        return Contact;
    };
}
