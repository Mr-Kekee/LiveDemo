package livedDemo.model;

public class LiveRedis {

	private String liveName;
	private String userName;
	private String keyName;
	private String content;
	
	public LiveRedis() {}
	
	public LiveRedis(String liveName, String userName, String keyName, String content) {
		super();
		this.liveName = liveName;
		this.userName = userName;
		this.keyName = keyName;
		this.content = content;
	}
	
	public String getLiveName() {
		return liveName;
	}
	public void setLiveName(String liveName) {
		this.liveName = liveName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getKeyName() {
		return keyName;
	}
	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
