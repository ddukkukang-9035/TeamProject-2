
/**
 * Tax - 인터페이스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호나 날짜)
 */
public interface Tax
{
    // 주류세 세율 상수 (주세법 기준)
    double SOJU_TAX_RATE = 0.72;  // 소주: 72%
    double BEER_TAX_RATE = 0.30;  // 맥주: 30%
    double WHISKEY_TAX_RATE = 0.72;  // 위스키: 72%
    double WINE_TAX_RATE = 0.30;  // 와인: 30%
    
    /**
     * 주류세 계산 메소드 (구현 클래스에서 반드시 오버라이딩)
     * @return 세금 금액 (원)
     */
    int calcTax();
}