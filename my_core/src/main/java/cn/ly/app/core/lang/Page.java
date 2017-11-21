package cn.ly.app.core.lang;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaohan on 2017/4/20.
 */
public class Page {
	public static final String PAGE = "page"; // 用于保存page的key

	public static final int DefaultCurPage = 1;
	public static final int DefaultPageSize = 40;

	private int curPage;// 查询第几页，注意：页数是从第1页开始的
	private int pageSize;// 每页的记录条数
	private int totalNum;// 满足条件的记录总数

	private List<Integer> pageIndexs;

	private int prePage; // 前一页
	private int nextPage; // 后一页

	private int firstPage; // 第一页
	private int lastPage; // 最后一页

	private Long startIdForPage; // 当前查询分页的起始ID，为提高查询效率用，适合于后台任务的单线程和多线程用
	private Long endIdForPage; // 当前查询分页的结束ID，为提高查询效率用，适合于后台任务的多线程用

	public Long getStartIdForPage() {
		return startIdForPage;
	}

	public void setStartIdForPage(Long startIdForPage) {
		this.startIdForPage = startIdForPage;
	}

	public Long getEndIdForPage() {
		return endIdForPage;
	}

	public void setEndIdForPage(Long endIdForPage) {
		this.endIdForPage = endIdForPage;
	}

	private void resetPage() {
		if (0 > totalNum) {
			totalNum = 0;
		}
		if (0 > pageSize) {
			pageSize = DefaultPageSize;
		}
		if (0 > curPage) {
			curPage = DefaultCurPage;
		}
		if (1 > prePage || 1 >= curPage) {
			curPage = 1;
		}
		if (1 > nextPage) {
			nextPage = 1;
		}
		firstPage = 1;
		lastPage = 1;
	}

	protected void parsePage() {
		firstPage = 1;

		pageIndexs = new ArrayList<Integer>();
		if (0 >= totalNum) {
			resetPage();
			return;
		}
		int curPage = getCurPage();
		int pageSize = getPageSize();

		lastPage = (0 == totalNum % pageSize) ? totalNum / pageSize : totalNum / pageSize + 1;
		if (curPage >= lastPage) {
			curPage = lastPage;
		}
		int pageRange = (0 == curPage % 5) ? curPage / 5 : curPage / 5 + 1;
		int endPage = 0 >= pageRange ? 1 : Math.min(lastPage, pageRange * 5);
		int startPage = 0 >= pageRange ? 1 : Math.max(firstPage, (pageRange - 1) * 5 + 1);
		for (int i = startPage; i <= endPage; i++) {
			pageIndexs.add(i);
		}

		prePage = 1 >= curPage ? 1 : curPage - 1;
		nextPage = lastPage <= curPage ? 1 : curPage + 1;

	}

	public Page() {
	}

	public Page(Page page) {
		this.curPage = page.curPage;
		this.pageSize = page.pageSize;
		this.totalNum = page.totalNum;
		this.firstPage = page.firstPage;
		this.lastPage = page.lastPage;
		this.nextPage = page.nextPage;
		this.pageIndexs = page.pageIndexs;
		this.prePage = page.prePage;
	}

	public void setPage(Page page) {
		this.curPage = page.curPage;
		this.pageSize = page.pageSize;
		this.totalNum = page.totalNum;
		this.firstPage = page.firstPage;
		this.lastPage = page.lastPage;
		this.nextPage = page.nextPage;
		this.pageIndexs = page.pageIndexs;
		this.prePage = page.prePage;
	}

	/**
	 * 得到第一个记录
	 *
	 * @return
	 */
	public int getStartIndex() {
		int startIndex = (getCurPage() - 1) * getPageSize();
		return (startIndex < 0) ? 0 : startIndex;
	}

	public int getEndIndex() {
		int endIndex = (getCurPage() + 1) * getPageSize() - 1;
		return (endIndex > getTotalNum()) ? getTotalNum() : endIndex;
	}

	/**
	 * 得到总页数
	 *
	 * @return
	 */
	public int getPageNum() {
		int pageNum = getTotalNum() / getPageSize();
		return (0 == getTotalNum() % getPageSize()) ? pageNum : pageNum + 1;
	}

	/**
	 * 返回 当前页
	 *
	 * @return
	 */
	public int getCurPage() {
		// if (curPage > getPageNum() && getPageNum() > 0) {
		// curPage = getPageNum();
		// }
		return (0 >= curPage) ? DefaultCurPage : curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = (0 > curPage) ? DefaultCurPage : curPage;
	}

	/**
	 * 返回 每页的记录个数
	 *
	 * @return
	 */
	public int getPageSize() {
		return (0 >= pageSize) ? DefaultPageSize : pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = (0 > pageSize) ? 0 : pageSize;
	}

	/**
	 * 返回 记录总数
	 *
	 * @return
	 */
	public int getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(int totalNum) {
		this.totalNum = (0 > totalNum) ? 0 : totalNum;
	}

	public Page toPage() {
		parsePage();
		Page page = new Page();
		page.setCurPage(curPage);
		page.setPageSize(pageSize);
		page.setTotalNum(totalNum);
		page.setFirstPage(firstPage);
		page.setLastPage(lastPage);
		page.setNextPage(nextPage);
		page.setPageIndexs(pageIndexs);
		page.setPrePage(prePage);
		return page;
	}

	public JSONObject toCommonPageJSON() {
		parsePage();
		JSONObject page = new JSONObject();
		page.put("curPage", curPage);
		page.put("pageSize", pageSize);
		page.put("totalNum", totalNum);
		return page;
	}

	public List<Integer> getPageIndexs() {
		return pageIndexs;
	}

	public void setPageIndexs(List<Integer> pageIndexs) {
		this.pageIndexs = pageIndexs;
	}

	public int getPrePage() {
		return prePage;
	}

	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getFirstPage() {
		return firstPage;
	}

	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	@Override
	public String toString() {
		return "Page [curPage=" + curPage + ", pageSize=" + pageSize + ", totalNum=" + totalNum + ", pageIndexs="
				+ pageIndexs + ", prePage=" + prePage + ", nextPage=" + nextPage + ", firstPage=" + firstPage
				+ ", lastPage=" + lastPage + "]";
	}
}
