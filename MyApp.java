/**
 * PostSystem의 메인 클래스
 *
 * @author (2023320010 박성준, 2023320012 강성하, 2023320006 정준영, 2023320029 정지후)
 * @version (2026.06.11)
 */

public class MyApp {
    public static void main(String[] args) {
        POST post = new POST();
        System.out.println("POST System (선문 편의점 POS)");
        while (true) {
            post.runSaleProcess();
        }
    }
}