package Practica;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NumerosAleatorios extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NumerosAleatorios frame = new NumerosAleatorios();
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
	public NumerosAleatorios() {
		this.setIconImage(new ImageIcon(getClass().getResource("numbers.png")).getImage());
		this.setTitle("Menú De Opciones");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1003, 521);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(0, 0, 989, 484);
		ImageIcon ico=new ImageIcon(getClass().getResource("numeros2.png"));
        ImageIcon img =new ImageIcon(ico.getImage().getScaledInstance(lblNewLabel.getWidth(),lblNewLabel.getHeight(), Image.SCALE_SMOOTH));
        
        JButton btnNewButton_3 = new JButton("Algoritmo Multiplicativo");
        btnNewButton_3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		llamaram();
        	}
        });
        btnNewButton_3.setBackground(new Color(5, 223, 215));
        btnNewButton_3.setFont(new Font("Broadway", Font.PLAIN, 24));
        btnNewButton_3.setBounds(294, 397, 377, 44);
        contentPane.add(btnNewButton_3);
        
        JButton btnNewButton_2 = new JButton("Algoritmo Lineal");
        btnNewButton_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		llamaral();
        	}
        });
        btnNewButton_2.setBackground(new Color(5, 223, 215));
        btnNewButton_2.setFont(new Font("Broadway", Font.PLAIN, 24));
        btnNewButton_2.setBounds(294, 315, 377, 44);
        contentPane.add(btnNewButton_2);
        
        JButton btnNewButton_1 = new JButton("Producto Medios");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		llamarpm();
        	}
        });
        btnNewButton_1.setBackground(new Color(5, 223, 215));
        btnNewButton_1.setFont(new Font("Broadway", Font.PLAIN, 24));
        btnNewButton_1.setBounds(294, 243, 377, 44);
        contentPane.add(btnNewButton_1);
        
        JButton btnNewButton = new JButton("Cuadrados Medios");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		llamarcm();
        		
        	}
        });
        btnNewButton.setBackground(new Color(5, 223, 215));
        btnNewButton.setFont(new Font("Broadway", Font.PLAIN, 24));
        btnNewButton.setBounds(294, 155, 377, 44);
        contentPane.add(btnNewButton);
        
        JLabel lblNewLabel_1 = new JLabel("MENU DE OPCIONES");
        lblNewLabel_1.setFont(new Font("Broadway", Font.PLAIN, 60));
        lblNewLabel_1.setBounds(144, 29, 671, 76);
        contentPane.add(lblNewLabel_1);
        lblNewLabel.setIcon(img);
		contentPane.add(lblNewLabel);
	}
	void llamarcm() {
		dispose();//para que se cierre la pestana
		CuadradosMedios obj1=new CuadradosMedios();
		  obj1.setLocationRelativeTo(null);  
		  obj1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  obj1.setVisible(true);
	}
	void llamarpm() {
		dispose();//para que se cierre la pestana
		ProductosMedios obj1=new ProductosMedios();
		  obj1.setLocationRelativeTo(null);  
		  obj1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  obj1.setVisible(true);
	}
	void llamaral() {
		dispose();//para que se cierre la pestana
		AlgoritmoLineal obj1=new AlgoritmoLineal();
		  obj1.setLocationRelativeTo(null);  
		  obj1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  obj1.setVisible(true);
	}
	void llamaram() {
		dispose();//para que se cierre la pestana
		AlgoritmoMultiplicativo obj1=new AlgoritmoMultiplicativo();
		  obj1.setLocationRelativeTo(null);  
		  obj1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  obj1.setVisible(true);
	}
}
