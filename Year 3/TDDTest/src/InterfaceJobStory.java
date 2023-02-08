

public interface InterfaceJobStory {
	
	public boolean login(String user , String pws);
	
	//allow the user to post a job 
	public boolean postNewJob(String title ,String content);
	
	//hidden assumption : allow to see the info about the job the user posted for example : amount of people applied.
	public boolean checkPostInfo();
	
	public boolean SearchForJob(int wage ,String job ,String education ,String scopeOfJob,String location ,String role ,String lineOfBusiness); 
		

	// allows job seekers to contact HR
	public boolean sendMessegeHR(String email , String about);
	

}
