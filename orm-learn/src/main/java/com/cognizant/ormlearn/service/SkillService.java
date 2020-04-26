package com.cognizant.ormlearn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.ormlearn.model.Skill;
import com.cognizant.ormlearn.repository.SkillRepository;

@Service
public class SkillService 
{
	@Autowired
	private SkillRepository skillRepository;
	
	@Transactional
	public Skill get(Integer id)
	{
		return skillRepository.findById(id).get();
	}
	
	@Transactional
	public void save(Skill skill)
	{
		skillRepository.save(skill);
	}
}
