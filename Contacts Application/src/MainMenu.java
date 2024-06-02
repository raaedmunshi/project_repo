import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractButton;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.io.FileNotFoundException;
import java.awt.FlowLayout;

public class MainMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	private static ArrayList<Contact> clist;
	public static JList contactlist = new JList();
	private static DefaultListModel model;
	
	
	
	/**
	 * Create the frame.
	 */
	
	public MainMenu() {
		
		clist= new ArrayList<Contact>();
		model= new DefaultListModel();
		contactlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		contactlist.setModel(model);
		
		Icon deleteicon= new ImageIcon("img/delete.PNG");
		JButton deletebtn = new JButton(deleteicon);

        
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel wpanel = new JPanel();
		wpanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		wpanel.setBackground(new Color(192, 192, 192));
		wpanel.setForeground(new Color(128, 64, 64));
		contentPane.add(wpanel, BorderLayout.WEST);
		wpanel.setLayout(new GridLayout(7, 3, 0, 0));
		
		Icon menuicon= new ImageIcon("img/menupng.png");
		
		JButton menubtn = new JButton(menuicon);
		menubtn.setForeground(new Color(64, 0, 0));
		menubtn.setPreferredSize(new Dimension(40,40));
		menubtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		menubtn.setBackground(new Color(255, 255, 255));
		wpanel.add(menubtn);
		
		Icon addicon= new ImageIcon("img/addpng.png");
		
		JButton addbtn = new JButton(addicon);
		addbtn.setPreferredSize(new Dimension(40,40));
		addbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Addcontact adc= new Addcontact();
				adc.show();
				dispose();
				
			}
		});
		
		addbtn.setBackground(new Color(255, 255, 255));
		wpanel.add(addbtn);
		

		JPanel mainpanel = new JPanel();
		contentPane.add(mainpanel, BorderLayout.CENTER);
		mainpanel.setLayout(new BorderLayout(0, 0));
		
		JPanel infopanel = new JPanel();
		infopanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		infopanel.setBackground(new Color(255, 255, 255));
		mainpanel.add(infopanel, BorderLayout.CENTER);
		infopanel.setLayout(new GridLayout(5, 0, 0, 0));
		
		JPanel namepanel = new JPanel();
		namepanel.setBorder(null);
		infopanel.add(namepanel);
		namepanel.setLayout(new GridLayout(1, 5, 0, 0));
		
		Icon nameicon= new ImageIcon("img/personpng.png");
		JLabel namelabel = new JLabel(nameicon);
		namepanel.add(namelabel);
		
		JTextField fnametxtfield = new JTextField();
		fnametxtfield.setEditable(false);
		namepanel.add(fnametxtfield);
		
		JTextField lnametxtfield = new JTextField();
		lnametxtfield.setEditable(false);
		namepanel.add(lnametxtfield);
		
		
		JPanel emailpanel = new JPanel();
		infopanel.add(emailpanel);
		emailpanel.setLayout(new GridLayout(1, 5, 0, 0));
		
		Icon emailicon= new ImageIcon("img/mail.png");
		JLabel emaillabel = new JLabel(emailicon);
		emailpanel.add(emaillabel);
		
		JTextField emailtxtfield = new JTextField();
		emailtxtfield.setForeground(new Color(0, 0, 255));
		emailtxtfield.setBackground(new Color(231, 232, 233));
		emailtxtfield.setFont(new Font("Tahoma", Font.BOLD, 11));
		emailtxtfield.setEditable(false);
		emailpanel.add(emailtxtfield);
		
		JPanel panel = new JPanel();
		emailpanel.add(panel);
		
		JPanel phonepanel = new JPanel();
		infopanel.add(phonepanel);
		phonepanel.setLayout(new GridLayout(1, 5, 0, 0));
		
		Icon phoneicon= new ImageIcon("img/phone.png");
		JLabel phonelabel = new JLabel(phoneicon);
		phonepanel.add(phonelabel);
		
		JTextField phonetxtfield = new JTextField();
		phonetxtfield.setEditable(false);
		phonepanel.add(phonetxtfield);
		
		JPanel webpanel = new JPanel();
		infopanel.add(webpanel);
		webpanel.setLayout(new GridLayout(1, 5, 0, 0));
		
		Icon webicon= new ImageIcon("img/world.png");
		JLabel weblabel = new JLabel(webicon);
		webpanel.add(weblabel);
		
		JTextField urltxtfield = new JTextField();
		urltxtfield.setFont(new Font("Tahoma", Font.BOLD, 11));
		urltxtfield.setForeground(new Color(0, 0, 255));
		urltxtfield.setEditable(false);
		webpanel.add(urltxtfield);
		
		JPanel locationpanel = new JPanel();
		infopanel.add(locationpanel);
		locationpanel.setLayout(new GridLayout(1, 5, 0, 0));
		
		Icon locicon= new ImageIcon("img/loc.png");
		JLabel locationlabel = new JLabel(locicon);
		locationpanel.add(locationlabel);
		
		JTextField loctxtfield = new JTextField();
		loctxtfield.setEditable(false);
		locationpanel.add(loctxtfield);
		
		Icon importicon= new ImageIcon("img/importpng.png");
		
		JButton importbtn = new JButton(importicon);
		
		importbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc=new JFileChooser();
		        fc.setCurrentDirectory(new File(System.getProperty("user.home")));
		        
		        int fstate=fc.showSaveDialog(null);
		        
		        if(fstate==JFileChooser.APPROVE_OPTION)
		        {
		            File selectedfile=fc.getSelectedFile();
		            String path=selectedfile.getAbsolutePath();
		            
		            
		            File file=new File(path);
		            try {
		                Scanner sc=new Scanner(file);
		                while(sc.hasNextLine())
		                {
		                    fnametxtfield.setText(sc.nextLine());
		                    lnametxtfield.setText(sc.nextLine());
		                    emailtxtfield.setText(sc.nextLine());
		                    phonetxtfield.setText(sc.nextLine());
		                    urltxtfield.setText(sc.nextLine());
		                    loctxtfield.setText(sc.nextLine());
		                }
		                MainMenu mm=new MainMenu(fnametxtfield.getText(),lnametxtfield.getText(),emailtxtfield.getText(),phonetxtfield.getText(),urltxtfield.getText(),loctxtfield.getText());
		            } catch (IOException ex) {
		                ex.printStackTrace();
		            }
		               JLabel label = new JLabel("Contact imported successfully.");
		                    label.setFont(new Font("Arial", java.awt.Font.BOLD, 18));
		                    JOptionPane.showMessageDialog(null, label, "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
		            
		        }
		        
			}
		});
		importbtn.setPreferredSize(new Dimension(40, 40));
		importbtn.setBackground(new Color(255, 255, 255));
		wpanel.add(importbtn);
		
		
		
		
		JPanel blankpanel1 = new JPanel();
		blankpanel1.setForeground(new Color(64, 0, 0));
		blankpanel1.setBackground(new Color(64, 0, 0));
		wpanel.add(blankpanel1);
		
		JPanel blankpanel2 = new JPanel();
		blankpanel2.setBackground(new Color(64, 0, 0));
		wpanel.add(blankpanel2);
		
		JPanel blankpanel3 = new JPanel();
		blankpanel3.setBackground(new Color(64, 0, 0));
		wpanel.add(blankpanel3);
		
		Icon settingsicon= new ImageIcon("img/settingfpng.PNG");
		JButton settingsbtn = new JButton(settingsicon);
		settingsbtn.setPreferredSize(new Dimension(40,40));
		settingsbtn.setBackground(new Color(255, 255, 255));
		wpanel.add(settingsbtn);
		
		
		JPanel jcontactpanel = new JPanel();
		jcontactpanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		jcontactpanel.setBackground(new Color(255, 255, 255));
		mainpanel.add(jcontactpanel, BorderLayout.NORTH);
		jcontactpanel.setLayout(new GridLayout(2, 2, 0, 0));
		jcontactpanel.setPreferredSize(new Dimension(200,200));
		
		JLabel titlelabel = new JLabel("JContacts");
		titlelabel.setBackground(Color.LIGHT_GRAY);
		titlelabel.setForeground(Color.BLACK);
		titlelabel.setFont(new Font("Yu Mincho Demibold", Font.BOLD, 54));
		jcontactpanel.add(titlelabel);
		
		JLabel subtitlelabel = new JLabel("A simple possibility for contacting");
		subtitlelabel.setBackground(Color.LIGHT_GRAY);
		subtitlelabel.setForeground(Color.BLACK);
		subtitlelabel.setFont(new Font("Sitka Text", Font.BOLD, 23));
		jcontactpanel.add(subtitlelabel);
		
		JPanel contactlistpanel = new JPanel();
		contactlistpanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		contactlistpanel.setBackground(new Color(255, 255, 255));
		mainpanel.add(contactlistpanel, BorderLayout.WEST);
		contactlistpanel.setPreferredSize(new Dimension(500,100));
		
		
		
		
		Icon exporticon= new ImageIcon("img/upload.png");
		JButton exportbtn = new JButton(exporticon);
		
		exportbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrintWriter print ; 
		            try {
		            	File file = new File("contacts.txt");
			            if(!file.exists())
			            {
						print = new PrintWriter(file);
						for(int i=0;i<clist.size();i++) {
						 print.println("First Name:"+clist.get(i).getFname());
						 print.println("Last Name: "+clist.get(i).getLname());
						 print.println("Email:"+ clist.get(i).getEmail());
						 print.println("Phone Number: "+clist.get(i).getNumber());
						 print.println("URL: "+clist.get(i).getUrl());
						 print.println("Location:"+clist.get(i).getLoc()+"\n");
				
						}
						 print.close();
				            JLabel label = new JLabel("The contacts are exported successfully.");
				            label.setFont(new Font("Arial", java.awt.Font.BOLD, 18));
		                    JOptionPane.showMessageDialog(null, label, "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
						
			            }
		                    else
				            {
				                file.delete();
				                file = new File("contacts.txt");
				                
								print = new PrintWriter(file);
								for(int i=0;i<clist.size();i++) {
								 print.println("First Name:"+clist.get(i).getFname());
								 print.println("Last Name: "+clist.get(i).getLname());
								 print.println("Email:"+ clist.get(i).getEmail());
								 print.println("Phone Number: "+clist.get(i).getNumber());
								 print.println("URL: "+clist.get(i).getUrl());
								 print.println("Location:"+clist.get(i).getLoc()+"\n");
								
								}
								 print.close();
						            JLabel label = new JLabel("The contacts are exported successfully.");
						            label.setFont(new Font("Arial", java.awt.Font.BOLD, 18));
				                    JOptionPane.showMessageDialog(null, label, "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
								
				                
				            
				            }
					} 
		            catch (IOException e1) 
		            {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}    
		        
			}
		});
		
		JLabel empty1 = new JLabel("");
		namepanel.add(empty1);
		
		exportbtn.setBackground(Color.WHITE);
		namepanel.add(exportbtn);
		
		contactlist.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				int contactno= contactlist.getSelectedIndex();
				if(contactno>=0)
				{
					Contact c= clist.get(contactno);
					fnametxtfield.setText(c.getFname());
					lnametxtfield.setText(c.getLname());
					emailtxtfield.setText(c.getEmail());
					phonetxtfield.setText(c.getNumber());
					urltxtfield.setText(c.getUrl());
					loctxtfield.setText(c.getLoc());
				}
						
			}
		});
		contactlistpanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel contactlblpanel = new JPanel();
		contactlblpanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		contactlistpanel.add(contactlblpanel);
		
		JLabel Contactlbltitle = new JLabel("Contacts");
		Contactlbltitle.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 24));
		contactlblpanel.add(Contactlbltitle);
		
		contactlistpanel.add(contactlist);
		
		
		
		
		deletebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = contactlist.getSelectedIndex();
			    if(index >= 0)
			    { 
			        model.removeElementAt(index);
			    }
			    if(index>=0)
				{
					Contact p= clist.get(index);
					fnametxtfield.setText(" ");
					lnametxtfield.setText(" ");
					emailtxtfield.setText(" ");
					phonetxtfield.setText(" ");
					urltxtfield.setText(" ");
					loctxtfield.setText(" ");
				}
			    clist.remove(index);
			}
		});
		
		JLabel empty2 = new JLabel("");
		emailpanel.add(empty2);
		deletebtn.setBackground(Color.WHITE);
		emailpanel.add(deletebtn);
		
		
	
		
		JPanel panel_1 = new JPanel();
		phonepanel.add(panel_1);
		
		JLabel empty3 = new JLabel("");
		phonepanel.add(empty3);
		
		JPanel panel_3 = new JPanel();
		phonepanel.add(panel_3);
		
		
		
		JPanel panel_2 = new JPanel();
		webpanel.add(panel_2);
		
		JLabel empty4 = new JLabel("");
		webpanel.add(empty4);
		
		JPanel panel_4 = new JPanel();
		webpanel.add(panel_4);
		
		
		
		JPanel panel_5 = new JPanel();
		locationpanel.add(panel_5);
		
		JLabel empty5 = new JLabel("");
		locationpanel.add(empty5);
		
		JPanel panel_6 = new JPanel();
		locationpanel.add(panel_6);
		
		
		
	}
	public static void addContact(Contact c)
	{
		clist.add(c);
		updatelist();
	}
	
	String fname;
	String lname;
	String email;
	String number;
	String url;
	String loc;
	
    public MainMenu(String fname, String lname, String email, String number, String url, String loc)
    {
       
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.number = number;
        this.url = url;
        this.loc = loc;
        Contact c=new Contact(fname,lname, email,number, url, loc);
        
        
   
        MainMenu.addContact(c);
     
    }
	
	public static void updatelist() {
		model.removeAllElements();
		for(Contact c: clist) {
			model.addElement(c.getLname()+","+c.getFname());
		}
		
	}
	 
	
	 
}
