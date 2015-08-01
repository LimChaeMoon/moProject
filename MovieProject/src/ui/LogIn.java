package ui;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import logic.MainClass;
import service.UserService;
import service.UserServiceImpl;
import vo.UserVo;

public class LogIn extends JFrame implements ActionListener{
	JButton btnLogin, btnExit;
	JLabel lbId, lbPw;
	JTextField tfId; 
	TextField tfPw;
	
	public LogIn(String title){
		super(title);
		setBounds(30, 30, 500, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// 배치 관리자 X
		setLayout(null);
		
		btnLogin = new JButton("로그인");
		btnExit = new JButton("EXIT");
		
		lbId = new JLabel("ID");
		lbPw = new JLabel("PW");
		
		tfId = new JTextField();
		tfPw = new TextField();
		tfPw.setEchoChar('*');
		
		btnLogin.setBounds(100, 330, 150, 50);		
		btnExit.setBounds(250, 330, 150, 50);
		
		lbId.setBounds(96, 107, 100, 30);		
		lbPw.setBounds(96, 207, 100, 30);
		tfId.setBounds(250, 107, 100, 40);
		tfPw.setBounds(250, 207, 100, 40);
		
		add(btnLogin);
		add(btnExit);
		add(lbId);
		add(lbPw);
		add(tfId);
		add(tfPw);
		setVisible(true);
		
		
		btnLogin.addActionListener(this);
		btnExit.addActionListener(this);
	}
	
	public static void main(String[] args) {
		LogIn lg = new LogIn("Login");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj1 = e.getSource();
		
		if(obj1 == btnLogin) {
			//로그인 버튼을 눌렀을 때
			//1.텍스트 필드의 값을 가져오기
			//2. 디비에 연결하여 해당 id, pw가 존재하는 사람이 있는지 여부를 알아오기
			//3. 존재하면 존재한다는 메세지 출력
			//4. 없으면 가입하라는 메세지를 출력
			
			
			if (tfId.getText().trim().equals("") ) {
				JOptionPane.showMessageDialog(null, "ID를 입력하세요.");
			} else if (tfPw.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(null, "비밀번호를 입력하세요.");
			} else {
				String id = tfId.getText();
				String pw = tfPw.getText();
				System.out.println("id : " + id + " pw : " + pw);

				UserVo userVo = new UserVo();
				userVo.setUser_id(id);
				userVo.setUser_pwd(pw);
				
				UserService svc = new UserServiceImpl();
				try {
					userVo = svc.selectLoingUser(userVo);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "관리자에게 문의하시기 바랍니다.");
				}
				
				if(userVo == null) {
					JOptionPane.showMessageDialog(null, "아이디 또는 암호가 맞지 않습니다.");
				} else {
					JOptionPane.showMessageDialog(null, "로그인 성공");
					dispose();
					new MainClass("인디언포커");
				}				
			}

		} else if (obj1 == btnExit) {
			// 종료버튼을 눌렀을 때
			System.exit(0);
			
		}
		
	}

}
