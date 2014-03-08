import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Order {
	
	@XmlElement
	int OrderNum;
	
	@XmlElement
	String FName;
	
	@XmlElement
	String LName;
	
	@XmlElement
	int ItemID;
	
	@XmlElement
	BigDecimal Price;
	
	@XmlElement
	int Quantity;
	
}

