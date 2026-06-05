
/**
 * Tax - 인터페이스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호나 날짜)
 */
public interface Tax
{
    public static final float TAXRATE = 0.1f;     
    
    public abstract int calculateTax();
    
    public abstract int getTotalPrice();
}