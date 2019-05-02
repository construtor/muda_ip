import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Janela extends JFrame {

	JButton btn_ip1,btn_ip2,btn_ip3,btn_ip4,btn_dhcp;
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
		panelBtn.setLayout(new GridLayout(3,2));
		
		btn_ip1 = new JButton("192.168.0.10");
		btn_ip2 = new JButton("192.168.1.10");
		btn_ip3 = new JButton("192.168.2.10");
		btn_ip4 = new JButton("192.168.254.10");
		btn_dhcp = new JButton("DHCP");
		panelBtn.add(btn_ip1);
		panelBtn.add(btn_ip2);
		panelBtn.add(btn_ip3);
		panelBtn.add(btn_ip4);
		panelBtn.add(btn_dhcp);
		
		panel.add(setIp);
		panel.add(panelBtn);
		
		//ip Manual
		processamentoBotoes(btn_apply, txf_ipManual);
		//ip estatico 1
		processamentoBotoes(btn_ip1, btn_ip1);
		//ip estatico 2
		processamentoBotoes(btn_ip2, btn_ip2);
		//ip estatico 3
		processamentoBotoes(btn_ip3, btn_ip3);
		//ip estatico 4
		processamentoBotoes(btn_ip4, btn_ip4);
	}
	

	private void processamentoBotoes(JButton acionador, Component jTexto) {
		
		
		
		
		
		
		acionador.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String texto = "";
				if(jTexto instanceof JTextField) {
					texto = ((JTextField) jTexto).getText();
				}else if (jTexto instanceof JButton) {
					texto = ((JButton)jTexto).getText();
				}
				texto = texto.trim();
				texto = texto.replace(" ", "");
				String fonte = texto;
				String queroIsso = "^[1-2]{0,1}[0-9]{0,1}[0-9]{1}\\.[1-2]{0,1}[0-9]{0,1}[0-9]{1}\\.[1-2]{0,1}[0-9]{0,1}[0-9]{1}\\.[1-2]{0,1}[0-9]{0,1}[0-9]{1}$";
				Pattern pattern = Pattern.compile(queroIsso);
				Matcher match = pattern.matcher(fonte);
				
				if(match.find())
					System.out.println(match.group());
				else
					System.out.println("não deu!");
				
				//Runtime.getRuntime().exec("netsh interface ip set address name=\"Conexão Local\" static "+texto+" 255.255.255.0 192.168.0.1");
			}
			
		});
		
	}
	

	public static void main(String args[]) {
		Janela jl = new Janela();
	}
}
