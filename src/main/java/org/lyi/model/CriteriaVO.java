package org.lyi.model;

public class CriteriaVO {

		//페이지 번호
		private int pageNum;
		
		//한 페이지당 게시물 갯수
		private int amount;
		
		//검색창에 입력한 키워드 
		private String keyword;

		//키워드의 종류
		private String type;
		
		
		
		//생성자
		public CriteriaVO() {
			this(1,10);
		}
		
		public CriteriaVO(int pageNum, int amount) {
			this.pageNum = pageNum;
			this.amount = amount;
		}
		public int getPageNum() {
			return pageNum;
		}

		public void setPageNum(int pageNum) {
			this.pageNum = pageNum;
		}

		public int getAmount() {
			return amount;
		}

		public void setAmount(int amount) {
			this.amount = amount;
		}
		
		public String getKeyword() {
			return keyword;
		}

		public void setKeyword(String keyword) {
			this.keyword = keyword;
		}
		
		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		//toString
		@Override
		public String toString() {
			return "CriteriaVO [pageNum=" + pageNum + ", amount=" + amount + ", keyword" + keyword + ", type" + type + "]";
		}
}
