package com.example.onlinevote.service;

import com.example.onlinevote.model.VoteItem;
import com.example.onlinevote.repository.VoteItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteItemService {

    @Autowired
    private VoteItemRepository voteItemRepository;

    // 取得所有投票項目
    public List<VoteItem> getAllItems() {
        return voteItemRepository.findAll();
    }

    // 使用呼叫 Stored Procedure 的方式新增投票項目
    public void createItem(String name) {
        voteItemRepository.spCreateVoteItem(name);
    }

    // 使用呼叫 Stored Procedure 的方式更新投票項目名稱
    public void updateItem(Long id, String newName) {
        voteItemRepository.spUpdateVoteItem(id, newName);
    }

    // 投票功能 (加票數)
    public VoteItem vote(Long id) {
        VoteItem item = voteItemRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Item not found"));
        item.setCount(item.getCount() + 1);
        return voteItemRepository.save(item);
    }
}

