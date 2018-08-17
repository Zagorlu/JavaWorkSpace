package Markup.Tag;

import java.util.ArrayList;
import java.util.List;

/**
 * Tag Class prepared for Markup Languages
 * @author Emre Demirkol
 *
 */
public class TagTemplate {
	private String m_name, m_start, m_end;
	private MultiAttributeTemplate m_attributes;
	private List<Object> m_value;
	
	/**
	 * Non-static Initiliazer Code Block
	 */
	{ m_value = new ArrayList<>(); }
	
	/**
	 * This Constructure set with name and attribute
	 * @param name  : Tag Name 
	 * @param attrs : This MultiAttributeTemplate object
	 */
	public TagTemplate(String name, MultiAttributeTemplate attrs) {
		this.m_name = name;
		this.m_attributes = attrs;
		this.m_start = String.format("<%s%s>", name, attrs);
		this.m_end = String.format("</%s>", name);
	}
	
	/**
	 * This Constructure only setting with name, and generate default MultiAttributeTemplate oblect
	 * @param name : Tag Name 
	 */
	public TagTemplate(String name) {
		this(name, new MultiAttributeTemplate());
	}
	
	/**
	 * This method update to start end
	 */
	private void setStart() {
		this.m_start = String.format("<%s%s>", this.m_name, this.m_attributes.toString());
	}
	
	/**
	 * This method MultiAttributeTemplate object will set with attribute data member
	 * @param attrs : This MultiAttributeTemplate object
	 */
	public void setAttributes(MultiAttributeTemplate attrs) {
		this.m_attributes = attrs;
		setStart();
	}
	
	/**
	 * This Method will return to attributes info
	 * @return MULTI_ATTRIBUTE_TEMPLATE
	 */
	public MultiAttributeTemplate getAttributes() {
		return m_attributes;
	}
	
	/**
	 * This method adds to object to tags value
	 * @param obj : Parameter uses the object toString() method
	 */
	public TagTemplate addValue(Object obj) {
		if(obj == null)
			throw new NullPointerException("Value cannot be null !!!");
		if(obj instanceof String)
			this.m_value.add(obj);
		if(obj instanceof TagTemplate)
			this.m_value.add(obj);
		//TODO: This part can throw exception or can constarin to other types
		return this;
	}
	
	/**
	 * This method will return add info
	 * @param at : This attribute template desire to be add list
	 * @return BOOLEAN
	 */
	public boolean addAttribute(AttributeTemplate at) {
		boolean result = this.m_attributes.add(at);
		this.setStart();
		return result;
	}
	
	/**
	 * This method will return delete info
	 * @param at : This attribute template desire to be deleted from list
	 * @return BOOLEAN
	 */
	public boolean removeAttribute(AttributeTemplate at) {
		boolean result = this.m_attributes.delete(at);
		this.setStart();
		return result;
	}
	
	/**
	 * This metod clear all Attributes
	 */
	public void removeAllAttribute() {
		this.m_attributes.removeAllAttributes();
	}
	
	/**
	 * Equality should be provide with Tag name
	 */
	@Override
	public boolean equals(Object obj) {
		return ((TagTemplate)obj).m_name == this.m_name;
	}
	
	/**
	 * Overrieded this metod should be give all components given with String
	 * For example <tag att1="..." att2="..."> ... value ... </tag>
	 */
	@Override
	public String toString() {
		if(m_value.size() == 0)
			return m_start + m_end;
		String valueResult = "";
		for (Object o : m_value)
			valueResult += o.toString();
		
		return m_start + valueResult + m_end;
	}
}
