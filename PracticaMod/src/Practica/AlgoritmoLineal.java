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
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class AlgoritmoLineal extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextArea textArea, textArea_1;
	private String semilla, c, cuantos, k;
	private int semillaint, kint, cint, cuantosint, a, multiplicacion, suma, mod, m;
	private double g, resultado;
	private BigDecimal resulredon;
	private ArrayList<Double> arrayaux = new ArrayList<Double>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlgoritmoLineal frame = new AlgoritmoLineal();
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
	public AlgoritmoLineal() {
		this.setIconImage(new ImageIcon(getClass().getResource("numbers.png")).getImage());
		this.setTitle("Algoritmo Congruencial Lineal");
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
        
        JButton btnNewButton_2 = new JButton("Atras");
        btnNewButton_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		llamarna();
        	}
        });
        btnNewButton_2.setBackground(new Color(5, 223, 215));
        btnNewButton_2.setFont(new Font("Broadway", Font.PLAIN, 24));
        btnNewButton_2.setBounds(555, 402, 143, 35);
        contentPane.add(btnNewButton_2);
        
        JButton btnNewButton_1 = new JButton("Limpiar");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		textField.setText("");
        		textField_1.setText("");
        		textField_2.setText("");
        		textField_3.setText("");
        		textArea.setText("");
        		textArea_1.setText("");
        	}
        });
        btnNewButton_1.setBackground(new Color(5, 223, 215));
        btnNewButton_1.setFont(new Font("Broadway", Font.PLAIN, 24));
        btnNewButton_1.setBounds(324, 402, 143, 35);
        contentPane.add(btnNewButton_1);
        
        JButton btnNewButton = new JButton("Generar");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String tabla= "   i\t|\tg\t|\tm\t|\tk\t|\ta\t|\tc\t|\taXi-1+c\t|\tXi\t|\tRi\n";
        		tabla+="---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n";
        		semilla=textField.getText();
        		k=textField_1.getText();
        		c=textField_2.getText();
        		cuantos=textField_3.getText();
        		semillaint=Integer.parseInt(semilla);
        		kint=Integer.parseInt(k);
        		cint=Integer.parseInt(c);
        		cuantosint=Integer.parseInt(cuantos);
        		g=(Math.log(cuantosint))/(Math.log(2));
        		m=(int)Math.pow(2, g);
        		a=1+(4*kint);
        		int flag=0;
                int auxiliar=0;
               // arrayaux.add("0");
                arrayaux=new ArrayList<Double>();
        		for (int i=1;i<=cuantosint;i++) {
        			multiplicacion=(a*semillaint);
        			suma=multiplicacion+cint;
        			mod=Math.floorMod(suma, m);
        			resultado=(double)(mod)/(double)(m-1);
        			
        			if (flag==0) {
                        for(int x = 0; x < arrayaux.size(); x++) {
                        	Double elementos= arrayaux.get(x);
                        	
                        	
                        	
                        	if(resultado==elementos) {
                        		flag=1;
                        		auxiliar=i;
                        		
                        		
                        	}
                        		
                        	
                        }
                        }
                        	
                        arrayaux.add(resultado);
        			resulredon= new BigDecimal(resultado).setScale(4, RoundingMode.HALF_UP);
        			tabla+= "   "+i+"\t|\t"+g+"\t|\t"+m+"\t|\t"+kint+"\t|\t"+a+"\t|\t"+cint+"\t|\t"+suma+"\t|\t"+mod+"\t|\t"+resulredon+"\n";
        			semillaint=mod;
        			System.out.println(resulredon);
        			
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
        btnNewButton.setBounds(91, 402, 149, 35);
        contentPane.add(btnNewButton);
        
        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(783, 176, 196, 73);
        contentPane.add(scrollPane_1);
        
        textArea_1 = new JTextArea();
        scrollPane_1.setViewportView(textArea_1);
        textArea_1.setEditable(false);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(23, 138, 731, 245);
        contentPane.add(scrollPane);
        
        textArea = new JTextArea();
        scrollPane.setViewportView(textArea);
        textArea.setEditable(false);
        textArea.setBackground(new Color(255, 245, 145));
        
        textField_3 = new JTextField();
        textField_3.setBounds(842, 87, 101, 34);
        contentPane.add(textField_3);
        textField_3.setColumns(10);
        
        JLabel lblNewLabel_5 = new JLabel("Cuantos Desea Generar:");
        lblNewLabel_5.setFont(new Font("Broadway", Font.PLAIN, 24));
        lblNewLabel_5.setBounds(517, 71, 347, 57);
        contentPane.add(lblNewLabel_5);
        
        textField_2 = new JTextField();
        textField_2.setBounds(404, 87, 101, 33);
        contentPane.add(textField_2);
        textField_2.setColumns(10);
        
        JLabel lblNewLabel_4 = new JLabel("C:");
        lblNewLabel_4.setFont(new Font("Broadway", Font.PLAIN, 24));
        lblNewLabel_4.setBounds(365, 82, 48, 34);
        contentPane.add(lblNewLabel_4);
        
        textField_1 = new JTextField();
        textField_1.setBounds(238, 87, 101, 33);
        contentPane.add(textField_1);
        textField_1.setColumns(10);
        
        JLabel lblNewLabel_3 = new JLabel("K:");
        lblNewLabel_3.setFont(new Font("Broadway", Font.PLAIN, 24));
        lblNewLabel_3.setBounds(189, 79, 48, 41);
        contentPane.add(lblNewLabel_3);
        
        textField = new JTextField();
        textField.setBounds(78, 87, 101, 33);
        contentPane.add(textField);
        textField.setColumns(10);
        
        JLabel lblNewLabel_2 = new JLabel("X0:");
        lblNewLabel_2.setFont(new Font("Broadway", Font.PLAIN, 24));
        lblNewLabel_2.setBounds(23, 82, 59, 34);
        contentPane.add(lblNewLabel_2);
        
        JLabel lblNewLabel_1 = new JLabel("ALGORITMO LINEAL");
        lblNewLabel_1.setFont(new Font("Broadway", Font.PLAIN, 48));
        lblNewLabel_1.setBounds(238, 10, 530, 67);
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
