/**
 * Beverages 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class Beverages extends Products implements Tax{

    public Beverages(long barcode, String name, int price) {
        super(barcode, name, price);
    }

    public static void initDB(){
        addToDB(new Beverages(880000000004L, "코카콜라", 1500));
        addToDB(new Beverages(880000000005L, "포카리스웨트", 1800));
        addToDB(new Beverages(880000000006L, "제주삼다수",900));
    }

    /**
     * 최종 지불 금액 = 기본가격 × 수량 (세금 없음)
     * @return 최종 금액 (원)
     */
    @Override
    public int calcAmount() {
        return getPrice();
    }

    /**
     * 음료수 상품 정보 출력
     */
    @Override
    public void printInfo() {
        System.out.println("[음료] " + getName() + " | 단가: " + getPrice() + "원" + " | 수량: " + " | 합계: " + calcAmount() + "원");
    }

    /**
     * 메소드 예제 - 사용자에 맞게 주석을 바꾸십시오.
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 와 y의 합
     */
    @Override
    public int calcTax(){
        int base = (int)(getPrice() * VAT);
        return base;
    }

}