package Visual;

import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logical.Shop;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;
	private Dimension dim;
	private boolean isAdminUser = Shop.getInstance().getLoggedUser().getIsAdmin();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Principal() {

		// Save Shop Instance before closing
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				try {
					FileOutputStream shopFile = new FileOutputStream(Shop.shopFilename);
					ObjectOutputStream write = new ObjectOutputStream(shopFile);
					write.writeObject(Shop.getInstance());
					write.close();
					shopFile.close();
				} catch (FileNotFoundException err) {
					err.printStackTrace();
				} catch (IOException err) {
					err.printStackTrace();
				}
			}
		});

		dim = getToolkit().getScreenSize();
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 637, 394);
		setSize(dim.width, dim.height - 45);
		setLocationRelativeTo(null);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Sale");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("New Sale");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sale sale = new Sale();
				sale.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);

		JMenu mnNewMenu_1 = new JMenu("Products");
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Add New Products");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewProducts newpro = new NewProducts();
				newpro.setVisible(true);
			}
		});
		mnNewMenu_1.setEnabled(isAdminUser);
		mnNewMenu_1.add(mntmNewMenuItem_3);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Products in stock");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StockProducts product = new StockProducts();
				product.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_1);

		JMenu mnNewMenu_3 = new JMenu("Customers");
		menuBar.add(mnNewMenu_3);

		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Customer List");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerList custlist = new CustomerList();
				custlist.setVisible(true);
			}
		});

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("New Customer");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewCustomer newcustomer = new NewCustomer();
				newcustomer.setVisible(true);
			}
		});
		mntmNewMenuItem_2.setEnabled(isAdminUser);
		mnNewMenu_3.add(mntmNewMenuItem_2);
		mnNewMenu_3.add(mntmNewMenuItem_6);

		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Quotations");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Quotations quote = new Quotations();
				quote.setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_7);
		mntmNewMenuItem_7.setEnabled(isAdminUser);

		JMenu mnNewMenu_2 = new JMenu("Invoices");
		menuBar.add(mnNewMenu_2);

		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Sale History");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaleHistory salehist = new SaleHistory();
				salehist.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_4);

		JMenu mnNewMenu_4 = new JMenu("Supplier");
		menuBar.add(mnNewMenu_4);

		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Suppliers");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MySuppliers mysupli = new MySuppliers();
				mysupli.setVisible(true);
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_9);

		JMenu mnNewMenu_6 = new JMenu("Admin");
		mnNewMenu_6.setEnabled(isAdminUser);
		menuBar.add(mnNewMenu_6);

		JMenuItem mntmNewMenuItem_8 = new JMenuItem("New User");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewUser newUser = new NewUser();
				newUser.setVisible(true);
			}
		});
		mntmNewMenuItem_8.setEnabled(isAdminUser);
		mnNewMenu_6.add(mntmNewMenuItem_8);

		JMenu mnNewMenu_5 = new JMenu("Backup");
		menuBar.add(mnNewMenu_5);
		mnNewMenu_5.setEnabled(isAdminUser);

		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Backup File");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Socket socket = null;
				File shopFile = null;
				InputStream in = null;
				OutputStream out = null;

				try {
					socket = new Socket("127.0.0.1", 7777);
					shopFile = new File(Shop.shopFilename);
					in = new FileInputStream(shopFile);
					out = socket.getOutputStream();
				} catch (FileNotFoundException err) {
					JOptionPane.showMessageDialog(null, "No shop data to backup", "Backup failed",
							JOptionPane.ERROR_MESSAGE);
				} catch (UnknownHostException uhe) {
					JOptionPane.showMessageDialog(null, "Could not create a backup file", "Backup failed",
							JOptionPane.ERROR_MESSAGE);
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}

				try {
					int count;
					byte[] bytes = new byte[8192];
					while ((count = in.read(bytes)) > 0) {
						out.write(bytes, 0, count);
					}

					out.close();
					in.close();
					socket.close();

					JOptionPane.showMessageDialog(null, "Backup file created in the backups folder", "Backup Done!",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		mnNewMenu_5.add(mntmNewMenuItem_5);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));

		setContentPane(contentPane);
		setLocationRelativeTo(null);
	}

}