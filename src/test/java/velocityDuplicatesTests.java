import org.junit.After;
import org.junit.Test;
import org.junit.Before;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: AshW
 * Date: 22/04/14
 * Time: 16:05
 * To change this template use File | Settings | File Templates.
 */
public class velocityDuplicatesTests {


   @Before
    public void getConnection() throws ClassNotFoundException {

        String urlMSSQL =  "jdbc:sqlserver://PLLPC6229\\ASH;databaseName=dev;user=dev;password=blah";
        String urlMYSQL =  "jdbc:mysql://127.0.0.1:3306/mantis-4-1?user=ashw&password=HBUQXWaN";

        //Use the new connector class
        dbCon = new databaseConnector(urlMSSQL);

        //return a new connection
        try{
        con = dbCon.returnSpecifiedConnection();
        }catch (SQLException ex){
            System.out.println(ex);
        }
    }

    @Test
    public void getStatementTest() throws SQLException {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM themes");
        while(rs.next()){
            int themeId = rs.getInt("themeId");
            String themeURL = rs.getString("themeURL");
            System.out.println(themeId+" ,"+themeURL);
        }


    }

    @Test
    public void configReaderTest() throws IOException {
          conRead = new configReader("C:/tables.txt");
          tableList = new ArrayList<String>();
          tableList = conRead.returnTablesAsArrayList();
          for(int i=0;tableList.size()>i;i++){
              System.out.println(tableList.get(i));
          }

    }

    @After
    public void tearDown() throws SQLException {
        con.close();
        tableList.clear();
    }

    private databaseConnector dbCon;
    private Connection con;
    private configReader conRead;
    private ArrayList<String> tableList;


    }
