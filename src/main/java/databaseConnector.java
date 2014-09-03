import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: AshW
 * Date: 22/04/14
 * Time: 15:54
 * To change this template use File | Settings | File Templates.
 */
public class databaseConnector {

    public databaseConnector(String url){
        this.url = url;
    }

    public Connection returnSpecifiedConnection() throws SQLException, ClassNotFoundException {

        if(url.startsWith("jdbc:mysql")){
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url);
            return con;
        }else if(url.startsWith("jdbc:sqlserver")){
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(url);
            return con;
        }else{
        return null;
        }
    }

    private String url;
    private Connection con;


}
