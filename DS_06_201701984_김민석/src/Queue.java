
public interface Queue {
	public Object pop();
	public boolean push(Object obj);
	public boolean empty();
	public Object front();
	public Object back();
	public void remove();
	public int size();
}