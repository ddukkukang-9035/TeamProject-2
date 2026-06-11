/**
 * 상품 판매 정보DB를 다루고 영수증을 작성하고 출력해주는 클래스
 *
 * @author (2023320010 박성준, 2023320012 강성하, 2023320006 정준영, 2023320029 정지후)
 * @version (2026.06.11)
 */
public class Sale {
    private static final int SALEDBMAX = 100;
    private static Sale[] saleDB = new Sale[SALEDBMAX];
    private static int saleCount = 0;

    private String[] cartNames;
    private int[] itemPrices;
    private int[] taxes;
    private int[] counts;
    private int inCartItemCount;
    private int totalAmount;
    private int paidCash;
    private int change;

    /**
     * 영수증을 만들기 위해 판매 상품들의 정보를 저장하는 객체 생성
     *
     * @param  maxItems : 한 번 구매할 때 가능한 상품 종류 개수
     */
    public Sale(int maxItems) {
        cartNames = new String[maxItems];
        itemPrices = new int[maxItems];
        taxes = new int[maxItems];
        counts = new int[maxItems];
        inCartItemCount = 0;
        totalAmount = 0;
        paidCash = 0;
        change = 0;
    }

    /**
     * 이번 판매의 영수증을 출력한다
     * UCDesc Line 9 — 영수증 발급
     * 
     */
    public void printReceipt() {
        System.out.println("-------- 영수증 --------");
        for (int i = 0; i < inCartItemCount; i++) {
            System.out.println("  " + cartNames[i] + " | 단가: " + itemPrices[i] + "원 | 수량: " + counts[i] + " | 금액: " + (itemPrices[i] * counts[i]) + "원");
        }
        System.out.println("------------------------");
        int totalTax = 0;
        for (int i = 0; i < inCartItemCount; i++) {
            totalTax += taxes[i] * counts[i];
        }
        int taxableAmount = totalAmount - totalTax;
        System.out.println("과세물품가액 : " + taxableAmount + "원");
        System.out.println("부가세      : " + totalTax + "원");
        System.out.println("총액        : " + totalAmount + "원");
        System.out.println("받은 현금   : " + paidCash + "원");
        System.out.println("거스름돈    : " + change + "원");
        System.out.println("------------------------");
    }

    /**
     * 이번 판매의 판매내역을 saleDB에 저장
     * 
     * @param  sale : 이번 판매로 생성된 영수증 정보
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
     *        price : 단가
     *        tax : 세금
     *        count : 수량
     * 
     * @return 추가 성공 여부
     */
    public boolean addProduct(String name, int price, int tax, int count) {
        cartNames[inCartItemCount] = name;
        itemPrices[inCartItemCount] = price;
        taxes[inCartItemCount] = tax;
        counts[inCartItemCount] = count;
        inCartItemCount++;
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
        return inCartItemCount;   
    }

    public int[] getItemPrices() { 
        return itemPrices; 
    }

    public int[] getCounts() { 
        return counts; 
    }

    public void setTotalAmount(int amount) {
        this.totalAmount = amount; 
    }

    public void setPaidCash(int paid) { 
        this.paidCash = paid; 
    }

    public void setChange(int change) { 
        this.change = change; 
    }
}