import java.util.Scanner;
/**
 * MyApp 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */

public class MyApp {
    public static void main(String[] args) {
        Scanner sc   = new Scanner(System.in);
        POST    post = new POST();

        System.out.println("========================================");
        System.out.println("   POST System - 편의점 계산 시스템");
        System.out.println("========================================");

        boolean running = true;
        while (running) {
            post.resetSale();
            System.out.println("\n[새 고객] 상품을 스캔하세요.");
            System.out.println(post.printProducts());

            // Step 2~3: 바코드 스캔 반복
            boolean scanning = true;
            while (scanning) {
                System.out.print("바코드 입력 (완료: 0) > ");
                String input = sc.nextLine().trim();

                if (input.equals("0")) {
                    scanning = false; // Step 4: 완료 버튼
                } else {
                    try {
                        long barcode = Long.parseLong(input);
                        Products found = post.findByBarcode(barcode);

                        if (found == null) {
                            // Alternative Scenario [Line 2]: 올바르지 않은 바코드
                            System.out.println("  오류: 등록되지 않은 바코드입니다.");
                        } else {
                            System.out.println("  상품 인식: " + found.toString());
                            System.out.print("  수량 입력 > ");
                            int qty = Integer.parseInt(sc.nextLine().trim());

                            int unitPrice = (found instanceof Tax)
                                ? ((Tax) found).getTotalPrice()
                                : found.getProductPrice();

                            post.saleInfoSave(found.getProductName(), unitPrice, qty);
                            System.out.println("  [장바구니]");
                            post.printCurrentSale();
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("  오류: 올바르지 않은 바코드입니다.");
                    }
                }
            }

            if (post.priceCalculate() == 0) {
                System.out.println("  스캔된 상품이 없습니다.");
                break;
            }

            // Step 5: 지불 금액 출력
            System.out.println("\n총 지불 금액: " + post.priceCalculate() + "원");

            // Step 6~8: 현금 수령
            int paidCash  = 0;
            boolean paid  = false;
            while (!paid) {
                System.out.print("받은 현금 입력 > ");
                try {
                    paidCash = Integer.parseInt(sc.nextLine().trim());
                    if (paidCash < post.priceCalculate()) {
                        // Alternative Scenario [Line 7]: 현금 부족 → 판매 취소
                        System.out.println("  현금이 부족합니다. 판매를 취소합니다.");
                        post.resetSale();
                        paidCash = -1;
                        paid = true;
                    } else {
                        paid = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("  올바른 금액을 입력하세요.");
                }
            }

            // Step 9~11: 영수증 출력
            if (paidCash >= 0) {
                post.printReceipt(paidCash);
            }

            // 다음 고객 여부
            System.out.print("\n다음 고객을 처리하시겠습니까? (y/n) > ");
            if (!sc.nextLine().trim().equalsIgnoreCase("y")) {
                running = false;
            }
        }

        System.out.println("\n시스템을 종료합니다. 감사합니다.");
        sc.close();
    }
}