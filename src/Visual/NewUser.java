package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

import Logical.Shop;
import Logical.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class NewUser extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField nameTxt;
	private JTextField phoneTxt;
	private JTextField usernameTxt;
	private JPasswordField passwordTxt;
	private JLabel idTxt;
	private JCheckBox adminCheck;
	private JTextField addressTxt;


	public NewUser() {
		setResizable(false);
		setTitle("New User");
		setBounds(100, 100, 525, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setBounds(310, 11, 18, 16);
		contentPanel.add(lblNewLabel);

		idTxt = new JLabel(String.valueOf(Shop.getInstance().getLastUserId()));
		idTxt.setBounds(329, 11, 61, 16);
		contentPanel.add(idTxt);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Personal Data:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(6, 28, 499, 132);
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setBounds(45, 18, 61, 16);
		panel.add(lblNewLabel_1);

		nameTxt = new JTextField();
		nameTxt.setBounds(45, 38, 179, 26);
		panel.add(nameTxt);
		nameTxt.setColumns(10);

		phoneTxt = new JTextField();
		phoneTxt.setBounds(258, 38, 179, 26);
		phoneTxt.setColumns(10);
		panel.add(phoneTxt);

		JLabel lblNewLabel_1_1 = new JLabel("Phone:");
		lblNewLabel_1_1.setBounds(258, 18, 61, 16);
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_2 = new JLabel("Address:");
		lblNewLabel_2.setBounds(45, 64, 61, 16);
		panel.add(lblNewLabel_2);
		
		addressTxt = new JTextField();
		addressTxt.setBounds(45, 90, 392, 26);
		panel.add(addressTxt);
		addressTxt.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Login Data:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(6, 159, 499, 132);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("Username:");
		lblNewLabel_3.setBounds(45, 34, 82, 16);
		panel_1.add(lblNewLabel_3);

		usernameTxt = new JTextField();
		usernameTxt.setBounds(45, 60, 185, 26);
		panel_1.add(usernameTxt);
		usernameTxt.setColumns(10);

		passwordTxt = new JPasswordField();
		passwordTxt.setBounds(258, 60, 186, 26);
		panel_1.add(passwordTxt);

		JLabel lblNewLabel_4 = new JLabel("Password:");
		lblNewLabel_4.setBounds(258, 34, 89, 16);
		panel_1.add(lblNewLabel_4);

		adminCheck = new JCheckBox("Grant ADMIN permissions");
		adminCheck.setBounds(310, 297, 195, 23);
		contentPanel.add(adminCheck);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Save");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							String id = String.valueOf(Shop.getInstance().getLastUserId());
							String name = nameTxt.getText();
							String phone = phoneTxt.getText();
							String address = addressTxt.getText();
							String username = usernameTxt.getText();
							String password = String.valueOf(passwordTxt.getPassword());
							boolean isAdmin = adminCheck.isSelected();

							User user = new User(id, name, address, phone, username, password, isAdmin);

							boolean isSaved = Shop.getInstance().addUser(user);

							if (isSaved) {
								JOptionPane.showMessageDialog(null, "New user registered", "Info",
										JOptionPane.INFORMATION_MESSAGE);
								cleanFields();
							} else {
								JOptionPane.showMessageDialog(null, "Could not create the new user", "Error",
										JOptionPane.ERROR_MESSAGE);
							}
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "Could not create the new user", "Something went wrong",
									JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Close");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	private void cleanFields() {
		nameTxt.setText("");
		phoneTxt.setText("");
		addressTxt.setText("");
		usernameTxt.setText("");
		passwordTxt.setText("");
		adminCheck.setSelected(false);
	}
}
