package org.generation.italy.demo.service;

import java.util.List;
import java.util.Optional;

import org.generation.italy.demo.pojo.Promotion;
import org.generation.italy.demo.repo.PromotionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PromotionService {
	
	@Autowired
	private PromotionRepo pR;
	
	public void save(Promotion promotion) {
		pR.save(promotion);
	}
	
	public List<Promotion> findAll() {
		return pR.findAll();
	}
	
	public Optional<Promotion> getPromotionById(int id) {
		return pR.findById(id);
	}
	
	public void deletePromotionById(int id) {
		pR.deleteById(id);
	}
}
