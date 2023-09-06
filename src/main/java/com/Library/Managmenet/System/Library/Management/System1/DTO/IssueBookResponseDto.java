package com.Library.Managmenet.System.Library.Management.System1.DTO;

import com.Library.Managmenet.System.Library.Management.System1.Enum.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class IssueBookResponseDto {
    String transactionId;
    String book_name;

    TransactionStatus transactionStatus;
}
