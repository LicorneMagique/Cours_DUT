package personnel.dao.oracle;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import oracle.jdbc.pool.OracleDataSource;
/**
 * Factory. Classe contenant une méthode statique qui crée
 * une source de données Oracle à partir d'un fichier de paramètres de
 *  configuration. Le constructeur est privé.
 */
public class OracleDataSourceDAO extends OracleDataSource  {
    private static OracleDataSourceDAO ods;
    
   private OracleDataSourceDAO() throws SQLException {
   }
   
   public static OracleDataSourceDAO getOracleDataSourceDAO() throws FileNotFoundException, IOException {
        FileInputStream fichier = null;
        try {
            
            Properties props = new Properties();
            fichier = new FileInputStream(
                    ".\\src\\nompackage\\dao\\oracle\\connexion.properties");
            props.load(fichier);
            ods = new OracleDataSourceDAO();
            ods.setDriverType(props.getProperty("pilote"));
            ods.setPortNumber(new Integer(props.getProperty("port")));
            ods.setServiceName(props.getProperty("service"));
            ods.setUser(props.getProperty("user"));
            ods.setPassword(props.getProperty("pwd"));
            ods.setServerName(props.getProperty("serveur"));       
        } catch (SQLException | IOException ex) {
          
        } finally {
            try {
                fichier.close();
            } catch (IOException ex) {
            
            }
        }
        return ods;
    }
} // Fin Classe OracleDataSourceDAO