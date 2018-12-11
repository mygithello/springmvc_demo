package com.demo.entity;

import java.util.TreeMap;

public class WechatMessageTemplate {
	private String touser; //接收者openid
	private String template_id; //模板ID
	
	private String  page;  //该字段不填则模板无跳转。page/index/index
	private String form_id;  //表单提交场景下，为 submit 事件带上的 formId
	private String emphasis_keyword;  //模板需要放大的关键词，不填则默认无放大
	
	private TreeMap<String, TreeMap<String, String>> data; //data数据
	
	/**
	 * 参数
	 * @param value
	 * @return
	 */
	public static TreeMap<String, String> item(String value) {
		TreeMap<String, String> params = new TreeMap<String, String>();
		params.put("value", value);
		return params;
	}

	public String getTouser() {
		return touser;
	}

	public void setTouser(String touser) {
		this.touser = touser;
	}

	public String getTemplate_id() {
		return template_id;
	}

	public void setTemplate_id(String templateId) {
		template_id = templateId;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getForm_id() {
		return form_id;
	}

	public void setForm_id(String formId) {
		form_id = formId;
	}

	public String getEmphasis_keyword() {
		return emphasis_keyword;
	}

	public void setEmphasis_keyword(String emphasisKeyword) {
		emphasis_keyword = emphasisKeyword;
	}

	public TreeMap<String, TreeMap<String, String>> getData() {
		return data;
	}

	public void setData(TreeMap<String, TreeMap<String, String>> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "WechatMessageTemplate [data=" + data + ", emphasis_keyword="
				+ emphasis_keyword + ", form_id=" + form_id + ", page=" + page
				+ ", template_id=" + template_id + ", touser=" + touser + "]";
	}

	
}
