/**
 * AlcoholicDrinks 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
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

    public static void initDB() {
        addToDB(new AlcoholicDrinks(8800000000001L, "참이슬", AlcoholicDrinks.SOJU,1800));
        addToDB(new AlcoholicDrinks(8800000000002L, "카스", AlcoholicDrinks.BEER,2500));
        addToDB(new AlcoholicDrinks(8800000000003L, "발렌타인", AlcoholicDrinks.WHISKEY,45000)); 
    }

    public double getTaxRate() {
        if (drinkType.equals(SOJU)) 
            return SOJUTAXRATE;
        if (drinkType.equals(BEER)) 
            return BEERTAXRATE;
        if (drinkType.equals(WHISKEY))
            return WHISKEYTAXRATE;
        return 0;
    }

    public int calcAlcoholTax() {
        return (int)(getPrice() * getTaxRate());
    }

    public int getVAT() {
        return (int)(getPrice() * VAT);
    }

    @Override
    public int calcTax() {
        return calcAlcoholTax() + getVAT();
    }

    @Override
    public int calcAmount() {
        return getPrice();
    }

    @Override
    public void printInfo() {
        int vat = getVAT();
        int alcoholTax = calcAlcoholTax();
        int taxableAmount = getPrice() - vat - alcoholTax;
        System.out.println("[주류] " + getName() + " | 단가: " + getPrice() + "원 | 과세물품가액: " + taxableAmount + "원 | 주류세: " + alcoholTax + "원 | 부가세: " + vat + "원");
    }

    public String getDrinkType() { 
        return drinkType; 
    }
}