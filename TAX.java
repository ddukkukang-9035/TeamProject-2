
/**
 * Tax - 인터페이스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호나 날짜)
 */
public interface TAX
{
    double SOJUTAXRATE = 0.72;
    double BEERTAXRATE = 0.30;
    double WHISKEYTAXRATE = 0.72;
    double WINETAXRATE = 0.30;
    double VAT = 0.1;
    
    /**
     * 세금 계산 메소드
     * @return 세금 금액 (원)
     */
    int calcTax();
}