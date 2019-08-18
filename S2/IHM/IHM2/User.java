package fr.scarex.projetihms2;

import java.io.File;

import fr.scarex.projetihms2.view.ProjetIHM;


/**
 * @author SCAREX
 *
 */
public class User
{
    public static final String PIC_DATABASE = "/db/pp/";
    public static final String DEFAULT_PIC = "default.jpg";
    private String id;
    private String mdp;
    
    public User(String id, String mdp) {
        this.id = id;
        this.mdp = mdp;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @param mdp the mdp to set
     */
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    
    /**
     * @return the mdp
     */
    public String getMdp() {
        return mdp;
    }

    public boolean checkMDP(String mdp) {
        return this.mdp.equals(mdp);
    }
    
    public File getUserPic() {
        return new File(ProjetIHM.SOFTWARE_DATA + PIC_DATABASE, this.id + ".png");
    }

    public static File getDefaultPic() {
        return new File(ProjetIHM.SOFTWARE_DATA + PIC_DATABASE + DEFAULT_PIC);
    }
}
