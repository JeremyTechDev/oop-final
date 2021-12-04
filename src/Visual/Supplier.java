package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import Logical.Client;
import Logical.Provider;
import Logical.Shop;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Supplier extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField SupliNametxt;
	private JTextField SupliRNCtxt;
	private JTextField SupliPhonetxt;
	private JTextField SupliAddresstxt;

	public Supplier() {
		setBounds(100, 100, 461, 316);
		setResizable(false);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setBounds(30, 30, 100, 21);
		contentPanel.add(lblNewLabel);
		
		SupliNametxt = new JTextField();
		SupliNametxt.setBounds(30, 60, 175, 25);
		contentPanel.add(SupliNametxt);
		SupliNametxt.setColumns(10);
		
		JLabel lblRnc = new JLabel("RNC:");
		lblRnc.setBounds(240, 30, 100, 21);
		contentPanel.add(lblRnc);
		
		SupliRNCtxt = new JTextField();
		SupliRNCtxt.setColumns(10);
		SupliRNCtxt.setBounds(240, 60, 175, 25);
		contentPanel.add(SupliRNCtxt);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setBounds(30, 90, 100, 21);
		contentPanel.add(lblPhoneNumber);
		
		SupliPhonetxt = new JTextField();
		SupliPhonetxt.setColumns(10);
		SupliPhonetxt.setBounds(30, 120, 175, 25);
		contentPanel.add(SupliPhonetxt);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(30, 150, 100, 21);
		contentPanel.add(lblAddress);
		
		SupliAddresstxt = new JTextField();
		SupliAddresstxt.setColumns(10);
		SupliAddresstxt.setBounds(30, 180, 385, 25);
		contentPanel.add(SupliAddresstxt);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton SaveSupplierBtn = new JButton("Save Supplier");
				SaveSupplierBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						boolean confirmed = confirmfields();
						if(confirmed) {
							Provider provider = new Provider(SupliNametxt.getText(), SupliRNCtxt.getText(), SupliPhonetxt.getText(),SupliAddresstxt.getText());
							Shop.getInstance().AddSuplier(provider);
							JOptionPane.showMessageDialog(null, "Supplier Added Successfully");
							CleanFields();

					}else {
						JOptionPane.showMessageDialog(null, "Please fill all the fields", "ERROR", JOptionPane.OK_OPTION);
					}
					}
				});
				SaveSupplierBtn.setActionCommand("OK");
				buttonPane.add(SaveSupplierBtn);
				getRootPane().setDefaultButton(SaveSupplierBtn);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	public boolean confirmfields() {
		boolean aux = false;
		if( !(SupliNametxt.getText().equalsIgnoreCase("")) && !(SupliRNCtxt.getText().equalsIgnoreCase("")) && !(SupliPhonetxt.getText().equalsIgnoreCase("")) && !(SupliAddresstxt.getText().equalsIgnoreCase(""))){
			aux = true;
		}
		return aux;
	}
	
	public void CleanFields() {
		//pending to add sales code
		//txtCodigoCliente.setText("C"+Biblioteca.getInstance().getGeneradorCodigoCliente());
		SupliNametxt.setText("");
		SupliRNCtxt.setText("");
		SupliPhonetxt.setText("");
		SupliAddresstxt.setText("");
		
	}	
	
}
