
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

    /**    ㅠㅍㅊ
     * 메소드 예제 - 사용자에 맞게 주석을 바꾸십시오.
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 와 y의 합
     */
    public POST() {
        this.saleDB = new Sale[1000];
        this.productDB = new Products[100];
        this.productCount = 0;
        this.saleCount = 0;
    }

    /**
     * 메소드 예제 - 사용자에 맞게 주석을 바꾸십시오.
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 와 y의 합
     */
    public int priceCalculate() {

    }

    /**
     * 메소드 예제 - 사용자에 맞게 주석을 바꾸십시오.
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 와 y의 합
     */
    public String printProducts() {

    }

    /**
     * 메소드 예제 - 사용자에 맞게 주석을 바꾸십시오.
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 와 y의 합
     */
    public int changeCalculate() {

    }

    /**
     * 메소드 예제 - 사용자에 맞게 주석을 바꾸십시오.
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 와 y의 합
     */
    public Sale saleInfoSave() {

    }

    /**
     * 메소드 예제 - 사용자에 맞게 주석을 바꾸십시오.
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 와 y의 합
     */
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