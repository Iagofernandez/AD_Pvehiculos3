
package pvehiculos3;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Pvehiculos3 {
/*
        Ejercicio Pvehiculos3
        Recoger datos de objectdb y Sql e insertar en DBMongo
        */
    private static MongoClient mongocliente;
    private static MongoDatabase database;
    private static MongoCollection collection;
    
    
    public void conexion() throws SQLException{
         /*
    Variables static generales Mongo
    */
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("/home/oracle/objectdb-2.7.5_01/db/vehicli2.odb");
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    
    
    Connection connection;
        String driver = "jdbc:oracle:thin:";
        String host = "localhost.localdomain"; 
        String porto = "1521";
        String sid = "orcl";
        String usuario = "hr";
        String password = "hr";
        String url = driver + usuario + "/" + password + "@" + host + ":" + porto + ":" + sid;
        
        connection = DriverManager.getConnection(url);
        
    
    mongocliente = new MongoClient("localhost", 27017);
    database = mongocliente.getDatabase("test");
    collection = database.getCollection("finalveh");
    
    mongocliente.close();
    connection.close();
    em.close();
    }
    public static void main(String[] args) {
        
    }
    
}
