package ec.edu.espe.deinglogin.view;

import ec.edu.espe.deinglogin.model.Product;
import ec.edu.espe.deinglogin.model.Sale;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import ec.edu.espe.deinglogin.model.Inventory;
import javax.swing.JOptionPane;
import org.bson.Document;
import org.bson.conversions.Bson;
import java.util.*;
import ec.edu.espe.utils.ValidationUtil;

/**
 *
 * @author Diego Casignia, Techware, DCCO-ESPE
 */
public class MainPage extends javax.swing.JFrame {

    /**
     * Creates new form MainPage
     */
    DefaultTableModel model = new DefaultTableModel();
    Product product;
    ArrayList<Sale> saleList = new ArrayList<>();
    Sale sale;

    public MainPage() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        getContentPane().setBackground(Color.white);
        initAllPanel();
        addTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtAmount = new javax.swing.JTextField();
        txtUnitValue = new javax.swing.JTextField();
        txtFullValue = new javax.swing.JTextField();
        bntNewProduct = new javax.swing.JButton();
        btnAddProduct = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btnFinishSale = new javax.swing.JButton();
        btnNewSale = new javax.swing.JButton();
        txtFinalPrice = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabList = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuInventory = new javax.swing.JMenu();
        itmAddRawMaterial = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        mnuHelp = new javax.swing.JMenu();
        mniHelp = new javax.swing.JMenuItem();
        mnExit = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Panes de la Rumiñahui");
        setName("mainPage"); // NOI18N

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(650, 625));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Código del Producto");

        txtId.setBackground(new java.awt.Color(255, 255, 255));
        txtId.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtId.setForeground(new java.awt.Color(0, 0, 0));
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });
        txtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIdKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIdKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Cantidad");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Valor por unidad");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Valor Total");

        txtAmount.setBackground(new java.awt.Color(255, 255, 255));
        txtAmount.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtAmount.setForeground(new java.awt.Color(0, 0, 0));
        txtAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAmountKeyPressed(evt);
            }
        });

        txtUnitValue.setEditable(false);
        txtUnitValue.setBackground(new java.awt.Color(255, 255, 255));
        txtUnitValue.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        txtUnitValue.setForeground(new java.awt.Color(0, 0, 0));
        txtUnitValue.setRequestFocusEnabled(false);

        txtFullValue.setEditable(false);
        txtFullValue.setBackground(new java.awt.Color(255, 255, 255));
        txtFullValue.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        txtFullValue.setForeground(new java.awt.Color(0, 0, 0));
        txtFullValue.setRequestFocusEnabled(false);

        bntNewProduct.setBackground(new java.awt.Color(255, 255, 255));
        bntNewProduct.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bntNewProduct.setForeground(new java.awt.Color(0, 0, 0));
        bntNewProduct.setText("Nuevo Producto");
        bntNewProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntNewProductActionPerformed(evt);
            }
        });

        btnAddProduct.setBackground(new java.awt.Color(255, 255, 255));
        btnAddProduct.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnAddProduct.setForeground(new java.awt.Color(0, 0, 0));
        btnAddProduct.setText("Agregar Producto");
        btnAddProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProductActionPerformed(evt);
            }
        });
        btnAddProduct.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnAddProductKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtFullValue, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                            .addComponent(txtUnitValue, javax.swing.GroupLayout.Alignment.LEADING))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bntNewProduct)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                        .addComponent(btnAddProduct)
                        .addGap(117, 117, 117))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(txtUnitValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(txtFullValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntNewProduct)
                    .addComponent(btnAddProduct))
                .addContainerGap(102, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(665, 625));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Lista de Productos");

        btnFinishSale.setBackground(new java.awt.Color(255, 255, 255));
        btnFinishSale.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnFinishSale.setForeground(new java.awt.Color(0, 0, 0));
        btnFinishSale.setText("Finalizar Venta");
        btnFinishSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinishSaleActionPerformed(evt);
            }
        });

        btnNewSale.setBackground(new java.awt.Color(255, 255, 255));
        btnNewSale.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnNewSale.setForeground(new java.awt.Color(0, 0, 0));
        btnNewSale.setText("Nueva Venta");
        btnNewSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewSaleActionPerformed(evt);
            }
        });

        txtFinalPrice.setEditable(false);
        txtFinalPrice.setBackground(new java.awt.Color(255, 255, 255));
        txtFinalPrice.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        txtFinalPrice.setForeground(new java.awt.Color(0, 0, 0));
        txtFinalPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFinalPriceActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Precio Final");

        tabList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jScrollPane1.setViewportView(tabList);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(146, Short.MAX_VALUE)
                .addComponent(btnNewSale)
                .addGap(125, 125, 125)
                .addComponent(btnFinishSale)
                .addGap(135, 135, 135))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(txtFinalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(txtFinalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNewSale)
                    .addComponent(btnFinishSale))
                .addGap(81, 81, 81))
        );

        mnuInventory.setText("Inventario");
        mnuInventory.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        itmAddRawMaterial.setText("Ir al Invetario");
        itmAddRawMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmAddRawMaterialActionPerformed(evt);
            }
        });
        mnuInventory.add(itmAddRawMaterial);

        jMenuBar1.add(mnuInventory);

        jMenu1.setText("Presupuesto");

        jMenuItem2.setText("Gastos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        mnuHelp.setText("Ayuda");
        mnuHelp.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mnuHelp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        mniHelp.setText("Contacto");
        mniHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniHelpActionPerformed(evt);
            }
        });
        mnuHelp.add(mniHelp);

        jMenuBar1.add(mnuHelp);

        mnExit.setText("Finalizar");

        jMenuItem1.setText("Cerrar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        mnExit.add(jMenuItem1);

        jMenuBar1.add(mnExit);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bntNewProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntNewProductActionPerformed
        initPanelProduct();
    }//GEN-LAST:event_bntNewProductActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed

    }//GEN-LAST:event_txtIdActionPerformed

    private void txtIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyReleased

    }//GEN-LAST:event_txtIdKeyReleased

    private void txtIdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyPressed
        ValidationUtil validationUtil = new ValidationUtil();
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            if (validationUtil.validateInt(txtId.getText())) {

                int id = Integer.parseInt(txtId.getText());
                validateProduct(id);
                txtAmount.requestFocus();
                txtUnitValue.setText(String.valueOf(product.getBudgetProduct()));
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese un un numero positivo para el Id");
                txtId.setText("");
                txtId.requestFocus();
            }

        }
    }//GEN-LAST:event_txtIdKeyPressed

    private void validateProduct(int id) {
        String uri = "mongodb+srv://gcalvache:gcalvache@cluster0.qsalyjy.mongodb.net/?retryWrites=true&w=majority";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("Prueba");
            MongoCollection<Document> collection = database.getCollection("Inventario");

            //Bson usernameFilter = Filters.eq("Id", String.valueOf(id));
            Bson usernameFilter = Filters.eq("Id", id);
            Document productDocument = collection.find(usernameFilter).first();

            if (productDocument != null) {
                String nameProduct = productDocument.getString("Name");
                float budgetProduct = productDocument.getDouble("Price").floatValue();
                System.out.println(budgetProduct);
                int stock = productDocument.getInteger("Ammount");
                System.out.println(stock);
                product = new Product(id, nameProduct, budgetProduct, stock);
            } else {
                JOptionPane.showMessageDialog(null, "Producto no encontrado");
            }
        } catch (MongoException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos");
            e.printStackTrace();
        }
    }

    private void btnAddProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProductActionPerformed
        
        ValidationUtil validationUtil = new ValidationUtil();

        boolean validate = true;
        
        int id = 0;
        int amount = 0;
        float totalPrice = 0;
        
            if (validationUtil.validateInt(txtId.getText())) {
                btnAddProduct.requestFocus();
                id = Integer.parseInt(txtId.getText());
                validateProduct(id);
                txtAmount.requestFocus();
                //txtUnitValue.setText(String.valueOf(product.getBudgetProduct()));
                
                if (validationUtil.validateInt(txtAmount.getText())) {

                amount = Integer.parseInt(txtAmount.getText());
                txtFullValue.setText(String.valueOf(product.getBudgetProduct() * amount));
                totalPrice = product.getBudgetProduct() * amount;
                
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese un un numero positivo para la Cantidad");
                validate = false;
                txtAmount.setText("");
                txtAmount.requestFocus();
            }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese un un numero positivo para el Id");
                txtId.setText("");
                txtId.requestFocus();
                validate = false;
            }    

            if (validate) {
                
                
                sale = new Sale(product.getId(), product.getNameProduct(), amount, product.getBudgetProduct(), totalPrice);
                saleList.add(sale);
                addProductToList();
                initPanelProduct();
            }
    }//GEN-LAST:event_btnAddProductActionPerformed

    private void txtAmountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAmountKeyPressed
        ValidationUtil validationUtil = new ValidationUtil();

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            if (validationUtil.validateInt(txtId.getText())) {
                btnAddProduct.requestFocus();
                int id = Integer.parseInt(txtId.getText());
                validateProduct(id);
                txtAmount.requestFocus();
                txtUnitValue.setText(String.valueOf(product.getBudgetProduct()));
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese un un numero positivo para el Id");
                txtId.setText("");
                txtId.requestFocus();
            }
            if (validationUtil.validateInt(txtAmount.getText())) {

                int amount = Integer.parseInt(txtAmount.getText());
                txtFullValue.setText(String.valueOf(product.getBudgetProduct() * amount));
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese un un numero positivo para la Cantidad");
                txtAmount.setText("");
                txtAmount.requestFocus();
            }
            btnAddProduct.requestFocus();
        }
    }//GEN-LAST:event_txtAmountKeyPressed

    private void btnNewSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewSaleActionPerformed
        int rowTable = tabList.getRowCount();
        for (int i = 1; i <= rowTable; i++) {
            model.removeRow(0);
            tabList.setModel(model);
        }
        initAllPanel();
    }//GEN-LAST:event_btnNewSaleActionPerformed

    private void btnFinishSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinishSaleActionPerformed
        saveSale();
        String uri = "mongodb+srv://gcalvache:gcalvache@cluster0.qsalyjy.mongodb.net/?retryWrites=true&w=majority";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("Prueba");
            MongoCollection<Document> collection = database.getCollection("Inventario");
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
        initAllPanel();
    }//GEN-LAST:event_btnFinishSaleActionPerformed
    
    private void saveSale(){
        String uri = "mongodb+srv://gcalvache:gcalvache@cluster0.qsalyjy.mongodb.net/?retryWrites=true&w=majority";

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("Prueba");
            MongoCollection<Document> collection = database.getCollection("Ingresos");

            int id;
            String name;
            int amount;
            float price;
            float finalPrice;
            
            for(int i=0; i<saleList.size(); i++){
                
            sale = saleList.get(i);
                
            id = sale.getId();
            name = sale.getNameProduct();
            amount = sale.getAmount();
            price = sale.getTotalPrice();
            finalPrice = Float.parseFloat(txtFinalPrice.getText());  
            
            Document doc1 = new Document("Id", id).append("Name", name).append("Ammount", amount).append("Price", price).append("Final Price", finalPrice);

            collection.insertOne(doc1);
            } 
        }
    }
    
    private void btnAddProductKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAddProductKeyPressed
        ValidationUtil validationUtil = new ValidationUtil();
        
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            boolean validate = true;
        
        int id = 0;
        int amount = 0;
        float totalPrice = 0;
        
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            
            
            if (validationUtil.validateInt(txtId.getText())) {
                btnAddProduct.requestFocus();
                id = Integer.parseInt(txtId.getText());
                validateProduct(id);
                txtAmount.requestFocus();
                
                if (validationUtil.validateInt(txtAmount.getText())) {

                amount = Integer.parseInt(txtAmount.getText());
                txtFullValue.setText(String.valueOf(product.getBudgetProduct() * amount));
                totalPrice = product.getBudgetProduct() * amount;
                
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese un un numero positivo para la Cantidad");
                validate = false;
                txtAmount.setText("");
                txtAmount.requestFocus();
            }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese un un numero positivo para el Id");
                txtId.setText("");
                txtId.requestFocus();
                validate = false;
            }    

            if (validate) {
                
                
                sale = new Sale(product.getId(), product.getNameProduct(), amount, product.getBudgetProduct(), totalPrice);
                saleList.add(sale);
                addProductToList();
                initPanelProduct();
            }

        }
        }

        
    }//GEN-LAST:event_btnAddProductKeyPressed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        LoginGUI loginGUI = new LoginGUI();
        loginGUI.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void itmAddRawMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmAddRawMaterialActionPerformed
        InventoryGUI inventoryGUI = new InventoryGUI();
        inventoryGUI.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_itmAddRawMaterialActionPerformed

    private void txtFinalPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFinalPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFinalPriceActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        IncomeGUI billsGUI = new IncomeGUI();
        billsGUI.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void mniHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniHelpActionPerformed
        JOptionPane.showMessageDialog(rootPane, "Por faovr contactese al siguiente numero: 0987654321");
    }//GEN-LAST:event_mniHelpActionPerformed

    private void addProductToList() {
        float finalPrice = Float.parseFloat(txtFinalPrice.getText());
        model.addRow(new Object[]{sale.getId(), sale.getNameProduct(), sale.getAmount(), sale.getUnitPrice(), sale.getTotalPrice()});
        tabList.setModel(model);
        finalPrice = finalPrice + sale.getTotalPrice();
        txtFinalPrice.setText(String.valueOf(finalPrice));
    }

    private void initAllPanel() {
        initPanelProduct();
        txtFinalPrice.setText("0.0");
    }

    private void initPanelProduct() {
        txtId.setText("");
        txtAmount.setText("");
        txtUnitValue.setText("0.0");
        txtFullValue.setText("0.0");
        txtId.requestFocus();
    }

    private void addTable() {
        model.addColumn("Codigo");
        model.addColumn("Nombre");
        model.addColumn("Cantidad");
        model.addColumn("Precio Unitario");
        model.addColumn("Precio Total");
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainPage().setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntNewProduct;
    private javax.swing.JButton btnAddProduct;
    private javax.swing.JButton btnFinishSale;
    private javax.swing.JButton btnNewSale;
    private javax.swing.JMenuItem itmAddRawMaterial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu mnExit;
    private javax.swing.JMenuItem mniHelp;
    private javax.swing.JMenu mnuHelp;
    private javax.swing.JMenu mnuInventory;
    private javax.swing.JTable tabList;
    private javax.swing.JTextField txtAmount;
    private javax.swing.JTextField txtFinalPrice;
    private javax.swing.JTextField txtFullValue;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtUnitValue;
    // End of variables declaration//GEN-END:variables
}
