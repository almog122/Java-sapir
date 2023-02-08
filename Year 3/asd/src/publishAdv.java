
public class publishAdv {
	
	//attributes 
	private String id;
	private String domain;
	private String role;
	private String desc;
	private String area;
	private boolean status;
	
	
	//constructor	
	publishAdv(String domain, String role, String desc, String area) {
		
		set_domain(domain);
		set_role(role);
		set_desc(desc);
		set_area(area);
		
		set_status(true);
		
	}
	
	
	//setters
	
	public void set_domain(String str) {
		this.domain = str;
	}
	
	public void set_role(String str) {
		this.role = str;
	}
	
	public void set_desc(String str) {
		this.desc = str;
	}
	
	public void set_area(String str) {
		this.area = str;
	}
	
	public void set_status(boolean ans) {
		this.status = ans;
	}
	
	public void set_adId(String id) {
		this.id = id;
	}
	
	
	//gets
	public String get_domain() {
		return this.domain;
	}
	
	public String get_role() {
		return this.role;
	}
	
	public String get_desc() {
		return this.desc;
	}
	
	public String get_area() {
		return this.area;
	}
	
	public boolean get_status() {
		return this.status;
	}
		
	public String get_adId() {
		return this.id; 
	}
	
}



