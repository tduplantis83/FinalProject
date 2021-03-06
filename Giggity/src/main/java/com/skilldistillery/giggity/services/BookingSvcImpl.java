package com.skilldistillery.giggity.services;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.giggity.entities.Booking;
import com.skilldistillery.giggity.entities.User;
import com.skilldistillery.giggity.repositories.BookingRepo;
import com.skilldistillery.giggity.repositories.UserRepo;

@Service
@Transactional
public class BookingSvcImpl implements BookingService {

	@Autowired
	private BookingRepo repo;
	

//	@Override
//	public List<Booking> getActive(int uid) {
//		return repo.queryActive(uid);
//	}
//
//	@Override
//	public List<Booking> getTransactionHistory(int uid) {
//		return repo.queryByTransactionHistory(uid);
//	}

	@Override
	public List<Booking> getAllByJob(int jid) {
		return repo.findByJob_Id(jid);
	}

	@Override
	public List<Booking> getAllByJobRequester(int reqid) {
		return repo.findByJob_User_Id(reqid);
	}

	@Override
	public Booking create(Booking booking) {
		booking.setStartDate(LocalDate.now());
		return repo.saveAndFlush(booking);
	}

	@Override
	public Booking update(int bid, Booking booking) {
		Booking update = repo.findById(bid);
		update.setAccepted(booking.isAccepted());
		update.setCompleteDate(booking.getCompleteDate());
		update.setExpectedCompleteDate(booking.getExpectedCompleteDate());
		update.setJob(booking.getJob());
		update.setMessages(booking.getMessages());
		update.setNotes(booking.getNotes());
		update.setSellerReview(booking.getSellerReview());
		update.setStartDate(booking.getStartDate());
		update.setBid(booking.getBid());
		return update;
	}

	@Override
	public boolean delete(int bid) {
		try {
			Booking booking = repo.findById(bid);
			repo.delete(booking);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Booking> getAllByBidBidder(int bidderid) {
		return repo.findByBid_Bidder_Id(bidderid);
	}

}
