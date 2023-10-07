package com.modsen.book.mapper;

import com.modsen.book.dto.BookCreate;
import com.modsen.book.dto.BookResponse;
import com.modsen.book.dto.BookUpdate;
import com.modsen.book.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL
)
public interface BookMapper {

    BookResponse bookToResponse(Book book);

    @Mapping(target = "id", ignore = true)
    Book createToBook(BookCreate request);

    void updateBookFromDto(BookUpdate request, @MappingTarget Book book);
}
