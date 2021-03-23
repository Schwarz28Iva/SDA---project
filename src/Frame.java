import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.table.*;
import javax.swing.*; 
import java.awt.*; 
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.AbstractButton;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;


public class Frame extends JFrame {

	private JPanel contentPane;
	private JTextField txtNume;
	private JTextField txtVarsta;
	private JTable table;
	private JTextField txtSters;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
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
	public Frame() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 658, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelNume = new JPanel();
		panelNume.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelNume.setBounds(20, 48, 235, 33);
		contentPane.add(panelNume);
		panelNume.setLayout(null);
		
		JLabel lblNume = new JLabel("Nume: ");
		lblNume.setBounds(10, 0, 43, 33);
		panelNume.add(lblNume);
		lblNume.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		txtNume = new JTextField();
		txtNume.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNume.setColumns(10);
		txtNume.setBounds(63, 7, 162, 20);
		panelNume.add(txtNume);
		
		JPanel panelVarsta = new JPanel();
		panelVarsta.setLayout(null);
		panelVarsta.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelVarsta.setBounds(279, 48, 115, 33);
		contentPane.add(panelVarsta);
		
		JLabel lblVarsta = new JLabel("Varsta:");
		lblVarsta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblVarsta.setBounds(10, 0, 43, 33);
		panelVarsta.add(lblVarsta);
		
		txtVarsta = new JTextField();
		txtVarsta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtVarsta.setColumns(10);
		txtVarsta.setBounds(63, 7, 43, 20);
		panelVarsta.add(txtVarsta);
		
		JPanel panelSarcina = new JPanel();
		panelSarcina.setLayout(null);
		panelSarcina.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelSarcina.setBounds(410, 48, 104, 33);
		contentPane.add(panelSarcina);
		
		JLabel lblSarcina = new JLabel("Sarcina:");
		lblSarcina.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSarcina.setBounds(10, 0, 52, 33);
		panelSarcina.add(lblSarcina);
		
		JCheckBox checkSarcina = new JCheckBox("");
		checkSarcina.setHorizontalAlignment(SwingConstants.CENTER);
		checkSarcina.setBounds(65, 4, 25, 25);
		panelSarcina.add(checkSarcina);
		
		JPanel panelMotiv = new JPanel();
		panelMotiv.setLayout(null);
		panelMotiv.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelMotiv.setBounds(20, 92, 235, 33);
		contentPane.add(panelMotiv);
		
		JLabel lblMotiv = new JLabel("Motivul venirii:");
		lblMotiv.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMotiv.setBounds(10, 0, 100, 33);
		panelMotiv.add(lblMotiv);
		
		String motiv[]={"","control de rutina","discomfort","urgenta"};        
	    final JComboBox comboMotiv=new JComboBox(motiv);    
		comboMotiv.setBounds(103, 6, 122, 22);
		panelMotiv.add(comboMotiv);
		
		JPanel panelNevoie = new JPanel();
		panelNevoie.setLayout(null);
		panelNevoie.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelNevoie.setBounds(279, 92, 235, 33);
		contentPane.add(panelNevoie);
		
		JLabel lblNevoie = new JLabel("Nevoie de:");
		lblNevoie.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNevoie.setBounds(10, 0, 76, 33);
		panelNevoie.add(lblNevoie);
		
		JLabel lblOrdine = new JLabel("");
		lblOrdine.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblOrdine.setBounds(85, 264, 551, 17);
		contentPane.add(lblOrdine);
		
		JLabel lblNumar = new JLabel("");
		lblNumar.setText("0");
		lblNumar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNumar.setBounds(134, 297, 72, 23);
		contentPane.add(lblNumar);
		
