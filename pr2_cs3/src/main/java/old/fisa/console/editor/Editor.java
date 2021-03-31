package old.fisa.console.editor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import old.fisa.console.command.Command;
import old.fisa.console.command.CopyCommand;
public class Editor {
	public JTextArea textField;
	public String clipboard;
	
	public void init() {
		JFrame frame = new JFrame("Text editor");
		JPanel content = new JPanel();
		frame.setContentPane(content);
		frame.setDefaultCloseOperation(3);
		content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
		textField = new JTextArea();
		textField.setLineWrap(true);
		content.add(textField);
		JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton ctrlC = new JButton("Ctrl+C");
		Editor editor = this;
		ctrlC.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				executeCommand(new CopyCommand(editor));
			}
		});
		buttons.add(ctrlC);
		content.add(buttons);
		frame.setSize(450, 200);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);			
	}
	
	private void executeCommand(Command command) {
		if (command.execute()){
			System.out.println("test réussi");
		}
	}
	
	private void undo() {
		return;
	}
	
	
	
}
