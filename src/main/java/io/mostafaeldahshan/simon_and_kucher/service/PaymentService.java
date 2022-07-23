package io.mostafaeldahshan.simon_and_kucher.service;

import io.mostafaeldahshan.simon_and_kucher.model.Customer;
import io.mostafaeldahshan.simon_and_kucher.model.Payment;
import io.mostafaeldahshan.simon_and_kucher.dto.PaymentDTO;
import io.mostafaeldahshan.simon_and_kucher.repos.CustomerRepository;
import io.mostafaeldahshan.simon_and_kucher.repos.PaymentRepository;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final CustomerRepository customerRepository;

    public PaymentService(final PaymentRepository paymentRepository,
            final CustomerRepository customerRepository) {
        this.paymentRepository = paymentRepository;
        this.customerRepository = customerRepository;
    }

    public List<PaymentDTO> findAll() {
        return paymentRepository.findAll(Sort.by("id"))
                .stream()
                .map(payment -> mapToDTO(payment, new PaymentDTO()))
                .collect(Collectors.toList());
    }

    public PaymentDTO get(final UUID id) {
        return paymentRepository.findById(id)
                .map(payment -> mapToDTO(payment, new PaymentDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Long create(final PaymentDTO paymentDTO) {
        final Payment payment = new Payment();
        mapToEntity(paymentDTO, payment);
        return paymentRepository.save(payment).getId();
    }

    public void update(final UUID id, final PaymentDTO paymentDTO) {
        final Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mapToEntity(paymentDTO, payment);
        paymentRepository.save(payment);
    }

    public void delete(final UUID id) {
        paymentRepository.deleteById(id);
    }

    private PaymentDTO mapToDTO(final Payment payment, final PaymentDTO paymentDTO) {
        paymentDTO.setId(payment.getId());
        paymentDTO.setAmount(payment.getAmount());
        paymentDTO.setPaymentDate(payment.getPaymentDate());
        paymentDTO.setPaymentStatus(payment.getPaymentStatus());
        paymentDTO.setTransactionId(payment.getTransactionId());
        paymentDTO.setCustomerOrderId(payment.getCustomerOrderId());
        paymentDTO.setCustomerId(payment.getCustomerId());
        paymentDTO.setPaymentCustomer(payment.getPaymentCustomer() == null ? null : payment.getPaymentCustomer().getId());
        return paymentDTO;
    }

    private Payment mapToEntity(final PaymentDTO paymentDTO, final Payment payment) {
        payment.setAmount(paymentDTO.getAmount());
        payment.setPaymentDate(paymentDTO.getPaymentDate());
        payment.setPaymentStatus(paymentDTO.getPaymentStatus());
        payment.setTransactionId(paymentDTO.getTransactionId());
        payment.setCustomerOrderId(paymentDTO.getCustomerOrderId());
        payment.setCustomerId(paymentDTO.getCustomerId());
        final Customer paymentCustomer = paymentDTO.getPaymentCustomer() == null ? null : customerRepository.findById(paymentDTO.getPaymentCustomer())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "paymentCustomer not found"));
        payment.setPaymentCustomer(paymentCustomer);
        return payment;
    }

}
