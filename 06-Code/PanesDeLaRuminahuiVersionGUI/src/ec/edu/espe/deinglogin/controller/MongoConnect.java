package ec.edu.espe.deinglogin.controller;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import javax.swing.JOptionPane;
import org.bson.Document;
import org.bson.conversions.Bson;
import ec.edu.espe.deinglogin.model.Sale;
import ec.edu.espe.deinglogin.view.LoginGUI;
import ec.edu.espe.deinglogin.view.MainPage;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jilmar Calderon, Techware, DCCO-ESPE
 */
public class MongoConnect {
    public void inventoryConnect(ArrayList<Sale> saleList, DefaultTableModel model, javax.swing.JTable tabList){
        
        Sale sale;
        String uri = "mongodb+srv://jcalderon:jcalderon@cluster0.94svwj5.mongodb.net/?retryWrites=true&w=majority";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("PanesDeLaRuminahui");
            MongoCollection<Document> collection = database.getCollection("inventory");
            
            int sizeSaleList = saleList.size();
            
            for (int i = 0; i < sizeSaleList; i++) {
                sale = saleList.get(i);
                Bson usernameFilter = Filters.eq("Id", sale.getId());
                Document productDocument = collection.find(usernameFilter).first();
                if (productDocument != null) {
                    int amount = productDocument.getInteger("Ammount");
                    amount = amount - sale.getAmount();
                    Bson update = new Document("$set", new Document("Ammount", amount));
                    collection.updateOne(usernameFilter, update);
                } else {
                    JOptionPane.showMessageDialog(null, "Producto no encontrado");
                }
                model.removeRow(0);
                tabList.setModel(model);
            }
        } catch (MongoException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos");
            e.printStackTrace();
        }
    }
    public void incomeConnect(ArrayList<Sale> saleList, float finalPrice){

    Sale sale;
        
    String uri = "mongodb+srv://jcalderon:jcalderon@cluster0.94svwj5.mongodb.net/?retryWrites=true&w=majority";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("PanesDeLaRuminahui");
            MongoCollection<Document> collection = database.getCollection("income");

            int id;
            String name;
            int amount;
            float price;
            
            for(int i=0; i<saleList.size(); i++){
                
            sale = saleList.get(i);
                
            id = sale.getId();
            name = sale.getNameProduct();
            amount = sale.getAmount();
            price = sale.getTotalPrice();
            
            Document doc1 = new Document("Id", id).append("Name", name).append("Ammount", amount).append("Price", price).append("Final Price", finalPrice);

            collection.insertOne(doc1);
            } 
        }

    }
            
    public boolean loginConnect( String username, String password ){
        
        boolean txtDelete = true;
        
        String uri = "mongodb+srv://jcalderon:jcalderon@cluster0.94svwj5.mongodb.net/?retryWrites=true&w=majority";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("PanesDeLaRuminahui");
            MongoCollection<Document> collection = database.getCollection("login");

            String cifrada = "";
            int desplazar = 1;

            for (int i = 0; i < password.length(); i++) {
                int codigoLetra = password.codePointAt(i);
                char letraDesplazada = (char) (codigoLetra + desplazar);
                cifrada = cifrada + letraDesplazada;
            }

            Bson usernameFilter = Filters.eq("User", username);
            Document userDocument = collection.find(usernameFilter).first();

            if (userDocument != null) {
                String storedPassword = userDocument.getString("Pasword");
                if (storedPassword.equals(cifrada)) {

                    Date fechaActual = new Date();

                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    String fechaTexto = sdf.format(fechaActual);

                    userDocument.append("Fecha de entrada:  ", fechaTexto);

                    collection.replaceOne(usernameFilter, userDocument);
                    MainPage mainPage = new MainPage();
                    mainPage.setVisible(true);
                    LoginGUI loginGUI = new LoginGUI();
                    loginGUI.setVisible(false);
                    
                    txtDelete = false;

                } else {
                    JOptionPane.showMessageDialog(null, "Contraseña incorrecta ");

                }
            } else {
                JOptionPane.showMessageDialog(null, "Usuario no encontrado ");

            }
        } catch (MongoException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos ");
            e.printStackTrace();
        }
        return txtDelete;
    }
}
