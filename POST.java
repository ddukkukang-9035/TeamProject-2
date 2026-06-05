

/**
 * POST 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class POST
{
    private Sale[] saleDB;
    private Products[] productDB;
    private int saleCount;
    private int productCount;
    
    public POST() {
        this.saleDB = new Sale[1000];
        this.productDB = new Products[100];
        this.productCount = 0;
        this.saleCount = 0;
    }
    
    public int priceCalculate() {
        
    }
    
    public String printProducts() {
        
    }
    
    public int changeCalculate() {
        
    }
    
    public Sale saleInfoSave() {
    
    }
    
    public Products setProduct(Products product) {
        for (int i = 0; i < productCount; i++) {
            if (productDB[i].getBarcodeNumber() == product.getBarcodeNumber()) {
                return productDB[i];
            }
        }
        productDB[productCount++] = product;
        return product;
    }
}