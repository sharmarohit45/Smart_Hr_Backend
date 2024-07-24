package com.youtube.jwt.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;


@Entity
public class AdminTask {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long taskId;

	    private String title;
	    private String taskCategory;
	    private String project;
	    private String startDate;
	    private String dueDate;
	    private String projectSummary;
	    private String contractType;
	    private Double contractValue;
	    private String currency;
	    private Long assignedTo;
		@ManyToOne
		@JoinColumn(name = "employee_Id", referencedColumnName = "empId")
		private Employee employee;
	    private String label;
	    private String milestones;
	    private String status;
	    private String extraStatus;
	    private String makePrivate;
	    private String billable;
	    private String timeEstimates;
	    private String hrs;
	    private Integer minutes;
	    private String repeatInterval;
	    private String dependentTask;
	    @Lob
		@Column(name = "file_data", columnDefinition = "BLOB")
	    private String fileData;
		public Long getTaskId() {
			return taskId;
		}
		public void setTaskId(Long taskId) {
			this.taskId = taskId;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getTaskCategory() {
			return taskCategory;
		}
		public void setTaskCategory(String taskCategory) {
			this.taskCategory = taskCategory;
		}
		public String getProject() {
			return project;
		}
		public void setProject(String project) {
			this.project = project;
		}
		public String getStartDate() {
			return startDate;
		}
		public void setStartDate(String startDate) {
			this.startDate = startDate;
		}
		public String getDueDate() {
			return dueDate;
		}
		public void setDueDate(String dueDate) {
			this.dueDate = dueDate;
		}
		public String getProjectSummary() {
			return projectSummary;
		}
		public void setProjectSummary(String projectSummary) {
			this.projectSummary = projectSummary;
		}
		public String getContractType() {
			return contractType;
		}
		public void setContractType(String contractType) {
			this.contractType = contractType;
		}
		public Double getContractValue() {
			return contractValue;
		}
		public void setContractValue(Double contractValue) {
			this.contractValue = contractValue;
		}
		public String getCurrency() {
			return currency;
		}
		public void setCurrency(String currency) {
			this.currency = currency;
		}
		public Long getAssignedTo() {
			return assignedTo;
		}
		public void setAssignedTo(Long assignedTo) {
			this.assignedTo = assignedTo;
		}
		public Employee getEmployee() {
			return employee;
		}
		public void setEmployee(Employee employee) {
			this.employee = employee;
		}
		public String getLabel() {
			return label;
		}
		public void setLabel(String label) {
			this.label = label;
		}
		public String getMilestones() {
			return milestones;
		}
		public void setMilestones(String milestones) {
			this.milestones = milestones;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getExtraStatus() {
			return extraStatus;
		}
		public void setExtraStatus(String extraStatus) {
			this.extraStatus = extraStatus;
		}
		public String getMakePrivate() {
			return makePrivate;
		}
		public void setMakePrivate(String makePrivate) {
			this.makePrivate = makePrivate;
		}
		public String getBillable() {
			return billable;
		}
		public void setBillable(String billable) {
			this.billable = billable;
		}
		public String getTimeEstimates() {
			return timeEstimates;
		}
		public void setTimeEstimates(String timeEstimates) {
			this.timeEstimates = timeEstimates;
		}
		public String getHrs() {
			return hrs;
		}
		public void setHrs(String hrs) {
			this.hrs = hrs;
		}
		public Integer getMinutes() {
			return minutes;
		}
		public void setMinutes(Integer minutes) {
			this.minutes = minutes;
		}
		
		public String getRepeatInterval() {
			return repeatInterval;
		}
		public void setRepeatInterval(String repeatInterval) {
			this.repeatInterval = repeatInterval;
		}
		public String getDependentTask() {
			return dependentTask;
		}
		public void setDependentTask(String dependentTask) {
			this.dependentTask = dependentTask;
		}
		public String getFileData() {
			return fileData;
		}
		public void setFileData(String fileData) {
			this.fileData = fileData;
		}

	
}
