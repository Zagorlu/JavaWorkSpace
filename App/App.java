package App;

import static HtmlTool.HtmlBuilder.getHtmlBuilderFactory;

import HtmlTool.Attribute;
import HtmlTool.Tag;

public class App {
	public static void main(String[] args) {
		
		System.out.println(getHtmlBuilderFactory().checkAttribute(Tag.FORM.generate(), Attribute.ACCEPT.generate()));
	}
}




