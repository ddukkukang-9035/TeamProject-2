/**
 * Sale 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class Sale { 
    private static final int SALEDBMAX  = 100;
    private static Sale[] saleDB = new Sale[SALEDBMAX];
    private static int saleCount   = 0;
    private Products[] cart;
    private int[] quantities;
    private int itemCount;
    private int totalAmount;
    private int paidCash;
    private int change; 

    /**
     * 메소드 예제 - 사용자에 맞게 주석을 바꾸십시오.
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 와 y의 합
     */
    public Sale(int maxItems) {
        cart = new Products[maxItems];
        quantities = new int[maxItems];
        itemCount = 0;
        totalAmount = 0;
        paidCash = 0;
        change = 0;
    }

    /**
     * 완료된 Sale 객체를 saleDB에 저장한다.
     * UCDesc Line 11 — "시스템은 Sale정보를 SaleDB에 저장한다."
     * 
     * @param 
     */ 
    public boolean addProduct(Products product, int qty) {
        if (itemCount >= cart.length) {
            System.out.println("[오류] 더 이상 상품을 추가할 수 없습니다.");
            return false;
        }
        cart[itemCount] = product;
        quantities[itemCount] = qty;
        itemCount++;
        return true;
    }

    /**
     * saleDB에 저장된 모든 판매 내역을 출력한다.
     * 무엇을 얼마나 팔았는지 한눈에 확인 가능.
     */ 
    public static void printSaleDB() {   
        if (saleCount == 0){ 
            System.out.println("  저장된 판매 내역이 없습니다 "); 
            return; 
        } 
        System.out.println("======== 판매 내역 (SaleDB) ========");
        for (int i = 0; i < saleCount; i++) {
            System.out.println("  ▶ 판매 #" + (i + 1));
            saleDB[i].printReceipt();
        }
        System.out.println("총 " + saleCount + "건 판매 완료.");
        System.out.println("===================================");
    }

    /** 
     * 누적 판매 건수 반환 
     */
    public static int getSaleCount() { 
        return saleCount; 
    }

    /**
     * 이번 판매 목록에 상품을 추가한다.
     * @param product : 추가할 상품 객체
     * @return 추가 성공 여부
     */
    public boolean addProduct(Products product) {
        if (itemCount >= cart.length) {
            System.out.println("[오류] 더 이상 상품을 추가할 수 없습니다.");
            return false;
        }
        cart[itemCount++] = product;
        return true;
    }

    /**
     * 담긴 모든 상품의 금액을 합산하여 totalAmount를 갱신한다.
     */
    public void calcTotalAmount() {
        totalAmount = 0;
        for (int i = 0; i < itemCount; i++) {
            totalAmount += cart[i].calcAmount();
        }
    }

    /**
     * 거스름돈을 계산하고 change 필드에 저장한다.
     * @param paid : 고객이 낸 현금
     * @return 거스름돈 (음수면 현금 부족)
     */
    public int calcChange(int paid) {
        this.paidCash = paid;
        this.change   = paid - totalAmount;
        return this.change;
    }

    /**
     * 이번 판매의 영수증을 출력한다.
     * UCDesc Line 9 — 영수증 발급
     */
    public void printReceipt() {
        System.out.println("-------- 영수증 --------");
        for (int i = 0; i < itemCount; i++) {
            System.out.print("  ");
            cart[i].printInfo();
        }
        System.out.println("------------------------");
        System.out.println("총 금액  : " + totalAmount + "원");
        System.out.println("받은 현금 : " + paidCash   + "원");
        System.out.println("거스름돈  : " + change     + "원");
        System.out.println("------------------------");
    }

    public static void saveDB(Sale sale) {
        if (saleCount < SALEDBMAX) {
            saleDB[saleCount] = sale;
            saleCount++;
            System.out.println("[시스템] Sale 정보가 SaleDB에 저장되었습니다."
                + "(누적 판매 건수: " + saleCount + "건)");
        } else {
            System.out.println("[경고] SaleDB가 가득 찼습니다.");
        }
    }

    public int getTotalAmount(){ 
        return totalAmount; 
    }

    public int getPaidCash(){
        return paidCash;    
    }

    public int getChange(){
        return change;      
    }

    public int getItemCount(){
        return itemCount;  
    }

    public Products[] getItems(){
        return cart;       
    }
}