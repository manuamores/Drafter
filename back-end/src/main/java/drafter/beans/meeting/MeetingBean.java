package drafter.beans.meeting;

import java.util.List;

import drafter.beans.Option;

public class MeetingBean {
	private Integer id;
	private String title; 
	private String description;
	private Integer numberOfMeeting;
	private String image;
	private long timer;
	private long date;
	private List<Option> attendants;
	private String type;
	private boolean isFinished;

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Option> getAttendants() {
		return attendants;
	}
	public void setAttendants(List<Option> attendants) {
		this.attendants = attendants;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isFinished() {
		return isFinished;
	}
	public void setFinished(boolean isFinished) {
		this.isFinished = isFinished;
	}
	public Integer getNumberOfMeeting() {
		return numberOfMeeting;
	}
	public void setNumberOfMeeting(Integer numberOfMeeting) {
		this.numberOfMeeting = numberOfMeeting;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public long getTimer() {
		return timer;
	}
	public void setTimer(long timer) {
		this.timer = timer;
	}
	public long getDate() {
		return date;
	}
	public void setDate(long date) {
		this.date = date;
	}
	
	
}