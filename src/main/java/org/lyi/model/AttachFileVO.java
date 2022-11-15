package org.lyi.model;

public class AttachFileVO {
	
	// 웹브라우저에 이미지를 출력하기 위해 필요한 데이터
	// 파일이 저장되어 있는 경로
	private String uploadPath;		// 2022-08-24 
	// 업로드된 파일명
	private String fileName;		// 업로드용3.png
	// UUID
	private String uuid;			//랜덤한 숫자와 알파벳의 조합
	// 업로드된 파일이 이미지인지 판별한 정보
	private boolean image;
	//게시판 번호
	private int bno;

	
	
	public String getUploadPath() {
		return uploadPath;
	}
	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public boolean isImage() {
		return image;
	}
	public void setImage(boolean image) {
		this.image = image;
	}
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	
	
	
	@Override
	public String toString() {
		return "AttachFileVO [uploadPath=" + uploadPath + ", fileName=" + fileName + ", uuid=" + uuid + ", image="
				+ image + ", bno=" + bno + "]";
	}
	
}
