/*
* Copyright 2011 the original author or authors.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
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
