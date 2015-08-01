package ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import service.MovieService;
import service.MovieServiceImpl;
import service.UserService;
import service.UserServiceImpl;
import vo.MovieInfoVo;

public class PayMentScreen extends JFrame implements ActionListener {

	JLabel movName, movtim, moSeat, screenNom;
	JButton pay, cancel;
	JLabel LmovName,Lmovtim,LmoSeat,LscreenNom;
	Font f;
	
	int movieNo;
	String movieName;
	int index;
	
	ArrayList<String> al;
	
	String[] sList;
	
	MovieInfoVo movieInfoVo = null;
	
	PayMentScreen(ArrayList<String> al, int movieNo, String movieName, int index) {
		this.al = al;
		this.movieNo = movieNo;
		this.movieName = movieName;
		this.index = index;
		setBounds(100, 100, 500, 700);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		movName = new JLabel(movieName);
		movtim = new JLabel();
		moSeat = new JLabel();
		screenNom = new JLabel();
		pay = new JButton("결제하기");
		cancel = new JButton("취소");
		f = new Font("고딕", Font.BOLD, 15);
		
		movName.setFont(f);
		movtim.setFont(f);
		moSeat.setFont(f);
		screenNom.setFont(f);

		
		add(movName);
		add(movtim);
		add(moSeat);
		add(screenNom);
		add(pay);
		add(cancel);

		movName.setBounds(90, 50, 100, 100);
		movtim.setBounds(90, 160, 100, 100);
		moSeat.setBounds(90, 270, 100, 100);
		screenNom.setBounds(90, 380, 100, 100);
		pay.setBounds(80, 550, 150, 50);
		cancel.setBounds(260, 550, 150, 50);
		
		pay.addActionListener(this);
		cancel.addActionListener(this);
		
		sList = new String[al.size()];
		MovieInfo();

		setVisible(true);
	}



	private void MovieInfo() {
		try {
			MovieService msv = new MovieServiceImpl();
			movieInfoVo = msv.MovieInfo(movieNo);
			
			if (movieInfoVo == null) {
				
			} else {
				movtim.setText(movieInfoVo.getMovie_time()+"");
				
				for (int i = 0; i < al.size(); i++) {
					sList[i] = al.get(i);
					System.out.println(sList[i]);
				}
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == cancel) {
			int result = JOptionPane.showConfirmDialog(this, "취소하시겠습니까?", "영화예매", JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.YES_OPTION) {
				System.exit(0);
			} else {

			}
		} else if (obj == pay) {
			int insertCount = 0;
			try {
				MovieService msv = new MovieServiceImpl();
				insertCount = msv.MoviePay(movieNo, sList);
				
				if (insertCount > 0) {
					dispose();
					new Finish("");
				} else {
					JOptionPane.showMessageDialog(null, "결제실패");
				}
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}
}
