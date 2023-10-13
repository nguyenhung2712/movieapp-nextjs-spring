package com.versolicitud.movieapp.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import com.versolicitud.movieapp.dto.BookingDTO;
import com.versolicitud.movieapp.dto.UserDTO;
import com.versolicitud.movieapp.mapper.BookingMapper;
import com.versolicitud.movieapp.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.versolicitud.movieapp.entity.Booking;
import com.versolicitud.movieapp.entity.User;
import com.versolicitud.movieapp.repository.BookingRepo;
import com.versolicitud.movieapp.service.interfaces.IBookingService;

@Service
public class BookingService implements IBookingService {

    @Autowired
    private BookingRepo bookingRepo;

    @Autowired
    private UserService userService;

    @Override
    public List<BookingDTO> getAll() {
        return bookingRepo.findAll().stream()
                .map(BookingMapper.MAPPER::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BookingDTO getById(UUID id) {
        Optional<Booking> optional = bookingRepo.findById(id);
        try {
            Booking booking = optional.orElseThrow(() -> new NoSuchElementException("Booking not found"));
            return BookingMapper.MAPPER.mapToDTO(booking);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public BookingDTO save(BookingDTO booking) {
        UserDTO user = userService.getById(booking.getUser().getId());
        booking.setUser(user);
        Booking savedBooking = BookingMapper.MAPPER.mapToEntity(booking);
        return BookingMapper.MAPPER.mapToDTO(bookingRepo.save(savedBooking));
    }

    @Override
    public void delete(UUID id) {
        bookingRepo.deleteById(id);
    }

}
