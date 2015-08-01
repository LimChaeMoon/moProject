package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import service.MovieService;
import service.MovieServiceImpl;
import vo.MovieBooKingVo;
import vo.MovieInfoVo;

public class ActorSeat extends JFrame {

	JButton btn37, btn38;

	JLabel as, sc;
	
	JCheckBox[] jcb;

	List<MovieBooKingVo> booKingList;
	ArrayList<String> al = new ArrayList();

	MovieBooKingVo movieBooKingVo;

	int movieNo;
	String movieName;
	int index;
	
	int chickBoxCount;
	

	ActorSeat(int movieNo, String movieName, int index) {
		this.movieNo = movieNo;
		this.movieName = movieName;
		this.index = index;
		MovieSelectList(this.movieNo);
		System.out.println(index+"명");

		// System.out.println(booKingList.size());

		setBounds(0, 0, 800, 500);

		setLayout(null);

		sc = new JLabel(movieName+" SCREEN");
		as = new JLabel("좌석을 선택해주세요");

		btn37 = new JButton("Click");
		btn38 = new JButton("EXIT");
		
		jcb = new JCheckBox[37];
		jcb[0] = new JCheckBox();
		int y = 20;
		for (int i = 1; i < jcb.length; i++) {
			jcb[i] = new JCheckBox();
			jcb[i].setName(i+"");
			jcb[i].setBounds(30, y, 50, 20);
			y+=20;
			add(jcb[i]);
		}
		
		
		

		if (booKingList != null) {
			for (int i = 0; i < booKingList.size(); i++) {
				// System.out.println(booKingList.get(i));
				movieBooKingVo = (MovieBooKingVo) booKingList.get(i);
				int a = movieBooKingVo.getRes_seat_num();
				jcb[a].setEnabled(false);
				System.out.println(a);
				
			}
		}
		
		as.setBounds(50, 400, 120, 30);
		sc.setBounds(200, 10, 100, 10);

		
		jcb[1].setBounds(30, 40, 30, 30);
		jcb[2].setBounds(60, 40, 30, 30);
		jcb[3].setBounds(90, 40, 30, 30);
		jcb[4].setBounds(180, 40, 30, 30);
		jcb[5].setBounds(210, 40, 30, 30);
		jcb[6].setBounds(240, 40, 30, 30);
		jcb[7].setBounds(270, 40, 30, 30);
		jcb[8].setBounds(360, 40, 30, 30);
		jcb[9].setBounds(390, 40, 30, 30);
		jcb[10].setBounds(420, 40, 30, 30);
		jcb[11].setBounds(30, 120, 30, 30);
		jcb[12].setBounds(60, 120, 30, 30);
		jcb[13].setBounds(90, 120, 30, 30);
		jcb[14].setBounds(180, 120, 30, 30);
		jcb[15].setBounds(210, 120, 30, 30);
		jcb[16].setBounds(240, 120, 30, 30);
		jcb[17].setBounds(270, 120, 30, 30);
		jcb[18].setBounds(360, 120, 30, 30);
		jcb[19].setBounds(390, 120, 30, 30);
		jcb[20].setBounds(420, 120, 30, 30);
		jcb[21].setBounds(40, 200, 30, 30);
		jcb[22].setBounds(70, 200, 30, 30);
		jcb[23].setBounds(180, 200, 30, 30);
		jcb[24].setBounds(210, 200, 30, 30);
		jcb[25].setBounds(240, 200, 30, 30);
		jcb[26].setBounds(270, 200, 30, 30);
		jcb[27].setBounds(375, 200, 30, 30);
		jcb[28].setBounds(405, 200, 30, 30);
		jcb[29].setBounds(40, 280, 30, 30);
		jcb[30].setBounds(70, 280, 30, 30);
		jcb[31].setBounds(180, 280, 30, 30);
		jcb[32].setBounds(210, 280, 30, 30);
		jcb[33].setBounds(240, 280, 30, 30);
		jcb[34].setBounds(270, 280, 30, 30);
		jcb[35].setBounds(375, 280, 30, 30);
		jcb[36].setBounds(405, 280, 30, 30);
		
		btn37.setBounds(250, 400, 100, 30);
		btn38.setBounds(350, 400, 100, 30);

		add(as);
		add(sc);


		add(btn37);
		add(btn38);

		setVisible(true);
		
		

		btn37.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				int result = JOptionPane.showConfirmDialog(null, "가입을 취소 하시겠습니까?", "alert", JOptionPane.YES_NO_OPTION);

				//OK 할 경우
				if (result == JOptionPane.YES_OPTION) {
					for (int i = 1; i < jcb.length; i++) {
						if (jcb[i].isSelected()) {
							chickBoxCount++;
						}
					}
					
					if (chickBoxCount > index) {
						System.out.println("인원 안맞음");
						chickBoxCount = 0;
					} else if (chickBoxCount < index) {
						System.out.println("인원 안맞음");
						chickBoxCount = 0;
					} else if (chickBoxCount == index) {
						for (int i = 1; i < jcb.length; i++) {
							if (jcb[i].isSelected()) {
								al.add(jcb[i].getName());
							}
						}
						dispose();
						// 로그인 프레임 실행
						new PayMentScreen(al, movieNo, movieName, index);
					}

					// 취소를 NO 할 경우
				} else if (result == JOptionPane.NO_OPTION) {
					// 따로 처리 할것이 없기 때문에 그냥 가만히 냅둔다
				}

				
			
				
			}

		});

	}

	private void MovieSelectList(int movieNo) {
		try {

			MovieService msv = new MovieServiceImpl();
			booKingList = msv.selectSeatNum(movieNo);

			if (booKingList == null) {
				System.out.println("예약자 아무도 없네");
			}

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			// e1.printStackTrace();

		}
	}

}
