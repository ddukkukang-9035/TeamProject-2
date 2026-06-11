/**
 * MyApp 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */

public class MyApp {
    public static void main(String[] args) {
        Products.initProductDB();
        POST post = new POST();
        System.out.println("POST System (선문 편의점 POS)");
        post.runSaleProcess();
    }
}