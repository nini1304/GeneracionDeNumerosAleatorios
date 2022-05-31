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
import java.awt.TextArea;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class CuadradosMedios extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextArea textArea, textArea_1;
	private String semilla;
	private int tam,tam2;
	private int semillaint, aux;
	private int cuantos;
	private long cuadrado;
	private String cuadradostring , resultado;
	private ArrayList<String> arrayaux = new ArrayList<String>();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CuadradosMedios frame = new CuadradosMedios();
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
	public CuadradosMedios() {
		this.setIconImage(new ImageIcon(getClass().getResource("numbers.png")).getImage());
		this.setTitle("Algoritmo No Congruencial Cuadrados Medios");
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
        scrollPane.setBounds(31, 131, 731, 246);
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
        btnNewButton_2.setBounds(581, 398, 149, 33);
        contentPane.add(btnNewButton_2);
        
        textField_1 = new JTextField();
        textField_1.setBounds(629, 86, 178, 35);
        contentPane.add(textField_1);
        textField_1.setColumns(10);
        
        JLabel lblNewLabel_3 = new JLabel("Cuantos Desea Generar:");
        lblNewLabel_3.setFont(new Font("Broadway", Font.PLAIN, 24));
        lblNewLabel_3.setBounds(278, 79, 388, 40);
        contentPane.add(lblNewLabel_3);
        
        textField = new JTextField();
        textField.setBounds(99, 86, 149, 35);
        contentPane.add(textField);
        textField.setColumns(10);
        
        JButton btnNewButton_1 = new JButton("Generar");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String tabla= "   i\t|\tYi\t|\tYi^2\t|\tXi\t|\tRi\n";
        		tabla+="-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n";
        		semilla=textField.getText();
                tam=semilla.length();
                semillaint=Integer.parseInt(semilla);
                cuantos=Integer.parseInt(textField_1.getText());
                int flag=0;
                int auxiliar=0;
               // arrayaux.add("0");
                arrayaux=new ArrayList<String>();
                    for (int i=1;i<=cuantos;i++) {
                        cuadrado=(long)Math.pow(semillaint, 2);
                        cuadradostring=Long.toString(cuadrado);
                        tam2= cuadradostring.length();
                        aux=(tam2-tam)/2;
                        resultado=cuadradostring.substring(aux,aux+tam);
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
                        	
                        
                        tabla+="   "+i+"\t|\t"+semillaint+"\t|\t"+cuadrado+"\t|\t"+resultado+"\t|\t"+((Long.parseLong(resultado))/Math.pow(10, tam))+"\n";
                        semillaint=Integer.parseInt(resultado);
                        
                    }
        		textArea.setText(tabla);
        		if(flag==1) {
        			textArea_1.setText("El algoritmo se degenera en la posicion: "+(auxiliar-1));
        		}else {
        			textArea_1.setText("El algoritmo no se degenero con los datos ingresados");
        		}
        		
        		
        	}
        });
        btnNewButton_1.setBackground(new Color(163, 247, 191));
        btnNewButton_1.setFont(new Font("Broadway", Font.PLAIN, 24));
        btnNewButton_1.setBounds(99, 397, 149, 35);
        contentPane.add(btnNewButton_1);
        
        JButton btnNewButton = new JButton("Limpiar");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		textField.setText("");
        		textField_1.setText("");
        		textArea.setText("");
        		textArea_1.setText("");
        		
        	}
        });
        btnNewButton.setBackground(new Color(5, 223, 215));
        btnNewButton.setFont(new Font("Broadway", Font.PLAIN, 24));
        btnNewButton.setBounds(345, 397, 149, 35);
        contentPane.add(btnNewButton);
        
        JLabel lblNewLabel_2 = new JLabel("X0:");
        lblNewLabel_2.setFont(new Font("Broadway", Font.PLAIN, 24));
        lblNewLabel_2.setBounds(31, 82, 76, 35);
        contentPane.add(lblNewLabel_2);
        
        JLabel lblNewLabel_1 = new JLabel("CUADRADOS MEDIOS");
        lblNewLabel_1.setFont(new Font("Broadway", Font.PLAIN, 48));
        lblNewLabel_1.setBounds(218, 21, 567, 33);
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
