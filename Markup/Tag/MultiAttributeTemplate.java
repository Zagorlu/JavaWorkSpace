package Markup.Tag;

import java.util.ArrayList;
import java.util.Collection;

public class MultiAttributeTemplate{
	private ArrayList<AttributeTemplate> m_attributeList;
	/**
	 * Non-Static Initializer For Members
	 * m_attributeList should be Synchronized
	 */
	{
		m_attributeList = new ArrayList<>();
	}
	public MultiAttributeTemplate() {}
	
	public MultiAttributeTemplate(Collection<? extends AttributeTemplate> c) {
		for(AttributeTemplate at:  c)
			this.m_attributeList.add(at);
	}
	
	public boolean add(AttributeTemplate at) {
		return this.m_attributeList.add(at);
	}
	
	public boolean delete(AttributeTemplate at) {
		return this.delete(at);
	}

	public ArrayList<AttributeTemplate> getAttributeList() {
		return m_attributeList;
	}

	public void setAttributeList(ArrayList<AttributeTemplate> m_attributeList) {
		this.m_attributeList = m_attributeList;
	}
	
	/**
	 * This metod clear all Attributes
	 */
	public void removeAllAttributes() {
		this.m_attributeList.clear();
	}

	@Override
	public String toString() {
		if(this.m_attributeList.size() == 0)
			return "";
		
		if(this.m_attributeList.size() == 1)
			return " " + m_attributeList.get(0).toString();
		
		StringBuilder result = new StringBuilder(" ");
		for(AttributeTemplate at : this.m_attributeList)
			result.append(at.toString() + " ");
		
		return result.toString();
	}
}
