package ec.edu.espe.panesdelaruminahui.controler;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import java.util.Scanner;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author Gabriel Baez, Techware, DCCO-ESPE
 */
public class SalesDB {
         public static void createDocument() {

        String uri = "mongodb+srv://jcalderon:jcalderon@cluster0.94svwj5.mongodb.net/?retryWrites=true&w=majority";
        Scanner readData = new Scanner(System.in);
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("PanesDeLaRuminahui");
            MongoCollection<Document> collection = database.getCollection("sale");

            System.out.print("id: ");
            int id = readData.nextInt();
            System.out.print("totalSales: ");
            float totalSales = readData.nextFloat();

            Document doc1 = new Document("id", id).append("totalSales", totalSales);
            InsertOneResult result = collection.insertOne(doc1);
            System.out.println("Inserted a document with the following id: "
                    + result.getInsertedId().asObjectId().getValue());
        }
    }

    public static void deleteDocument() {
        
        String uri = "mongodb+srv://jcalderon:jcalderon@cluster0.94svwj5.mongodb.net/?retryWrites=true&w=majority";
        Scanner readData = new Scanner(System.in);
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("PanesDeLaRuminahui");
            MongoCollection<Document> collection = database.getCollection("sale");

            System.out.println("What id you Want delete?");
            int del = readData.nextInt();
            Bson filter = Filters.eq("id", del);
            collection.deleteOne(filter);
            System.out.println("Deleted Succesfull");
  }
    }

    public static void readDocument() {
        
        String uri = "mongodb+srv://jcalderon:jcalderon@cluster0.94svwj5.mongodb.net/?retryWrites=true&w=majority";
        Scanner readData = new Scanner(System.in);
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("PanesDeLaRuminahui");
            MongoCollection<Document> collection = database.getCollection("sale");

            System.out.println("What id you want to view?");
            int search = readData.nextInt();
            MongoCursor<Document> cursor = collection.find(eq("id", search)).cursor();

            try {
                while (cursor.hasNext()) {
                    System.out.println(cursor.next().toJson());
                }
            } finally {
                cursor.close();
   }
        }
    }

    public static void modifyDocument() {
        
        String uri = "mongodb+srv://jcalderon:jcalderon@cluster0.94svwj5.mongodb.net/?retryWrites=true&w=majority";
        Scanner readData = new Scanner(System.in);
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("PanesDeLaRuminahui");
            MongoCollection<Document> collection = database.getCollection("sale");

            System.out.println("What ID you want to modify?");
            int search = readData.nextInt();
            Document docmod = collection.find(eq("id", search)).first();
            System.out.println("Please insert new data:");

            
             System.out.print("id: ");
            int id = readData.nextInt();
            System.out.print("invoiceNumber: ");
            String invoiceNumber = readData.next();
            System.out.print("name: ");
            String name = readData.next();
            System.out.print("amount: ");
            int amount = readData.nextInt();
            while (amount <= -1) {
                System.out.println("No allowed");
                System.out.print("Age:");
                amount = readData.nextInt();
            }
            System.out.print("price: ");
            float price = readData.nextFloat();

            Document doc1 = new Document("id", id).append("invoiceNumber", invoiceNumber).append("name", name).append("amount", amount).append("price", price);

            UpdateResult result = collection.replaceOne(docmod, doc1);
            System.out.println("Matched document count: " + result.getMatchedCount());
            System.out.println("Modified document count: " + result.getModifiedCount());
        }
    }

    public static void showDatabase() {
        
        String uri = "mongodb+srv://jcalderon:jcalderon@cluster0.94svwj5.mongodb.net/?retryWrites=true&w=majority";
        Scanner readData = new Scanner(System.in);
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("PanesDeLaRuminahui");
            MongoCollection<Document> collection = 
                    database.getCollection("sale");

            MongoCursor<Document> cursor = collection.find().cursor();

            try {
                while (cursor.hasNext()) {
                    System.out.println(cursor.next().toJson());
                }
            } finally {
                cursor.close();
            }
        }
    }
}
