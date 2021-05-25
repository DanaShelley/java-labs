package edu.hav.labs.service.membership.impls;

import edu.hav.labs.model.Membership;
import edu.hav.labs.repository.bookHeldByMembership.BookHeldByMembershipRepository;
import edu.hav.labs.repository.bookLog.BookLogRepository;
import edu.hav.labs.repository.membership.MembershipRepository;
import edu.hav.labs.service.membership.interfaces.IMembershipService;
import org.bson.Document;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  MembershipServiceImpl
  @version  1.0.0 
  @since 20.04.2021
*/

@Service
@Component
public class MembershipServiceImpl implements IMembershipService {

    final
    MembershipRepository repository;

    final BookLogRepository bookLogRepository;

    final BookHeldByMembershipRepository bookHeldByMembershipRepository;

    public MembershipServiceImpl(MembershipRepository repository,
                                 BookLogRepository bookLogRepository,
                                 BookHeldByMembershipRepository bookHeldByMembershipRepository) {
        this.repository = repository;
        this.bookLogRepository = bookLogRepository;
        this.bookHeldByMembershipRepository = bookHeldByMembershipRepository;
    }

    @Override
    public Membership getById(String id) {
        return repository.findById(id)
                         .orElse(null);
    }

    @Override
    public Membership create(Membership membership) {
        return repository.save(membership);
    }

    @Override
    public Membership update(Membership membership) {
        return repository.save(membership);
    }

    @Override
    public Membership delete(String id) {
        repository.deleteById(id);
        return null;

    }

    @Override
    public List<Membership> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Membership> getMembershipsWhoOverdueDeadLine() {
        List<Membership> list = new ArrayList<>();
        bookHeldByMembershipRepository.findAllByDeliveryDateAfter(LocalDate.now())
                                      .forEach(bookHeldByMembership -> list.add(bookHeldByMembership.getMembership()));
        return list;
    }

    public List<Document> getMembershipsServiceByStaff(String staffId, LocalDate date1, LocalDate date2) {
        List<Document> list = new ArrayList<>();
        bookLogRepository.findAllByStaff_IdAndDateBetweenOrDateEqualsOrDateEquals(staffId, date1, date2, date1, date2)
                         .forEach(bookLog -> list.add(new Document().append("membership", bookLog.getMembership())
                                                                    .append("date", bookLog.getDate())));
        return list;
    }
}
