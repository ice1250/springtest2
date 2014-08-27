package com.taehee.springtest.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
public abstract class BaseObject implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3785355625920531803L;

	@Override
	public BaseObject clone() throws CloneNotSupportedException {

		return (BaseObject) super.clone();
	}

	@Override
	public boolean equals(Object obj) {

		return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public int hashCode() {

		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public String toString() {

		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}

}
