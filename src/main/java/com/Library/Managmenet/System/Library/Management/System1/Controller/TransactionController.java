package com.Library.Managmenet.System.Library.Management.System1.Controller;

import com.Library.Managmenet.System.Library.Management.System1.DTO.IssueBookRequestDto;
import com.Library.Managmenet.System.Library.Management.System1.DTO.IssueBookResponseDto;
import com.Library.Managmenet.System.Library.Management.System1.Repository.TransactionRepository;
import com.Library.Managmenet.System.Library.Management.System1.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {


    @Autowired
    TransactionService transactionService;
    @PostMapping("/issue")
    public ResponseEntity issueBook(@RequestBody IssueBookRequestDto issueBookRequestDto){
        IssueBookResponseDto issueBookResponseDto;
        try {
            issueBookResponseDto=transactionService.issueBook(issueBookRequestDto);

        }
        catch (Exception e){
           return new ResponseEntity(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity(issueBookResponseDto,HttpStatus.ACCEPTED);
    }
}
