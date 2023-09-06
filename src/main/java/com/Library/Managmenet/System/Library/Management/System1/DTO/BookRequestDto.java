package com.Library.Managmenet.System.Library.Management.System1.DTO;

import com.Library.Managmenet.System.Library.Management.System1.Enum.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookRequestDto {

    String book_name;
    int price;
    int authorId;

    Genre genre;
}
