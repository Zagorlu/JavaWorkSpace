package App;

import HtmlTool.Tag.HtmlItem;
import HtmlTool.Tag;
import Markup.Tag.AttributeTemplate;


public class App {
	public static void main(String[] args) {
		HtmlItem t = Tag.HTML.generate();		
		
		
		t.addAttribute(new AttributeTemplate("attrs","value"));
		t.addAttribute(new AttributeTemplate("dsadsa","dsadasd"));
		
		t.addValue(Tag.ACRONYM.generate().addValue(Tag.HTML.generate()));
		t.addValue(Tag.ADDRESS.generate());
		
		
		
		System.out.println(t);
		
	}
}
