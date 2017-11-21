package cn.ly.app.core.lang;

import java.io.Serializable;

/**
 * Created by zhaohan on 2017/4/20.
 */
public class BaseQuery extends Page implements Serializable {

	private static final long serialVersionUID = 2029631904203706115L;

	private String sqlOrderType;

	private Boolean isPage;

	public static enum OrderType {
		desc(0, "desc", "降序"),
		asc(1, "asc", "升序");

		private Integer index;
		private String code;
		private String name;

		private OrderType(Integer index, String code, String name) {
			this.index = index;
			this.code = code;
			this.name = name;
		}

		public Integer getIndex() {
			return this.index;
		}

		public String getCode() {
			return this.code;
		}

		public String getName() {
			return this.name;
		}

		public boolean equals(String code) {
			return null == code ? false : code.equals(this.code);
		}

		public boolean equals(Integer index) {
			return null == index ? false : index.equals(this.index);
		}

		public static OrderType getType(String code) {
			for (OrderType type : OrderType.values()) {
				if (type.code.equals(code)) {
					return type;
				}
			}
			return null;
		}

		public static OrderType getType(Integer index) {
			for (OrderType type : OrderType.values()) {
				if (type.index.equals(index)) {
					return type;
				}
			}
			return null;
		}
	}

	public String getSqlOrderType() {
		return sqlOrderType;
	}

	public void setSqlOrderType(String sqlOrderType) {
		this.sqlOrderType = sqlOrderType;
	}

	public Boolean getIsPage() {
		return isPage;
	}

	public void setIsPage(Boolean isPage) {
		this.isPage = isPage;
	}

	public BaseQuery() {
	}

	public BaseQuery(Page page) {
		super(page);
	}

}
