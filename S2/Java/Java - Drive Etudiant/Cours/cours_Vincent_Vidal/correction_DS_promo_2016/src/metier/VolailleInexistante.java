
package metier;

public class VolailleInexistante extends Exception {

    public VolailleInexistante() {
    }

    public VolailleInexistante(String msg) {
        super(msg);
    }
    @Override
    public String getMessage(){
        return("Cette volaille n'existe pas");
    }
}
