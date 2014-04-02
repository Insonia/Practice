package sb;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MVFDemo  extends JFrame{
	private JButton jbtController = new JButton("Show COntroller");
	private JButton jbtView = new JButton("Show View");
	private CircleModel model = new CircleModel();
	
	public MVFDemo(){
		setLayout(new FlowLayout());
		add(jbtController);
		add(jbtView);
		
		jbtController.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame fram = new JFrame("Controller");
				CircleController controller = new CircleController();
				controller.setModel(model);
				fram.add(controller);
				fram.setSize(200,200);
				fram.setVisible(true);
			}
		});
		
		jbtView.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame frame = new JFrame("View");
				CircleView view = new CircleView();
				view.setModel(model);
				frame.add(view);
				frame.setSize(500,200);
				frame.setLocation(200, 200);
				frame.setVisible(true);
			}
		});
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new MVFDemo();
		frame.pack();
		frame.setVisible(true);
	}

}
