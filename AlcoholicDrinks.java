
/**
 * AlcoholicDrinks 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class AlcoholicDrinks extends Product implements Tax{ 
    private double taxLate;  
    private double alcohoilcTax; 
    public AlcoholicDrinks(String productName, int productPrice, long barcodeNumber,
    double taxLate, double alcoholicTax){
    super(productName, productPrice, barcodeNumber); 
    this.taxLate = taxLate;
    this.alcoholicTax = alcoholicTax;} 
    
    public int calculateTax(){ 
    }//세금 계산하는 메소드 
    public int getTotalPrice(){ 
    }//술의 총 가격을 알려주는 메소드
}