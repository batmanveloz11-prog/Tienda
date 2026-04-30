package Almacen;

public class Product {
	int id;
	
	String Name,Price, StockQuantity, IsAvailable;
	DataProduct da= new DataProduct();
	
	public Product(){
		
	}
	public Product(int id, String name, String price, String stockquantity, String isavailable) {
		super();
		this.id=id;
		Name=name;
		Price=price;
		StockQuantity=stockquantity;
		IsAvailable=isavailable;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPrice() {
		return Price;
	}
	public void setPrice(String price) {
		Price = price;
	}
	public String getStockQuantity() {
		return StockQuantity;
	}
	public void setStockQuantity(String stockquantity) {
		StockQuantity = stockquantity;
	}
	public String getIsAvailable() {
		return IsAvailable;
	}
	public void setIsAvailable(String isavailable) {
		IsAvailable=isavailable;
	}
	public boolean InsertProduct() {
		// TODO Auto-generated method stub
		return da.InsertProduct(this);
	}
	public boolean DeleteProduct() {
		// TODO Auto-generated method stub
		return da.DeleteProduct(this);
	}
	public boolean CarryProduct() {
		// TODO Auto-generated method stub
		return da.CarryProduct(this);
	}
	public boolean UpdateProduct() {
		// TODO Auto-generated method stub
		return da.UpdateProduct(this);
	}
}
