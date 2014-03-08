import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Convert {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException, JAXBException {

		String csvFileToRead = "C:\\Users\\Elliott\\workspace\\Convert_Orders\\src\\Orders";
		BufferedReader br = null;
		String line = "";

		br = new BufferedReader(new FileReader(csvFileToRead));
		while ((line = br.readLine()) != null) {

			String[] thisLine = line.split(",");
			Order order = new Order();
			order.OrderNum = Integer.parseInt(thisLine[0]);
			order.FName = thisLine[1];
			order.LName = thisLine[2];
			order.ItemID = Integer.parseInt(thisLine[3]);
			order.Price = new BigDecimal(thisLine[4]);
			order.Quantity = Integer.parseInt(thisLine[5]);

			File file = new File("order" + order.OrderNum + ".xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Order.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(order, file);
			jaxbMarshaller.marshal(order, System.out);

		}
	}
}
