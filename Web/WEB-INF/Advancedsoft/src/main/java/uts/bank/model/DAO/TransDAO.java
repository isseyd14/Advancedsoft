package uts.bank.model.DAO;

// import java.util.ArrayList;
// import java.util.List;

import org.bson.Document;

import com.mongodb.client.*;


public class TransDAO{
    String uri = "mongodb+srv://admin:admin@cluster0.2hlmjh5.mongodb.net/?retryWrites=true&w=majority";
    MongoClient mongoClient = MongoClients.create(uri);
    MongoDatabase database = mongoClient.getDatabase("bank");
    MongoCollection<Document> collection = database.getCollection("transaction");

    

}