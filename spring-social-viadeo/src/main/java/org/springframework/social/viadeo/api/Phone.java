package org.springframework.social.viadeo.api;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;

public class Phone implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7992330053889482442L;

	private final String type;
	private final String country;
	private final String dialing;
	private final String number;

	public Phone(String type, String country, String dialing, String number) {
		this.type = type;
		this.country = country;
		this.dialing = dialing;
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public String getCountry() {
		return country;
	}

	public String getDialing() {
		return dialing;
	}

	public String getNumber() {
		return number;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((dialing == null) ? 0 : dialing.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Phone other = (Phone) obj;
		return new EqualsBuilder()
				.append(this.getCountry(), other.getCountry()).append(
						this.getDialing(), other.getDialing()).append(
						this.getNumber(), other.getNumber()).append(
						this.getType(), other.getType()).isEquals();
	}

}