		String nevoie[]={"","analize","pastile","perfuzie","copci"};        
	    final JComboBox comboNevoie=new JComboBox(nevoie);    
		comboNevoie.setBounds(83, 6, 122, 22);
		panelNevoie.add(comboNevoie);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 144, 616, 106);
		contentPane.add(scrollPane);
		
		JTable table = new JTable();
		scrollPane.setViewportView(table);
		DefaultTableModel model = new DefaultTableModel();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"Nume", "Varsta", "Sarcina", "Motiv", "Nevoie"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		
		JButton btnAdauga = new JButton("Adauga");
		BinomialHeap bh = new BinomialHeap( );
		String ordinenume;
		btnAdauga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String valoareMotiv = comboMotiv.getSelectedItem().toString();
				String valoareNevoie = comboNevoie.getSelectedItem().toString(); 
				if(txtNume.getText().equals("")||txtVarsta.getText().equals("")||valoareMotiv.equals("")||valoareNevoie.equals(""))
					{
					JOptionPane.showMessageDialog(null, "Nu ati completat toate campurile!");
					//boolean isNumeric = txtVarsta.getText().chars().allMatch( Character::isDigit );
					//System.out.println("aici"+isNumeric);
					String varsta;
					varsta=txtVarsta.getText();
					if(!(varsta.chars().allMatch( Character::isDigit )))
						JOptionPane.showMessageDialog(null, "Varsta nu este un numar!");
					}
			else {
				String valoareSarcina="-";
				if(checkSarcina.isSelected())
					valoareSarcina="da";
				int valoareScor=0;
				if(Integer.parseInt(txtVarsta.getText())<7||Integer.parseInt(txtVarsta.getText())>60)
					valoareScor=valoareScor+5;
				if(checkSarcina.isSelected())
					valoareScor=valoareScor+10;
				if(valoareMotiv.equals("urgenta"))
					valoareScor=valoareScor+10;
				if(valoareMotiv.equals("discomfort"))
					valoareScor=valoareScor+5;
				if(valoareNevoie.equals("perfuzie"))
					valoareScor=valoareScor+6;
				if(valoareNevoie.equals("copci"))
					valoareScor=valoareScor+10;
				if(valoareNevoie.equals("pastile"))
					valoareScor=valoareScor+3;
				Object data[] = {txtNume.getText(),txtVarsta.getText(),valoareSarcina,valoareMotiv,valoareNevoie, valoareScor};
				Pacient x=new Pacient(txtNume.getText(),Integer.parseInt(txtVarsta.getText()),valoareSarcina,valoareMotiv,valoareNevoie,valoareScor);
				//System.out.println(x);
				//String ordinenume;
				//ordinenume = txtNume.getText()+", ";
				//lblOrdine.setText(String.valueOf(ordinenume));
				Ordine a = new Ordine();
				a.aux="";
				bh.insert( x.scor, x.nume );
				bh.displayHeap(a);
				//bh.displayHeap(aux);
				lblOrdine.setText(String.valueOf(Ordine.aux));
				//bh.insert( x.scor, x.nume );
				//String v;
				//v=bh.displayHeap();
				//lblOrdine.setText(bh.displayHeap());
				lblNumar.setText(String.valueOf(bh.getSize()));
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(data);
				JOptionPane.showMessageDialog(null, "Pacient adaugat cu succes!");
				txtNume.setText("");
				txtVarsta.setText("");
				checkSarcina.setSelected(false);
				comboMotiv.setSelectedIndex(0);
				comboNevoie.setSelectedIndex(0);
			}
			}
		});
		//ordinenume = txtNume.getText()+", ";
		//lblOrdine.setText(String.valueOf(ordinenume));
		btnAdauga.setBounds(547, 102, 89, 23);
		contentPane.add(btnAdauga);
		
		JButton btnSterge = new JButton("Sterge");
		btnSterge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String valoareStergere;
				valoareStergere = txtSters.getText();
				//System.out.print(valoareStergere);
				//NU MERGE bh.delete
				bh.deleteName( valoareStergere );
				Ordine a = new Ordine();
				a.aux="";
				bh.displayHeap(a);
				lblOrdine.setText(String.valueOf(Ordine.aux));
				lblNumar.setText(String.valueOf(bh.getSize()));
				for (int i = 0; i < model.getRowCount(); i++) {
			        if (((String)table.getValueAt(i, 0)).equals(valoareStergere)) {
			            model.removeRow(i);
			            break;
			        }
			    }
				//TREBUIE SA STERG OBIECTUL
			}
		});
		btnSterge.setBounds(49, 346, 89, 23);
		contentPane.add(btnSterge);
		
		JButton btnGoleste = new JButton("Goleste");
		btnGoleste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ObjButtons[] = {"Da","Nu"};
		        int PromptResult = JOptionPane.showOptionDialog(null,"Esti sigur ca vrei sa golesti panoul?","Confirmare golire",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,ObjButtons,ObjButtons[1]);
		        if(PromptResult==JOptionPane.YES_OPTION)
		        	{
		        	bh.makeEmpty();
		        	lblNumar.setText(String.valueOf(bh.getSize()));
		        	lblOrdine.setText("");
		        	DefaultTableModel model = (DefaultTableModel) table.getModel();
		        	model.setRowCount(0);
		        	}
			}
		});
		btnGoleste.setBounds(410, 346, 89, 23);
		contentPane.add(btnGoleste);
		
		txtSters = new JTextField();
		txtSters.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtSters.getText().equals("Nume"))
				{
					txtSters.setText("");
					
				}
				else {
					txtSters.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtSters.getText().equals(""))
					txtSters.setText("Nume");
			}
		});
		txtSters.setText("Nume");
		txtSters.setFont(new Font("Tahoma", Font.ITALIC, 13));
		txtSters.setColumns(10);
		txtSters.setBounds(148, 347, 162, 20);
		contentPane.add(txtSters);
		
		JLabel lblNewLabel = new JLabel("Ordine:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(20, 261, 72, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Numar total:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(20, 297, 104, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Gestionarea Pacientilor");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(148, 11, 377, 26);
		contentPane.add(lblNewLabel_2);
		
		
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent we)
		    { 
		        String ObjButtons[] = {"Da","Nu"};
		        int PromptResult = JOptionPane.showOptionDialog(null,"Esti sigur ca vrei sa inchizi aplicatia","Confirmare inchidere",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,ObjButtons,ObjButtons[1]);
		        if(PromptResult==JOptionPane.YES_OPTION)
		        {
		            System.exit(0);
		        }
		    }
		});
	}
}
