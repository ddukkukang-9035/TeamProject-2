
/**
 * Beverages 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class Beverages extends Products{
    private String category;
    
    public Beverages(String barcode, String name, String category,
                     int price, int quantity) {
        super(barcode, name, price, quantity);
        this.category = category;
    }
}