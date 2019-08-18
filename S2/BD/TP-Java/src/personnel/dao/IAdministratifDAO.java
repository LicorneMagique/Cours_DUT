package personnel.dao;

import java.sql.Connection;
import java.util.List;
import javax.sql.DataSource;
import personnel.métier.Administratif;

public interface IAdministratifDAO {
    
    public void setDataSource(DataSource ds);
    
    public void setConnection(Connection c);
    
    public List<Administratif> getLesObjetsClasseMétier();
    
}
