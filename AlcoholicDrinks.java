/**
 * 주류 상품을 다루는 클래스
 *
 * @author (2023320010 박성준, 2023320012 강성하, 2023320006 정준영, 2023320029 정지후)
 * @version (2026.06.11)
 */
public class AlcoholicDrinks extends Products implements TAX{
    public static final String SOJU = "소주";
    public static final String BEER = "맥주";
    public static final String WHISKEY = "위스키";
    private String drinkType;

    public AlcoholicDrinks(long barcode, String name, String drinkType, int price) {
        this.barcode = barcode; 
        this.name = name;
        this.price = price;
        this.drinkType = drinkType;
    }

    /**
     * 상품DB에 상품을 추가하는 메서드
     */
    public static void initDB() {
        addToDB(new AlcoholicDrinks(8800000000001L, "참이슬", AlcoholicDrinks.SOJU,1800));
        addToDB(new AlcoholicDrinks(8800000000002L, "카스", AlcoholicDrinks.BEER,2500));
        addToDB(new AlcoholicDrinks(8800000000003L, "발렌타인", AlcoholicDrinks.WHISKEY,45000)); 
    }

    /**
     * 주류 종류에 따라 다른 주류세를 반환하는 메서드
     *      
     * @return 주류별 주류세율
     */
    public double getAlcoholicTaxRate() {
        if (drinkType.equals(SOJU)) 
            return SOJUTAXRATE;
        if (drinkType.equals(BEER)) 
            return BEERTAXRATE;
        if (drinkType.equals(WHISKEY))
            return WHISKEYTAXRATE;
        return 0;
    }

    /**
     * 상품의 총 세금을 계산하는 메서드
     * @return 해당 상품의 부가세
     */
    @Override
    public int calcTax() {
        return calcAlcoholTax() + getVAT();
    }

    /**
     * 주류세를 계산하는 메서드
     *      
     * @return 주류에 해당하는 주류세
     */
    public int calcAlcoholTax() {
        return (int)(getPrice() * getAlcoholicTaxRate());
    }

    /**
     * 상품의 부가가치세를 계산하는 메서드
     *      
     * @return 상품의 부가가치세
     */
    public int getVAT() {
        return (int)(getPrice() * VATRATE);
    }

    /**
     * 주류 종류를 반환하는 메서드
     * @return drinkType : 주류 종류 (소주, 맥주, 위스키, 와인)
     */
    public String getDrinkType() { 
        return drinkType; 
    }
}