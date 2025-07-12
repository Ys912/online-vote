package com.example.onlinevote.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.onlinevote.model.VoteItem;

@Repository
public interface VoteItemRepository extends JpaRepository<VoteItem, Long> {

    // 呼叫 sp_create_vote_item Stored Procedure
    @Procedure(procedureName = "sp_create_vote_item")
    void spCreateVoteItem(@Param("item_name") String name);

    // 呼叫 sp_update_vote_item Stored Procedure
    @Procedure(procedureName = "sp_update_vote_item")
    void spUpdateVoteItem(@Param("item_id") Long id, @Param("new_name") String newName);
}

