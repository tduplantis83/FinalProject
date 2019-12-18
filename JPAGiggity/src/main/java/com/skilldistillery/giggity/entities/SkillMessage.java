package com.skilldistillery.giggity.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SkillMessage {
	// F I E L D S
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "poster_id")
	private int posterId;

	@Column(name = "skill_id")
	private int skillId;

	private String message;

	@Column(name = "message_date")
	private LocalDateTime messageDate;

	@Column(name = "in_reply_to")
	private int inReplyTo;

	// C O N S T R U C T O R
	public SkillMessage() {

	}

	// G E T T E R S && S E T T E R S
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPosterId() {
		return posterId;
	}

	public void setPosterId(int posterId) {
		this.posterId = posterId;
	}

	public int getSkillId() {
		return skillId;
	}

	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getMessageDate() {
		return messageDate;
	}

	public void setMessageDate(LocalDateTime messageDate) {
		this.messageDate = messageDate;
	}

	public int getInReplyTo() {
		return inReplyTo;
	}

	public void setInReplyTo(int inReplyTo) {
		this.inReplyTo = inReplyTo;
	}

	// H A S H && E Q U A L S
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + inReplyTo;
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((messageDate == null) ? 0 : messageDate.hashCode());
		result = prime * result + posterId;
		result = prime * result + skillId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SkillMessage other = (SkillMessage) obj;
		if (id != other.id)
			return false;
		if (inReplyTo != other.inReplyTo)
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (messageDate == null) {
			if (other.messageDate != null)
				return false;
		} else if (!messageDate.equals(other.messageDate))
			return false;
		if (posterId != other.posterId)
			return false;
		if (skillId != other.skillId)
			return false;
		return true;
	}

	// T O S T R I N G
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SkillMessage [id=");
		builder.append(id);
		builder.append(", posterId=");
		builder.append(posterId);
		builder.append(", skillId=");
		builder.append(skillId);
		builder.append(", message=");
		builder.append(message);
		builder.append(", messageDate=");
		builder.append(messageDate);
		builder.append(", inReplyTo=");
		builder.append(inReplyTo);
		builder.append("]");
		return builder.toString();
	}

}
