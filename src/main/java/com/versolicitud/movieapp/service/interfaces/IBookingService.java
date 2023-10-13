package com.versolicitud.movieapp.service.interfaces;

import java.util.List;
import java.util.UUID;

import com.versolicitud.movieapp.dto.BookingDTO;
import com.versolicitud.movieapp.entity.Booking;

public interface IBookingService {
    List<BookingDTO> getAll();

    BookingDTO getById(UUID id);

    BookingDTO save(BookingDTO booking);

    void delete(UUID id);
}
