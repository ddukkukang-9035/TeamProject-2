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
    protected static int DBCount  = 0;

    protected long barcode;
    protected String name;
    protected int price;

    /** 
     * 상품DB에 상품 등록
     * @param product : 서브 클래스에서 생성된 상품 객체
     */
    protected static void addToDB(Products product) {
        productDB[DBCount] = product;
        DBCount ++;
    }

    /**
     * 바코드로 상품DB를 검색하여 해당 Products 정보 반환.
     * 없으면 null 반환
     * @param barcode 스캔된 바코드 문자열
     * @return 해당 Products 객체 정보 또는 null값
     */
    public static Products findByBarcode(long barcode) {
        for (int i = 0; i < DBCount; i++) {
            if (productDB[i].barcode == barcode) {
                return productDB[i];
            }
        }
        return null;
    }

    /**
     * 상품의 바코드를 반환하는 메서드
     * @return barcode : 상품 바코드
     */
    public long getBarcode(){
        return barcode; 
    }

    /**
     * 상품의 이름을 반환하는 메서드
     * @return name : 상품명
     */
    public String getName(){
        return name;   
    }

    /**
     * 상품의 가격을 반환하는 메서드
     * @return price : 상품 단가
     */
    public int getPrice(){ 
        return price;    
    }
}