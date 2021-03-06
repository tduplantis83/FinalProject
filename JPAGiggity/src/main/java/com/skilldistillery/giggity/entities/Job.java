package com.skilldistillery.giggity.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
public class Job {

	// F I E L D S
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "skill_id")
	private Skill skill;
	
	private double price;

	private String description;

	private String title;

	private Boolean active;

	@ManyToOne
	@JoinColumn(name = "address_id")
	private Address address;

	private Boolean remote;

	@Column(name = "image_url")
	private String imageUrl;

	@Column(name = "date_created")
	private LocalDateTime dateCreated;

	@Column(name = "date_updated")
	private LocalDateTime dateUpdated;
	
	@JsonIgnoreProperties({"skills", "bids", "jobs", "posts"})
	@ManyToOne
	@JoinColumn(name = "requestor_id")
	private User user;
	
	@JsonIgnore
	@OneToMany(mappedBy = "job")
	private List<Booking> bookings;
	
	@JsonIgnore
	@OneToMany(mappedBy = "job")
	private List<BuyerReview> buyerReviews;
	
	@OneToMany(mappedBy = "job")
	private List<Bid> jobBids;
	

	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "job_image", joinColumns = @JoinColumn(name = "image_id"), inverseJoinColumns = @JoinColumn(name = "job_id"))
	private List<Image> jobImages;

	// C O N S T R U C T O R
	public Job() {

	}

	// G E T T E R S && S E T T E R S

	public int getId() {
		return id;
	}

	public List<Bid> getJobBids() {
		return jobBids;
	}

	public void setJobBids(List<Bid> jobBids) {
		this.jobBids = jobBids;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}


	public List<BuyerReview> getBuyerReviews() {
		return buyerReviews;
	}

	public void setBuyerReviews(List<BuyerReview> buyerReviews) {
		this.buyerReviews = buyerReviews;
	}

	public List<Image> getJobImages() {
		return jobImages;
	}

	public void setJobImages(List<Image> jobImages) {
		this.jobImages = jobImages;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Boolean getRemote() {
		return remote;
	}

	public void setRemote(Boolean remote) {
		this.remote = remote;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public LocalDateTime getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

	public LocalDateTime getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(LocalDateTime dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((active == null) ? 0 : active.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((bookings == null) ? 0 : bookings.hashCode());
		result = prime * result + ((buyerReviews == null) ? 0 : buyerReviews.hashCode());
		result = prime * result + ((dateCreated == null) ? 0 : dateCreated.hashCode());
		result = prime * result + ((dateUpdated == null) ? 0 : dateUpdated.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((imageUrl == null) ? 0 : imageUrl.hashCode());
		result = prime * result + ((jobBids == null) ? 0 : jobBids.hashCode());
		result = prime * result + ((jobImages == null) ? 0 : jobImages.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((remote == null) ? 0 : remote.hashCode());
		result = prime * result + ((skill == null) ? 0 : skill.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Job other = (Job) obj;
		if (active == null) {
			if (other.active != null)
				return false;
		} else if (!active.equals(other.active))
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (bookings == null) {
			if (other.bookings != null)
				return false;
		} else if (!bookings.equals(other.bookings))
			return false;
		if (buyerReviews == null) {
			if (other.buyerReviews != null)
				return false;
		} else if (!buyerReviews.equals(other.buyerReviews))
			return false;
		if (dateCreated == null) {
			if (other.dateCreated != null)
				return false;
		} else if (!dateCreated.equals(other.dateCreated))
			return false;
		if (dateUpdated == null) {
			if (other.dateUpdated != null)
				return false;
		} else if (!dateUpdated.equals(other.dateUpdated))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (imageUrl == null) {
			if (other.imageUrl != null)
				return false;
		} else if (!imageUrl.equals(other.imageUrl))
			return false;
		if (jobBids == null) {
			if (other.jobBids != null)
				return false;
		} else if (!jobBids.equals(other.jobBids))
			return false;
		if (jobImages == null) {
			if (other.jobImages != null)
				return false;
		} else if (!jobImages.equals(other.jobImages))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (remote == null) {
			if (other.remote != null)
				return false;
		} else if (!remote.equals(other.remote))
			return false;
		if (skill == null) {
			if (other.skill != null)
				return false;
		} else if (!skill.equals(other.skill))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Job [id=");
		builder.append(id);
		builder.append(", skill=");
		builder.append(skill);
		builder.append(", price=");
		builder.append(price);
		builder.append(", description=");
		builder.append(description);
		builder.append(", title=");
		builder.append(title);
		builder.append(", active=");
		builder.append(active);
		builder.append(", address=");
		builder.append(address);
		builder.append(", remote=");
		builder.append(remote);
		builder.append(", imageUrl=");
		builder.append(imageUrl);
		builder.append(", dateCreated=");
		builder.append(dateCreated);
		builder.append(", dateUpdated=");
		builder.append(dateUpdated);
		builder.append(", user=");
		builder.append(user);
		builder.append("]");
		return builder.toString();
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
