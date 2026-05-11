package Almacen;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;

public class PantallaProduct extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtName;
	private JTextField txtPrice;
	private JTextField txtStockQuantity;
	private JTextField txtIsAvailable;
	Product product = new Product();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaProduct frame = new PantallaProduct();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PantallaProduct() {
		setTitle("CRUD de Tienda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblID = new JLabel("ID");
		lblID.setBounds(74, 34, 114, 12);
		contentPane.add(lblID);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(74, 56, 114, 12);
		contentPane.add(lblName);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(74, 78, 114, 12);
		contentPane.add(lblPrice);
		
		JLabel lblStockQuantity = new JLabel("Stock Quantity");
		lblStockQuantity.setBounds(74, 100, 114, 12);
		contentPane.add(lblStockQuantity);
		
		JLabel lblIsAvailable = new JLabel("Is Available");
		lblIsAvailable.setBounds(74, 122, 114, 12);
		contentPane.add(lblIsAvailable);
		
		txtID = new JTextField();
		txtID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txtID.getText().length()>=11){
					e.consume();
				}
			}
		});
		txtID.setBounds(174, 31, 182, 18);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(174, 53, 182, 18);
		contentPane.add(txtName);
		
		txtPrice = new JTextField();
		txtPrice.setColumns(10);
		txtPrice.setBounds(174, 78, 182, 18);
		contentPane.add(txtPrice);
		
		txtStockQuantity = new JTextField();
		txtStockQuantity.setColumns(10);
		txtStockQuantity.setBounds(174, 100, 182, 18);
		contentPane.add(txtStockQuantity);
		
		txtIsAvailable = new JTextField();
		txtIsAvailable.setColumns(10);
		txtIsAvailable.setBounds(174, 122, 182, 18);
		contentPane.add(txtIsAvailable);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Product a = new Product(Integer.parseInt(txtID.getText()), txtName.getText(),
							txtPrice.getText(), txtStockQuantity.getText(), txtIsAvailable.getText());
					if(a.InsertProduct()) {
						limpiar();
						JOptionPane.showMessageDialog(null, "Se agrego correctamente");
					} else {
						JOptionPane.showMessageDialog(null, "ERROR AL AGREGAR");
					}
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "ERROR AL AGREGAR");
				}
			}
		});
		btnIngresar.setBounds(74, 167, 84, 20);
		contentPane.add(btnIngresar);
		
		JButton btnCargar = new JButton("Cargar");
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int id=Integer.parseInt(JOptionPane.showInputDialog("ID a cargar"));
					
					product.setId(id);
					if(product.CarryProduct()) {
						txtID.setText("" + product.getId());
						txtName.setText(product.getName());
						txtPrice.setText(product.getPrice());
						txtStockQuantity.setText(product.getStockQuantity());
						txtIsAvailable.setText(product.getIsAvailable());
						JOptionPane.showMessageDialog(null, "SE CARGO CORRECTAMENTE");
					} else {
						JOptionPane.showMessageDialog(null, "ERROR AL CARGAR");
					}
				} catch (Exception e2) {
					
					JOptionPane.showMessageDialog(null, "ERROR AL CARGAR");
				}
			}
		});
		btnCargar.setBounds(214, 167, 84, 20);
		contentPane.add(btnCargar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int id=Integer.parseInt(JOptionPane.showInputDialog("ID a eliminar"));
					Product a = new Product();
					a.setId(id);
					if(a.DeleteProduct()) {
						JOptionPane.showMessageDialog(null, "SE ELIMINO CORRECTAMENTE");
					} else {
						JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR");
					}
				} catch (Exception e2) {
					
					JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR");
				}
			}
		});
		//borra la cuenta brayan
		btnEliminar.setBounds(74, 208, 84, 20);
		contentPane.add(btnEliminar);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					product.setId(Integer.parseInt(txtID.getText().toString()));
					product.setName(txtName.getText());
					product.setPrice(txtPrice.getText());
					product.setStockQuantity(txtStockQuantity.getText());
					product.setIsAvailable(txtIsAvailable.getText());
					if(product.UpdateProduct()) {
						limpiar();
						JOptionPane.showMessageDialog(null, "Se actualizo correctamente");
					} else {
						JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR");
					}
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR");
				}
			}
		});
		btnActualizar.setBounds(214, 208, 84, 20);
		contentPane.add(btnActualizar);
		
		JButton btnBaseDatos = new JButton("Borrar la base de datos");
		btnBaseDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnBaseDatos.setBounds(242, 233, 170, 20);
		contentPane.add(btnBaseDatos);

	}
	public void limpiar() {
		txtID.setText("");
		txtName.setText("");
		txtPrice.setText("");
		txtStockQuantity.setText("");
		txtIsAvailable.setText("");
		PantallaProduct p = new PantallaProduct();
		p.setVisible(false);
				
	}
}
