package fisa.console.command;

import fisa.console.editor.*;
import fisa.console.editor.Editor;
import uphf.kafka.demo.engine.Producer;

public class CopyCommand extends Command {
	
	public CopyCommand(Editor editor) {
		super(editor);
	}
	
	@Override
	public boolean execute() {
		editor.clipboard = editor.textField.getText();
		//if(editor.textField.getText().equals("test"))
		editor.textField.insert(":\ntest réussi\n \n", editor.textField.getCaretPosition());
		Producer t = null;
		t.sendMessagePr2("editor.textField.getText()");
		return false;
	}

}
