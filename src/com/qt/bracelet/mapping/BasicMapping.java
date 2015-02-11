package com.qt.bracelet.mapping;

import java.io.Serializable;
import java.util.List;

public class BasicMapping<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	public List<T> datas = null;

	public String message = null;

	public Integer code = -2;

}
