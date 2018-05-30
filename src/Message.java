


public class Message {

	String body;
	String sender;
	String address;
	
	public Message(String sender,String address,String body) {
		this.body=body;
		this.address=address;
		this.sender=sender;
	}
	public Message() {
		this.body="";
		this.sender="";
		this.address="";
	}
	
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
		
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getAddressee() {
		return address;
	}
	public void setAddressee(String addressee) {
		this.address = addressee;
	}
	public void addToBody(String s) {
		this.body=body+ "%n" +s;                   //check if %n actually add new line
	}
	public String toString() {
		return " sentFrom:<"+ this.getSender() +">to:<"+this.getAddressee()+">: <" + this.getBody()+">" ;
	}
}

