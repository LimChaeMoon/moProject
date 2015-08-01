package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import service.MovieService;
import service.MovieServiceImpl;
import vo.MovieInfoVo;

public class Choice extends JFrame implements ActionListener {
	String id;
	JLabel jlbName, jlbInfo;
	JButton jbtnMovie1, jbtnMovie2, jbtnMovie3, jbtnMovie4, jbtnResCon, jbtnExit;

	Choice() {

		setBounds(0, 0, 1300, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		jlbName = new JLabel("회원이름");
		jlbInfo = new JLabel("정보");
		jbtnMovie1 = new JButton("미션임파서블 로그네이션");
		jbtnMovie2 = new JButton("인사이드아웃");
		jbtnMovie3 = new JButton("암살");
		jbtnMovie4 = new JButton("미니언즈");
		jbtnResCon = new JButton("예약취소");
		jbtnExit = new JButton("종료");

		setLayout(null);
		jlbName.setBounds(100, 50, 100, 100);
		jlbInfo.setBounds(250, 50, 250, 100);
		jbtnMovie1.setBounds(50, 150, 250, 350);
		jbtnMovie2.setBounds(350, 150, 250, 350);
		jbtnMovie3.setBounds(650, 150, 250, 350);
		jbtnMovie4.setBounds(950, 150, 250, 350);
		jbtnResCon.setBounds(100, 600, 700, 50);
		jbtnExit.setBounds(900, 600, 200, 50);

		add(jlbName);
		add(jlbInfo);
		add(jbtnMovie1);
		add(jbtnMovie2);
		add(jbtnMovie3);
		add(jbtnMovie4);
		add(jbtnResCon);
		add(jbtnExit);

		jbtnMovie1.addActionListener(this);
		jbtnMovie2.addActionListener(this);
		jbtnMovie3.addActionListener(this);
		jbtnMovie4.addActionListener(this);
		jbtnResCon.addActionListener(this);
		jbtnExit.addActionListener(this);

		setVisible(true);
	}

	public static void main(String[] args) {
		new Choice();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == jbtnMovie1) {
			new MovieList(jbtnMovie1.getText());
			dispose();
		} else if (obj == jbtnMovie2) {
			new MovieList(jbtnMovie2.getText());
			dispose();
		} else if (obj == jbtnMovie3) {
			new MovieList(jbtnMovie3.getText());
			dispose();
		} else if (obj == jbtnMovie4) {
			new MovieList(jbtnMovie4.getText());
			dispose();
		} else if (obj == jbtnExit) {
			System.exit(0);
		} else if (obj == jbtnResCon) {

		}

	}
}
