package com.gwtjs.icustom.mybatis.entity;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PagedResult<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PageVO pageVO;
	private List<T> result;

	public PagedResult() {
	}

	public PagedResult(PageVO page, List<T> result) {
		this.pageVO = page;
		this.result = result;
	}

	public PageVO getPageVO() {
		return pageVO;
	}

	public void setPageVO(PageVO pageVO) {
		this.pageVO = pageVO;
	}

	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "PagedResult [pageVO=" + pageVO + ", result=" + result + "]";
	}

}
