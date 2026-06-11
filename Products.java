/**
 * 상품의 추상클래스
 * DB를 다루는 클래스
 *
 * @author (2023320010 박성준, 2023320012 강성하, 2023320006 정준영, 2023320029 정지후)
 * @version (2026.06.11)
 */
public abstract class Products
{   
    protected static final int DBMAX = 100;
    protected static Products[] productDB = new Products[DBMAX];
    protected static int dbCount  = 0;

    protected long barcode;
    protected String name;
    protected int price;
    protected int quantity;

    /** 
     * 상품DB에 상품 등록
     * @param product : 서브 클래스에서 생성된 상품 객체
     */
    protected static void addToDB(Products product) {
        productDB[dbCount] = product;
        dbCount ++;
    }

    /**
     * 바코드로 상품DB를 검색하여 해당 Products 정보 반환.
     * 없으면 null 반환
     * @param barcode 스캔된 바코드 문자열
     * @return 해당 Products 객체 정보 또는 null값
     */
    public static Products findByBarcode(long barcode) {
        for (int i = 0; i < dbCount; i++) {
            if (productDB[i].barcode == barcode) {
                return productDB[i];
            }
        }
        return null;
    }

    public long getBarcode(){
        return barcode; 
    }

    public String getName(){
        return name;   
    }

    public int getPrice(){ 
        return price;    
    }
    
    public abstract int calcTax();
}