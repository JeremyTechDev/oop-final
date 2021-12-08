package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import Logical.Client;
import Logical.Shop;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewCustomer extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField Nametxt;
	private JTextField IDtxt;
	private JTextField Addresstxt;
	private JTextField Phonetxt;
	private JTextField CreditLimittxt;

	
	public NewCustomer() {
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 504, 316);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Customer Name:");
		lblNewLabel.setBounds(20, 30, 105, 22);
		contentPanel.add(lblNewLabel);
		
		JLabel lblCustomerId = new JLabel("Customer ID:");
		lblCustomerId.setBounds(264, 30, 105, 22);
		contentPanel.add(lblCustomerId);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(20, 90, 105, 22);
		contentPanel.add(lblAddress);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setBounds(20, 150, 105, 22);
		contentPanel.add(lblPhoneNumber);
		
		JLabel lblCreditLimit = new JLabel("Credit Limit:");
		lblCreditLimit.setBounds(264, 155, 105, 22);
		contentPanel.add(lblCreditLimit);
		
		Nametxt = new JTextField();
		Nametxt.setBounds(20, 60, 200, 25);
		contentPanel.add(Nametxt);
		Nametxt.setColumns(10);
		
		IDtxt = new JTextField();
		IDtxt.setColumns(10);
		IDtxt.setBounds(264, 60, 200, 25);
		contentPanel.add(IDtxt);
		
		Addresstxt = new JTextField();
		Addresstxt.setColumns(10);
		Addresstxt.setBounds(20, 120, 444, 25);
		contentPanel.add(Addresstxt);
		
		Phonetxt = new JTextField();
		Phonetxt.setColumns(10);
		Phonetxt.setBounds(20, 180, 160, 25);
		contentPanel.add(Phonetxt);
		
		CreditLimittxt = new JTextField();
		CreditLimittxt.setColumns(10);
		CreditLimittxt.setBounds(264, 180, 160, 25);
		contentPanel.add(CreditLimittxt);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			//Add customer function Visual
			{
				JButton SaveCustomerbtn = new JButton("Save Customer");
				SaveCustomerbtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						boolean confirmed = confirmfields();
						if(confirmed) {
							Client client = new Client(IDtxt.getText(), Nametxt.getText(),Addresstxt.getText(), Phonetxt.getText(),CreditLimittxt.getText());
							Shop.getInstance().AddCustomer(client);
							JOptionPane.showMessageDialog(null, "Customer Added Successfully");
							CleanFields();
					}else {
						JOptionPane.showMessageDialog(null, "Please fill all the fields", "ERROR", JOptionPane.OK_OPTION);
					}
						//Missing Sales Code
					}
				});
				SaveCustomerbtn.setActionCommand("OK");
				buttonPane.add(SaveCustomerbtn);
				getRootPane().setDefaultButton(SaveCustomerbtn);
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
	//Method to confirm fields are correctly completed
	public boolean confirmfields() {
		boolean aux = false;
		if( !(Nametxt.getText().equalsIgnoreCase("")) && !(IDtxt.getText().equalsIgnoreCase("")) && !(Addresstxt.getText().equalsIgnoreCase("")) && !(Phonetxt.getText().equalsIgnoreCase("")) && !(CreditLimittxt.getText().equalsIgnoreCase(""))){
			aux = true;
		}
		return aux;
	}
	
	public void CleanFields() {
		//pending to add sales code
		//txtCodigoCliente.setText("C"+Biblioteca.getInstance().getGeneradorCodigoCliente());
		Nametxt.setText("");
		IDtxt.setText("");
		Addresstxt.setText("");
		Phonetxt.setText("");
		CreditLimittxt.setText("");
		
	}
	
}
