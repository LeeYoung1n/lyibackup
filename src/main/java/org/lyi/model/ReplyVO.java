package org.lyi.model;

public class ReplyVO {

	private int rno;		// 댓글번호
	private String reply; 	//댓글내용
	private String id;		// 아이디
	private String replydate;
	private int bno;
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getReplydate() {
		return replydate;
	}
	public void setReplydate(String replydate) {
		this.replydate = replydate;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	
	
	//toString
			@Override
			public String toString() {
				return "ReplyVO [rno=" + rno + ", reply=" + reply + ", id=" + id + ", replydate=" + replydate + ", bno=" + bno +"]";
			}
	
	
	
}
	
