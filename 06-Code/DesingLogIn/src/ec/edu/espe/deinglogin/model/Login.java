
package ec.edu.espe.deinglogin.model;

//import at.favre.lib.crypto.bcrypt.BCrypt;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.eq;
//import com.mongodb.client.result.UpdateResult;
import java.util.Scanner;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.mindrot.jbcrypt.BCrypt;
//import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;




/**
 *
 * @author Jilmar Calderon, Techware, DCCO-ESPE
 */
public class Login {
 
     public static void createDocument() {

        String uri = "mongodb+srv://gcalvache:gcalvache@cluster0.qsalyjy.mongodb.net/?retryWrites=true&w=majority";
        Scanner readData = new Scanner(System.in);
        try ( MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("Prueba");
            MongoCollection<Document> collection = database.getCollection("Login");

            System.out.print("Username: ");
            String username = readData.next();
            System.out.println("Password");
            String password = readData.next();
            
            String cifrada = "";
		int desplazar = 1;
 
		for (int i = 0; i < password.length(); i++) {
 
			int codigoLetra = password.codePointAt(i);

			char letraDesplazada = (char)(codigoLetra + desplazar);

			cifrada = cifrada + letraDesplazada;
		}

            Document doc1 = new Document("username", username).append("password", cifrada);

            collection.insertOne(doc1);

        }
    }
     public static void deleteDocument() {
         String uri = "mongodb+srv://gcalvache:gcalvache@cluster0.qsalyjy.mongodb.net/?retryWrites=true&w=majority";
        Scanner readData = new Scanner(System.in);
        try ( MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("Prueba");
            MongoCollection<Document> collection = database.getCollection("Login");

        System.out.println("What username do you want to delete?");
        String del = readData.next();
        Bson filter = Filters.eq("username", del);
        Document resultado = collection.find(filter).first();

        if (resultado != null) {
            System.out.println("El dato existe en la colección.");
        } else {
            System.out.println("El dato no existe en la colección.");
        }
    }
}

    public static void readDocument() {
          String uri = "mongodb+srv://gcalvache:gcalvache@cluster0.qsalyjy.mongodb.net/?retryWrites=true&w=majority";
        Scanner readData = new Scanner(System.in);
        try ( MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("Prueba");
            MongoCollection<Document> collection = database.getCollection("Login");

            System.out.println("What Username you want to view?");
            String search = readData.next();
            MongoCursor<Document> cursor = collection.find(eq("Username", search)).cursor();

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
         String uri = "mongodb+srv://gcalvache:gcalvache@cluster0.qsalyjy.mongodb.net/?retryWrites=true&w=majority";
        Scanner readData = new Scanner(System.in);
        try ( MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("Prueba");
            MongoCollection<Document> collection = database.getCollection("Login");

            System.out.println("What Username you want to modify?");
            String search = readData.next();
            Document docmod = collection.find(eq("Username", search)).first();
            System.out.println("Please insert new data:");

            System.out.print("Username: ");
            String username = readData.next();
            System.out.println("Password");
            String password = readData.next();

            Document doc1 = new Document("Username", username).append("Pasword", password);
            UpdateResult result = collection.replaceOne(docmod, doc1);
            System.out.println("Matched document count: " + result.getMatchedCount());
            System.out.println("Modified document count: " + result.getModifiedCount());
        }

    }

    public static void showDatabase() {
        String uri = "mongodb+srv://gcalvache:gcalvache@cluster0.qsalyjy.mongodb.net/?retryWrites=true&w=majority";
        Scanner readData = new Scanner(System.in);
        try ( MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("Prueba");
            MongoCollection<Document> collection = database.getCollection("Login");

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
