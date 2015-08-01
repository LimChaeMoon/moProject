package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import service.MovieService;
import service.MovieServiceImpl;
import vo.MovieInfoVo;

public class MovieList extends JFrame {
	
	MovieInfoVo movieInfoVo;
	
	List<MovieInfoVo> movieList;
	
	JLabel[] jlMovie_Name;
	JLabel[] jlScreen_Num;
	JLabel[] jlMovie_Time;
	JLabel[] jlSeat_Amount;
	JButton[] jbtnMovie_No;
	
	JComboBox[] indexValue;
	String movieName;
	int index;
	
	
	public MovieList(String movieName) {
		this.movieName = movieName;
		MovieSelectList(this.movieName);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(30, 30, 800, 600);
		setLayout(null);
		
		jlMovie_Name = new JLabel[movieList.size()];
		jlScreen_Num = new JLabel[movieList.size()];
		jlMovie_Time = new JLabel[movieList.size()];
		jlSeat_Amount = new JLabel[movieList.size()];
		jbtnMovie_No = new JButton[movieList.size()];

		
		JComboBox indexValue = new JComboBox<String>();
		indexValue.addItem("1");
		indexValue.addItem("2");
		indexValue.addItem("3");
		indexValue.addItem("4");
		indexValue.addItem("5");
		indexValue.addItem("6");
		indexValue.addItem("7");
		indexValue.addItem("8");
		
		
		
		System.out.println(movieList.size());
		
		int y = 30;
		for (int i = 0; i < jlScreen_Num.length; i++) {
			movieInfoVo = (MovieInfoVo) movieList.get(i);
			jlScreen_Num[i] = new JLabel(movieInfoVo.getScreen_num());
			jlScreen_Num[i].setBounds(30, y, 50, 30);
			add(jlScreen_Num[i]);
			
			jlMovie_Name[i] = new JLabel(movieInfoVo.getMovie_name());
			jlMovie_Name[i].setBounds(90, y, 200, 30);
			add(jlMovie_Name[i]);
			
			jlMovie_Time[i] = new JLabel(movieInfoVo.getMovie_time()+"");
			jlMovie_Time[i].setBounds(300, y, 200, 30);
			add(jlMovie_Time[i]);
			
			jlSeat_Amount[i] = new JLabel(movieInfoVo.getSeat_amount()+"자리");
			jlSeat_Amount[i].setBounds(510, y, 80, 30);
			add(jlSeat_Amount[i]);

			jbtnMovie_No[i] = new JButton(movieInfoVo.getMovie_no()+"");
			jbtnMovie_No[i].setBounds(600, y, 50, 30);
			add(jbtnMovie_No[i]);
			
			
			
			y += 40;
			
			
			jbtnMovie_No[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {

					Object obj = indexValue.getSelectedItem();
					String str = (String) obj;
					int index = Integer.parseInt(str);
					
					String thisNo = e.getActionCommand();
					
					int MovieNo = Integer.parseInt(thisNo);
					System.out.println(MovieNo);
					
					
					// 가입을 취소 할 것 인지 안할 것 인지 묻는다.
					int result = JOptionPane.showConfirmDialog(null, "인원 : " + index + 
							", 영화 : " + movieName + ", " + MovieNo  );
					
					//취소를 OK 할 경우
					if(result == JOptionPane.YES_OPTION) {
						new ActorSeat(MovieNo, movieName, index);
						dispose();

					// 취소를 NO 할 경우	
					} else if (result == JOptionPane.NO_OPTION) {
						// 따로 처리 할것이 없기 때문에 그냥 가만히 냅둔다
					}

				}
			});
		}
		indexValue.setBounds(660, 30, 100, 30);
		add(indexValue);

		
		setVisible(true);
		
	}
	

	
	
	
	private void MovieSelectList(String movieName) {
		try {
			
			MovieService msv = new MovieServiceImpl();
			movieList = msv.selectMovie(movieName);

			if (movieList == null) {
				System.out.println("조회된 영화가 없습니다.");
			}

			for (int i = 0; i < movieList.size(); i++) {
				// System.out.println(movieList.get(i));
				movieInfoVo = (MovieInfoVo) movieList.get(i);
			}
			
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			// e1.printStackTrace();

		}
	}

}
