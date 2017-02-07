package DBConnexion;
/**
 * connection to SQLite database
 * @author          Adrián Castelló Martínez; Macarena Parrizas Siles; Benedikt Futterer; Fabian Finkbeiner
 * creation        20.10.2016
 * @version         18.01.2017
 * @exception       database connection not successful
 */
import java.sql.*;
import javax.swing.JOptionPane;

public class DBConnexion {
    //Constructor
    public DBConnexion (String sql) {
        try {
            //Connects to the DataBase located on the project folder
            Connection c=DriverManager.getConnection("jdbc:sqlite:DrawingProject.sqlite");
            Statement s=c.createStatement();
            if(s.execute(sql)){
                ResultSet rs=s.getResultSet();
                int z=rs.getMetaData().getColumnCount();
                while (rs.next()){
                    for(int i=1; i<=z; i++){
                        if(i!=z)
                            System.out.print(rs.getString(i)+", ");
                        else
                            System.out.print(rs.getString(i)+"\n ");
                    }
                }
            }
            else
                System.out.println(s.getUpdateCount());
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex);
            ex.printStackTrace();
        }
    }
}
