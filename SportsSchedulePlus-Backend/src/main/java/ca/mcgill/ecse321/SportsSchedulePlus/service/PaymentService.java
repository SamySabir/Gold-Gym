package ca.mcgill.ecse321.SportsSchedulePlus.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import ca.mcgill.ecse321.SportsSchedulePlus.repository.PaymentRepository;
import ca.mcgill.ecse321.SportsSchedulePlus.repository.CustomerRepository;
import ca.mcgill.ecse321.SportsSchedulePlus.repository.ScheduledCourseRepository;
import ca.mcgill.ecse321.SportsSchedulePlus.model.Payment;
import ca.mcgill.ecse321.SportsSchedulePlus.exception.SportsSchedulePlusException;
import ca.mcgill.ecse321.SportsSchedulePlus.model.Customer;
import ca.mcgill.ecse321.SportsSchedulePlus.model.ScheduledCourse;
import ca.mcgill.ecse321.SportsSchedulePlus.model.Payment.Key;
import ca.mcgill.ecse321.utils.Helper;

/**
 * Service class for managing data related to Payments
 * @author Vladimir Venkov
 */
@Service
public class PaymentService {
    
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ScheduledCourseRepository ScheduledCourseRepository;

    @Transactional
    public List<Payment> getAllPayments() {
        return Helper.toList(paymentRepository.findAll());
    }

    @Transactional
    public Payment getPaymentByConfirmationNumber(int confirmationNumber) {
        return paymentRepository.findPaymentByConfirmationNumber(confirmationNumber);
    }

    @Transactional
    public List<Payment> getPaymentsByCustomer(int customerId) {
        Optional<Customer> c = customerRepository.findById(customerId);
        if (!c.isPresent()) {
            throw new SportsSchedulePlusException(HttpStatus.NOT_FOUND, "There is no customer with ID " + customerId + ".");
        }
        return paymentRepository.findPaymentsByKeyCustomer(c.get());
    }

    @Transactional
    public List<Payment> getPaymentsByCourse(int courseId) {
        Optional<ScheduledCourse> sc = ScheduledCourseRepository.findById(courseId);
        if (!sc.isPresent()) {
            throw new SportsSchedulePlusException(HttpStatus.NOT_FOUND, "There is no scheduled course with ID " + courseId + ".");
        }
        return paymentRepository.findPaymentsByKeyScheduledCourse(sc.get());
    }

    @Transactional
    public Payment createPayment(int customerId, int courseId) {
        Optional<Customer> c = customerRepository.findById(customerId);
        if (!c.isPresent()) {
            throw new SportsSchedulePlusException(HttpStatus.NOT_FOUND, "There is no customer with ID " + customerId + ".");
        }
        Optional<ScheduledCourse> sc = ScheduledCourseRepository.findById(courseId);
        if (!sc.isPresent()) {
            throw new SportsSchedulePlusException(HttpStatus.NOT_FOUND, "There is no scheduled course with ID " + courseId + ".");
        }
        List<Payment> previousPayments = getPaymentsByCustomer(customerId);
        if (previousPayments != null) {
            for (Payment p : previousPayments) {
                if (p.getKey().getScheduledCourse().equals(sc.get())) {
                    throw new SportsSchedulePlusException(HttpStatus.BAD_REQUEST, "The customer with ID " + customerId + " has already paid for the course with ID " + courseId + ".");
                }
            }
        }
        Key key = new Key(c.get(), sc.get());
        Payment p = new Payment(key);
        return p;
    }
}
