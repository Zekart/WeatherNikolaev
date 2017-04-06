package weatherApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author zekart
 */
public class DbConnector {

    public DbConnector(String city, String temp, String time) {
    
    try
    {
        // Загрузка драйвера
        Class.forName("org.sqlite.JDBC");
        Connection connection = null;
        
        try
        {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:/home/zekart/NetBeansProjects/WeatherNikolaev/src/db/database");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // Установить тайм-аут в 30 сек
            
            statement.executeUpdate("insert into weather_keeper values('"+city+"','"+temp+"', '"+time+"')");
            
//            ResultSet rs = statement.executeQuery("select * from weather_keeper");
//            while(rs.next())
//            {
//                // Получить результат
//                System.out.println("city = " + rs.getString("City"));
//                
//            }
        }
        catch(SQLException e)
        {
            // Не найден файл БД
            System.err.println(e.getMessage());
        }
        finally
        {
            try
            {
                if(connection != null)
                    connection.close();
            }
            catch(SQLException e)
            {
                // connection close failed.
                System.err.println(e);
            }
        }
      }
      catch(ClassNotFoundException e)
      {
            System.err.println(e);
      }
    }
  }

