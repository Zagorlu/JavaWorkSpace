package Nodes;

public class Pair<FirstType, SecondType>{
	private FirstType  m_firstData;
	private SecondType m_secondData;
	public Pair() {}
	
	public Pair(FirstType firstData, SecondType secondData) {
		m_firstData  = firstData;
		m_secondData = secondData;
	}
	
	public Pair(final Pair<FirstType, SecondType> p) {
		this(p.getFirstData(),p.getSecondData());
	}

	public FirstType getFirstData() {
		return m_firstData;
	}

	public void setFirstData(FirstType m_firstData) {
		this.m_firstData = m_firstData;
	}

	public SecondType getSecondData() {
		return m_secondData;
	}

	public void setSecondData(SecondType m_secondData) {
		this.m_secondData = m_secondData;
	}
	
	@Override
	public String toString() {
		return String.format("[%s, %s]", m_firstData.toString(), m_secondData.toString());
	}
}