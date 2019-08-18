
package metier;

public class VolailleExistante extends Exception {

    public VolailleExistante() {
    }


    public VolailleExistante(String msg) {
        super(msg);
    }
    
    @Override
    public String getMessage(){
        return("Cette volaille existe déjà");
    }
}
