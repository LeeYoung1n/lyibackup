package org.lyi.model;

public class PageVO {
	
	//시작번호
	private int startPage;
	
	//끝번호
	private int endPage;
	
	//이전버튼
	private boolean prev;
	
	//다음버튼
	private boolean next;
	
	//CriteriaVO 포함
	private CriteriaVO cri;
	
	//board테이블의 전체 건수를 저장
	private int total;
	
	
	//생성자
	public PageVO(CriteriaVO cri, int total) {
		this.cri = cri;
		this.total = total;
		
		this.endPage = (int)(Math.ceil(cri.getPageNum()/10.0))*10;
		
		this.startPage = this.endPage-9;
		
		int realEnd = (int)(Math.ceil((total*1.0)/cri.getAmount()));
		
		if(realEnd < this.endPage) {
			this.endPage = realEnd;
		}
		
		this.prev = this.startPage > 1;
		
		this.next = this.endPage < realEnd;
	}
	
	
	
	//게터세터
	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public CriteriaVO getCri() {
		return cri;
	}

	public void setCri(CriteriaVO cri) {
		this.cri = cri;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	
	//toString
	@Override
	public String toString() {
		return "PageVO [startPage=" + startPage + ", endPage=" + endPage + ",prev=" + prev + ", next=" +next + ",cri=" + cri + ", total" + total +"]";
	}
	
}
