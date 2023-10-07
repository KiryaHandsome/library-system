package com.modsen.book.mapper;

import com.modsen.book.dto.BookCreate;
import com.modsen.book.dto.BookResponse;
import com.modsen.book.dto.BookUpdate;
import com.modsen.book.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface BookMapper {

    BookResponse bookToResponse(Book book);

    Book createToBook(BookCreate request);

    void updateBookFromDto(BookUpdate request, @MappingTarget Book book);
}
