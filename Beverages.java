/**
 * Beverages 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class Beverages extends Products implements TAX{

    public Beverages(long barcode, String name, int price) {
        this.barcode = barcode;
        this.name = name;
        this.price = price;
    }

    /**
     * 상품DB에 상품을 추가하는 메서드
     */
    public static void initDB(){
        addToDB(new Beverages(8800000000004L, "코카콜라", 1500));
        addToDB(new Beverages(8800000000005L, "포카리스웨트", 1800));
        addToDB(new Beverages(8800000000006L, "제주삼다수",900));
    }

    /**
     * 상품세금 적용 전 금액 = 기본가격 × 수량
     * @return 최종 금액 (원)
     */
    @Override
    public int calcAmount() {
        int result = getPrice();
        return getPrice();
    }

    /**
     * 음료수 상품 정보 출력
     */
    @Override
    public void printInfo() {
        int vat = calcTax();
        int taxableAmount = getPrice() - vat;
        System.out.println("[음료] " + getName() + " | 단가: " + getPrice() + "원 | 과세물품가액: " + taxableAmount + "원 | 부가세: " + vat + "원");
    }

    /**
     * 상품 단가에 세금을 더하는 메서드
     *
     * @return 세금이 포함된 가격
     */
    @Override
    public int calcTax() {
        int result = (int)(getPrice() * VATRATE);
        return result;
    }

}