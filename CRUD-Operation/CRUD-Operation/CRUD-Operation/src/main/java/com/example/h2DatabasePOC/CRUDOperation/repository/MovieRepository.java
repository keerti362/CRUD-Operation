package com.example.h2DatabasePOC.CRUDOperation.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.h2DatabasePOC.CRUDOperation.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

	@Query(nativeQuery = true, value = "SELECT * FROM TBL_MOVIE WHERE user_name LIKE 'Keerti%' order by user_name")
	public List<Movie> findByUser_Name(String user_name);

	@Query(nativeQuery = true, value = "SELECT * FROM TBL_MOVIE WHERE movie_name=:movie_name")
	public Optional<Movie> getMovieByName(@Param("movie_name") String movie_name);

}
