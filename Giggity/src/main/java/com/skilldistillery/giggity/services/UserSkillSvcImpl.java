package com.skilldistillery.giggity.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.giggity.repositories.UserSkillRepo;

@Service
@Transactional
public class UserSkillSvcImpl implements UserSkillService {

	@Autowired
	private UserSkillRepo usRepo;
}