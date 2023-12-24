package question1;

import java.io.Serializable;

public class Project implements Serializable {

	private static final long serialVersionUID = 1L;
	
	String projectCode;
	String projectName;
	int projectStrength;
	
	public Project(String projectCode, String projectName, int projectStrength) {
		this.projectCode = projectCode;
		this.projectName = projectName;
		this.projectStrength = projectStrength;
	}

	@Override
	public String toString() {
		return "The Project\nProject [projectCode=" + projectCode + ", projectName=" + projectName + ", projectStrength="
				+ projectStrength + "] Has the following Employees";
	}
	
}
