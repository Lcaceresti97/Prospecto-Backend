package com.sti.project.service;

import com.sti.project.dto.ProspectoDto;
import com.sti.project.exception.ProspectoNotFoundException;
import org.springframework.data.domain.Page;

import java.util.ArrayList;

/**
 * Service interface for Prospecto entity crud operations.
 * @author Laurent G. Cáceres (caceresbjm97@gmail.com)
 * @version 1.0.0
 */
public interface ProspectoService {

    /**
     * Saves given prospecto into DB.
     * @param prospectoDto Prospecto
     */
    ProspectoDto saveProspecto(ProspectoDto prospectoDto);

    /**
     * Find a prospecto by its ID.
     * @param prospectoId String
     * @return Student ProspectoDTO
     * @throws ProspectoNotFoundException when no Student is found by ID
     */
    ProspectoDto findProspectoById(final String prospectoId) throws ProspectoNotFoundException;

    /**
     * Find a prospecto by its name.
     * @param prospectoName String
     * @return Student ProspectoDTO
     * @throws ProspectoNotFoundException when no Student is found by name
     */
    ProspectoDto findProspectoByName(final String prospectoName) throws ProspectoNotFoundException;


    /**
     * Delete prospecto by its ID.
     * @param prospectoId
     */
    void deleteProspectoById(final String prospectoId);

    /**
     * Return a page of sorted students.
     * @param prospectoname Student names to sort by.
     * @param page Page number to query by.
     * @param size Page size to query by.
     * @param sort Extra sort params to sort by.
     * @return PageResponseDto Student.
     */
    Page<ProspectoDto> findPaginatedSortedProspects(String prospectoname, int page, int size, String[] sort);


    ArrayList<ProspectoDto> getAllProspectos(int pageNo, int pageSize, String sortBy);
}
