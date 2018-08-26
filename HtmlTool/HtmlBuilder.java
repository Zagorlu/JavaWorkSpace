package HtmlTool;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import HtmlTool.Attribute.HtmlAttribute;
import HtmlTool.Tag.HtmlItem;

public final class HtmlBuilder {
	private static final HtmlBuilder builderObject;
	private static HashMap<String, LinkedList<String>> htmlAttributes;
	
	static { 
		builderObject = new HtmlBuilder();
		htmlAttributes = new HashMap<>();
		htmlAttributes.put("accept", getValueArrayList("form","input"));
		htmlAttributes.put("accept-charset", getValueArrayList("form"));
		htmlAttributes.put("action", getValueArrayList("form"));
		htmlAttributes.put("align", getValueArrayList("applet","caption","col","colgroup","hr","iframe","img", "table","tbody","td","tfoot","th","thead","tr"));
		htmlAttributes.put("alt", getValueArrayList("applet","area","img","input"));
		htmlAttributes.put("async", getValueArrayList("script"));
		htmlAttributes.put("autocomplete", getValueArrayList("form","input","textarea"));
		htmlAttributes.put("autofocus", getValueArrayList("button","input","keygen","select","textarea"));
		htmlAttributes.put("autoplay", getValueArrayList("audio","video"));
		htmlAttributes.put("bgcolor", getValueArrayList("body","col","colgroup","marquee","table","tbody","tfoot","td","th","tr"));
		htmlAttributes.put("border", getValueArrayList("img","object","table"));
		htmlAttributes.put("buffered", getValueArrayList("audio","video"));
		htmlAttributes.put("challenge", getValueArrayList("keygen"));
		htmlAttributes.put("charset", getValueArrayList("meta","script"));
		htmlAttributes.put("checked", getValueArrayList("command","input"));
		htmlAttributes.put("cite", getValueArrayList("blockquote","del","ins","q"));
		htmlAttributes.put("code", getValueArrayList("applet"));
		htmlAttributes.put("codebase", getValueArrayList("applet"));
		htmlAttributes.put("color", getValueArrayList("basefont","font","hr"));		
		htmlAttributes.put("cols", getValueArrayList("textarea"));
		htmlAttributes.put("colspan", getValueArrayList("td","th"));
		htmlAttributes.put("content", getValueArrayList("meta"));
		htmlAttributes.put("controls", getValueArrayList("audio","video"));
		htmlAttributes.put("coords", getValueArrayList("area"));
		htmlAttributes.put("crossorigin", getValueArrayList("audio","img","link","script","video"));
		htmlAttributes.put("datetime", getValueArrayList("dal","ins","time"));
		htmlAttributes.put("default", getValueArrayList("track"));
		htmlAttributes.put("defer", getValueArrayList("script"));
		htmlAttributes.put("dirname", getValueArrayList("input","textarea"));
		htmlAttributes.put("disabled", getValueArrayList("button","command","fieldset","input","keygen", "optgroup","option","select","textarea"));
		htmlAttributes.put("download", getValueArrayList("a","area"));
		htmlAttributes.put("enctype", getValueArrayList("form"));
		htmlAttributes.put("for", getValueArrayList("label","output"));
		htmlAttributes.put("formaction", getValueArrayList("input","button"));
		htmlAttributes.put("headers", getValueArrayList("td","th"));
		htmlAttributes.put("height", getValueArrayList("canvas","embed","iframe","img","input","object","video"));
		htmlAttributes.put("high", getValueArrayList("lmeter"));
		htmlAttributes.put("href", getValueArrayList("a","area","base","link"));
		htmlAttributes.put("hreflang", getValueArrayList("a","area","link"));
		htmlAttributes.put("http-equiv", getValueArrayList("meta"));
		htmlAttributes.put("icon", getValueArrayList("command"));
		htmlAttributes.put("integrity", getValueArrayList("link","script"));
		htmlAttributes.put("ismap", getValueArrayList("img"));
		htmlAttributes.put("keytype", getValueArrayList("keygen"));
		htmlAttributes.put("kind", getValueArrayList("track"));
		htmlAttributes.put("label", getValueArrayList("track"));
		htmlAttributes.put("language", getValueArrayList("script"));
		htmlAttributes.put("list", getValueArrayList("input"));
		htmlAttributes.put("loop", getValueArrayList("audio","bgsound","marquee","video"));
		htmlAttributes.put("low", getValueArrayList("meter"));
		htmlAttributes.put("manifest", getValueArrayList("html"));
		htmlAttributes.put("max", getValueArrayList("input","meter","progress"));
		htmlAttributes.put("maxlength", getValueArrayList("input","textarea"));
		htmlAttributes.put("minlength", getValueArrayList("input","textarea"));
		htmlAttributes.put("media", getValueArrayList("a","area","link","source","style"));
		htmlAttributes.put("method", getValueArrayList("form"));
		htmlAttributes.put("min", getValueArrayList("input","meter"));
		htmlAttributes.put("multiple", getValueArrayList("input","select"));
		htmlAttributes.put("muted", getValueArrayList("audio","video"));
		htmlAttributes.put("name", getValueArrayList("button","form","fieldset","iframe","input","keygen","object", "output","select","textarea","map","meta","param"));
		htmlAttributes.put("novalidate", getValueArrayList("form"));
		htmlAttributes.put("open", getValueArrayList("details"));
		htmlAttributes.put("optimum", getValueArrayList("meter"));
		htmlAttributes.put("pattern", getValueArrayList("input"));
		htmlAttributes.put("ping", getValueArrayList("a","area"));
		htmlAttributes.put("placeholder", getValueArrayList("input","textarea"));
		htmlAttributes.put("poster", getValueArrayList("video"));
		htmlAttributes.put("preload", getValueArrayList("audio","video"));
		htmlAttributes.put("radiogroup", getValueArrayList("command"));
		htmlAttributes.put("readonly", getValueArrayList("input","textarea"));
		htmlAttributes.put("rel", getValueArrayList("a","area","link"));
		htmlAttributes.put("required", getValueArrayList("input","select","textarea"));
		htmlAttributes.put("reversed", getValueArrayList("ol"));
		htmlAttributes.put("rows", getValueArrayList("textarea"));
		htmlAttributes.put("rowspan", getValueArrayList("td","th"));
		htmlAttributes.put("scope", getValueArrayList("th"));
		htmlAttributes.put("scoped", getValueArrayList("style"));
		htmlAttributes.put("seamless", getValueArrayList("iframe"));
		htmlAttributes.put("selected", getValueArrayList("option"));
		htmlAttributes.put("shape", getValueArrayList("a","area"));
		htmlAttributes.put("size", getValueArrayList("input","select"));	
		htmlAttributes.put("sizes", getValueArrayList("link","img","source"));
		htmlAttributes.put("span", getValueArrayList("col","colgroup"));
		htmlAttributes.put("src", getValueArrayList("audio","embed","iframe","img","input","script","source","track","video"));
		htmlAttributes.put("srcdoc", getValueArrayList("iframe"));
		htmlAttributes.put("srclang", getValueArrayList("track"));
		htmlAttributes.put("srcset", getValueArrayList("img"));
		htmlAttributes.put("start", getValueArrayList("ol"));
		htmlAttributes.put("step", getValueArrayList("input"));
		htmlAttributes.put("summary", getValueArrayList("table"));
		htmlAttributes.put("target", getValueArrayList("a","area","base","form"));
		htmlAttributes.put("type", getValueArrayList("button","input","command","embed","object","script","source","style","menu"));
		htmlAttributes.put("usemap", getValueArrayList("img","input","object"));
		htmlAttributes.put("value", getValueArrayList("button","option","input","li","meter","progress","param"));
		htmlAttributes.put("width", getValueArrayList("canvas","embed","iframe","img","input","object","video"));
		htmlAttributes.put("wrap", getValueArrayList("textarea"));
	}
	
	public HtmlBuilder() {}
	
	public static HtmlBuilder getHtmlBuilderFactory() { return builderObject; }
	
	private static LinkedList<String> getValueArrayList(String...strings)
	{
		LinkedList<String> result = new LinkedList<>();
		for(String s: strings)
			result.add(s);
		return result;
	}
	
	public boolean checkAttribute(HtmlItem hi, HtmlAttribute ha) {
		return htmlAttributes.containsKey(hi.getName()) ? htmlAttributes.get(hi.getName()).contains(ha.getName()) : false;
	}
	
	
	
	
	
	
	
	
}
