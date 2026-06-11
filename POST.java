import java.util.Scanner;

/**
 * POST Class  (Point Of Sale Terminal)
 * 비즈니스 로직 전담 클래스.
 *
 * 상품DB는 Products가, 판매DB는 Sale이 각자 관리한다.
 * POST는 두 클래스의 static 메소드를 호출하여 판매 흐름을 조율한다.
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