package Markup.Tag;

public class AttributeTemplate {
	/**
	 * This template created for using the mark up languages attributes
	 */
	private String m_name, m_value;
	
	public AttributeTemplate() {}
	
	public AttributeTemplate(String name, String value) {
		this.m_name = name;
		this.m_value = value;
	}
	
	public AttributeTemplate(AttributeTemplate attr) {
		this(attr.getName(), attr.getValue());
	}

	public String getName() {
		return m_name;
	}

	public void setName(String m_name) {
		this.m_name = m_name;
	}

	public String getValue() {
		return m_value;
	}

	public void setValue(String m_value) {
		this.m_value = m_value;
	}
	
	@Override
	public boolean equals(Object obj) {
		return ((AttributeTemplate)obj).getName() == this.m_name;
	}
	
	@Override
	public String toString() {
		if(this.m_name == null || this.m_value == null)
			return "";
		return String.format("%s = \"%s\"", this.m_name, this.m_value);
	}
}
