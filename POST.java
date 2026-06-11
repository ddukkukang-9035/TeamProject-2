import java.util.Scanner;

/**
 * MyApp 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */

public class POST {
    private Sale    currentSale;
    private Scanner sc = new Scanner(System.in);

    /**
     * POST 생성 시 상품DB를 초기화한다.
     * (상품DB 데이터는 Products 클래스가 소유)
     */
    public POST() {
        AlcoholicDrinks.initDB();
        Beverages.initDB();
    }

    /**
     * 바코드 입력 → Products.findByBarcode() 조회 ,currentSale에 추가.
     * UCD Line 2~3 반복 구간.
     * @return 계속 스캔해야 하면 true, 'done' 입력이면 false
     */
    public boolean scanProduct() {
        System.out.print("바코드 입력 (완료: '0'): ");
        String barcode = sc.next();

        if (barcode.equalsIgnoreCase("0")) {
            return false;
        }
        
        Products found = Products.findByBarcode(barcode);
        if (found == null) {
            System.out.println("  [오류] 올바르지 않은 바코드입니다: " + barcode);
            return true;
        }

        System.out.print("  수량 입력: ");
        int qty = sc.nextInt();

        Products item = cloneWithQuantity(found, qty);

        currentSale.addProduct(item);

        System.out.println("  [추가됨] " + item.getName() + " × " + qty + "  →  소계: " + item.calcAmount() + "원");

        return true;
    } 
    
    /**
     * 상품 객체를 지정 수량으로 복사 생성한다.
     */
    private Products cloneWithQuantity(Products src, int qty) {
        if (src instanceof AlcoholicDrinks) {
            AlcoholicDrinks ad = (AlcoholicDrinks) src;
            return new AlcoholicDrinks(ad.getBarcode(), ad.getName(), ad.getDrinkType(), ad.getPrice(), qty);
        } else {
            Beverages bv = (Beverages) src;
            return new Beverages(bv.getBarcode(), bv.getName(), bv.getCategory(), bv.getPrice(), qty);
        }
    }

    /**
     * 총 금액 계산 → 현금 수령 → 거스름돈 계산.
     * UCDe Line 4~9 해당.
     */
    public void processPayment() {
        currentSale.calcTotalAmount();
        System.out.println("\n  지불할 금액: " + currentSale.getTotalAmount() + "원");

        System.out.println("고객에게 금액을 안내합니다.");
        
        System.out.print("받은 현금 입력: ");
        int paid = sc.nextInt();

        if (paid < currentSale.getTotalAmount()) {
            System.out.println("[취소] 현금이 부족합니다. 판매를 취소합니다.");
            currentSale = null;
            return;
        }

        int change = currentSale.calcChange(paid);
        System.out.println("거스름돈: " + change + "원");
    }

    /**
     * UCDescription Main Scenario 전체 흐름을 실행한다.
     */
    public void runSaleProcess() {
        currentSale = new Sale(20);

        System.out.println("\n========== POST 판매 시작 ==========");

        while (scanProduct()) {
        }

        if (currentSale.getItemCount() == 0) {
            System.out.println("  스캔된 상품이 없습니다. 판매를 종료합니다.");
            return;
        }

        processPayment();

        if (currentSale == null) {
            return;
        }

        currentSale.printReceipt();

        Sale.saveToDB(currentSale);

        System.out.println("========== 판매 완료 ==========\n");
    }

    /**
     * 상품DB 목록 출력 — Products 클래스에게 위임
     */
    public void printProductDB() {
        Products.printDB();
    }

    /**
     * 판매DB 전체 내역 출력 — Sale 클래스에게 위임
     */
    public void printSaleDB() {
        Sale.printSaleDB();
    }
}