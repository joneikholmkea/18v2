package patterns.singleton;

public class DBConnection {

    private static DBConnection dbConnection = new DBConnection();

    private DBConnection(){

    }

    static synchronized DBConnection getInstance(){
        return dbConnection;
    }

}
