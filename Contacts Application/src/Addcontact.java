import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;

public class Addcontact extends JFrame {

	private JPanel contentPane;
	private JTextField fnametxtfield;
	private JTextField lnametxtfield;
	private JTextField emailtxtfield;
	private JTextField phonetxtfield;
	private JTextField urltxtfield;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addcontact frame = new Addcontact();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static MainMenu mm = new MainMenu();

	/**
	 * Create the frame.
	 */
	public Addcontact() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel wpanel = new JPanel();
		wpanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(wpanel, BorderLayout.WEST);
		wpanel.setLayout(new GridLayout(7, 0, 0, 0));
		
		Icon menuicon= new ImageIcon("img/menupng.png");
		JButton menubtn = new JButton(menuicon);
		
		menubtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				mm.show();
				dispose();
				
			}
		});
		menubtn.setBackground(new Color(255, 255, 255));
		wpanel.add(menubtn);
		
		Icon addicon= new ImageIcon("img/addpng.png");
		JButton addbtn = new JButton(addicon);
		addbtn.setBackground(new Color(255, 255, 255));
		wpanel.add(addbtn);
		
		Icon importicon= new ImageIcon("img/importpng.png");
		JButton importbtn = new JButton(importicon);
		importbtn.setBackground(new Color(255, 255, 255));
		wpanel.add(importbtn);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 0, 0));
		wpanel.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 0, 0));
		wpanel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(128, 0, 0));
		wpanel.add(panel_2);
		
		Icon settingsicon= new ImageIcon("img/settingfpng.png");
		JButton settingsbtn = new JButton(settingsicon);
		settingsbtn.setBackground(new Color(255, 255, 255));
		wpanel.add(settingsbtn);
		
		JPanel mainpanel = new JPanel();
		contentPane.add(mainpanel, BorderLayout.CENTER);
		mainpanel.setLayout(new BorderLayout(0, 0));
		
		JPanel bottompanel = new JPanel();
		bottompanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		bottompanel.setBackground(Color.DARK_GRAY);
		mainpanel.add(bottompanel, BorderLayout.SOUTH);
		bottompanel.setLayout(new GridLayout(1, 7, 0, 0));
		
		Icon exiticon= new ImageIcon("img/back.png");
		JButton exitbtn = new JButton(exiticon);
		exitbtn.setBackground(new Color(255, 255, 255));
		exitbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				mm.show();
				dispose();
			}
		});
		bottompanel.add(exitbtn);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(64, 0, 0));
		bottompanel.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(64, 0, 0));
		bottompanel.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(64, 0, 0));
		bottompanel.add(panel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(64, 0, 0));
		bottompanel.add(panel_6);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(64, 0, 0));
		bottompanel.add(panel_7);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(64, 0, 0));
		bottompanel.add(panel_8);
		
		Icon checkicon= new ImageIcon("img/check.png");
		JButton checkbtn = new JButton(checkicon);
		checkbtn.setBackground(new Color(255, 255, 255));
		bottompanel.add(checkbtn);
		
		JPanel infopanel = new JPanel();
		infopanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		mainpanel.add(infopanel, BorderLayout.CENTER);
		infopanel.setLayout(new GridLayout(5, 0, 0, 0));
		
		JPanel namepanel = new JPanel();
		infopanel.add(namepanel);
		namepanel.setLayout(new GridLayout(1, 4, 0, 0));
		
		Icon namelblicon= new ImageIcon("img/personpng.png");
		JLabel namelbl = new JLabel(namelblicon);
		namepanel.add(namelbl);
		
		fnametxtfield= new JTextField();
		namepanel.add(fnametxtfield);
		fnametxtfield.setColumns(10);
		
		lnametxtfield = new JTextField();
		namepanel.add(lnametxtfield);
		lnametxtfield.setColumns(10);
		
		JLabel emplbl1 = new JLabel("");
		namepanel.add(emplbl1);
		
		
		
		JPanel emailpanel = new JPanel();
		infopanel.add(emailpanel);
		emailpanel.setLayout(new GridLayout(1, 4, 0, 0));
		
		Icon emaillblicon= new ImageIcon("img/mail.png");
		JLabel emaillbl = new JLabel(emaillblicon);
		emailpanel.add(emaillbl);
		
		emailtxtfield = new JTextField();
		emailpanel.add(emailtxtfield);
		emailtxtfield.setColumns(10);
		
		JPanel panel_9 = new JPanel();
		emailpanel.add(panel_9);
		
		JLabel emplbl2 = new JLabel("");
		emailpanel.add(emplbl2);
		
		JPanel phonepanel = new JPanel();
		infopanel.add(phonepanel);
		phonepanel.setLayout(new GridLayout(1, 4, 0, 0));
		
		Icon numlblicon= new ImageIcon("img/phone.png");
		JLabel numlbl = new JLabel(numlblicon);
		phonepanel.add(numlbl);
		
		phonetxtfield = new JTextField();
		phonepanel.add(phonetxtfield);
		phonetxtfield.setColumns(10);
		
		JPanel panel_10 = new JPanel();
		phonepanel.add(panel_10);
		
		JLabel emplbl3 = new JLabel("");
		phonepanel.add(emplbl3);
		
		JPanel webpanel = new JPanel();
		infopanel.add(webpanel);
		webpanel.setLayout(new GridLayout(1, 4, 0, 0));
		
		Icon urllblicon= new ImageIcon("img/world.png");
		JLabel urllbl = new JLabel(urllblicon);
		webpanel.add(urllbl);
		
		urltxtfield = new JTextField();
		urltxtfield.setText("");
		webpanel.add(urltxtfield);
		urltxtfield.setColumns(10);
		
		JPanel panel_11 = new JPanel();
		webpanel.add(panel_11);
		
		JLabel emplbl4 = new JLabel("");
		webpanel.add(emplbl4);
		
		JPanel locationpanel = new JPanel();
		infopanel.add(locationpanel);
		locationpanel.setLayout(new GridLayout(1, 4, 0, 0));
		
		Icon loclblicon= new ImageIcon("img/loc.png");
		JLabel loclbl = new JLabel(loclblicon);
		locationpanel.add(loclbl);
		
		JComboBox loccmbbox = new JComboBox();
		loccmbbox.setModel(new DefaultComboBoxModel(new String[] {"Afghanistan", "Albania", "Algeria", "Andorra", "Angola", "Antigua & Deps", "Argentina", "Armenia", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bhutan", "Bolivia", "Bosnia Herzegovina", "Botswana", "Brazil", "Brunei", "Bulgaria", "Burkina", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Central African Rep", "Chad", "Chile", "China", "Colombia", "Comoros", "Congo", "Congo {Democratic Rep}", "Costa Rica", "Croatia", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Fiji", "Finland", "France", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Greece", "Grenada", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Honduras", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland {Republic}", "Israel", "Italy", "Ivory Coast", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Korea North", "Korea South", "Kosovo", "Kuwait", "Kyrgyzstan", "Laos", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Macedonia", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Mauritania", "Mauritius", "Mexico", "Micronesia", "Moldova", "Monaco", "Mongolia", "Montenegro", "Morocco", "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal", "Netherlands", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Poland", "Portugal", "Qatar", "Romania", "Russian Federation", "Rwanda", "St Kitts & Nevis", "St Lucia", "Saint Vincent & the Grenadines", "Samoa", "San Marino", "Sao Tome & Principe", "Saudi Arabia", "Senegal", "Serbia", "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Sudan", "Spain", "Sri Lanka", "Sudan", "Suriname", "Swaziland", "Sweden", "Switzerland", "Syria", "Taiwan", "Tajikistan", "Tanzania", "Thailand", "Togo", "Tonga", "Trinidad & Tobago", "Tunisia", "Turkey", "Turkmenistan", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States", "Uruguay", "Uzbekistan", "Vanuatu", "Vatican City", "Venezuela", "Vietnam", "Yemen", "Zambia", "Zimbabwe"}));
		locationpanel.add(loccmbbox);
		
		JPanel panel_12 = new JPanel();
		locationpanel.add(panel_12);
		
		JLabel emplbl5 = new JLabel("");
		locationpanel.add(emplbl5);
		
		
		checkbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(!isFilled())
				{
					JLabel label = new JLabel("Not every field was filled!");
                    label.setFont(new Font("Tahoma", java.awt.Font.BOLD, 18));
                    JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
				MainMenu cp= new MainMenu(fnametxtfield.getText(), lnametxtfield.getText(), emailtxtfield.getText(), phonetxtfield.getText(), urltxtfield.getText(), (String) loccmbbox.getSelectedItem());	
				mm.show();
				JLabel label = new JLabel("Contact added successfully!");
                label.setFont(new Font("Tahoma", java.awt.Font.BOLD, 18));
                JOptionPane.showMessageDialog(null, label, "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                dispose();
				}
			}
		});
		
	}
	public boolean isFilled() {
		if(fnametxtfield.getText().isEmpty()||lnametxtfield.getText().isEmpty()||emailtxtfield.getText().isEmpty()||phonetxtfield.getText().isEmpty()||urltxtfield.getText().isEmpty())
		{
			return false;
	    }
		return true;
	
	}

}

