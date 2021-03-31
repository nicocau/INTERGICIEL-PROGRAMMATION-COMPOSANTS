package old.fisa.console.command;

import old.fisa.console.editor.Editor;
import old.uphf.kafka.demo.engine.Producer;

public class CopyCommand extends Command {
	
	public CopyCommand(Editor editor) {
		super(editor);
	}
	
	@Override
	public boolean execute() {
		editor.clipboard = editor.textField.getText();
		//if(editor.textField.getText().equals("test"))
		editor.textField.insert(":\ntest réussi\n \n", editor.textField.getCaretPosition());
		Producer t;
		//t.sendMessagePr2("editor.textField.getText()");
		return false;
	}

}
