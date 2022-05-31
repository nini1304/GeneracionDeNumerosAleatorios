package Practica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.TextArea;

public class ProductosMedios extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextArea textArea, textArea_1;
	private String semilla, semilla2;
	private int tam,tam2;
	private int semillaint, semillaint2, aux;
	private int cuantos;
	private int multiplicacion;
	private String multiplicacionstring , resultado;
	private ArrayList<String> arrayaux = new ArrayList<String>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductosMedios frame = new ProductosMedios();
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
	public ProductosMedios() {
		this.setIconImage(new ImageIcon(getClass().getResource("numbers.png")).getImage());
		this.setTitle("Algoritmo No Congruencial Productos Medios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1003, 521);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 989, 484);
		ImageIcon ico=new ImageIcon(getClass().getResource("numeros2.png"));
        ImageIcon img =new ImageIcon(ico.getImage().getScaledInstance(lblNewLabel.getWidth(),lblNewLabel.getHeight(), Image.SCALE_SMOOTH));
        
        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(783, 176, 196, 73);
        contentPane.add(scrollPane_1);
        
        textArea_1 = new JTextArea();
        scrollPane_1.setViewportView(textArea_1);
        textArea_1.setEditable(false);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(31, 132, 731, 247);
        contentPane.add(scrollPane);
        
        textArea = new JTextArea();
        scrollPane.setViewportView(textArea);
        textArea.setEditable(false);
        textArea.setBackground(new Color(255, 245, 145));
        
        JButton btnNewButton_2 = new JButton("Atras");
        btnNewButton_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		llamarna();
        	}
        });
        btnNewButton_2.setBackground(new Color(5, 223, 215));
        btnNewButton_2.setFont(new Font("Broadway", Font.PLAIN, 24));
        btnNewButton_2.setBounds(568, 396, 149, 35);
        contentPane.add(btnNewButton_2);
        
        JButton btnNewButton_1 = new JButton("Limpiar");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		textField.setText("");
        		textField_1.setText("");
        		textField_2.setText("");
        		textArea.setText("");
        		textArea_1.setText("");
        	}
        });
        btnNewButton_1.setBackground(new Color(5, 223, 215));
        btnNewButton_1.setFont(new Font("Broadway", Font.PLAIN, 24));
        btnNewButton_1.setBounds(334, 396, 149, 35);
        contentPane.add(btnNewButton_1);
        
        JButton btnNewButton = new JButton("Generar");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String tabla= "   i\t|\tXi-1\t|\tXi\t|\tYi\t|\tXi+1\t|\tRi\n";
        		tabla+="-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n";
        		semilla=textField.getText();
        		semilla2=textField_1.getText();
                tam=semilla.length();
                semillaint=Integer.parseInt(semilla);
                semillaint2=Integer.parseInt(semilla2);
                cuantos=Integer.parseInt(textField_2.getText());
                int flag=0;
                int auxiliar=0;
               // arrayaux.add("0");
                arrayaux=new ArrayList<String>();
                    for (int i=1;i<=cuantos;i++) {
                        multiplicacion=semillaint2*semillaint;
                        multiplicacionstring=Long.toString(multiplicacion);
                        tam2= multiplicacionstring.length();
                        aux=(tam2-tam)/2;
                        resultado=multiplicacionstring.substring(aux,aux+tam);
                        if (flag==0) {
                            for(int x = 0; x < arrayaux.size(); x++) {
                            	String elementos= arrayaux.get(x);
                            	
                            	
                            	if(resultado.equals(elementos)) {
                            		flag=1;
                            		auxiliar=i;
                            		
                            		
                            	}
                            		
                            	
                            }
                            }
                            	
                            arrayaux.add(resultado);
                        tabla+="   "+i+"\t|\t"+semillaint+"\t|\t"+semillaint2+"\t|\t"+multiplicacion+"\t|\t"+resultado+"\t|\t"+((Long.parseLong(resultado))/Math.pow(10, tam))+"\n";
                        semillaint=semillaint2;
                        semillaint2=Integer.parseInt(resultado);
                        
                        
                    }
        		textArea.setText(tabla);
        		if(flag==1) {
        			textArea_1.setText("El algoritmo se degenera en la posicion: "+(auxiliar-1));
        		}else {
        			textArea_1.setText("El algoritmo no se degenero con los datos ingresados");
        		}
        	}
        });
        btnNewButton.setBackground(new Color(163, 247, 191));
        btnNewButton.setFont(new Font("Broadway", Font.PLAIN, 24));
        btnNewButton.setBounds(84, 396, 149, 35);
        contentPane.add(btnNewButton);
        
        textField_2 = new JTextField();
        textField_2.setBounds(814, 91, 140, 33);
        contentPane.add(textField_2);
        textField_2.setColumns(10);
        
        JLabel lblNewLabel_4 = new JLabel("Cuantos Desea Generar:");
        lblNewLabel_4.setFont(new Font("Broadway", Font.PLAIN, 24));
        lblNewLabel_4.setBounds(471, 67, 318, 72);
        contentPane.add(lblNewLabel_4);
        
        textField_1 = new JTextField();
        textField_1.setBounds(318, 94, 132, 28);
        contentPane.add(textField_1);
        textField_1.setColumns(10);
        
        JLabel lblNewLabel_3 = new JLabel("X1:");
        lblNewLabel_3.setFont(new Font("Broadway", Font.PLAIN, 24));
        lblNewLabel_3.setBounds(260, 84, 99, 39);
        contentPane.add(lblNewLabel_3);
        
        textField = new JTextField();
        textField.setBounds(84, 94, 146, 28);
        contentPane.add(textField);
        textField.setColumns(10);
        
        JLabel lblNewLabel_2 = new JLabel("X0:");
        lblNewLabel_2.setFont(new Font("Broadway", Font.PLAIN, 24));
        lblNewLabel_2.setBounds(31, 94, 99, 28);
        contentPane.add(lblNewLabel_2);
        
        JLabel lblNewLabel_1 = new JLabel("PRODUCTOS MEDIOS");
        lblNewLabel_1.setFont(new Font("Broadway", Font.PLAIN, 48));
        lblNewLabel_1.setBounds(236, 10, 544, 55);
        contentPane.add(lblNewLabel_1);
        lblNewLabel.setIcon(img);
		contentPane.add(lblNewLabel);
	}
	
	void llamarna() {
		dispose();//para que se cierre la pestana
		NumerosAleatorios obj1=new NumerosAleatorios();
		  obj1.setLocationRelativeTo(null);  
		  obj1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  obj1.setVisible(true);
	}
}
