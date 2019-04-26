import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Janela extends JFrame {

	JButton btn_ip1,btn_ip2,btn_ip3,btn_ip4;
	JLabel lb_ipManual ;
	JTextField txf_ipManual ;
	JButton btn_apply ;
	public Janela() {
		super("Mudar IP");
		init();
		setSize(new Dimension(400,400));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	private void init(){
		//painel principal
		Container panel = this.getContentPane();
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		
		//JLabel e botão para setar ip manual
		JPanel setIp = new JPanel();
		setIp.setLayout(new FlowLayout());
		lb_ipManual = new JLabel("IP manual: ");
		txf_ipManual = new JTextField(15);
		btn_apply = new JButton("aplicar");
		setIp.add(lb_ipManual);
		setIp.add(txf_ipManual);
		setIp.add(btn_apply);
		
		//Botões predefinidos com ip
		JPanel panelBtn = new JPanel();
		panelBtn.setLayout(new GridLayout(2,2));
		
		btn_ip1 = new JButton("192.168.0.10");
		btn_ip2 = new JButton("192.168.1.10");
		btn_ip3 = new JButton("192.168.2.10");
		btn_ip4 = new JButton("192.168.254.10");
		panelBtn.add(btn_ip1);
		panelBtn.add(btn_ip2);
		panelBtn.add(btn_ip3);
		panelBtn.add(btn_ip4);
		
		panel.add(setIp);
		panel.add(panelBtn);
		
		processamentoBotoes();
	}
	

	private void processamentoBotoes() {
		btn_apply.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String texto = txf_ipManual.getText();
				texto = texto.trim();
				texto = texto.replace(" ", "");
				System.out.println(texto);
			}
			
		});
		
	}

	public static void main(String args[]) {
		Janela jl = new Janela();
	}
}
