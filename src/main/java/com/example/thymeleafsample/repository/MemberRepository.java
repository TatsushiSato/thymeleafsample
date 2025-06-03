package com.example.thymeleafsample.repository;

import com.example.thymeleafsample.entity.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends CrudRepository<Member, Integer> {

    List<Member> findByArtistId(Integer artistId);
}
