/**
 * TAX Interface
 * 주류세 계산을 위한 인터페이스
 * 주세법 제22조 기준: 소주/위스키 72%, 맥주/와인 30%
 */

public interface TAX {
    double SOJUTAXRATE = 0.72;
    double BEERTAXRATE = 0.30;
    double WHISKEYTAXRATE = 0.72;
    double VAT = 0.1;

    /**
     * 주류세 계산 메소드 (구현 클래스에서 반드시 오버라이딩)
     * @return 세금 금액 (원)
     */
    int calcTax();
}