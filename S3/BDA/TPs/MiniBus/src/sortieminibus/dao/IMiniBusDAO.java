package sortieminibus.dao;

import java.sql.Connection;
import java.util.List;
import javax.sql.DataSource;
import sortieminibus.metier.MiniBus;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author p1702401
 */
public interface IMiniBusDAO {
    
    public void setDataSource(DataSource ds);

    public void setConnection(Connection c);
    
    public abstract List<MiniBus> getLesObjetsMiniBus();
    
}
