package HtmlTool;

import Markup.Tag.MultiAttributeTemplate;
import Markup.Tag.TagTemplate;

/**
 * @author Taha Emre Demirkol
 * This enum created for basic HTML tag. It should be add all of them. If you realize some new tag,
 * you should add new one. Also this enum can modify with new methods.
 * 
 * Another options you can use below static string array : 
 * 
 	final private static String [] htmlTags= {"!DOCTYPE", "a", "abbr", "acronym", "address", "applet", "area",
			"article", "aside", "audio", "b", "base", "basefont", "bdi", "bdo", "br", "button", "body",
			"canvas", "caption", "center", "cite", "code", "col", "colgroup", "datalist", "dd",
			"del", "dfn", "dialog", "dir", "div", "dl", "dt", "em", "embed", "fieldset",
			"figcaption", "figure", "font", "footer", "form", "frame", "frameset",
			"h1", "h2", "h3", "h4", "h5", "h6", "h7", "head", "header", "hr","html", "i", "iframe", 
			"img", "input", "ins", "kdp", "keygen", "label", "legend", "li", "link", "main", "map", 
			"mark", "marquee", "menu", "menuitem", "meta", "meter", "nav", "noframes", "noscript", "object",
			"ol", "optgroup", "option", "output", "p", "param", "picture", "pre", "progress", "q",
			"rp", "rt", "ruby", "s", "samp", "script", "section", "select", "small", "source", "span",
			"strike", "strong", "style", "sub", "summary", "sup", "table", "tbody", "td", "textarea",
			"tfoot", "th", "thead", "time", "title", "tr", "track", "tt", "u", "ul", "var", "video","wbr"};
 */


public enum Tag {
	
	DOCTYPE("!DOCTYPE"), A("a"), ABBR("abbr"), ACRONYM("acronym"), ADDRESS("address"), APPLET("applet"),
	AREA("area"), ARTICLE("article"), ASIDE("aside"), AUDIO("audio"), B("b"), BASE("base"), BASEFONT("basefont"),
	BDI("bdi"), BDO("bdo"), BR("br"), BUTTON("BUTTON"), BODY("body"), CANVAS("canvas"), CAPTION("caption"), CENTER("center"),
	CITE("cite"), CODE("code"), COL("col"), COLGROUP("colgroup"), DATALIST("datalist"), DD("dd"), DEL("del"), DFN("dfn"),
	DIALOG("dialog"), DIR("dir"), DIV("div"), DL("dl"), DT("dt"), EM("em"), EMBED("embed"), FIELDSET("fieldset"), 
	FIGCAPTION("figcaption"), FIGURE("figure"), FONT("font"), FOOTER("footer"), FORM("form"), FRAME("frame"), 
	FRAMESET("frameset"), H1("h1"), H2("h2"), H3("h3"), H4("h4"), H5("h5"), H6("h6"), H7("h7"), HEAD("head"), HEADER("header"),
	HR("hr"), HTML("html"), I("i"), IFRAME("iframe"), IMG("img"), INPUT("input"), INS("ins"), KDP("kdp"), KEYGEN("keygen"),
	LABEL("label"), LEGEND("legend"), LI("li"), LINK("link"), MAIN("main"), MAP("map"), MARK("mark"), MARQUEE("marquee"),
	MENU("menu"), MENUITEM("menuitem"), META("meta"), METER("meter"), NAV("nav"), NOFRAMES("noframes"), NOSCRIPT("noscript"),
	OBJECT("object"), OL("ol"), OPTGROUP("optgroup"), OPTION("option"), OUTPUT("output"), P("p"), PARAM("param"), PICTURE("picture"),
	PRE("pre"), PROGRESS("progress"), Q("q"), RP("rp"), RT("rt"), RUBY("ruby"), S("s"), SAMP("samp"), SCRIPT("script"), SECTION("section"),
	SELECT("select"), SMALL("small"), SOURCE("source"), SPAN("span"), STRIKE("strike"), STRONG("strong"), STYLE("style"), SUB("sub"),
	SUMMARY("summary"), SUP("sup"), TABLE("table"), TBODY("tbody"), TD("td"), TEXTAREA("textarea"), TFOOT("tfoot"), TH("th"),
	THEAD("thead"), TIME("time"), TITLE("title"), TR("tr"), TRACK("track"), TT("tt"), U("u"), UL("ul"), VAR("var"), VIDEO("video"), WBR("wbr");
	
	private String tagName;
	/**
	 * This Ctor already initiliaze with default value on enum
	 * @param name
	 */
	private Tag(String name){
		this.tagName = name;
	}
	
	/**
	 * This method return to initiliazed tag name
	 * @return STRING
	 */
	public String getName() {
		return this.tagName;
	}
	
	/**
	 * This method generate HtmlItem Class for each call
	 * @return CLASS: HTML_ITEM
	 */
	public HtmlItem generate() {
		return new HtmlItem(this.tagName);
	}
	
	/**
	 * This method generate HtmlItem Class for each call and set with Attributes
	 * @param attrs: MultiAttributeTemplate Object
	 * TODO: This Parameter will change with ATTR enum type
	 * @return CLASS: HTML_ITEM
	 */
	public HtmlItem generate(MultiAttributeTemplate attrs) {
		return new HtmlItem(this.tagName, attrs);
	}
	
	/**
	 * This inner class created and designed for Builder Pattern
	 * This item only Marking with "HtmlItem" name, on purpose this class  inherited from TagTemplate
	 */
	public final class HtmlItem extends TagTemplate{

		public HtmlItem(String name) {
			super(name);
		}

		public HtmlItem(String name, MultiAttributeTemplate attrs) {
			super(name, attrs);
		}	
	}	
}
