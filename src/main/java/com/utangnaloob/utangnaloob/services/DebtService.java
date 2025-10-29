package com.utangnaloob.utangnaloob.services;

import com.utangnaloob.utangnaloob.dtos.DebtItemRequestDTO;
import com.utangnaloob.utangnaloob.dtos.DebtRequestDTO;
import com.utangnaloob.utangnaloob.dtos.DebtResponseDTO;
import com.utangnaloob.utangnaloob.exceptions.DebtNotFoundException;
import com.utangnaloob.utangnaloob.exceptions.DebtorNotFoundException;
import com.utangnaloob.utangnaloob.exceptions.ItemNotFoundException;
import com.utangnaloob.utangnaloob.mappers.DebtMapper;
import com.utangnaloob.utangnaloob.models.Debt;
import com.utangnaloob.utangnaloob.models.DebtItem;
import com.utangnaloob.utangnaloob.models.Debtor;
import com.utangnaloob.utangnaloob.models.Item;
import com.utangnaloob.utangnaloob.repositories.DebtRepository;
import com.utangnaloob.utangnaloob.repositories.DebtorRepository;
import com.utangnaloob.utangnaloob.repositories.ItemRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class DebtService {
    private final DebtRepository debtRepository;
    private final DebtorRepository debtorRepository;
    private final ItemRepository itemRepository;
    private final EntityManager entityManager;

    @Autowired
    public DebtService(
            DebtRepository debtRepository, DebtorRepository debtorRepository,
            ItemRepository itemRepository, EntityManager entityManager) {
        this.debtRepository = debtRepository;
        this.debtorRepository = debtorRepository;
        this.itemRepository = itemRepository;
        this.entityManager = entityManager;
    }

    public List<DebtResponseDTO> getAllDebts() {
        return debtRepository.findAll().stream()
                .map(DebtMapper::toResponseDto)
                .toList();
    }

    public DebtResponseDTO createDebt(DebtRequestDTO requestDTO) {
        Long debtorId = requestDTO.getDebtorId();
        Debtor debtor = debtorRepository.findById(debtorId)
                .orElseThrow(() -> new DebtorNotFoundException("Debtor not found."));

        Debt debt = new Debt();
        debt.setDebtor(debtor);

        Set<DebtItem> debtItems = mapDebtItems(requestDTO.getDebtItems(), debt);
        debt.setDebtItems(debtItems);

        Debt createdDebt = debtRepository.saveAndFlush(debt);
        entityManager.refresh(createdDebt);

        return DebtMapper.toResponseDto(createdDebt);
    }

    public DebtResponseDTO getDebtById(Long id) {
        Debt debt = debtRepository.findById(id)
                .orElseThrow(() -> new DebtNotFoundException("Debt not found."));

        return DebtMapper.toResponseDto(debt);
    }

    private Set<DebtItem> mapDebtItems(Set<DebtItemRequestDTO> debtItems, Debt debt) {
        return debtItems.stream()
                .map(itemDto -> {
                    Item item = itemRepository.findById(itemDto.getItemId())
                            .orElseThrow(() -> new ItemNotFoundException("Item not found."));

                    DebtItem debtItem = new DebtItem();
                    debtItem.setQuantity(itemDto.getQuantity());
                    debtItem.setUnitPrice(item.getPrice());
                    debtItem.setItem(item);
                    debtItem.setDebt(debt);

                    return debtItem;
                })
                .collect(Collectors.toSet());
    }
}
