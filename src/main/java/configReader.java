import java.io.*;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: AshW
 * Date: 28/04/14
 * Time: 16:24
 * To change this template use File | Settings | File Templates.
 */
public class configReader {

    public configReader(String filePath){
        //Constructor reads in a new file and populates an arraylist of tables
        tables = new ArrayList<String>();
        tableList = new File(filePath);
        try{
        buffRead = new BufferedReader(new FileReader(filePath));
        }catch (FileNotFoundException fnf){
            fnf.printStackTrace();
        }
        try {
            String addTable;
            while((addTable = buffRead.readLine()) != null){
                tables.add(addTable);
            }
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }

    public ArrayList<String> returnTablesAsArrayList(){
        return tables;
    }


    private ArrayList<String> tables;
    private File tableList;
    private BufferedReader buffRead;
}
