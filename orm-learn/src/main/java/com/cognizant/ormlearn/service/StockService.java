package com.cognizant.ormlearn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.repository.StockRepository;

@Service
public class StockService 
{
	@Autowired
	private StockRepository stockRepository;
	public List<Stock> findFBTillSep()
	{
		return stockRepository.findFBTillSep();
	}
	
	public List<Stock> findGOOGLmore1250()
	{
		return stockRepository.findGOOGLmore1250();
	}
	
	public List<Stock> findTop3ByCodeOrderByVolumeDesc(String code)
	{
		return stockRepository.findTop3ByCodeOrderByVolumeDesc(code);
	}
	
	public List<Stock> findTop3ByCodeOrderByClose(String code)
	{
		return stockRepository.findTop3ByCodeOrderByClose(code);
	}
}
