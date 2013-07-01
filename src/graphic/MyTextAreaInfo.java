package graphic;

import java.awt.TextArea;


public class MyTextAreaInfo extends TextArea {

	private TextArea lblInfo;
	
	private static final long serialVersionUID = 8180326902904288295L;

	/**
	 * @wbp.parser.entryPoint
	 */
	public MyTextAreaInfo() {
		super();
		this.setSize(1000,100);
	}

	
	public TextArea getInfo(){
		return lblInfo;
	}

	
}
