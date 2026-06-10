
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
    
    public static void initDB() {
        addToDB(new Beverages("B001", "코카콜라", "탄산음료", 1500, 1));
        addToDB(new Beverages("B002", "포카리스웨트", "이온음료", 1800, 1));
        addToDB(new Beverages("B003", "제주삼다수", "생수",900, 1));
    }
}