package swing.models;

import javax.swing.DefaultListSelectionModel;
import javax.swing.ListSelectionModel;

public class OneRowSelectionModel extends DefaultListSelectionModel{
	
	public OneRowSelectionModel() {
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}

}
