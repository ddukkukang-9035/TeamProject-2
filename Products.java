
/**
 * Product 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public abstract class Products
{   
    protected static final int DB_MAX = 20;
    protected static Products[] productDB = new Products[DB_MAX];
    protected static int dbCount  = 0;
    protected long barcode;
    protected String name;
    protected int price;
    protected int quantity;

    public Products(long barcode, String name, int price) {
        this.barcode = barcode;
        this.name = name;
        this.price = price;
    }

    /** 
     * 상품DB에 상품 추가
     */
    protected static void addToDB(Products p) {
        if (dbCount < DB_MAX) {
            productDB[dbCount++] = p;
        }
    }

    /**
     * 바코드로 상품DB를 검색하여 해당 Products 정보 반환.
     * 없으면 null 반환, 호출부에서 오류 메시지 처리.
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
    
    /** 
     * 최종 지불 금액 계산
     */
    public abstract int calcAmount();
    
    /** 
     * 상품 정보 한 줄 출력 
     */
    public abstract void printInfo();
    
    /**
     * 판매 가능한 상품을 productDB에 등록한다.
     */
    public static void initProductDB(){
        AlcoholicDrinks.initDB();
        Beverages.initDB();
    }
}