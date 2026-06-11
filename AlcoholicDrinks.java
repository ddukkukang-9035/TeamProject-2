/**
 * AlcoholicDrinks 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class AlcoholicDrinks extends Products implements Tax{
    public static final String SOJU = "소주";
    public static final String BEER = "맥주";
    public static final String WHISKEY = "위스키";
    public static final String WINE = "와인";
    private String drinkType;

    public AlcoholicDrinks(long barcode, String name, String drinkType, int price) {
        super(barcode, name, price);
        this.drinkType = drinkType;
    }

    @Override
    public void initDB() {
        addToDB(new AlcoholicDrinks(880000000001L, "참이슬", AlcoholicDrinks.SOJU,1800));
        addToDB(new AlcoholicDrinks(880000000002L, "카스", AlcoholicDrinks.BEER,2500));
        addToDB(new AlcoholicDrinks(880000000003L, "발렌타인", AlcoholicDrinks.WHISKEY,45000)); 
    }

    /**
     * 주류세 계산 (주세법 기준 세율 적용)
     * 과세표준 = 기본가격 × 수량
     * @return 주류세 금액 (원, 소수점 버림)
     */
    @Override
    public int calcTax() {
        int base = getPrice();

        if (drinkType.equals(SOJU)) {
            base = (int)(base * SOJUTAXRATE);
            return base;
        } else if (drinkType.equals(BEER)) {
            base = (int)(base * BEERTAXRATE);
            return base;
        } else if (drinkType.equals(WHISKEY)) {
            base = (int)(base * WHISKEYTAXRATE);
            return base;
        } else if (drinkType.equals(WINE)) {
            base = (int)(base * WINETAXRATE);
            return base;
        } else {
            return 0;
        }
    }

    /**
     * 최종 지불 금액 = (기본가격 × 수량) + 주류세
     * @return 세금 포함 최종 금액 (원)
     */
    @Override
    public int calcAmount() {
        int base = getPrice();
        return base + calcTax();
    }

    /**
     * 주류 상품 정보 출력
     */
    @Override
    public void printInfo() {
        System.out.println("[주류] " + getName() + " | 단가: " + getPrice() + "원" + " | 수량: " + " | 주류종류: " + drinkType + " | 세율: " + (int)(getTaxRate() * 100) + "%" + " | 주류세: " + calcTax() + "원" + " | 합계: " + calcAmount() + "원");
    }

    public String getDrinkType() { return drinkType; }

    /**
     * 현재 주류 종류의 세율 반환
     */
    public double getTaxRate() {
        if (drinkType.equals(SOJU) || drinkType.equals(WHISKEY)) {
            return SOJUTAXRATE;
        } else {
            return BEERTAXRATE;
        }
    }
}