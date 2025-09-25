package com.mamabologtub.library_system.services;

import java.util.List;

import com.mamabologtub.library_system.dtos.BookRequestDto;
import com.mamabologtub.library_system.entities.BookRequest;

/**
 * @Author Tshepo M Mahudu on Jul 16, 2025.
 */

public interface BookRequestService {

    public BookRequest creatBookRequest(BookRequestDto dto);
    public List<BookRequest> getRequests();

}
