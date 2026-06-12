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
     * @param  maxItems : 한 번 구매할 때 가능한 상품 종류 가지수
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
     * 장바구니에 상품을 추가한다.
     * 
     * @param name : 상품명
     *        price : 단가
     *        tax : 세금
     *        count : 수량
     * 
     * @return 추가 성공 여부
     */
    public void addProduct(String name, int price, int tax, int count) {
        cartNames[inCartItemCount] = name;
        itemPrices[inCartItemCount] = price;
        taxes[inCartItemCount] = tax;
        counts[inCartItemCount] = count;
        inCartItemCount++;
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
     * @param  sale : 이번 판매로 생성된 영수증 정보
     */
    public static void saveDB(Sale sale) {
        saleDB[saleCount] = sale;
        saleCount++;
        System.out.println("[시스템] Sale 정보가 SaleDB에 저장되었습니다.(누적 판매 건수: " + saleCount + "건)");
    }

    /**
     * 총 금액을 반환하는 메서드
     * @return totalAmount : 총 금액
     */
    public int getTotalAmount(){ 
        return totalAmount; 
    }

    /**
     * 손님이 지불할 금액을 반환하는 메서드
     * @return getpaidCash : 손님이 지불할 금액
     */
    public int getPaidCash(){
        return paidCash;    
    }

    /**
     * 거스름돈 액수를 반환하는 메서드
     * @return getChange : 거스름돈 액수
     */
    public int getChange(){
        return change;        
    }

    /**
     * 현재 장바구니에 담겨있는 상품 종류 가지수를 반환하는 메서드
     * @return getInCartItemCount : 장바구니에 담겨있는 상품 종류 가지수
     */
    public int getInCartItemCount(){
        return inCartItemCount;   
    }

    /**
     * 장바구니에 담겨있는 모든 상품의 각각의 가격을 배열에 저장하는 메서드
     * @return itemPrices : 상품가격이 담긴 배열
     */
    public int[] getItemPrices() { 
        return itemPrices; 
    }

    /**
     * 상품의 수량을 반환하는 메서드
     * @return counts : 상품 수량
     */
    public int[] getCounts() { 
        return counts; 
    }

    /**
     * 총 금액을 설정하는 메서드
     * @param amount : 설정할 총 금액
     */
    public void setTotalAmount(int amount) {
        this.totalAmount = amount; 
    }

    /**
     * 고객이 낸 현금을 설정하는 메서드
     * @param paid : 고객이 낸 현금
     */
    public void setPaidCash(int paid) { 
        this.paidCash = paid; 
    }

    /**
     * 거스름돈을 설정하는 메서드
     * @param change : 거스름돈
     */
    public void setChange(int change) { 
        this.change = change; 
    }
}