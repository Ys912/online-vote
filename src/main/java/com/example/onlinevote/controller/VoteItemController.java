package com.example.onlinevote.controller;

import com.example.onlinevote.model.VoteItem;
import com.example.onlinevote.service.VoteItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vote-items")
public class VoteItemController {

    @Autowired
    private VoteItemService voteItemService;

    // 1. 取得所有投票項目
    @GetMapping
    public List<VoteItem> getAllVoteItems() {
        return voteItemService.getAllItems();
    }

    // 2. 新增投票項目 (呼叫 Stored Procedure)
    @PostMapping
    public void createVoteItem(@RequestBody VoteItem item) {
        voteItemService.createItem(item.getName());
    }

    // 3. 更新投票項目名稱 (呼叫 Stored Procedure)
    @PutMapping("/{id}")
    public void updateVoteItem(@PathVariable Long id, @RequestBody VoteItem item) {
        voteItemService.updateItem(id, item.getName());
    }

    // 4. 投票 (增加票數)
    @PostMapping("/{id}/vote")
    public VoteItem vote(@PathVariable Long id) {
        return voteItemService.vote(id);
    }
}

