
/**
 * AlcoholicDrinks 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class AlcoholicDrinks extends Products implements Tax{ 
    private static float alcohoilcTax; 

    /**
     * 메소드 예제 - 사용자에 맞게 주석을 바꾸십시오.
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 와 y의 합
     */
    public AlcoholicDrinks(String productName, int productPrice, long barcodeNumber, float alcoholicTax){
        this.productName = productName;
        this.productPrice = productPrice;
        this.barcodeNumber = barcodeNumber; 
        this.alcoholicTax = alcoholicTax;
    }

    /**
     * 메소드 예제 - 사용자에 맞게 주석을 바꾸십시오.
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 와 y의 합
     */
    public int calculateTax(){ 
    }//세금 계산하는 메소드 

    /**
     * 메소드 예제 - 사용자에 맞게 주석을 바꾸십시오.
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 와 y의 합
     */
    public int getTotalPrice(){ 
    }//술의 총 가격을 알려주는 메소드
}