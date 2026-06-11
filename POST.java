import java.util.Scanner;

/**
 * MyApp 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */

public class POST {
    private Sale billHistory;
    private Scanner scanner = new Scanner(System.in);

    /**
     * 바코드 입력 , Products.findByBarcode() 조회 ,billHistory에 추가.
     * UCD Line 2~3 반복 구간.
     * @return 계속 스캔해야 하면 true, 0 입력이면 false
     */
    public boolean scanProduct() {
        System.out.print("바코드 입력 (완료: '0'): ");
        long barcode = scanner.nextLong();

        if (barcode == 0) {
            return false;
        }

        Products found = Products.findByBarcode(barcode);   
        if (found == null) {
            System.out.println("  [오류] 올바르지 않은 바코드입니다: " + barcode);
            return true;
        }

        System.out.print("수량 입력: ");
        int qty = scanner.nextInt();
        billHistory.addProduct(found, qty);
        System.out.println("[추가됨] " + found.getName() + " × " + qty + "개");
        return true;

    } 

    /**
     * 총 금액 계산 , 현금 수령 , 거스름돈 계산.
     * UCDe Line 4~9 해당.
     */
    public void processPayment() {
        billHistory.calcTotalAmount();
        System.out.println("\n  지불할 금액: " + billHistory.getTotalAmount() + "원");

        System.out.println("고객에게 금액을 안내합니다.");

        System.out.print("받은 현금 입력: ");
        int paid = scanner.nextInt();

        if (paid < billHistory.getTotalAmount()) {
            System.out.println("[취소] 현금이 부족합니다. 판매를 취소합니다.");
            billHistory = null;
            return;
        }

        int change = billHistory.calcChange(paid);
        System.out.println("거스름돈: " + change + "원");
    }

    /**
     * UCDescription Main Scenario 전체 흐름을 실행한다.
     */
    public void runSaleProcess() {
        billHistory = new Sale(100);

        System.out.println("\n========== POST 판매 시작 ==========");
        while (scanProduct()) {
        }

        processPayment();

        if (billHistory == null) {
            return;
        }

        billHistory.printReceipt();

        Sale.saveDB(billHistory);

        System.out.println("========== 판매 완료 ==========\n");
    }
}