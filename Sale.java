/**
 * Sale 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class Sale {
    private static final int SALEDBMAX = 100;
    private static Sale[] saleDB = new Sale[SALEDBMAX];
    private static int saleCount = 0;

    private String[] cartNames;
    private int[] cartPrices;
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
        cartNames = new String[maxItems];
        cartPrices = new int[maxItems];
        quantities = new int[maxItems];
        itemCount = 0;
        totalAmount = 0;
        paidCash = 0;
        change = 0;
    }

    /**
     * 거스름돈을 계산하고 change 필드에 저장한다.
     * @param paid : 고객이 낸 현금
     * @return 거스름돈
     */
    public int calcChange(int paid) {
        this.paidCash = paid;
        this.change = paid - totalAmount;
        return this.change;
    }

    /**
     * 이번 판매의 영수증을 출력한다.
     * UCDesc Line 9 — 영수증 발급
     */
    public void printReceipt() {
        System.out.println("-------- 영수증 --------");
        for (int i = 0; i < itemCount; i++) {
            System.out.println("  " + cartNames[i] + " | 단가: " + cartPrices[i] + "원 | 수량: " + quantities[i] + " | 금액: " + (cartPrices[i] * quantities[i]) + "원");
        }
        System.out.println("------------------------");
        int vat = (int)(totalAmount * 0.1);
        int taxableAmount = totalAmount - vat;
        System.out.println("과세물품가액 : " + taxableAmount + "원");
        System.out.println("부가세      : " + vat + "원");
        System.out.println("총액        : " + totalAmount + "원");
        System.out.println("받은 현금   : " + paidCash + "원");
        System.out.println("거스름돈    : " + change + "원");
        System.out.println("------------------------");
    }

    /**
     * 판매정보 saleDB에 저장
     */
    public static void saveDB(Sale sale) {
        saleDB[saleCount] = sale;
        saleCount++;
        System.out.println("[시스템] Sale 정보가 SaleDB에 저장되었습니다.(누적 판매 건수: " + saleCount + "건)");
    }

    /**
     * 장바구니에 상품을 추가한다.
     * 
     * @param name : 상품명
     * @param price : 단가
     * @param count : 수량
     * @return 추가 성공 여부
     */
    public boolean addProduct(String name, int price, int count) {
        cartNames[itemCount] = name;
        cartPrices[itemCount] = price;
        quantities[itemCount] = count;
        itemCount++;
        return true;
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
}