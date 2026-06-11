/**
 * 음료 상품을 다루는 클래스
 *
 * @author (2023320010 박성준, 2023320012 강성하, 2023320006 정준영, 2023320029 정지후)
 * @version (2026.06.11)
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
     * 상품세금 적용 전 금액
     * @return 최종 금액 (원)
     */
    @Override
    public int getPrice() {
        return price;
    }

    /**
     * 상품의 세금을 계산하는 메서드
     * @return 해당 상품의 부가세
     */
    @Override
    public int calcTax() {
        return (int)(getPrice() * VATRATE);
    }
}