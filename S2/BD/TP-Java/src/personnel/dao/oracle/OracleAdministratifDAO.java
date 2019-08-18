package personnel.dao.oracle;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import personnel.dao.IAdministratifDAO;
import personnel.métier.Administratif;

public class OracleAdministratifDAO implements IAdministratifDAO  {
    private static DataSource ds;
    private static Connection connexionBD;
    
    @Override
    public void setDataSource(DataSource ds) {
        OracleAdministratifDAO.ds = ds;
    }
    
    @Override
    public void setConnection(Connection c){
        OracleAdministratifDAO.connexionBD=c;
    }   
    
    @Override
    public List<Administratif> getLesObjetsClasseMétier() {
        ResultSet rset=null;
        Statement stmt=null;
        List<Administratif> listeClasseMétier = null;
        try {
            stmt= connexionBD.createStatement();
            listeClasseMétier = new ArrayList<>();
            rset = stmt.executeQuery("SELECT * from ClasseMétier ….");
            while (rset.next()) {
                    
                }
         }
         catch (SQLException exc) {
            
        } finally {
            try {
                // la clause finally est toujours executée, quoi qu'il arrive
                if (stmt != null) stmt.close();
                if (rset != null) rset.close();
            } catch (SQLException ex) {

            }
        }
        return listeClasseMétier;
    }
}  
