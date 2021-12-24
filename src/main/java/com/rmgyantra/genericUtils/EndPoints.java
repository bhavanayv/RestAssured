package com.rmgyantra.genericUtils;
/**
 * This class contains the endpoints of the API's
 * @author Bhavana
 *
 */
public interface EndPoints {

	public String GETALLPROJECTS = "/projects";
	public String ADDPROJECT = "/addProject";
	public String GETSINGLEPROJECTS = "/projects/{projectId}";
	public String UPDATEPROJECT = "/projects/{projectId}";
	public String DELETEPROJECT = "/projects/{projectId}";
	public String CREATEUSER = "/employees";
	public String DELETEUSER= "/employees/{empId}";
}
