package sortieminibus.dao.oracle;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import sortieminibus.dao.IMiniBusDAO;
import sortieminibus.metier.MiniBus;

public class OracleMinibusDAO implements IMiniBusDAO {
    
    private static DataSource ds;
    private static Connection connexionBD;
    
    @Override
    public void setDataSource(DataSource ds) {
        OracleMinibusDAO.ds = ds;
    }
    
    @Override
    public void setConnection(Connection c) {
        OracleMinibusDAO.connexionBD = c;
    }
    
    @Override
    public List<MiniBus> getLesObjetsMiniBus() {
        ResultSet rset = null;
        Statement stmt = null;
        List<MiniBus> listeMinibus = null;
        try {
            stmt = connexionBD.createStatement();
            listeMinibus = new ArrayList<>();
            rset = stmt.executeQuery("SELECT * FROM minibus");
            while (rset.next()) {
                listeMinibus.add(new MiniBus(rset.getInt("nominibus"), rset.getInt("capacite")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(OracleMinibusDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (rset != null) rset.close();
            } catch (SQLException ex) {
                Logger.getLogger(OracleMinibusDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listeMinibus;
    }
}
