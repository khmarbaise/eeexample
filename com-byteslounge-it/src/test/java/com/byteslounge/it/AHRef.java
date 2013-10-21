package com.byteslounge.it;

public class AHRef {
	/**
	 * 
	 */
	private String id;
	private String href;
	private String text;


	public AHRef(String id, String href, String text) {
		super();
		this.id = id;
		this.href = href;
		this.text = text;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("id=");
		sb.append(this.id);
		sb.append(", href=\"");
		sb.append(this.href);
		sb.append("\" text='");
		sb.append(this.text);
		sb.append("'");
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((href == null) ? 0 : href.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AHRef other = (AHRef) obj;
		if (href == null) {
			if (other.href != null)
				return false;
		} else if (!href.equals(other.href))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}

}