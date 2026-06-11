import java.util.Scanner;

/**
 * MyApp 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */

public class POST {
    private Sale cartItems;
    private Scanner scanner = new Scanner(System.in);

    /**
     * UCDescription Main Scenario 전체 흐름을 실행한다.
     */
    public void runSaleProcess() {
        AlcoholicDrinks.initDB();
        Beverages.initDB();
        
        cartItems = new Sale(100);
        System.out.println("\n========== POST 판매 시작 ==========");
        while (scanProduct()) {
        }

        payment();

        if (cartItems == null) {
            return;
        }
        cartItems.printReceipt();
        Sale.saveDB(cartItems);    
        System.out.println("========== 판매 완료 ==========\n");
    }

    /**
     * 담긴 모든 상품의 금액을 합산하여 totalAmount를 갱신한다.
     */
    public void calcTotalAmount() {
        totalAmount = 0;
        for (int i = 0; i < itemCount; i++) {
            totalAmount += cartPrices[i] * quantities[i];
        }
    }

    /**
     * 바코드 입력 , Products.findByBarcode() 조회 ,cartItems에 추가.
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
            System.out.println("[오류] 올바르지 않은 바코드입니다: " + barcode);
            return true;
        }

        System.out.print("수량 입력: ");
        int count = scanner.nextInt();
        cartItems.addProduct(found.getName(), found.getPrice(), count);

        System.out.println("[추가됨] " + found.getName() + " × " + count + "개");
        return true;
    } 

    /**
     * 총 금액 계산 , 현금 수령 , 거스름돈 계산.
     * UCDe Line 4~9 해당.
     */
    public void payment() {
        cartItems.calcTotalAmount();
        System.out.println("\n  지불할 금액: " + cartItems.getTotalAmount() + "원");

        System.out.print("받은 현금 입력: ");
        int paid = scanner.nextInt();

        if (paid < cartItems.getTotalAmount()) {
            System.out.println("[취소] 현금이 부족합니다. 판매를 취소합니다.");
            cartItems = null;
            return;
        }

        int change = cartItems.calcChange(paid);
        System.out.println("거스름돈: " + change + "원");
    }
}