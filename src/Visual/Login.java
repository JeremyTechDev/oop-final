package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import Logical.Shop;
import Logical.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Login extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField usernameTxt;
	private JPasswordField passwordTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				try {
					// Load Shop instance from existing file
					FileInputStream shopFile = new FileInputStream(Shop.shopFilename);
					ObjectInputStream read = new ObjectInputStream(shopFile);
					Shop shopInstance = (Shop) read.readObject();
					Shop.setInstance(shopInstance);
					shopFile.close();
					read.close();
				} catch (FileNotFoundException err) {
					try {
						// No Shop instance saved, create new file
						FileOutputStream shop = new FileOutputStream(Shop.shopFilename);
						ObjectOutputStream write = new ObjectOutputStream(shop);

						// Add default admin
						User defaultAdmin = new User("0000", "Admin", "-", "-", "Admin", "123", true);
						Shop.getInstance().addUser(defaultAdmin);

						write.writeObject(Shop.getInstance());
						shop.close();
						write.close();
					} catch (FileNotFoundException err1) {
						// do nothing
					} catch (IOException err1) {
						// do nothing
					}
				} catch (IOException err) {
					// do nothing
				} catch (ClassNotFoundException err) {
					// do nothing
				}

				// Default view
				try {
					Login dialog = new Login();
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});

	}

	/**
	 * Create the dialog.
	 */
	public Login() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Login");
		setResizable(false);
		setBounds(100, 100, 246, 260);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(39, 46, 173, 152);
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setBounds(6, 6, 88, 16);
		panel.add(lblNewLabel);

		usernameTxt = new JTextField();
		usernameTxt.setBounds(6, 23, 161, 26);
		panel.add(usernameTxt);
		usernameTxt.setColumns(10);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(6, 61, 88, 16);
		panel.add(lblPassword);

		passwordTxt = new JPasswordField();
		passwordTxt.setBounds(6, 78, 161, 26);
		panel.add(passwordTxt);

		JButton loginBtn = new JButton("LOGIN");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String username = usernameTxt.getText();
				String password = String.valueOf(passwordTxt.getPassword());
				if (Shop.getInstance().handleLogin(username, password)) {
					dispose();
					Principal main = new Principal();
					main.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Wrong username or password", "Login failed",
							JOptionPane.ERROR_MESSAGE);
					clean();
				}
			}
		});
		loginBtn.setBounds(29, 112, 117, 29);
		panel.add(loginBtn);

		JLabel lblNewLabel_1 = new JLabel("LOGIN");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		lblNewLabel_1.setBounds(97, 28, 61, 16);
		contentPanel.add(lblNewLabel_1);
	}

	private void clean() {
		usernameTxt.setText("");
		passwordTxt.setText("");
	}
}
