import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Main extends JFrame {
	JButton IVbutton;
	JButton TSbutton;
	JButton YFbutton;
	static Main frame;

	public static void main(String[] args){

		Main frame = new Main("終値ゲッター！");
		frame.setVisible(true);

	}

	Main(String title) {
	    setTitle(title);
	    setBounds(100, 100, 600, 250);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    JPanel p = new JPanel();
	    p.setLayout(null);


	    JTextArea area = new JTextArea("エクスポートするファイル形式を選択", 2, 60);
	    area.setBounds(10, 100, 600, 30);
	    area.setOpaque(false);

//	    JTextField a = new JTextField("tesuto",10);
//	    a.setBounds(10, 80, 100, 30);
//	    p.add(a);

	    IVbutton = new JButton("Investing");
	    IVbutton.setBounds(10, 130, 120, 30);

	    TSbutton = new JButton("tradeStation");
	    TSbutton.setBounds(140, 130, 120, 30);

	    YFbutton = new JButton("yahooFinance");
	    YFbutton.setBounds(270, 130, 120, 30);

	    p.add(area);
	    p.add(IVbutton);
	    p.add(TSbutton);
	    p.add(YFbutton);

	    RateFileController controller = new RateFileController();

	    IVbutton.addActionListener(
	      new ActionListener(){
	        public void actionPerformed(ActionEvent event){
				try {
					controller.Controller("investing");
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
	        }
	      }
	    );

	    TSbutton.addActionListener(
	  	      new ActionListener(){
	  	        public void actionPerformed(ActionEvent event){
	  				try {
	  					controller.Controller("tradeStation");
	  				} catch (FileNotFoundException e) {
	  					e.printStackTrace();
	  				} catch (IOException e) {
	  					e.printStackTrace();
	  				}
	  	        }
	  	      }
	  	    );

	    YFbutton.addActionListener(
		  	      new ActionListener(){
		  	        public void actionPerformed(ActionEvent event){
		  				try {
		  					controller.Controller("yahooFinance");
		  				} catch (FileNotFoundException e) {
		  					e.printStackTrace();
		  				} catch (IOException e) {
		  					e.printStackTrace();
		  				}
		  	        }
		  	      }
		  	    );

	    Container contentPane = getContentPane();
	    contentPane.add(p, BorderLayout.CENTER);
	  }
}
