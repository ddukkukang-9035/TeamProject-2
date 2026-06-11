import java.util.Scanner;
/**
 * MyApp 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */

public class MyApp {

    public static void main(String[] args) {

        POST post = new POST();
        Scanner scanner = new Scanner(System.in);
        int menu;

        System.out.println("POST System  (편의점 POS)");

        while (true) {
            System.out.println("\n[메뉴]");
            System.out.println("  1. 상품 목록 보기  (ProductDB)");
            System.out.println("  2. 판매 시작");
            System.out.println("  3. 판매 내역 보기  (SaleDB)");
            System.out.println("  0. 종료");
            System.out.print("선택: ");
            menu = scanner.nextInt();

            if (menu == 1) {
                post.printProductDB();
            } 
            else if (menu == 2) {
                post.runSaleProcess();
            } 
            else if (menu == 3) {
                post.printSaleDB();
            }
            else if (menu == 0) {
                System.out.println("POST 시스템을 종료합니다.");
                break;
            }
            else {
                System.out.println("올바른 메뉴를 선택하세요.");
            }
        }

    }
}