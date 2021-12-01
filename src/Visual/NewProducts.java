package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import Logical.ConnectionType;
import Logical.HardDisk;
import Logical.HardDiskType;
import Logical.Microprocessor;
import Logical.Motherboard;
import Logical.Provider;
import Logical.RamCard;
import Logical.RamType;
import Logical.Shop;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import Logical.MotherBoardManufacterer;
import Logical.MotherBoardModel;
import Logical.MicroprocessorModel;
import Logical.MicroprocessorConnectionType;
import Logical.MicroprocessorFrecuency;
import Logical.RamSize;
import Logical.RamManufacterer;
import Logical.HardDiskManufacterer;
import Logical.HardDiskModel;
import Logical.HardDiskSize;
import Logical.MicroprocessorManufacturer;

public class NewProducts extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField Suppliertxt;
	private JTextField SupplierRNCtxt;
	private JTextField PhoneNumbertxt;
	private JTextField ProductPricetxt;
	private JTextField Productcodetxt;
	private JTextField ProductStatetxt;
	private JTextField amountTxt;
	private JTextField paymentMethodtxt;
	private JRadioButton Rambtn;
	private JRadioButton StorageDiskbtn;
	private JRadioButton Microprocessorsbtn;
	private JRadioButton Motherboardbtn;
	private JPanel MotherboardPanel;
	private JPanel MicroprocessorsPanel;
	private JPanel StorageDiskPanel;
	private JPanel RamPanel;

	public NewProducts() {
		setTitle("New Products");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 650, 522);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Supplier:");
		lblNewLabel.setBounds(50, 30, 75, 25);
		contentPanel.add(lblNewLabel);

		Suppliertxt = new JTextField();
		Suppliertxt.setBounds(50, 60, 100, 25);
		contentPanel.add(Suppliertxt);
		Suppliertxt.setColumns(10);

		JLabel lblSupplierRnc = new JLabel("Supplier RNC:");
		lblSupplierRnc.setBounds(200, 30, 100, 25);
		contentPanel.add(lblSupplierRnc);

		SupplierRNCtxt = new JTextField();
		SupplierRNCtxt.setEditable(false);
		SupplierRNCtxt.setColumns(10);
		SupplierRNCtxt.setBounds(200, 60, 100, 25);
		contentPanel.add(SupplierRNCtxt);

		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setBounds(350, 30, 100, 25);
		contentPanel.add(lblPhoneNumber);

		PhoneNumbertxt = new JTextField();
		PhoneNumbertxt.setColumns(10);
		PhoneNumbertxt.setBounds(350, 60, 100, 25);
		contentPanel.add(PhoneNumbertxt);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Add Stock",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(30, 101, 585, 100);
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Product Type:");
		lblNewLabel_1.setBounds(20, 22, 150, 25);
		panel.add(lblNewLabel_1);

		Rambtn = new JRadioButton("Memory RAM");
		Rambtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RamPanel.setVisible(true);
				StorageDiskPanel.setVisible(false);
				MicroprocessorsPanel.setVisible(false);
				MotherboardPanel.setVisible(false);
				Rambtn.setSelected(true);
				StorageDiskbtn.setSelected(false);
				Microprocessorsbtn.setSelected(false);
				Motherboardbtn.setSelected(false);
			}
		});
		Rambtn.setBounds(446, 50, 133, 21);
		panel.add(Rambtn);

		StorageDiskbtn = new JRadioButton("Storage Disk");
		StorageDiskbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RamPanel.setVisible(false);
				StorageDiskPanel.setVisible(true);
				MicroprocessorsPanel.setVisible(false);
				MotherboardPanel.setVisible(false);
				Rambtn.setSelected(false);
				StorageDiskbtn.setSelected(true);
				Microprocessorsbtn.setSelected(false);
				Motherboardbtn.setSelected(false);

			}
		});
		StorageDiskbtn.setBounds(156, 50, 138, 21);
		panel.add(StorageDiskbtn);

		Microprocessorsbtn = new JRadioButton("Microprocessors");
		Microprocessorsbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RamPanel.setVisible(false);
				StorageDiskPanel.setVisible(false);
				MicroprocessorsPanel.setVisible(true);
				MotherboardPanel.setVisible(false);
				Rambtn.setSelected(false);
				StorageDiskbtn.setSelected(false);
				Microprocessorsbtn.setSelected(true);
				Motherboardbtn.setSelected(false);
			}
		});
		Microprocessorsbtn.setBounds(298, 50, 150, 21);
		panel.add(Microprocessorsbtn);

		Motherboardbtn = new JRadioButton("Motherboard");
		Motherboardbtn.setSelected(true);
		Motherboardbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RamPanel.setVisible(false);
				StorageDiskPanel.setVisible(false);
				MicroprocessorsPanel.setVisible(false);
				MotherboardPanel.setVisible(true);
				Rambtn.setSelected(false);
				StorageDiskbtn.setSelected(false);
				Microprocessorsbtn.setSelected(false);
				Motherboardbtn.setSelected(true);
			}
		});
		Motherboardbtn.setBounds(20, 50, 138, 21);
		panel.add(Motherboardbtn);

		ProductPricetxt = new JTextField();
		ProductPricetxt.setColumns(10);
		ProductPricetxt.setBounds(50, 405, 125, 25);
		contentPanel.add(ProductPricetxt);

		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(500, 30, 100, 25);
		contentPanel.add(lblDate);

		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerDateModel());
		spinner.setBounds(500, 60, 100, 25);
		contentPanel.add(spinner);
		
		JLabel lblNewLabel_2_2 = new JLabel("Product Code:");
		lblNewLabel_2_2.setBounds(50, 327, 91, 13);
		contentPanel.add(lblNewLabel_2_2);

		JLabel lblNewLabel_2_1_2 = new JLabel("Current State:");
		lblNewLabel_2_1_2.setBounds(262, 327, 91, 13);
		contentPanel.add(lblNewLabel_2_1_2);

		JLabel lblNewLabel_2_1_2_1 = new JLabel("Order Quantity");
		lblNewLabel_2_1_2_1.setBounds(470, 327, 125, 13);
		contentPanel.add(lblNewLabel_2_1_2_1);

		MotherboardPanel = new JPanel();
		MotherboardPanel.setLayout(null);
		MotherboardPanel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Product Description", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		MotherboardPanel.setBounds(30, 211, 585, 100);
		contentPanel.add(MotherboardPanel);

		JLabel lblNewLabel_5 = new JLabel("Manufacturer:");
		lblNewLabel_5.setBounds(20, 29, 103, 21);
		MotherboardPanel.add(lblNewLabel_5);

		JLabel lblNewLabel_5_1 = new JLabel("Model:");
		lblNewLabel_5_1.setBounds(147, 29, 103, 21);
		MotherboardPanel.add(lblNewLabel_5_1);

		JLabel lblNewLabel_5_2 = new JLabel("Connection type:");
		lblNewLabel_5_2.setBounds(286, 29, 103, 21);
		MotherboardPanel.add(lblNewLabel_5_2);

		JLabel lblNewLabel_5_3 = new JLabel("Ram type:");
		lblNewLabel_5_3.setBounds(424, 29, 103, 21);
		MotherboardPanel.add(lblNewLabel_5_3);

		JComboBox MBManufacturercbx = new JComboBox();
		MBManufacturercbx.setModel(new DefaultComboBoxModel(MotherBoardManufacterer.values()));
		MBManufacturercbx.setBounds(20, 55, 115, 25);
		MotherboardPanel.add(MBManufacturercbx);

		JComboBox MBModelcbx = new JComboBox();
		MBModelcbx.setModel(new DefaultComboBoxModel(MotherBoardModel.values()));
		MBModelcbx.setToolTipText("");
		MBModelcbx.setBounds(147, 55, 115, 25);
		MotherboardPanel.add(MBModelcbx);

		JComboBox MBConectionTypecbx = new JComboBox();
		MBConectionTypecbx.setModel(new DefaultComboBoxModel(ConnectionType.values()));
		MBConectionTypecbx.setBounds(286, 55, 115, 25);
		MotherboardPanel.add(MBConectionTypecbx);

		JComboBox MBRamTypecbx = new JComboBox();
		MBRamTypecbx.setModel(new DefaultComboBoxModel(RamType.values()));
		MBRamTypecbx.setBounds(424, 55, 124, 25);
		MotherboardPanel.add(MBRamTypecbx);

		MicroprocessorsPanel = new JPanel();
		MicroprocessorsPanel.setLayout(null);
		MicroprocessorsPanel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Product Description", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		MicroprocessorsPanel.setBounds(30, 211, 585, 100);
		contentPanel.add(MicroprocessorsPanel);

		JLabel lblNewLabel_6 = new JLabel("Manufacturer:");
		lblNewLabel_6.setBounds(20, 29, 103, 21);
		MicroprocessorsPanel.add(lblNewLabel_6);

		JComboBox PSMakecbx = new JComboBox();
		PSMakecbx.setModel(new DefaultComboBoxModel(MicroprocessorManufacturer.values()));
		PSMakecbx.setBounds(20, 55, 125, 25);
		MicroprocessorsPanel.add(PSMakecbx);

		JLabel lblNewLabel_6_1 = new JLabel("Model:");
		lblNewLabel_6_1.setBounds(170, 29, 103, 21);
		MicroprocessorsPanel.add(lblNewLabel_6_1);

		JLabel lblNewLabel_6_2 = new JLabel("Conection Type:");
		lblNewLabel_6_2.setBounds(320, 29, 103, 21);
		MicroprocessorsPanel.add(lblNewLabel_6_2);
		
		JLabel lblNewLabel_6_3 = new JLabel("Frequency (GHZ):");
		lblNewLabel_6_3.setBounds(470, 29, 103, 21);
		MicroprocessorsPanel.add(lblNewLabel_6_3);

		JComboBox PSModelcbx = new JComboBox();
		PSModelcbx.setModel(new DefaultComboBoxModel(MicroprocessorModel.values()));
		PSModelcbx.setBounds(166, 55, 125, 25);
		MicroprocessorsPanel.add(PSModelcbx);

		JComboBox PSConectionTypecbx = new JComboBox();
		PSConectionTypecbx.setModel(new DefaultComboBoxModel(MicroprocessorConnectionType.values()));
		PSConectionTypecbx.setBounds(320, 55, 125, 25);
		MicroprocessorsPanel.add(PSConectionTypecbx);

		JComboBox PSFrequencycbx = new JComboBox();
		PSFrequencycbx.setModel(new DefaultComboBoxModel(MicroprocessorFrecuency.values()));
		PSFrequencycbx.setBounds(470, 55, 99, 25);
		MicroprocessorsPanel.add(PSFrequencycbx);

		StorageDiskPanel = new JPanel();
		StorageDiskPanel.setLayout(null);
		StorageDiskPanel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Product Description", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		StorageDiskPanel.setBounds(30, 211, 585, 100);
		contentPanel.add(StorageDiskPanel);

		JLabel lblNewLabel_7 = new JLabel("Manufacturer:");
		lblNewLabel_7.setBounds(20, 29, 103, 21);
		StorageDiskPanel.add(lblNewLabel_7);

		JComboBox SDManufacturercbx = new JComboBox();
		SDManufacturercbx.setModel(new DefaultComboBoxModel(HardDiskManufacterer.values()));
		SDManufacturercbx.setBounds(20, 55, 113, 25);
		StorageDiskPanel.add(SDManufacturercbx);

		JLabel lblNewLabel_7_1 = new JLabel("Model:");
		lblNewLabel_7_1.setBounds(170, 29, 103, 21);
		StorageDiskPanel.add(lblNewLabel_7_1);

		JLabel lblNewLabel_7_2 = new JLabel("Memory Size:");
		lblNewLabel_7_2.setBounds(320, 29, 103, 21);
		StorageDiskPanel.add(lblNewLabel_7_2);

		JLabel lblNewLabel_7_3 = new JLabel("Disk Type:");
		lblNewLabel_7_3.setBounds(470, 33, 103, 21);
		StorageDiskPanel.add(lblNewLabel_7_3);

		JComboBox SDModelcbx = new JComboBox();
		SDModelcbx.setModel(new DefaultComboBoxModel(HardDiskModel.values()));
		SDModelcbx.setBounds(165, 55, 108, 25);
		StorageDiskPanel.add(SDModelcbx);

		JComboBox SDMemorySizecbx = new JComboBox();
		SDMemorySizecbx.setModel(new DefaultComboBoxModel(HardDiskSize.values()));
		SDMemorySizecbx.setBounds(320, 55, 106, 25);
		StorageDiskPanel.add(SDMemorySizecbx);

		JComboBox SDTypecbx = new JComboBox();
		SDTypecbx.setModel(new DefaultComboBoxModel(HardDiskType.values()));
		SDTypecbx.setBounds(470, 55, 100, 25);
		StorageDiskPanel.add(SDTypecbx);

		RamPanel = new JPanel();
		RamPanel.setLayout(null);
		RamPanel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Product Description", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		RamPanel.setBounds(30, 211, 585, 100);
		contentPanel.add(RamPanel);

		JLabel lblNewLabel_2 = new JLabel("Manufacturer:");
		lblNewLabel_2.setBounds(20, 29, 103, 21);
		RamPanel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Memory Size:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setBounds(236, 29, 103, 21);
		RamPanel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Memory Type:");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4.setBounds(440, 29, 103, 21);
		RamPanel.add(lblNewLabel_4);

		JComboBox RamMakecbx = new JComboBox();
		RamMakecbx.setModel(new DefaultComboBoxModel(RamManufacterer.values()));
		RamMakecbx.setBounds(20, 55, 125, 25);
		RamPanel.add(RamMakecbx);

		JComboBox RamSizetxt = new JComboBox();
		RamSizetxt.setModel(new DefaultComboBoxModel(RamSize.values()));
		RamSizetxt.setBounds(232, 55, 125, 25);
		RamPanel.add(RamSizetxt);

		JComboBox RamTypecbx = new JComboBox();
		RamTypecbx.setModel(new DefaultComboBoxModel(RamType.values()));
		RamTypecbx.setBounds(440, 55, 125, 25);
		RamPanel.add(RamTypecbx);

		Productcodetxt = new JTextField();
		Productcodetxt.setColumns(10);
		Productcodetxt.setBounds(50, 350, 125, 25);
		contentPanel.add(Productcodetxt);

		ProductStatetxt = new JTextField();
		ProductStatetxt.setColumns(10);
		ProductStatetxt.setBounds(262, 350, 125, 25);
		contentPanel.add(ProductStatetxt);

		JSpinner quantityTxt = new JSpinner();
		quantityTxt.setBounds(470, 350, 125, 25);
		contentPanel.add(quantityTxt);

		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Price:");
		lblNewLabel_2_1_1_1_1.setBounds(50, 385, 91, 13);
		contentPanel.add(lblNewLabel_2_1_1_1_1);
		
		JLabel lblNewLabel_2_1_2_2 = new JLabel("Min Quantity:");
		lblNewLabel_2_1_2_2.setBounds(262, 385, 91, 13);
		contentPanel.add(lblNewLabel_2_1_2_2);

		JLabel lblNewLabel_2_1_2_3 = new JLabel("Payment Method:");
		lblNewLabel_2_1_2_3.setBounds(470, 385, 125, 13);
		contentPanel.add(lblNewLabel_2_1_2_3);

		amountTxt = new JTextField();
		amountTxt.setColumns(10);
		amountTxt.setBounds(262, 405, 125, 25);
		contentPanel.add(amountTxt);

		paymentMethodtxt = new JTextField();
		paymentMethodtxt.setColumns(10);
		paymentMethodtxt.setBounds(470, 405, 125, 25);
		contentPanel.add(paymentMethodtxt);
		setLocationRelativeTo(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						String providerName = Suppliertxt.getText();
						String providerRnc = SupplierRNCtxt.getText();
						String providerAddress = "Nothing";
						String providerPhone = PhoneNumbertxt.getText();
						Provider provider = new Provider(providerName, providerRnc, providerPhone, providerAddress, 0);

						float price = Float.parseFloat(ProductPricetxt.getText());
						Integer quantity = Integer.parseInt(quantityTxt.getValue().toString());
						Integer serial = Integer.parseInt(Productcodetxt.getText());
						Integer minimun = 1;

						if (Motherboardbtn.isSelected()) {
							String brand = (String) MBManufacturercbx.getSelectedItem();
							String model = (String) MBModelcbx.getSelectedItem();
							ConnectionType connectionType = (ConnectionType) MBConectionTypecbx.getSelectedItem();
							RamType ramType = (RamType) MBRamTypecbx.getSelectedItem();
							Motherboard motherboard = new Motherboard(price, quantity, serial, minimun, provider, brand,
									model, connectionType, ramType, new ArrayList<HardDiskType>());
						} else if (StorageDiskbtn.isSelected()) {
							String brand = (String) SDManufacturercbx.getSelectedItem();
							String model = (String) SDModelcbx.getSelectedItem();
							HardDiskSize capacity = (HardDiskSize) SDMemorySizecbx.getSelectedItem();
							HardDiskType connectionType = (HardDiskType) SDTypecbx.getSelectedItem();
							HardDisk hardDisk = new HardDisk(price, quantity, serial, minimun, provider, brand, model,
									capacity, connectionType);
						} else if (Microprocessorsbtn.isSelected()) {
							String brand = (String) PSMakecbx.getSelectedItem();
							String model = (String) PSModelcbx.getSelectedItem();
							MicroprocessorFrecuency speed = (MicroprocessorFrecuency) SDMemorySizecbx.getSelectedItem();
							MicroprocessorConnectionType type = (MicroprocessorConnectionType) PSConectionTypecbx
									.getSelectedItem();
							Microprocessor microprocessor = new Microprocessor(price, quantity, serial, minimun,
									provider, brand, model, type, speed);
						} else if (Rambtn.isSelected()) {
							String brand = (String) RamMakecbx.getSelectedItem();
							RamSize capacity = (RamSize) RamSizetxt.getSelectedItem();
							RamType type = (RamType) RamTypecbx.getSelectedItem();
							RamCard ram = new RamCard(price, quantity, serial, minimun, provider, brand, capacity,
									type);
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
