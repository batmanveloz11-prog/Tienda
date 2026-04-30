package Almacen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class DataProductTest {

	@Test
	void testInsertProduct() {
		Product a = new Product(8, "Camisas", "500", "250","Activo");
		assertTrue(a.InsertProduct());
	}

	@Test
	void testDeleteProduct() {
		Product a = new Product(4, "Vasos", "10", "200","Activo");
		assertTrue(a.DeleteProduct());	
	}

	@Test
	void testCarryProduct() {
		Product a = new Product(1, "katana murasame", "1600", "10","Activo");
		assertTrue(a.CarryProduct());
	}

	@Test
	void testUpdateProduct() {
		Product a = new Product(6, "Katana de damasco", "4500", "15","Activo");
		assertTrue(a.UpdateProduct());
	}

}
