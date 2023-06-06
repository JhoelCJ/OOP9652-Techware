package ec.edu.espe.panesrumiñahui.model;

import java.io.FileNotFoundException;

/**
 *
 * @author Diego Casignia, Techware, DCCO-ESPE
 */

public class Inventory {
    
    public void dailySale() throws FileNotFoundException{
        SaleOperation saleOperation = new SaleOperation();
        saleOperation.readSale();
    }
    
    public float totalDailySale() throws FileNotFoundException{
        SaleOperation saleOperation = new SaleOperation();
        float totalDialy = saleOperation.totalDialySale();
        return totalDialy;
    }
    
    public void productStock() throws FileNotFoundException{
        ModifyProduct modifyProduct = new ModifyProduct();
        modifyProduct.readProduct();
    }
    
    public void rawMaterialStock() throws FileNotFoundException{
        ModifyRawMaterial modifyRawMaterial = new ModifyRawMaterial();
        modifyRawMaterial.readRawMaterial();
    }
}
