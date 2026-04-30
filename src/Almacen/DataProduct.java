package Almacen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataProduct {
Connection cx;
	
	public Connection conectar() {
		try {
			cx=DriverManager.getConnection("jdbc:mysql://localhost/Tienda","root","");
			System.out.println("Conexion exitosa");
		} catch (SQLException e) {
			
		}
		return cx;
	}

	public boolean InsertProduct(Product p) {
		PreparedStatement ps = null;
		try {
			ps = conectar().prepareStatement("INSERT INTO product VALUES (?,?,?,?,?)");
			ps.setInt(1, p.getId());
			ps.setString(2, p.getName());
			ps.setString(3, p.getPrice());
			ps.setString(4, p.getStockQuantity());
			ps.setString(5, p.getIsAvailable());
			return ps.executeUpdate()>0;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	public boolean DeleteProduct(Product p) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		try {
			ps = conectar().prepareStatement("DELETE FROM product WHERE id=?");
			ps.setInt(1, p.getId());
			
			return ps.executeUpdate()>0;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	public boolean CarryProduct(Product p) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		ResultSet rs=null;
		try {
			ps=conectar().prepareStatement("SELECT  * FROM product WHERE id=?");
			ps.setInt(1, p.getId());
			rs = ps.executeQuery();
			if(rs.next()) {
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setPrice(rs.getString(3));
				p.setStockQuantity(rs.getString(4));
				p.setIsAvailable(rs.getString(5));
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			return false;
		
		}
	}

	public boolean UpdateProduct(Product p) {
		PreparedStatement ps = null;
		try {
			ps = conectar().prepareStatement("UPDATE product SET Name=?, Price=?, StockQuantity=?, IsAvailable=? WHERE id=?");
			ps.setString(1, p.getName());
			ps.setString(2, p.getPrice());
			ps.setString(3, p.getStockQuantity());
			ps.setString(4, p.getIsAvailable());
			ps.setInt(5, p.getId());
			return ps.executeUpdate()>0;
		} catch (Exception e) {
			
			return false;
		}
	}
}
