package tradearea.warehouse;

import tradearea.model.ProductData;
import tradearea.model.WarehouseData;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


public class WarehouseSimulation {

	public static WarehouseData generateRandomWarehouseData() {
		WarehouseData warehouseData = new WarehouseData();

		warehouseData.setWarehouseName("NOE Korneuburg");
		warehouseData.setWarehouseCountry("Austria");

		Random random = new Random();
		warehouseData.setWarehouseID(String.format("%03d", random.nextInt(1000)));

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		warehouseData.setTimestamp(dateFormat.format(new Date()));

		ProductData[] productData = new ProductData[2];
		productData[0] = generateRandomProductData();
		productData[1] = generateRandomProductData();

		warehouseData.setWarehouseProducts(productData);

		return warehouseData;
	}

	public static ProductData generateRandomProductData() {
		ProductData productData = new ProductData();
		Random random = new Random();

		productData.setProductId(String.format("PD%03d", random.nextInt(1000)));
		productData.setProductName(generateRandomProductName());
		productData.setProductCategory(assignProductCategory(productData.getProductName()));
		productData.setProductQuantity(Integer.toString(random.nextInt(1000)));
		productData.setProductUnit("pcs");

		return productData;
	}

	public static String generateRandomProductName() {
		// You can replace this with a list of actual product names
		String[] productNames = {"Coca-Cola", "Pepsi", "Fanta", "Almdudler", "Voeslauer", "Coffee"};
		Random random = new Random();
		return productNames[random.nextInt(productNames.length)];
	}

	public static String assignProductCategory(String productName) {

		if (productName.equals("Coca-Cola") || productName.equals("Pepsi")) {
			return "Soda";
		} else if (productName.equals("Fanta") || productName.equals("Almdudler")) {
			return "Juice";
		} else if (productName.equals("Voeslauer")) {
			return "Water";
		} else if (productName.equals("Coffee")) {
			return "Coffee";
		} else {
			return "Unknown";
		}
	}
}
