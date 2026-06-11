/**
 * AlcoholicDrinks Class
 * Products를 상속하고 TAX 인터페이스를 구현하는 주류 클래스
 * 지원 주류: 소주(SOJU), 맥주(BEER), 위스키(WHISKEY), 와인(WINE)
 */
public class AlcoholicDrinks extends Products implements TAX {
    public static final String SOJU = "소주";
    public static final String BEER = "맥주";
    public static final String WHISKEY = "위스키";
    public static final String WINE = "와인";
    private String drinkType;

    public AlcoholicDrinks(String barcode, String name, String drinkType,
                           int price, int quantity) {
        super(barcode, name, price, quantity);
        this.drinkType = drinkType;
    }
    public static void initDB() {
        addToDB(new AlcoholicDrinks("A001", "참이슬", AlcoholicDrinks.SOJU,1800,1));
        addToDB(new AlcoholicDrinks("A002", "카스", AlcoholicDrinks.BEER,2500,1));
        addToDB(new AlcoholicDrinks("A003", "발렌타인", AlcoholicDrinks.WHISKEY,45000,1)); 
    }
    /**
     * 주류세 계산 (주세법 기준 세율 적용)
     * 과세표준 = 기본가격 × 수량
     * @return 주류세 금액 (원, 소수점 버림)
     */
    @Override
    public int calcTax() {
        int base = getPrice() * getQuantity();

        if (drinkType.equals(SOJU)) {
            return (int)(base * SOJU_TAX_RATE);
        } else if (drinkType.equals(BEER)) {
            return (int)(base * BEER_TAX_RATE);
        } else if (drinkType.equals(WHISKEY)) {
            return (int)(base * WHISKEY_TAX_RATE);
        } else if (drinkType.equals(WINE)) {
            return (int)(base * WINE_TAX_RATE);
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
        int base = getPrice() * getQuantity();
        return base + calcTax();
    }

    /**
     * 주류 상품 정보 출력
     */
    @Override
    public void printInfo() {
        System.out.println("[주류] " + getName() + " | 단가: " + getPrice() + "원" + " | 수량: " + getQuantity() + " | 주류종류: " + drinkType + " | 세율: " + (int)(getTaxRate() * 100) + "%" + " | 주류세: " + calcTax() + "원" + " | 합계: " + calcAmount() + "원");
    }

    public String getDrinkType() { return drinkType; }

    /**
     * 현재 주류 종류의 세율 반환
     */
    public double getTaxRate() {
        if (drinkType.equals(SOJU) || drinkType.equals(WHISKEY)) {
            return SOJU_TAX_RATE;
        } else {
            return BEER_TAX_RATE;
        }
    }
}