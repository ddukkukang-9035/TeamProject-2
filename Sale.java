/**
 * Sale Class
 * 한 건의 판매 트랜잭션 정보를 담는 클래스
 *
 * [판매DB 책임]
 *   완료된 Sale 객체를 static saleDB 배열에 직접 저장·관리한다.
 *   POST는 Sale.saveToDB() / Sale.printSaleDB() 를 호출하기만 한다.
 */  
public class Sale { 
    private static final int SALEDB_MAX  = 100;
    private static Sale[] saleDB = new Sale[SALEDB_MAX];
    private static int saleCount   = 0;
    private Products[] items;
    private int itemCount;
    private int totalAmount;
    private int paidCash;
    private int change; 

    /**
     * 완료된 Sale 객체를 saleDB에 저장한다.
     * UCDesc [Line 11] — "시스템은 Sale정보를 SaleDB에 저장한다."
     * @param sale 저장할 Sale 객체
     */ 
    public static void saveTODB(Sale sale){  
        if(saleCount < SALEDB_MAX) { 
            saleDB[saleCount] = sale; 
            saleCount++; 
            System.out.println("[시스템] Sale 정보가 SaleDB에 저장되었습니다." 
                + "(누적 판매 건수: " + saleCount + "건)");} 
        else { 
            System.out.println("[경고] SaleDB가 가득 찼습니다.");
        }
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
     * 판매정보 저장
     */
    public Sale(int maxItems) {
        items       = new Products[maxItems];
        itemCount   = 0;
        totalAmount = 0;
        paidCash    = 0;
        change      = 0;
    }

    /**
     * 이번 판매 목록에 상품을 추가한다.
     * @param product 추가할 상품 객체
     * @return 추가 성공 여부
     */
    public boolean addProduct(Products product) {
        if (itemCount >= items.length) {
            System.out.println("[오류] 더 이상 상품을 추가할 수 없습니다.");
            return false;
        }
        items[itemCount++] = product;
        return true;
    }

    /**
     * 담긴 모든 상품의 금액을 합산하여 totalAmount를 갱신한다.
     */
    public void calcTotalAmount() {
        totalAmount = 0;
        for (int i = 0; i < itemCount; i++) {
            totalAmount += items[i].calcAmount();
        }
    }

    /**
     * 거스름돈을 계산하고 change 필드에 저장한다.
     * @param paid 고객이 낸 현금
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
            items[i].printInfo();
        }
        System.out.println("------------------------");
        System.out.println("총 금액  : " + totalAmount + "원");
        System.out.println("받은 현금 : " + paidCash   + "원");
        System.out.println("거스름돈  : " + change     + "원");
        System.out.println("------------------------");
    }

    public int        getTotalAmount() { return totalAmount; }

    public int        getPaidCash()    { return paidCash;    }

    public int        getChange()      { return change;      }

    public int        getItemCount()   { return itemCount;   }

    public Products[] getItems()       { return items;       }
}

    
    
    
    
    
    
    
