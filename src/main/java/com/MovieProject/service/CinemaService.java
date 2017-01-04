package com.MovieProject.service;

import java.util.ArrayList;

import com.MovieProject.dto.CinemaDTO;

public interface CinemaService {

	public ArrayList<CinemaDTO> selectCinemaList();
	public void writeCinema(CinemaDTO cinemaDTO);
	public void deleteCinema(int num);
}
