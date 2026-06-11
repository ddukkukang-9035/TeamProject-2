/**
 * 주류별 세금을 상수로 지정하고 세금 계산 메서드가 있는 인터페이스
 * 
 * 소주는 72%로 세율이주류 고정이지만 맥주는 1L당 885.7원의 세금이 부과되는데
 * 
 * 이 프로그램에선 1L당 885.7원이 평균적으로 맥주가격의 약15%를 차지하므로
 * 맥주의 주류세율은 15%라는 기준으로 만들었음
 * 
 * @author (2023320010 박성준, 2023320012 강성하, 2023320006 정준영, 2023320029 정지후)
 * @version (2026.06.11)
 */

public interface TAX {
    double SOJUTAXRATE = 0.72;
    double BEERTAXRATE = 0.15;
    double WHISKEYTAXRATE = 0.72;
    double VATRATE = 0.1;

    /**
     * 세금 계산 추상 메소드
     */
    public abstract int calcTax();
}