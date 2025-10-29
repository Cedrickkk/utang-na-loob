package com.utangnaloob.utangnaloob.services;

import com.utangnaloob.utangnaloob.dtos.DebtorRequestDTO;
import com.utangnaloob.utangnaloob.dtos.DebtorResponseDTO;
import com.utangnaloob.utangnaloob.exceptions.DebtorNotFoundException;
import com.utangnaloob.utangnaloob.mappers.DebtorMapper;
import com.utangnaloob.utangnaloob.models.Debtor;
import com.utangnaloob.utangnaloob.repositories.DebtorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DebtorService {
    private final DebtorRepository debtorRepository;

    @Autowired
    public DebtorService(DebtorRepository debtorRepository) {
        this.debtorRepository = debtorRepository;
    }

    public List<DebtorResponseDTO> getAllDebtors() {
        return debtorRepository.findAll()
                .stream()
                .map(DebtorMapper::toResponseDto)
                .toList();
    }

    public DebtorResponseDTO createDebtor(DebtorRequestDTO requestDTO) {
        Debtor debtor = debtorRepository.saveAndFlush(DebtorMapper.fromRequestDto(requestDTO));
        return DebtorMapper.toResponseDto(debtor);
    }

    public DebtorResponseDTO getDebtorById(Long id) {
        Debtor debtor = debtorRepository.findById(id)
                .orElseThrow(() -> new DebtorNotFoundException("Debtor not found."));

        return DebtorMapper.toResponseDto(debtor);
    }

    public DebtorResponseDTO updateDebtorById(Long id, DebtorRequestDTO requestDTO) {
        Debtor debtor = debtorRepository.findById(id)
                .orElseThrow(() -> new DebtorNotFoundException("Debtor not found."));

        debtor.setName(requestDTO.getName());
        debtor.setEmail(requestDTO.getEmail());
        debtor.setContactNumber(requestDTO.getContactNumber());
        debtor.setAddress(requestDTO.getAddress());

        Debtor updatedDebtor = debtorRepository.save(debtor);

        return DebtorMapper.toResponseDto(updatedDebtor);
    }

    public void deleteDebtorById(Long id) {
        Debtor debtor = debtorRepository.findById(id)
                .orElseThrow(() -> new DebtorNotFoundException("Debtor not found."));
        debtorRepository.delete(debtor);
    }
}
