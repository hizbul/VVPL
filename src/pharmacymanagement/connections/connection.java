/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacymanagement.connections;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author drag me to hell
 */
public class connection {
    private Connection con;

     

    public connection(){
    }
     

    public Connection connect(){
        if(con == null){
            MysqlDataSource db = new MysqlDataSource();
            db.setDatabaseName("db_apotek");
            db.setUser("root");
            db.setPassword("");
            try {
                con = db.getConnection();
            } catch (SQLException e) {
            }
        }
        return con;
    }
    
}
