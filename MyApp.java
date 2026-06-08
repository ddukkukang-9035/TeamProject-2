import java.util.Scanner;
/**
 * MyApp 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class MyApp
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        POST post = new POST();
        
        System.out.println("========================================");
        System.out.println("   POST System - 편의점 계산 시스템");
        System.out.println("========================================");
        
        boolean running = true;
        while (running) {
            post.resetSale();
            System.out.println("\n[새 고객] 상품을 스캔하세요.");
            System.out.println(post.printProducts());
            
            
    }
    
    
}