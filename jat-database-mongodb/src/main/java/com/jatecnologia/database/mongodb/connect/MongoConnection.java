package com.jatecnologia.database.mongodb.connect;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.MongoClient;


public class MongoConnection {
    private static final String HOST = "localhost";
    private static final int PORT = 27017;    

    private static MongoConnection uniqInstance;
    private static int mongoInstance = 1;

    private MongoClient mongo;
    private DB db;

    private MongoConnection() {}

    public static synchronized MongoConnection getInstance() {
        if (uniqInstance == null) {
            uniqInstance = new MongoConnection();
        }
        return uniqInstance;
    }

    /**
     * Host is 'localhost'
     * Port is default (27017)
     * 
     * @param database_name
     * @return
     */
    public DB getDB(String database_name) {
        if (mongo == null) {
            try {
                mongo = new MongoClient(HOST, PORT);
                db = mongo.getDB(database_name);
                System.out.println("Mongo instance equals :> " + mongoInstance++);
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }
        return db;
    }
    public DB getDB(String host, int port, String database_name) {
        if (mongo == null) {
            try {
                mongo = new MongoClient(host, port);
                db = mongo.getDB(database_name);
                System.out.println("Mongo instance equals :> " + mongoInstance++);
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }
        return db;
    }    
    
}
