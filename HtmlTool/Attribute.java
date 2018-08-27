package HtmlTool;

import Markup.Tag.AttributeTemplate;

/**
 * @author Taha Emre Demirkol
 * 
 */
public enum Attribute {

	ACCEPT("accept"), ACCEPT_CHARSET("accept-charset"), ACTION("action"), ALIGN("align"), ALT("alt"), ASYNC("async"),
	AUTOCOMPLETE("autocomplete"), AUTOFOCUS("autofocus"), AUTOPLAY("autoplay"), BGCOLOR("bgcolor"), BORDOR("border"),
	BUFFERED("buffered"), CHALLENGE("challenge"), CHARSET("charset"), CHECKED("checked"), CITE("cite"), CODE("code"),
	CODEBASE("codebase"), COLOR("color"), COLS("cols"), COLSPAN("colspan"), CONTENT("content"), CONTROLS("controls"),
	COORDS("coords"), CROSSORIGIN("crossorigin"), DATETIME("datetime"), DEFAULT("default"), DEFER("defer"), DIRNAME("dirname"),
	DISABLED("disabled"), DOWNLOAD("download"), ENCTYPE("enctype"), FOR("for"), FORMACTION("formaction"), HEADERS("headers"),
	HEIGHT("height"), HIGH("high"), HREF("href"), HREFLANG("hreflang"), HTTP_EQUIV("http-equiv"), ICON("icon"), INTEGRITY("integrity"),
	ISMAP("ismap"), KEYTYPE("keytype"), KIND("kind"), LABEL("label"), LANGUAGE("language"), LIST("list"), LOOP("loop"), LOW("low"),
	MANIFEST("manifest"), MAX("max"), MAX_LENGTH("maxlength"), MIN_LENGTH("minlength"), MEDIA("media"), METHOD("method"), 
	MIN("min"), MULTIPLE("multiple"), MUTED("muted"), NAME("name"), NOVALIDATE("novalidate"), OPEN("open"), OPTIMUM("optimum"),
	PATTERN("pattern"), PING("ping"), PLACEHOLDER("placeholder"), POSTER("poster"), PRELOAD("preload"), RADIOGROUP("radiogroup"),
	READONLY("readonly"), REL("rel"), REQUIRED("required"), REVERSED("reversed"), ROWS("rows"), ROWSPAN("rowspan"), SCOPE("scope"),
	SCOPED("scoped"), SEAMLESS("seamless"), SELECTED("selected"), SHAPE("shape"), SIZE("size"), SIZES("sizes"), SPAN("span"),
	SRC("src"), SRCDOC("srcdoc"), SRCLANG("srclang"), SRCSET("srcset"), START("start"), STEP("step"), SUMMARY("summary"), TARGET("target"),
	TYPE("type"), USEMAP("usemap"), VALUE("value"), WIDTH("width"), WRAP("wrap");
	
	private String attrName;
	Attribute(String name){
		this.attrName = name;
	}
	
	public HtmlAttribute generate() {
		return new HtmlAttribute(this.attrName,"");
	}
	
	public HtmlAttribute generate(String value) {
		return new HtmlAttribute(this.attrName,value);
	}
	
	/**
	 * This inner class created and designed for Builder Pattern
	 * This item only Marking with "HtmlAttribute" name, on purpose this class  inherited from AttributeTemplate
	 */
	public final class HtmlAttribute extends AttributeTemplate {

		public HtmlAttribute(String name, String value) {
			super(name, value);
		}
		
	}
	
	public String getName() {
		return this.attrName;
	}
}
