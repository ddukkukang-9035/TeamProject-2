
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
    
    /**
     * 최종 지불 금액 = 기본가격 × 수량 (세금 없음)
     * @return 최종 금액 (원)
     */
    @Override
    public int calcAmount() {
        return getPrice() * getQuantity();
    }

    /**
     * 음료수 상품 정보 출력
     */
    @Override
    public void printInfo() {
        System.out.println("[음료] " + getName() + " | 단가: " + getPrice() + "원" + " | 수량: " + getQuantity() + " | 카테고리: " + category + " | 합계: " + calcAmount() + "원");
    }

    public String getCategory() { return category; }
}