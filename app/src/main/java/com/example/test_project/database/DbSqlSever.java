package com.example.test_project.database;

import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbSqlSever {
    Connection connection;
    final String TAG = "zzzzzz";

    public Connection openConnect(){
        String ip = "10.24.54.101", port = "1433", user = "sa", pass = "Password.1", db = "Session2";
        StrictMode.ThreadPolicy threadPolicy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(threadPolicy);

        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            String connectUrl = "jdbc:jtds:sqlserver://" + ip + ":" + port + ";databasename=" + db +";user=" + user +";password=" + pass +";";
            this.connection = DriverManager.getConnection(connectUrl);
            Log.d(TAG, "openConnect: OK");


        } catch (Exception e) {
            Log.e(TAG, "getCollection: Loi ket noi CSDL" + e.getMessage());
            e.printStackTrace();
        }
        return connection;
    }
}
